/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exchangestudentmanagementsystem;
import java.util.Date;
import java.awt.Color;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malcolm
 */
public class CreateApplicationForm extends javax.swing.JFrame {
    String createAppGender = "";
    String program = "";
    /**
     * Creates new form newApplicationForm
     */
    public CreateApplicationForm() {
        initComponents();
        getContentPane().setBackground(new Color(51,204,255));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://10.0.19.74/db_kii03486",
                    "kii03486","kii03486");  
            int username1 = Constants.usernameOnline;
            String query = "SELECT * FROM `csi473Student` WHERE `StudentID`="+username1;
           Statement myPstmt = myConn.prepareStatement(query);
           ResultSet myRs = myPstmt.executeQuery(query);
           
           Statement programs = myConn.createStatement();
           String progs = "SELECT ProgramCode FROM csi473Program";
           ResultSet rs = programs.executeQuery(progs);
           while(rs.next())
           {
               createAppProgram.addItem(rs.getString("ProgramCode"));
           }
//            
            while(myRs.next()){
               int userName = myRs.getInt("StudentID");
               String fname = myRs.getString("FirstName");
               String lname = myRs.getString("LastName");
               int credits = myRs.getInt("CreditsTaken");
               Date dob = myRs.getDate("DOB");
               String postal = myRs.getString("PostalAddress");
               String createGender = myRs.getString("Gender");
               String thisYear = new SimpleDateFormat("yyyy").format(new Date());
               
               int thisYears = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
               int doY = Integer.parseInt(new SimpleDateFormat("yyyy").format(dob));
               //int age = new SimpleDateFormat("yyyy/MM/dd") - dob;
               int age= thisYears - doY;
               
               createAppName.setText(fname+" "+lname);
               createAppDOB.setText(dob.toString());
               createAppStudID.setText(String.valueOf(userName));
               createAppPostAddr.setText(postal);
}
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StudentLogin.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gender = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        createAppName = new javax.swing.JTextField();
        createAppAge = new javax.swing.JTextField();
        createAppStudID = new javax.swing.JTextField();
        createAppDOB = new javax.swing.JTextField();
        createAppPostAddr = new javax.swing.JTextField();
        createAppMale = new javax.swing.JRadioButton();
        createAppFemale = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        createAppHostInst = new javax.swing.JTextField();
        createAppHostCountry = new javax.swing.JTextField();
        createAppFOS = new javax.swing.JTextField();
        createAppLOS = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        createAppProgram = new javax.swing.JComboBox();
        createAppSubmit = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        createAppMotivLetter = new javax.swing.JTextArea();
        createAppScroll = new javax.swing.JScrollBar();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setText("EXCHANGE STUDENT MANAGEMENT SYSTEM");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setText("PERSONAL INFORMATION");

        jLabel3.setText("Name:");

        jLabel4.setText("DOB:");

        jLabel5.setText("Age:");

        jLabel6.setText("Student ID:");

        jLabel7.setText("Postal Address:");

        jLabel8.setText("Gender:");

        createAppAge.setText(" ");
        createAppAge.setPreferredSize(new java.awt.Dimension(9, 23));

