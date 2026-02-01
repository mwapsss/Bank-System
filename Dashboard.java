import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
import javax.swing.Timer;

public class Dashboard extends javax.swing.JFrame {

    // Logger for debugging and error tracking
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dashboard.class.getName());

    // Store logged-in user's username and role
    String username, role;

    // Constructor: initialize dashboard for the given user and role
    public Dashboard(String user, String r) {
        initComponents(); // Initialize GUI components

        username = user; // Save username
        role = r;        // Save role (User/Admin)

        // Welcome message with username and role
        lblWelcome.setText("Welcome " + username + " (" + role + ")");

        // Format balance display to two decimal places with commas
        DecimalFormat df = new DecimalFormat("#,###.00");

        // Timer updates balance every second in case of changes
        Timer timer = new Timer(1000, e -> {
            lblBalance.setText("Balance: ₱" + df.format(getBalance()));
        });
        timer.start();

        // Hide user management button if not an admin
        if (!role.equalsIgnoreCase("Admin")) {
            btnUsers.setVisible(false);
        }

        setLocationRelativeTo(null);         // Center the frame
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Close only this frame on exit
    }

    // Get current balance of the logged-in user
    private double getBalance() {
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(","); // CSV format: username,password,role,balance,...
                if (d[0].equals(username)) return Double.parseDouble(d[3]); // return balance
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; // default balance if user not found or error occurs
    }

    @SuppressWarnings("unchecked")
    // GUI components initialization
    private void initComponents() {

        // Labels
        lblWelcome = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();

        // Buttons
        btnDeposit = new javax.swing.JButton();
        btnWithdraw = new javax.swing.JButton();
        btnTransfer = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();
        btnUsers = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Welcome label
        lblWelcome.setText("WELCOME");

        // Balance label
        lblBalance.setText("Balance");

        // Deposit button
        btnDeposit.setText("Deposit");
        btnDeposit.addActionListener(this::btnDepositActionPerformed);

        // Withdraw button
        btnWithdraw.setText("Withdraw");
        btnWithdraw.addActionListener(this::btnWithdrawActionPerformed);

        // Transfer button
        btnTransfer.setText("Transfer");
        btnTransfer.addActionListener(this::btnTransferActionPerformed);

        // History button
        btnHistory.setText("History");
        btnHistory.addActionListener(this::btnHistoryActionPerformed);

        // User management button (Admin only)
        btnUsers.setText("User Management");
        btnUsers.addActionListener(this::btnUsersActionPerformed);

        // Logout button
        btnLogout.setText("Logout");
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        // Layout setup
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    // Left side buttons: Deposit, Transfer, User Management
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUsers)
                            .addComponent(btnTransfer)
                            .addComponent(btnDeposit)))
                    // Balance label
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                // Right side buttons: Withdraw, History, Logout
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnWithdraw)
                    .addComponent(btnHistory)
                    .addComponent(btnLogout))
                .addGap(148, 148, 148))
            // Centered welcome label
            .addGroup(layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(lblWelcome)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblWelcome)
                .addGap(15, 15, 15)
                .addComponent(lblBalance)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeposit)
                    .addComponent(btnWithdraw))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTransfer)
                    .addComponent(btnHistory))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsers)
                    .addComponent(btnLogout))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack(); // Adjust component sizes
    }

    // Deposit button opens DepositForm
    private void btnDepositActionPerformed(java.awt.event.ActionEvent evt) {
        new DepositForm(username).setVisible(true);
    }

    // Withdraw button opens WithdrawForm
    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {
        new WithdrawForm(username).setVisible(true);
    }

    // Transfer button opens TransferForm
    private void btnTransferActionPerformed(java.awt.event.ActionEvent evt) {
        new TransferForm(username).setVisible(true);
    }

    // History button opens HistoryForm
    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {
        new HistoryForm(username).setVisible(true);
    }

    // Logout button returns to LoginForm
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        new LoginForm().setVisible(true);
        dispose(); // Close dashboard
    }

    // User management button opens AdminForm (Admin only)
    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {
        new AdminForm().setVisible(true);
    }

    public static void main(String args[]) {
        // Main method currently empty
    }

    // Variables declaration
    private javax.swing.JButton btnDeposit;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnTransfer;
    private javax.swing.JButton btnUsers;
    private javax.swing.JButton btnWithdraw;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblWelcome;
}
