import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;

public class AdminForm extends javax.swing.JFrame {

    // Table model used to control data inside JTable
    private DefaultTableModel model;

    // Logger (auto-generated, optional)
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(AdminForm.class.getName());

    /**
     * Constructor
     * Initializes GUI, table model, and loads users
     */
    public AdminForm() {
        initComponents();           // Build GUI first (VERY IMPORTANT)
        setLocationRelativeTo(null); // Center window

        // Create table model with column headers
        model = new DefaultTableModel(
                new Object[]{"Username", "Role", "Balance"}, 0);

        // Attach model to JTable
        jTable1.setModel(model);

        // Load users from file into table
        loadUsers();
    }

    /**
     * Reads users.txt and displays users in JTable
     */
    private void loadUsers() {
        model.setRowCount(0); // Clear table before reloading

        File file = new File("users.txt");
        if (!file.exists()) return; // Stop if file doesn't exist

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Expected format:
                // username,password,role,balance
                String[] d = line.split(",", -1);

                if (d.length >= 4) {
                    // Add row to table (password is hidden)
                    model.addRow(new Object[]{
                        d[0], // username
                        d[2], // role
                        d[3]  // balance
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading users.");
        }
    }

    /**
     * GUI builder method (NetBeans generated)
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        cmbRole = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Title label
        lblTitle.setText("USER MANAGEMENT");

        // Table placeholder (real model is set in constructor)
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {}
        ));
        scrollPane.setViewportView(jTable1);

        // Role dropdown
        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "User", "Admin" }
        ));

        // Add user button
        btnAdd.setText("Add User");
        btnAdd.addActionListener(this::btnAddActionPerformed);

        // Delete user button
        btnDelete.setText("Delete User");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        // Back button
        btnBack.setText("Cancel");
        btnBack.addActionListener(this::btnBackActionPerformed);

        // Layout configuration (auto-generated)
        javax.swing.GroupLayout layout =
                new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, 75, 75, 75)
                            .addComponent(txtUsername, 75, 75, 75)
                            .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdd)
                        .addGap(23)
                        .addComponent(btnDelete)))
                .addComponent(btnBack)
                .addGap(62))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88)
                        .addComponent(scrollPane, 278, 278, 278)))
                .addContainerGap(102))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, 166, 166, 166)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbRole)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete))
                .addContainerGap(22))
        );

        pack();
    }// </editor-fold>

    /**
     * Add new user button action
     */
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        String user = txtUsername.getText().trim();
        String pass = txtPassword.getText().trim();
        String role = cmbRole.getSelectedItem().toString();

        // Input validation
        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter username and password!");
            return;
        }

        try (FileWriter fw = new FileWriter("users.txt", true)) {
            // Default balance = 0
            fw.write(user + "," + pass + "," + role + ",0\n");
            JOptionPane.showMessageDialog(this, "User added!");
            loadUsers(); // Refresh table
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding user.");
        }
    }

    /**
     * Delete selected user
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int row = jTable1.getSelectedRow();
        if (row == -1) return; // No selection

        String userToDelete = model.getValueAt(row, 0).toString();

        File input = new File("users.txt");
        File temp = new File("temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(input));
             FileWriter fw = new FileWriter(temp)) {

            String line;
            while ((line = br.readLine()) != null) {
                // Skip selected user
                if (!line.startsWith(userToDelete + ",")) {
                    fw.write(line + "\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Replace original file
        input.delete();
        temp.renameTo(input);

        loadUsers(); // Refresh table
    }

    /**
     * Close admin form
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox<String> cmbRole;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration
}
