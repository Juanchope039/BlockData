package RSA;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA {
    
    protected  Cipher rsa;
    protected final int bytesRSA, bytesHash;
    protected  /*final*/String MensageCifrado ;
    
    /**
     * Es un objecto que se encarga de cifrar/decifrarTexto por rsa y sha con el fin de proteger los datos y frimarlos
     * @param bytesRSA Numero de bytes usados para cifrar los mensajes con rsa
     * @param bytesHash Numero de bytes usados para encriptar el hash de la firma del mensaje
     */
    
    public RSA(int bytesRSA, int bytesHash) {
        this.bytesRSA = bytesRSA;
        this.bytesHash = bytesHash;        
    }

    public static void main(String[] args) throws  Exception {
        generarprubaBasica();//*/
    }    

    private static void generarprubaBasica() throws Exception{
        
 /*       RSA pruebarsa = new RSA(2048, 256);//2048,512
        pruebarsa.CargarLlavesSRC("publickey.pubc","privatekey.prv");
          pruebarsa.setLlavepublicaReceptor("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAieokV9uraadtG0/iSGVXGgyTbqh3wWoh91JfQbxeijNUHsmgv7uxWTL017Szm8qFXT12loagsX52AVQDl7vWO0WCZtKQSe7ZHN17FpYSdKOR6LHRQC20MmcdeXzAViXJ3u7xP9dd0vtm6n5kSVvHIvNQ0RfPCkyqiLKVnB9OYOSU+Kw+f11/jE6BoWA/t7C5MRlJKvqatbS3zRnGDanteR8iMYM8XmPe8P79/2RKPkh5EGI7RENJe6fu1epTTWrzNKlA4uuZw87WUfBmh4u0JNvIGQXquWRImkURHuPDakynoQIqLrdLRgBXp9Uln+WD3Ay4WdulY17obVvicd1O6wIDAQAB");
                
        //mostrar llaves
      System.out.println("Llave Publica: -----> " + pruebarsa.getLlavePublica());
        System.out.println("Llave Privada: -----> " + pruebarsa.getLlavePrivada());
        System.out.println("Llave Publica Receptor: -----> " + pruebarsa.getLlavepublicaReceptor());
        
        // Texto a cifrar
        String text = "Texto a cifrar";
        System.out.println("texto a cifrar: -----> " + text);
        
        // cifrando texto
        //String textocifrado = pruebarsa.Cifrar(text),
        //        Textocifrado2 = pruebarsa.cifrarReceptor(text);

        // Escribimos el encriptado para verlo, con caracteres visibles
        //System.out.println("Texto Cifrado: -----> " + textocifrado);
        //System.out.println("Texto Cifrado para receptor: -----> " + Textocifrado2);
        
        // Se descifra
        //String textoDecifrado = pruebarsa.decifrarTexto(textocifrado);
        
        // Se escribe el texto decifrado
        //System.out.println("texto decifrado: -----> " + textoDecifrado);
        
        //has del texto
        //String hashdelMensage = pruebarsa.hashSHA(textocifrado),
        //        hashdelMensage2 = pruebarsa.hashSHA(Textocifrado2);//512-bytes
        
        // mostrar hash del texto cifrado
        //System.out.println("hash del texto cifrado: -----> " + hashdelMensage);
        //System.out.println("hash del texto cifrado para receptor: -----> " + hashdelMensage2);
        
        //generando hash
        //String firmaDigital = pruebarsa.cifrarfirma(hashdelMensage),
        //        firmaDigital2 = pruebarsa.cifrarfirma(hashdelMensage2);//Base64.getEncoder().encodeToString(firmaCifrada);
        
        //mostrando hash
        //System.out.println( "firma digital: -----> " + firmaDigital);
        //System.out.println( "firma digital receptor: -----> " + firmaDigital2);
        
        //decifrando firma digital
        //String firmadecifrada = pruebarsa.decifrarfirma(firmaDigital ),
        //        firmadecifrada2 = pruebarsa.decifrarfirma(firmaDigital2);
        
        //amostrando firma decifrada
        //System.out.println("autenticacion por llave publica : -----> " + firmadecifrada);
        //System.out.println("autenticacion por llave publica receptor: -----> " + firmadecifrada2);
        
        //autenticando firma
        //System.out.println("-----> " + (hashdelMensage.equals(firmadecifrada)? "firma autenticada" : "Erro Firma corrupta"));
        //System.out.println("-----> " + (hashdelMensage2.equals(firmadecifrada2)? "firma autenticada" : "Erro Firma corrupta"));
*/    }

    private KeyPair generarPardeLLaves() throws Exception{
        KeyPairGenerator pardeLlaves = KeyPairGenerator.getInstance("RSA");
        pardeLlaves.initialize(bytesRSA);
        KeyPair keyPair = pardeLlaves.generateKeyPair();        
        return keyPair;
    }

    private  void exportarLlave(Key Llave, String nombredeArchivo) {
        byte[] bytesdelaLlave = Llave.getEncoded();
        try (FileOutputStream archivodeSalidaenVivo = new FileOutputStream(nombredeArchivo)) {
            archivodeSalidaenVivo.write(bytesdelaLlave);
            System.out.println("Par de llaves guardadas sactisfactoriamente.");
        } catch (Exception ex) {
            System.out.println("Guardado de llaves falló.");
        }
    }

    private  PublicKey importarLlavePublica(String nombredelArchivo) throws Exception {
        byte[] bytes = cargarArchivoConvertidoaBytes(nombredelArchivo);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        KeySpec keySpec = new X509EncodedKeySpec(bytes);
        PublicKey keyFromBytes = keyFactory.generatePublic(keySpec);
        return keyFromBytes;
    }

    private  PrivateKey importarLlavePrivada(String nombredelArchivo ) throws Exception{
        byte[] bytes = cargarArchivoConvertidoaBytes(nombredelArchivo);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        KeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
        PrivateKey keyFromBytes = keyFactory.generatePrivate(keySpec);
        return keyFromBytes;
    }
/*
    protected String decifrarTexto(String textocifrado){
        String salida = "";
        try {
            // Obtener la clase para encriptar/desencriptar
            rsa = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
            rsa.init(Cipher.DECRYPT_MODE, llavePrivada);
            byte[] bytesDesencriptados = rsa.doFinal(decodificar(textocifrado));
            salida = new String(bytesDesencriptados);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getCause().toString());
        }
        return salida;
    }*/
/*
    protected String cifrarTexto(String text){
        String salida= "";
        try {
            rsa = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");//"RSA/ECB/PKCS1Padding"
            rsa.init(Cipher.ENCRYPT_MODE, llavepublicaReceptor);
            salida = codificar(rsa.doFinal(text.getBytes()));
        } catch (Exception ex) {
            System.out.println(ex.getCause().toString());
        }
        return salida;
    }*/
    /*
    private  String cifrarReceptor(String text) throws Exception{
        rsa = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");//"RSA/ECB/PKCS1Padding"
        rsa.init(Cipher.ENCRYPT_MODE, llavepublicaReceptor);
        return codificar(rsa.doFinal(text.getBytes()));
    }*/
    
    public PublicKey Cargarpub(String llave){
        try {
            KeyFactory fabricarLlave = KeyFactory.getInstance("RSA");
            KeySpec llaveSpec = new X509EncodedKeySpec(decodificar(llave));
            return fabricarLlave.generatePublic(llaveSpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            if (("java.security.InvalidKeyException: IOException: Short read of DER length").equals(ex.getCause().toString()))
                System.out.println("llave demasiado corta.");
            else
                System.out.println("Guardar llave publica del receptor falló.\n" + ex.getCause().toString());
        }
        return null;
    }
    /*
    public PrivateKey Cargarprv(String llave){
        try {
            KeyPair pardeLlaves;
            byte[] bytesprv = llave.getBytes();
            KeyFactory fabricarLlave = KeyFactory.getInstance("RSA");
            KeySpec llaveSpec = new PKCS8EncodedKeySpec(bytesprv);
            PrivateKey prv = fabricarLlave.generatePrivate(llaveSpec);
            return prv;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.out.println("Crgarprv llave falló"+ex);
        }
        return null;
    }
*/
    public KeyPair CargardeLLaves(String pub, String prv){
        KeyPair pardeLlaves;
        try {
            byte[] bytespub = pub.getBytes(),
                    bytesprv = prv.getBytes();
            
            //System.out.println(new String(bytespub));
            
            KeyFactory fabricarLlave = KeyFactory.getInstance("RSA");
            KeySpec llaveSpec = new X509EncodedKeySpec(bytespub);
            PublicKey llpub = fabricarLlave.generatePublic(llaveSpec);
            
            fabricarLlave = KeyFactory.getInstance("RSA");
            llaveSpec = new PKCS8EncodedKeySpec(bytesprv);
            PrivateKey llpriv = fabricarLlave.generatePrivate(llaveSpec);
            
            return pardeLlaves = new KeyPair(llpub, llpriv);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.out.println("Cargar llaves Falló." + ex);
        }
        return null;
    }

    private  byte[] cargarArchivoConvertidoaBytes(String nombredelArchivo)throws Exception{
        byte[] bytes;
        try (FileInputStream fis = new FileInputStream(nombredelArchivo)) {
            int numBtyes = fis.available();
            bytes = new byte[numBtyes];
            fis.read(bytes);
        }
        return bytes;
    }

    private  String codificar(byte[] cifrado) {
        return Base64.getEncoder().encodeToString(cifrado);
    }

    private  byte[] decodificar(String textocifrado) {
        return Base64.getDecoder().decode(textocifrado);
    }

    public String hashSHA(String texto){
        try {
            MessageDigest digestordeMensages = MessageDigest.getInstance("SHA-" + bytesHash);
            return  codificar(digestordeMensages.digest(texto.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getCause().toString());
        }
        return null;
    }

    private  byte[] control(String hashdelMensage) {
        byte[] cadena = decodificar(hashdelMensage);
        return cadena;
    }
    
    public String Cifrar(String texto, Key llave){
        try {
            Cipher cipher2 = Cipher.getInstance("rsa");
            cipher2.init(Cipher.DECRYPT_MODE, llave);
            return codificar(cipher2.doFinal(decodificar(texto)));//control(firmaCifrada)
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getCause().toString());
        }
        return null;
    }
    
    public String Decifrar(String texto, Key llave){
        try {
            Cipher cipher = Cipher.getInstance("rsa"); cipher.init(Cipher.ENCRYPT_MODE, llave);        
            return codificar(cipher.doFinal(decodificar(texto)));//decodificar(hash)
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getCause().toString());
        }
        return null;
    }
    
    
/*
    protected String cifrarfirma(String hash){
        try {
            Cipher cipher = Cipher.getInstance("rsa"); cipher.init(Cipher.ENCRYPT_MODE, llavePrivada);        
            return codificar(cipher.doFinal(decodificar(hash)));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getCause().toString());
        }
        return null;
    }*/
    /*
    protected String decifrarfirma(String firmaCifrada) {
        try {
            Cipher cipher2 = Cipher.getInstance("rsa");
            cipher2.init(Cipher.DECRYPT_MODE, llavePublica);
            return codificar(cipher2.doFinal(control(firmaCifrada)));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex.getCause().toString());
        }
        return null;
    }*/

    private void CargarLlavesSRC(String srcpubc, String srcprv) {
        try {
//            llavePublica = importarLlavePublica(srcpubc);
//            llavePrivada = importarLlavePrivada(srcprv);
            System.out.println("llaves rescatadas correctamente.");
        } catch (Exception e) {
            System.out.println("falló rescate de llaves.");
        }
        
//        if (llavePublica == null | llavePrivada == null){
            try {
                System.out.println("Generando par de llaves.");
                KeyPair pardeLLaves ;
                pardeLLaves = generarPardeLLaves();
                System.out.println("Obteniendo par de llaves");
//                llavePublica = pardeLLaves.getPublic();
//                llavePrivada = pardeLLaves.getPrivate();
                
                System.out.println("Guardando par de llaves.");
//                exportarLlave(llavePublica, srcpubc);
//                exportarLlave(llavePrivada, srcprv);
            } catch (Exception ex) {
                System.out.println("Guardado de llaves falló.");
            }
//        }
    }
    
    /**
 * 
 * @param pub llave publica
 * @param prv llave privada
 * 
 * 
 */
/*
    public void CargarLlaves(String pub, String prv) {
        try {
            byte[] bytes1 = decodificar(pub),
                    bytes2 = decodificar(prv);
            
            KeyFactory fabricarLlave = KeyFactory.getInstance("RSA");
            KeySpec llaveSpec = new X509EncodedKeySpec(bytes1);
            PublicKey llpub = fabricarLlave.generatePublic(llaveSpec);
            
            fabricarLlave = KeyFactory.getInstance("RSA");
            llaveSpec = new PKCS8EncodedKeySpec(bytes2);
            PrivateKey llpriv = fabricarLlave.generatePrivate(llaveSpec);
            
            KeyPair kp = new KeyPair(llpub, llpriv);
            
            llavePublica = kp.getPublic();
            llavePrivada = kp.getPrivate();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.out.println("Extraer llaves Falló.<266-R>\n" + ex.getCause().toString());
        }        
    }*/
    
    private KeyPair generarLlaves(){
        try {
            KeyPair pardeLLaves ;
            pardeLLaves = generarPardeLLaves();
//            llavePublica = pardeLLaves.getPublic();
//            llavePrivada = pardeLLaves.getPrivate();
            return pardeLLaves;   
        } catch (Exception ex) {
            System.out.println("Guardado de llaves falló.\n" + ex.getCause().toString());
        }   
        return null;
    }

    public String getLlave(Key llave) {
        return codificar(llave.getEncoded());
    }

    protected String getMensageCifrado() {
        return MensageCifrado;
    }

    public void setMensageCifrado(String MensageCifrado) {
        if (MensageCifrado.length() ==344)
            this.MensageCifrado = MensageCifrado;
    }
/*
    public void setLlavepublicaReceptor(String pub) {
        try {
            KeyFactory fabricarLlave = KeyFactory.getInstance("RSA");
            KeySpec llaveSpec = new X509EncodedKeySpec(decodificar(pub));
            this.llavepublicaReceptor = fabricarLlave.generatePublic(llaveSpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            if (("java.security.InvalidKeyException: IOException: Short read of DER length").equals(ex.getCause().toString()))
                System.out.println("llave demasiado corta.");
            else
                System.out.println(ex.getCause().toString());
        }
    }*/
}
