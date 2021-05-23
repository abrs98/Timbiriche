/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timbiriche;

import DataTransferObjects.DataMensaje;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Jugador;
import objetosNegocio.Scorer;
import utileria.IActualizable;
import Cliente.Cliente;
import Cliente.ICliente;

/**
 *
 * @author Abrahan Barrios
 */
public class FrmSalaEspera extends javax.swing.JFrame implements IActualizable {

    /**
     * Creates new form FrmSalaEspera
     */
    private Jugador jugador;
    private String ip;
    private int port;
    private static FrmSalaEspera instance;
    private ICliente sck;
    private int jugadoresDibujados = 0;
    private String colores[];
    DefaultTableModel modelo2;

    private FrmSalaEspera() {
        initComponents();
        this.setSize(540, 400);
        this.setLocationRelativeTo(null);
        this.setTitle("Sala de espera. Un momento");
        this.sck = new Cliente(jugador, this);
    }

    public static FrmSalaEspera getInstance() {
        if (instance == null) {
            instance = new FrmSalaEspera();
        }
        return instance;
    }

    public String[] getColores() {
        return colores;
    }

    public void setColores(String[] colores) {
        this.colores = colores;
    }

    public boolean ejecutarConexion(Jugador jugador, String ip, int port) {
        this.jugador = jugador;
        this.ip = ip;
        this.port = port;

        if (sck.conectarAlServidor(this.ip, this.port)) {
            System.out.println("Conectado con exito");
            sck.enviarAlServidor(this.jugador);
            sck.escucharAlServidor();
            return true;
        } else {
            System.out.println("No se pudo conectar con el servidor");
            return false;
        }
    }

    public void recibirMensaje(String mensaje) {
        txtMensajes.setText(mensaje);
        txtMensajes.revalidate();
        validate();
    }
    
    private void CrearModelo() {
        try {
            modelo2 = (new DefaultTableModel(
                    null, new String[]{
                        "Numero", "Nombre",
                        "Color"}) {
                Class[] types = new Class[]{
                    java.lang.String.class, //aqui es el tipo de columna, dejemoslo en STRING
                    java.lang.String.class,
                    java.lang.String.class,
                  
                    };
                boolean[] canEdit = new boolean[]{ //aquí decimos si podrán ser editables o no.
                    false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
            tblSala.setModel(modelo2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error");
        }
    }


    public void recibirJugadores(List<Jugador> jugadores) {

        CrearModelo();

        try {
            System.out.println("si se está ejecutando"); //mensaje para saber si se está ejecutando el método.

            Object O[] = null;


            //para buscar personas usaremos un ciclo for.
            for (int i = 0; i < jugadores.size(); i++) {
                System.out.println("" + jugadores.get(i).getNombre()); //hasta este paso, solo sale la info en consola, aun no se muestra en la tabla.
                modelo2.addRow(O); //aquí pediremos que se agregue la informacion del arreglo,
                modelo2.setValueAt((i+1), i, 0); //el numero al final 0 indica el lugar donde se mostrará en la tabla la información..
                modelo2.setValueAt(jugadores.get(i).getNombre(), i, 1);
                modelo2.setValueAt(jugadores.get(i).getColor(), i, 2);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
//        for (int i = 0; i < jugadores.size(); i++) {
//
//            Jugador jugador = jugadores.get(i);
//            int num = i + 1;
//            String nombre = jugador.getNombre();
//            String color = jugador.getColor();
//            switch (i) {
//                case 0:
//                    this.tblSala.setValueAt(num, i, 0);
//                    this.tblSala.setValueAt(nombre, i, 1);
//                    this.tblSala.setValueAt(color, i, 2);
//                    break;
//                case 1:
//                    this.tblSala.setValueAt(num, i, 0);
//                    this.tblSala.setValueAt(nombre, i, 1);
//                    this.tblSala.setValueAt(color, i, 2);
//                    break;
//                case 2:
//                    this.tblSala.setValueAt(num, i, 0);
//                    this.tblSala.setValueAt(nombre, i, 1);
//                    this.tblSala.setValueAt(color, i, 2);
//                    break;
//                case 3:
//                    this.tblSala.setValueAt(num, i, 0);
//                    this.tblSala.setValueAt(nombre, i, 1);
//                    this.tblSala.setValueAt(color, i, 2);
//                    break;
//                default:
//                    break;
//            }
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        lblSala = new javax.swing.JLabel();
        btnAtras2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSala = new javax.swing.JTable();
        lblOpcion = new javax.swing.JLabel();
        votar1 = new java.awt.Button();
        votar2 = new java.awt.Button();
        votar3 = new java.awt.Button();
        votar4 = new java.awt.Button();
        txtMensajes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sala de Espera");

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));

        lblSala.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 36)); // NOI18N
        lblSala.setForeground(new java.awt.Color(255, 255, 255));
        lblSala.setText("Sala de Espera");
        lblSala.setToolTipText("");

        btnAtras2.setBackground(new java.awt.Color(204, 204, 204));
        btnAtras2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAtras2.setForeground(new java.awt.Color(0, 51, 51));
        btnAtras2.setText("ATRAS");
        btnAtras2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtras2ActionPerformed(evt);
            }
        });

