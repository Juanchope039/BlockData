package codigo;

import RSA.RSA;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;
/**
 *
 * @author Juanchope
 */
public final class Mensage{
    
    final private String FirmaDigital, mensage, mensageCifrado;
    private PublicKey   llavePublicaE, llavePublicaR;
    private PrivateKey  llavePrivadaE, llavePrivadaR;
    final private RSA rsa = new RSA(2048, 256);
    
    
    public Mensage(String pubE, String prvE, String pubR, String msg) {
        CargarLlavesE(pubE, prvE);
        CargarLlavepubR(pubR);
        mensage = msg;
        mensageCifrado = CifrarMensage();
        FirmaDigital = FirmarMensage();
    }
    
    public Mensage(String pubE, String pubR, String prvR, String msg, String FirmaDigital){
        CargarLlavepubE(pubE);
        CargarLlavesR(pubR,prvR);
        this.FirmaDigital = FirmaDigital;
        mensageCifrado = msg;
        mensage = DecifrarMensage();
        if (!rsa.hashSHA(msg).equals(rsa.Decifrar(this.FirmaDigital, llavePublicaE))){
            System.out.println("Mensage Corrupto.");
        }
    }
    
    public boolean ComprobarMensage(){
        //if (MensageCifrado.length() != 344)
        //    return false;
        System.out.println(mensageCifrado);
        System.out.println(mensage);
        System.out.println(FirmaDigital);
        System.out.println(gethashMensage());
        System.out.println(getFirmaDigitalDecifrada());
        System.out.println(gethashMensage().equals(getFirmaDigitalDecifrada()));
        return true;
    }
    
    public static void main(String[] args) {
        Scanner Lector = new Scanner(System.in);
        //while (Lector.hasNext()) {
            String pubR = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAieokV9uraadtG0/iSGVXGgyTbqh3wWoh91JfQbxeijNUHsmgv7uxWTL017Szm8qFXT12loagsX52AVQDl7vWO0WCZtKQSe7ZHN17FpYSdKOR6LHRQC20MmcdeXzAViXJ3u7xP9dd0vtm6n5kSVvHIvNQ0RfPCkyqiLKVnB9OYOSU+Kw+f11/jE6BoWA/t7C5MRlJKvqatbS3zRnGDanteR8iMYM8XmPe8P79/2RKPkh5EGI7RENJe6fu1epTTWrzNKlA4uuZw87WUfBmh4u0JNvIGQXquWRImkURHuPDakynoQIqLrdLRgBXp9Uln+WD3Ay4WdulY17obVvicd1O6wIDAQAB",
                pubE = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnqY6TggR6buvHyOed/7ohpFyQ0t0ZfKO9NXv3Yv/wTcM7jdVAtqa/SKd8vl1kK+YjVcOO/o/eid1qrWEUDJMZ0B7Z0Bm129otzYV0q9jXz4hUEdjzFyQSQW6BSJBBla7rhVAU2M9TKuTX0jH3QIucFGwRWpX/Lga3Px7ZXqDFgUbNWWUnewELhFHQPi/7CXEL2JyVym0wophHSbzPjKi2yJTMZgC3P0VoCWfmj6cX97jrIrxn1yPZMf5NDsrkHI8YOgaunuyZ/T6mvGdoHsPuNX1q+vEBr89jgHQ5HUsfxUqziF/fjgt8M1k6ROnsT9RvvcqGiNIhvJkK6AfnqZ+4wIDAQAB",
                prvE = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCepjpOCBHpu68fI553/uiGkXJDS3Rl8o701e/di//BNwzuN1UC2pr9Ip3y+XWQr5iNVw47+j96J3WqtYRQMkxnQHtnQGbXb2i3NhXSr2NfPiFQR2PMXJBJBboFIkEGVruuFUBTYz1Mq5NfSMfdAi5wUbBFalf8uBrc/HtleoMWBRs1ZZSd7AQuEUdA+L/sJcQvYnJXKbTCimEdJvM+MqLbIlMxmALc/RWgJZ+aPpxf3uOsivGfXI9kx/k0OyuQcjxg6Bq6e7Jn9Pqa8Z2gew+41fWr68QGvz2OAdDkdSx/FSrOIX9+OC3wzWTpE6exP1G+9yoaI0iG8mQroB+epn7jAgMBAAECggEAQ0BJtOw806zItlV+BnXbEbg0DIy+wbyJlwXdUTfYaYoxhAWWlsgeLTHwbKAMkxGshDWkBg61u81gVsXtWaWIt7gg14r4TVifthJKO+43HJeUvZgVmPqf+yRfT2/OyqYXltrRUsfdo1OT/C848dnL37bxFuvWcn2EfarVkBXX3YwME5XWPpM1QWtGCtsnAZ+GjheeAjH8Ug5jUb2vSjzDrIoUCZVzWz8S6l+u6W1SIsih5Q4Yr5JovwiixWqlGi9huOBtXEAVlVKSAU+Pzp77QuRyVUTsGM4NT89XvPPClwvbOJITjLLU0RTfdPDTDm7956ev+bsb1SoTUGUHoN7YIQKBgQD3tUFm9Wikf6upVdqTpOB6MkU7U4Y1rKhpr4FQBRSzHlpk7eDTZ/3zfJ9kF09+339QKRzyMNP8T94Q3QZI8cieBJLM0G4wJk93F6GExlH8Q2ak5WRbIf1epjcK4vg7kCb7sav4jcvQHV6GLSUodV23UdoXyITiGQIfeNGGSuhLUQKBgQCj9cepebmMxfkbV3cZKzAX0SONyKKwoj9IXKLfcYMGa/o/hl8zpxELsj+3mUTWKJNbnlZdJpK+sR8nO2kXnc0WdNyrZLx7w+9eTdxuIB9FvI7waIsjbxcpvb0CsVBFeQ7gSrvV/wHM4DeQ+JTrLzgxXF+wkB9zNUIje8gQudSx8wKBgEhrHWvUY3t0N+ORzg1MLrSK7eKiUKJwj+wV+2BBnAOh5BuN0CT+SihdTtwcVIlrHfV5j5Te4ZrqXqnfdG7vAQ/xlll6tjwtdx4CMp52vJFbwy6CQgzCqyh4v67XHGuNgVgkYXqROfzmGTRxDmP9rCBkNbauUOspFI3O7LKuQ6uBAoGAaud3LrZSWEpA+SXXXs69Bdp0Lx8RjM/NKTZVcBFIGCjROxg2/KvCvniTePdzXZuJMSSVNRlQdwtvv5nKFP7r2OeLdikxiBUh/sAPqLJDEao3HONdTVZCqRGwqo/IQfQD0hSIUqh5mQbc1CZwmsPoBK8xKSNfjjO8kvxDXzx7RScCgYBMfO/vTVDoZTD773ukq5/or5cWT2xVdAVTDNT24pEFJ0Ze/dD0EDfssWM81sHGxD2mNLQRanbhh8X5y2cS6jOWH0/PccRhMEetKwi81celaVintaqMy23+oPoUcUEZKITxrCfBucMtVBJNoO2/zUvUvBCUkihkvYPzHlqo3Hlz6w==",
                mensage = Lector.next();
            Mensage msg = new Mensage(pubE, prvE, pubR, mensage);
            //msg.setLlavepublicaReceptor("");
            //msg.setLlavePublicaEmisor("");
            //msg.setMensage();
            //System.out.println(msg.ToString());
            System.out.println(msg.gethashMensage());
        //}
    }
    
