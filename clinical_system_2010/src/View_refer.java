
import java.awt.event.KeyEvent;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gech
 */
public class View_refer extends javax.swing.JFrame {

    /**
     * Creates new form View_refer
     */
    public View_refer(String x, String y, String z) {
        initComponents();
        display.setText(x);
        displayp.setText(y);
     //   id.setText(z);
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
        dsctp = new javax.swing.JDesktopPane();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        crdnm = new javax.swing.JLabel();
        fn = new javax.swing.JLabel();
        mn = new javax.swing.JLabel();
        ln = new javax.swing.JLabel();
        sex = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        dt = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        to = new javax.swing.JLabel();
        ch = new javax.swing.JLabel();
        hpi = new javax.swing.JLabel();
        pr = new javax.swing.JLabel();
        bp = new javax.swing.JLabel();
        rr = new javax.swing.JLabel();
        tm = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rfr = new javax.swing.JLabel();
        rx = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        dnm = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        sp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1112, 693));
        setPreferredSize(new java.awt.Dimension(1180, 730));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 120, 30));
        getContentPane().add(displayp, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 130, 30));

        dsctp.setBackground(new java.awt.Color(204, 204, 204));
        dsctp.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("RESPARATORY RATE");
        dsctp.add(jLabel15);
        jLabel15.setBounds(610, 360, 160, 20);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("TO");
        dsctp.add(jLabel3);
        jLabel3.setBounds(610, 80, 140, 29);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("ID NUMBER");
        dsctp.add(jLabel9);
        jLabel9.setBounds(120, 100, 160, 29);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("RX GIVEN");
        dsctp.add(jLabel18);
        jLabel18.setBounds(610, 560, 150, 27);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("REASON FOR REFERRAL");
        dsctp.add(jLabel19);
        jLabel19.setBounds(610, 500, 170, 43);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("TEMPRATURE");
        dsctp.add(jLabel16);
        jLabel16.setBounds(610, 410, 130, 32);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("BLOOD PRESSURE");
        dsctp.add(jLabel12);
        jLabel12.setBounds(610, 310, 140, 25);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("PULSE RATE");
        dsctp.add(jLabel14);
        jLabel14.setBounds(610, 250, 130, 24);

        jLabel21.setBackground(new java.awt.Color(51, 51, 255));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setText("UNIVERSITY OF GONDAR STUDENTS REFERRAL FORM");
        dsctp.add(jLabel21);
        jLabel21.setBounds(80, 10, 390, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("CARD NUMBER");
        dsctp.add(jLabel10);
        jLabel10.setBounds(120, 150, 160, 29);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("FIRST NAME");
        dsctp.add(jLabel11);
        jLabel11.setBounds(120, 200, 160, 29);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("LAST NAME");
        dsctp.add(jLabel13);
        jLabel13.setBounds(120, 310, 160, 29);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("MIDDLE NAME");
        dsctp.add(jLabel17);
        jLabel17.setBounds(120, 260, 160, 29);

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setText("SEX");
        dsctp.add(jLabel20);
        jLabel20.setBounds(120, 360, 160, 29);

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setText("AGE");
        dsctp.add(jLabel22);
        jLabel22.setBounds(120, 420, 160, 29);

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setText("DATE");
        dsctp.add(jLabel23);
        jLabel23.setBounds(120, 470, 160, 29);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel24.setText("TIME");
        dsctp.add(jLabel24);
        jLabel24.setBounds(120, 520, 160, 29);

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setText("CHIEF COMPLIANT");
        dsctp.add(jLabel25);
        jLabel25.setBounds(610, 130, 160, 29);

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel26.setText("HPI");
        dsctp.add(jLabel26);
        jLabel26.setBounds(610, 190, 160, 29);

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel27.setText("DIAGNOSIS");
        dsctp.add(jLabel27);
        jLabel27.setBounds(610, 460, 130, 32);
        dsctp.add(crdnm);
        crdnm.setBounds(290, 154, 280, 30);
        dsctp.add(fn);
        fn.setBounds(290, 214, 280, 30);
        dsctp.add(mn);
        mn.setBounds(290, 264, 280, 30);
        dsctp.add(ln);
        ln.setBounds(290, 314, 280, 30);
        dsctp.add(sex);
        sex.setBounds(290, 374, 290, 30);
        dsctp.add(age);
        age.setBounds(290, 434, 290, 30);
        dsctp.add(dt);
        dt.setBounds(290, 484, 280, 30);
        dsctp.add(time);
        time.setBounds(290, 524, 290, 20);
        dsctp.add(to);
        to.setBounds(780, 90, 290, 30);
        dsctp.add(ch);
        ch.setBounds(780, 150, 290, 30);
        dsctp.add(hpi);
        hpi.setBounds(780, 200, 290, 30);
        dsctp.add(pr);
        pr.setBounds(780, 260, 290, 30);
        dsctp.add(bp);
        bp.setBounds(780, 310, 290, 30);
        dsctp.add(rr);
        rr.setBounds(780, 360, 290, 30);
        dsctp.add(tm);
        tm.setBounds(780, 410, 290, 30);
        dsctp.add(jLabel1);
        jLabel1.setBounds(780, 460, 290, 30);
        dsctp.add(rfr);
        rfr.setBounds(780, 500, 290, 40);
        dsctp.add(rx);
        rx.setBounds(790, 550, 290, 40);

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setText("DOCTOR NAME");
        dsctp.add(jLabel28);
        jLabel28.setBounds(120, 560, 150, 27);
        dsctp.add(dnm);
        dnm.setBounds(300, 550, 290, 40);

        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        dsctp.add(jButton1);
        jButton1.setBounds(600, 20, 100, 30);
        dsctp.add(id);
        id.setBounds(260, 90, 270, 30);

        sp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spActionPerformed(evt);
            }
        });
        sp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spKeyTyped(evt);
            }
        });
        dsctp.add(sp);
        sp.setBounds(260, 50, 270, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("DATE");
        dsctp.add(jLabel2);
        jLabel2.setBounds(120, 50, 110, 30);
        dsctp.add(jPanel1);
        jPanel1.setBounds(10, 10, 1070, 590);

        getContentPane().add(dsctp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1090, 610));

        jMenu1.setText("BACK                  ");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("LOGOUT                              ");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
            RMIInterface hello = (RMIInterface) Naming.lookup("//localhost/clinical");
            String fetch[] = new String[5000];
              if (id.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER ID NUMBER",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
            } else if ((id.getText().length() < 7) || (id.getText().length() > 7)) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID SIZE OF ID NUMBER",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
                id.setText("");
            } else if (sp.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER  DATE",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
            } else if ((sp.getText().length() < 10) || (sp.getText().length() > 10)) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID SIZE OF  DATE",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
                sp.setText("");
            }
            else{
            fetch = hello.view_refers(id.getText(),sp.getText());
            int c = fetch.length;
            int i = 0, j = 0, idx = 0;
            if (c >= 1) {
                while (i < c) {
                    crdnm.setText(fetch[2]);

                    fn.setText(fetch[3]);

                    mn.setText(fetch[4]);
                    ln.setText(fetch[5]);
                    sex.setText(fetch[6]);

                    age.setText(fetch[7]);

                    dt.setText(fetch[8]);

                    time.setText(fetch[9]);
                    to.setText(fetch[10]);
                    ch.setText(fetch[11]);

                    hpi.setText(fetch[12]);

                    bp.setText(fetch[13]);

                    pr.setText(fetch[14]);
                    rr.setText(fetch[15]);
                    tm.setText(fetch[16]);

                    jLabel1.setText(fetch[17]);

                    rx.setText(fetch[18]);
                    dnm.setText(fetch[20]);
                    rfr.setText(fetch[19]);
                    i++;
                }
            } else {
                JOptionPane.showMessageDialog(null, "THIS ID NUMBER IS NOT REFERED",
                        null,
                        JOptionPane.PLAIN_MESSAGE);
            }
            }

        } catch (NotBoundException e) {
            System.out.println("Clinicalclient not bound exception:" + e);
        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new Doctor(display.getText(),displayp.getText()).setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
      
        new LOGIN().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       if (displayp.getText().equals("other")){
         jMenu1.setVisible(false);
}
 else
 {
     jMenu1.setVisible(true);
 }
    }//GEN-LAST:event_formWindowOpened

    private void spActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spActionPerformed

    private void spKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spKeyTyped
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)
            || c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_MINUS) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE))) {
    JOptionPane.showMessageDialog(null, "date is allowed only number and - in between",
        null,
        JOptionPane.QUESTION_MESSAGE);
        //gettoolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_spKeyTyped

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
            java.util.logging.Logger.getLogger(View_refer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_refer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_refer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_refer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_refer("","","").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel age;
    private javax.swing.JLabel bp;
    private javax.swing.JLabel ch;
    private javax.swing.JLabel crdnm;
    private javax.swing.JLabel display;
    private javax.swing.JLabel displayp;
    private javax.swing.JLabel dnm;
    private javax.swing.JDesktopPane dsctp;
    private javax.swing.JLabel dt;
    private javax.swing.JLabel fn;
    private javax.swing.JLabel hpi;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel ln;
    private javax.swing.JLabel mn;
    private javax.swing.JLabel pr;
    private javax.swing.JLabel rfr;
    private javax.swing.JLabel rr;
    private javax.swing.JLabel rx;
    private javax.swing.JLabel sex;
    private javax.swing.JTextField sp;
    private javax.swing.JLabel time;
    private javax.swing.JLabel tm;
    private javax.swing.JLabel to;
    // End of variables declaration//GEN-END:variables
}