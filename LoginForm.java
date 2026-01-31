import javax.swing.*;
import java.io.*;

public class LoginForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginForm.class.getName());

    public LoginForm() {
         initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnSignup = new javax.swing.JButton();
        btnForgot = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(249, 253, 255));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblTitle.setText("BANK SYSTEM");

        lblUser.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblUser.setText("Username");

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setText("Password");

        txtUsername.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N

        btnLogin.setBackground(new java.awt.Color(37, 99, 235));
        btnLogin.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        btnSignup.setBackground(new java.awt.Color(37, 99, 235));
        btnSignup.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnSignup.setText("Signup");
        btnSignup.addActionListener(this::btnSignupActionPerformed);

        btnForgot.setBackground(new java.awt.Color(37, 99, 235));
        btnForgot.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnForgot.setText("Forgot Password");
        btnForgot.addActionListener(this::btnForgotActionPerformed);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnForgot))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap(94, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogin)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(79, 79, 79))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitle)
                .addGap(41, 41, 41)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addComponent(btnLogin)
                .addGap(41, 41, 41)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnForgot)
                    .addComponent(btnSignup))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d[0].equals(txtUsername.getText()) &&
                    d[1].equals(new String(txtPassword.getPassword()))) {

                    found = true;
                    new Dashboard(d[0], d[2]).setVisible(true);
                    dispose();
                    break;
                }
            }

            if (!found)
                JOptionPane.showMessageDialog(this, "Invalid login!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }                                        

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {                                          
         new SignupForm().setVisible(true);
        dispose();
    }                                         

    private void btnForgotActionPerformed(java.awt.event.ActionEvent evt) {                                          
       new ForgotPasswordForm().setVisible(true);
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
        java.awt.EventQueue.invokeLater(() -> new LoginForm().setVisible(true));
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnForgot;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration                   
}
