
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
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
public class view_member extends javax.swing.JFrame {

    /**
     * Creates new form view_member
     */
    public view_member(String x, String y) {
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

        dsctp = new javax.swing.JDesktopPane();
        lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        cmd_print = new javax.swing.JButton();
        rptyp = new javax.swing.JComboBox();
        sex = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        display = new javax.swing.JLabel();
        displayp = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1112, 693));
        setPreferredSize(new java.awt.Dimension(1112, 693));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dsctp.setBackground(new java.awt.Color(204, 204, 204));
        lbl.setBounds(540, 380, 243, 32);
        dsctp.add(lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txta.setColumns(20);
        txta.setRows(5);
        txta.setBorder(null);
        jScrollPane1.setViewportView(txta);

        jScrollPane1.setBounds(30, 80, 1040, 470);
        dsctp.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("VIEW");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(160, 20, 59, 30);
        dsctp.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cmd_print.setText("PRINT");
        cmd_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_printActionPerformed(evt);
            }
        });
        cmd_print.setBounds(270, 20, 90, 30);
        dsctp.add(cmd_print, javax.swing.JLayeredPane.DEFAULT_LAYER);

        rptyp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TYPE OF REPORT", "MONTHLY", "ANNUALLY", "WEEKLY" }));
        rptyp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rptypActionPerformed(evt);
            }
        });
        rptyp.setBounds(480, 20, 140, 30);
        dsctp.add(rptyp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        sex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT SEX", "MALE", "FEMALE" }));
        sex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexActionPerformed(evt);
            }
        });
        sex.setBounds(640, 20, 140, 30);
        dsctp.add(sex, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPanel1.setBounds(10, 10, 1080, 560);
        dsctp.add(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(dsctp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 1100, 580));
        getContentPane().add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 100, 30));
        getContentPane().add(displayp, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 100, 30));

        jMenu1.setText("BACK               ");
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


        // pttable.setBackground(Color.BLUE);
        try {
            Mainclass ob = new Mainclass();
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
                String fetch[] = new String[500000];
                fetch = hello.view_member(rptyp.getSelectedItem().toString(), sex.getSelectedItem().toString());
                int c = fetch.length;
                int i = 0, j = 0, idx = 0, cc = 0;



//                 String report = (rptyp.getSelectedItem().toString() + "  " + rptyp1.getSelectedItem().toString() + "   " + sex.getSelectedItem().toString() + "   PATEINTS   IDENTIFICATION   INFORMATION   REPORT   IN   UNIVERSITY   OF   GONDAR   ATSE   TEWODROSE   STUDENT  CLINIC   \n ");
//
//                        String s = report + "\n add here the needed information\n    INFOMATION ID" + "     " + "CARD NUMBER" + "         " + "ID NUMBER" + "        FIRST NAME" + "     " + "MIDDLE NAME" + "         " + "LAST NAME" + "       AGE" + "     " + "SEX" + "         " + "OCCUPATION" + "        RELIGION" + "                       " + "ADDRESS" + "         " + "SERVIES" + "         " + "DATE" + "         " + "STATUES" + "                  " + "TIME" + "         " + "CALLED" + "         " + "DEPARTMENT" + "         " + "BLOCK NUMBER" + "         " + "DORMITORY NUMBER" + "      \n";
//
//                        while (cc <= arraysize) {
//                            s = s + "   " + fetch[cc] + "                              " + fetch[cc + 1] + "                           " + fetch[cc + 2] + "                    " + fetch[cc + 3] + "                    " + fetch[cc + 4] + "                  " + fetch[cc + 5] + "          " + fetch[cc + 6] + "           " + fetch[cc + 7] + "      " + fetch[cc + 8] + "               " + fetch[cc + 9] + "             " + fetch[cc + 10] + "      " + fetch[cc + 11] + "      " + fetch[cc + 12] + "      " + fetch[cc + 13] + "               " + fetch[cc + 14] + "                     " + fetch[cc + 15] + "                      " + fetch[cc + 16] + "                " + fetch[cc + 17] + "                  " + fetch[cc + 18] + "     \n";
//                            txta.setText(s);
//                            cc = cc + 19;
//                        }






                if (c >= 1) {






                    //   String s=(rptyp.getSelectedItem().toString() + "   " + sex.getSelectedItem().toString() + "   MEMBER    IDENTIFICATION   INFORMATION   REPORT   IN   UNIVERSITY   OF   GONDAR   ATSE   TEWODROSE   STUDENT  CLINIC   \n ");

                    String report = (rptyp.getSelectedItem().toString() + "  " + sex.getSelectedItem().toString() + "   MEMBER   INFORMATION   REPORT   IN   UNIVERSITY   OF   GONDAR   ATSE   TEWODROSE   STUDENT  CLINIC   \n ");

                    String s = report + "\n add here the needed information\n    MEMBER ID" + "                  FIRST NAME" + "     " + "MIDDLE NAME" + "         " + "LAST NAME" + "       SEX" + "     " + "AGE" + "         " + "PHONE NUMBER" + "        EMAIL" + "                       " + "ADDRESS" + "         " + "PROFESSION" + "                " + "STATUES" + "                  " + "DATE" + "         " + "TIME" + "              \n";

                    while (cc <= c) {
                        s = s + "   " + fetch[cc] + "                              " + fetch[cc + 1] + "                           " + fetch[cc + 2] + "                    " + fetch[cc + 3] + "                    " + fetch[cc + 4] + "                  " + fetch[cc + 5] + "          " + fetch[cc + 6] + "           " + fetch[cc + 7] + "      " + fetch[cc + 8] + "               " + fetch[cc + 9] + "             " + fetch[cc + 10] + "      " + fetch[cc + 11] + "      " + fetch[cc + 12] + "      \n";
                        txta.setText(s);
                        cc = cc + 13;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "MEMBER TABLE IS EMPTY",
                            null,
                            JOptionPane.PLAIN_MESSAGE);
                    // pttable.hide();
                }
            }

        } catch (NotBoundException e) {
            System.out.println("Clinicalclient not bound exception:" + e);
            lbl.setText("Clinicalclient not bound exception:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }




    }//GEN-LAST:event_jButton1ActionPerformed

    private void rptypActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rptypActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rptypActionPerformed

    private void sexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexActionPerformed

    private void cmd_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_printActionPerformed
        MessageFormat header = new MessageFormat("Report Print");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        Toolkit tkp = txta.getToolkit();
        PrintJob pjp;
        pjp = tkp.getPrintJob(this, null, null);
        Graphics g = pjp.getGraphics();
        txta.print(g);
        g.dispose();
        pjp.end();
    }//GEN-LAST:event_cmd_printActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
 if (displayp.getText().equals("MANAGER")){
         cmd_print.setVisible(true);
}
 else
 {
     cmd_print.setVisible(false);
 }      
    }//GEN-LAST:event_formWindowActivated

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
         new Manager(display.getText(), displayp.getText()).setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(view_member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_member("", "").setVisible(true);
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
    private javax.swing.JLabel lbl;
    private javax.swing.JComboBox rptyp;
    private javax.swing.JComboBox sex;
    private javax.swing.JTextArea txta;
    // End of variables declaration//GEN-END:variables
}
