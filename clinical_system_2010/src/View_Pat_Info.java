
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.image.ImageObserver;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Array;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import java.awt.print.*;
import java.text.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gech
 */
public class View_Pat_Info extends javax.swing.JFrame {

    /**
     * Creates new form View_Pat_Info
     */
    public View_Pat_Info(String x, String y) {
        initComponents();
        display.setText(x);
        displayp.setText(y);
        //  JFrame jfrm=new JFrame("Text Area");
             /*pttable.getColumnModel().getColumn(0).setPreferredWidth(180);
         pttable.getColumnModel().getColumn(1).setPreferredWidth(180);
         pttable.getColumnModel().getColumn(2).setPreferredWidth(180);
         pttable.getColumnModel().getColumn(3).setPreferredWidth(180);
         pttable.getColumnModel().getColumn(4).setPreferredWidth(180);
         pttable.getColumnModel().getColumn(5).setPreferredWidth(180);
         pttable.getColumnModel().getColumn(6).setPreferredWidth(180);*/
//        pttable.getColumnModel().getColumn(7).setPreferredWidth(100);
//        pttable.getColumnModel().getColumn(8).setPreferredWidth(130);
//        pttable.getColumnModel().getColumn(9).setPreferredWidth(260);
//        pttable.getColumnModel().getColumn(10).setPreferredWidth(160);
//        pttable.getColumnModel().getColumn(11).setPreferredWidth(100);
//        pttable.getColumnModel().getColumn(12).setPreferredWidth(180);
//        pttable.getColumnModel().getColumn(13).setPreferredWidth(180);
//        pttable.getColumnModel().getColumn(14).setPreferredWidth(180);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        display = new javax.swing.JLabel();
        displayp = new javax.swing.JLabel();
        dsctp = new javax.swing.JDesktopPane();
        lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        cmd_print = new javax.swing.JButton();
        rptyp1 = new javax.swing.JComboBox();
        rptyp = new javax.swing.JComboBox();
        sex = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1112, 693));
        setPreferredSize(new java.awt.Dimension(1220, 690));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 110, 20));
        getContentPane().add(displayp, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 120, 20));

        dsctp.setBackground(new java.awt.Color(204, 204, 204));
        dsctp.add(lbl);
        lbl.setBounds(540, 380, 243, 32);

        txta.setColumns(20);
        txta.setRows(5);
        txta.setBorder(null);
        jScrollPane1.setViewportView(txta);

        dsctp.add(jScrollPane1);
        jScrollPane1.setBounds(30, 20, 1010, 450);
        dsctp.add(jPanel1);
        jPanel1.setBounds(10, 10, 1050, 470);

        getContentPane().add(dsctp, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 1070, 490));

        jButton1.setText("VIEW");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 580, 77, 30));

        cmd_print.setText("PRINT");
        cmd_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_printActionPerformed(evt);
            }
        });
        getContentPane().add(cmd_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 580, 90, 30));

        rptyp1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TYPE OF REPORT", "SERVED", "READY TO SERVE", "CALLED BUT NOT SERVED", "NOT CALLED" }));
        rptyp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rptyp1ActionPerformed(evt);
            }
        });
        getContentPane().add(rptyp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 140, 30));

        rptyp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TYPE OF REPORT", "MONTHLY", "ANNUALLY", "WEEKLY" }));
        rptyp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rptypActionPerformed(evt);
            }
        });
        getContentPane().add(rptyp, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 140, 30));

        sex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT SEX", "MALE", "FEMALE" }));
        sex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexActionPerformed(evt);
            }
        });
        getContentPane().add(sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 140, 30));

        jMenu1.setText("BACK            ");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int k;

