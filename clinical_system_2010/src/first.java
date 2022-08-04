
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class first extends javax.swing.JFrame {

    /**
     * Creates new form first
     */
    public String[] info = new String[2];

    public first() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        display = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        enc = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txta = new javax.swing.JTextArea();
        dsctp = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        display.setColumns(20);
        display.setRows(5);
        jScrollPane1.setViewportView(display);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 45, -1, -1));

        jButton1.setText("get information");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 208, -1, -1));

        jLabel1.setText("first fram");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 11, 121, 28));

        jButton2.setText("print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 203, 80, 30));
        getContentPane().add(enc, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 90, 30));

        jButton3.setText("enc");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 70, 30));

        txta.setColumns(20);
        txta.setRows(5);
        jScrollPane2.setViewportView(txta);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 16, 490, 240));
        getContentPane().add(dsctp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//
//         PageFormat pf = null;
//             Graphics g = null;
//             int pageIndex;
//         
//           int height = display.getHeight();  
//        int numpages =1;
//        if (height >756) {
//            for (int i = 756; i < height;) {
//                numpages = numpages+1;
//                i= i +756;
//            }
//        }   
////        if (pageIndex >3)   
////        {
////            
////        }
////          //  return NO_SUCH_PAGE; 
////        else{  
//            Graphics2D g2 = (Graphics2D) g;   
//            g2.setFont(new Font("Monospaced", Font.PLAIN, 10));
//            display.setBounds(0, 0, display.getWidth(), display.getHeight());
//            // paper.getImageableWidth();
//            g2.translate(pf.getImageableX(), pf.getImageableY()); 
//            System.out.println("print " +pf.getImageableY());
//            Rectangle componentBounds = display.getBounds();   
//            g2.translate(-componentBounds.x, -componentBounds.y);   
//            g2.scale(1, 1);   
//            boolean wasBuffered = display.isDoubleBuffered();   
//            display.printAll(g2);   //printOut is my text area.
//            display.setDoubleBuffered(wasBuffered);   

            //return PAGE_EXISTS;   
//        }
        
        
        
        
//        
//        int width = display.getWidth() ;
//    int height = display.getHeight();
//    System.out.println("width is "+ width);
//    System.out.println("Height is "+height);
////
////    String font = display.getText();
////    int FontS = Integer.parseInt(font);
////    Font fonT = new Font("Monospaced", Font.PLAIN, 12);
////
////    display.setFont(new Font("Tahoma", Font.PLAIN, FontS));
//
//    PrinterJob pj = PrinterJob.getPrinterJob();   
//    PageFormat pf = pj.defaultPage(); 
//
//    Book bk = new Book();
//    Paper paper = new Paper(); 
//
//    double margin = 18;    
//    pj.setPageable(bk);
//
//    paper.setSize(612,792);
//    paper.setImageableArea(margin, margin
//                , paper.getWidth() -margin * 2
//                , paper.getHeight() - margin * 2);   
//    int lines = display.getLineCount();
//    System.out.println("lines = "+lines);
//    pf.setPaper(paper); 
//    int tall = (int) pf.getImageableHeight();
//    System.out.println("tall ="+tall);
//    System.out.println("orientation "+pf.getOrientation());
//
//    int pagenum =bk.getNumberOfPages();
//    System.out.println("pagenum = "+pagenum);
//    System.out.println("areah = "+height);
//    int numpages =1;
//    if (height >756) {
//        for (int i = 756; i < height;) {
//            numpages = numpages+1;
//            i= i +756;
//        }
//    }
//    System.out.println("numpages ="+numpages);
//   // bk.append(new MyPrintable(), pf,numpages);
//
//     // pj.setPrintable(new MyPrintable(), pf);   
//    if (pj.printDialog()) {   
//        try {   
//            display.setBounds(0, 0, display.getWidth(), display.getHeight());
//            display.print();
//        } catch (PrinterException pp) {   
//            System.out.println(pp);   
//        }   
//    }   
        
        
        
        ////        second sec = new second(this);
////        sec.setVisible(true);
//        String pass="getasew";
//        MessageDigest md=null;//new MessageDigest("MD5");
//        StringBuffer sb = new StringBuffer();
//       try {
//        md = MessageDigest.getInstance("MD5");
//        byte[] passBytes = pass.getBytes();
//        md.reset();
//        byte[] digested = md.digest(passBytes);
//        
//        for(int i=0;i<digested.length;i++){
//            sb.append(Integer.toHexString(0xff & digested[i]));
//        }
//        System.out.println(sb.toString());
//    } catch (NoSuchAlgorithmException ex) {
//       // CryptWithMD5
//      // Logger.getLogger(CryptWithMD5.class.getName()).log(Level.SEVERE, null, ex);
//    } 
//     
//       
//         String passs="getasew";
//         
//           MessageDigest mdd=null;//new MessageDigest("MD5");
//        StringBuffer sbs = new StringBuffer();
//       try {
//        mdd = MessageDigest.getInstance("MD5");
//        byte[] passBytes = passs.getBytes();
//        mdd.reset();
//        byte[] digested = mdd.digest(passBytes);
//        
//        for(int i=0;i<digested.length;i++){
//            sbs.append(Integer.toHexString(0xff & digested[i]));
//        }
//        System.out.println(sbs.toString());
//    } catch (NoSuchAlgorithmException ex) {
//       // CryptWithMD5
//      // Logger.getLogger(CryptWithMD5.class.getName()).log(Level.SEVERE, null, ex);
//    } 
//         
//         
//         
//       // MessageDigest md=null;//new MessageDigest("MD5");
////       try {
////        md = MessageDigest.getInstance("MD5");
////        byte[] passBytes = passs.getBytes();
//        md.reset();
//        byte[] digested = md.digest(passBytes);
//        StringBuffer sbd = new StringBuffer();
//        for(int i=0; i<digested.length-1;i++){
//            sbd.append(Integer.toHexString( digested[i] & 0xff ));
//        }
//        System.out.println(sbd.toString());
//    } catch (NoSuchAlgorithmException ex) {
//       // CryptWithMD5
//      // Logger.getLogger(CryptWithMD5.class.getName()).log(Level.SEVERE, null, ex);
//    } 
       
      // char sbb=sb.toCharArray();;
       
//          StringBuffer sbs = new StringBuffer(sb.length() * 2);
//        for (int i = 0; i < sb.length(); i++) {
//            int v = sb[i] & 0xff;
//            if (v < 16) {
//                sbs.append('0');
//            }
//            sbs.append(Integer.toHexString(v));
//        }
//        System.out.println(sbs.toString().toUpperCase());
       
       
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Boolean complet = txta.print();
            if (complet) {
                JOptionPane.showMessageDialog(null, "Done printing...");
            } else {
                JOptionPane.showMessageDialog(null, "printing...");
            }
        } catch (PrinterException ex) {
            Logger.getLogger(first.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed
 
    @SuppressWarnings("empty-statement")
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        
       // String s = "foo";
         String s = enc.getText();
  byte[] bytes = s.getBytes();
  StringBuilder  binary = new StringBuilder();
  for (byte b : bytes)
  {
     int val = b;
     for (int i = 0; i < 8; i++)
     {
        binary.append((val & 128) == 0 ? 0 : 1);
        val <<= 1;
     }
     binary.append(' ');
  }
  
  
  
  
//  String input = "Hello World!";
//char[] values = input.toCharArray();
//int f=values.length;
//      
//                  for(int i=0;i<f;i=i+3)
//         {
//    char letter=values[i];
//    // Get the integral value of the character.
//    int value = Convert.ToInt32(letter);
//    // Convert the decimal value to a hexadecimal value in string form.
//    String hexOutput = String.format("{0:X}", value);
//    System.out.println("Hexadecimal value of {0} is {1}"+ letter+ hexOutput);
//}
 
  
  //the variable name of the binary string is: "binary"
//int digitNumber = 1;
//    int sum = 0;
//    String binarys=""+binary;
//    int test = binarys.length()%4;
//    if(test!=0) {
//        binarys = padLeft(binarys, test);
//    }
//    for(int i = 0; i < binary.length(); i++){
//        if(digitNumber == 1)
//            sum+=Integer.parseInt(binarys.charAt(i) + "")*8;
//        else if(digitNumber == 2)
//            sum+=Integer.parseInt(binarys.charAt(i) + "")*4;
//        else if(digitNumber == 3)
//            sum+=Integer.parseInt(binarys.charAt(i) + "")*2;
//        else if(digitNumber == 4 || i < binarys.length()+1){
//            sum+=Integer.parseInt(binarys.charAt(i) + "")*1;
//            digitNumber = 0;
//            if(sum < 10)
//                System.out.print(sum);
//            else if(sum == 10)
//                System.out.print("A");
//            else if(sum == 11)
//                System.out.print("B");
//            else if(sum == 12)
//                System.out.print("C");
//            else if(sum == 13)
//                System.out.print("D");
//            else if(sum == 14)
//                System.out.print("E");
//            else if(sum == 15)
//                System.out.print("F");
//            sum=0;
//        }
//        digitNumber++;
//    }
  
    
  
 // System.out.println("ex="+binarys);
  
  
  
  String bin=""+binary;
   // String hex = Long.toHexString(Long.parseLong(bin, 2));
  //  String hex= Long.toHexString(Long.parseLong(bin, 2)).replaceAll(".*.{16}", "$1");
  String con=bin;
  System.out.println("con="+con);
           String name = con;
         int len=name.length();
       //  int no=Integer.parseInt(enc.getText(),2);//bibary to integer
     //    System.out.println(no);
         char[] cc = name.toCharArray();
      
          
               
                  for(int i=0;i<len-2;i=i+3)
         {
             char temp= cc[i];
             cc[i]=cc[i+2];
             cc[i+2]=temp;
         }
                  
                    System.out.println(cc);
          String x=String.valueOf(cc);
        display.setText(x);
           
        
        
        
         char[] dec = x.toCharArray();
         System.out.println(dec);
             
            for(int i=0;i<len-2;i=i+3)
         {
             char temp= dec[i+2];
             dec[i+2]=dec[i];
             dec[i]=temp;
         }
       
         
            
         //      BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
     
      
            
            
        
          System.out.println(dec);
          String xx=String.valueOf(dec);
        txta.setText(xx);
        
        
       //  System.out.println("Enter a binary value:");
      //String h =xx;//b.readLine();
      String input = s;//"011000010110000101100001";
String output = "";
for(int i = 0; i <= input.length() - 8; i+=8)
{
    int k = Integer.parseInt(input.substring(i, i+8), 2);
    output += (char) k;
} 
System.out.println("bin"+output);
     // int k = Integer.parseInt(h,2);  
      //String nn=String.valueOf(k);
      //String out = String.valueOf(k);
     // String out = new Character((char)k).toString();
    //  System.out.println("string: " + k);
       // Byte byt=Byte.parseByte(xx);
       // Byte byt=Byte.decode(xx);
        // System.out.println(byt);
        
        
        
        
        
        
        
        
        
        
        
        
//        int size = 0, tmp = 0, i = 0, j = 0;
//        String names = enc.getText();
//        size = names.length();
        
        
      //  String value = "abc123";
        // Loop through characters in this String.
     //   for (int i = 0; i < value.length(); i++) {
      /*  for (i = 0; i < size; i++) {
            char c = names.charAt(i);

            // See if the character is a letter or not.
            if (Character.isLetter(c)) {
                String x=String.valueOf(c);
                System.out.println(c + " = LETTER");
                //x=x+x;
                display.setText(x);
            } else {
                System.out.println(c);
               // display.setText(c);
            }
        }*/
        
        
        
        
        
        
        
      //  Character.isDigit(names);
   //     String name[] = new String[size];
        //if (size % 4 == 0) {
          //  display.setText(names);
        /*    for (i = 0; i < size; i++) {
               // for (j = 0; j < size; j++) {
                    if (i + 4 <= size) {
                        name[tmp] = name[i + 4];
                        name[i + 4] = name[i];
                        name[i] = name[tmp];
                    }
                    else{
                    name[tmp] = name[0];
                    name[0] = name[i];
                    name[i] = name[tmp];
                      name[tmp] = name[1];
                    name[1] = name[i];
                    name[i] = name[tmp];
                      name[tmp] = name[2];
                    name[2] = name[i];
                    name[i] = name[tmp];
                      name[tmp] = name[3];
                    name[3] = name[i];
                    name[i] = name[tmp];
                }
            }*/
            //  System.out.println(size);
       // } else {
        //    display.setText("no");
            // System.out.println("no");   
     //   }
//        for(i=0;i<size;i++)
//        System.out.println(name[i]);
    }//GEN-LAST:event_jButton3ActionPerformed
 
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
            java.util.logging.Logger.getLogger(first.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(first.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(first.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(first.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new first().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea display;
    private javax.swing.JDesktopPane dsctp;
    private javax.swing.JTextField enc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txta;
    // End of variables declaration//GEN-END:variables

    private String padLeft(String binarys, int test) {
      //  System.out.println( binarys);
        return String.format("%0$"+test+"s", binarys);
    }
}
