import javax.swing.*;
import java.io.*;

public class LoginForm extends javax.swing.JFrame {
    
    // Logger for debugging and error tracking
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginForm.class.getName());

    // Constructor: initializes the form and centers it on the screen
    public LoginForm() {
         initComponents();       // Initialize Swing components (buttons, labels, textfields)
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    @SuppressWarnings("unchecked")
    // This method initializes all the GUI components
    private void initComponents() {

        // Main panel to hold all components
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

        // Customize main panel
        mainPanel.setBackground(new java.awt.Color(249, 253, 255)); // Light background
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        // Title label
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 36)); // Large font
        lblTitle.setText("BANK SYSTEM");

        // Username label
        lblUser.setFont(new java.awt.Font("Segoe UI Black", 0, 18));
        lblUser.setText("Username");

        // Password label
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18));
        jLabel1.setText("Password");

        // Username text field
        txtUsername.setFont(new java.awt.Font("Segoe UI Black", 0, 18));

        // Login button
        btnLogin.setBackground(new java.awt.Color(37, 99, 235)); // Blue color
        btnLogin.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14));
        btnLogin.setText("Login");
        btnLogin.addActionListener(this::btnLoginActionPerformed); // Call login method when clicked

        // Signup button
        btnSignup.setBackground(new java.awt.Color(37, 99, 235));
        btnSignup.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14));
        btnSignup.setText("Signup");
        btnSignup.addActionListener(this::btnSignupActionPerformed); // Open signup form

        // Forgot password button
        btnForgot.setBackground(new java.awt.Color(37, 99, 235));
        btnForgot.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14));
        btnForgot.setText("Forgot Password");
        btnForgot.addActionListener(this::btnForgotActionPerformed); // Open forgot password form

        // Layout for main panel (drag-and-drop style)
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
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))))
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

        // Layout for the frame itself
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

        pack(); // Pack all components neatly
    }

    // Action performed when login button is clicked
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            boolean found = false;

            // Loop through users.txt to check credentials
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d[0].equals(txtUsername.getText()) &&
                    d[1].equals(new String(txtPassword.getPassword()))) {

                    found = true;
                    new Dashboard(d[0], d[2]).setVisible(true); // Open dashboard
                    dispose(); // Close login form
                    break;
                }
            }

            if (!found)
                JOptionPane.showMessageDialog(this, "Invalid login!"); // Show error if user/pass not found

        } catch (Exception e) {
            e.printStackTrace(); // Print errors
        }
    }

    // Action performed when signup button is clicked
    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {
         new SignupForm().setVisible(true); // Open signup form
        dispose();
    }

    // Action performed when forgot password button is clicked
    private void btnForgotActionPerformed(java.awt.event.ActionEvent evt) {
       new ForgotPasswordForm().setVisible(true); // Open forgot password form
        dispose();
    }

    // Main method: entry point of the program
    public static void main(String args[]) {
        try {
            // Set Nimbus look and feel (optional)
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Show the login form
        java.awt.EventQueue.invokeLater(() -> new LoginForm().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton btnForgot;       // Forgot password button
    private javax.swing.JButton btnLogin;        // Login button
    private javax.swing.JButton btnSignup;       // Signup button
    private javax.swing.JLabel jLabel1;          // Password label
    private javax.swing.JLabel lblTitle;         // Main title label
    private javax.swing.JLabel lblUser;          // Username label
    private javax.swing.JPanel mainPanel;        // Main panel
    private javax.swing.JPasswordField txtPassword; // Password field
    private javax.swing.JTextField txtUsername;     // Username field
}