//        pttable.setVisible(true);
        // pttable.setBackground(Color.BLUE);
        try {
            Mainclass ob = new Mainclass();
            RMIInterface hello = (RMIInterface) Naming.lookup("//localhost/clinical");
            if (rptyp1.getSelectedItem().toString().equals("TYPE OF REPORT")) {
                JOptionPane.showMessageDialog(null, "PLEASE SELECT REPORT TYPE",
                        null,
                        JOptionPane.PLAIN_MESSAGE);
            } else if (rptyp.getSelectedItem().toString().equals("TYPE OF REPORT")) {
                JOptionPane.showMessageDialog(null, "PLEASE SELECT THE SECOND REPORT TYPE",
                        null,
                        JOptionPane.PLAIN_MESSAGE);
            } else if (sex.getSelectedItem().toString().equals("SELECT SEX")) {
                JOptionPane.showMessageDialog(null, "PLEASE SELECT SEX",
                        null,
                        JOptionPane.PLAIN_MESSAGE);
            } else {


                int patient_identification = hello.view_pat_informationcount(rptyp.getSelectedItem().toString(), rptyp1.getSelectedItem().toString(), sex.getSelectedItem().toString());

                if (patient_identification < 1) {
                    String report = (rptyp.getSelectedItem().toString() + "  " + rptyp1.getSelectedItem().toString() + "   " + sex.getSelectedItem().toString() + "   PATEINTS   IDENTIFICATION   INFORMATION   REPORT   IN   UNIVERSITY   OF   GONDAR   ATSE   TEWODROSE   STUDENT  CLINIC   \n ");

                    txta.setText(report + ":   DOES NOT EXIST");
                } else {
                    int arraysize = patient_identification * 19;

                    String fetch[] = new String[arraysize];
                    fetch = hello.view_pat_information(arraysize, rptyp.getSelectedItem().toString(), rptyp1.getSelectedItem().toString(), sex.getSelectedItem().toString());
                    int cc = 0;
                    int c = fetch.length;
                    int i = 0, j = 0, idx = 0;
                    if (c >= 1) {
                        String report = (rptyp.getSelectedItem().toString() + "  " + rptyp1.getSelectedItem().toString() + "   " + sex.getSelectedItem().toString() + "   PATEINTS   IDENTIFICATION   INFORMATION   REPORT   IN   UNIVERSITY   OF   GONDAR   ATSE   TEWODROSE   STUDENT  CLINIC   \n ");

                        String s = report + "\n add here the needed information\n    INFOMATION ID" + "     " + "CARD NUMBER" + "         " + "ID NUMBER" + "        FIRST NAME" + "     " + "MIDDLE NAME" + "         " + "LAST NAME" + "       AGE" + "     " + "SEX" + "         " + "OCCUPATION" + "        RELIGION" + "                       " + "ADDRESS" + "         " + "SERVIES" + "         " + "DATE" + "         " + "STATUES" + "                  " + "TIME" + "         " + "CALLED" + "         " + "DEPARTMENT" + "         " + "BLOCK NUMBER" + "         " + "DORMITORY NUMBER" + "      \n";

                        while (cc <= arraysize) {
                            s = s + "   " + fetch[cc] + "                              " + fetch[cc + 1] + "                           " + fetch[cc + 2] + "                    " + fetch[cc + 3] + "                    " + fetch[cc + 4] + "                  " + fetch[cc + 5] + "          " + fetch[cc + 6] + "           " + fetch[cc + 7] + "      " + fetch[cc + 8] + "               " + fetch[cc + 9] + "             " + fetch[cc + 10] + "      " + fetch[cc + 11] + "      " + fetch[cc + 12] + "      " + fetch[cc + 13] + "               " + fetch[cc + 14] + "                     " + fetch[cc + 15] + "                      " + fetch[cc + 16] + "                " + fetch[cc + 17] + "                  " + fetch[cc + 18] + "     \n";
                            txta.setText(s);
                            cc = cc + 19;
                        }


                    } else {

                        JOptionPane.showMessageDialog(null, "PATIENT INFORMATION TABLE IS EMPTY",
                                null,
                                JOptionPane.PLAIN_MESSAGE);
                        txta.setText("");
                    }
                }
            }

        } catch (NotBoundException e) {
            System.out.println("Clinicalclient not bound exception:" + e);
            lbl.setText("Clinicalclient not bound exception:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmd_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_printActionPerformed
//        MessageFormat header = new MessageFormat("Report Print");
//        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
//        try {
////            pttable.print(JTable.PrintMode.NORMAL, header, footer);
//            txta.print(header, footer);
//        } catch (java.awt.print.PrinterException e) {
//            System.err.format("", e.getMessage());
//        }






        int width = txta.getWidth();
        int height = txta.getHeight();
        System.out.println("width is " + width);
        System.out.println("Height is " + height);
//
//    String font = display.getText();
//    int FontS = Integer.parseInt(font);
//    Font fonT = new Font("Monospaced", Font.PLAIN, 12);
//
//    display.setFont(new Font("Tahoma", Font.PLAIN, FontS));

        PrinterJob pj = PrinterJob.getPrinterJob();
        PageFormat pf = pj.defaultPage();

        Book bk = new Book();
        Paper paper = new Paper();

        double margin = 18;
        pj.setPageable(bk);

        paper.setSize(912, 792);
        paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight() - margin * 2);
        int lines = txta.getLineCount();
        System.out.println("lines = " + lines);
        pf.setPaper(paper);
        int tall = (int) pf.getImageableHeight();
        System.out.println("tall =" + tall);
        System.out.println("orientation " + pf.getOrientation());

        int pagenum = bk.getNumberOfPages();
        System.out.println("pagenum = " + pagenum);
        System.out.println("areah = " + height);
        int numpages = 1;
        if (height > 756) {
            for (int i = 756; i < height;) {
                numpages = numpages + 1;
                i = i + 756;
            }
        }
        System.out.println("numpages =" + numpages);
        // bk.append(new MyPrintable(), pf,numpages);

        // pj.setPrintable(new MyPrintable(), pf);   
        if (pj.printDialog()) {
            try {
                txta.setBounds(0, 0, txta.getWidth(), txta.getHeight());
                txta.print();
            } catch (PrinterException pp) {
                System.out.println(pp);
            }
        }







// Toolkit tkp = dsctp.getToolkit();
//        PrintJob pjp;
//        pjp = tkp.getPrintJob(this, null, null);
//        Graphics g = pjp.getGraphics();
//        dsctp.print(g);
//        g.dispose();
//        pjp.end();
//try {
//            Boolean complet = txta.print();
//            if (complet) {
//                JOptionPane.showMessageDialog(null, "Done printing...");
//            } else {
//                JOptionPane.showMessageDialog(null, "printing...");
//            }
//        } catch (PrinterException ex) {
//            Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_cmd_printActionPerformed

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

    private void sexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexActionPerformed

    private void rptyp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rptyp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rptyp1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (displayp.getText().equals("MANAGER")) {
            cmd_print.setVisible(true);
        } else {
            cmd_print.setVisible(false);
        }
    }//GEN-LAST:event_formWindowActivated

    private void rptypActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rptypActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rptypActionPerformed

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
            java.util.logging.Logger.getLogger(View_Pat_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Pat_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Pat_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Pat_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Pat_Info("", "").setVisible(true);
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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl;
    private javax.swing.JComboBox rptyp;
    private javax.swing.JComboBox rptyp1;
    private javax.swing.JComboBox sex;
    private javax.swing.JTextArea txta;
    // End of variables declaration//GEN-END:variables
}
