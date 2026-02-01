import javax.swing.*;
import java.io.*;

public class DepositForm extends javax.swing.JFrame {

    // Stores the currently logged-in username
    String username;

    // Logger for error logging
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(DepositForm.class.getName());

    // Constructor receives username from Dashboard
    public DepositForm(String username) {
        this.username = username; // assign logged-in user
        initComponents();         // initialize GUI
        setLocationRelativeTo(null); // center the form
    }

    @SuppressWarnings("unchecked")
    // Auto-generated Swing GUI code
    private void initComponents() {

        // GUI components
        lblTitle = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        btnDeposit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Title label
        lblTitle.setText("DEPOSIT");

        // Amount label
        lblAmount.setText("Amount");

        // Deposit button action
        btnDeposit.setText("Deposit");
        btnDeposit.addActionListener(this::btnDepositActionPerformed);

        // Cancel button action
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(this::btnCancelActionPerformed);

        // Layout settings (auto-generated)
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancel))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeposit)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(192, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTitle)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAmount)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE,
                                  javax.swing.GroupLayout.DEFAULT_SIZE,
                                  javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeposit)
                    .addComponent(btnCancel))
                .addGap(158, 158, 158))
        );

        pack(); // Adjust window size
    }

    // Deposit button logic
    private void btnDepositActionPerformed(java.awt.event.ActionEvent evt) {

        // Convert input text to double
        double amount = Double.parseDouble(txtAmount.getText());

        // Update user's balance
        updateBalance(amount);

        // Save transaction record
        saveTransaction("Deposit", amount, "Cash deposit");

        // Success message
        JOptionPane.showMessageDialog(this, "Deposit successful");

        // Close the form
        dispose();
    }

    // Updates balance in users.txt file
    private void updateBalance(double amt) {

        File input = new File("users.txt"); // original file
        File temp = new File("temp.txt");   // temporary file

        try (BufferedReader br = new BufferedReader(new FileReader(input));
             FileWriter fw = new FileWriter(temp)) {

            String line;

            // Read each user record
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                // If username matches, update balance
                if (d[0].equals(username)) {
                    double newBal = Double.parseDouble(d[3]) + amt;
                    fw.write(d[0] + "," + d[1] + "," + d[2] + "," + newBal + "\n");
                } else {
                    // Write unchanged user data
                    fw.write(line + "\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Replace old file with updated file
        input.delete();
        temp.renameTo(input);
    }

    // Saves transaction history in transactions.txt
    private void saveTransaction(String type, double amt, String details) {
        try (FileWriter fw = new FileWriter("transactions.txt", true)) {

            // Get current date and time
            String date = java.time.LocalDateTime.now()
                    .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            // Write transaction in CSV format
            fw.write(username + "," + date + "," + type + "," +
                     String.format("%.2f", amt) + "," + details + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Cancel button closes the form
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    public static void main(String args[]) {
        // Look and Feel setup (optional)
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeposit;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtAmount;
}
