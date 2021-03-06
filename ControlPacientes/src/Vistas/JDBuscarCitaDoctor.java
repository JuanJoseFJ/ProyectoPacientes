/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Cita;
import static Vistas.JDAgregarCita.jtPaciente;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class JDBuscarCitaDoctor extends javax.swing.JDialog {

    /**
     * Creates new form JDBuscarCita
     */
    
    //-------------creacion de la variable tipo tabla para PACIENTES-----------
    
    DefaultTableModel modeloCitasPacientes;
    
    //----------------------------------------------------------     
    
    public JDBuscarCitaDoctor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        //--------------inicializacion del disenio de la tabla----------------
        modeloCitasPacientes = new DefaultTableModel(); //le asignamos todas las funciones al modelo
        jtCitasPaciente.setModel(modeloCitasPacientes); //le asignamos a la tabla el modelo que creamos
        String Titulos1[] = {"No." ,"Apellidos Paciente", "Nombre Paciente", "Hora de la cita"}; //creamos una variable con el nombre que queremos para la tabla
        modeloCitasPacientes.setColumnIdentifiers(Titulos1); //le asignamos al modelo el nombre que creamos en la linea anterior
        //-------------------------------------------------------------------         
        
        //---------------------para que al ejecutar esta clase liste de una vez los doctores actuales--------------------------
        Cita nuevoListar = new Cita();
        nuevoListar.ColocarDoctoresCBX(cbxDoctores);
        //---------------------------------------------------------------------------------------------------------------------
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCitasPaciente = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        cbxDoctores = new javax.swing.JComboBox<>();
        JDFechaBuscadaDoctor = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("BUSCAR CITAS POR DOCTOR");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 24, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Seleccione un Doctor:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 107, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Fecha:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 171, -1, -1));

        jtCitasPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "Apellidos Paciente", "Nombre Paciente", "Hora de la cita"
            }
        ));
        jScrollPane1.setViewportView(jtCitasPaciente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 325, 550, 173));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 240, 169, 44));

        getContentPane().add(cbxDoctores, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 104, 185, 32));
        getContentPane().add(JDFechaBuscadaDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 171, 198, 22));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/OMS3.1.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 440, 450));

        btnRegresar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Regresar.jpg"))); // NOI18N
        btnRegresar1.setText("Volver");
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 540, 100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(JDFechaBuscadaDoctor.getDate()==null)//si no se ingreso una fecha 
        {
            JOptionPane.showMessageDialog(null, "ERROR: ingrese una fecha para buscar las citas");
            
            //solo para limpiar la tabla 
            Cita nuevaLimpieza = new Cita();
            nuevaLimpieza.limpiarTabla(modeloCitasPacientes);            
        }
        else //si ya ingreso una fecha 
        {
            //asignacion de los datos a una variable tipo fecha
            Date fecha = JDFechaBuscadaDoctor.getDate();
              
            //creacion de un formato de fecha que se quiera objtener
            SimpleDateFormat formato = new SimpleDateFormat("d/MM/yyyy");            
            
            Cita nuevaBusqueda = new Cita();//creamos un objeto 
            nuevaBusqueda.BuscarCitaDoc(cbxDoctores.getSelectedItem().toString(), formato.format(fecha), modeloCitasPacientes);  //enviamos los parametros requeridos
                            //ojo que para obtener el dado seleccionado del combobox es diferente            
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnRegresar1ActionPerformed

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
            java.util.logging.Logger.getLogger(JDBuscarCitaDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDBuscarCitaDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDBuscarCitaDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDBuscarCitaDoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDBuscarCitaDoctor dialog = new JDBuscarCitaDoctor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDFechaBuscadaDoctor;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JComboBox<String> cbxDoctores;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtCitasPaciente;
    // End of variables declaration//GEN-END:variables
}
