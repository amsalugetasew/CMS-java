
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gech
 */
public class view_Prescription extends javax.swing.JFrame {

    /**
     * Creates new form view_Prescription
     */
    public view_Prescription(String x, String y) {
        initComponents();
        display.setText(x);
        displayp.setText(y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayp = new javax.swing.JLabel();
        display = new javax.swing.JLabel();
        rptyp = new javax.swing.JComboBox();
        sex = new javax.swing.JComboBox();
        dsctp = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta = new javax.swing.JTextArea();
        cmd_print = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1112, 693));
        setPreferredSize(new java.awt.Dimension(1112, 693));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(displayp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 120, 20));
        getContentPane().add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 0, 110, 20));

        rptyp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TYPE OF REPORT", "MONTHLY", "ANNUALLY", "WEEKLY" }));
        rptyp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rptypActionPerformed(evt);
            }
        });
        getContentPane().add(rptyp, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 140, 30));

        sex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT SEX", "MALE", "FEMALE" }));
        sex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexActionPerformed(evt);
            }
        });
        getContentPane().add(sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 140, 30));

        dsctp.setBackground(new java.awt.Color(204, 204, 204));

        txta.setColumns(20);
        txta.setRows(5);
        jScrollPane1.setViewportView(txta);

        dsctp.add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 850, 400);

        cmd_print.setText("PRINT");
        cmd_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_printActionPerformed(evt);
            }
        });
        dsctp.add(cmd_print);
        cmd_print.setBounds(530, 20, 90, 30);

        jButton1.setText("VIEW");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        dsctp.add(jButton1);
        jButton1.setBounds(440, 20, 77, 30);
        dsctp.add(jPanel1);
        jPanel1.setBounds(10, 10, 940, 480);

        getContentPane().add(dsctp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 960, 500));

        jMenu1.setText("BACK                      ");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        //       try
        //       {
        // Object x=pttable;
        // int i=0,j=0,indx=0;
        int k;

        try {
            Mainclass ob = new Mainclass();
            //ob.card_number;
            //    ResultSet rs;
            //ArrayList fetch = new ArrayList();
            RMIInterface hello = (RMIInterface) Naming.lookup("//localhost/clinical");
            if (rptyp.getSelectedItem().toString().equals("TYPE OF REPORT")) {
                JOptionPane.showMessageDialog(null, "PLEASE SELECT REPORT TYPE",
                        null,
                        JOptionPane.PLAIN_MESSAGE);
            } else if (sex.getSelectedItem().toString().equals("SELECT SEX")) {
                JOptionPane.showMessageDialog(null, "PLEASE SELECT SEX",
                        null,
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                String fetch[] = new String[5000];
                fetch = hello.view_prescription(rptyp.getSelectedItem().toString(), sex.getSelectedItem().toString());
                int c = fetch.length;
                int i = 0, j = 0, idx = 0,cc=0;



                String report = (rptyp.getSelectedItem().toString() + "     " + sex.getSelectedItem().toString() + "   PATEINTS   IDENTIFICATION   INFORMATION   REPORT   IN   UNIVERSITY   OF   GONDAR   ATSE   TEWODROSE   STUDENT  CLINIC   \n ");

                        String s = report+"\n add here the needed information\n    PRESCRIPTION ID" + "     " + "ID NUMBER" + "         " + "CARD NUMBER" + "        FIRST NAME" + "     " + "LAST NAME" + "         " + "SEX" + "       DEPARTMENT" + "     " + "BLOCK NUMBER" + "         " + "DORMETRY NUMBER" + "        PRESCRIPTION DATE" + "                       " + "DRUG NAME" + "         " + "DOSE" + "         " + "FREQUENCY" + "         " + "FOR HOW LONG" + "                  " + "QUANTITY" + "         " + "SERVICE" + "         " + "CALLED" + "         \n"; 

                        while (cc <= c) {
                            s = s + "   " + fetch[cc] + "                              " + fetch[cc + 1] + "                           " + fetch[cc + 2] + "                    " + fetch[cc + 3] + "                    " + fetch[cc + 4] + "                  " + fetch[cc + 5] + "          " + fetch[cc + 6] + "           " + fetch[cc + 7] + "      " + fetch[cc + 8] + "               " + fetch[cc + 9] + "             " + fetch[cc + 10] + "      " + fetch[cc + 11] + "      " + fetch[cc + 12] + "      " + fetch[cc + 13] + "               " + fetch[cc + 14] + "                     " + fetch[cc + 15] + "                      " + fetch[cc + 16] + "                      \n";
                            txta.setText(s);
                            cc = cc + 17;
                        }






                
            }

        } catch (NotBoundException e) {
            System.out.println("Clinicalclient not bound exception:" + e);
            // lbl.setText("Clinicalclient not bound exception:" +e.getMessage());
        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }






    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmd_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_printActionPerformed
        Toolkit tkp = dsctp.getToolkit();
        PrintJob pjp;
        pjp = tkp.getPrintJob(this, null, null);
        Graphics g = pjp.getGraphics();
        dsctp.print(g);
        // dsctp.print(dsctp.PrintMode.NORMAL);
        g.dispose();
        pjp.end();
    }//GEN-LAST:event_cmd_printActionPerformed

    private void rptypActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rptypActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rptypActionPerformed

    private void sexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
             
 if (displayp.getText().equals("MANAGER")){
         cmd_print.setVisible(true);
}
 else
 {
     cmd_print.setVisible(false);
 }
    }//GEN-LAST:event_formWindowOpened

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
         if (displayp.getText().equals("DOCTOR/NURSE")) {
            new Doctor(display.getText(), displayp.getText()).setVisible(true);
            this.setVisible(false);
        } else if (displayp.getText().equals("RECEPTION")) {
            new Reception(display.getText(), displayp.getText()).setVisible(true);
            this.setVisible(false);
        } else if (displayp.getText().equals("PHARMACIST")) {
            new Pharmacist(display.getText(), displayp.getText()).setVisible(true);
            this.setVisible(false);
        } else if (displayp.getText().equals("LABORATORIST")) {
            new Laboratorist(display.getText(), displayp.getText()).setVisible(true);
            this.setVisible(false);
        } else if (displayp.getText().equals("MANAGER")) {
            new Manager(displayp.getText(), displayp.getText()).setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jMenu1MouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(view_Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_Prescription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_Prescription("", "").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd_print;
    private javax.swing.JLabel display;
    private javax.swing.JLabel displayp;
    private javax.swing.JDesktopPane dsctp;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox rptyp;
    private javax.swing.JComboBox sex;
    private javax.swing.JTextArea txta;
    // End of variables declaration//GEN-END:variables
}
