/*
 * Principal.java
 *
 * Created on 14 de abril de 2008, 12:11
 */

package superxat;
import java.net.*;
import java.io.*;
/**
 *
 * @author  genar
 */
public class Principal extends javax.swing.JFrame {
    String nick;
    Socket conexion;
    DataInputStream entrada;
    DataOutputStream salida;
    /** Creates new form Principal */
    
    public Principal() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        taMensajes = new javax.swing.JTextArea();
        mensaje = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        tfURL = new javax.swing.JTextField();
        tfPort = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tfNick = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmServidor = new javax.swing.JMenuItem();
        jmCliente = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        taMensajes.setColumns(20);
        taMensajes.setEditable(false);
        taMensajes.setLineWrap(true);
        taMensajes.setRows(5);
        taMensajes.setAlignmentX(0.0F);
        taMensajes.setAlignmentY(0.0F);
        taMensajes.setEnabled(false);
        jScrollPane1.setViewportView(taMensajes);

        mensaje.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), null));
        mensaje.setEnabled(false);
        mensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mensajeActionPerformed(evt);
            }
        });

        tfURL.setText("localhost");
        jToolBar1.add(tfURL);

        tfPort.setText("2000");
        jToolBar1.add(tfPort);

        jButton3.setIcon(new javax.swing.ImageIcon("/home/genar/Projects/SuperXat/src/superxat/nsala.gif"));
        jButton3.setText("Crear sala");
        jButton3.setBorderPainted(false);
        jButton3.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jToolBar1.add(jButton3);

        jButton2.setIcon(new javax.swing.ImageIcon("/home/genar/Projects/SuperXat/src/superxat/esala.gif"));
        jButton2.setText("Unirse");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jToolBar1.add(jButton2);

        jToolBar1.add(tfNick);

        jButton1.setText("Cambiar apodo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToolBar1.add(jButton1);

        jMenu1.setText("Conexion");
        jmServidor.setText("Crear sala");
        jmServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmServidorActionPerformed(evt);
            }
        });

        jMenu1.add(jmServidor);

        jmCliente.setText("Unirse a sala");
        jmCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmClienteActionPerformed(evt);
            }
        });

        jMenu1.add(jmCliente);

        jMenu1.add(jSeparator1);

        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });

        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addComponent(mensaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mensaje)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

/** Cmabiamos el valor de la variable nick con el valor del textArea */
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        nick = tfNick.getText();
    }//GEN-LAST:event_jButton1ActionPerformed

/** Cambiamos el nick a  cliente y ejecutamos el metodo cliente() */
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        nick = "Cliente";
        cliente();
    }//GEN-LAST:event_jButton2ActionPerformed

/** Cambiamos el nick a servidor y ejecutamos el metodo servidor() */
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        nick = "Servidor";
        servidor();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    
/** Metodo encargado de poner el mensaje escrito en el outputStream **/    
    private void mensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mensajeActionPerformed
        try{
            salida.writeUTF("<"+nick+">:"+ mensaje.getText()+"\n");
            salida.flush();
        }catch(IOException e){
            System.out.println("Error al mandar el texto");
        }
        mensaje.setText("");
    }//GEN-LAST:event_mensajeActionPerformed

    private void jmClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmClienteActionPerformed
        cliente();
    }//GEN-LAST:event_jmClienteActionPerformed

    private void jmServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmServidorActionPerformed
        servidor();
    }//GEN-LAST:event_jmServidorActionPerformed
    /** 
     * Ejecuta los metodos necesarios para ejecutar el servidor y crear un
     * cliente que se conecte al mismo servidor
     */
    public void servidor(){
        
        int port = Integer.parseInt(tfPort.getText());
        new Servidor(port);
        cliente();
        mensaje.setEnabled(true);
        taMensajes.setEnabled(true);
        jmCliente.setVisible(false);
    }
    
    /** 
     * Ejecuta los metodos necesarios para realizar la conexion como cliente
     * 
     */
    public void cliente(){
        
        int port = Integer.parseInt(tfPort.getText());
            try{
                conexion = new Socket(tfURL.getText(),port);
                entrada = new DataInputStream(conexion.getInputStream());
                salida = new DataOutputStream(conexion.getOutputStream());
                System.out.println("Conectado correctamente");
            }catch(IOException e){
                System.out.println("error a la hora de conectar");
            }
        new escucharMensajes();
        mensaje.setEnabled(true);
        taMensajes.setEnabled(true);
        jmServidor.setVisible(false);
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem jmCliente;
    private javax.swing.JMenuItem jmServidor;
    private javax.swing.JTextField mensaje;
    private javax.swing.JTextArea taMensajes;
    private javax.swing.JTextField tfNick;
    private javax.swing.JTextField tfPort;
    private javax.swing.JTextField tfURL;
    // End of variables declaration//GEN-END:variables
    
    public class escucharMensajes extends Thread{
        
        escucharMensajes(){
            super();
            start();
        }
        
        
        @Override
        public void run(){
            recibirMensajes();
        }
        
        
        /** 
         * Metodo que lee infinitamente la entrada y la añade al text area 
         **/
        synchronized void recibirMensajes(){
            while(true){
                try{
                    String mens = entrada.readUTF();
                    taMensajes.append(mens);
                    
                    System.out.println("Se ha recibido: "+ mens);
                }catch(IOException e){
                    System.out.println("Error al leer mensajes");
                }
            }
        }
    }
}