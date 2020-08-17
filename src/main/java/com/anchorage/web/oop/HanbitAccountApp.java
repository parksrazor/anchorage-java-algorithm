package com.anchorage.web.oop;
import lombok.*;

import javax.swing.*;
import java.util.Calendar;
import java.util.Scanner;

class RandomGenerator {
    public static int getRandomNum(int a, int b){
        return (a>b)?(int)(Math.random()*(a-b+1)+b):(int)(Math.random()*(b-a+1)+a);
    }
}
@Getter @Setter abstract class HanbitAccount {
    final static String BANK_NAME="한빛뱅크";
    final static String ACCOUNT_TYPE="통장 베이스";
    final static String WITHDRAW_SUCCESS="출금성공";
    final static String WITHDRAW_FAIL="잔액부족";
    final static String DEPOSIT_SUCCESS="입금성공";
    final static String DEPOSIT_FAIL="적합한 입력값이 아님";
    protected int money,accountNo;
    protected String uid,accountType,createDate;
    public HanbitAccount() {}
    public HanbitAccount(String uid, String accountType,int money){ // 6자리 램덤숫자
        this.accountNo = RandomGenerator.getRandomNum(100000, 999999);
        this.createDate = Calendar.getInstance().get(Calendar.YEAR) +"년 "
                +Calendar.getInstance().get(Calendar.MONTH)+1 +" 월 "
                +Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+" 일"; //
        this.uid = uid;
        this.accountType = accountType;
        this.money = money;
    }
    abstract boolean checkMoney(int money);
    abstract String deposit(int money);
    abstract String withdraw(int money);

}

class HanbitAccountWage extends HanbitAccount{
    public HanbitAccountWage(String uid, String accountType,int money){ // 6자리 램덤숫자
        accountNo = RandomGenerator.getRandomNum(100000, 999999);
        createDate = Calendar.getInstance().get(Calendar.YEAR) +"년 "
                +Calendar.getInstance().get(Calendar.MONTH)+1 +" 월 "
                +Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+" 일"; //
        super.uid = uid;
        super.accountType = accountType;
        super.money = money;
    }

    @Override
    public String deposit(int money) {
        String result = "";
        if(checkMoney(money)){
            this.money += money;
            result = HanbitAccount.DEPOSIT_SUCCESS;
        }else{
            money=this.money;
            result = HanbitAccount.DEPOSIT_FAIL;
        }
        return result;
    }

    @Override
    public String withdraw(int money) {
        String result = "";
        if(checkMoney(this.money-money)){
            this.money -= money;
            result=HanbitAccount.WITHDRAW_SUCCESS;
        }else{
            money = this.money;
            result=HanbitAccount.DEPOSIT_FAIL;
        }
        return result;
    }

    @Override
    public boolean checkMoney(int money) {
        return money>=0;
    }
}
@Getter @Setter class HanbitMember {
    private String uid,name,ssn;

    public String calcGender(String ssn){
        char ch = ssn.charAt(7);
        String gender = "";
        if (ch == '1' || ch == '3') {
            gender= "남자";
        } else if (ch == '2' || ch == '4') {
            gender = "여자";
        } else {
            gender = "외국인";
        }
        return gender;
    }
}
class HanbitAccountController {

    public void start() {
        Scanner s = new Scanner(System.in);
        HanbitMember member = null;
        HanbitAccount account = null;
        String ssn = "";
        while (true) {
            /*
             * int opt = Integer.parseInt(option); String opt2 =
             * String.valueOf(opt);
             */
            switch (JOptionPane.showInputDialog("0.종료 1.회원등록 2.통장개설 3.입금 4.출금 5.조회 6.해지")) {
                case "0":
                    return;
                case "1":
                    member = new HanbitMember();
                    while (true) {
                        ssn = JOptionPane.showInputDialog("주민번호앞자리(800101-1)");
                        char ch = ssn.charAt(7);
                        if (ch == '0' || ch == '7' || ch == '8' || ch == '9') {
                            JOptionPane.showMessageDialog(null, "다시 입력하세요");
                        } else {
                            break;
                        }
                    }
                    member.setSsn(ssn);
                    member.setUid(JOptionPane.showInputDialog("아이디"));
                    member.setName(JOptionPane.showInputDialog("이름"));
                    JOptionPane.showMessageDialog(null, member.getName() + "님 회원등록 되었습니다.");
                    break;
                case "2":
                    String uid = "";
                    int money = 0;
                    String accountType = "저축예금";
                    account = new HanbitAccountWage(uid, accountType, money);
                    /*
                     * [한빛뱅크] 계좌번호: 123456 예금종류: 저축예금 송상훈님 가입일:2016년12월14일 잔액: ￦ 0
                     */
                    StringBuffer sb = new StringBuffer();
                    sb.append("[" + HanbitAccount.BANK_NAME + "]\n");
                    sb.append("계좌번호: " + account.getAccountNo());
                    sb.append("예금종류: " + account.getAccountType());
                    /* sb.append("가입일: " + account.getCreatDate()); */
                    sb.append("잔액: " + account.getMoney());
                    System.out.println(sb.toString());

                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, account.deposit(Integer.parseInt(JOptionPane.showInputDialog("얼마를 입금하시겠습니까?"))));
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null,
                            account.withdraw(Integer.parseInt(
                                    JOptionPane.showInputDialog("출금할 금액을 입력해주세요."))));
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "잔액은"+account.getMoney()+"입니다.");
                    break;
                case "6":
                    break;
            }
        }
    }

}