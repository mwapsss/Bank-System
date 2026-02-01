import javax.swing.*;
import java.io.*;

public class ForgotPasswordForm extends javax.swing.JFrame {

    // Logger for debugging and error tracking
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ForgotPasswordForm.class.getName());

    // Constructor: initializes the form and centers it
    public ForgotPasswordForm() {
        initComponents(); // Initialize GUI components (labels, textfields, buttons)

        // Security question field should not be editable by user
        txtShowQuestion.setEditable(false);
        txtShowQuestion.setFocusable(false);

        setLocationRelativeTo(null); // Center the frame on the screen
    }

    @SuppressWarnings("unchecked")
    // Method to initialize GUI components
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblNewPass = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblQuestion = new javax.swing.JLabel();
        lblAnswer = new javax.swing.JLabel();
        txtShowQuestion = new javax.swing.JTextField();
        txtAnswer = new javax.swing.JTextField();

        jLabel1.setText("jLabel1"); // Unused placeholder label

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setText("FORGOT PASSWORD"); // Title of the form
        lblUser.setText("Username");          // Label for username input
        lblNewPass.setText("New Password");   // Label for new password input
        lblQuestion.setText("Security Question"); // Label for security question
        lblAnswer.setText("Security Answer");     // Label for answer to security question

        // Username field: when focus is lost, load security question
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });
        txtUsername.addActionListener(this::txtUsernameActionPerformed); // Also triggered on Enter

        // Reset button: perform password reset
        btnReset.setText("Reset Password");
        btnReset.addActionListener(this::btnResetActionPerformed);

        // Back button: go back to login form
        btnBack.setText("Cancel");
        btnBack.addActionListener(this::btnBackActionPerformed);

        // Security question field: read-only
        txtShowQuestion.setEditable(false);
        txtShowQuestion.addActionListener(this::txtShowQuestionActionPerformed);

        // Layout setup (drag-and-drop style)
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(lblTitle)
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(lblUser)
                    .addComponent(lblQuestion)
                    .addComponent(lblAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNewPass))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNewPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAnswer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(154, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtShowQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(btnReset)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestion)
                    .addComponent(txtShowQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnswer)
                    .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewPass)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnBack))
                .addGap(37, 37, 37))
        );

        pack(); // Adjust component sizes
    }

    // Reset button action: verifies security answer and updates password
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
        String user = txtUsername.getText().trim();       // Get username input
        String newPass = txtNewPassword.getText().trim(); // Get new password input
        String answerInput = txtAnswer.getText().trim();  // Get security answer input

        // Validate that all fields are filled
        if (user.isEmpty() || newPass.isEmpty() || answerInput.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        File input = new File("users.txt");
        File temp = new File("temp.txt");
        boolean reset = false; // Flag to indicate successful reset

        try (
            BufferedReader br = new BufferedReader(new FileReader(input));
            PrintWriter pw = new PrintWriter(new FileWriter(temp))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",", -1); // Split by comma, keep empty fields

                if (d.length < 6) continue; // Skip invalid records

                if (d[0].equalsIgnoreCase(user)) { // Match username
                    // Verify security answer
                    if (!d[5].equalsIgnoreCase(answerInput)) {
                        JOptionPane.showMessageDialog(this, "Incorrect security answer");
                        temp.delete();
                        return;
                    }

                    // Rewrite full record with new password
                    pw.println(d[0] + "," + newPass + "," + d[2] + "," + d[3] + "," + d[4] + "," + d[5]);
                    reset = true;

                } else {
                    // Keep other users unchanged
                    pw.println(line);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error processing file");
            return;
        }

        // Finalize changes if password reset succeeded
        if (reset) {
            input.delete();        // Delete original file
            temp.renameTo(input);  // Rename temp file to original
            JOptionPane.showMessageDialog(this, "Password reset successful!");
            new LoginForm().setVisible(true); // Return to login
            dispose(); // Close this form
        } else {
            temp.delete(); // Cleanup
            JOptionPane.showMessageDialog(this, "Username not found");
        }
    }

    // Back button action: go back to login form
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        new LoginForm().setVisible(true);
        dispose();
    }

    // Triggered when security question field is interacted
    private void txtShowQuestionActionPerformed(java.awt.event.ActionEvent evt) {
        loadSecurityQuestion();
    }

    // Triggered when username field loses focus
    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {
        loadSecurityQuestion();
    }

    // Triggered when username field enter key pressed
    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {
        loadSecurityQuestion();
    }

    // Load security question for the entered username
    private void loadSecurityQuestion() {
        String user = txtUsername.getText().trim();
        txtShowQuestion.setText(""); // Clear previous question

        if (user.isEmpty()) return;

        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",", -1);
                if (d.length >= 6 && d[0].equalsIgnoreCase(user)) {
                    txtShowQuestion.setText(d[4]); // Set security question
                    return;
                }
            }
        } catch (Exception e) {
            // Ignore errors while loading
        }
    }

    // Variables declaration
    private javax.swing.JButton btnBack;          // Cancel / go back button
    private javax.swing.JButton btnReset;         // Reset password button
    private javax.swing.JLabel jLabel1;           // Placeholder label (unused)
    private javax.swing.JLabel lblAnswer;         // Label for security answer
    private javax.swing.JLabel lblNewPass;        // Label for new password
    private javax.swing.JLabel lblQuestion;       // Label for security question
    private javax.swing.JLabel lblTitle;          // Form title
    private javax.swing.JLabel lblUser;           // Label for username
    private javax.swing.JTextField txtAnswer;     // Input for security answer
    private javax.swing.JTextField txtNewPassword; // Input for new password
    private javax.swing.JTextField txtShowQuestion; // Read-only security question
    private javax.swing.JTextField txtUsername;     // Input for username
}
