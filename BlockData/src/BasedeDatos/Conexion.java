package BasedeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Juanchope
 * @code Esta clase se encarga de manejar la conexion a la base de datos
 */

public class Conexion {
    private Connection Conexion;
    private final String CONTROLADOR //"com.mysql.jdbc.Driver" //"org.apache.derby.jdbc.EmbeddedDriver"
            ,USUARIO //"root" //"APP"
            ,CLAVE //"" //"1234"
            ,URL //jdbc:derby:D:\\Mis Documentos\\Juan David G V\\NetBeansProjects\\Prueba1\\BD" 
            /*"jdbc:mysql://localhost:3306/tienda1" ///*jdbc:derby:memory:myDB;create=true*/;   

    
/**
 * 
 * Construye la conexion para ser usada junto con un manejador de base de datos
 * 
 * @param USUARIO identifica al usuario de la base de datos
 * @param CLAVE clave del usuario de la base de datos 
 * @param CONTROLADOR el identificador del controlador a usar | "org.apache.derby.jdbc.EmbeddedDriver" | "com.mysql.jdbc.Driver"
 * @param URL direccion en donde está la base de datos |"jdbc:derby:ruta" |jdbc:mysql:ruta 
 * 
 */
    
    public Conexion(String USUARIO, String CLAVE,String CONTROLADOR, String URL) {
        this.CONTROLADOR = CONTROLADOR;
        this.USUARIO = USUARIO;
        this.CLAVE = CLAVE;
        this.URL = URL;
    } 
    
    /**
     *
     * establece la conexion a la base de datos
     * 
     * @return Devuelve el estado de la conección
     * 
    */
    
    public boolean Conectar(){
        //Conexion=null;
        try{    
            Class.forName(CONTROLADOR);
            Conexion = DriverManager.getConnection(URL,USUARIO,CLAVE);
            System.out.println(Conexion != null ? "Conectado Correctamente" 
                    : "Ha ocurrido un error al conectar");
            return true;
        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Servidor Desconectado", "Alerta", JOptionPane.ERROR_MESSAGE);
            System.out.println("error. "+ e);
        }
        return false;
    }
    
    /**
     *
     * Rompe la conexion a la base de datos
     * 
    */
    
    public void desconectar(){
        Conexion = null;
        System.out.println(Conexion == null ? "Conexion Terminada.." 
                : "Error al Desconectar");
    }
    
    /**
     * 
     * @return devuelbe la conexion
     * 
     */
    
    public Connection getConexion() {
        return Conexion;
    }
}
