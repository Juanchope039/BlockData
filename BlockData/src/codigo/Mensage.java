package codigo;

import RSA.RSA;
import java.util.Scanner;
/**
 *
 * @author Juanchope
 */
public class Mensage extends RSA{
    
    private String FirmaDigital, mensage;
        
    public boolean ComprobarMensage(){
        //if (MensageCifrado.length() != 344)
        //    return false;
        System.out.println(MensageCifrado);
        System.out.println(gethashMensage());
        System.out.println(getFirmaDigitalDecifrada());
        System.out.println(gethashMensage().equals(getFirmaDigitalDecifrada()));
        return true;
    }
    
    public static void main(String[] args) {
        Scanner Lector = new Scanner(System.in);
        //while (Lector.hasNext()) {
            Mensage msg = new Mensage();
            msg.setLlavepublicaReceptor("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAieokV9uraadtG0/iSGVXGgyTbqh3wWoh91JfQbxeijNUHsmgv7uxWTL017Szm8qFXT12loagsX52AVQDl7vWO0WCZtKQSe7ZHN17FpYSdKOR6LHRQC20MmcdeXzAViXJ3u7xP9dd0vtm6n5kSVvHIvNQ0RfPCkyqiLKVnB9OYOSU+Kw+f11/jE6BoWA/t7C5MRlJKvqatbS3zRnGDanteR8iMYM8XmPe8P79/2RKPkh5EGI7RENJe6fu1epTTWrzNKlA4uuZw87WUfBmh4u0JNvIGQXquWRImkURHuPDakynoQIqLrdLRgBXp9Uln+WD3Ay4WdulY17obVvicd1O6wIDAQAB");
            msg.setLlavePublicaEmisor("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnqY6TggR6buvHyOed/7ohpFyQ0t0ZfKO9NXv3Yv/wTcM7jdVAtqa/SKd8vl1kK+YjVcOO/o/eid1qrWEUDJMZ0B7Z0Bm129otzYV0q9jXz4hUEdjzFyQSQW6BSJBBla7rhVAU2M9TKuTX0jH3QIucFGwRWpX/Lga3Px7ZXqDFgUbNWWUnewELhFHQPi/7CXEL2JyVym0wophHSbzPjKi2yJTMZgC3P0VoCWfmj6cX97jrIrxn1yPZMf5NDsrkHI8YOgaunuyZ/T6mvGdoHsPuNX1q+vEBr89jgHQ5HUsfxUqziF/fjgt8M1k6ROnsT9RvvcqGiNIhvJkK6AfnqZ+4wIDAQAB");
            //msg.setMensage(Lector.next());
            //System.out.println(msg.ToString());
            //System.out.println(msg.gethashMensage());
        //}
    }
       
    public Mensage(String llavePublicaEmisor, String llaveprivadaEmisor, String llavePublicaReceptor, String Mensage) {
        super(2048, 256);
        CargarLlaves(llavePublicaEmisor, llaveprivadaEmisor);
        setLlavepublicaReceptor(llavePublicaReceptor);
        mensage = Mensage;
    }
    
    public Mensage(String pub, String prv, String pubR, String msg, String FirmaDigital){
        super(2048, 256);
        CargarLlaves(pub, prv);//crear un metodo para introducir llaves por variable"publickey.pubc","privatekey.prv"
        setLlavepublicaReceptor(pubR);
        if (hashSHA(msg).equals(decifrarfirma(this.FirmaDigital))){
            MensageCifrado = msg;
            this.FirmaDigital = FirmaDigital;
        }
    }
    
    public Mensage() {
        super(2048, 256);
        generarLlaves();
    }
    
    public String CifrarMensage(){
        String respuesta = "";
        if (null == (respuesta = MensageCifrado))
            respuesta = cifrarTexto(mensage);
        return respuesta;        
    }
    
    public String DecifrarMensage(){
        String respuesta;
        if (null == MensageCifrado)
            respuesta = decifrarTexto(mensage);
        else
            respuesta = decifrarTexto(MensageCifrado);
        return respuesta;           
    }
    
    private String FirmarMensage(){
        if(MensageCifrado == null)
            return null;
        String respuesta = "";
        try {
            respuesta = cifrarfirma(hashSHA(mensage));                       
            //System.out.println("Mensage firmado correctamente.");
        } catch (Exception ex) {
            System.out.println("firmado de mensage falló.\n" + ex);
        }
        return respuesta;
    }
    
    public Boolean AutenticarFirma(String Firma){
        Boolean respuesta = false;
        try {
            respuesta = (decifrarfirma(Firma).equals(hashSHA(MensageCifrado)));                       
            //System.out.println("Mensage Autenticado correctamente.");
        } catch (Exception ex) {
            System.out.println("Autenticación de mensage falló.\n" + ex);
        }
        return respuesta;
    }

    public String getFirmaDigital() {
        System.out.println(FirmaDigital);
        System.out.println(FirmaDigital.isEmpty() );
        if (FirmaDigital.isEmpty())
            FirmaDigital = FirmarMensage();
        System.out.println("Firma digita = " + FirmaDigital);
        return FirmaDigital;
    }
    
    public String getFirmaDigitalDecifrada(){
        String salida = getFirmaDigital();
        salida = decifrarfirma(salida);
        return salida;
    }

    public void setMensage(String Mensage) {
        this.mensage = Mensage;
    }
    
    public void setLlavePublicaEmisor(String llavePublicaEmissor){
        super.CargarLLavePublicaEmissor(llavePublicaEmissor);
    }
    
    public void setLlavesEmisor(String pub, String prv){
        this.CargarLlaves(pub, prv);
    }

    @Override
    public String toString() {
        String resultado = "Emissor: " + getLlavePublica() +
                "\nReceptor: " + getLlavepublicaReceptor() +
                "\nMensage: " + (MensageCifrado != null ? CifrarMensage() : MensageCifrado ) +
                "\nFirmaDigital: " + FirmarMensage();
        return resultado;
    }
    
    public String hash() {
        String salida, hash = null, msg;
        try {
            System.out.println(getFirmaDigitalDecifrada());
            System.out.println(gethashMensage());
            if (!getFirmaDigitalDecifrada().equals(gethashMensage())){
                System.out.println("¡mensage Corrupto!");
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.getCause().toString());
        }
        salida = getLlavePublica() + getLlavepublicaReceptor() + 
                (MensageCifrado == null ? CifrarMensage() : MensageCifrado) + 
                (FirmaDigital == null?FirmarMensage() : FirmaDigital);
        try {
            hash = hashSHA(salida);
        } catch (Exception ex) {
            System.out.println("hash no finalizado.");
        }       
        return hash;
    }
    
    public String gethashMensage(){
        try {
            return  hashSHA("".equals(CifrarMensage()) ? MensageCifrado : CifrarMensage());
        } catch (Exception ex) {
            System.out.println("eror M <138>");
        }
        return null;
    }
    
    public void setFirmaDigital(String fd){
        FirmaDigital = fd;
    }    
    
    public String getMensage(){
        return mensage;
    }

    @Override
    public void setMensageCifrado(String MensageCifrado) {
        System.out.println(hashSHA(MensageCifrado));
        System.out.println(decifrarfirma(FirmaDigital));
        if (hashSHA(MensageCifrado).equals(decifrarfirma(FirmaDigital)))
            super.setMensageCifrado(MensageCifrado);
    }
}
