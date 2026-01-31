import javax.swing.*;
import java.io.*;

public class DepositForm extends javax.swing.JFrame {
     String username;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DepositForm.class.getName());

    public DepositForm(String username) {
        this.username = username;
        initComponents();
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        btnDeposit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setText("DEPOSIT");

        lblAmount.setText("Amount");

        btnDeposit.setText("Deposit");
        btnDeposit.addActionListener(this::btnDepositActionPerformed);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(this::btnCancelActionPerformed);

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
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeposit)
                    .addComponent(btnCancel))
                .addGap(158, 158, 158))
        );

        pack();
    }// </editor-fold>                        

    private void btnDepositActionPerformed(java.awt.event.ActionEvent evt) {                                           
        double amount = Double.parseDouble(txtAmount.getText());
        updateBalance(amount);
        saveTransaction("Deposit", amount, "Cash deposit");
        JOptionPane.showMessageDialog(this, "Deposit successful");
        dispose();
    }

    private void updateBalance(double amt) {
        File input = new File("users.txt");
        File temp = new File("temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(input));
             FileWriter fw = new FileWriter(temp)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d[0].equals(username)) {
                    double newBal = Double.parseDouble(d[3]) + amt;
                    fw.write(d[0] + "," + d[1] + "," + d[2] + "," + newBal + "\n");
                } else fw.write(line + "\n");
            }
        } catch (Exception e) {}

        input.delete();
        temp.renameTo(input);
    }
     private void saveTransaction(String type, double amt, String details) {
    try (FileWriter fw = new FileWriter("transactions.txt", true)) {
      
        String date = java.time.LocalDateTime.now().toString();
  
        fw.write(username + "," + date + "," + type + "," + amt + "," + details + "\n");
    } catch (IOException e) {
        e.printStackTrace();
    }
    }                                          

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {                                          
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
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeposit;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtAmount;
    // End of variables declaration                   
}
