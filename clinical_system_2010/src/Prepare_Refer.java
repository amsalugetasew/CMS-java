
import java.awt.event.KeyEvent;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gech
 */
public class Prepare_Refer extends javax.swing.JFrame {

    /**
     * Creates new form Prepare_Refer
     */
    public Prepare_Refer(String x, String y, String z) {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel15 = new javax.swing.JLabel();
        pr = new javax.swing.JTextField();
        bp = new javax.swing.JTextField();
        to = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        rx = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        rfr = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        tm = new javax.swing.JTextField();
        rr = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        display = new javax.swing.JLabel();
        displayp = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1112, 693));
        setPreferredSize(new java.awt.Dimension(1112, 693));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jDesktopPane1, org.jdesktop.beansbinding.ELProperty.create("                                                                                              REFERAL"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(200, 100));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("RESPARATORY RATE");
        jLabel15.setBounds(120, 320, 160, 20);
        jDesktopPane1.add(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        pr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prKeyTyped(evt);
            }
        });
        pr.setBounds(290, 200, 290, 40);
        jDesktopPane1.add(pr, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bpKeyTyped(evt);
            }
        });
        bp.setBounds(290, 260, 290, 40);
        jDesktopPane1.add(bp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        to.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                toKeyTyped(evt);
            }
        });
        to.setBounds(290, 150, 290, 40);
        jDesktopPane1.add(to, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("TO");
        jLabel3.setBounds(120, 150, 140, 29);
        jDesktopPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });
        id.setBounds(290, 100, 290, 40);
        jDesktopPane1.add(id, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("ID NUMBER");
        jLabel9.setBounds(120, 100, 160, 29);
        jDesktopPane1.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        rx.setColumns(20);
        rx.setRows(5);
        jScrollPane4.setViewportView(rx);

        jScrollPane4.setBounds(290, 460, 290, 36);
        jDesktopPane1.add(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("SUBMIT REFER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(260, 540, 170, 30);
        jDesktopPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("RX GIVEN");
        jLabel18.setBounds(120, 470, 150, 27);
        jDesktopPane1.add(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);

        rfr.setColumns(20);
        rfr.setRows(5);
        jScrollPane5.setViewportView(rfr);

        jScrollPane5.setBounds(290, 410, 290, 43);
        jDesktopPane1.add(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("REASON FOR REFERRAL");
        jLabel19.setBounds(123, 410, 170, 43);
        jDesktopPane1.add(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tmKeyTyped(evt);
            }
        });
        tm.setBounds(290, 360, 290, 40);
        jDesktopPane1.add(tm, javax.swing.JLayeredPane.DEFAULT_LAYER);

        rr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rrKeyTyped(evt);
            }
        });
        rr.setBounds(290, 310, 290, 40);
        jDesktopPane1.add(rr, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("TEMPRATURE");
        jLabel16.setBounds(120, 370, 130, 32);
        jDesktopPane1.add(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("BLOOD PRESSURE");
        jLabel12.setBounds(120, 270, 140, 25);
        jDesktopPane1.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("PULSE RATE");
        jLabel14.setBounds(120, 210, 130, 24);
        jDesktopPane1.add(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel21.setBackground(new java.awt.Color(51, 51, 255));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setText("UNIVERSITY OF GONDAR STUDENTS REFERRAL FORM");
        jLabel21.setBounds(100, 50, 484, 17);
        jDesktopPane1.add(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("NEED PRINT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(440, 540, 130, 30);
        jDesktopPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPanel2.setBounds(10, 10, 770, 580);
        jDesktopPane1.add(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 790, 600));
        getContentPane().add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 120, 30));
        getContentPane().add(displayp, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 130, 30));

        jMenu1.setText("BACK                             ");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("LOGOUT                                 ");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        //dt.setText(s.format(d));
        String x = s.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(d);
        try {
            Mainclass ob = new Mainclass();
            ob.dates = x;
            ob.time = time;
            ob.hospital_name = to.getText();
            ob.id_number = id.getText();
            ob.bp = pr.getText();
            ob.tm = rr.getText();
            ob.pr = tm.getText();
            ob.rr = bp.getText();
            ob.sex = null;
            ob.hpi = null;
            ob.diagnosis = null;
            ob.ch = null;
            ob.rx_given = rx.getText();
            ob.reason_refer = rfr.getText();
            
            try {
                RMIInterface hello = (RMIInterface) Naming.lookup("//localhost/clinical");
                String func=null;
                  if (ob.id_number.isEmpty()) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER ID NUMBER",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
            } else if ((id.getText().length() < 7) || (id.getText().length() > 7)) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID SIZE OF ID NUMBER",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
                id.setText("");
            } else   if (pr.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER PULSE RATE",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
            } else if ((pr.getText().length() < 2) || (pr.getText().length() > 3)) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID SIZE OF PULSE RATE",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
                pr.setText("");
            }else   if (bp.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER BLOOD PRESURE",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
            } else if ((bp.getText().length() < 2) || (bp.getText().length() > 3)) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID SIZE OF BLOOD PRESURE",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
                bp.setText("");
            }else   if (rr.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER RESPARATORY RATE",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
            } else if ((rr.getText().length() < 2) || (rr.getText().length() > 3)) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID SIZE OF RESPARATORY RATE",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
                rr.setText("");
            }else   if (tm.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER TEMPRATURE",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
            } else if ((tm.getText().length() < 2) || (tm.getText().length() > 3)) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID SIZE OF TEMPRATURE",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
                tm.setText("");
            }else   if (rx.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER HISTORY GIVEN",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
            } 
                else
                {
                func=(hello.referral(display.getText(),"1", ob.id_number, ob.dates, ob.time, ob.hospital_name, ob.ch, ob.hpi, ob.bp, ob.pr, ob.rr, ob.tm, ob.diagnosis, ob.rx_given, ob.reason_refer));
               int count=Integer.parseInt(func);
                if(count>=1){
                JOptionPane.showMessageDialog(null, "REFERED",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
                }
                else
                {
                  JOptionPane.showMessageDialog(null, "INCORRECT ID NUMBER",
                        null,
                        JOptionPane.QUESTION_MESSAGE);  
                }
                }
            } catch (NotBoundException e) {
                System.out.println("Clinicalclient not bound exception:" + e);
                //lbl.setText("Clinicalclient not bound exception:" +e.getMessage());
            } catch (Exception e) {
                System.out.println("HelloClient exception:" + e);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Register_pat_info.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          if (id.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER ID NUMBER",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
            } else if ((id.getText().length() < 7) || (id.getText().length() > 7)) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID SIZE OF ID NUMBER",
                        null,
                        JOptionPane.QUESTION_MESSAGE);
                id.setText("");
            }else{
        new print_refer(display.getText(), displayp.getText(),id.getText()).setVisible(true);
        this.setVisible(false);
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
         char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)
                || c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_SLASH) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            JOptionPane.showMessageDialog(null, "id number must be number",
                    null,
                    JOptionPane.QUESTION_MESSAGE);
            //gettoolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_idKeyTyped

    private void toKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toKeyTyped
          int i = evt.getKeyChar();
        if (!((Character.isAlphabetic(i)) || (i == KeyEvent.VK_SPACE) || (i == KeyEvent.VK_BACK_SPACE) || (i == KeyEvent.VK_DELETE))) {
            JOptionPane.showMessageDialog(null, "hospital name must be character",
                    null,
                    JOptionPane.QUESTION_MESSAGE);
            evt.consume();

        }
    }//GEN-LAST:event_toKeyTyped

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
         new Doctor(display.getText(), displayp.getText()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void prKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prKeyTyped
          char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)
                || c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            JOptionPane.showMessageDialog(null, "pulse rate must be number",
                    null,
                    JOptionPane.QUESTION_MESSAGE);
            //gettoolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_prKeyTyped

    private void bpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bpKeyTyped
          char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)
                || c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            JOptionPane.showMessageDialog(null, "blood presure must be number",
                    null,
                    JOptionPane.QUESTION_MESSAGE);
            //gettoolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_bpKeyTyped

    private void rrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rrKeyTyped
          char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)
                || c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            JOptionPane.showMessageDialog(null, "resparatory rate must be number",
                    null,
                    JOptionPane.QUESTION_MESSAGE);
            //gettoolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_rrKeyTyped

    private void tmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tmKeyTyped
          char c = evt.getKeyChar();
        if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)
                || c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            JOptionPane.showMessageDialog(null, "tempreture must be number",
                    null,
                    JOptionPane.QUESTION_MESSAGE);
            //gettoolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tmKeyTyped

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
            java.util.logging.Logger.getLogger(Prepare_Refer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prepare_Refer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prepare_Refer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prepare_Refer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prepare_Refer("", "","").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bp;
    private javax.swing.JLabel display;
    private javax.swing.JLabel displayp;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField pr;
    private javax.swing.JTextArea rfr;
    private javax.swing.JTextField rr;
    private javax.swing.JTextArea rx;
    private javax.swing.JTextField tm;
    private javax.swing.JTextField to;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
