/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Medico;

import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author CRISTIAN
 */
public class JDagregar extends javax.swing.JDialog {

    /**
     * Creates new form JDagregar
     */
    public JDagregar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(479, 430);
        this.setTitle("Agregar Medico");
    }
    
    public void Limpiar()
        {
            nombre.setText("");
            apellido.setText("");
            direccion.setText("");
            telefono.setText("");
            colegiado.setText("");
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbl5 = new javax.swing.JLabel();
        colegiado = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/OMS3.1.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(27, 54, 50, 14);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Apellido: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(27, 111, 60, 14);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Dirección:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(27, 184, 60, 14);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Teléfono:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(27, 264, 60, 14);

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreKeyPressed(evt);
            }
        });
        getContentPane().add(nombre);
        nombre.setBounds(107, 51, 168, 20);

        direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                direccionKeyPressed(evt);
            }
        });
        getContentPane().add(direccion);
        direccion.setBounds(107, 181, 168, 20);

        apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                apellidoKeyPressed(evt);
            }
        });
        getContentPane().add(apellido);
        apellido.setBounds(107, 112, 168, 20);

        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                telefonoKeyPressed(evt);
            }
        });
        getContentPane().add(telefono);
        telefono.setBounds(107, 258, 168, 20);

        jLabel5.setFont(new java.awt.Font("AR JULIAN", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setText("Ingresar Médico");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(130, 1, 200, 30);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AgregarBoton.jpg"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        btnAgregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregarKeyPressed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(240, 370, 100, 25);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Regresar.jpg"))); // NOI18N
        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(100, 370, 100, 23);

        lbl5.setBackground(new java.awt.Color(51, 255, 255));
        lbl5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl5.setText("No. Colegiado:");
        getContentPane().add(lbl5);
        lbl5.setBounds(18, 326, 80, 14);

        colegiado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                colegiadoKeyPressed(evt);
            }
        });
        getContentPane().add(colegiado);
        colegiado.setBounds(108, 323, 167, 20);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/OMS3.1.png"))); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 432, Short.MAX_VALUE)
                .addGap(137, 137, 137))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 440, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Medico med = new Medico(apellido.getText(), nombre.getText(), direccion.getText(), telefono.getText(), colegiado.getText());
        String apellido = this.apellido.getText();
        String nombre = this.nombre.getText();
        String direccion = this.direccion.getText();
        String telefono = this.telefono.getText();
        String colegiado = this.colegiado.getText();
        if(apellido.length()==0||nombre.length()==0||direccion.length()==0||telefono.length()==0||colegiado.length()==0)
        {
            JOptionPane.showMessageDialog(null, "Los registros no pueden estar vacios\nPor favor llene los registros", "Advertencia", JOptionPane.WARNING_MESSAGE);
            this.nombre.requestFocus();
        }
        else
        {
            if(apellido.length()>50||nombre.length()>50||direccion.length()>50||telefono.length()>12||colegiado.length()>50)
            {
                JOptionPane.showMessageDialog(null, "El numero de caracteres en los registros es mayor al permitido\nNombre, Apellido, Direccion y Colegiado no pueden ser mayor a 50 caracteres\nTelefono no puede ser mayor a 12", "Advertencia", JOptionPane.WARNING_MESSAGE);
                this.nombre.requestFocus();
            }
            else
            {
                Icon i = new ImageIcon(getClass().getResource("/Imagenes/Aceptar.jpg"));
                JOptionPane.showMessageDialog(null, med.AgregarMedico(med),"Mensaje",JOptionPane.INFORMATION_MESSAGE, i);
                Limpiar();
                this.nombre.requestFocus();
            }
        }
        
//Validacion val = new Validacion (); 
//val.ValidarMedico(apellido.getText(), nombre.getText(), direccion.getText(), telefono.getText());
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
this.hide();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.apellido.requestFocus();
        }
    }//GEN-LAST:event_nombreKeyPressed

    private void apellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.direccion.requestFocus();
        }
    }//GEN-LAST:event_apellidoKeyPressed

    private void direccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccionKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            this.telefono.requestFocus();
        }
    }//GEN-LAST:event_direccionKeyPressed

    private void telefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
         this.colegiado.requestFocus();
        }
    }//GEN-LAST:event_telefonoKeyPressed

    private void colegiadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_colegiadoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            btnAgregar.requestFocus(true);
        }
    }//GEN-LAST:event_colegiadoKeyPressed

    private void btnAgregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
         Medico med = new Medico(apellido.getText(), nombre.getText(), direccion.getText(), telefono.getText(), colegiado.getText());
        String apellido = this.apellido.getText();
        String nombre = this.nombre.getText();
        String direccion = this.direccion.getText();
        String telefono = this.telefono.getText();
        String colegiado = this.colegiado.getText();
        if(apellido.length()==0||nombre.length()==0||direccion.length()==0||telefono.length()==0||colegiado.length()==0)
        {
            JOptionPane.showMessageDialog(null, "Los registros no pueden estar vacios\nPor favor llene los registros", "Advertencia", JOptionPane.WARNING_MESSAGE);
            this.nombre.requestFocus();
        }
       
        else
        {
            if(apellido.length()>50||nombre.length()>50||direccion.length()>50||telefono.length()>12||colegiado.length()>50)
            {
                JOptionPane.showMessageDialog(null, "El numero de caracteres en los registros es mayor al permitido\nNombre, Apellido, Direccion y Colegiado no pueden ser mayor a 50 caracteres\nTelefono no puede ser mayor a 12", "Advertencia", JOptionPane.WARNING_MESSAGE);
                this.nombre.requestFocus();
            }
            else
            {
                Icon i = new ImageIcon(getClass().getResource("/Imagenes/Aceptar.jpg"));
                JOptionPane.showMessageDialog(null, med.AgregarMedico(med),"Mensaje",JOptionPane.INFORMATION_MESSAGE, i);
                this.nombre.requestFocus();
            }
            
        }
        
        }
        nombre.setText("");
        apellido.setText("");
        direccion.setText("");
        telefono.setText("");
        colegiado.setText("");
    }//GEN-LAST:event_btnAgregarKeyPressed

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
            java.util.logging.Logger.getLogger(JDagregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDagregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDagregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDagregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDagregar dialog = new JDagregar(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField apellido;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JTextField colegiado;
    private javax.swing.JTextField direccion;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl5;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
