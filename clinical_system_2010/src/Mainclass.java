
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class Mainclass extends UnicastRemoteObject implements RMIInterface {

    private Object V;
    private static final String voicename = "kevin16";

    public Mainclass() throws RemoteException {
    }
    String time, bp, pr, tm, rr, ch, hpi, diagnosis, rx_given, reason_refer, hospital_name, requested_first_name, requested_last_name, stool_examination, opo, history_id;
    String password, member_id, user_nme, first_name, middle_name, dose, dates, drug_name, ferquency, strength, quantity, last_name, age, sex, occupation, religion, address, id_number, phone_number, email, profssion, card_number;
    int inc;
    String department, block_number, dormetry_number;

    public int change_password(String member_id, String user_name, String old_password, String profession, String new_password) {
        int ci = 0, c = 0;
        //System.out.println(new_password);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`member`   where member_id='" + member_id + "' and profession='" + profession + "'  and statues='1'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                ci++;
            }

            if (ci >= 1) {

                String selects = "select *from `clinicaldb`.`user_account`   where member_id='" + member_id + "' and profession='" + profession + "'  and statues='1'  and user_name='" + user_name + "' and password='" + old_password + "'";
                ResultSet rs = stmt.executeQuery(selects);
                while (rs.next()) {
                    c++;
                }
                if (c >= 1) {
                    System.out.println(c);

                    String update = "update `clinicaldb`.`user_account` SET password='" + new_password + "' where member_id='" + member_id + "' and user_name='" + user_name + "' and profession='" + profession + "' and statues='1'";
                    stmt.executeUpdate(update);
                }
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return c;
    }

    public int forgot_password(String member_id, String user_name, String profession, String new_password) {
        int ci = 0, c = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`member`   where member_id='" + member_id + "' and profession='" + profession + "'  and statues='1'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                ci++;
            }

            if (ci >= 1) {

                String selects = "select *from `clinicaldb`.`user_account`   where member_id='" + member_id + "' and profession='" + profession + "'  and statues='1'  and user_name='" + user_name + "'";
                ResultSet rs = stmt.executeQuery(selects);
                while (rs.next()) {
                    c++;
                }
                if (c >= 1) {
                    System.out.println(c);

                    String update = "update `clinicaldb`.`user_account` SET password='" + new_password + "' where member_id='" + member_id + "' and user_name='" + user_name + "' and profession='" + profession + "' and statues='1'";
                    stmt.executeUpdate(update);
                }
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return c;
    }

    public String[] print_sickleaves(String id_number) {
        int ci = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`sickleave`   where id_number='" + id_number + "'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                ci++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int arraysize = ci * 11;
        String customer[] = new String[arraysize];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(w, y, z);
            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`sickleave`   where id_number='" + id_number + "' ORDER BY sickleave_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            int i = 0, j = 0;
            while (rs.next()) {
                i++;
            }
            if (i >= 1) {
                String sel = "select *from `clinicaldb`.`sickleave`  where id_number='" + id_number + "' ORDER BY sickleave_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet r = stmt.executeQuery(sel);
                int ii = 0, jj = 0;
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);
                    idx++;
                    customer[idx] = r.getString(5);
                    idx++;
                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;
                    customer[idx] = (r.getString(9));
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;
                    customer[idx] = (r.getString(11));
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;
                    customer[idx] = (r.getString(13));
                    idx++;
                    customer[idx] = (r.getString(14));
                    idx++;
                    customer[idx] = (r.getString(15));
                    idx++;
                    customer[idx] = (r.getString(16));
                    idx++;
                    customer[idx] = (r.getString(17));
                    idx++;
                    customer[idx] = (r.getString(18));
                    idx++;
                    customer[idx] = (r.getString(19));
                    idx++;
                    customer[idx] = (r.getString(20));
                    idx++;
                    customer[idx] = (r.getString(21));
                    idx++;
                    customer[idx] = (r.getString(22));
                    idx++;
                    customer[idx] = (r.getString(23));
                    idx++;
                    customer[idx] = (r.getString(24));
                    idx++;
                    customer[idx] = (r.getString(25));
                    idx++;
                    customer[idx] = (r.getString(26));
                    idx++;
                    customer[idx] = (r.getString(27));
                    idx++;
                }
            } else {
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return customer;


    }

    public String[] print_sickleave(String id_number, String visited_date) {

        int ci = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`patient_history`   where id_number='" + id_number + "' and medication_date='" + visited_date + "'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                ci++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int arraysize = ci * 64;
        String customer[] = new String[arraysize];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(w, y, z);
            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`patient_history`   where id_number='" + id_number + "'  and medication_date='" + visited_date + "' ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            int i = 0, j = 0;
            while (rs.next()) {
                i++;
            }
            if (i >= 1) {
                String sel = "select *from `clinicaldb`.`patient_history`  where id_number='" + id_number + "'  and medication_date='" + visited_date + "' ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet r = stmt.executeQuery(sel);
                int ii = 0, jj = 0;
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);
                    idx++;
                    customer[idx] = r.getString(5);
                    idx++;
                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;
                    customer[idx] = (r.getString(9));
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;
                    customer[idx] = (r.getString(11));
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;
                    customer[idx] = (r.getString(13));
                    idx++;
                    customer[idx] = (r.getString(14));
                    idx++;
                    customer[idx] = (r.getString(15));
                    idx++;
                    customer[idx] = (r.getString(16));
                    idx++;
                    customer[idx] = (r.getString(17));
                    idx++;
                    customer[idx] = (r.getString(18));
                    idx++;
                    customer[idx] = (r.getString(19));
                    idx++;
                    customer[idx] = (r.getString(20));
                    idx++;
                    customer[idx] = (r.getString(21));
                    idx++;
                    customer[idx] = (r.getString(22));
                    idx++;
                    customer[idx] = (r.getString(23));
                    idx++;
                    customer[idx] = (r.getString(24));
                    idx++;
                    customer[idx] = (r.getString(25));
                    idx++;
                    customer[idx] = (r.getString(26));
                    idx++;
                    customer[idx] = (r.getString(27));
                    idx++;
                }
            } else {
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return customer;


    }

    public String[] view_refers(String id_number,String date) {

        int ci = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`referral`   where id_number='" + id_number + "' and date='"+date+"'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                ci++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int arraysize = ci * 21;
        String customer[] = new String[arraysize];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(w, y, z);
            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`referral`   where id_number='" + id_number + "'and date='"+date+"' ORDER BY refer_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            int i = 0, j = 0;
            while (rs.next()) {
                i++;
            }
            if (i >= 1) {
                String sel = "select *from `clinicaldb`.`referral`  where id_number='" + id_number + "'and date='"+date+"' ORDER BY refer_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet r = stmt.executeQuery(sel);
                int ii = 0, jj = 0;
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);
                    idx++;
                    customer[idx] = r.getString(5);
                    idx++;
                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;
                    customer[idx] = (r.getString(9));
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;
                    customer[idx] = (r.getString(11));
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;
                    customer[idx] = (r.getString(13));
                    idx++;
                    customer[idx] = (r.getString(14));
                    idx++;
                    customer[idx] = (r.getString(15));
                    idx++;
                    customer[idx] = (r.getString(16));
                    idx++;
                    customer[idx] = (r.getString(17));
                    idx++;
                    customer[idx] = (r.getString(18));
                    idx++;
                    customer[idx] = (r.getString(19));
                    idx++;
                    customer[idx] = (r.getString(20));
                    idx++;
                    customer[idx] = (r.getString(21));
                    idx++;
                }
            } else {
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return customer;


    }

    public String[] print_refer(String id_number) {

        int ci = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`referral`   where id_number='" + id_number + "'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                ci++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int arraysize = ci * 21;
        String customer[] = new String[arraysize];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(w, y, z);
            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`referral`   where id_number='" + id_number + "' ORDER BY refer_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            int i = 0, j = 0;
            while (rs.next()) {
                i++;
            }
            if (i >= 1) {
                String sel = "select *from `clinicaldb`.`referral`  where id_number='" + id_number + "' ORDER BY refer_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet r = stmt.executeQuery(sel);
                int ii = 0, jj = 0;
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);
                    idx++;
                    customer[idx] = r.getString(5);
                    idx++;
                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;
                    customer[idx] = (r.getString(9));
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;
                    customer[idx] = (r.getString(11));
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;
                    customer[idx] = (r.getString(13));
                    idx++;
                    customer[idx] = (r.getString(14));
                    idx++;
                    customer[idx] = (r.getString(15));
                    idx++;
                    customer[idx] = (r.getString(16));
                    idx++;
                    customer[idx] = (r.getString(17));
                    idx++;
                    customer[idx] = (r.getString(18));
                    idx++;
                    customer[idx] = (r.getString(19));
                    idx++;
                    customer[idx] = (r.getString(20));
                    idx++;
                    customer[idx] = (r.getString(21));
                    idx++;
                }
            } else {
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return customer;
    }

    public String[] view_lab_result(String reptyp, String sex) {
        int ci = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`investigation_result` where sex='" + sex + "'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                ci++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int arraysize = ci * 13;
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dx = s.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(d);
        String first = "";
        String second = "";
        String third = "";
        String conc = null;
        int cn = 0;
        int length = dx.length();
        char[] ccx = dx.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            first = first + ccx[h];
        }
        int length1 = dx.length();
        char[] ccx1 = dx.toCharArray();
        for (int h = 5; h < 7; h = h + 1) {
            second = second + ccx1[h];
        }
        int length2 = dx.length();
        char[] ccx2 = dx.toCharArray();
        for (int h = 8; h < 10; h = h + 1) {
            third = third + ccx2[h];
        }
        conc = first + second + third;
        int compute = 0;
        int dates = Integer.parseInt(conc);
        cn = Integer.parseInt(first);
        if (reptyp.equals("WEEKLY")) {
            compute = dates - 7;
        } else if (reptyp.equals("MONTHLY")) {
            compute = dates - 30;
        } else if (reptyp.equals("ANNUALLY")) {
            compute = cn - 1;
            first = String.valueOf(compute);
            String comps = first + second + third;
            compute = Integer.parseInt(comps);
        }
        String computes = String.valueOf(compute);
        String thirdst = null;
        String thirdsts = null;

        String firsts = "";
        String seconds = "";
        String thirds = "";
        String concs = null;
        int lengths = computes.length();
        char[] ccxs = computes.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            firsts = firsts + ccxs[h];
        }
        firsts = firsts + "-";
        int lengths1 = computes.length();
        char[] ccxs1 = computes.toCharArray();
        for (int h = 4; h < 6; h = h + 1) {
            seconds = seconds + ccxs1[h];
        }
        seconds = seconds + "-";
        int lengthss2 = computes.length();
        char[] ccxss2 = computes.toCharArray();
        for (int h = 6; h < 8; h = h + 1) {
            thirds = thirds + ccxss2[h];
        }
        int thirdstss = Integer.parseInt(thirds);
        if (thirdstss > 30) {
            thirdstss = thirdstss - 70;
            thirds = String.valueOf(thirdstss);
        } else {
            thirds = thirds;
        }
        concs = firsts + seconds + thirds;
        String customer[] = new String[arraysize];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`investigation_result` where  collection_date>='" + concs + "' and sex='" + sex + "'";
            ResultSet r = stmt.executeQuery(select);
            int idx = 0;
            int c = 0;
            while (r.next()) {
                c++;
                customer[idx] = (r.getString(1));
                idx++;
                customer[idx] = (r.getString(2));
                idx++;
                customer[idx] = (r.getString(3));
                idx++;
                customer[idx] = (r.getString(4));
                idx++;
                customer[idx] = (r.getString(5));
                idx++;
                customer[idx] = (r.getString(6));
                idx++;
                customer[idx] = (r.getString(7));
                idx++;
                customer[idx] = (r.getString(8));
                idx++;
                customer[idx] = (r.getString(9));
                idx++;
                customer[idx] = (r.getString(10));
                idx++;
                customer[idx] = (r.getString(11));
                idx++;
                customer[idx] = (r.getString(12));
                idx++;
                customer[idx] = (r.getString(13));
                idx++;
            }


        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return customer;

    }

    public String[] view_member(String reptyp, String sex) {
        int ci = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`member` where sex='" + sex + "'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                ci++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int arraysize = ci * 13;
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dx = s.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(d);
        String first = "";
        String second = "";
        String third = "";
        String conc = null;
        int cn = 0;
        int length = dx.length();
        char[] ccx = dx.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            first = first + ccx[h];
        }
        int length1 = dx.length();
        char[] ccx1 = dx.toCharArray();
        for (int h = 5; h < 7; h = h + 1) {
            second = second + ccx1[h];
        }
        int length2 = dx.length();
        char[] ccx2 = dx.toCharArray();
        for (int h = 8; h < 10; h = h + 1) {
            third = third + ccx2[h];
        }
        conc = first + second + third;
        int compute = 0;
        int dates = Integer.parseInt(conc);
        cn = Integer.parseInt(first);
        if (reptyp.equals("WEEKLY")) {
            compute = dates - 7;
        } else if (reptyp.equals("MONTHLY")) {
            compute = dates - 30;
        } else if (reptyp.equals("ANNUALLY")) {
            compute = cn - 1;
            first = String.valueOf(compute);
            String comps = first + second + third;
            compute = Integer.parseInt(comps);
        }
        String computes = String.valueOf(compute);

        String thirdst = null;
        String thirdsts = null;

        String firsts = "";
        String seconds = "";
        String thirds = "";
        String concs = null;
        int lengths = computes.length();
        char[] ccxs = computes.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            firsts = firsts + ccxs[h];
        }
        firsts = firsts + "-";
        int lengths1 = computes.length();
        char[] ccxs1 = computes.toCharArray();
        for (int h = 4; h < 6; h = h + 1) {
            seconds = seconds + ccxs1[h];
        }
        seconds = seconds + "-";
        int lengthss2 = computes.length();
        char[] ccxss2 = computes.toCharArray();
        for (int h = 6; h < 8; h = h + 1) {
            thirds = thirds + ccxss2[h];
        }
        int thirdstss = Integer.parseInt(thirds);
        if (thirdstss > 30) {
            thirdstss = thirdstss - 70;
            thirds = String.valueOf(thirdstss);
        } else {
            thirds = thirds;
        }
        concs = firsts + seconds + thirds;
        String customer[] = new String[arraysize];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`member` where sex='" + sex + "' and date>'" + concs + "'";
            ResultSet r = stmt.executeQuery(select);
            int idx = 0;
            int c = 0;
            while (r.next()) {
                c++;
                customer[idx] = (r.getString(1));
                idx++;
                customer[idx] = (r.getString(2));
                idx++;
                customer[idx] = (r.getString(3));
                idx++;
                customer[idx] = (r.getString(4));
                idx++;
                customer[idx] = (r.getString(5));
                idx++;
                customer[idx] = (r.getString(6));
                idx++;
                customer[idx] = (r.getString(7));
                idx++;
                customer[idx] = (r.getString(8));
                idx++;
                customer[idx] = (r.getString(9));
                idx++;
                customer[idx] = (r.getString(10));
                idx++;
                customer[idx] = (r.getString(11));
                idx++;
                customer[idx] = (r.getString(12));
                idx++;
                customer[idx] = (r.getString(13));
                idx++;
            }


        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return customer;
    }

    public String[] Search_for_Update_examination(String infoid) {

        String customer[] = new String[7000];

        String historyid = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(w, y, z);

            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`patient_history` where history_id='" + history_id + "' ORDER BY history_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            int i = 0, j = 0;
            while (rs.next()) {
                i++;
            }

            if (i >= 1) {

                String sel = "select *from `clinicaldb`.`patient_history`  where history_id='" + history_id + "' ORDER BY history_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet r = stmt.executeQuery(sel);
                int ii = 0, jj = 0;
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);
                    idx++;
                    customer[idx] = r.getString(5);
                    idx++;
                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;
                    customer[idx] = (r.getString(9));
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;
                    customer[idx] = (r.getString(11));
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;

                    customer[idx] = (r.getString(13));
                    idx++;
                    customer[idx] = (r.getString(14));
                    idx++;
                    customer[idx] = (r.getString(15));
                    idx++;
                    customer[idx] = (r.getString(16));
                    idx++;
                    customer[idx] = (r.getString(17));
                    idx++;
                    customer[idx] = (r.getString(18));
                    idx++;
                    customer[idx] = (r.getString(19));
                    idx++;
                    customer[idx] = (r.getString(20));
                    idx++;
                    customer[idx] = (r.getString(21));
                    idx++;
                    customer[idx] = (r.getString(22));
                    idx++;

                    customer[idx] = (r.getString(23));
                    idx++;
                    customer[idx] = (r.getString(24));
                    idx++;
                    customer[idx] = (r.getString(25));
                    idx++;
                    customer[idx] = (r.getString(26));
                    idx++;
                }
            } else {
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }




        return customer;
    }

    public String[] Search_for_Update_examination1(String history_id) {
        String customer[] = new String[7000];

        String historyid = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(w, y, z);

            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`patient_history` where history_id='" + history_id + "' ORDER BY history_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            int i = 0, j = 0;
            while (rs.next()) {
                i++;
            }

            if (i >= 1) {

                String sel = "select *from `clinicaldb`.`patient_history`  where history_id='" + history_id + "' ORDER BY history_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet r = stmt.executeQuery(sel);
                int ii = 0, jj = 0;
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);
                    idx++;
                    customer[idx] = r.getString(5);
                    idx++;
                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;
                    customer[idx] = (r.getString(9));
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;
                    customer[idx] = (r.getString(11));
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;

                    customer[idx] = (r.getString(13));
                    idx++;
                    customer[idx] = (r.getString(14));
                    idx++;
                    customer[idx] = (r.getString(15));
                    idx++;
                    customer[idx] = (r.getString(16));
                    idx++;
                    customer[idx] = (r.getString(17));
                    idx++;
                    customer[idx] = (r.getString(18));
                    idx++;
                    customer[idx] = (r.getString(19));
                    idx++;
                    customer[idx] = (r.getString(20));
                    idx++;
                    customer[idx] = (r.getString(21));
                    idx++;
                    customer[idx] = (r.getString(22));
                    idx++;
                    customer[idx] = (r.getString(23));
                    idx++;
                    customer[idx] = (r.getString(24));
                    idx++;
                    customer[idx] = (r.getString(25));
                    idx++;
                    customer[idx] = (r.getString(26));
                    idx++;
                    customer[idx] = (r.getString(27));
                    idx++;
                }
            } else {
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return customer;
    }

    public String[] Update_investigation(String id_number) {
        String customer[] = new String[7000];

        String historyid = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(w, y, z);

            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`investigationtbl` where patient_id='" + id_number + "' ORDER BY requist_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            int i = 0, j = 0;
            while (rs.next()) {
                i++;
            }

            if (i >= 1) {

                String sel = "select *from `clinicaldb`.`investigationtbl` where patient_id='" + id_number + "' ORDER BY requist_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet r = stmt.executeQuery(sel);
                int ii = 0, jj = 0;
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);
                    idx++;
                    customer[idx] = r.getString(5);
                    idx++;
                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;
                    customer[idx] = (r.getString(9));
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;
                    customer[idx] = (r.getString(11));
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;

                    /*customer[idx] = (r.getString(13));
                     idx++;
                     customer[idx] = (r.getString(14));
                     idx++;
                     customer[idx] = (r.getString(15));
                     idx++;
                     customer[idx] = (r.getString(16));
                     idx++;
                     customer[idx] = (r.getString(17));
                     idx++;
                     customer[idx] = (r.getString(18));
                     idx++;
                     customer[idx] = (r.getString(19));
                     idx++;
                     customer[idx] = (r.getString(20));
                     idx++;
                     customer[idx] = (r.getString(21));
                     idx++;
                     customer[idx] = (r.getString(22));
                     idx++;
                     customer[idx] = (r.getString(23));
                     idx++;
                     customer[idx] = (r.getString(24));
                     idx++;
                     customer[idx] = (r.getString(25));
                     idx++;
                     customer[idx] = (r.getString(26));
                     idx++;
                     customer[idx] = (r.getString(27));
                     idx++;






                     customer[idx] = r.getString(28);
                     idx++;
                     customer[idx] = r.getString(29);
                     idx++;
                     customer[idx] = r.getString(30);
                     idx++;
                     customer[idx] = r.getString(31);
                     idx++;
                     customer[idx] = r.getString(32);
                     idx++;
                     customer[idx] = r.getString(33);
                     idx++;
                     customer[idx] = r.getString(34);
                     idx++;
                     customer[idx] = r.getString(35);
                     idx++;
                     customer[idx] = r.getString(36);
                     idx++;
                     customer[idx] = (r.getString(37));
                     idx++;
                     customer[idx] = (r.getString(38));
                     idx++;
                     customer[idx] = (r.getString(39));
                     idx++;
                     customer[idx] = (r.getString(40));
                     idx++;
                     customer[idx] = (r.getString(41));
                     idx++;
                     customer[idx] = (r.getString(42));
                     idx++;

                     customer[idx] = (r.getString(43));
                     idx++;
                     customer[idx] = (r.getString(44));
                     idx++;
                     customer[idx] = (r.getString(45));
                     idx++;
                     customer[idx] = (r.getString(46));
                     idx++;
                     customer[idx] = (r.getString(47));
                     idx++;
                     customer[idx] = (r.getString(48));
                     idx++;
                     customer[idx] = (r.getString(49));
                     idx++;
                     customer[idx] = (r.getString(50));
                     idx++;
                     customer[idx] = (r.getString(51));
                     idx++;
                     customer[idx] = (r.getString(52));
                     idx++;
                     customer[idx] = (r.getString(53));
                     idx++;
                     customer[idx] = (r.getString(54));
                     idx++;
                     customer[idx] = (r.getString(55));
                     idx++;
                     customer[idx] = (r.getString(56));
                     idx++;
                     customer[idx] = (r.getString(57));
                     idx++;
                     customer[idx] = (r.getString(58));
                     idx++;
                     customer[idx] = (r.getString(59));
                     idx++;
                     customer[idx] = (r.getString(60));
                     idx++;
                     customer[idx] = (r.getString(61));
                     idx++;
                     customer[idx] = (r.getString(62));
                     idx++;
                     customer[idx] = (r.getString(63));
                     idx++;
                     customer[idx] = (r.getString(64));
                     idx++;*/

                }
            } else {
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }




        return customer;

    }

    public String[] Update_examination1(String id_number) {

        String customer[] = new String[7000];

        String historyid = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(w, y, z);

            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "' ORDER BY history_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            int i = 0, j = 0;
            while (rs.next()) {
                i++;
            }
            if (i >= 1) {
                String sel = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "' ORDER BY history_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet r = stmt.executeQuery(sel);
                int ii = 0, jj = 0;
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);
                    idx++;
                    customer[idx] = r.getString(5);
                    idx++;
                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;
                    customer[idx] = (r.getString(9));
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;
                    customer[idx] = (r.getString(11));
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;

                    customer[idx] = (r.getString(13));
                    idx++;
                    customer[idx] = (r.getString(14));
                    idx++;
                    customer[idx] = (r.getString(15));
                    idx++;
                    customer[idx] = (r.getString(16));
                    idx++;
                    customer[idx] = (r.getString(17));
                    idx++;
                    customer[idx] = (r.getString(18));
                    idx++;
                    customer[idx] = (r.getString(19));
                    idx++;
                    customer[idx] = (r.getString(20));
                    idx++;
                    customer[idx] = (r.getString(21));
                    idx++;
                    customer[idx] = (r.getString(22));
                    idx++;
                    customer[idx] = (r.getString(23));
                    idx++;
                    customer[idx] = (r.getString(24));
                    idx++;
                    customer[idx] = (r.getString(25));
                    idx++;
                    customer[idx] = (r.getString(26));
                    idx++;
                    customer[idx] = (r.getString(27));
                    idx++;
                    customer[idx] = r.getString(28);
                    idx++;
                    customer[idx] = r.getString(29);
                    idx++;
                    customer[idx] = r.getString(30);
                    idx++;
                    customer[idx] = r.getString(31);
                    idx++;
                    customer[idx] = r.getString(32);
                    idx++;
                    customer[idx] = r.getString(33);
                    idx++;
                    customer[idx] = r.getString(34);
                    idx++;
                    customer[idx] = r.getString(35);
                    idx++;
                    customer[idx] = r.getString(36);
                    idx++;
                    customer[idx] = (r.getString(37));
                    idx++;
                    customer[idx] = (r.getString(38));
                    idx++;
                    customer[idx] = (r.getString(39));
                    idx++;
                    customer[idx] = (r.getString(40));
                    idx++;
                    customer[idx] = (r.getString(41));
                    idx++;
                    customer[idx] = (r.getString(42));
                    idx++;

                    customer[idx] = (r.getString(43));
                    idx++;
                    customer[idx] = (r.getString(44));
                    idx++;
                    customer[idx] = (r.getString(45));
                    idx++;
                    customer[idx] = (r.getString(46));
                    idx++;
                    customer[idx] = (r.getString(47));
                    idx++;
                    customer[idx] = (r.getString(48));
                    idx++;
                    customer[idx] = (r.getString(49));
                    idx++;
                    customer[idx] = (r.getString(50));
                    idx++;
                    customer[idx] = (r.getString(51));
                    idx++;
                    customer[idx] = (r.getString(52));
                    idx++;
                    customer[idx] = (r.getString(53));
                    idx++;
                    customer[idx] = (r.getString(54));
                    idx++;
                    customer[idx] = (r.getString(55));
                    idx++;
                    customer[idx] = (r.getString(56));
                    idx++;
                    customer[idx] = (r.getString(57));
                    idx++;
                    customer[idx] = (r.getString(58));
                    idx++;
                    customer[idx] = (r.getString(59));
                    idx++;
                    customer[idx] = (r.getString(60));
                    idx++;
                    customer[idx] = (r.getString(61));
                    idx++;
                    customer[idx] = (r.getString(62));
                    idx++;
                    customer[idx] = (r.getString(63));
                    idx++;
                    customer[idx] = (r.getString(64));
                    idx++;

                }
            } else {
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }




        return customer;
    }

    public String[] Update_examination1() {

        String customer[] = new String[7000];

        String historyid = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(w, y, z);

            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`patient_history` ORDER BY history_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            int i = 0, j = 0;
            while (rs.next()) {
                i++;
            }

            if (i >= 1) {

                String sel = "select *from `clinicaldb`.`patient_history` ORDER BY history_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet r = stmt.executeQuery(sel);
                int ii = 0, jj = 0;
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);
                    idx++;
                    customer[idx] = r.getString(5);
                    idx++;
                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;
                    customer[idx] = (r.getString(9));
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;
                    customer[idx] = (r.getString(11));
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;

                    customer[idx] = (r.getString(13));
                    idx++;
                    customer[idx] = (r.getString(14));
                    idx++;
                    customer[idx] = (r.getString(15));
                    idx++;
                    customer[idx] = (r.getString(16));
                    idx++;
                    customer[idx] = (r.getString(17));
                    idx++;
                    customer[idx] = (r.getString(18));
                    idx++;
                    customer[idx] = (r.getString(19));
                    idx++;
                    customer[idx] = (r.getString(20));
                    idx++;
                    customer[idx] = (r.getString(21));
                    idx++;
                    customer[idx] = (r.getString(22));
                    idx++;

                    customer[idx] = (r.getString(23));
                    idx++;
                    customer[idx] = (r.getString(24));
                    idx++;
                    customer[idx] = (r.getString(25));
                    idx++;
                    customer[idx] = (r.getString(26));
                    idx++;
                    customer[idx] = (r.getString(27));
                    idx++;
                }
            } else {
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }




        return customer;
    }

    public String[] update_patient_information(String department, String bloclk_number, String dorm_number, String infoid, String id_number, String first_name, String middle_name, String last_name, String age, String sex, String occupation, String religion, String address, String statue) {

        /* String name = first_name;
         int len = name.length();
         //  int no=Integer.parseInt(enc.getText(),2);//bibary to integer
         //    System.out.println(no);
         char[] cc = name.toCharArray();



         for (int i = 0; i < len - 2; i = i + 3) {
         char temp = cc[i];
         cc[i] = cc[i + 2];
         cc[i + 2] = temp;
         }
         first_name = String.valueOf(cc);





         name = middle_name;
         len = name.length();
         cc = name.toCharArray();



         for (int i = 0; i < len - 2; i = i + 3) {
         char temp = cc[i];
         cc[i] = cc[i + 2];
         cc[i + 2] = temp;
         }
         middle_name = String.valueOf(cc);





         name = last_name;
         len = name.length();
         cc = name.toCharArray();



         for (int i = 0; i < len - 2; i = i + 3) {
         char temp = cc[i];
         cc[i] = cc[i + 2];
         cc[i + 2] = temp;
         }
         //   System.out.println(cc);
         last_name = String.valueOf(cc);



         name = occupation;
         len = name.length();
         cc = name.toCharArray();



         for (int i = 0; i < len - 2; i = i + 3) {
         char temp = cc[i];
         cc[i] = cc[i + 2];
         cc[i + 2] = temp;
         }
         //  System.out.println(cc);
         occupation = String.valueOf(cc);





         name = address;
         len = name.length();
         cc = name.toCharArray();



         for (int i = 0; i < len - 2; i = i + 3) {
         char temp = cc[i];
         cc[i] = cc[i + 2];
         cc[i + 2] = temp;
         }
         address = String.valueOf(cc);*/
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();

            String update = "update `clinicaldb`.`patient_information` SET department='" + department + "',block_number='" + bloclk_number + "',dormetery_number='" + dorm_number + "',age='" + age + "',first_name='" + first_name + "',middle_name='" + middle_name + "',last_name='" + last_name + "',sex='" + sex + "',occupation='" + occupation + "',religion='" + religion + "',address='" + address + "',statues='" + statue + "' where information_id=" + infoid + " and id_number='" + id_number + "'";
            stmt.executeUpdate(update);

            // sickleave schedule
            String updateschedule = "update `clinicaldb`.`schedule` SET BLOCK_NUMBER='" + bloclk_number + "',DORMITORY_NUMBER='" + dorm_number + "',AGE='" + age + "',STATUES='" + statue + "' where ID_NUMBER='" + id_number + "' ORDER BY schedule_id DESC";
            stmt.executeUpdate(updateschedule);

            // drug providing table
            String updatepro = "update `clinicaldb`.`drug_protbl` SET department='" + department + "',block_number='" + bloclk_number + "',dormetery_number='" + dorm_number + "',patient_first_name='" + first_name + "',patient_last_name='" + middle_name + "',sex='" + sex + "' where id_number='" + id_number + "'";
            stmt.executeUpdate(updatepro);



            // investigation table
            String updateinvestigation = "update `clinicaldb`.`investigationtbl` SET patient_first_name='" + first_name + "',patient_last_name='" + middle_name + "',sex='" + sex + "' where patient_id='" + id_number + "'";
            stmt.executeUpdate(updateinvestigation);

            String name = first_name + "  " + middle_name;
            // investigation result table
            String updateinestigationresult = "update `clinicaldb`.`investigation_result` SET patient_name='" + name + "',sex='" + sex + "'  where id_number='" + id_number + "'";
            stmt.executeUpdate(updateinestigationresult);



            // patient_history table
            String updatehistorytable = "update `clinicaldb`.`patient_history` SET first_name='" + first_name + "',last_name='" + middle_name + "',sex='" + sex + "' where id_number='" + id_number + "'";
            stmt.executeUpdate(updatehistorytable);

            // prescription table
            String updateprescriptiontable = "update `clinicaldb`.`prescription` SET department='" + department + "',block_number='" + bloclk_number + "',dormetery_number='" + dorm_number + "',first_name='" + first_name + "',last_name='" + middle_name + "',sex='" + sex + "' where id_number='" + id_number + "'";
            stmt.executeUpdate(updateprescriptiontable);



            // referal table
            String updatereferaltable = "update `clinicaldb`.`referral` SET first_name='" + first_name + "',middle_name='" + middle_name + "',last_name='" + last_name + "',sex='" + sex + "' where id_number='" + id_number + "'";
            stmt.executeUpdate(updatereferaltable);


            // sickleave table
            String updatesickleave = "update `clinicaldb`.`sickleave` SET first_name='" + first_name + "',middle_name='" + middle_name + "',sex='" + sex + "' where id_number='" + id_number + "'";
            stmt.executeUpdate(updatesickleave);



        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return null;
    }

    public String[] search_patient_info(String id_number) {

        int csf = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`patient_information` where id_number='" + id_number + "' ORDER BY information_id DESC";
            ResultSet rs = stmt.executeQuery(ins);

            while (rs.next()) {
                csf++;
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int sf = csf * 19;
        String customer[] = new String[sf];
        try {
            // customer[208]=customer[20];
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`patient_information` where id_number='" + id_number + "' ORDER BY information_id DESC";
            ResultSet rs = stmt.executeQuery(ins);
            int cs = 0;
            while (rs.next()) {
                cs++;
            }
            if (cs >= 1) {
                String select = "select *from `clinicaldb`.`patient_information` where id_number='" + id_number + "' ORDER BY information_id DESC";
                ResultSet r = stmt.executeQuery(select);

                int idx = 0;
                int c = 0;
                while (r.next()) {
                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);
                    idx++;
                    customer[idx] = r.getString(5);
                    idx++;
                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;
                    customer[idx] = (r.getString(9));
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;
                    customer[idx] = (r.getString(11));
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;
                    customer[idx] = (r.getString(13));
                    idx++;
                    customer[idx] = (r.getString(14));
                    idx++;
                    customer[idx] = (r.getString(15));
                    idx++;
                    customer[idx] = (r.getString(16));
                    idx++;
                    customer[idx] = (r.getString(17));
                    idx++;
                    customer[idx] = (r.getString(18));
                    idx++;
                    customer[idx] = (r.getString(19));
                    idx++;
                }


            } else {
                //  customer=null;  
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return customer;
    }

    public String[] update_drug_pro_info(int proid, String id_numeber, String drugname, String strength, String dose, String unit, int quantity, String unitcost, String comment) {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dx = s.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(d);


        try {

            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();

            String update = "update `clinicaldb`.`drug_protbl` SET time='" + time + "',date='" + dx + "',dosage='" + dose + "',strength='" + strength + "',drug_name='" + drugname + "',unit='" + unit + "',quantity=" + quantity + ",unit_cost=" + unitcost + ",comment='" + comment + "' where drug_pro_id=" + proid + " and id_number='" + id_numeber + "'";
            stmt.executeUpdate(update);

        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return null;
    }

    public String[] search_for_drug_pro_info(String id_numeber) {

        int ci = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`drug_protbl` where id_number='" + id_numeber + "'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                ci++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int arraysize = ci * 21;
        int size = arraysize - 1;
        String customer[] = new String[size];
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`drug_protbl` where id_number='" + id_numeber + "' ORDER BY drug_pro_id DESC";// where serviceis='ready'";//where card_number='"+txt.getText()+"' and serviceis='served'";
            ResultSet rs = stmt.executeQuery(ins);
            int cs = 0;
            while (rs.next()) {
                cs++;
            }

            String select = "select *from `clinicaldb`.`drug_protbl` where id_number='" + id_numeber + "' ORDER BY drug_pro_id DESC";// ORDER BY time,date DESC";// where serviceis='ready'";// where card_number='"+txt.getText()+"'";//and profession='"+ob.profssion+"'";
            ResultSet r = stmt.executeQuery(select);

            int idx = 0;
            int c = 0;
            while (r.next()) {
                c++;
                customer[idx] = r.getString(1);
                idx++;
                customer[idx] = r.getString(2);
                idx++;
                customer[idx] = r.getString(3);
                idx++;
                customer[idx] = r.getString(4);
                idx++;
                customer[idx] = r.getString(5);
                idx++;
                customer[idx] = r.getString(6);
                idx++;
                customer[idx] = (r.getString(7));
                idx++;
                customer[idx] = (r.getString(8));
                idx++;
                customer[idx] = (r.getString(9));
                idx++;
                customer[idx] = (r.getString(10));
                idx++;
                customer[idx] = (r.getString(11));
                idx++;
                customer[idx] = (r.getString(12));
                idx++;
                customer[idx] = (r.getString(13));
                idx++;
                customer[idx] = (r.getString(14));
                idx++;
                customer[idx] = (r.getString(15));
                idx++;
                customer[idx] = (r.getString(16));
                idx++;
                customer[idx] = (r.getString(17));
                idx++;
                customer[idx] = (r.getString(18));
                idx++;
                customer[idx] = (r.getString(19));
                idx++;
                customer[idx] = (r.getString(20));
                idx++;
                customer[idx] = (r.getString(21));
                idx++;
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return customer;
    }

    public String[] view_drug_pro_info(String reptyp, String sex) {

        int ci = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`drug_protbl` where sex='" + sex + "'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                ci++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int arraysize = ci * 21;
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dx = s.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(d);
        String first = "";
        String second = "";
        String third = "";
        String conc = null;
        int cn = 0;
        int length = dx.length();
        char[] ccx = dx.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            first = first + ccx[h];
        }
        int length1 = dx.length();
        char[] ccx1 = dx.toCharArray();
        for (int h = 5; h < 7; h = h + 1) {
            second = second + ccx1[h];
        }
        int length2 = dx.length();
        char[] ccx2 = dx.toCharArray();
        for (int h = 8; h < 10; h = h + 1) {
            third = third + ccx2[h];
        }
        conc = first + second + third;
        int compute = 0;
        int dates = Integer.parseInt(conc);
        cn = Integer.parseInt(first);
        if (reptyp.equals("WEEKLY")) {
            compute = dates - 7;
        } else if (reptyp.equals("MONTHLY")) {
            compute = dates - 30;
        } else if (reptyp.equals("ANNUALLY")) {
            compute = cn - 1;
            first = String.valueOf(compute);
            String comps = first + second + third;
            compute = Integer.parseInt(comps);
        }
        String computes = String.valueOf(compute);
        String thirdst = null;
        String thirdsts = null;

        String firsts = "";
        String seconds = "";
        String thirds = "";
        String concs = null;
        int lengths = computes.length();
        char[] ccxs = computes.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            firsts = firsts + ccxs[h];
        }
        firsts = firsts + "-";
        int lengths1 = computes.length();
        char[] ccxs1 = computes.toCharArray();
        for (int h = 4; h < 6; h = h + 1) {
            seconds = seconds + ccxs1[h];
        }
        seconds = seconds + "-";
        int lengthss2 = computes.length();
        char[] ccxss2 = computes.toCharArray();
        for (int h = 6; h < 8; h = h + 1) {
            thirds = thirds + ccxss2[h];
        }
        int thirdstss = Integer.parseInt(thirds);
        if (thirdstss > 30) {
            thirdstss = thirdstss - 70;
            thirds = String.valueOf(thirdstss);
        } else {
            thirds = thirds;
        }
        concs = firsts + seconds + thirds;
        String customer[] = new String[arraysize - 1];



        try {

            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`drug_protbl` where sex='" + sex + "' and date>'" + concs + "'";// where serviceis='ready'";//where card_number='"+txt.getText()+"' and serviceis='served'";
            ResultSet rs = stmt.executeQuery(ins);
            int cs = 0;
            while (rs.next()) {
                cs++;
            }

            String select = "select *from `clinicaldb`.`drug_protbl` where sex='" + sex + "' and date>'" + concs + "'";// ORDER BY time,date DESC";// where serviceis='ready'";// where card_number='"+txt.getText()+"'";//and profession='"+ob.profssion+"'";
            ResultSet r = stmt.executeQuery(select);

            int idx = 0;
            int c = 0;
            while (r.next()) {
                c++;
                customer[idx] = r.getString(1);
                idx++;
                customer[idx] = r.getString(2);
                idx++;
                customer[idx] = r.getString(3);
                idx++;
                customer[idx] = r.getString(4);
                idx++;
                customer[idx] = r.getString(5);
                idx++;
                customer[idx] = r.getString(6);
                idx++;
                customer[idx] = (r.getString(7));
                idx++;
                customer[idx] = (r.getString(8));
                idx++;
                customer[idx] = (r.getString(9));
                idx++;
                customer[idx] = (r.getString(10));
                idx++;
                customer[idx] = (r.getString(11));
                idx++;
                customer[idx] = (r.getString(12));
                idx++;
                customer[idx] = (r.getString(13));
                idx++;
                customer[idx] = (r.getString(14));
                idx++;
                customer[idx] = (r.getString(15));
                idx++;
                customer[idx] = (r.getString(16));
                idx++;
                customer[idx] = (r.getString(17));
                idx++;
                customer[idx] = (r.getString(18));
                idx++;
                customer[idx] = (r.getString(19));
                idx++;
                customer[idx] = (r.getString(20));
                idx++;
                customer[idx] = (r.getString(21));
                idx++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return customer;
    }

    public String[] view_prescription(String reporttyp, String sex) {
        int ci = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`prescription` where sex='" + sex + "'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                ci++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int arraysize = ci * 21;
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dx = s.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(d);
        String first = "";
        String second = "";
        String third = "";
        String conc = null;
        int cn = 0;
        int length = dx.length();
        char[] ccx = dx.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            first = first + ccx[h];
        }
        int length1 = dx.length();
        char[] ccx1 = dx.toCharArray();
        for (int h = 5; h < 7; h = h + 1) {
            second = second + ccx1[h];
        }
        int length2 = dx.length();
        char[] ccx2 = dx.toCharArray();
        for (int h = 8; h < 10; h = h + 1) {
            third = third + ccx2[h];
        }
        conc = first + second + third;
        int compute = 0;
        int dates = Integer.parseInt(conc);
        cn = Integer.parseInt(first);
        if (reporttyp.equals("WEEKLY")) {
            compute = dates - 7;
        } else if (reporttyp.equals("MONTHLY")) {
            compute = dates - 30;
        } else if (reporttyp.equals("ANNUALLY")) {
            compute = cn - 1;
            first = String.valueOf(compute);
            String comps = first + second + third;
            compute = Integer.parseInt(comps);
        }
        String computes = String.valueOf(compute);
        String thirdst = null;
        String thirdsts = null;

        String firsts = "";
        String seconds = "";
        String thirds = "";
        String concs = null;
        int lengths = computes.length();
        char[] ccxs = computes.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            firsts = firsts + ccxs[h];
        }
        firsts = firsts + "-";
        int lengths1 = computes.length();
        char[] ccxs1 = computes.toCharArray();
        for (int h = 4; h < 6; h = h + 1) {
            seconds = seconds + ccxs1[h];
        }
        seconds = seconds + "-";
        int lengthss2 = computes.length();
        char[] ccxss2 = computes.toCharArray();
        for (int h = 6; h < 8; h = h + 1) {
            thirds = thirds + ccxss2[h];
        }
        int thirdstss = Integer.parseInt(thirds);
        if (thirdstss > 30) {
            thirdstss = thirdstss - 70;
            thirds = String.valueOf(thirdstss);
        } else {
            thirds = thirds;
        }
        concs = firsts + seconds + thirds;
        String customer[] = new String[arraysize];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`prescription` where sex='" + sex + "'";// where serviceis='ready'";//where card_number='"+txt.getText()+"' and serviceis='served'";
            ResultSet rs = stmt.executeQuery(ins);
            int cs = 0;
            while (rs.next()) {
                cs++;
            }
            String select = "select *from `clinicaldb`.`prescription` where sex='" + sex + "'";// ORDER BY time,date DESC";// where serviceis='ready'";// where card_number='"+txt.getText()+"'";//and profession='"+ob.profssion+"'";
            ResultSet r = stmt.executeQuery(select);
            int idx = 0;
            int c = 0;
            while (r.next()) {
                c++;
                customer[idx] = r.getString(1);
                idx++;
                customer[idx] = r.getString(2);
                idx++;
                customer[idx] = r.getString(3);
                idx++;
                customer[idx] = r.getString(4);
                idx++;
                customer[idx] = r.getString(5);
                idx++;
                customer[idx] = r.getString(6);
                idx++;
                customer[idx] = (r.getString(7));
                idx++;
                customer[idx] = (r.getString(8));
                idx++;
                customer[idx] = (r.getString(9));
                idx++;
                customer[idx] = (r.getString(10));
                idx++;
                customer[idx] = (r.getString(11));
                idx++;
                customer[idx] = (r.getString(12));
                idx++;
                customer[idx] = (r.getString(13));
                idx++;
                customer[idx] = (r.getString(14));
                idx++;
                customer[idx] = (r.getString(15));
                idx++;
                customer[idx] = (r.getString(16));
                idx++;
                customer[idx] = (r.getString(17));
                idx++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return customer;
    }

    public String[] view_lab_result() {
        String customer[] = new String[208];





        try {

            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`investigation_result`";// where serviceis='ready'";//where card_number='"+txt.getText()+"' and serviceis='served'";
            ResultSet rs = stmt.executeQuery(ins);
            int cs = 0;
            while (rs.next()) {
                cs++;
            }
            String select = "select *from `clinicaldb`.`investigation_result`";// ORDER BY time,date DESC";// where serviceis='ready'";// where card_number='"+txt.getText()+"'";//and profession='"+ob.profssion+"'";
            ResultSet r = stmt.executeQuery(select);
            int idx = 0;
            int c = 0;
            while (r.next()) {
                c++;
                customer[idx] = r.getString(1);
                idx++;
                customer[idx] = r.getString(2);
                idx++;
                customer[idx] = r.getString(3);
                idx++;
                customer[idx] = r.getString(4);
                idx++;
                customer[idx] = r.getString(5);
                idx++;
                customer[idx] = r.getString(6);
                idx++;
                customer[idx] = (r.getString(7));
                idx++;
                customer[idx] = (r.getString(8));
                idx++;
                customer[idx] = (r.getString(9));
                idx++;
                customer[idx] = (r.getString(10));
                idx++;
                customer[idx] = (r.getString(11));
                idx++;
                customer[idx] = (r.getString(12));
                idx++;


            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return customer;
    }

    public String[] view_pat_history(String reptyp, String sex) {


        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dx = s.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(d);
        String first = "";
        String second = "";
        String third = "";
        String conc = null;
        int cn = 0;
        int length = dx.length();
        char[] ccx = dx.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            first = first + ccx[h];
        }
        int length1 = dx.length();
        char[] ccx1 = dx.toCharArray();
        for (int h = 5; h < 7; h = h + 1) {
            second = second + ccx1[h];
        }
        int length2 = dx.length();
        char[] ccx2 = dx.toCharArray();
        for (int h = 8; h < 10; h = h + 1) {
            third = third + ccx2[h];
        }
        conc = first + second + third;
        int compute = 0;
        int dates = Integer.parseInt(conc);
        cn = Integer.parseInt(first);
        if (reptyp.equals("WEEKLY")) {
            compute = dates - 7;
        } else if (reptyp.equals("MONTHLY")) {
            compute = dates - 30;
        } else if (reptyp.equals("ANNUALLY")) {
            compute = cn - 1;
            first = String.valueOf(compute);
            String comps = first + second + third;
            compute = Integer.parseInt(comps);
        }
        String computes = String.valueOf(compute);

        String thirdst = null;
        String thirdsts = null;

        String firsts = "";
        String seconds = "";
        String thirds = "";
        String concs = null;
        int lengths = computes.length();
        char[] ccxs = computes.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            firsts = firsts + ccxs[h];
        }
        firsts = firsts + "-";
        int lengths1 = computes.length();
        char[] ccxs1 = computes.toCharArray();
        for (int h = 4; h < 6; h = h + 1) {
            seconds = seconds + ccxs1[h];
        }

        seconds = seconds + "-";
        int lengthss2 = computes.length();
        char[] ccxss2 = computes.toCharArray();
        for (int h = 6; h < 8; h = h + 1) {
            thirds = thirds + ccxss2[h];
        }
        int thirdstss = Integer.parseInt(thirds);
        if (thirdstss > 30) {
            thirdstss = thirdstss - 70;
            thirds = String.valueOf(thirdstss);
        } else {
            thirds = thirds;
        }
        concs = firsts + seconds + thirds;

















        int csh = 0;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`patient_history` where sex='" + sex + "' and  medication_date>='" + concs + "'";
            ResultSet rs = stmt.executeQuery(ins);

            while (rs.next()) {
                csh++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int Arraysize = 64 * csh;
        String customer[] = new String[Arraysize];
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`patient_history` where sex='" + sex + "' and  medication_date>='" + concs + "'";// where serviceis='ready'";//where card_number='"+txt.getText()+"' and serviceis='served'";
            ResultSet rs = stmt.executeQuery(ins);
            int cs = 0;
            while (rs.next()) {
                cs++;
            }
            if (cs < 1) {
            } else {


                String select = "select *from `clinicaldb`.`patient_history` where sex='" + sex + "' and  medication_date>='" + concs + "'";// ORDER BY time,date DESC";// where serviceis='ready'";// where card_number='"+txt.getText()+"'";//and profession='"+ob.profssion+"'";
                ResultSet r = stmt.executeQuery(select);
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);
                    idx++;
                    customer[idx] = r.getString(5);
                    idx++;
                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;
                    customer[idx] = (r.getString(9));
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;
                    customer[idx] = (r.getString(11));
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;
                    customer[idx] = (r.getString(13));
                    idx++;
                    customer[idx] = (r.getString(14));
                    idx++;
                    customer[idx] = (r.getString(15));
                    idx++;
                    customer[idx] = (r.getString(16));
                    idx++;
                    customer[idx] = (r.getString(17));
                    idx++;
                    customer[idx] = (r.getString(18));
                    idx++;
                    customer[idx] = (r.getString(19));
                    idx++;
                    customer[idx] = (r.getString(20));
                    idx++;
                    customer[idx] = (r.getString(21));
                    idx++;
                    customer[idx] = (r.getString(22));
                    idx++;
                    customer[idx] = (r.getString(23));
                    idx++;
                    customer[idx] = (r.getString(24));
                    idx++;
                    customer[idx] = (r.getString(25));
                    idx++;
                    customer[idx] = (r.getString(26));
                    idx++;








                    customer[idx] = r.getString(27);
                    idx++;
                    customer[idx] = r.getString(28);
                    idx++;
                    customer[idx] = r.getString(29);
                    idx++;
                    customer[idx] = r.getString(30);
                    idx++;
                    customer[idx] = r.getString(31);
                    idx++;
                    customer[idx] = r.getString(32);
                    idx++;
                    customer[idx] = (r.getString(33));
                    idx++;
                    customer[idx] = (r.getString(34));
                    idx++;
                    customer[idx] = (r.getString(35));
                    idx++;
                    customer[idx] = (r.getString(36));
                    idx++;
                    customer[idx] = (r.getString(37));
                    idx++;
                    customer[idx] = (r.getString(38));
                    idx++;
                    customer[idx] = (r.getString(39));
                    idx++;
                    customer[idx] = (r.getString(40));
                    idx++;
                    customer[idx] = (r.getString(41));
                    idx++;
                    customer[idx] = (r.getString(42));
                    idx++;
                    customer[idx] = (r.getString(43));
                    idx++;
                    customer[idx] = (r.getString(44));
                    idx++;
                    customer[idx] = (r.getString(45));
                    idx++;
                    customer[idx] = (r.getString(46));
                    idx++;
                    customer[idx] = (r.getString(47));
                    idx++;
                    customer[idx] = (r.getString(48));
                    idx++;
                    customer[idx] = (r.getString(49));
                    idx++;
                    customer[idx] = (r.getString(50));
                    idx++;
                    customer[idx] = (r.getString(51));
                    idx++;
                    customer[idx] = (r.getString(52));
                    idx++;




                    customer[idx] = (r.getString(53));
                    idx++;
                    customer[idx] = (r.getString(54));
                    idx++;
                    customer[idx] = (r.getString(55));
                    idx++;
                    customer[idx] = (r.getString(56));
                    idx++;
                    customer[idx] = (r.getString(57));
                    idx++;
                    customer[idx] = (r.getString(58));
                    idx++;
                    customer[idx] = (r.getString(59));
                    idx++;
                    customer[idx] = (r.getString(60));
                    idx++;
                    customer[idx] = (r.getString(61));
                    idx++;
                    customer[idx] = (r.getString(62));
                    idx++;
                    customer[idx] = (r.getString(63));
                    idx++;
                    customer[idx] = (r.getString(64));
                    idx++;
                }
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return customer;
    }
public String[] view_histories(String id_number)
{
  int c=0,csh=0;
     try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "'";
            ResultSet rs = stmt.executeQuery(ins);
            while (rs.next()) {
                csh++;
            }
            System.out.println(csh);
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int Arraysize = 64 * csh;
        String customer[] = new String[Arraysize];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "'";// where serviceis='ready'";//where card_number='"+txt.getText()+"' and serviceis='served'";
            ResultSet r = stmt.executeQuery(ins);
                           int idx = 0;
                int cc = 0;
                while (r.next()) {
                    cc++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);
                    idx++;
                    customer[idx] = r.getString(5);
                    idx++;
                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;
                    customer[idx] = (r.getString(9));
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;
                    customer[idx] = (r.getString(11));
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;
                    customer[idx] = (r.getString(13));
                    idx++;
                    customer[idx] = (r.getString(14));
                    idx++;
                    customer[idx] = (r.getString(15));
                    idx++;
                    customer[idx] = (r.getString(16));
                    idx++;
                    customer[idx] = (r.getString(17));
                    idx++;
                    customer[idx] = (r.getString(18));
                    idx++;
                    customer[idx] = (r.getString(19));
                    idx++;
                    customer[idx] = (r.getString(20));
                    idx++;
                    customer[idx] = (r.getString(21));
                    idx++;
                    customer[idx] = (r.getString(22));
                    idx++;
                    customer[idx] = (r.getString(23));
                    idx++;
                    customer[idx] = (r.getString(24));
                    idx++;
                    customer[idx] = (r.getString(25));
                    idx++;
                    customer[idx] = (r.getString(26));
                    idx++;








                    customer[idx] = r.getString(27);
                    idx++;
                    customer[idx] = r.getString(28);
                    idx++;
                    customer[idx] = r.getString(29);
                    idx++;
                    customer[idx] = r.getString(30);
                    idx++;
                    customer[idx] = r.getString(31);
                    idx++;
                    customer[idx] = r.getString(32);
                    idx++;
                    customer[idx] = (r.getString(33));
                    idx++;
                    customer[idx] = (r.getString(34));
                    idx++;
                    customer[idx] = (r.getString(35));
                    idx++;
                    customer[idx] = (r.getString(36));
                    idx++;
                    customer[idx] = (r.getString(37));
                    idx++;
                    customer[idx] = (r.getString(38));
                    idx++;
                    customer[idx] = (r.getString(39));
                    idx++;
                    customer[idx] = (r.getString(40));
                    idx++;
                    customer[idx] = (r.getString(41));
                    idx++;
                    customer[idx] = (r.getString(42));
                    idx++;
                    customer[idx] = (r.getString(43));
                    idx++;
                    customer[idx] = (r.getString(44));
                    idx++;
                    customer[idx] = (r.getString(45));
                    idx++;
                    customer[idx] = (r.getString(46));
                    idx++;
                    customer[idx] = (r.getString(47));
                    idx++;
                    customer[idx] = (r.getString(48));
                    idx++;
                    customer[idx] = (r.getString(49));
                    idx++;
                    customer[idx] = (r.getString(50));
                    idx++;
                    customer[idx] = (r.getString(51));
                    idx++;
                    customer[idx] = (r.getString(52));
                    idx++;




                    customer[idx] = (r.getString(53));
                    idx++;
                    customer[idx] = (r.getString(54));
                    idx++;
                    customer[idx] = (r.getString(55));
                    idx++;
                    customer[idx] = (r.getString(56));
                    idx++;
                    customer[idx] = (r.getString(57));
                    idx++;
                    customer[idx] = (r.getString(58));
                    idx++;
                    customer[idx] = (r.getString(59));
                    idx++;
                    customer[idx] = (r.getString(60));
                    idx++;
                    customer[idx] = (r.getString(61));
                    idx++;
                    customer[idx] = (r.getString(62));
                    idx++;
                    customer[idx] = (r.getString(63));
                    idx++;
                    customer[idx] = (r.getString(64));
                    idx++;
            }

            //System.out.println(cs);
         
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return customer;

}
public int viewhistories(String id_number)
{
  int c=0,csh=0;
     try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "'";
            ResultSet rs = stmt.executeQuery(ins);
            while (rs.next()) {
                csh++;
            }
            System.out.println(csh);
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int Arraysize = 64 * csh;
        String customer[] = new String[Arraysize];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "'";// where serviceis='ready'";//where card_number='"+txt.getText()+"' and serviceis='served'";
            ResultSet rs = stmt.executeQuery(ins);
            int cs = 0;
            while (rs.next()) {
                c++;
            }

            System.out.println(cs);
         
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return c;

}

public int view_pat_historys(String reptyp, String sex) {


        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dx = s.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(d);
        String first = "";
        String second = "";
        String third = "";
        String conc = null;
        int cn = 0;
        int length = dx.length();
        char[] ccx = dx.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            first = first + ccx[h];
        }
        int length1 = dx.length();
        char[] ccx1 = dx.toCharArray();
        for (int h = 5; h < 7; h = h + 1) {
            second = second + ccx1[h];
        }
        int length2 = dx.length();
        char[] ccx2 = dx.toCharArray();
        for (int h = 8; h < 10; h = h + 1) {
            third = third + ccx2[h];
        }
        conc = first + second + third;
        int compute = 0;
        int dates = Integer.parseInt(conc);
        cn = Integer.parseInt(first);
        if (reptyp.equals("WEEKLY")) {
            compute = dates - 7;
        } else if (reptyp.equals("MONTHLY")) {
            compute = dates - 30;
        } else if (reptyp.equals("ANNUALLY")) {
            compute = cn - 1;
            first = String.valueOf(compute);
            String comps = first + second + third;
            compute = Integer.parseInt(comps);
        }
        String computes = String.valueOf(compute);

        String thirdst = null;
        String thirdsts = null;

        String firsts = "";
        String seconds = "";
        String thirds = "";
        String concs = null;
        int lengths = computes.length();
        char[] ccxs = computes.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            firsts = firsts + ccxs[h];
        }
        firsts = firsts + "-";
        int lengths1 = computes.length();
        char[] ccxs1 = computes.toCharArray();
        for (int h = 4; h < 6; h = h + 1) {
            seconds = seconds + ccxs1[h];
        }

        seconds = seconds + "-";
        int lengthss2 = computes.length();
        char[] ccxss2 = computes.toCharArray();
        for (int h = 6; h < 8; h = h + 1) {
            thirds = thirds + ccxss2[h];
        }
        int thirdstss = Integer.parseInt(thirds);
        if (thirdstss > 30) {
            thirdstss = thirdstss - 70;
            thirds = String.valueOf(thirdstss);
        } else {
            thirds = thirds;
        }
        concs = firsts + seconds + thirds;
        int c = 0;
        int csh = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`patient_history` where sex='" + sex + "' and  medication_date>='" + concs + "'";
            ResultSet rs = stmt.executeQuery(ins);
            while (rs.next()) {
                csh++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int Arraysize = 64 * csh;
        String customer[] = new String[Arraysize];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`patient_history` where sex='" + sex + "' and  medication_date>='" + concs + "'";// where serviceis='ready'";//where card_number='"+txt.getText()+"' and serviceis='served'";
            ResultSet rs = stmt.executeQuery(ins);
            int cs = 0;
            while (rs.next()) {
                cs++;
            }

            if (cs < 1) {
                c = 0;
            } else {

                String select = "select *from `clinicaldb`.`patient_history` where sex='" + sex + "' and  medication_date>='" + concs + "'";// ORDER BY time,date DESC";// where serviceis='ready'";// where card_number='"+txt.getText()+"'";//and profession='"+ob.profssion+"'";
                ResultSet r = stmt.executeQuery(select);
                int idx = 0;

                while (r.next()) {
                    c++;
                }
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return c;
    }

    public String[] calling_for_drug_pro_info(String room_number, String btn_name) {
        String customer[] = new String[208];
        String requestid = null;
        int i = 0, j = 0, c = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`prescription` where servieces='ready'  ORDER BY prescription_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            while (rs.next()) {
                i++;
            }
            String req_id = null;
            if (i >= 1) {

                if (btn_name.equals("CALLING AGAIN")) {

                    String selss = "select *from `clinicaldb`.`prescription` where servieces='ready' and called='yes' ORDER BY prescription_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sls = stmt.executeQuery(selss);
                    while (sls.next()) {
                        req_id = sls.getString("id_number");
                        requestid = sls.getString("prescription_id");
                    }

                    String sels = "select *from `clinicaldb`.`prescription` where servieces='ready' and called='yes' and prescription_id='" + requestid + "' ORDER BY prescription_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sl = stmt.executeQuery(sels);

                    int kk = 0, idx = 0;
                    while (sl.next()) {


                        customer[idx] = sl.getString(1);
                        idx++;
                        customer[idx] = sl.getString(2);
                        idx++;
                        customer[idx] = sl.getString(3);
                        idx++;
                        customer[idx] = sl.getString(4);
                        idx++;
                        customer[idx] = sl.getString(5);
                        idx++;
                        customer[idx] = sl.getString(6);
                        idx++;
                        customer[idx] = (sl.getString(7));
                        idx++;
                        customer[idx] = (sl.getString(8));
                        idx++;
                        customer[idx] = (sl.getString(9));
                        idx++;
                        customer[idx] = (sl.getString(10));
                        idx++;
                        customer[idx] = (sl.getString(11));
                        idx++;
                        customer[idx] = (sl.getString(12));
                        idx++;

                        customer[idx] = (sl.getString(13));
                        idx++;
                        customer[idx] = (sl.getString(14));
                        idx++;
                        customer[idx] = (sl.getString(15));
                        idx++;
                        customer[idx] = (sl.getString(16));
                        idx++;
                        customer[idx] = (sl.getString(17));
                        idx++;
                    }




                    String update = "update `clinicaldb`.`prescription` SET servieces='diactvate' where prescription_id='" + requestid + "'";
                    stmt.executeUpdate(update);

                } else {
                    String selss = "select *from `clinicaldb`.`prescription` where servieces='ready' and called='no' ORDER BY prescription_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sls = stmt.executeQuery(selss);
                    while (sls.next()) {
                        req_id = sls.getString("id_number");
                        requestid = sls.getString("prescription_id");
                    }

                    String sels = "select *from `clinicaldb`.`prescription` where servieces='ready' and called='no' and prescription_id='" + requestid + "' ORDER BY prescription_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sl = stmt.executeQuery(sels);

                    int kk = 0, idx = 0;
                    while (sl.next()) {


                        customer[idx] = sl.getString(1);
                        idx++;
                        customer[idx] = sl.getString(2);
                        idx++;
                        customer[idx] = sl.getString(3);
                        idx++;
                        customer[idx] = sl.getString(4);
                        idx++;
                        customer[idx] = sl.getString(5);
                        idx++;
                        customer[idx] = sl.getString(6);
                        idx++;
                        customer[idx] = (sl.getString(7));
                        idx++;
                        customer[idx] = (sl.getString(8));
                        idx++;
                        customer[idx] = (sl.getString(9));
                        idx++;
                        customer[idx] = (sl.getString(10));
                        idx++;
                        customer[idx] = (sl.getString(11));
                        idx++;
                        customer[idx] = (sl.getString(12));
                        idx++;

                        customer[idx] = (sl.getString(13));
                        idx++;
                        customer[idx] = (sl.getString(14));
                        idx++;
                        customer[idx] = (sl.getString(15));
                        idx++;
                        customer[idx] = (sl.getString(16));
                        idx++;
                        customer[idx] = (sl.getString(17));
                        idx++;
                    }




                    String update = "update `clinicaldb`.`prescription` SET called='yes' where prescription_id='" + requestid + "'";
                    stmt.executeUpdate(update);
                }
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }


        return customer;
    }

    public int calling_for_drug_pro_info_count(String btn_name) {

        String requestid = null;
        int i = 0, j = 0, c = 0;
        int idx = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`prescription` where servieces='ready'  ORDER BY prescription_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            while (rs.next()) {
                i++;
            }
            String req_id = null;
            if (i >= 1) {
                if (btn_name.equals("CALLING AGAIN")) {


                    String selss = "select *from `clinicaldb`.`prescription` where servieces='ready' and called='yes' ORDER BY prescription_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sls = stmt.executeQuery(selss);
                    while (sls.next()) {
                        req_id = sls.getString("id_number");
                        requestid = sls.getString("prescription_id");
                    }

                    String sels = "select *from `clinicaldb`.`prescription` where servieces='ready' and called='yes' and prescription_id='" + requestid + "' ORDER BY prescription_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sl = stmt.executeQuery(sels);


                    while (sl.next()) {
                        idx++;
                    }


                } else {

                    String selss = "select *from `clinicaldb`.`prescription` where servieces='ready' and called='no' ORDER BY prescription_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sls = stmt.executeQuery(selss);
                    while (sls.next()) {
                        req_id = sls.getString("id_number");
                        requestid = sls.getString("prescription_id");
                    }

                    String sels = "select *from `clinicaldb`.`prescription` where servieces='ready' and called='no' and prescription_id='" + requestid + "' ORDER BY prescription_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sl = stmt.executeQuery(sels);


                    while (sl.next()) {
                        idx++;
                    }


                }
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }


        return idx;

    }

    public String drug_pro_info(String responsible_person, String professin, String id_number, String age, String drugname, String strength, String dose, String unit, String quantity, String unitcost, String comment) {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dx = s.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(d);

        String department = null;
        int drug_pro_id = 1;
        String Patient_first_name = null;
        String Patient_middle_name = null;
        String Patient_last_name = null;
        String sex = null;
        String card_number = null;
        int i = 0, j = 0, c = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();



            String ins = "select *from `clinicaldb`.`prescription` where id_number='" + id_number + "'";
            ResultSet r = stmt.executeQuery(ins);

            while (r.next()) {
                c++;
            }
            if (c >= 1) {
                String inss = "select *from `clinicaldb`.`prescription` where id_number='" + id_number + "'";
                ResultSet rs = stmt.executeQuery(inss);
                while (rs.next()) {
                    department = rs.getString("department");
                    block_number = rs.getString("block_number");
                    dormetry_number = rs.getString("dormetery_number");
                    Patient_first_name = rs.getString("first_name");
                    sex = rs.getString("sex");

                    Patient_last_name = rs.getString("last_name");
                    card_number = rs.getString("card_number");
                }
                System.out.println("last name=" + Patient_last_name);

                String seldp = "select *from `clinicaldb`.`drug_protbl` ORDER BY drug_pro_id ASC";
                ResultSet rsdp = stmt.executeQuery(seldp);
                int cxs = 0;
                while (rsdp.next()) {
                    cxs++;
                }

                if (cxs >= 1) {
                    String selhistory = "select *from `clinicaldb`.`drug_protbl` ORDER BY drug_pro_id ASC";
                    ResultSet rshis = stmt.executeQuery(selhistory);
                    String historyid = null;
                    while (rshis.next()) {

                        historyid = rshis.getString("drug_pro_id");
                    }
                    drug_pro_id = Integer.parseInt(historyid);
                    drug_pro_id = drug_pro_id + 1;
                } else {
                    drug_pro_id = 1;
                }
                stmt.executeUpdate("INSERT INTO  `clinicaldb`.`drug_protbl`  VALUES (" + drug_pro_id + ", '" + Patient_first_name + "', '" + Patient_last_name + "', '" + sex + "', '" + age + "', '" + card_number + "', '" + id_number + "', '" + department + "', '" + block_number + "', '" + dormetry_number + "','" + drugname + "', '" + dose + "','" + strength + "',  '" + unit + "', " + quantity + ", '" + unitcost + "', '" + comment + "', '" + dx + "', '" + time + "', '" + responsible_person + "', '" + professin + "')");
            } else {
                System.out.println("no");
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");

        }
        String test = String.valueOf(c);
        return test;
    }

    public int drug_pro_info(String id_number) {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dx = s.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(d);

        int i = 0, j = 0, c = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();



            String ins = "select *from `clinicaldb`.`prescription` where id_number='" + id_number + "'";
            ResultSet r = stmt.executeQuery(ins);

            while (r.next()) {
                c++;
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");

        }
        return c;
    }

    public String existing_patient_info(String id_number, String date, String time, String sts, String ready, String age, String block_number, String dormetry_number) {
        String information_id = null;
        String count = null;
        int informationid = 0;





        String schedule_id = null;
        int schedule_ids = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();



            String sl = "select *from `clinicaldb`.`patient_information` where id_number='" + id_number + "'";//where card_number='"+txt.getText()+"' and serviceis='served'";
            ResultSet rs = stmt.executeQuery(sl);
            int c = 0;
            while (rs.next()) {
                c++;
            }

            String selschedule = "select *from `clinicaldb`.`schedule` ORDER BY schedule_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rsschedule = stmt.executeQuery(selschedule);
            while (rsschedule.next()) {
                schedule_id = rsschedule.getString("schedule_id");

            }


            if (c >= 1) {
                String inss = "select *from `clinicaldb`.`patient_information` ORDER BY information_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet r = stmt.executeQuery(inss);
                //   int i=0,j=0;

                while (r.next()) {
                    card_number = r.getString("card_number");
                    information_id = r.getString("information_id");

                }

                String search = "select *from `clinicaldb`.`patient_information` where id_number='" + id_number + "'";//where card_number='"+txt.getText()+"' and serviceis='served'";
                ResultSet rss = stmt.executeQuery(search);
                // int k=0;
                String department = null;

                while (rss.next()) {

                    information_id = rss.getString("information_id");
                    card_number = rss.getString("card_number");
                    id_number = rss.getString("id_number");
                    first_name = rss.getString("first_name");
                    middle_name = rss.getString("middle_name");
                    last_name = rss.getString("last_name");
                    sex = rss.getString("sex");
                    occupation = rss.getString("occupation");
                    religion = rss.getString("religion");
                    address = rss.getString("address");
                    department = rss.getString("department");
                    // block_number = rss.getString("block_number");
                    // dormetery_number = rss.getString("dormetery_number");

                }
                informationid = Integer.parseInt(information_id);
                informationid = informationid;// + 1;
                int cardnumber = Integer.parseInt(card_number);
                schedule_ids = Integer.parseInt(schedule_id);
                schedule_ids = schedule_ids + 1;
                stmt.executeUpdate("INSERT INTO `clinicaldb`.`schedule` (`schedule_id`, `INFOMATION ID`, `CARD NUMBER`, `ID NUMBER`, `AGE`, `SERVIES`, `DATE`, `STATUES`, `TIME`, `CALLED`, `BLOCK NUMBER`, `DORMITORY NUMBER`) VALUES (" + schedule_ids + ", " + informationid + ", '" + cardnumber + "', '" + id_number + "', '" + age + "', '" + ready + "', '" + date + "', '" + sts + "', '" + time + "', 'no', '" + block_number + "', '" + dormetry_number + "')");
//                stmt.executeUpdate("INSERT INTO  `clinicaldb`.`patient_information` VALUES (" + informationid + ", " + cardnumber + ",  '" + id_number + "',  '" + first_name + "',  '" + middle_name + "',  '" + last_name + "',  '" + age + "',  '" + sex + "',  '" + occupation + "',  '" + religion + "',  '" + address + "','" + ready + "','" + date + "','" + sts + "','" + time + "','no','" + department + "','" + block_number + "','" + dormetery_number + "')");

            }
            count = String.valueOf(c);
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");

        }
        return count;
    }

    public String[] view_pat_information(int arraysize, String reptyp, String reptyp1, String sex) {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dx = s.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(d);
        String first = "";
        String second = "";
        String third = "";
        String conc = null;
        int cn = 0;
        int length = dx.length();
        char[] ccx = dx.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            first = first + ccx[h];
        }
        int length1 = dx.length();
        char[] ccx1 = dx.toCharArray();
        for (int h = 5; h < 7; h = h + 1) {
            second = second + ccx1[h];
        }
        int length2 = dx.length();
        char[] ccx2 = dx.toCharArray();
        for (int h = 8; h < 10; h = h + 1) {
            third = third + ccx2[h];
        }
        conc = first + second + third;
        int compute = 0;
        int dates = Integer.parseInt(conc);
        cn = Integer.parseInt(first);
        if (reptyp.equals("WEEKLY")) {
            compute = dates - 7;
        } else if (reptyp.equals("MONTHLY")) {
            compute = dates - 30;
        } else if (reptyp.equals("ANNUALLY")) {
            compute = cn - 1;
            first = String.valueOf(compute);
            String comps = first + second + third;
            compute = Integer.parseInt(comps);
        }
        String computes = String.valueOf(compute);
        String thirdst = null;
        String thirdsts = null;
        String firsts = "";
        String seconds = "";
        String thirds = "";
        String concs = null;
        int lengths = computes.length();
        char[] ccxs = computes.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            firsts = firsts + ccxs[h];
        }
        firsts = firsts + "-";
        int lengths1 = computes.length();
        char[] ccxs1 = computes.toCharArray();
        for (int h = 4; h < 6; h = h + 1) {
            seconds = seconds + ccxs1[h];
        }
        seconds = seconds + "-";
        int lengthss2 = computes.length();
        char[] ccxss2 = computes.toCharArray();
        for (int h = 6; h < 8; h = h + 1) {
            thirds = thirds + ccxss2[h];
        }
        int thirdstss = Integer.parseInt(thirds);
        if (thirdstss > 30) {
            thirdstss = thirdstss - 70;
            thirds = String.valueOf(thirdstss);
        } else {
            thirds = thirds;
        }
        concs = firsts + seconds + thirds;
        int ci = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`patient_information`  where date>'" + concs + "' and serviceis='served' and sex='" + sex + "'";// where date>'5'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                ci++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        // int arraysize = ci * 19;



        String customer[] = new String[arraysize];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            if (reptyp1.equals("SERVED")) {
                String select = "select *from `clinicaldb`.`patient_information` where date>'" + concs + "' and serviceis='served' and sex='" + sex + "'";
                ResultSet r = stmt.executeQuery(select);
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);
                    idx++;

                    customer[idx] = r.getString(5);
                    idx++;

                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;

                    customer[idx] = r.getString(9);
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;
                    customer[idx] = r.getString(11);
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;

                    customer[idx] = (r.getString(13));
                    idx++;
                    customer[idx] = (r.getString(14));
                    idx++;
                    customer[idx] = (r.getString(15));
                    idx++;
                    customer[idx] = (r.getString(16));
                    idx++;
                    customer[idx] = (r.getString(17));
                    idx++;
                    customer[idx] = (r.getString(18));
                    idx++;
                    customer[idx] = (r.getString(19));
                    idx++;
                }

            } else if (reptyp1.equals("READY TO SERVE")) {
                String select = "select *from `clinicaldb`.`patient_information` where date>'" + concs + "' and serviceis='ready' and sex='" + sex + "'";
                ResultSet r = stmt.executeQuery(select);
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);;
                    idx++;

                    customer[idx] = r.getString(5);;
                    idx++;

                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;

                    customer[idx] = r.getString(9);;
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;

                    customer[idx] = r.getString(11);
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;

                    customer[idx] = (r.getString(13));
                    idx++;
                    customer[idx] = (r.getString(14));
                    idx++;
                    customer[idx] = (r.getString(15));
                    idx++;
                    customer[idx] = (r.getString(16));
                    idx++;

                    customer[idx] = (r.getString(17));
                    idx++;
                    customer[idx] = (r.getString(18));
                    idx++;
                    customer[idx] = (r.getString(19));
                    idx++;
                }

            } else if (reptyp1.equals("CALLED BUT NOT SERVED")) {
                String select = "select *from `clinicaldb`.`patient_information` where date>'" + concs + "' and serviceis='ready' and called='yes' and sex='" + sex + "'";
                ResultSet r = stmt.executeQuery(select);
                int idx = 0;
                int c = 0;
                while (r.next()) {

                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);;
                    idx++;

                    customer[idx] = r.getString(5);;
                    idx++;

                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;

                    customer[idx] = r.getString(9);;
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;

                    customer[idx] = r.getString(11);
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;

                    customer[idx] = (r.getString(13));
                    idx++;
                    customer[idx] = (r.getString(14));
                    idx++;
                    customer[idx] = (r.getString(15));
                    idx++;
                    customer[idx] = (r.getString(16));
                    idx++;

                    customer[idx] = (r.getString(17));
                    idx++;
                    customer[idx] = (r.getString(18));
                    idx++;
                    customer[idx] = (r.getString(19));
                    idx++;
                }

            } else if (reptyp1.equals("NOT CALLED")) {
                String select = "select *from `clinicaldb`.`patient_information` where date>'" + concs + "'and called='no' and sex='" + sex + "'";
                ResultSet r = stmt.executeQuery(select);
                int idx = 0;
                int c = 0;
                while (r.next()) {

                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);;
                    idx++;

                    customer[idx] = r.getString(5);;
                    idx++;

                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;

                    customer[idx] = r.getString(9);;
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;

                    customer[idx] = r.getString(11);
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;

                    customer[idx] = (r.getString(13));
                    idx++;
                    customer[idx] = (r.getString(14));
                    idx++;
                    customer[idx] = (r.getString(15));
                    idx++;
                    customer[idx] = (r.getString(16));
                    idx++;

                    customer[idx] = (r.getString(17));
                    idx++;
                    customer[idx] = (r.getString(18));
                    idx++;
                    customer[idx] = (r.getString(19));
                    idx++;
                }

            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return customer;
    }

    public int view_pat_schedule(String reptyp1, String reptyp, String sex) {
        int count = 0;



        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dx = s.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(d);
        String first = "";
        String second = "";
        String third = "";
        String conc = null;
        int cn = 0;
        int length = dx.length();
        char[] ccx = dx.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            first = first + ccx[h];
        }
        int length1 = dx.length();
        char[] ccx1 = dx.toCharArray();
        for (int h = 5; h < 7; h = h + 1) {
            second = second + ccx1[h];
        }
        int length2 = dx.length();
        char[] ccx2 = dx.toCharArray();
        for (int h = 8; h < 10; h = h + 1) {
            third = third + ccx2[h];
        }
        conc = first + second + third;
        int compute = 0;
        int dates = Integer.parseInt(conc);
        cn = Integer.parseInt(first);
        if (reptyp.equals("WEEKLY")) {
            compute = dates - 7;
        } else if (reptyp.equals("MONTHLY")) {
            compute = dates - 30;
        } else if (reptyp.equals("ANNUALLY")) {
            compute = cn - 1;
            first = String.valueOf(compute);
            String comps = first + second + third;
            compute = Integer.parseInt(comps);
        }
        String computes = String.valueOf(compute);
        String thirdst = null;
        String thirdsts = null;
        String firsts = "";
        String seconds = "";
        String thirds = "";
        String concs = null;
        int lengths = computes.length();
        char[] ccxs = computes.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            firsts = firsts + ccxs[h];
        }
        firsts = firsts + "-";
        int lengths1 = computes.length();
        char[] ccxs1 = computes.toCharArray();
        for (int h = 4; h < 6; h = h + 1) {
            seconds = seconds + ccxs1[h];
        }
        seconds = seconds + "-";
        int lengthss2 = computes.length();
        char[] ccxss2 = computes.toCharArray();
        for (int h = 6; h < 8; h = h + 1) {
            thirds = thirds + ccxss2[h];
        }
        int thirdstss = Integer.parseInt(thirds);
        if (thirdstss > 30) {
            thirdstss = thirdstss - 70;
            thirds = String.valueOf(thirdstss);
        } else {
            thirds = thirds;
        }
        concs = firsts + seconds + thirds;
        int ci = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`schedule`  where DATE>'" + concs + "' and SERVIES='served'";// where date>'5'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                ci++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int arraysize = ci * 12;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            if (reptyp1.equals("SERVED")) {
                String select = "select *from `clinicaldb`.`schedule` where DATE>'" + concs + "' and SERVIES='served'";
                ResultSet r = stmt.executeQuery(select);
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    count++;

                }

            } else if (reptyp1.equals("READY TO SERVE")) {
                String select = "select *from `clinicaldb`.`schedule` where DATE>'" + concs + "' and SERVIES='ready'";
                ResultSet r = stmt.executeQuery(select);
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    count++;



                }

            } else if (reptyp1.equals("CALLED BUT NOT SERVED")) {
                String select = "select *from `clinicaldb`.`schedule` where DATE>'" + concs + "' and SERVIES='ready' and called='yes'";
                ResultSet r = stmt.executeQuery(select);
                int idx = 0;
                int c = 0;
                while (r.next()) {

                    count++;
                }

            } else {
                count = 0;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return count;
    }

    public String[] view_pat_schedules(String reptyp1, int arraysize, String reptyp, String sex) {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dx = s.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(d);
        String first = "";
        String second = "";
        String third = "";
        String conc = null;
        int cn = 0;
        int length = dx.length();
        char[] ccx = dx.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            first = first + ccx[h];
        }
        int length1 = dx.length();
        char[] ccx1 = dx.toCharArray();
        for (int h = 5; h < 7; h = h + 1) {
            second = second + ccx1[h];
        }
        int length2 = dx.length();
        char[] ccx2 = dx.toCharArray();
        for (int h = 8; h < 10; h = h + 1) {
            third = third + ccx2[h];
        }
        conc = first + second + third;
        int compute = 0;
        int dates = Integer.parseInt(conc);
        cn = Integer.parseInt(first);
        if (reptyp.equals("WEEKLY")) {
            compute = dates - 7;
        } else if (reptyp.equals("MONTHLY")) {
            compute = dates - 30;
        } else if (reptyp.equals("ANNUALLY")) {
            compute = cn - 1;
            first = String.valueOf(compute);
            String comps = first + second + third;
            compute = Integer.parseInt(comps);
        }
        String computes = String.valueOf(compute);
        String thirdst = null;
        String thirdsts = null;
        String firsts = "";
        String seconds = "";
        String thirds = "";
        String concs = null;
        int lengths = computes.length();
        char[] ccxs = computes.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            firsts = firsts + ccxs[h];
        }
        firsts = firsts + "-";
        int lengths1 = computes.length();
        char[] ccxs1 = computes.toCharArray();
        for (int h = 4; h < 6; h = h + 1) {
            seconds = seconds + ccxs1[h];
        }
        seconds = seconds + "-";
        int lengthss2 = computes.length();
        char[] ccxss2 = computes.toCharArray();
        for (int h = 6; h < 8; h = h + 1) {
            thirds = thirds + ccxss2[h];
        }
        int thirdstss = Integer.parseInt(thirds);
        if (thirdstss > 30) {
            thirdstss = thirdstss - 70;
            thirds = String.valueOf(thirdstss);
        } else {
            thirds = thirds;
        }
        concs = firsts + seconds + thirds;
        int ci = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`schedule`  where DATE>'" + concs + "' and SERVIES='served'";// where date>'5'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                ci++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        // int arraysize = ci * 19;



        String customer[] = new String[arraysize];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            if (reptyp1.equals("SERVED")) {
                String select = "select *from `clinicaldb`.`schedule` where DATE>'" + concs + "' and SERVIES='served'";
                ResultSet r = stmt.executeQuery(select);
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);
                    idx++;

                    customer[idx] = r.getString(5);
                    idx++;

                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;

                    customer[idx] = r.getString(9);
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;
                    customer[idx] = r.getString(11);
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;
                }

            } else if (reptyp1.equals("READY TO SERVE")) {
                String select = "select *from `clinicaldb`.`schedule` where DATE>'" + concs + "' and SERVIES='ready'";
                ResultSet r = stmt.executeQuery(select);
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);;
                    idx++;

                    customer[idx] = r.getString(5);;
                    idx++;

                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;

                    customer[idx] = r.getString(9);;
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;

                    customer[idx] = r.getString(11);
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;

                }

            } else if (reptyp1.equals("CALLED BUT NOT SERVED")) {
                String select = "select *from `clinicaldb`.`schedule` where DATE>'" + concs + "' and SERVIES='ready' and CALLED='yes'";
                ResultSet r = stmt.executeQuery(select);
                int idx = 0;
                int c = 0;
                while (r.next()) {

                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);;
                    idx++;

                    customer[idx] = r.getString(5);;
                    idx++;

                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;

                    customer[idx] = r.getString(9);;
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;

                    customer[idx] = r.getString(11);
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;
                }

            } else if (reptyp1.equals("NOT CALLED")) {
                String select = "select *from `clinicaldb`.`schedule` where DATE>'" + concs + "'and CALLED='no'";
                ResultSet r = stmt.executeQuery(select);
                int idx = 0;
                int c = 0;
                while (r.next()) {

                    c++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);;
                    idx++;

                    customer[idx] = r.getString(5);;
                    idx++;

                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;

                    customer[idx] = r.getString(9);;
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;

                    customer[idx] = r.getString(11);
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;
                }

            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return customer;
    }

    public int view_pat_informationcount(String reptyp, String reptyp1, String sex) {


        int count = 0;



        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dx = s.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(d);
        String first = "";
        String second = "";
        String third = "";
        String conc = null;
        int cn = 0;
        int length = dx.length();
        char[] ccx = dx.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            first = first + ccx[h];
        }
        int length1 = dx.length();
        char[] ccx1 = dx.toCharArray();
        for (int h = 5; h < 7; h = h + 1) {
            second = second + ccx1[h];
        }
        int length2 = dx.length();
        char[] ccx2 = dx.toCharArray();
        for (int h = 8; h < 10; h = h + 1) {
            third = third + ccx2[h];
        }
        conc = first + second + third;
        int compute = 0;
        int dates = Integer.parseInt(conc);
        cn = Integer.parseInt(first);
        if (reptyp.equals("WEEKLY")) {
            compute = dates - 7;
        } else if (reptyp.equals("MONTHLY")) {
            compute = dates - 30;
        } else if (reptyp.equals("ANNUALLY")) {
            compute = cn - 1;
            first = String.valueOf(compute);
            String comps = first + second + third;
            compute = Integer.parseInt(comps);
        }
        String computes = String.valueOf(compute);
        String thirdst = null;
        String thirdsts = null;
        String firsts = "";
        String seconds = "";
        String thirds = "";
        String concs = null;
        int lengths = computes.length();
        char[] ccxs = computes.toCharArray();
        for (int h = 0; h < 4; h = h + 1) {
            firsts = firsts + ccxs[h];
        }
        firsts = firsts + "-";
        int lengths1 = computes.length();
        char[] ccxs1 = computes.toCharArray();
        for (int h = 4; h < 6; h = h + 1) {
            seconds = seconds + ccxs1[h];
        }
        seconds = seconds + "-";
        int lengthss2 = computes.length();
        char[] ccxss2 = computes.toCharArray();
        for (int h = 6; h < 8; h = h + 1) {
            thirds = thirds + ccxss2[h];
        }
        int thirdstss = Integer.parseInt(thirds);
        if (thirdstss > 30) {
            thirdstss = thirdstss - 70;
            thirds = String.valueOf(thirdstss);
        } else {
            thirds = thirds;
        }
        concs = firsts + seconds + thirds;
        int ci = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`patient_information`  where date>'" + concs + "' and serviceis='served' and sex='" + sex + "'";// where date>'5'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                ci++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int arraysize = ci * 19;


