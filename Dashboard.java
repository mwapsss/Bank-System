import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
import javax.swing.Timer;

public class Dashboard extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dashboard.class.getName());

      String username, role;
      
    public Dashboard(String user, String r) {
         initComponents();

        username = user;
        role = r;

        lblWelcome.setText("Welcome " + username + " (" + role + ")");

        DecimalFormat df = new DecimalFormat("#,###.00");
        
         Timer timer = new Timer(1000, e -> {
            lblBalance.setText("Balance: ₱" + df.format(getBalance()));
        });
        timer.start();
        
         if (!role.equalsIgnoreCase("Admin")) {
            btnUsers.setVisible(false);
        }

        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
     private double getBalance() {
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d[0].equals(username)) return Double.parseDouble(d[3]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblWelcome = new javax.swing.JLabel();
        btnDeposit = new javax.swing.JButton();
        btnWithdraw = new javax.swing.JButton();
        btnTransfer = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();
        btnUsers = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblBalance = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblWelcome.setText("WELCOME");

        btnDeposit.setText("Deposit");
        btnDeposit.addActionListener(this::btnDepositActionPerformed);

        btnWithdraw.setText("Withdraw");
        btnWithdraw.addActionListener(this::btnWithdrawActionPerformed);

        btnTransfer.setText("Transfer");
        btnTransfer.addActionListener(this::btnTransferActionPerformed);

        btnHistory.setText("History");
        btnHistory.addActionListener(this::btnHistoryActionPerformed);

        btnUsers.setText("User Management");
        btnUsers.addActionListener(this::btnUsersActionPerformed);

        btnLogout.setText("Logout");
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        lblBalance.setText("Balance");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUsers)
                                    .addComponent(btnTransfer)
                                    .addComponent(btnDeposit)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnWithdraw)
                            .addComponent(btnHistory)
                            .addComponent(btnLogout)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(lblWelcome)))
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

        pack();
    }// </editor-fold>                        

    private void btnDepositActionPerformed(java.awt.event.ActionEvent evt) {                                           
         new DepositForm(username).setVisible(true);
    }                                          

    private void btnWithdrawActionPerformed(java.awt.event.ActionEvent evt) {                                            
          new WithdrawForm(username).setVisible(true);
    }                                           

    private void btnTransferActionPerformed(java.awt.event.ActionEvent evt) {                                            
        new TransferForm(username).setVisible(true);
    }                                           

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {                                           
        new HistoryForm(username).setVisible(true);
    }                                          

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {                                          
        new LoginForm().setVisible(true);
        dispose();
    }                                         

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {                                         
        new AdminForm().setVisible(true);
    }                                        

    
    public static void main(String args[]) {
        
        
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnDeposit;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnTransfer;
    private javax.swing.JButton btnUsers;
    private javax.swing.JButton btnWithdraw;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration                   
}
