package BasedeDatos;

import codigo.Mensage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Juanchope
 */
public class Manejador_de_Base_de_Datos {
    
    private static final String bd = "pruebarsa", localizacionxampp = "jdbc:mysql://localhost/";
    private static final Conexion con = new Conexion("root", "", "com.mysql.jdbc.Driver", localizacionxampp + bd);
    
    private static void Consulta(Connection con,String Consulta,String... parametros){
        try{
            PreparedStatement consulta;
            consulta = con.prepareStatement(Consulta);
            for (int i = 0; i < parametros.length; i++)
                consulta.setString(i+1, parametros[i]);
            consulta.executeUpdate();
            System.out.println("Consulta exitosa.");
        }catch(Exception ex){
            
            if (ex.hashCode() == 89387388)
                System.out.println("Filas repetidas.");
            else
                System.out.println("Consulta falló.\n" + ex/*.hashCode()*/);
        }
    }
    
    private static ArrayList<Mensage> recibirMensage(Connection con,String Consulta,String parametro){
        ArrayList<Mensage> resultado =new ArrayList<>();
        try{
            PreparedStatement consulta = con.prepareStatement(Consulta );
            if (!parametro.equals("*"))
                consulta.setString(1, parametro);
            ResultSet r = consulta.executeQuery();
            while(r.next()){
                Mensage msg = new Mensage();
                msg.setLlavePublicaEmisor(r.getString(1));
                msg.setLlavepublicaReceptor(r.getString(2));
                msg.setMensage(r.getString(3));
                msg.setFirmaDigital(r.getString(4));
                resultado.add(msg);
            }
            System.out.println("Consulta exitosa.");
        }catch(Exception ex){
            System.out.println(ex.getCause().toString());
        }
        return (resultado.isEmpty() ? null : resultado);
    }
    
    public static void enviarmensage(String pube, String pubr, String msg, String firmadigital){
        con.Conectar();
        String consulta="INSERT INTO `mensaje` (`llave publica emisor`, `llave publica receptor`, `mensaje cifrado`, `firma digital`) VALUES (?, ?, ?, ?)", //, `Fecha`, ?
                parametros[] = {pube, pubr, msg, firmadigital};
        Manejador_de_Base_de_Datos.Consulta(con.getConexion(), consulta, parametros);
    }
    
    public static void enviarmensage(Mensage msg){
        con.Conectar();
        String consulta="INSERT INTO `mensaje` (`llave publica emisor`, `llave publica receptor`, `mensaje cifrado`, `firma digital`, `HashActual`) VALUES (?, ?, ?, ?, ?)", //, `Fecha`, ?
                parametros[] = {msg.getLlavePublica(), 
                    msg.getLlavepublicaReceptor(), 
                    msg.CifrarMensage(), msg.getFirmaDigital(), msg.hash()};
        Manejador_de_Base_de_Datos.Consulta(con.getConexion(), consulta, parametros);
    }

    public static ArrayList<Mensage> recibirmensage(String direccion) {
        con.Conectar();
        String consulta = "SELECT * FROM `mensaje` ";
        if (!"*".equals(direccion))
            consulta += "WHERE `llave publica receptor` = ?" ;// AND `Recibido` = false
        return Manejador_de_Base_de_Datos.recibirMensage(con.getConexion(), consulta, direccion);
    }
    
}
