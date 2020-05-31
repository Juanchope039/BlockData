package prueba.visual;

import codigo.Mensaje;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Tablero extends javax.swing.JFrame {

    private LinkedList<String[]>    NombresDirecciones  = new LinkedList<>();
    private LinkedList<Mensaje>     Mensajes            = new LinkedList<>();
    private LinkedList<String[]>    llaves              = new LinkedList<>();
    private LinkedList<String[]>    registro            = new LinkedList<>();
    private final String            nombreArchivo       = "datos.obj";
    
    public Tablero() {
        initComponents();
        Recuperar();     
        generarRegistro("se ha iniciado la aplicacion");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jta_Reporte = new javax.swing.JTextArea();
        jtf_dirrecionPrivadaRemitente = new javax.swing.JTextField();
        jtf_dirrecionReceptor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jta_mensaje = new javax.swing.JTextArea();
        jbtn_enviar = new javax.swing.JButton();
        jbtn_limpiar = new javax.swing.JButton();
        jbtn_filtrar = new javax.swing.JButton();
        jbtn_listarTodos = new javax.swing.JButton();
        jbtn_listar = new javax.swing.JButton();
        jbtn_salir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtf_dirrecionPublicaRemitente = new javax.swing.JTextField();
        jbtn_borrar = new javax.swing.JButton();
        jbtn_verDatos = new javax.swing.JButton();
        jbtn_verApodos = new javax.swing.JButton();
        jbtn_verLlaves = new javax.swing.JButton();
        jbtn_verRegistros = new javax.swing.JButton();
        jbtn_borrarContenido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BlockData");
        setName("Main"); // NOI18N

        jta_Reporte.setColumns(20);
        jta_Reporte.setRows(5);
        jta_Reporte.setEnabled(false);
        jta_Reporte.setName(""); // NOI18N
        jScrollPane1.setViewportView(jta_Reporte);

        jtf_dirrecionPrivadaRemitente.setToolTipText("Direccion del remitente");
        jtf_dirrecionPrivadaRemitente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_dirrecionPrivadaRemitenteKeyPressed(evt);
            }
        });

        jtf_dirrecionReceptor.setToolTipText("direccion de receptor");
        jtf_dirrecionReceptor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_dirrecionReceptorKeyPressed(evt);
            }
        });

        jLabel1.setText("Direccion privada del remitente: ");

        jLabel2.setText("Direccion de receptor:");

        jLabel3.setText("Mensaje");

        jta_mensaje.setColumns(20);
        jta_mensaje.setRows(5);
        jta_mensaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jta_mensajeKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jta_mensaje);

        jbtn_enviar.setText("Enviar");
        jbtn_enviar.setEnabled(false);
        jbtn_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_enviarActionPerformed(evt);
            }
        });

        jbtn_limpiar.setText("Limpiar");
        jbtn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_limpiarActionPerformed(evt);
            }
        });

        jbtn_filtrar.setText("Filtrar");
        jbtn_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_filtrarActionPerformed(evt);
            }
        });

        jbtn_listarTodos.setText("Listar todos");
        jbtn_listarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_listarTodosActionPerformed(evt);
            }
        });

        jbtn_listar.setText("listar");
        jbtn_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_listarActionPerformed(evt);
            }
        });

        jbtn_salir.setText("Salir");
        jbtn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_salirActionPerformed(evt);
            }
        });

        jLabel4.setText("Direccion publica del remitente: ");

        jtf_dirrecionPublicaRemitente.setToolTipText("Direccion del remitente");
        jtf_dirrecionPublicaRemitente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_dirrecionPublicaRemitenteKeyPressed(evt);
            }
        });

        jbtn_borrar.setText("Borrrar");
        jbtn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_borrarActionPerformed(evt);
            }
        });

        jbtn_verDatos.setText("ver datos");
        jbtn_verDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_verDatosActionPerformed(evt);
            }
        });

        jbtn_verApodos.setText("Ver apodos");
        jbtn_verApodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_verApodosActionPerformed(evt);
            }
        });

        jbtn_verLlaves.setText("Ver llaves");
        jbtn_verLlaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_verLlavesActionPerformed(evt);
            }
        });

        jbtn_verRegistros.setText("ver Registros");
        jbtn_verRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_verRegistrosActionPerformed(evt);
            }
        });

        jbtn_borrarContenido.setText("borrar contenido");
        jbtn_borrarContenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_borrarContenidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jtf_dirrecionPrivadaRemitente)
                    .addComponent(jtf_dirrecionReceptor)
                    .addComponent(jScrollPane2)
                    .addComponent(jtf_dirrecionPublicaRemitente)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtn_enviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jbtn_limpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jbtn_listarTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jbtn_listar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jbtn_filtrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jbtn_borrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jbtn_salir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtn_verDatos)
                                .addGap(30, 30, 30)
                                .addComponent(jbtn_verApodos)
                                .addGap(30, 30, 30)
                                .addComponent(jbtn_verLlaves)
                                .addGap(18, 18, 18)
                                .addComponent(jbtn_verRegistros)
                                .addGap(18, 18, 18)
                                .addComponent(jbtn_borrarContenido)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_dirrecionPublicaRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_dirrecionPrivadaRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_dirrecionReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_enviar)
                    .addComponent(jbtn_filtrar)
                    .addComponent(jbtn_limpiar)
                    .addComponent(jbtn_listarTodos)
                    .addComponent(jbtn_listar)
                    .addComponent(jbtn_salir)
                    .addComponent(jbtn_borrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_verDatos)
                    .addComponent(jbtn_verApodos)
                    .addComponent(jbtn_verLlaves)
                    .addComponent(jbtn_verRegistros)
                    .addComponent(jbtn_borrarContenido))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_limpiarActionPerformed
        limpiar();
        jbtn_enviar.setEnabled(false);
        generarRegistro("Se ha limpiado los campos");
    }//GEN-LAST:event_jbtn_limpiarActionPerformed

    private void jbtn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_salirActionPerformed
        Almacenar();
        generarRegistro("se ha salido de la app");
        System.exit(0);
    }//GEN-LAST:event_jbtn_salirActionPerformed

    private void jbtn_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_listarActionPerformed
        limpiar();
        String direccion;
        do{
            direccion = JOptionPane.showInputDialog("Porfavor Ingrese la direccion que desea buscar.");
            if (isdireccion(direccion) || direccion.equalsIgnoreCase(""))
                JOptionPane.showMessageDialog(null, "Porfavor Ingrese una direccion valida");
            else
                BuscarDireccion(direccion);
        }while(direccion.equalsIgnoreCase("") || isdireccion(direccion));
        generarRegistro("se han listado todos los reportes con direccion -> " + direccion);
    }//GEN-LAST:event_jbtn_listarActionPerformed

    private void jbtn_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_filtrarActionPerformed
        JOptionPane.showMessageDialog(null, "Esta funcion ahun no está en funcionamiento");
    }//GEN-LAST:event_jbtn_filtrarActionPerformed

    private void jbtn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_enviarActionPerformed
        try {            
            String  direccionReceptor = jtf_dirrecionReceptor.getText(),
                    direccionPrivadaRemitente = jtf_dirrecionPrivadaRemitente.getText(),
                    direccionPublicaRemitente = jtf_dirrecionPublicaRemitente.getText(),
                    mensaje = jta_mensaje.getText(),
                    ultimohash = "";
            if (Mensajes.size() != 0)
                ultimohash = Mensajes.getLast().hash();
            Mensaje msj = null;
            if (direccionReceptor.charAt(0) == '@')
                direccionReceptor = buscarApodo(direccionReceptor.substring(1));
            else if (   direccionReceptor.charAt(0) == '*' && 
                        direccionPrivadaRemitente.charAt(0) == '*')
                msj = new Mensaje(mensaje);
            else if (direccionPrivadaRemitente.charAt(0) == '*')
                msj = new Mensaje(direccionReceptor, mensaje);
            else 
                msj = new Mensaje(direccionPublicaRemitente, direccionPrivadaRemitente, direccionReceptor, mensaje);
            if(jtf_dirrecionReceptor.getText().charAt(0)!='@' &&  
                    JOptionPane.showConfirmDialog(null, "Desea agregar un apodo a esta direccio?",
                    "Guardar Apodo en lista", JOptionPane.YES_NO_OPTION) == 0){
                String apodo;
                do{
                    apodo = JOptionPane.showInputDialog("Porfavor escriba el apodo");
                    if (apodo.equalsIgnoreCase(""))
                        JOptionPane.showMessageDialog(null, "No escribió un apodovalido");
                    else if(!buscarApodo(apodo).equalsIgnoreCase("0"))
                        JOptionPane.showMessageDialog(null, "El apodo ingresado ya existe.");
                }while(apodo.equalsIgnoreCase("") || !buscarApodo(apodo).equalsIgnoreCase("0"));
                String[] obj = {apodo,msj.getLLavePrivadaEmissor(),msj.getLlavePublicaEmissor()};
                NombresDirecciones.add(obj);
            }
            Mensajes.add(msj);
            llaves.add(new String [] {
                msj.getLLavePrivadaEmissor(),
                msj.getLlavePublicaEmissor(),
                msj.getLlavepublicaReceptor()});
            JOptionPane.showMessageDialog(null, "Apodo agregado sactisfactoriamente. [" + msj.hash() + "]"); 
            generarRegistro("Se ha generado un nuevo registro para -> " + msj.getLlavepublicaReceptor());
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(null,"no escribió nada porfavor intentelo nuevamente");
            generarRegistro("se generado un error [" + e.getMessage() + "]");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ha ocurrido un error inesperado. " + e.getMessage());
            generarRegistro("se generado un error [" + e.getMessage() + "]");
        }
    }//GEN-LAST:event_jbtn_enviarActionPerformed

    private void jta_mensajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jta_mensajeKeyPressed
        activarDesactivarEnviar();
    }//GEN-LAST:event_jta_mensajeKeyPressed

    private void jtf_dirrecionReceptorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_dirrecionReceptorKeyPressed
        activarDesactivarEnviar();
    }//GEN-LAST:event_jtf_dirrecionReceptorKeyPressed

    private void jtf_dirrecionPrivadaRemitenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_dirrecionPrivadaRemitenteKeyPressed
        activarDesactivarEnviar();
    }//GEN-LAST:event_jtf_dirrecionPrivadaRemitenteKeyPressed

    private void jbtn_listarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_listarTodosActionPerformed
        limpiar();
        String res = "**Lista de todos los mensajes**";
        res = Mensajes.stream().map((obj) -> "\n" + obj.toString()).reduce(res, String::concat);
        jta_Reporte.setText(res);
        generarRegistro("se han listado todos los mensajes");
    }//GEN-LAST:event_jbtn_listarTodosActionPerformed

    private void jtf_dirrecionPublicaRemitenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_dirrecionPublicaRemitenteKeyPressed
        activarDesactivarEnviar();
    }//GEN-LAST:event_jtf_dirrecionPublicaRemitenteKeyPressed

    private void jbtn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_borrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtn_borrarActionPerformed

    private void jbtn_verDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_verDatosActionPerformed
        String[] columnas = {
            "Llave publica del emisor",
            "llave publica del receptor",
            "mensaje cifrado",
            "firma digital",
            "hash del mensaje",
            "hash anterior"
        };
        String[][] datos = new String[Mensajes.size()][6];
        for (int i = 0; i < Mensajes.size(); i++){
            datos[i][0] = Mensajes.get(i).getLlavePublicaEmissor();
            datos[i][1] = Mensajes.get(i).getLlavepublicaReceptor();
            datos[i][2] = Mensajes.get(i).getMensageCifrado();
            datos[i][3] = Mensajes.get(i).getFirmaDigital();
            datos[i][4] = Mensajes.get(i).hash();
            datos[i][5] = Mensajes.get(i).hasAnterior();
        }
        tablaDatos td = new tablaDatos(columnas, datos);
        td.setVisible(true);
    }//GEN-LAST:event_jbtn_verDatosActionPerformed

    private void jbtn_verApodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_verApodosActionPerformed
        String[] columnas = {
            "Apodo",
            "Direccion privada",
            "Direccion Publica"
        };
        String[][] datos = new String[NombresDirecciones.size()][3];
        for (int i = 0; i < NombresDirecciones.size(); i++)
            datos[i] = NombresDirecciones.get(i);
        tablaDatos td = new tablaDatos(columnas, datos);
        td.setVisible(true);
    }//GEN-LAST:event_jbtn_verApodosActionPerformed

    private void jbtn_verLlavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_verLlavesActionPerformed
        String[] columnas = {
            "Direccion Privada del Remitente",
            "Direccion Publica del Remitente",
            "Direccion Publica del Receptor"
        };
        String[][] datos = new String[llaves.size()][3];
        for (int i = 0; i < llaves.size(); i++)
            datos[i] = (String[])llaves.get(i);
        tablaDatos td = new tablaDatos(columnas, datos);
        td.setVisible(true);
    }//GEN-LAST:event_jbtn_verLlavesActionPerformed

    private void jbtn_verRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_verRegistrosActionPerformed
        String[] columnas = {
            "fecha",
            "registro"
        };
        String[][] datos = new String[registro.size()][2];
        for (int i = 0; i < registro.size(); i++)
            datos[i] = registro.get(i);
        tablaDatos td = new tablaDatos(columnas, datos);
        td.setVisible(true);
    }//GEN-LAST:event_jbtn_verRegistrosActionPerformed

    private void jbtn_borrarContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_borrarContenidoActionPerformed
        ObjectOutputStream  salida=null;
        try { 
            
            salida  =  new  ObjectOutputStream( 
                    new  FileOutputStream( nombreArchivo ) ) ;
            
            salida.writeChars("****THE BOSS.****");
        } catch( Exception  e ) { 
            JOptionPane.showMessageDialog(null,"Error almacenando los datos "+e.getMessage()+" -- "+e.toString()) ;
        } finally
        {
            try{
                salida.close();
            } catch(Exception e){
               JOptionPane.showMessageDialog(null,"Error cerrando ") ;             
            }
        } 
    }

    private void Recuperar() {
        LinkedList<String[]>    aux1 = new LinkedList<>();
        LinkedList<Mensaje>     aux2 = new LinkedList<>();
        LinkedList<String[]>    aux3 = new LinkedList<>();
        LinkedList<String[]>    aux4 = new LinkedList<>();
        ObjectInputStream  entrada=null;
        try{
            // lectura de datos
            entrada  =   new  ObjectInputStream( 
                    new  FileInputStream( nombreArchivo ) ) ;
     
            aux1 = (LinkedList<String[]>)   entrada.readObject();
            aux2 = (LinkedList<Mensaje>)    entrada.readObject();
            aux3 = (LinkedList<String[]>)   entrada.readObject();
            aux4 = (LinkedList<String[]>)   entrada.readObject();
            NombresDirecciones.clear();
            Mensajes.clear();
            for (String[] obj: aux1)
                NombresDirecciones.add(obj);
            for (Mensaje obj : aux2)            
                Mensajes.add(obj);
            for (String[] obj : aux3)
                llaves.add(obj);
            for (String[] obj : aux4)
                registro.add(obj);
            //JOptionPane.showMessageDialog(null, "Datos recuperados Sactisfactoriamente.");
        } catch( IOException | ClassNotFoundException  e ) { 
            JOptionPane.showMessageDialog(null,"Error recuperando los datos "+e.getMessage()+" -- "+e.toString()) ;
        } finally
        {
            try{
                entrada.close();
            } catch(Exception e){
               JOptionPane.showMessageDialog(null,"Error cerrando ") ;             
            }
        } 
    }//GEN-LAST:event_jbtn_borrarContenidoActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Tablero().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtn_borrar;
    private javax.swing.JButton jbtn_borrarContenido;
    private javax.swing.JButton jbtn_enviar;
    private javax.swing.JButton jbtn_filtrar;
    private javax.swing.JButton jbtn_limpiar;
    private javax.swing.JButton jbtn_listar;
    private javax.swing.JButton jbtn_listarTodos;
    private javax.swing.JButton jbtn_salir;
    private javax.swing.JButton jbtn_verApodos;
    private javax.swing.JButton jbtn_verDatos;
    private javax.swing.JButton jbtn_verLlaves;
    private javax.swing.JButton jbtn_verRegistros;
    private javax.swing.JTextArea jta_Reporte;
    private javax.swing.JTextArea jta_mensaje;
    private javax.swing.JTextField jtf_dirrecionPrivadaRemitente;
    private javax.swing.JTextField jtf_dirrecionPublicaRemitente;
    private javax.swing.JTextField jtf_dirrecionReceptor;
    // End of variables declaration//GEN-END:variables

    private void BuscarDireccion(String direccion) {
        String res = "Lista de mensajes con dirrecion [" + direccion + "]";
        res = Mensajes.stream().filter((obj) -> (    obj.getLlavePublicaEmissor().equalsIgnoreCase(direccion) ||
                obj.getLlavepublicaReceptor().equalsIgnoreCase(direccion))).map((obj) -> "\n" + obj.toString()).reduce(res, String::concat);
        jta_Reporte.setText(res);
    }

    private String buscarApodo(String apodo) {
        for (String[] obj : NombresDirecciones)
           if (obj[0].equalsIgnoreCase(apodo))
               return obj[1];
        return "0";
    }

    private void limpiar() {
        jbtn_enviar.setEnabled(false);
        jtf_dirrecionReceptor.setText("");
        jtf_dirrecionPublicaRemitente.setText("");
        jtf_dirrecionPrivadaRemitente.setText("");
        jta_mensaje.setText("");
        jta_Reporte.setText("");
        jtf_dirrecionPublicaRemitente.requestFocus();
    }

    private boolean isdireccion(String direccion) {
        return Mensajes.stream().anyMatch((obj) -> (    obj.getLlavePublicaEmissor().equalsIgnoreCase(direccion) ||
                obj.getLlavepublicaReceptor().equalsIgnoreCase(direccion)));
    }

    private void activarDesactivarEnviar() {
        jbtn_enviar.setEnabled(!(jtf_dirrecionReceptor.getText().isEmpty() ||
                                jtf_dirrecionPrivadaRemitente.getText().isEmpty() ||
                                jtf_dirrecionPublicaRemitente.getText().isEmpty() ||
                                jta_mensaje.getText().isEmpty())) ;
    }

    private void Almacenar() {
        ObjectOutputStream  salida=null;
        try { 
            
            salida  =  new  ObjectOutputStream( 
                    new  FileOutputStream( nombreArchivo ) ) ;
            
            salida.writeObject(NombresDirecciones);
            salida.writeObject(Mensajes);
            salida.writeObject(llaves);
            salida.writeObject(registro);
            
            //JOptionPane.showMessageDialog(null, "Datos almacenados correctamente.");
        } catch( Exception  e ) { 
            JOptionPane.showMessageDialog(null,"Error almacenando los datos "+e.getMessage()+" -- "+e.toString()) ;
        } finally
        {
            try{
                salida.close();
            } catch(Exception e){
               JOptionPane.showMessageDialog(null,"Error cerrando ") ;             
            }
        } 
    }
    
    public void generarRegistro(String text){
        LocalDate fecha = LocalDate.now();
        registro.add(new String[] {fecha.toString(),text});
        System.out.println(fecha.toString() + "  -  " + text);
    }
}