//
//        String customer[] = new String[arraysize];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            if (reptyp1.equals("SERVED")) {
                String select = "select *from `clinicaldb`.`patient_information` where date>'" + concs + "' and serviceis='served' and sex='" + sex + "'";
                ResultSet r = stmt.executeQuery(select);
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    count++;

                }

            } else if (reptyp1.equals("READY TO SERVE")) {
                String select = "select *from `clinicaldb`.`patient_information` where date>'" + concs + "' and serviceis='ready' and sex='" + sex + "'";
                ResultSet r = stmt.executeQuery(select);
                int idx = 0;
                int c = 0;
                while (r.next()) {
                    count++;



                }

            } else if (reptyp1.equals("CALLED BUT NOT SERVED")) {
                String select = "select *from `clinicaldb`.`patient_information` where date>'" + concs + "' and serviceis='ready' and called='yes' and sex='" + sex + "'";
                ResultSet r = stmt.executeQuery(select);
                int idx = 0;
                int c = 0;
                while (r.next()) {

                    count++;
                }

            } else {
                count = 0;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        return count;
    }

    public String[] calling(int arraysize,String btn_name, String room_number) {
        int kk = 0;
        
        String customer[] = new String[arraysize];
       if(btn_name.equals("CALLING"))
       {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`investigationtbl` where servieces='ready' and called='no' ORDER BY requist_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            //  int i=0,j=0;
            while (rs.next()) {
                kk++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int size = arraysize;
        String requestid = null;
        int i = 0, j = 0, c = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`investigationtbl` where servieces='ready' and called='no' ORDER BY requist_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            while (rs.next()) {
                i++;
            }
            String req_id = null;
            if (i >= 1) {
                String sels = "select *from `clinicaldb`.`investigationtbl` where servieces='ready'and called='no'  ORDER BY requist_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rss = stmt.executeQuery(sels);
                while (rss.next()) {

                    req_id = rss.getString("patient_id");
                    requestid = rss.getString("requist_id");
                }

                String sel = "select *from `clinicaldb`.`investigationtbl` where servieces='ready' and called='no' and requist_id='" + requestid + "' ORDER BY requist_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet r = stmt.executeQuery(sel);
                int ii = 0, jj = 0;
                int idx = 0;
                int k = 0;
                while (r.next()) {
                    k++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);
                    idx++;
                    customer[idx] = r.getString(5);
                    idx++;
                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;
                    customer[idx] = (r.getString(9));
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;
                    customer[idx] = (r.getString(11));
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;

                }
                String update = "update `clinicaldb`.`investigationtbl` SET called='yes' where requist_id='" + requestid + "'";
                stmt.executeUpdate(update);
            } else {
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }
       }
       else
       {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`investigationtbl` where servieces='ready' and called='yes' ORDER BY requist_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            //  int i=0,j=0;
            while (rs.next()) {
                kk++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int size = arraysize;
        String requestid = null;
        int i = 0, j = 0, c = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`investigationtbl` where servieces='ready' and called='yes' ORDER BY requist_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            while (rs.next()) {
                i++;
            }
            String req_id = null;
            if (i >= 1) {
                String sels = "select *from `clinicaldb`.`investigationtbl` where servieces='ready'and called='yes'  ORDER BY requist_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rss = stmt.executeQuery(sels);
                while (rss.next()) {

                    req_id = rss.getString("patient_id");
                    requestid = rss.getString("requist_id");
                }

                String sel = "select *from `clinicaldb`.`investigationtbl` where servieces='ready' and called='yes' and requist_id='" + requestid + "' ORDER BY requist_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet r = stmt.executeQuery(sel);
                int ii = 0, jj = 0;
                int idx = 0;
                int k = 0;
                while (r.next()) {
                    k++;
                    customer[idx] = r.getString(1);
                    idx++;
                    customer[idx] = r.getString(2);
                    idx++;
                    customer[idx] = r.getString(3);
                    idx++;
                    customer[idx] = r.getString(4);
                    idx++;
                    customer[idx] = r.getString(5);
                    idx++;
                    customer[idx] = r.getString(6);
                    idx++;
                    customer[idx] = (r.getString(7));
                    idx++;
                    customer[idx] = (r.getString(8));
                    idx++;
                    customer[idx] = (r.getString(9));
                    idx++;
                    customer[idx] = (r.getString(10));
                    idx++;
                    customer[idx] = (r.getString(11));
                    idx++;
                    customer[idx] = (r.getString(12));
                    idx++;

                }
                String update = "update `clinicaldb`.`investigationtbl` SET servieces='diactivated',called='yes' where requist_id='" + requestid + "'";
                stmt.executeUpdate(update);
            } else {
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }   
       }
        return customer;
    }

    public int calling_lab_result_count(String btn_name) {
        int kk = 0;
        int k = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`investigationtbl` where servieces='ready' ORDER BY requist_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            //  int i=0,j=0;
            while (rs.next()) {
                kk++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");
        }
        int arraysize = kk * 13;
        int size = arraysize;
        String customer[] = new String[arraysize];
        String requestid = null;
        int i = 0, j = 0, c = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`investigationtbl` where servieces='ready' ORDER BY requist_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            while (rs.next()) {
                i++;
            }
            String req_id = null;
            if (i >= 1) {
                if (btn_name.equals("CALLING")) {

                    String sels = "select *from `clinicaldb`.`investigationtbl` where servieces='ready'and called='no'  ORDER BY requist_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet rss = stmt.executeQuery(sels);
                    while (rss.next()) {

                        req_id = rss.getString("patient_id");
                        requestid = rss.getString("requist_id");
                    }

                    String sel = "select *from `clinicaldb`.`investigationtbl` where servieces='ready' and called='no' and requist_id='" + requestid + "' ORDER BY requist_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet r = stmt.executeQuery(sel);
                    int ii = 0, jj = 0;
                    int idx = 0;

                    while (r.next()) {
                        k++;

                    }
////               
//                    String update = "update `clinicaldb`.`investigationtbl` SET called='yes' where requist_id='" + requestid + "'";
//                    stmt.executeUpdate(update);
                } else {
                    String sels = "select *from `clinicaldb`.`investigationtbl` where servieces='ready'and called='yes'  ORDER BY requist_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet rss = stmt.executeQuery(sels);
                    while (rss.next()) {

                        req_id = rss.getString("patient_id");
                        requestid = rss.getString("requist_id");
                    }
                    String sel = "select *from `clinicaldb`.`investigationtbl` where servieces='ready' and called='yes' and requist_id='" + requestid + "' ORDER BY requist_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet r = stmt.executeQuery(sel);
                    int ii = 0, jj = 0;
                    int idx = 0;

                    while (r.next()) {
                        k++;

                    }
////               
//                    String update = "update `clinicaldb`.`investigationtbl` SET servieces='out of date' where requist_id='" + requestid + "'";
//                    stmt.executeUpdate(update);
                }
            } else {
            }
        } catch (Exception e) {
            System.out.println("lastHelloClient exception:" + e);
        }

        return k;
    }

    public String[] calling_for_history(String room_number, String btn_name) {
        String[] customer = new String[67];
        int i = 0, j = 0, c = 0;
        String req_id = null;
        int crdnm = 0;

        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dx = s.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(d);


        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`schedule` ORDER BY schedule_id DESC";
            ResultSet rs = stmt.executeQuery(ins);
            while (rs.next()) {
                i++;
            }

            if (i >= 1) {
                if (btn_name.equals("CALLING AGAIN")) {

                    String sels = "select *from `clinicaldb`.`schedule` where SERVIES='ready' and STATUES='emergency'and CALLED='yes' and DATE='" + dx + "' ORDER BY schedule_id DESC";
                    ResultSet sls = stmt.executeQuery(sels);
                    int k = 0, l = 0;
                    while (sls.next()) {
                        k++;
                    }
                    String selss = "select *from `clinicaldb`.`schedule` where SERVIES='ready' and STATUES='NORMAL' and CALLED='yes' and DATE='" + dx + "' ORDER BY schedule_id DESC";
                    ResultSet slss = stmt.executeQuery(selss);
                    int kk = 0;
                    while (slss.next()) {
                        kk++;
                    }

                    if (k >= 1) {
                        String sel = "select *from `clinicaldb`.`schedule` where SERVIES='ready' and STATUES='emergency' and CALLED='yes' and DATE='" + dx + "' ORDER BY schedule_id DESC";
                        ResultSet sl = stmt.executeQuery(sel);
                        int ii = 0, jj = 0;
                        while (sl.next()) {
                            req_id = sl.getString("schedule_id");
                            crdnm = sl.getInt("INFOMATION_ID");
                        }
                        String selsl = "select *from `clinicaldb`.`patient_information` where information_id='" + crdnm + "'";
                        ResultSet r = stmt.executeQuery(selsl);
                        int idx = 0;
                        int km = 0;
                        while (r.next()) {
                            km++;
                            customer[idx] = r.getString(1);
                            idx++;
                            customer[idx] = r.getString(2);
                            idx++;
                            customer[idx] = r.getString(3);
                            idx++;
                            customer[idx] = r.getString(4);
                            idx++;
                            customer[idx] = r.getString(5);
                            idx++;
                            customer[idx] = r.getString(6);
                            idx++;
                            customer[idx] = (r.getString(7));
                            idx++;
                            customer[idx] = (r.getString(8));
                            idx++;
                            customer[idx] = (r.getString(9));
                            idx++;
                            customer[idx] = (r.getString(10));
                            idx++;
                            customer[idx] = (r.getString(11));
                            idx++;
                            customer[idx] = (r.getString(12));
                            idx++;
                            customer[idx] = (r.getString(13));
                            idx++;
                            customer[idx] = (r.getString(14));
                            idx++;
                            customer[idx] = (r.getString(15));
                            idx++;
                            customer[idx] = (r.getString(16));
                            idx++;
                            customer[idx] = (r.getString(17));
                            idx++;
                            customer[idx] = (r.getString(18));
                            idx++;
                            customer[idx] = (r.getString(19));
                            idx++;
                        }
                        String update = "update `clinicaldb`.`schedule` SET SERVIES='diactivate' where schedule_id='" + req_id + "'  and DATE='" + dx + "'";
                        stmt.executeUpdate(update);



                    } else if (kk >= 1) {

                        String sel = "select *from `clinicaldb`.`schedule` where SERVIES='ready' and STATUES='NORMAL' and CALLED='yes' and DATE='" + dx + "' ORDER BY schedule_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                        ResultSet sl = stmt.executeQuery(sel);
                        int ii = 0, jj = 0;
                        while (sl.next()) {
                            req_id = sl.getString("schedule_id");
                            crdnm = sl.getInt("INFOMATION_ID");
                        }

                        String selS = "select *from `clinicaldb`.`patient_information` where information_id='" + crdnm + "'";
                        ResultSet r = stmt.executeQuery(selS);
                        int idx = 0;
                        int kK = 0;
                        while (r.next()) {
                            kK++;
                            customer[idx] = r.getString(1);
                            idx++;
                            customer[idx] = r.getString(2);
                            idx++;
                            customer[idx] = r.getString(3);
                            idx++;
                            customer[idx] = r.getString(4);
                            idx++;
                            customer[idx] = r.getString(5);
                            idx++;
                            customer[idx] = r.getString(6);
                            idx++;
                            customer[idx] = (r.getString(7));
                            idx++;
                            customer[idx] = (r.getString(8));
                            idx++;
                            customer[idx] = (r.getString(9));
                            idx++;
                            customer[idx] = (r.getString(10));
                            idx++;
                            customer[idx] = (r.getString(11));
                            idx++;
                            customer[idx] = (r.getString(12));
                            idx++;

                            customer[idx] = (r.getString(13));
                            idx++;
                            customer[idx] = (r.getString(14));
                            idx++;
                            customer[idx] = (r.getString(15));
                            idx++;
                            customer[idx] = (r.getString(16));
                            idx++;
                            customer[idx] = (r.getString(17));
                            idx++;
                            customer[idx] = (r.getString(18));
                            idx++;
                            customer[idx] = (r.getString(19));
                            idx++;
                        }




                        String update = "update `clinicaldb`.`schedule` SET SERVIES='diactivate' where schedule_id='" + req_id + "'";
                        stmt.executeUpdate(update);
                    } else {
                        System.out.println("nothing");
                    }
                } else {


                    String sels = "select *from `clinicaldb`.`schedule` where SERVIES='ready' and STATUES='emergency'and CALLED='no' ORDER BY schedule_id DESC";
                    ResultSet sls = stmt.executeQuery(sels);
                    int k = 0, l = 0;
                    while (sls.next()) {
                        k++;
                    }
                    String selss = "select *from `clinicaldb`.`schedule` where SERVIES='ready' and STATUES='NORMAL' and CALLED='no' ORDER BY schedule_id DESC";
                    ResultSet slss = stmt.executeQuery(selss);
                    int kk = 0;
                    while (slss.next()) {
                        kk++;
                    }

                    if (k >= 1) {
                        String sel = "select *from `clinicaldb`.`schedule` where SERVIES='ready' and STATUES='emergency' and CALLED='no' ORDER BY schedule_id DESC";
                        ResultSet sl = stmt.executeQuery(sel);
                        int ii = 0, jj = 0;
                        while (sl.next()) {
                            req_id = sl.getString("schedule_id");
                            crdnm = sl.getInt("INFOMATION_ID");
                        }
                        String selsl = "select *from `clinicaldb`.`patient_information` where information_id='" + crdnm + "'";
                        ResultSet r = stmt.executeQuery(selsl);
                        int idx = 0;
                        int km = 0;
                        while (r.next()) {
                            km++;
                            customer[idx] = r.getString(1);
                            idx++;
                            customer[idx] = r.getString(2);
                            idx++;
                            customer[idx] = r.getString(3);
                            idx++;
                            customer[idx] = r.getString(4);
                            idx++;
                            customer[idx] = r.getString(5);
                            idx++;
                            customer[idx] = r.getString(6);
                            idx++;
                            customer[idx] = (r.getString(7));
                            idx++;
                            customer[idx] = (r.getString(8));
                            idx++;
                            customer[idx] = (r.getString(9));
                            idx++;
                            customer[idx] = (r.getString(10));
                            idx++;
                            customer[idx] = (r.getString(11));
                            idx++;
                            customer[idx] = (r.getString(12));
                            idx++;
                            customer[idx] = (r.getString(13));
                            idx++;
                            customer[idx] = (r.getString(14));
                            idx++;
                            customer[idx] = (r.getString(15));
                            idx++;
                            customer[idx] = (r.getString(16));
                            idx++;
                            customer[idx] = (r.getString(17));
                            idx++;
                            customer[idx] = (r.getString(18));
                            idx++;
                            customer[idx] = (r.getString(19));
                            idx++;
                        }
                        String update = "update `clinicaldb`.`schedule` SET CALLED='yes' where schedule_id='" + req_id + "'";
                        stmt.executeUpdate(update);



                    } else if (kk >= 1) {

                        String sel = "select *from `clinicaldb`.`schedule` where SERVIES='ready' and STATUES='NORMAL' and CALLED='no' ORDER BY schedule_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                        ResultSet sl = stmt.executeQuery(sel);
                        int ii = 0, jj = 0;
                        while (sl.next()) {
                            req_id = sl.getString("schedule_id");
                            crdnm = sl.getInt("INFOMATION_ID");
                        }

                        String selS = "select *from `clinicaldb`.`patient_information` where information_id='" + crdnm + "'";
                        ResultSet r = stmt.executeQuery(selS);
                        int idx = 0;
                        int kK = 0;
                        while (r.next()) {
                            kK++;
                            customer[idx] = r.getString(1);
                            idx++;
                            customer[idx] = r.getString(2);
                            idx++;
                            customer[idx] = r.getString(3);
                            idx++;
                            customer[idx] = r.getString(4);
                            idx++;
                            customer[idx] = r.getString(5);
                            idx++;
                            customer[idx] = r.getString(6);
                            idx++;
                            customer[idx] = (r.getString(7));
                            idx++;
                            customer[idx] = (r.getString(8));
                            idx++;
                            customer[idx] = (r.getString(9));
                            idx++;
                            customer[idx] = (r.getString(10));
                            idx++;
                            customer[idx] = (r.getString(11));
                            idx++;
                            customer[idx] = (r.getString(12));
                            idx++;

                            customer[idx] = (r.getString(13));
                            idx++;
                            customer[idx] = (r.getString(14));
                            idx++;
                            customer[idx] = (r.getString(15));
                            idx++;
                            customer[idx] = (r.getString(16));
                            idx++;
                            customer[idx] = (r.getString(17));
                            idx++;
                            customer[idx] = (r.getString(18));
                            idx++;
                            customer[idx] = (r.getString(19));
                            idx++;
                        }




                        String update = "update `clinicaldb`.`schedule` SET CALLED='yes' where schedule_id='" + req_id + "'";
                        stmt.executeUpdate(update);
                    } else {
                        System.out.println("nothing");
                    }


                }
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }
        return customer;
    }

    public int call_pat_for_history(String btn_name) {


        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String dx = s.format(d);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(d);

        int counter = 0;
        int i = 0, j = 0, c = 0;
        String req_id = null;
        int crdnm = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`schedule` ORDER BY schedule_id DESC";
            ResultSet rs = stmt.executeQuery(ins);
            while (rs.next()) {
                i++;
            }

            if (i >= 1) {
                if (btn_name.equals("CALLING AGAIN")) {
                    String sels = "select *from `clinicaldb`.`schedule` where SERVIES='ready' and STATUES='EMERGENCY'and CALLED='yes' and DATE='" + dx + "' ORDER BY schedule_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sls = stmt.executeQuery(sels);
                    int k = 0, l = 0;
                    while (sls.next()) {
                        k++;
                    }

                    String selss = "select *from `clinicaldb`.`schedule` where SERVIES='ready' and STATUES='NORMAL' and CALLED='yes' and DATE='" + dx + "' ORDER BY schedule_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet slss = stmt.executeQuery(selss);
                    int kk = 0;
                    while (slss.next()) {
                        kk++;
                    }

                    if (k >= 1 || kk >= 1) {
                        counter++;
                    } else {
                        counter = 0;
                    }
                } else {

                    String sels = "select *from `clinicaldb`.`schedule` where SERVIES='ready' and STATUES='EMERGENCY'and CALLED='no' ORDER BY schedule_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sls = stmt.executeQuery(sels);
                    int k = 0, l = 0;
                    while (sls.next()) {
                        k++;
                    }

                    String selss = "select *from `clinicaldb`.`schedule` where SERVIES='ready' and STATUES='NORMAL' and CALLED='no' ORDER BY schedule_id DESC";
                    ResultSet slss = stmt.executeQuery(selss);
                    int kk = 0;
                    while (slss.next()) {
                        kk++;
                    }

                    if (k >= 1 || kk >= 1) {
                        counter++;
                    } else {
                        counter = 0;
                    }


                }
            }




        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }


        return counter;
    }

    public String[] calling_for_prescription(String room_num) {
        int iii = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`investigation_result`  where servieces='ready' and called='no'  ORDER BY lab_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            while (rs.next()) {
                iii++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }
        int arraysize = iii * 13;
        String[] customer = new String[arraysize];
        int i = 0, j = 0, c = 0;
        String lab_idr = null;
        String id_numberr = null;
        String datesr = null;
        String timer = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`investigation_result`  where servieces='ready' and called='no'  ORDER BY lab_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            while (rs.next()) {
                i++;
            }

            if (i >= 1) {
                String sels = "select *from `clinicaldb`.`investigation_result`  where servieces='ready' and called='no'  ORDER BY lab_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet sls = stmt.executeQuery(sels);
                while (sls.next()) {

                    lab_idr = sls.getString("lab_id");
                    id_numberr = sls.getString("id_number");
                    datesr = sls.getString("collection_date");
                    timer = sls.getString("collection_time");
                }





                String sel = "select *from `clinicaldb`.`investigation_result`  where servieces='ready' and called='no' and lab_id='" + lab_idr + "'  ORDER BY lab_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet sl = stmt.executeQuery(sel);
                int ii = 0, jj = 0, k = 0, idx = 0;
                while (sl.next()) {
                    k++;
                    customer[idx] = sl.getString(1);
                    idx++;
                    customer[idx] = sl.getString(2);
                    idx++;
                    customer[idx] = sl.getString(3);
                    idx++;
                    customer[idx] = sl.getString(4);
                    idx++;
                    customer[idx] = sl.getString(5);
                    idx++;
                    customer[idx] = sl.getString(6);
                    idx++;
                    customer[idx] = sl.getString(7);
                    idx++;
                    customer[idx] = sl.getString(8);
                    idx++;
                    customer[idx] = sl.getString(9);
                    idx++;
                    customer[idx] = sl.getString(10);
                    idx++;
                    customer[idx] = sl.getString(11);
                    idx++;
                    customer[idx] = sl.getString(12);
                    idx++;
                    customer[idx] = sl.getString(13);
                    idx++;



                }

                String update = "update `clinicaldb`.`investigation_result` SET called='yes' where lab_id='" + lab_idr + "'";//+id+"'";
                stmt.executeUpdate(update);

            } else {
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }

        return customer;
    }

    public int calling_prescription_count() {
        int iii = 0;
        int ii = 0, jj = 0, k = 0, idx = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`investigation_result`  where servieces='ready' and called='no'  ORDER BY lab_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            while (rs.next()) {
                iii++;
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }
        int arraysize = iii * 13;
        String[] customer = new String[arraysize];
        int i = 0, j = 0, c = 0;
        String lab_idr = null;
        String id_numberr = null;
        String datesr = null;
        String timer = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`investigation_result`  where servieces='ready' and called='no'  ORDER BY lab_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
            ResultSet rs = stmt.executeQuery(ins);
            while (rs.next()) {
                i++;
                lab_idr = rs.getString("lab_id");
            }

            if (i >= 1) {
                String sels = "select *from `clinicaldb`.`investigation_result`  where servieces='ready' and called='no'  and lab_id='" + lab_idr + "' ORDER BY lab_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet sls = stmt.executeQuery(sels);
                while (sls.next()) {

                    lab_idr = sls.getString("lab_id");
                    id_numberr = sls.getString("id_number");
                    datesr = sls.getString("collection_date");
                    timer = sls.getString("collection_time");
                }





                String sel = "select *from `clinicaldb`.`investigation_result`  where servieces='ready' and called='no' and lab_id='" + lab_idr + "'  ORDER BY lab_id DESC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet sl = stmt.executeQuery(sel);
                while (sl.next()) {
                    k++;
                }

                String update = "update `clinicaldb`.`investigation_result` SET called='yes' where lab_id='" + lab_idr + "' and id_number'" + id_numberr + "'";//+id+"'";
                stmt.executeUpdate(update);

            } else {
            }
        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }

        return k;
    }

    public String SUMMERY(String id_number, String button_name, String subjective_summry, String objective_summry, String assasment) {


        String historyid = null;


        if (button_name.equals("UPDATE")) {


            try {
                Class.forName("com.mysql.jdbc.Driver");
                String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String y = "root";
                String z = "vertrigo";
                Connection con;
                con = DriverManager.getConnection(w, y, z);
                Statement stmt = con.createStatement();
                String ins = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "' ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rs = stmt.executeQuery(ins);
                int i = 0, j = 0;
                while (rs.next()) {
                    i++;
                }

                if (i >= 1) {

                    String sel = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "' ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sl = stmt.executeQuery(sel);
                    int ii = 0, jj = 0;
                    while (sl.next()) {
                        historyid = sl.getString("history_id");
                    }

                    String update = "update `clinicaldb`.`patient_history` SET subjective_summry='" + subjective_summry + "',objective_summry='" + objective_summry + "',assasment='" + assasment + "' where history_id='" + historyid + "'";//+id+"'";
                    stmt.executeUpdate(update);
                }
            } catch (Exception e) {
                System.out.println("HelloClient exception:" + e);
            }
        } else {


            try {
                Class.forName("com.mysql.jdbc.Driver");
                String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String y = "root";
                String z = "vertrigo";
                Connection con;
                con = DriverManager.getConnection(w, y, z);

                Statement stmt = con.createStatement();
                String ins = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rs = stmt.executeQuery(ins);
                int i = 0, j = 0;
                while (rs.next()) {
                    i++;
                }
                if (i >= 1) {
                    String sel = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sl = stmt.executeQuery(sel);
                    int ii = 0, jj = 0;
                    while (sl.next()) {
                        historyid = sl.getString("history_id");
                    }

                    String update = "update `clinicaldb`.`patient_history` SET subjective_summry='" + subjective_summry + "',objective_summry='" + objective_summry + "',assasment='" + assasment + "' where history_id='" + historyid + "'";//+id+"'";
                    stmt.executeUpdate(update);

                }
            } catch (Exception e) {
                System.out.println("HelloClient exception:" + e);
            }
        }
        return null;
    }

    public String examination4(String id_number, String button_name, String glascomas_system, String minimental_system, String CN1, String CN2, String CN3, String CN4, String CN5, String CN6, String CN7, String CN8, String CN9, String CN10, String CN11, String CN12) {


        String historyid = null;


        if (button_name.equals("UPDATE")) {


            try {
                Class.forName("com.mysql.jdbc.Driver");
                String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String y = "root";
                String z = "vertrigo";
                Connection con;
                con = DriverManager.getConnection(w, y, z);
                Statement stmt = con.createStatement();
                String ins = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "' ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rs = stmt.executeQuery(ins);
                int i = 0, j = 0;
                while (rs.next()) {
                    i++;
                }

                if (i >= 1) {

                    String sel = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "' ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sl = stmt.executeQuery(sel);
                    int ii = 0, jj = 0;
                    while (sl.next()) {
                        historyid = sl.getString("history_id");
                    }


                    String update = "update `clinicaldb`.`patient_history` SET glascomas_system='" + glascomas_system + "',minimental_system='" + minimental_system + "',cranial_nervous_system_CN1='" + CN1 + "',cranial_nervous_system_CN2='" + CN2 + "',cranial_nervous_system_CN3='" + CN3 + "',cranial_nervous_system_CN4='" + CN4 + "',cranial_nervous_system_CN5='" + CN5 + "',cranial_nervous_system_CN6='" + CN6 + "',cranial_nervous_system_CN7='" + CN7 + "',cranial_nervous_system_CN8='" + CN8 + "',cranial_nervous_system_CN9='" + CN9 + "',cranial_nervous_system_CN10='" + CN10 + "',cranial_nervous_system_CN11='" + CN11 + "',cranial_nervous_system_CN12='" + CN12 + "' where history_id='" + historyid + "'";//+id+"'";
                    stmt.executeUpdate(update);
                }
            } catch (Exception e) {
                System.out.println("HelloClient exception:" + e);
            }
        } else {


            try {
                Class.forName("com.mysql.jdbc.Driver");
                String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String y = "root";
                String z = "vertrigo";
                Connection con;
                con = DriverManager.getConnection(w, y, z);

                Statement stmt = con.createStatement();
                String ins = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rs = stmt.executeQuery(ins);
                int i = 0, j = 0;
                while (rs.next()) {
                    i++;
                }
                if (i >= 1) {
                    String sel = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sl = stmt.executeQuery(sel);
                    int ii = 0, jj = 0;
                    while (sl.next()) {
                        historyid = sl.getString("history_id");
                    }

                    String update = "update `clinicaldb`.`patient_history` SET glascomas_system='" + glascomas_system + "',minimental_system='" + minimental_system + "',cranial_nervous_system_CN1='" + CN1 + "',cranial_nervous_system_CN2='" + CN2 + "',cranial_nervous_system_CN3='" + CN3 + "',cranial_nervous_system_CN4='" + CN4 + "',cranial_nervous_system_CN5='" + CN5 + "',cranial_nervous_system_CN6='" + CN6 + "',cranial_nervous_system_CN7='" + CN7 + "',cranial_nervous_system_CN8='" + CN8 + "',cranial_nervous_system_CN9='" + CN9 + "',cranial_nervous_system_CN10='" + CN10 + "',cranial_nervous_system_CN11='" + CN11 + "',cranial_nervous_system_CN12='" + CN12 + "' where history_id='" + historyid + "'";//+id+"'";
                    stmt.executeUpdate(update);

                }
            } catch (Exception e) {
                System.out.println("HelloClient exception:" + e);
            }
        }
        return null;
    }

    public String examination4(String id_number, String button_name, String inspection, String palpotion, String percution, String auscultation, String inspections, String palpotions, String percutions, String auscultations) {



        String historyid = null;


        if (button_name.equals("UPDATE")) {


            try {
                Class.forName("com.mysql.jdbc.Driver");
                String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String y = "root";
                String z = "vertrigo";
                Connection con;
                con = DriverManager.getConnection(w, y, z);
                Statement stmt = con.createStatement();
                String ins = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "' ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rs = stmt.executeQuery(ins);
                int i = 0, j = 0;
                while (rs.next()) {
                    i++;
                }

                if (i >= 1) {

                    String sel = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "' ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sl = stmt.executeQuery(sel);
                    int ii = 0, jj = 0;
                    while (sl.next()) {
                        historyid = sl.getString("history_id");
                    }


                    String update = "update `clinicaldb`.`patient_history` SET musko_skeletal_system_inspection='" + inspection + "',musko_skeletal_system_palpotion='" + palpotion + "',musko_skeletal_system_percution='" + percution + "',musko_skeletal_system_auscultation='" + auscultation + "',integmentary_system_inspections='" + inspections + "',integmentary_system_palpotions='" + palpotions + "',integmentary_system_percutions='" + percutions + "',integmentary_system_auscultations='" + auscultations + "' where history_id='" + historyid + "'";//+id+"'";
                    stmt.executeUpdate(update);
                }
            } catch (Exception e) {
                System.out.println("HelloClient exception:" + e);
            }
        } else {



            try {

                Class.forName("com.mysql.jdbc.Driver");
                String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String y = "root";
                String z = "vertrigo";
                Connection con;
                con = DriverManager.getConnection(w, y, z);

                Statement stmt = con.createStatement();
                String ins = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rs = stmt.executeQuery(ins);
                int i = 0, j = 0;
                while (rs.next()) {
                    i++;
                }
                if (i >= 1) {
                    String sel = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sl = stmt.executeQuery(sel);
                    int ii = 0, jj = 0;
                    while (sl.next()) {
                        historyid = sl.getString("history_id");
                    }

                    String update = "update `clinicaldb`.`patient_history` SET musko_skeletal_system_inspection='" + inspection + "',musko_skeletal_system_palpotion='" + palpotion + "',musko_skeletal_system_percution='" + percution + "',musko_skeletal_system_auscultation='" + auscultation + "',integmentary_system_inspections='" + inspections + "',integmentary_system_palpotions='" + palpotions + "',integmentary_system_percutions='" + percutions + "',integmentary_system_auscultations='" + auscultations + "' where history_id='" + historyid + "'";//+id+"'";
                    stmt.executeUpdate(update);

                }
            } catch (Exception e) {
                System.out.println("HelloClient exception:" + e);
            }
        }
        return null;
    }

    public String examination3(String id_number, String button_name, String inspection, String palpotion, String percution, String auscultation, String inspections, String palpotions, String percutions, String auscultations) {


        String historyid = null;


        if (button_name.equals("UPDATE")) {


            try {
                Class.forName("com.mysql.jdbc.Driver");
                String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String y = "root";
                String z = "vertrigo";
                Connection con;
                con = DriverManager.getConnection(w, y, z);
                Statement stmt = con.createStatement();
                String ins = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "' ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rs = stmt.executeQuery(ins);
                int i = 0, j = 0;
                while (rs.next()) {
                    i++;
                }

                if (i >= 1) {

                    String sel = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "' ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sl = stmt.executeQuery(sel);
                    int ii = 0, jj = 0;
                    while (sl.next()) {
                        historyid = sl.getString("history_id");
                    }
                    String update = "update `clinicaldb`.`patient_history` SET abdomenal_system_inspection='" + inspection + "',abdomenal_system_palpotion='" + palpotion + "',abdomenal_system_percution='" + percution + "',abdomenal_system_auscultation='" + auscultation + "',genitouniry_system_inspections='" + inspections + "',genitouniry_system_palpotions='" + palpotions + "',genitouniry_system_percutions='" + percutions + "',genitouniry_system_auscultations='" + auscultations + "' where history_id='" + historyid + "'";//+id+"'";
                    stmt.executeUpdate(update);

//                  String update = "update `clinicaldb`.`patient_history` SET lympho_glandular_system='" + lgss + "',resparatory_system_inspection='" + inspection + "',resparatory_system_palpotion='" + palpotion + "',resparatory_system_percution='" + percution + "',resparatory_system_auscultation='" + auscultation + "',cardio_vascular_system_arteroi='" + arteroi + "',cardio_vascular_system_venuos='" + venuos + "',precordial_inspections='" + inspections + "',precordial_palpotions='" + palpotions + "',precordial_percutions='" + percutions + "',precordial_auscultations='" + auscultations + "' where history_id='" + historyid + "'";//+id+"'";
//                stmt.executeUpdate(update);

//                String update = "update `clinicaldb`.`patient_history` SET general_apearance='" + gap + "',blood_presure='" + blood_presure + "',resparatory_rate='" + resparatory_rate + "',pulse_rate='" + pulse_rate + "',temprature='" + temprature + "',head='" + head + "',ear='" + ear + "',eyes='" + eyes + "',nose='" + nose + "',mouth='" + mouth + "' where history_id=" + historyid;
//                stmt.executeUpdate(update);


                }
            } //               catch(NotBoundException e){
            //                System.out.println("Clinicalclient not bound exception:" +e);
            //               // lbl.setTexteyes("Clinicalclient not bound exception:" +e.getMessage());
            //            }
            catch (Exception e) {
                System.out.println("HelloClient exception:" + e);
            }
        } else {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String y = "root";
                String z = "vertrigo";
                Connection con;
                con = DriverManager.getConnection(w, y, z);

                Statement stmt = con.createStatement();
                String ins = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rs = stmt.executeQuery(ins);
                int i = 0, j = 0;
                while (rs.next()) {
                    i++;
                }
                if (i >= 1) {
                    String sel = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sl = stmt.executeQuery(sel);
                    int ii = 0, jj = 0;
                    while (sl.next()) {
                        historyid = sl.getString("history_id");
                    }

                    String update = "update `clinicaldb`.`patient_history` SET abdomenal_system_inspection='" + inspection + "',abdomenal_system_palpotion='" + palpotion + "',abdomenal_system_percution='" + percution + "',abdomenal_system_auscultation='" + auscultation + "',genitouniry_system_inspections='" + inspections + "',genitouniry_system_palpotions='" + palpotions + "',genitouniry_system_percutions='" + percutions + "',genitouniry_system_auscultations='" + auscultations + "' where history_id='" + historyid + "'";//+id+"'";
                    stmt.executeUpdate(update);
                }
            } catch (Exception e) {
                System.out.println("HelloClient exception:" + e);

            }
        }
        return null;
    }

    public String examination2(String id_number, String button_name, String arteroi, String venuos, String lgss, String inspection, String palpotion, String percution, String auscultation, String inspections, String palpotions, String percutions, String auscultations) {
        String historyid = null;


        if (button_name.equals("UPDATE")) {


            try {
                Class.forName("com.mysql.jdbc.Driver");
                String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String y = "root";
                String z = "vertrigo";
                Connection con;
                con = DriverManager.getConnection(w, y, z);
                Statement stmt = con.createStatement();
                String ins = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "' ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rs = stmt.executeQuery(ins);
                int i = 0, j = 0;
                while (rs.next()) {
                    i++;
                }

                if (i >= 1) {

                    String sel = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "' ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sl = stmt.executeQuery(sel);
                    int ii = 0, jj = 0;
                    while (sl.next()) {
                        historyid = sl.getString("history_id");
                    }

                    String update = "update `clinicaldb`.`patient_history` SET lympho_glandular_system='" + lgss + "',resparatory_system_inspection='" + inspection + "',resparatory_system_palpotion='" + palpotion + "',resparatory_system_percution='" + percution + "',resparatory_system_auscultation='" + auscultation + "',cardio_vascular_system_arteroi='" + arteroi + "',cardio_vascular_system_venuos='" + venuos + "',precordial_inspections='" + inspections + "',precordial_palpotions='" + palpotions + "',precordial_percutions='" + percutions + "',precordial_auscultations='" + auscultations + "' where history_id='" + historyid + "'";//+id+"'";
                    stmt.executeUpdate(update);

//                String update = "update `clinicaldb`.`patient_history` SET general_apearance='" + gap + "',blood_presure='" + blood_presure + "',resparatory_rate='" + resparatory_rate + "',pulse_rate='" + pulse_rate + "',temprature='" + temprature + "',head='" + head + "',ear='" + ear + "',eyes='" + eyes + "',nose='" + nose + "',mouth='" + mouth + "' where history_id=" + historyid;
//                stmt.executeUpdate(update);


                }
            } //               catch(NotBoundException e){
            //                System.out.println("Clinicalclient not bound exception:" +e);
            //               // lbl.setTexteyes("Clinicalclient not bound exception:" +e.getMessage());
            //            }
            catch (Exception e) {
                System.out.println("HelloClient exception:" + e);
            }
        } else {





            try {
                Class.forName("com.mysql.jdbc.Driver");
                String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String y = "root";
                String z = "vertrigo";
                Connection con;
                con = DriverManager.getConnection(w, y, z);

                Statement stmt = con.createStatement();
                String ins = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rs = stmt.executeQuery(ins);
                int i = 0, j = 0;
                while (rs.next()) {
                    i++;
                }
                //String historyid = null;
                if (i >= 1) {
                    String sel = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sl = stmt.executeQuery(sel);
                    int ii = 0, jj = 0;
                    while (sl.next()) {
                        historyid = sl.getString("history_id");
                    }

                    String update = "update `clinicaldb`.`patient_history` SET lympho_glandular_system='" + lgss + "',resparatory_system_inspection='" + inspection + "',resparatory_system_palpotion='" + palpotion + "',resparatory_system_percution='" + percution + "',resparatory_system_auscultation='" + auscultation + "',cardio_vascular_system_arteroi='" + arteroi + "',cardio_vascular_system_venuos='" + venuos + "',precordial_inspections='" + inspections + "',precordial_palpotions='" + palpotions + "',precordial_percutions='" + percutions + "',precordial_auscultations='" + auscultations + "' where history_id='" + historyid + "'";//+id+"'";
                    stmt.executeUpdate(update);
                }
            } catch (Exception e) {
                System.out.println("HelloClient exception:" + e);
            }
        }

        return null;
    }

    public String examination1(String Id_for_search, String button_name, String gap, String temprature, String blood_presure, String resparatory_rate, String pulse_rate, String head, String ear, String eyes, String nose, String mouth) {
        String historyid = null;


        if (button_name.equals("UPDATE")) {


            try {
                Class.forName("com.mysql.jdbc.Driver");
                String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String y = "root";
                String z = "vertrigo";
                Connection con;
                con = DriverManager.getConnection(w, y, z);
                Statement stmt = con.createStatement();
                String ins = "select *from `clinicaldb`.`patient_history` where id_number='" + Id_for_search + "' ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rs = stmt.executeQuery(ins);
                int i = 0, j = 0;
                while (rs.next()) {
                    i++;
                }

                if (i >= 1) {

                    String sel = "select *from `clinicaldb`.`patient_history` where id_number='" + Id_for_search + "' ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sl = stmt.executeQuery(sel);
                    int ii = 0, jj = 0;
                    while (sl.next()) {
                        historyid = sl.getString("history_id");
                    }

                    String update = "update `clinicaldb`.`patient_history` SET general_apearance='" + gap + "',blood_presure='" + blood_presure + "',resparatory_rate='" + resparatory_rate + "',pulse_rate='" + pulse_rate + "',temprature='" + temprature + "',head='" + head + "',ear='" + ear + "',eyes='" + eyes + "',nose='" + nose + "',mouth='" + mouth + "' where history_id=" + historyid;
                    stmt.executeUpdate(update);


                }
            } //               catch(NotBoundException e){
            //                System.out.println("Clinicalclient not bound exception:" +e);
            //               // lbl.setTexteyes("Clinicalclient not bound exception:" +e.getMessage());
            //            }
            catch (Exception e) {
                System.out.println("HelloClient exception:" + e);
            }
        } else {


            try {
                Class.forName("com.mysql.jdbc.Driver");
                String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String y = "root";
                String z = "vertrigo";
                Connection con;
                con = DriverManager.getConnection(w, y, z);
                Statement stmt = con.createStatement();
                String ins = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rs = stmt.executeQuery(ins);
                int i = 0, j = 0;
                while (rs.next()) {
                    i++;
                }

                if (i >= 1) {

                    String sel = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet sl = stmt.executeQuery(sel);
                    int ii = 0, jj = 0;
                    while (sl.next()) {
                        historyid = sl.getString("history_id");
                    }

                    String update = "update `clinicaldb`.`patient_history` SET general_apearance='" + gap + "',blood_presure='" + blood_presure + "',resparatory_rate='" + resparatory_rate + "',pulse_rate='" + pulse_rate + "',temprature='" + temprature + "',head='" + head + "',ear='" + ear + "',eyes='" + eyes + "',nose='" + nose + "',mouth='" + mouth + "' where history_id='" + historyid + "'";
                    stmt.executeUpdate(update);


                }
            } //               catch(NotBoundException e){
            //                System.out.println("Clinicalclient not bound exception:" +e);
            //               // lbl.setTexteyes("Clinicalclient not bound exception:" +e.getMessage());
            //            }
            catch (Exception e) {
                System.out.println("HelloClient exception:" + e);
            }
        }
        return null;
    }

    public ArrayList findAll() {
        ArrayList arr = new ArrayList();
        int c = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`user_account`";//where user_name='"+user_name+"' and password='"+Password+"'and profession='"+Profession+"'";
            ResultSet rs = stmt.executeQuery(ins);

            while (rs.next()) {
                c++;
                Province p = new Province();
                p.setId(rs.getInt("member_id"));
                p.setShortName(rs.getString("user_name"));
                p.setName(rs.getString("password"));
                arr.add(p);
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }
        return arr;
    }

    public String[] login(String user_name, String Password) {
        int c = 0;
        String id_number = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`user_account`where user_name='" + user_name + "' and password='" + Password + "'and statues='1'";
            ResultSet rs = stmt.executeQuery(ins);

            while (rs.next()) {
                c++;
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }
        int arraysize = c * 13;
        int size = arraysize;
        String customer[] = new String[size];
        int indx = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`user_account`where user_name='" + user_name + "' and password='" + Password + "'and statues='1'";
            ResultSet rs = stmt.executeQuery(ins);

            while (rs.next()) {
                c++;
            }

            String inss = "select *from `clinicaldb`.`user_account`where user_name='" + user_name + "' and password='" + Password + "'and statues='1'";
            ResultSet rss = stmt.executeQuery(inss);

            while (rss.next()) {
                id_number = rss.getString("member_id");
            }
            String insss = "select *from `clinicaldb`.`member`where member_id='" + id_number + "'and statues='1'";
            ResultSet rsss = stmt.executeQuery(insss);
            int cc = 0;
            while (rsss.next()) {
                cc++;
                customer[indx] = (rsss.getString(1));
                indx++;
                customer[indx] = (rsss.getString(2));
                indx++;
                customer[indx] = (rsss.getString(3));
                indx++;
                customer[indx] = (rsss.getString(4));
                indx++;
                customer[indx] = (rsss.getString(5));
                indx++;
                customer[indx] = (rsss.getString(6));
                indx++;
                customer[indx] = (rsss.getString(7));
                indx++;
                customer[indx] = (rsss.getString(8));
                indx++;
                customer[indx] = (rsss.getString(9));
                indx++;
                customer[indx] = (rsss.getString(10));
                indx++;
                customer[indx] = (rsss.getString(11));
                indx++;
                customer[indx] = (rsss.getString(12));
                indx++;
                customer[indx] = (rsss.getString(13));
                indx++;
            }

        } catch (Exception e) {
            System.out.println("HelloClient exception:" + e);
        }
        //String[] cx = String.v
        return customer;
    }

    public String patient_information(String card_number, String id_number, String first_name, String midle_name, String last_name, String age, String sex, String occupation, String religion, String address, String ready, String date, String sts, String time, String department, String block_number, String dormetry_number) {
        String card_numbers = null;
        int cardnumbers = 0;
        String schedule_id = null;
        int schedule_ids = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            int cardnumber = 0, informationid = 0;
            String information_id = null;
            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`patient_information`";
            ResultSet rs = stmt.executeQuery(ins);
            int i = 0, j = 0;
            while (rs.next()) {
                i++;
            }
            if (i >= 1) {
                String inss = "select *from `clinicaldb`.`patient_information` ORDER BY card_number ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet r = stmt.executeQuery(inss);
                while (r.next()) {
                    card_number = r.getString("card_number");
                }
                String slinfo = "select *from `clinicaldb`.`patient_information` ORDER BY information_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rsinf = stmt.executeQuery(slinfo);
                while (rsinf.next()) {
                    information_id = rsinf.getString("information_id");

                }

                String crd_inc = "select *from `clinicaldb`.`patient_information` where id_number='" + id_number + "'";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rs_crd_inc = stmt.executeQuery(crd_inc);
                int m = 0;
                while (rs_crd_inc.next()) {
                    m++;
                }
                String selschedule = "select *from `clinicaldb`.`schedule` ORDER BY schedule_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                ResultSet rsschedule = stmt.executeQuery(selschedule);
                while (rsschedule.next()) {
                    schedule_id = rsschedule.getString("schedule_id");
                }
                if (m >= 1) {
                    String crd_incs = "select *from `clinicaldb`.`patient_information` where id_number='" + id_number + "'";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet rs_crd_incs = stmt.executeQuery(crd_incs);
                    String informationids = null;
                    while (rs_crd_incs.next()) {
                        informationids = rs_crd_incs.getString("information_id");
                        card_numbers = rs_crd_incs.getString("card_number");
                        first_name = rs_crd_incs.getString("first_name");
                        midle_name = rs_crd_incs.getString("middle_name");
                        last_name = rs_crd_incs.getString("last_name");
                        sex = rs_crd_incs.getString("sex");
                        occupation = rs_crd_incs.getString("occupation");
                        address = rs_crd_incs.getString("address");
                        religion = rs_crd_incs.getString("religion");
                    }
                    cardnumber = cardnumbers;
                    cardnumber = Integer.parseInt(card_numbers);
                    informationid = Integer.parseInt(information_id);
                    informationid = Integer.parseInt(informationids);
                    schedule_ids = Integer.parseInt(schedule_id);
                    schedule_ids = schedule_ids + 1;
                   // stmt.executeUpdate("INSERT INTO `clinicaldb`.`schedule` (`schedule_id`, `INFOMATION ID`, `CARD NUMBER`, `ID NUMBER`, `AGE`, `SERVIES`, `DATE`, `STATUES`, `TIME`, `CALLED`, `BLOCK NUMBER`, `DORMITORY NUMBER`) VALUES (" + schedule_ids + ", " + informationid + ", '" + cardnumber + "', '" + id_number + "', '" + age + "', '" + ready + "', '" + date + "', '" + sts + "', '" + time + "', 'no', '" + block_number + "', '" + dormetry_number + "')");
                 stmt.executeUpdate("INSERT INTO `clinicaldb`.`schedule` (`schedule_id`, `INFOMATION_ID`, `CARD_NUMBER`, `ID_NUMBER`, `AGE`, `SERVIES`, `DATE`, `STATUES`, `TIME`, `CALLED`, `BLOCK_NUMBER`, `DORMITORY_NUMBER`) VALUES ("+schedule_ids+", "+informationid+",  '" + cardnumber + "', '" + id_number + "', '" + age + "', '" + ready + "', '" + date + "', '" + sts + "', '" + time + "', 'no', '" + block_number + "', '" + dormetry_number + "')");
               
                } else {
                    schedule_ids = Integer.parseInt(schedule_id);
                    schedule_ids = schedule_ids + 1;
                    cardnumber = Integer.parseInt(card_number);
                    cardnumber = cardnumber + 1;
                    informationid = Integer.parseInt(information_id);
                    informationid = informationid + 1;
                    stmt.executeUpdate("INSERT INTO  `clinicaldb`.`patient_information` VALUES (" + informationid + "," + cardnumber + ",  '" + id_number + "',  '" + first_name + "',  '" + midle_name + "',  '" + last_name + "',  '" + age + "',  '" + sex + "',  '" + occupation + "',  '" + religion + "',  '" + address + "','" + ready + "','" + date + "','" + sts + "','" + time + "','no','" + department + "','" + block_number + "','" + dormetry_number + "')");
                   // stmt.executeUpdate("INSERT INTO `clinicaldb`.`schedule` (`schedule_id`, `INFOMATION ID`, `CARD NUMBER`, `ID NUMBER`, `AGE`, `SERVIES`, `DATE`, `STATUES`, `TIME`, `CALLED`, `BLOCK NUMBER`, `DORMITORY NUMBER`) VALUES (" + schedule_ids + ", " + informationid + ", '" + cardnumber + "', '" + id_number + "', '" + age + "', '" + ready + "', '" + date + "', '" + sts + "', '" + time + "', 'no', '" + block_number + "', '" + dormetry_number + "')");
                 stmt.executeUpdate("INSERT INTO `clinicaldb`.`schedule` (`schedule_id`, `INFOMATION_ID`, `CARD_NUMBER`, `ID_NUMBER`, `AGE`, `SERVIES`, `DATE`, `STATUES`, `TIME`, `CALLED`, `BLOCK_NUMBER`, `DORMITORY_NUMBER`) VALUES ("+schedule_ids+", "+informationid+",  '" + cardnumber + "', '" + id_number + "', '" + age + "', '" + ready + "', '" + date + "', '" + sts + "', '" + time + "', 'no', '" + block_number + "', '" + dormetry_number + "')");
                 }
            } else {
                cardnumber = 1000;
                schedule_ids = 1;
                informationid = 1;
                stmt.executeUpdate("INSERT INTO  `clinicaldb`.`patient_information` VALUES (" + informationid + "," + cardnumber + ",  '" + id_number + "',  '" + first_name + "',  '" + midle_name + "',  '" + last_name + "',  '" + age + "',  '" + sex + "',  '" + occupation + "',  '" + religion + "',  '" + address + "','" + ready + "','" + date + "','" + sts + "','" + time + "','no','" + department + "','" + block_number + "','" + dormetry_number + "')");
                //stmt.executeUpdate("INSERT INTO `clinicaldb`.`schedule` (`schedule_id`, `INFOMATION ID`, `CARD NUMBER`, `ID NUMBER`, `AGE`, `SERVIES`, `DATE`, `STATUES`, `TIME`, `CALLED`, `BLOCK NUMBER`, `DORMITORY NUMBER`) VALUES (" + schedule_ids + ", " + informationid + ", '" + cardnumber + "', '" + id_number + "', '" + age + "', '" + ready + "', '" + date + "', '" + sts + "', '" + time + "', 'no', '" + block_number + "', '" + dormetry_number + "')");
            stmt.executeUpdate("INSERT INTO `clinicaldb`.`schedule` (`schedule_id`, `INFOMATION_ID`, `CARD_NUMBER`, `ID_NUMBER`, `AGE`, `SERVIES`, `DATE`, `STATUES`, `TIME`, `CALLED`, `BLOCK_NUMBER`, `DORMITORY_NUMBER`) VALUES ("+schedule_ids+", "+informationid+",  '" + cardnumber + "', '" + id_number + "', '" + age + "', '" + ready + "', '" + date + "', '" + sts + "', '" + time + "', 'no', '" + block_number + "', '" + dormetry_number + "')");
                    
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            // ob=ex;
        } catch (SQLException ex) {
            //   ob=ex;
            Logger.getLogger(Mainclass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String createuser(String member_id, String username, String password, String profession) throws RemoteException {
        // Exception ob=new Exception();

        try {

//                    Class.forName("com.mysql.jdbc.Driver");
//                    String x="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
//                    String y="root";
//                    String z="vertrigo";
//                    Connection  con;
//                    con = DriverManager.getConnection(x, y, z);
//
//                    Statement stmt = con.createStatement();
//                    String ins="select *from `clinicaldb`.`member` where member_id='"+ob.member_id+"'and profession='"+ob.profssion+"'";
//                    ResultSet  r=stmt.executeQuery(ins);
//                    int c=0;
//                    while(r.next())
//                    {
//                        c++;
//                    }
//                    if(c>=1)
//                    {
//                        
//                    }
//              
//                        
//                    else
//                    {
//                        System.out.println("member id or proffession does not exist");
//                    }

            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`member` where member_id='" + member_id + "'and profession='" + profession + "'";
            ResultSet r = stmt.executeQuery(ins);
            int i = 0, j = 0, c = 0;
            while (r.next()) {
                c++;
            }
            if (c >= 1) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String xx = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                    String yy = "root";
                    String zz = "vertrigo";
                    Connection cons;
                    cons = DriverManager.getConnection(xx, yy, zz);

                    Statement stmts = cons.createStatement();
                    stmts.executeUpdate("INSERT INTO `clinicaldb`.`user_account`  VALUES ('" + member_id + "',' " + username + "','" + password + "','" + profession + "')");
                    System.out.println("inserted");
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                    // ob=ex;
                } catch (SQLException ex) {
                    //   ob=ex;
                    Logger.getLogger(Mainclass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//else
//    {
//        System.out.println("member id or proffession does not exist");
//    }
            // System.out.println("inserted");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            // ob=ex;
        } catch (SQLException ex) {
            //   ob=ex;
            Logger.getLogger(Mainclass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public int memberjoin(String id_number, String first_name, String midle_name, String last_name, String age, String sex, String phone_number, String email, String address, String profssion, String date, String time) throws RemoteException {
        int i = 0, cs = 0, c = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();

            String ins = "select *from `clinicaldb`.`member` where member_id='" + id_number + "'";
            ResultSet r = stmt.executeQuery(ins);
            while (r.next()) {
                c++;
            }

            String insss = "select *from `clinicaldb`.`member` where member_id='" + id_number + "' and statues=0";
            ResultSet rss = stmt.executeQuery(insss);
            while (rss.next()) {
                cs++;
            }
            System.out.println(cs);
            if (c < 1) {
                i = 0;
                stmt.executeUpdate("INSERT INTO  `clinicaldb`.`member` VALUES ('" + id_number + "','" + first_name + "',  '" + midle_name + "',  '" + last_name + "',  '" + sex + "',  '" + age + "',  '" + phone_number + "',  '" + email + "',  '" + address + "',  '" + profssion + "',1,  '" + date + "',  '" + time + "')");

                String dx = midle_name;
                int cn = 0;
                String fivith_letter = "";
                int length = dx.length();
                char[] ccx = dx.toCharArray();
                for (int h = 0; h <= 2; h = h + 1) {
                    fivith_letter = fivith_letter + ccx[h];
                }
                int cx = 0;
                midle_name = fivith_letter;
                String user_name = midle_name + "." + first_name + "." + 123;

                String inss = "select *from `clinicaldb`.`user_account` where user_name='" + user_name + "'";
                ResultSet rs = stmt.executeQuery(inss);
                while (rs.next()) {
                    cx++;
                }
                String padding = "1";
                int pad = Integer.parseInt(padding);
                if (cx >= 1) {
                    while (pad <= 10) {
                        padding = String.valueOf(pad);
                        user_name = user_name + padding;
                        String inssss = "select *from `clinicaldb`.`user_account` where user_name='" + user_name + "'";
                        ResultSet rsss = stmt.executeQuery(inssss);
                        int cxs = 0;
                        while (rsss.next()) {
                            cxs++;
                        }
                        if (cxs < 1) {
                            break;
                        }
                        pad++;
                    }
                } else {
                    user_name = user_name;
                }
                String password = "clinical0987";

                String pass = password;
                MessageDigest md = null;
                StringBuilder sb = new StringBuilder();
                try {
                    md = MessageDigest.getInstance("MD5");
                    byte[] passBytes = pass.getBytes();
                    md.reset();
                    byte[] digested = md.digest(passBytes);

                    for (int ii = 0; ii < digested.length; ii++) {
                        sb.append(Integer.toHexString(0xff & digested[ii]));
                    }
                    password = sb.toString();
                } catch (NoSuchAlgorithmException ex) {
                    // Logger.getLogger(CryptWithMD5.class.getName()).log(Level.SEVERE, null, ex);
                }

                stmt.executeUpdate("INSERT INTO  `clinicaldb`.`user_account` VALUES ('" + id_number + "','" + user_name + "',  '" + password + "',  '" + profssion + "',1)");
            } else if (cs >= 1) {
                i = 0;
                String inss = "DELETE FROM `clinicaldb`.`withdraw_member`where id_number='" + id_number + "'";
                stmt.executeUpdate(inss);
                String update = "update `clinicaldb`.`member` SET statues=1,date='" + date + "',time='" + time + "' where member_id='" + id_number + "'";
                stmt.executeUpdate(update);
                String updates = "update `clinicaldb`.`user_account` SET statues=1 where member_id='" + id_number + "'";
                stmt.executeUpdate(updates);
            } else {
                i = 1;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(Mainclass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public String prescription(String block_number, String dorm_number, int presc_id, String id_number, String dates, String drug_name, String dose, int ferquency, String strength, int quantity) throws RemoteException {
        // Exception ob=new Exception();
        String labid = null;
        int c = 0, xy = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();


            String select = "select *from `clinicaldb`.`patient_information` where id_number='" + id_number + "'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                c++;
            }

            if (c >= 1) {

                String inss = "select *from `clinicaldb`.`patient_information` where id_number='" + id_number + "'";
                ResultSet rs = stmt.executeQuery(inss);
                while (rs.next()) {

                    first_name = rs.getString("first_name");
                    last_name = rs.getString("middle_name");
                    card_number = rs.getString("card_number");
                    sex = rs.getString("sex");
                    department = rs.getString("department");
                }
                int cc = 0;
                String selects = "select *from `clinicaldb`.`prescription` ORDER BY prescription_id ASC";
                ResultSet rss = stmt.executeQuery(selects);
                while (rss.next()) {
                    cc++;

                }
                if (cc >= 1) {
                    String insss = "select *from `clinicaldb`.`prescription`  ORDER BY prescription_id ASC";
                    ResultSet rst = stmt.executeQuery(insss);
                    while (rst.next()) {
                        labid = rst.getString("prescription_id");
                    }

                    presc_id = Integer.parseInt(labid);
                    presc_id = presc_id + 1;
                   // stmt.executeUpdate("INSERT INTO `clinicaldb`.`prescription` (`prescription_id`, `id_number`, `card_number`, `first_name`, `last_name`, `sex`, `department`, `block_number`, `dormetery_number`, `prescription_date`, `drug_name`, `dose`, `frequency`, `strength`, `quantity`, `servieces`, `called`) VALUES (" + presc_id + ", '" + id_number + "', '" + card_number + "', '" + first_name + "', '" + last_name + "', '" + sex + "', '" + department + "', '" + block_number + "', '" + dorm_number + "', '" + dates + "', '" + drug_name + "', '" + dose + "', " + ferquency + ", '" + strength + "', " + quantity + ", 'ready', 'no')");
               stmt.executeUpdate("INSERT INTO `clinicaldb`.`prescription` (`prescription_id`, `id_number`, `card_number`, `first_name`, `last_name`, `sex`, `department`, `block_number`, `dormetery_number`, `prescription_date`, `drug_name`, `dose`, `frequency`, `strength`, `quantity`, `servieces`, `called`) VALUES (" + presc_id + ", '" + id_number + "','" + card_number + "', '" + first_name + "',  '" + last_name + "', '" + sex + "',  '" + department + "', '" + block_number + "', '" + dorm_number + "', '" + dates + "', '" + drug_name + "', '" + dose + "', " + ferquency + ", '" + strength + "', " + quantity + ", 'ready', 'no')");
                } else {
                    presc_id = 100;
                    stmt.executeUpdate("INSERT INTO `clinicaldb`.`prescription` (`prescription_id`, `id_number`, `card_number`, `first_name`, `last_name`, `sex`, `department`, `block_number`, `dormetery_number`, `prescription_date`, `drug_name`, `dose`, `frequency`, `strength`, `quantity`, `servieces`, `called`) VALUES (" + presc_id + ", '" + id_number + "','" + card_number + "', '" + first_name + "',  '" + last_name + "', '" + sex + "',  '" + department + "', '" + block_number + "', '" + dorm_number + "', '" + dates + "', '" + drug_name + "', '" + dose + "', " + ferquency + ", '" + strength + "', " + quantity + ", 'ready', 'no')");
               }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            // ob=ex;
        } catch (SQLException ex) {
            //   ob=ex;
            Logger.getLogger(Mainclass.class.getName()).log(Level.SEVERE, null, ex);
        }
        String ccc=String.valueOf(c);
        return ccc;
    }

    public String referral(String doctor_name, String refer_id, String id_number, String dates, String time, String hospital_name, String hpi, String ch, String bp, String pr, String rr, String tm, String diagnosis, String rx_given, String reason_refer) {


        int ci = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();
            int ccc = 0;
            String selects = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "' ORDER BY history_id ASC";
            ResultSet rss = stmt.executeQuery(selects);
            while (rss.next()) {
                ccc++;
            }
            if (ccc >= 1) {
                String selectin = "select *from `clinicaldb`.`patient_history` where id_number='" + id_number + "' ORDER BY history_id ASC";
                ResultSet rst = stmt.executeQuery(selectin);
                while (rst.next()) {
                    id_number = rst.getString("id_number");
                    hpi = rst.getString("history_present_illness");
                    ch = rst.getString("chief_compliant");
                    diagnosis = rst.getString("assasment");
                }

                String ins = "select *from `clinicaldb`.`patient_information` where id_number='" + id_number + "' ORDER BY information_id ASC";
                ResultSet r = stmt.executeQuery(ins);
                int i = 0, j = 0, c = 0;
                while (r.next()) {
                    c++;
                }
                if (c >= 1) {
                    String inss = "select *from `clinicaldb`.`patient_information` where id_number='" + id_number + "' ORDER BY information_id ASC";
                    ResultSet rs = stmt.executeQuery(inss);
                    while (rs.next()) {
                        ci++;
                        first_name = rs.getString("first_name");
                        middle_name = rs.getString("middle_name");
                        last_name = rs.getString("last_name");
                        card_number = rs.getString("card_number");
                        age = rs.getString("age");
                        sex = rs.getString("sex");
                    }
                    int cc = 0;
                    String selectss = "select *from `clinicaldb`.`referral` ORDER BY refer_id ASC";
                    ResultSet rsss = stmt.executeQuery(selectss);
                    while (rsss.next()) {
                        cc++;

                    }

                    if (cc >= 1) {
                        String insssss = "select *from `clinicaldb`.`referral`  ORDER BY refer_id ASC";
                        ResultSet rstss = stmt.executeQuery(insssss);
                        while (rstss.next()) {
                            refer_id = rstss.getString("refer_id");
                        }

                        int presc_id = Integer.parseInt(refer_id);
                        presc_id = presc_id + 1;
                        refer_id = String.valueOf(presc_id);
                    } else {
                        int presc_id = 100;
                        refer_id = String.valueOf(presc_id);
                    }
                    stmt.executeUpdate("INSERT INTO `clinicaldb`.`referral` VALUES ('" + refer_id + "','" + id_number + "', '" + card_number + "','" + first_name + "','" + middle_name + "','" + last_name + "','" + sex + "','" + age + "', '" + dates + "', '" + time + "', '" + hospital_name + "', '" + ch + "', '" + hpi + "', '" + bp + "', '" + pr + "', '" + rr + "', '" + tm + "', '" + diagnosis + "', '" + rx_given + "', '" + reason_refer + "', '" + doctor_name + "')");
                } else {
                    System.out.println("infohere is no like this patient in the database");
                }
            } else {
                System.out.println("histhere is no like this patient in the database");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            // ob=ex;
        } catch (SQLException ex) {
            //   ob=ex;
            Logger.getLogger(Mainclass.class.getName()).log(Level.SEVERE, null, ex);
        }
        String rtype = String.valueOf(ci);
        return rtype;
    }

    public String investigation_record(String dates, String time, String id_number, String history_id, String opo, String lab_id, String reporter_name, String lab_test_result, String remark) {
        int i = 0, j = 0, c = 0;
        System.out.println(c);
        int xy = 0;
        String requist_ids = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String select = "select *from `clinicaldb`.`investigationtbl` where patient_id='" + id_number + "'";
            ResultSet r = stmt.executeQuery(select);
            while (r.next()) {
                c++;
            }

            if (c >= 1) {

                String inss = "select *from `clinicaldb`.`investigationtbl` where patient_id='" + id_number + "'";
                ResultSet rs = stmt.executeQuery(inss);
                while (rs.next()) {

                    first_name = rs.getString("patient_first_name");
                    last_name = rs.getString("patient_last_name");
                    card_number = rs.getString("card_number");
                    sex = rs.getString("sex");
                    history_id = rs.getString("history_id");
                    requist_ids = rs.getString("requist_id");
                }
                int cc = 0;
                String selects = "select *from `clinicaldb`.`investigation_result` ORDER BY lab_id ASC";
                ResultSet rss = stmt.executeQuery(selects);

                while (rss.next()) {
                    cc++;

                }

                if (cc >= 1) {
                    String insss = "select *from `clinicaldb`.`investigation_result`  ORDER BY lab_id ASC";
                    ResultSet rst = stmt.executeQuery(insss);
                    while (rst.next()) {
                        lab_id = rst.getString("lab_id");
                    }

                    xy = Integer.parseInt(lab_id);
                    xy = xy + 1;

                    String name = first_name + " " + last_name;
                    stmt.executeUpdate("INSERT INTO `clinicaldb`.`investigation_result` VALUES (" + xy + ",'" + id_number + "', '" + card_number + "', '" + history_id + "', '" + name + "','" + sex + "', '" + dates + "', '" + time + "', '" + lab_test_result + "', '" + remark + "', '" + reporter_name + "','ready','no')");
                    String update = "update `clinicaldb`.`investigationtbl` SET servieces='served' where requist_id='" + requist_ids + "'";
                    stmt.executeUpdate(update);
                } else {
                    xy = 1000;
                    String name = first_name + " " + last_name;
                    stmt.executeUpdate("INSERT INTO `clinicaldb`.`investigation_result` VALUES (" + xy + ",'" + id_number + "', '" + card_number + "', '" + history_id + "', '" + name + "','" + sex + "', '" + dates + "', '" + time + "', '" + lab_test_result + "', '" + remark + "', '" + reporter_name + "','ready','no')");
                    String update = "update `clinicaldb`.`investigationtbl` SET servieces='served' where requist_id='" + requist_ids + "'";
                    stmt.executeUpdate(update);

                }



            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            // ob=ex;
        } catch (SQLException ex) {
            //   ob=ex;
            Logger.getLogger(Mainclass.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public String investigation_request(String id_numbers, String button_name, String id_number, int history_id, String requested_first_name, String requested_last_name, String opo, String examination_type) {

        String historyid = null;
        String requestid = null;

        String statues = null;
        int req_id = 0, c = 0;
        String reqst_id = null;
        if (button_name.equals("UPDATE")) {


            try {
                Class.forName("com.mysql.jdbc.Driver");
                String w = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String y = "root";
                String z = "vertrigo";
                Connection con;
                con = DriverManager.getConnection(w, y, z);
                Statement stmt = con.createStatement();

                String select = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";
                ResultSet r = stmt.executeQuery(select);

                while (r.next()) {
                    c++;
                }

                if (c >= 1) {
                    id_number = "";//rin.getString("id_number");
                    card_number = "";//rin.getString("card_number");
                    age = "";//rin.getString("age");
                    address = "";//rin.getString("address"); 


                    String selectin = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";
                    ResultSet rin = stmt.executeQuery(selectin);
                    int m = 0;
                    while (rin.next()) {
                        m++;
                    }
                    if (m >= 1) {
                        String selectins = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";
                        ResultSet rins = stmt.executeQuery(selectins);


                        while (rins.next()) {
                            historyid = rins.getString("history_id");
                            id_number = rins.getString("id_number");
                            card_number = rins.getString("card_number");
                            first_name = rins.getString("first_name");
                            last_name = rins.getString("last_name");
                            sex = rins.getString("sex");
                        }

                        history_id = Integer.parseInt(historyid);


                        String selectinss = "select *from `clinicaldb`.`investigationtbl` ORDER BY requist_id ASC";
                        ResultSet rinss = stmt.executeQuery(selectinss);
                        int f = 0;
                        while (rinss.next()) {
                            f++;
                        }
                        if (f >= 1) {
                            String selectreq = "select *from `clinicaldb`.`investigationtbl` ORDER BY requist_id ASC";
                            ResultSet rinsreq = stmt.executeQuery(selectreq);


                            while (rinsreq.next()) {
                                reqst_id = rinsreq.getString("requist_id");
                            }

                            req_id = Integer.parseInt(reqst_id);
                            req_id = req_id + 1;
                        } else {
                            req_id = 100;
                        }
                    } else {
                    }
                    String ins = "select *from `clinicaldb`.`investigationtbl` where patient_id='" + id_numbers + "' ORDER BY requist_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                    ResultSet rs = stmt.executeQuery(ins);
                    int i = 0, j = 0;
                    while (rs.next()) {
                        i++;
                    }

                    if (i >= 1) {

                        String sel = "select *from `clinicaldb`.`investigationtbl` where patient_id='" + id_numbers + "' ORDER BY requist_id ASC";// DESC";// ASC";//and profession='"+ob.profssion+"'";
                        ResultSet sl = stmt.executeQuery(sel);
                        int ii = 0, jj = 0;
                        while (sl.next()) {
                            requestid = sl.getString("requist_id");
                        }
                        String update = "update `clinicaldb`.`investigationtbl` SET REQUESTED_LAST_NAME='" + requested_last_name + "',REQUESTED_FIRST_NAME='" + requested_first_name + "',examination_type='" + examination_type + "',opo='" + opo + "',servieces='ready',called='no',sex='" + sex + "',patient_last_name='" + last_name + "',patient_first_name='" + first_name + "' ,card_number='" + card_number + "' ,history_id='" + historyid + "' where requist_id='" + requestid + "'";//+id+"'";
                        stmt.executeUpdate(update);
                    }
                }
            } catch (Exception e) {
                System.out.println("HelloClient exception:" + e);
            }
        }//close if for update
        else {







            int i = 0, j = 0;
            System.out.println(c);

            try {
                Class.forName("com.mysql.jdbc.Driver");
                String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
                String y = "root";
                String z = "vertrigo";
                Connection con;
                con = DriverManager.getConnection(x, y, z);
                Statement stmt = con.createStatement();
                String select = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";
                ResultSet r = stmt.executeQuery(select);

                while (r.next()) {
                    c++;
                }

                if (c >= 1) {
                    id_number = "";//rin.getString("id_number");
                    card_number = "";//rin.getString("card_number");
                    age = "";//rin.getString("age");
                    address = "";//rin.getString("address"); 


                    String selectin = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";
                    ResultSet rin = stmt.executeQuery(selectin);
                    int m = 0;
                    while (rin.next()) {
                        m++;
                    }
                    if (m >= 1) {
                        String selectins = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";
                        ResultSet rins = stmt.executeQuery(selectins);


                        while (rins.next()) {
                            historyid = rins.getString("history_id");
                            id_number = rins.getString("id_number");
                            card_number = rins.getString("card_number");
                            first_name = rins.getString("first_name");
                            last_name = rins.getString("last_name");
                            sex = rins.getString("sex");
                        }

                        history_id = Integer.parseInt(historyid);


                        String selectinss = "select *from `clinicaldb`.`investigationtbl` ORDER BY requist_id ASC";
                        ResultSet rinss = stmt.executeQuery(selectinss);
                        int f = 0;
                        while (rinss.next()) {
                            f++;
                        }
                        if (f >= 1) {
                            String selectreq = "select *from `clinicaldb`.`investigationtbl` ORDER BY requist_id ASC";
                            ResultSet rinsreq = stmt.executeQuery(selectreq);


                            while (rinsreq.next()) {
                                reqst_id = rinsreq.getString("requist_id");
                            }

                            req_id = Integer.parseInt(reqst_id);
                            req_id = req_id + 1;
                        } else {
                            req_id = 100;
                        }
                        //   stmt.executeUpdate("INSERT INTO  `clinicaldb`.`investigationtbl` VALUES ("+requestid+","+history_id+",'"+id_number+"','"+card_number+"','"+address+"','"+age+"','"+requested_first_name+"','"+requested_last_name+"','"+opo+"','"+examination_type+"')");

                    } else {
                    }

                    stmt.executeUpdate("INSERT INTO `clinicaldb`.`investigationtbl` VALUES ('" + req_id + "','" + id_number + "', " + history_id + ", '" + card_number + "', '" + first_name + "', '" + last_name + "','" + sex + "', '" + requested_first_name + "', '" + requested_last_name + "', '" + opo + "', '" + examination_type + "','ready','no')");

                } else {
                }
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
                // ob=ex;
            } catch (SQLException ex) {
                //   ob=ex;
                Logger.getLogger(Mainclass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String cx = null;
        cx = String.valueOf(req_id);
        return reqst_id;
    }

    public String patient_history(String button_name, Integer history_id, String id_number, String dates, String ch, String hpi, String patient_history, String general_apearance, String vital_sign, String heent, String lgs, String resparatory_system, String cardio_vascular_system, String precordial, String abdomenal_system, String genitouniry_system, String musko_skeletal_system, String integmentary_system, String glascomas_system, String minimental_system, String cranial_nervous_system, String subjective_summry, String objective_summry, String assasment/*,String patient_history,String ch,String hpi*/) {
        String historyid = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String ins = "select *from `clinicaldb`.`patient_information` where id_number='" + id_number + "'";
            ResultSet r = stmt.executeQuery(ins);
            int i = 0, j = 0, c = 0;
            while (r.next()) {
                c++;
            }
            if (c >= 1) {
                String inss = "select *from `clinicaldb`.`patient_information` where id_number='" + id_number + "'";
                ResultSet rs = stmt.executeQuery(inss);
                while (rs.next()) {
                    first_name = rs.getString("first_name");
                    sex = rs.getString("sex");
                    last_name = rs.getString("middle_name");
                    card_number = rs.getString("card_number");
                }
                String selhistory = "select *from `clinicaldb`.`patient_history` ORDER BY history_id ASC";
                ResultSet rshis = stmt.executeQuery(selhistory);
                while (rshis.next()) {
                    historyid = rshis.getString("history_id");
                }
                history_id = Integer.parseInt(historyid);
                history_id = history_id + 1;
                if (button_name.equals("UPDATE")) {
                    history_id = history_id - 1;
                    String updatef = "update `clinicaldb`.`patient_history` SET patient_history='" + patient_history + "',chief_compliant='" + ch + "' ,history_present_illness='" + hpi + "' where history_id=" + history_id;//+id+"'";
                    stmt.executeUpdate(updatef);
//                        String updates = "update `clinicaldb`.`patient_history` SET chief_compliant='"+ch+"'";// where history_id=" + history_id;//+id+"'";
//                    stmt.executeUpdate(updates);
                    String update = "update `clinicaldb`.`patient_information` SET serviceis='served' where card_number='" + card_number + "'";//+id+"'";
                    stmt.executeUpdate(update);
                } else {
                    stmt.executeUpdate("INSERT INTO  `clinicaldb`.`patient_history` VALUES (" + history_id + ",'" + id_number + "','" + card_number + "',  '" + first_name + "',  '" + last_name + "','" + sex + "',  '" + dates + "','" + ch + "','" + hpi + "','" + patient_history + "','" + general_apearance + "','-','-','-','-','-','-','-','-','-','" + lgs + "','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','" + glascomas_system + "','" + minimental_system + "','-','-','-','-','-','-','-','-','-','-','-','-','" + subjective_summry + "','" + objective_summry + "','" + assasment + "')");


                    //    stmt.executeUpdate("INSERT INTO `patient_history` (`history_id`, `id_number`, `card_number`, `first_name`, `last_name`, `sex`, `medication_date`, `chief_compliant`, `history_present_illness`, `patient_history`, `general_apearance`, `blood_presure`, `resparatory_rate`, `pulse_rate`, `temprature`, `head`, `ear`, `eyes`, `nose`, `mouth`, `lympho_glandular_system`, `resparatory_system_inspection`, `resparatory_system_palpotion`, `resparatory_system_percution`, `resparatory_system_auscultation`, `cardio_vascular_system_arteroi`, `cardio_vascular_system_venuos`, `precordial_inspections`, `precordial_palpotions`, `precordial_percutions`, `precordial_auscultations`, `abdomenal_system_inspection`, `abdomenal_system_palpotion`, `abdomenal_system_percution`, `abdomenal_system_auscultation`, `genitouniry_system_inspections`, `genitouniry_system_palpotions`, `genitouniry_system_percutions`, `genitouniry_system_auscultations`, `musko_skeletal_system_inspection`, `musko_skeletal_system_palpotion`, `musko_skeletal_system_percution`, `musko_skeletal_system_auscultation`, `integmentary_system_inspections`, `integmentary_system_palpotions`, `integmentary_system_percutions`, `integmentary_system_auscultations`, `glascomas_system`, `minimental_system`, `cranial_nervous_system_CN1`, `cranial_nervous_system_CN2`, `cranial_nervous_system_CN3`, `cranial_nervous_system_CN4`, `cranial_nervous_system_CN5`, `cranial_nervous_system_CN6`, `cranial_nervous_system_CN7`, `cranial_nervous_system_CN8`, `cranial_nervous_system_CN9`, `cranial_nervous_system_CN10`, `cranial_nervous_system_CN11`, `cranial_nervous_system_CN12`, `subjective_summry`, `objective_summry`, `assasment`) VALUES (" + history_id + ",'" + id_number + "','" + card_number + "',  '" + first_name + "',  '" + last_name + "','" + sex + "',  '" + dates + "','" + ch + "','" + hpi + "','" + patient_history + "', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-')");




                    String update = "update `clinicaldb`.`patient_information` SET serviceis='served' where card_number='" + card_number + "'";//+id+"'";
                    stmt.executeUpdate(update);
                }
            } else {
                System.out.println("no");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            // ob=ex;
        } catch (SQLException ex) {
            //   ob=ex;
            Logger.getLogger(Mainclass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String withdraw(String id_number, String date, String time) {
        String count = null;
        int cs = 0, k = 0;



        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);

            Statement stmt = con.createStatement();

            String sl = "select *from `clinicaldb`.`member` where member_id='" + id_number + "'";
            ResultSet rs = stmt.executeQuery(sl);
            int c = 0;
            while (rs.next()) {
                c++;
            }
            if (c >= 1) {

                String search = "select *from `clinicaldb`.`member` where member_id='" + id_number + "'";
                ResultSet rss = stmt.executeQuery(search);
                while (rss.next()) {
                    first_name = rss.getString("member_first_name");
                    middle_name = rss.getString("member_middle_name");
                    last_name = rss.getString("member_last_name");
                    sex = rss.getString("sex");
                    address = rss.getString("address");
                    profssion = rss.getString("profession");

                }

                String sls = "select *from `clinicaldb`.`withdraw_member` where id_number='" + id_number + "'";
                ResultSet rsss = stmt.executeQuery(sls);

                while (rsss.next()) {
                    cs++;
                }
                if (cs < 1) {
                    k++;
                    stmt.executeUpdate("INSERT INTO  `clinicaldb`.`withdraw_member` VALUES ('" + id_number + "', '" + first_name + "','" + middle_name + "',  '" + last_name + "','" + sex + "','" + address + "','" + profssion + "','" + date + "','" + time + "')");
                    String update = "update `clinicaldb`.`member` SET statues=0 where member_id='" + id_number + "'";
                    stmt.executeUpdate(update);
                    String updates = "update `clinicaldb`.`user_account` SET statues=0 where member_id='" + id_number + "'";
                    stmt.executeUpdate(updates);
                } else {
                    k = 0;
                }
            }
            count = String.valueOf(k);
        } catch (Exception e) {
            System.out.println("HelloClient exception:\n\n" + e + "\n\n");

        }
        return count;

    }

    public String save_sickleave(String sickleave_id, String date, String id_number, String first_name, String middle_name, String sex, String rx_given, String sickleave, String recomendation, String date_issue, String physican_name, String visited_date) {


        int cc = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String x = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
            String y = "root";
            String z = "vertrigo";
            Connection con;
            con = DriverManager.getConnection(x, y, z);
            Statement stmt = con.createStatement();
            String selectss = "select *from `clinicaldb`.`sickleave` ORDER BY sickleave_id ASC";
            ResultSet rsss = stmt.executeQuery(selectss);
            while (rsss.next()) {
                cc++;
            }

            if (cc >= 1) {
                String insssss = "select *from `clinicaldb`.`sickleave`  ORDER BY sickleave_id ASC";
                ResultSet rstss = stmt.executeQuery(insssss);
                while (rstss.next()) {
                    sickleave_id = rstss.getString("sickleave_id");
                }

                int presc_id = Integer.parseInt(sickleave_id);
                presc_id = presc_id + 1;
                sickleave_id = String.valueOf(presc_id);
            } else {
                int presc_id = 100;
                sickleave_id = String.valueOf(presc_id);
            }
            stmt.executeUpdate("INSERT INTO `clinicaldb`.`sickleave` VALUES ('" + sickleave_id + "','" + id_number + "','" + first_name + "','" + middle_name + "','" + sex + "' , '" + rx_given + "', '" + sickleave + "', '" + recomendation + "', '" + date_issue + "', '" + visited_date + "', '" + physican_name + "')");


        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            // ob=ex;
        } catch (SQLException ex) {
            //   ob=ex;
            Logger.getLogger(Mainclass.class.getName()).log(Level.SEVERE, null, ex);
        }
        String rtype = String.valueOf(cc);
        return rtype;

    }
}
