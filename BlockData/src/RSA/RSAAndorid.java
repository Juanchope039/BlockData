package RSA;

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

public class RSAAndorid {
    
    PublicKey llavePublica;
    PrivateKey llavePrivada;
    
    public RSAAndorid(){
    }

    public static void main(String[] args) throws  Exception {
        RSAAndorid prueba = new RSAAndorid();
        generarprubaBasica();//*/
    }

    private static void generarprubaBasica() throws Exception{
        //Crear una instancia rsa
        RSAAndorid rsa1 = new RSAAndorid();
        // Generar el par de claves
        System.out.println(rsa1.generarPardeLLaves()? "Par de lave generadas correctamente": "Par de llaves no se generaron");

        rsa1.generarPardeLLaves(rsa1.getllavePublica(), rsa1.getllavePrivada());
        
        System.out.println("Llave Publica -> " + rsa1.getllavePublica());
        System.out.println("Llave Privada -> " + rsa1.getllavePrivada());

        // Texto a cifrar
        String text = "Texto a cifrar";
        System.out.println("texto a cifrar: " + text);
        
        // Se Cifra el texto y se muestra
        String textoCifrado = rsa1.cifrar(text);
        System.out.println("Texto Cifrado: " + textoCifrado);

        // Se Decifra el texto cifrado y se muestra
        String textoDecifrado = rsa1.decifrar(textoCifrado);
        System.out.println("texto decifrado: " + textoDecifrado);
        
        String hashdeltextoCifrado = rsa1.hashSHA256(textoCifrado);
        System.out.println("hash del texto cifrado: " + hashdeltextoCifrado);
        
        String firmaDigitaldelHash  = rsa1.firmaDigital(hashdeltextoCifrado);
        System.out.println( "firma digital: " + firmaDigitaldelHash);
        
        String autenticacionfirmadigital1 = rsa1.decifrarfirmaDigital(firmaDigitaldelHash);
        System.out.println("autenticacion por llave publica : " + autenticacionfirmadigital1);
        
        System.out.println(hashdeltextoCifrado.equals(autenticacionfirmadigital1)? "firma autenticada" : "Erro Firma corrupta");
        //<------------------ Voy por aquí
    }

    public boolean generarPardeLLaves() {
        try {
            KeyPairGenerator generadordeLlaves = KeyPairGenerator.getInstance("RSA");
            generadordeLlaves.initialize(2048);
            KeyPair llavero = generadordeLlaves.generateKeyPair();
            llavePublica = llavero.getPublic();
            llavePrivada = llavero.getPrivate();
            return true;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RSAAndorid.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean generarPardeLLaves(String llavepublica, String llaveprivada){
        try {
            
            KeyFactory fabricarLlave = KeyFactory.getInstance("RSA");
            KeySpec llaveSpec = new X509EncodedKeySpec(decodificar(llavepublica));
            llavePublica = fabricarLlave.generatePublic(llaveSpec);
            
            fabricarLlave = KeyFactory.getInstance("RSA");
            llaveSpec = new PKCS8EncodedKeySpec(decodificar(llaveprivada));
            llavePrivada = fabricarLlave.generatePrivate(llaveSpec);
            
            return true;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(RSAAndorid.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
/*
    private static void exportarLlave(Key llavePublica, String nombredeArchivo) throws Exception{
        byte[] bytesdelaLlave = llavePublica.getEncoded();
        try (FileOutputStream archivodeSalidaenVivo = new FileOutputStream(nombredeArchivo)) {
            archivodeSalidaenVivo.write(bytesdelaLlave);
        }
    }

    private static PublicKey importarLlavePublica(String nombredelArchivo) throws Exception {
        byte[] bytes = cargarArchivoConvertidoaBytes(nombredelArchivo);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        KeySpec keySpec = new X509EncodedKeySpec(bytes);
        PublicKey keyFromBytes = keyFactory.generatePublic(keySpec);
        return keyFromBytes;
    }

    private static PrivateKey importarLlavePrivada(String nombredelArchivo ) throws Exception{
        byte[] bytes = cargarArchivoConvertidoaBytes(nombredelArchivo);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        KeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
        PrivateKey keyFromBytes = keyFactory.generatePrivate(keySpec);
        return keyFromBytes;
    }
//*/
    private byte[] decifrar(byte[] cifrado) throws Exception{
        // Obtener la clase para encriptar/desencriptar
        Cipher rsa = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
        rsa.init(Cipher.DECRYPT_MODE, llavePrivada);
        return rsa.doFinal(cifrado);
    }
    
    public String decifrar(String Texto){
        try {
            byte[] unicode = decodificar(Texto);
            unicode = decifrar(unicode);
            return new String(unicode);
        } catch (Exception ex) {
            Logger.getLogger(RSAAndorid.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private byte[] cifrar(byte[] TextoUnicode) throws Exception{
        Cipher rsa = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");//"RSA/ECB/PKCS1Padding"
        rsa.init(Cipher.ENCRYPT_MODE, llavePublica);
        return rsa.doFinal(TextoUnicode);
    }
    
    public String cifrar(String Texto){
        try {
            byte[] unicode = cifrar(Texto.getBytes());
            return codificar(unicode);
        } catch (Exception ex) {
            Logger.getLogger(RSAAndorid.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/*
    private static byte[] cargarArchivoConvertidoaBytes(String nombredelArchivo)throws Exception{
        byte[] bytes;
        try (FileInputStream fis = new FileInputStream(nombredelArchivo)) {
            int numBtyes = fis.available();
            bytes = new byte[numBtyes];
            fis.read(bytes);
        }
        return bytes;
    }
//*/
    private String codificar(byte[] cifrado) {
        return Base64.getEncoder().encodeToString(cifrado);
    }

    private byte[] decodificar(String textocifrado) {
        return Base64.getDecoder().decode(textocifrado);
    }

    public String hashSHA256(String texto) throws  Exception{
        MessageDigest digestordeMensages = MessageDigest.getInstance("SHA-256");
        return  codificar(digestordeMensages.digest(texto.getBytes(StandardCharsets.UTF_8)));
    }

    public String firmaDigital(String hash) {
        try {
            byte[] unicode = decodificar(hash);
            Cipher cipher = Cipher.getInstance("rsa"); 
            cipher.init(Cipher.ENCRYPT_MODE, llavePrivada);
            unicode = cipher.doFinal(unicode);        
            return codificar(unicode);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(RSAAndorid.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String decifrarfirmaDigital(String hashFirmado) {
        try {
            byte[] unicode = decodificar(hashFirmado);
            Cipher cipher2 = Cipher.getInstance("rsa");
            cipher2.init(Cipher.DECRYPT_MODE, llavePublica);
            unicode = cipher2.doFinal(unicode);
            return codificar(unicode);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(RSAAndorid.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //Getters and Setters
    
    public String getllavePublica(){
        return getllave(llavePublica);
    }
    
    public String getllavePrivada(){
        return getllave(llavePrivada);
    }
    private String getllave(Key llave){
        byte[] unicode = llave.getEncoded();
        return Base64.getEncoder().encodeToString(unicode);
    }
    
}
