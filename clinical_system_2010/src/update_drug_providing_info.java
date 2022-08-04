
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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
public class update_drug_providing_info extends javax.swing.JFrame {

    /**
     * Creates new form update_drug_providing_info
     */
    public update_drug_providing_info(String x,String y) {
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel26 = new javax.swing.JLabel();
        strgth = new javax.swing.JTextField();
        drgnm = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        dsg = new javax.swing.JTextField();
        unt = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        qntty = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        untc = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cmnt = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        pn = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        proid = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        displayp = new javax.swing.JLabel();
        display = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1112, 693));
        setPreferredSize(new java.awt.Dimension(1112, 693));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel26.setText("FOR HOW LONG");
        jDesktopPane1.add(jLabel26);
        jLabel26.setBounds(60, 170, 150, 22);
        jDesktopPane1.add(strgth);
        strgth.setBounds(220, 170, 230, 30);

        drgnm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drgnmActionPerformed(evt);
            }
        });
        jDesktopPane1.add(drgnm);
        drgnm.setBounds(220, 130, 230, 30);

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel30.setText("DOSSAGE");
        jDesktopPane1.add(jLabel30);
        jLabel30.setBounds(60, 210, 110, 20);
        jDesktopPane1.add(dsg);
        dsg.setBounds(220, 210, 230, 30);

        unt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                untActionPerformed(evt);
            }
        });
        jDesktopPane1.add(unt);
        unt.setBounds(590, 80, 250, 40);

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel31.setText("UNIT");
        jDesktopPane1.add(jLabel31);
        jLabel31.setBounds(460, 90, 120, 17);

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel32.setText("QUANTITY");
        jDesktopPane1.add(jLabel32);
        jLabel32.setBounds(460, 130, 120, 17);
        jDesktopPane1.add(qntty);
        qntty.setBounds(590, 130, 250, 30);

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel33.setText("UNIT COST");
        jDesktopPane1.add(jLabel33);
        jLabel33.setBounds(460, 170, 120, 17);
        jDesktopPane1.add(untc);
        untc.setBounds(590, 170, 250, 30);

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel34.setText("COMMENT");
        jDesktopPane1.add(jLabel34);
        jLabel34.setBounds(460, 210, 120, 17);

        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButton1);
        jButton1.setBounds(240, 363, 110, 30);

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel35.setText("DRUG NAME");
        jDesktopPane1.add(jLabel35);
        jLabel35.setBounds(60, 130, 150, 22);

        cmnt.setColumns(20);
        cmnt.setRows(5);
        jScrollPane1.setViewportView(cmnt);

        jDesktopPane1.add(jScrollPane1);
        jScrollPane1.setBounds(590, 210, 250, 40);

        jButton5.setText("SEARCH");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButton5);
        jButton5.setBounds(460, 40, 180, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("DRUG PROVIDING INFORMATION REGISTRATION PAGE");
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(40, 10, 496, 20);

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setText("ID NUMBER");
        jDesktopPane1.add(jLabel25);
        jLabel25.setBounds(60, 40, 104, 22);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel24.setText("PATIENT NAME");
        jDesktopPane1.add(jLabel24);
        jLabel24.setBounds(60, 90, 136, 22);

        pn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnActionPerformed(evt);
            }
        });
        jDesktopPane1.add(pn);
        pn.setBounds(220, 90, 230, 30);

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jDesktopPane1.add(id);
        id.setBounds(220, 40, 230, 30);
        jDesktopPane1.add(proid);
        proid.setBounds(414, 370, 80, 30);
        jDesktopPane1.add(jPanel1);
        jPanel1.setBounds(10, 10, 860, 450);

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 880, 470));
        getContentPane().add(displayp, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 140, 20));
        getContentPane().add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 150, 20));

        jMenu1.setText("BACK                ");

        jMenu2.setText("BACK");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String drug_pro_id=null;
        try {
            Mainclass ob=new Mainclass();
            // ob.id_number=id.getText();

            RMIInterface hello;
            try {
                hello = (RMIInterface)
                Naming.lookup("//localhost/clinical");
                if( id.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "PLEASE ENTER ID NUMBER",
                        null,
                        JOptionPane.PLAIN_MESSAGE);
                }
                else
                {
                    String fetch[]=new String[5000];
                    fetch = hello.search_for_drug_pro_info(id.getText());
                    int c=fetch.length;
                    int i=0,j=0,idx=0;
                    if(c>=1)
                    {
                    while(i<c)
                    {
                        dsg.setText(fetch[11]);
                        proid.setText(fetch[0]);
                        cmnt.setText(fetch[16]);
                        drgnm.setText(fetch[10]);
                        unt.setText(fetch[13]);
                        qntty.setText(fetch[14]);
                        untc.setText(fetch[15]);

                        
                        id.setText(fetch[6]);
                        pn.setText(fetch[1]);
                        strgth.setText(fetch[12]);
                        i++;
                    }
                    JOptionPane.showMessageDialog(null, "YOU CAN CONTINUE",
                        null,
                        JOptionPane.PLAIN_MESSAGE);
                }
                    else
                    {
                       JOptionPane.showMessageDialog(null, "THERE LIKR THIS ID",
                        null,
                        JOptionPane.PLAIN_MESSAGE);  
                    }
                }
                
            } catch (NotBoundException ex) {
                Logger.getLogger(Register_patient_lab_result.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Register_patient_lab_result.class.getName()).log(Level.SEVERE, null, ex);
            }
            //  String id_number,String history_id,String opo,String lab_id,String reporter_name,String lab_test_result,String remark
            //  System.out.println(hello.investigation_record(ob.id_number/*,ob.card_number,ob.address,ob.age*/,ob.history_id,ob.requested_first_name,ob.requested_last_name,ob.opo,ob.stool_examination));
            // TODO add your handling code here:
        } catch (RemoteException ex) {
            Logger.getLogger(Register_patient_lab_result.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Mainclass ob;
            ob = new Mainclass();
            ob.id_number=id.getText();
            String drugname=drgnm.getText();
            ob.strength=strgth.getText();
            ob.dose=dsg.getText();
            String unit=unt.getText();
            ob.quantity=qntty.getText();
            String unitcost=untc.getText();
            String comment=cmnt.getText();
            String pro_id=proid.getText();
            int proid=Integer.parseInt(pro_id);
            int quant=Integer.parseInt(ob.quantity);
            try
            {
                RMIInterface hello=(RMIInterface)
                Naming.lookup("//localhost/clinical");

                System.out.println(hello.update_drug_pro_info(proid,ob.id_number,drugname,ob.strength,ob.dose,unit,quant,unitcost,comment));
                JOptionPane.showMessageDialog(null, "SUCCESSFULLY  UPDATED",
                    null,
                    JOptionPane.PLAIN_MESSAGE);

            }
            catch(NotBoundException e){
                System.out.println("Clinicalclient not bound exception:" +e);
                // lbl.setText("Clinicalclient not bound exception:" +e.getMessage());
            }
            catch(Exception e){
                System.out.println("HelloClient exception:" +e);
            }

        } catch (RemoteException ex) {
            Logger.getLogger(Register_pat_info.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void untActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_untActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_untActionPerformed

    private void drgnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drgnmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drgnmActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        proid.setVisible(false);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
     new Pharmacist(display.getText(),displayp.getText()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

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
            java.util.logging.Logger.getLogger(update_drug_providing_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(update_drug_providing_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(update_drug_providing_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(update_drug_providing_info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new update_drug_providing_info("","").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea cmnt;
    private javax.swing.JLabel display;
    private javax.swing.JLabel displayp;
    private javax.swing.JTextField drgnm;
    private javax.swing.JTextField dsg;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pn;
    private javax.swing.JLabel proid;
    private javax.swing.JTextField qntty;
    private javax.swing.JTextField strgth;
    private javax.swing.JTextField unt;
    private javax.swing.JTextField untc;
    // End of variables declaration//GEN-END:variables
}
