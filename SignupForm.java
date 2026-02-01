import javax.swing.*;
import java.io.*;

public class SignupForm extends javax.swing.JFrame {
    
    // Logger for debugging and error tracking
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SignupForm.class.getName());

    // Constructor: initializes the form and centers it on the screen
    public SignupForm() {
         initComponents();       // Initialize Swing components (labels, textfields, buttons)
        setLocationRelativeTo(null); // Center the frame on the screen
    }
    
    @SuppressWarnings("unchecked")
    // Method to initialize GUI components
    private void initComponents() {

        // Labels for the form
        lblTitle = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        lblAnswer = new javax.swing.JLabel();

        // Text fields for username, password, and security answer
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtAnswer = new javax.swing.JTextField();

        // Combo boxes for role and security question
        cmbRole = new javax.swing.JComboBox<>();
        cmbQuestion = new javax.swing.JComboBox<>();

        // Button to create account
        btnCreate = new javax.swing.JButton();

        // Set frame close operation
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Set the title label
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 28));
        lblTitle.setText("CREATE ACCOUNT");

        // Set the field labels
        lblUser.setText("Username");
        lblPass.setText("Password");
        lblRole.setText("Role");
        lblQuestion.setText("Security Question");
        lblAnswer.setText("Security Answer");

        // Set combo box options
        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));
        cmbQuestion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "What is your favorite color?", 
            "What is your pet's name?", 
            "What city were you born in?", 
            "What is your favorite food?" 
        }));

        // Button action: create account when clicked
        btnCreate.setText("Create");
        btnCreate.addActionListener(this::btnCreateActionPerformed);

        // Optional: handle enter key for security answer
        txtAnswer.addActionListener(this::txtAnswerActionPerformed);

        // Layout setup (drag-and-drop style)
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(lblTitle)
                .addGap(0, 116, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUser)
                            .addComponent(lblPass)
                            .addComponent(lblRole)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblQuestion)
                            .addComponent(lblAnswer))))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCreate)
                .addGap(64, 64, 64))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPass))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole)
                    .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnswer)
                    .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCreate)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack(); // Pack all components neatly
    }

    // Action performed when "Create" button is clicked
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // Get input values
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();
        String role = cmbRole.getSelectedItem().toString();
        String question = cmbQuestion.getSelectedItem().toString();
        String answer = txtAnswer.getText().trim();

        // Validate inputs
        if (username.isEmpty() || password.isEmpty() || answer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        // Check if username already exists
        if (usernameExists(username)) {
            JOptionPane.showMessageDialog(this, "Username already exists!");
            return;
        }

        // Save new user to users.txt
        try (PrintWriter pw = new PrintWriter(new FileWriter("users.txt", true))) {
            pw.println(username + "," + password + "," + role + ",0," + question + "," + answer);
            JOptionPane.showMessageDialog(this, "Account created!");
            new LoginForm().setVisible(true); // Open login form
            dispose(); // Close signup form
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving account");
        }
    }                                         

    // Optional: handle enter key in answer field
    private void txtAnswerActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // Currently does nothing, can trigger create action
    }                                         

    // Check if username already exists in users.txt
    private boolean usernameExists(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equalsIgnoreCase(username)) {
                    return true; // Username found
                }
            }
        } catch (Exception e) {
            // Ignore exceptions
        }
        return false; // Username not found
    }

    // Variables declaration
    private javax.swing.JButton btnCreate;           // Button to create account
    private javax.swing.JComboBox<String> cmbQuestion; // ComboBox for security question
    private javax.swing.JComboBox<String> cmbRole;     // ComboBox for role (User/Admin)
    private javax.swing.JLabel lblAnswer;             // Label for security answer
    private javax.swing.JLabel lblPass;               // Label for password
    private javax.swing.JLabel lblQuestion;           // Label for security question
    private javax.swing.JLabel lblRole;               // Label for role
    private javax.swing.JLabel lblTitle;              // Label for title
    private javax.swing.JLabel lblUser;               // Label for username
    private javax.swing.JTextField txtAnswer;         // TextField for security answer
    private javax.swing.JTextField txtPassword;       // TextField for password
    private javax.swing.JTextField txtUsername;       // TextField for username
}
