
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
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
public class print_sickleave extends javax.swing.JFrame {

    /**
     * Creates new form print_sickleave
     */
    public print_sickleave(String x, String y, String z) {
        initComponents();
        display.setText(x);
        displayp.setText(y);
        id.setText(z);
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
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        vdt3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rx = new javax.swing.JLabel();
        sc = new javax.swing.JLabel();
        rc = new javax.swing.JLabel();
        fn = new javax.swing.JLabel();
        mn = new javax.swing.JLabel();
        sex = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        fns = new javax.swing.JLabel();
        pnm = new javax.swing.JLabel();
        idt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        displayp = new javax.swing.JLabel();
        display = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1112, 693));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dsctp.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText(" SEX");
        jLabel7.setBounds(30, 290, 174, 25);
        dsctp.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText(" LAST NAME");
        jLabel4.setBounds(30, 250, 174, 25);
        dsctp.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText(" FIRST NAME");
        jLabel2.setBounds(30, 190, 174, 25);
        dsctp.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText(" DATE OF CLINIC VISIT");
        jLabel10.setBounds(30, 150, 174, 25);
        dsctp.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText(" ID NUMBER");
        jLabel6.setBounds(30, 110, 174, 25);
        dsctp.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        vdt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vdt3ActionPerformed(evt);
            }
        });
        vdt3.setBounds(310, 340, 180, 30);
        dsctp.add(vdt3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText(" PHYSICIAN SIGNATURE");
        jLabel13.setBounds(100, 340, 174, 25);
        dsctp.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(rx, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 180, 30));
        jPanel1.add(sc, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 180, 30));
        jPanel1.add(rc, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 180, 30));
        jPanel1.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 180, 30));
        jPanel1.add(mn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 180, 30));
        jPanel1.add(sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 180, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText(" PHYSICIAN NAME");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 170, 25));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText(" DATE OF ISSUE");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 174, 25));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("RECOMENDATION");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 174, 25));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText(" SICK LEAVE");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 174, 25));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText(" Rx GIVEN");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 174, 25));
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 100, 30));
        jPanel1.add(fns, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 150, 30));

        pnm.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(pnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 180, 30));
        jPanel1.add(idt, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 180, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 840, 560));

        jPanel1.setBounds(10, 10, 820, 540);
        dsctp.add(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(dsctp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 840, 560));
        getContentPane().add(displayp, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 130, 30));
        getContentPane().add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 120, 30));

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("PRINT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 110, 30));

        jMenu1.setText("BACK                    ");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("LOGOUT                  ");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vdt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vdt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vdt3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Toolkit tkp = dsctp.getToolkit();
        PrintJob pjp;
        pjp = tkp.getPrintJob(this, null, null);
        Graphics g = pjp.getGraphics();
        dsctp.print(g);
        // dsctp.print(dsctp.PrintMode.NORMAL);
        g.dispose();
        pjp.end();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            RMIInterface hello = (RMIInterface) Naming.lookup("//localhost/clinical");
            String fetch[] = new String[5000];
            fetch = hello.print_sickleaves(id.getText());
            int c = fetch.length;
            int i = 0, j = 0, idx = 0;
            if (c >= 1) {
                while (i < c) {

                    id.setText(fetch[1]);
                    fn.setText(fetch[2]);
                    mn.setText(fetch[3]);
                    sex.setText(fetch[4]);
                    idt.setText(fetch[8]);
                    pnm.setText(display.getText());
                    rx.setText(fetch[5]);
                    sc.setText(fetch[6]);
                    fns.setText(fetch[9]);
                    rc.setText(fetch[7]);
                    i++;
                }
            } else {
                JOptionPane.showMessageDialog(null, "EMPTY",
                        null,
                        JOptionPane.PLAIN_MESSAGE);
            }

        } catch (NotBoundException e) {
            System.out.println("Clinicalclient not bound exception:" + e);
        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }

    }//GEN-LAST:event_formWindowActivated

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
         new Sickleave(display.getText(), displayp.getText(), id.getText()).setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
     new LOGIN().setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jMenu2MouseClicked

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
            java.util.logging.Logger.getLogger(print_sickleave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(print_sickleave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(print_sickleave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(print_sickleave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new print_sickleave("", "", "").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel display;
    private javax.swing.JLabel displayp;
    private javax.swing.JDesktopPane dsctp;
    private javax.swing.JLabel fn;
    private javax.swing.JLabel fns;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idt;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel mn;
    private javax.swing.JLabel pnm;
    private javax.swing.JLabel rc;
    private javax.swing.JLabel rx;
    private javax.swing.JLabel sc;
    private javax.swing.JLabel sex;
    private javax.swing.JTextField vdt3;
    // End of variables declaration//GEN-END:variables
}