        tblSala.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"01", "Pedro", "Green"},
                {"02", "Juan", "Blue"},
                {"03", "Jose", "Yellow"},
                {"04", "Raul", null}
            },
            new String [] {
                "Jugador", "Nombre", "Color"
            }
        ));
        jScrollPane1.setViewportView(tblSala);
        if (tblSala.getColumnModel().getColumnCount() > 0) {
            tblSala.getColumnModel().getColumn(0).setResizable(false);
            tblSala.getColumnModel().getColumn(1).setResizable(false);
            tblSala.getColumnModel().getColumn(2).setResizable(false);
        }

        lblOpcion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblOpcion.setText("Opción");

        votar1.setLabel("Votar");
        votar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votar1ActionPerformed(evt);
            }
        });

        votar2.setLabel("Votar");
        votar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votar2ActionPerformed(evt);
            }
        });

        votar3.setLabel("Votar");
        votar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votar3ActionPerformed(evt);
            }
        });

        votar4.setLabel("Votar");
        votar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votar4ActionPerformed(evt);
            }
        });

        txtMensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensajesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(votar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOpcion)
                    .addComponent(votar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(votar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(votar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSala)
                .addGap(59, 59, 59))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(txtMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(btnAtras2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblSala)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblOpcion)
                        .addGap(12, 12, 12)
                        .addComponent(votar1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(votar2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(votar3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(votar4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMensajes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtras2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtras2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtras2ActionPerformed
        // TODO add your handling code here:
        FrmInicio i = new FrmInicio();
        i.setLocationRelativeTo(null);
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtras2ActionPerformed

    private void votar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votar1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Jugador ha confirmado el inicio!!!");
        sck.enviarAlServidor(DataMensaje.VOTO);
    }//GEN-LAST:event_votar1ActionPerformed

    private void votar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votar2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Jugador ha confirmado el inicio!!!");
        sck.enviarAlServidor(DataMensaje.VOTO);
    }//GEN-LAST:event_votar2ActionPerformed

    private void votar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votar3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Jugador ha confirmado el inicio!!!");
        sck.enviarAlServidor(DataMensaje.VOTO);
    }//GEN-LAST:event_votar3ActionPerformed

    private void votar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votar4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Jugador ha confirmado el inicio!!!");
        sck.enviarAlServidor(DataMensaje.VOTO);
    }//GEN-LAST:event_votar4ActionPerformed

    private void txtMensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMensajesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMensajesActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmSalaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSalaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSalaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSalaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSalaEspera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblOpcion;
    private javax.swing.JLabel lblSala;
    private javax.swing.JTable tblSala;
    private javax.swing.JTextField txtMensajes;
    private java.awt.Button votar1;
    private java.awt.Button votar2;
    private java.awt.Button votar3;
    private java.awt.Button votar4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizaDeSocket(Object mensaje) {
        if (mensaje instanceof String) {
            recibirMensaje((String) mensaje);
        } else if (mensaje instanceof List) {
            recibirJugadores((List<Jugador>) mensaje);
        } else if (mensaje instanceof Scorer) {
            FrmPartida frmSala = new FrmPartida((Scorer) mensaje, this.jugador);
            frmSala.setVisible(true);
            frmSala.setColores(colores);
            this.dispose();
        }
    }
}
