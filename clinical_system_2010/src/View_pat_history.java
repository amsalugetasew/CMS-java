
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
public class View_pat_history extends javax.swing.JFrame {

    /**
     * Creates new form View_pat_history
     */
    public View_pat_history(String x, String y) {
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

        display = new javax.swing.JLabel();
        displayp = new javax.swing.JLabel();
        sex = new javax.swing.JComboBox();
        rptyp = new javax.swing.JComboBox();
        cmd_print = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta = new javax.swing.JTextArea();
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
        getContentPane().add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 0, 110, 20));
        getContentPane().add(displayp, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 120, 20));

        sex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT SEX", "MALE", "FEMALE" }));
        sex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexActionPerformed(evt);
            }
        });
        getContentPane().add(sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, 30));

        rptyp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TYPE OF REPORT", "MONTHLY", "ANNUALLY", "WEEKLY" }));
        rptyp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rptypActionPerformed(evt);
            }
        });
        getContentPane().add(rptyp, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, 30));

        cmd_print.setText("PRINT");
        cmd_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_printActionPerformed(evt);
            }
        });
        getContentPane().add(cmd_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 90, 30));

        jButton1.setText("VIEW");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 77, 30));

        txta.setColumns(20);
        txta.setRows(5);
        txta.setBorder(null);
        jScrollPane1.setViewportView(txta);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 860, 440));

        jMenu1.setText("BACK                    ");
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







        int k;

        try {
            Mainclass ob = new Mainclass();
           if (rptyp.getSelectedItem().toString().equals("TYPE OF REPORT")) {
                JOptionPane.showMessageDialog(null, "PLEASE SELECT REPORT TYPE",
                        null,
                        JOptionPane.PLAIN_MESSAGE);
            } else 
               if (sex.getSelectedItem().toString().equals("SELECT SEX")) {
                JOptionPane.showMessageDialog(null, "PLEASE SELECT SEX",
                        null,
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                   
            RMIInterface hello = (RMIInterface) Naming.lookup("//localhost/clinical");
                   
                 int patient_identification = hello.view_pat_historys(rptyp.getSelectedItem().toString(), sex.getSelectedItem().toString());

                if (patient_identification < 1) {
                     String report = (rptyp.getSelectedItem().toString() + "  "  + sex.getSelectedItem().toString() + "   PATEINTS   IDENTIFICATION   INFORMATION   REPORT   IN   UNIVERSITY   OF   GONDAR   ATSE   TEWODROSE   STUDENT  CLINIC   \n ");

                    txta.setText(report+":   DOES NOT EXIST");
                } else {    
                   int arraysize=patient_identification*64;
                   
            String fetch[] = new String[arraysize];
            fetch = hello.view_pat_history(rptyp.getSelectedItem().toString(), sex.getSelectedItem().toString());
                 int cc = 0;
            int c = fetch.length;
            int i = 0, j = 0, idx = 0;
            
            
             String report = (rptyp.getSelectedItem().toString() + "       "+ sex.getSelectedItem().toString() + "   PATEINTS   HISTORY   INFORMATION   REPORT   IN   UNIVERSITY   OF   GONDAR   ATSE   TEWODROSE   STUDENT  CLINIC   \n ");

                        String s = report + "\n add here the needed information\n   "
                                + " HISTORY ID" + "     " + "ID NUMBER" + "         " + "CARD NUMBER" + "        FIRST NAME" + "     " + "LAST NAME" + "         " + "SEX" + "       MEDICATION DATE" + "     " + "CHIEF COMPLIANT" + "         " + "HISTORY OF PRESENT ILLNESS" + "        HISTORY OF PREVIOUSE ADMISION" + "                       " + "GENERAL APPEARANCE" + "         " + "BLOOD PRESURE" + "         " + "RESPARATORY RATE" + "         " + "PULSE RATE" + "                  " + "TEMPRATURE" + "         " + "HEAD" + "         " + "EAR" + "         " + "EYE" + "         " + "NOSE" + "               " + "MOUTH" + "               " + "LYMPHO GRADULAR SYSTEM" + "               " + "RESPARATORY SYSTEM INSPECTION" + "               " + "RESPARATORY SYSTEM PALPUTION" + "                     " + "RESPARATORY SYSTEM PERCUTION" + "                     " + "RESPARATORY SYSTEM AUSCALTATION" + "                     " + "CARDIO VASCULAR ARTERIOL" + "                     " + "CARDIO VASCULAR VENOUSE" + "                     " + "PRECORDIAL INSPECTION" + "                           " + "PRECORDIAL PALPUTION" + "                           " + "PRECORDIAL PERCUTION" + "                           " + "PRECORDIAL AUSCALTATION" + "                           " + "ABDOMENAL SYSTEM INSPECTION" + "                                 " + "ABDOMENAL SYSTEM PALPUTION" + "                                 " + "ABDOMENAL SYSTEM PERCUTION" + "                                 " + "ABDOMENAL SYSTEM AUSCULTATION" + "                                 " + "GENITONARY SYSTEM INSPECTION" + "                                       " + "GENITONARY SYSTEM PALPUTION" + "                                       " + "GENITONARY SYSTEM PERCUTION" + "                                       " + "GENITONARY SYSTEM AUSCULTATION" + "                                       " + "MESKO SKELETAL SYSTEM INSPECTION" + "                                       " + "MESKO SKELETAL SYSTEM PALPUTION" + "                                             " + "MESKO SKELETAL SYSTEM PERCUTION" + "                                             " + "MESKO SKELETAL SYSTEM AUSCULTATION" + "                                             " + "INTEGMENTARY SYSTEM INSPECTION" + "                                                   " + "INTEGMENTARY SYSTEM PALPUTION" + "                                                   " + "INTEGMENTARY SYSTEM PERCUTION" + "                                                   " + "INTEGMENTARY SYSTEM AUSCULTATION" + "                                                   " + "GLASCOMAL SYSTEM" + "                                                   " + "MINIMENTAL SYSTEM " + "                                                   " + "CRANIAL NERVIOUSE SYSTEM CN1" + "                                                         " + "CRANIAL NERVIOUSE SYSTEM CN2" + "                                                         " + "CRANIAL NERVIOUSE SYSTEM CN3" + "                                                         " + "CRANIAL NERVIOUSE SYSTEM CN4" + "                                                         " + "CRANIAL NERVIOUSE SYSTEM CN5" + "                                                         " + "CRANIAL NERVIOUSE SYSTEM CN6" + "                                                         " + "CRANIAL NERVIOUSE SYSTEM CN7" + "                                                         " + "CRANIAL NERVIOUSE SYSTEM CN8" + "                                                         " + "CRANIAL NERVIOUSE SYSTEM CN9" + "                                                         " + "CRANIAL NERVIOUSE SYSTEM CN10" + "                                                         " + "CRANIAL NERVIOUSE SYSTEM CN11" + "                                                         " + "CRANIAL NERVIOUSE SYSTEM CN12" + "                                                         " + "SUBJECTIVE SUMMERY" + "                                                               " + "OBBJECTIVE SUMMERY" + "                                                               " + "ASSASMENT" + "      \n";

                        while (cc <= arraysize) {
                            s = s + "   " + fetch[cc] + "                              " + fetch[cc + 1] + "                           " + fetch[cc + 2] + "                    " + fetch[cc + 3] + "                    " + fetch[cc + 4] + "                  " + fetch[cc + 5] + "          " + fetch[cc + 6] + "           " + fetch[cc + 7] + "      " + fetch[cc + 8] + "               " + fetch[cc + 9] + "             " + fetch[cc + 10] + "      " + fetch[cc + 11] + "      " + fetch[cc + 12] + "      " + fetch[cc + 13] + "               " + fetch[cc + 14] + "                     " + fetch[cc + 15] + "                      " + fetch[cc + 16] + "                " + fetch[cc + 17] + "                  " + fetch[cc + 18] + "                       " + fetch[cc + 19] + "                       " + fetch[cc + 20] + "                       " + fetch[cc + 21] + "                            " + fetch[cc + 22] + "                            " + fetch[cc + 23] + "                                 " + fetch[cc + 24] + "                                 " + fetch[cc + 25] + "                                 " + fetch[cc + 26] + "                                 " + fetch[cc + 27] + "                                 " + fetch[cc + 28] + "                                 " + fetch[cc + 29] + "                                 " + fetch[cc + 30] + "                                      " + fetch[cc + 31] + "                                      " + fetch[cc + 32] + "                                      " + fetch[cc + 33] + "                                      " + fetch[cc + 34] + "                                      " + fetch[cc + 35] + "                                      " + fetch[cc + 36] + "                                      " + fetch[cc + 37] + "                                      " + fetch[cc + 38] + "                                      " + fetch[cc + 39] + "                                      " + fetch[cc + 40] + "                                           " + fetch[cc + 41] + "                                           " + fetch[cc + 42] + "                                           " + fetch[cc + 43] + "                                           " + fetch[cc + 44] + "                                           " + fetch[cc + 45] + "                                           " + fetch[cc + 46] + "                                           " + fetch[cc + 47] + "                                           " + fetch[cc + 48] + "                                           " + fetch[cc + 49] + "                                           " + fetch[cc + 50] + "                                                " + fetch[cc + 51] + "                                                " + fetch[cc + 52] + "                                                " + fetch[cc + 53] + "                                                " + fetch[cc + 54] + "                                                " + fetch[cc + 55] + "                                                " + fetch[cc + 56] + "                                                " + fetch[cc + 57] + "                                                " + fetch[cc + 58] + "                                                " + fetch[cc + 59] + "                                                " + fetch[cc + 60] + "                                                " + fetch[cc + 61] + "                                                " + fetch[cc + 62] + "                                               " + fetch[cc + 63] + "     \n";
                            txta.setText(s);
                            cc = cc + 64;
                        }

                }
            
            
//            while (i < c) {
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                i++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                j++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                i++;
//                idx++;
//                pttable.getModel().setValueAt(fetch[idx], i, j);
//                i++;
//                idx++;
//                j = 0;
//            }
            }
           
        } catch (NotBoundException e) {
            System.out.println("Clinicalclient not bound exception:" + e);
            //   lbl.setText("Clinicalclient not bound exception:" +e.getMessage());
        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmd_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_printActionPerformed
//        MessageFormat header = new MessageFormat("Report Print");
//        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
//        try {
//            pttable.print(JTable.PrintMode.NORMAL, header, footer);
//        } catch (java.awt.print.PrinterException e) {
//            System.err.format("", e.getMessage());
//        }
//        Toolkit tkp = dsctp.getToolkit();
//        PrintJob pjp;
//        pjp = tkp.getPrintJob(this, null, null);
//        Graphics g = pjp.getGraphics();
//        dsctp.print(g);
//        g.dispose();
//        pjp.end();

    }//GEN-LAST:event_cmd_printActionPerformed

    private void sexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexActionPerformed

    private void rptypActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rptypActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rptypActionPerformed

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
            java.util.logging.Logger.getLogger(View_pat_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_pat_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_pat_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_pat_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_pat_history("", "").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd_print;
    private javax.swing.JLabel display;
    private javax.swing.JLabel displayp;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox rptyp;
    private javax.swing.JComboBox sex;
    private javax.swing.JTextArea txta;
    // End of variables declaration//GEN-END:variables
}