        gender.add(createAppMale);
        createAppMale.setText("M");
        createAppMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAppMaleActionPerformed(evt);
            }
        });

        gender.add(createAppFemale);
        createAppFemale.setText("F");
        createAppFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAppFemaleActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel9.setText("EDUCATIONAL BACKGROUND");

        jLabel10.setText("Host Institution:");

        jLabel11.setText("Host Country:");

        jLabel12.setText("Field of Study:");

        jLabel13.setText("Level of Study:");

        jLabel14.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel14.setText("EXCHANGE PROGRAM");

        jLabel15.setText("Select Program:");

        jLabel16.setText("Motivational Letter:");

        createAppProgram.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Program ..." }));
        createAppProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAppProgramActionPerformed(evt);
            }
        });

        createAppSubmit.setText("Submit");
        createAppSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAppSubmitActionPerformed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exchangestudentmanagementsystem/UB-logo.png"))); // NOI18N

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBar(null);

        createAppMotivLetter.setColumns(20);
        createAppMotivLetter.setRows(5);
        jScrollPane1.setViewportView(createAppMotivLetter);

        jLabel18.setText("(not more than 200 words)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancel)
                        .addGap(18, 18, 18)
                        .addComponent(createAppSubmit)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel13)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(createAppLOS))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel12)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(createAppFOS))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel11)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(createAppHostCountry))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel10)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(createAppHostInst, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(createAppProgram, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(95, 95, 95))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel16)
                                                    .addComponent(jLabel18))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel3)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(createAppName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel2))
                                                .addGap(39, 39, 39)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(createAppAge, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel4)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(createAppDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(createAppPostAddr, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(createAppStudID, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel8)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(createAppMale)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(createAppFemale)))))
                                        .addGap(18, 18, 18))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(createAppScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap(5, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {createAppName, createAppPostAddr});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(createAppAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(createAppName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(createAppStudID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(createAppDOB)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(createAppPostAddr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(createAppMale)
                                .addComponent(createAppFemale)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createAppHostInst, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createAppHostCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createAppFOS, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createAppLOS, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createAppProgram, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createAppScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createAppSubmit)
                    .addComponent(cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {createAppFOS, createAppHostCountry, createAppHostInst, createAppLOS});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {createAppAge, createAppDOB, createAppName, createAppPostAddr, createAppStudID});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void createAppSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAppSubmitActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://10.0.19.74/db_kii03486",
                    "kii03486","kii03486");  
            int username1 = Constants.usernameOnline;
            String query = "SELECT * FROM `csi473Student` WHERE `StudentID`="+username1;
           Statement myPstmt = myConn.prepareStatement(query);
           ResultSet myRs = myPstmt.executeQuery(query);
//            
            while(myRs.next()){
               int userName = myRs.getInt("StudentID");
               String fname = myRs.getString("FirstName");
               String lname = myRs.getString("LastName");
               int credits = myRs.getInt("CreditsTaken");
               Date dob = myRs.getDate("DOB");
               String hostCountry = createAppHostCountry.getText();
               String hostInstitution = createAppHostInst.getText();
               
               String postal = myRs.getString("PostalAddress");
               String createGender = myRs.getString("Gender");
               String fulName = fname +" "+lname;
               String fieldOfStudy = createAppFOS.getText();
               String levelOfStudy = createAppLOS.getText();
               String motivationalLetter = createAppMotivLetter.getText();
               String status = "Not Approved"; 
               
               //String thisYear = new SimpleDateFormat("yyyy").format(new Date());
               
               int thisYears = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
               int doY = Integer.parseInt(new SimpleDateFormat("yyyy").format(dob));
               //int age = new SimpleDateFormat("yyyy/MM/dd") - dob;
               int age= thisYears - doY;
               String sql = "INSERT INTO `csi473Application`(`Name`, `ProgramCode`, `Age`, `Gender`, `DOB`, `StudentID`, `PostalAddress`, `HostCountry`, `HostUniversity`, `FieldOfStudy`, `LevelOfStudy`, `MotivationalLetter`, `Status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
               PreparedStatement pstmt = myConn.prepareStatement(sql);
               Statement stmt = myConn.createStatement();
            pstmt.setString(1,fulName);
            pstmt.setString(2, program);
            pstmt.setInt(3, age);
            pstmt.setString(4, createAppGender);
            pstmt.setString(5, dob.toString());
            pstmt.setInt(6, userName);
            pstmt.setString(7, postal);
            pstmt.setString(8, hostCountry);
            pstmt.setString(9, hostInstitution);
            pstmt.setString(10, fieldOfStudy);
            pstmt.setString(11, levelOfStudy);
            pstmt.setString(12, motivationalLetter);
            pstmt.setString(13, status);
            pstmt.executeUpdate();
}
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StudentLogin.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_createAppSubmitActionPerformed

    private void createAppMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAppMaleActionPerformed
        createAppMale.setActionCommand("male");
        createAppGender = "M";// TODO add your handling code here:
        
    }//GEN-LAST:event_createAppMaleActionPerformed

    private void createAppFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAppFemaleActionPerformed
        createAppFemale.setActionCommand("female");
        createAppGender = "F"; // TODO add your handling code here:
    }//GEN-LAST:event_createAppFemaleActionPerformed

    private void createAppProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAppProgramActionPerformed
        program = createAppProgram.getSelectedItem().toString();
    }//GEN-LAST:event_createAppProgramActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        new StudentView().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateApplicationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CreateApplicationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JTextField createAppAge;
    private javax.swing.JTextField createAppDOB;
    private javax.swing.JTextField createAppFOS;
    private javax.swing.JRadioButton createAppFemale;
    private javax.swing.JTextField createAppHostCountry;
    private javax.swing.JTextField createAppHostInst;
    private javax.swing.JTextField createAppLOS;
    private javax.swing.JRadioButton createAppMale;
    private javax.swing.JTextArea createAppMotivLetter;
    private javax.swing.JTextField createAppName;
    private javax.swing.JTextField createAppPostAddr;
    private javax.swing.JComboBox createAppProgram;
    private javax.swing.JScrollBar createAppScroll;
    private javax.swing.JTextField createAppStudID;
    private javax.swing.JButton createAppSubmit;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
