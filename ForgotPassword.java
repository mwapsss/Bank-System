import javax.swing.*;
import java.io.*;

public class ForgotPasswordForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ForgotPasswordForm.class.getName());

    public ForgotPasswordForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblNewPass = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setText("FORGOT PASSWORD");

        lblUser.setText("Username");

        lblNewPass.setText("New Password");

        btnReset.setText("Reset Password");
        btnReset.addActionListener(this::btnResetActionPerformed);

        btnBack.setText("Back To Login");
        btnBack.addActionListener(this::btnBackActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(lblUser))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(lblNewPass)))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btnBack)
                        .addGap(32, 32, 32)
                        .addComponent(btnReset)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblTitle)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewPass)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnReset))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {                                         
           String user = txtUsername.getText();
        String newPass = new String(txtNewPassword.getText());

        File input = new File("users.txt");
        File temp = new File("temp.txt");
        boolean found = false;

        try (
            BufferedReader br = new BufferedReader(new FileReader(input));
            FileWriter fw = new FileWriter(temp)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d[0].equals(user)) {
                    fw.write(d[0] + "," + newPass + "," + d[2] + "," + d[3] + "\n");
                    found = true;
                } else {
                    fw.write(line + "\n");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error processing file");
        }

        if (found) {
            input.delete();
            temp.renameTo(input);
            JOptionPane.showMessageDialog(this, "Password reset successful");
            new LoginForm().setVisible(true);
            dispose();
        } else {
            temp.delete();
            JOptionPane.showMessageDialog(this, "Username not found");
        }
    }                                        

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {                                        
       new LoginForm().setVisible(true);
        dispose();
    }                                       

    public static void main(String args[]) {
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> new ForgotPasswordForm().setVisible(true));
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblNewPass;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtNewPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration                   
}