    private String CifrarMensage(){
        return rsa.Cifrar(mensage,llavePublicaR);     
    }
    
    private String DecifrarMensage(){
        return rsa.Decifrar(mensage,llavePrivadaR);      
    }
    
    private String FirmarMensage(){
        return rsa.firmaDigital(mensageCifrado, llavePrivadaE);
    }
    
    private String DecifrarFirma(){
        return rsa.decifrarfirmaDigital(FirmaDigital, llavePublicaE);
    }
    
    public Boolean AutenticarFirma(String Firma){
        return getFirmaDigitalDecifrada().equals(gethashMensage());
    }

    public String getFirmaDigital() {
        return FirmaDigital;
    }
    
    public String getFirmaDigitalDecifrada(){
        return DecifrarFirma();
    }
    
    @Override
    public String toString() {
        String resultado = "Emissor: " + getLlavePublicaEmissor() +
                "\nReceptor: " + getLlavepublicaReceptor() +
                "\nMensage: " + mensageCifrado +
                "\nFirmaDigital: " + FirmaDigital;
        return resultado;
    }
    
    public String hash() {
        String salida;
        if (getFirmaDigitalDecifrada().equals(gethashMensage())){
            //System.out.println(getFirmaDigitalDecifrada());
            //System.out.println(gethashMensage());
            salida = getLlavePublicaEmissor() + getLlavepublicaReceptor() + 
            mensageCifrado + FirmaDigital;
            return rsa.hashSHA(salida);
        }
        System.out.println("¡mensage Corrupto!");
        return null;
    }
    
    public String gethashMensage(){
        return  rsa.hashSHA(mensageCifrado);
    }
    
    public String getMensage(){
        return mensage;
    }

    public void prueba() {
        System.out.println("Mensage             : " + mensageCifrado);
        System.out.println("Firma del mensage   : " + getFirmaDigital());
        System.out.println("hash del mensage    : " + gethashMensage());
        System.out.println("firma descifrada    : " + getFirmaDigitalDecifrada());
    }

    private void CargarLlavesE(String pubE, String prvE) {
        KeyPair kp = rsa.CargardeLLaves(pubE, prvE);
        if (kp != null){
            llavePublicaE = kp.getPublic();
            llavePrivadaE = kp.getPrivate();
        }else
            System.out.println("Error al generar llaves");
    }

    private void CargarLlavepubR(String pubR) {
        llavePublicaR = rsa.Cargarpub(pubR);
    }

    private void CargarLlavepubE(String pubE) {
        llavePublicaE = rsa.Cargarpub(pubE);
    }

    private void CargarLlavesR(String pubR, String prvR) {
        KeyPair kp = rsa.CargardeLLaves(pubR, prvR);
        llavePublicaR = kp.getPublic();
        llavePrivadaR = kp.getPrivate();
    }

    private String getLlavePublicaEmissor() {
        return rsa.getLlave(llavePublicaE);
    }

    private String getLlavepublicaReceptor() {
        return rsa.getLlave(llavePublicaR);
    }
}
