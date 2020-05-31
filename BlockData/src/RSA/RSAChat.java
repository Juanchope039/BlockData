package RSA;

import codigo.Mensaje;
import java.util.ArrayList;

public class RSAChat {
    private final int bytesRSA, bytesHash;
    private ArrayList<Mensaje> mensajes = new ArrayList<>();
    private final String prv, pub;

    public RSAChat(int bytesRSA, int bytesHash, String prv, String pub) {
        this.bytesRSA = bytesRSA;
        this.bytesHash = bytesHash;
        this.prv=prv;
        this.pub=pub;        
    }

    public Mensaje Write(String pube, String mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void read(String pubr, String texto, String firma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
