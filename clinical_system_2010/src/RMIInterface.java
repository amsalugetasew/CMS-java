
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public interface RMIInterface extends Remote {

    public String[] view_pat_schedules(String reptyp1, int arraysize, String report_type, String sex) throws RemoteException;

    public int view_pat_schedule(String rptyp1, String report_type, String sex) throws RemoteException;

    public int view_pat_informationcount(String reptyp, String reptyp1, String sex) throws RemoteException;

    public int forgot_password(String member_id, String user_name, String profession, String new_password) throws RemoteException;

    public int change_password(String member_id, String user_name, String old_password, String profession, String new_password) throws RemoteException;

    public int calling_prescription_count() throws RemoteException;

    public int calling_lab_result_count(String btn_name) throws RemoteException;

    public int calling_for_drug_pro_info_count(String btn_name) throws RemoteException;

    public int drug_pro_info(String id_number) throws RemoteException;

    public String[] print_sickleaves(String id_number) throws RemoteException;

    public String save_sickleave(String sickleave_id, String x, String id_number, String first_name, String middle_name, String sex, String rx_given, String sickleave, String recomendation, String date_issue, String physican_name, String visited_date) throws RemoteException;

    public String[] print_sickleave(String id_number, String visited_date) throws RemoteException;

    public int view_pat_historys(String reptyp, String sex) throws RemoteException;

    public String[] view_refers(String id_number,String date) throws RemoteException;

    public String[] print_refer(String id_number) throws RemoteException;
    //public String[] Search_for_Update_examination(String infoid) throws RemoteException;

    public String[] view_lab_result(String reptyp, String sex) throws RemoteException;

    public String[] Search_for_Update_examination1(String history_id) throws RemoteException;

    public String[] Update_examination1(String id_number) throws RemoteException;

    public String[] Update_examination1() throws RemoteException;

    public String[] update_patient_information(String department, String bloclk_number, String dorm_number, String infoid, String id_number, String first_name, String middle_name, String last_name, String age, String sex, String occupation, String religion, String address, String statue) throws RemoteException;

    public String[] search_patient_info(String id_number) throws RemoteException;

    public String[] update_drug_pro_info(int proid, String id_numeber, String drugname, String strength, String dose, String unit, int quantity, String unitcost, String comment) throws RemoteException;

    public String[] search_for_drug_pro_info(String id_numeber) throws RemoteException;

    public String[] view_drug_pro_info(String reptyp, String sex) throws RemoteException;

    public String[] view_prescription(String reporttyp, String sex) throws RemoteException;

    public String[] view_lab_result() throws RemoteException;

    public String[] view_pat_history(String reptyp, String sex) throws RemoteException;

    public String[] calling_for_drug_pro_info(String room_number, String btn_name) throws RemoteException;

    public String drug_pro_info(String responsible_person, String professin, String id_number, String age, String drugname, String strength, String dose, String unit, String quantity, String unitcost, String comment) throws RemoteException;

    public String existing_patient_info(String id_number, String date, String time, String statues, String ready, String age, String block_number, String dormetery_number) throws RemoteException;

    public String[] view_pat_information(int arraysize, String reptyp, String reptyp1, String sex) throws RemoteException;

    public String[] view_member(String reptyp, String sex) throws RemoteException;

    public String[] calling_for_history(String room_number, String btn_name) throws RemoteException;

    public int call_pat_for_history(String btn_name) throws RemoteException;

    public String[] calling_for_prescription(String room_num) throws RemoteException;

    public String[] Update_investigation(String id_number) throws RemoteException;

    public String SUMMERY(String id_number, String button_name, String subjective_summry, String objective_summry, String assasment) throws RemoteException;

    public String[] calling(int arraysize, String btn_name, String room_number) throws RemoteException;

    public int viewhistories(String id_number) throws RemoteException;

    public String[] view_histories(String id_number) throws RemoteException;

    public String examination4(String id_number, String button_name, String glascomas_system, String minimental_system, String CN1, String CN2, String CN3, String CN4, String CN5, String CN6, String CN7, String CN8, String CN9, String CN10, String CN11, String CN12) throws RemoteException;

    public String examination4(String id_number, String button_name, String inspection, String palpotion, String percution, String auscultation, String inspections, String palpotions, String percutions, String auscultations) throws RemoteException;

    public String examination3(String id_number, String button_name, String inspection, String palpotion, String percution, String auscultation, String inspections, String palpotions, String percutions, String auscultations) throws RemoteException;

    public String examination2(String id_number, String button_name, String arteroi, String venuos, String lgss, String inspection, String palpotion, String percution, String auscultation, String inspections, String palpotions, String percutions, String auscultations) throws RemoteException;

    public ArrayList findAll() throws RemoteException;

    public String investigation_record(String dates, String time, String id_number, String history_id, String opo, String lab_id, String reporter_name, String lab_test_result, String remark) throws RemoteException;

    public String examination1(String Id_for_search, String button_name, String gap, String vital_sign, String blood_presure, String resparatory_rate, String pulse_rate, String head, String ear, String eyes, String nose, String mouth) throws RemoteException;

    public String[] login(String user_name, String Password) throws RemoteException;

    public String patient_history(String button_name, Integer history_id, String id_number,/*String card_number,String first_name,String last_name,*/ String dates, String ch, String hpi, String patient_history, String general_apearance, String vital_sign, String heent, String lgs, String resparatory_system, String cardio_vascular_system, String precordial, String abdomenal_system, String genitouniry_system, String musko_skeletal_system, String integmentary_system, String glascomas_system, String minimental_system, String cranial_nervous_system, String subjective_summry, String objective_summry, String assasment/*,String patient_history,String ch,String hpi*/) throws RemoteException;

    public String referral(String doctor_name, String refer_id, String id_number, String dates, String time, String hospital_name,/*ob.first_name,ob.middle_name,ob.last_name,String age,String sex,String id_number,*/ String ch, String hpi, String bp, String pr, String rr, String tm, String diagnosis, String rx_given, String reason_refer) throws RemoteException;

    public String investigation_request(String id_numbers, String button_name, String id_number, int history_id, String requested_first_name, String requested_last_name, String opo, String examination_type/*,String age,String dates/*,String address,String opo,String requested_first_name,String requested_last_name,String card_number,String id_number,String time,String history_id,String stool_examination*/) throws RemoteException;

    public String patient_information(String card_number, String id_number, String first_name, String midle_name, String last_name, String age, String sex, String occupation, String religion, String address, String ready, String date, String sts, String time, String department, String block_number, String dormetry_number) throws RemoteException;

    public String createuser(String member_id, String username, String password, String profession) throws RemoteException;

    public int memberjoin(String id_number, String first_name, String midle_name, String last_name, String age, String sex, String phone_number, String email, String address, String profssion, String date, String time) throws RemoteException;

    public String prescription(String block_number, String dorm_number, int presc_id, String id_number, String dates, String drug_name, String dose, int ferquency, String strength, int quantity) throws RemoteException;

    public String withdraw(String id_number, String date, String time) throws RemoteException;
}
