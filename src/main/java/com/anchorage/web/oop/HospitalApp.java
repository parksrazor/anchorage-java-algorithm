package com.anchorage.web.oop;
import lombok.*;

import javax.swing.*;

abstract class HospitalTreatment { protected int treatId, docId, patId;}
@Getter @Setter class HospitalBmi extends HospitalTreatment{ private double kg,cm;}
@Getter @Setter class HospitalMember {
    protected String name,ssn,email,addr,phone;
    protected int uid;
}
@Getter @Setter class HospitalDoctor extends HospitalMember{
    private String docPosition,majorTreat;
    @Override
    public String toString() {
        return String.format(
                "의사ID: %s\n"
                        + "담당진료과목: %s\n"
                        + "성명: %s\n"
                        + "성별: %s\n"
                        + "전화번호: %s\n"
                        + "이메일: %s\n"
                        + "직급: %s\n",
                "");
    }
}
@Getter @Setter class HospitalNurse extends HospitalMember{
    private String nurPosition,majorJob;
    @Override
    public String toString() {
        return String.format(
                "간호사ID: %s\n"
                        + "담당진료과목: %s\n"
                        + "성명: %s\n"
                        + "성별: %s\n"
                        + "전화번호: %s\n"
                        + "이메일: %s\n"
                        + "직급: %s\n",
                "");
    }
}
@Getter @Setter class HospitalPatient extends HospitalMember{
    private String patJob;
    @Override
    public String toString() {
        return String.format(
                "환자ID: %s\n"
                        + "간호사ID: %s\n"
                        + "의사ID: %s\n"
                        + "환자성명: %s\n"
                        + "환자성별: %s\n"
                        + "주민번호(800101-1): %s\n"
                        + "주소: %s\n"
                        + "전화번호: %s\n"
                        + "이메일: %s\n"
                        + "직업: %s\n",
                "");
    }
}
class HospitalController {
    public final static String EXE_OPTION=
            "0.EXIT"
                    + "1.REG-DOCTOR\n"
                    + "2.REG-NURSE\n"
                    + "3.REG-PATIENT\n"
                    + "4.CHECK BMI\n";
    public final static String DOC_SPEC=
            "INPUT AS 의사ID,담당진료과목,성명,SSN,전화번호,이메일직급";
    public void start() {
        while (true) {
            switch (JOptionPane.showInputDialog(EXE_OPTION)) {
                case "0":return;
                case "1":
                    HospitalDoctor doc = new HospitalDoctor();
                    String docInfo = JOptionPane.showInputDialog(DOC_SPEC);
                    String[] docInfoArr = docInfo.split(",");
                    doc.setUid(Integer.parseInt(docInfoArr[0]));
                    doc.setMajorTreat(docInfoArr[1]);
                    doc.setName(docInfoArr[2]);
                    // .....
                    JOptionPane.showMessageDialog(null, doc.toString());
                    break;
                case "2":
                    HospitalNurse nur = new HospitalNurse();

                    break;
                case "3":
                    HospitalPatient pat = new HospitalPatient();

                    break;
                case "4":
                    HospitalBmi bmi = new HospitalBmi();
                    bmi.setCm(Double.parseDouble(JOptionPane.showInputDialog("What Height?"))/100);
                    bmi.setKg(Double.parseDouble(JOptionPane.showInputDialog("What Weight?")));
                    JOptionPane.showMessageDialog(null, "");
                    break;
            }

        }
    }
}
class HospitalIndex {
    public static void main(String[] args) {
        new HospitalController().start();
    }
}