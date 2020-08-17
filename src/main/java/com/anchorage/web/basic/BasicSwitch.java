package com.anchorage.web.basic;

import java.util.Scanner;
class BasicSwitchMain {
    public static void main(String[] args) {
        BasicSwitchBmi.main();
        BasicSwitchCalculator.main();
        BasicSwitchSsn.main();
        BasicSwitchMonth.main();
        BasicSwitchNaiveLotto.main();
    }
}
class BasicSwitchCalculator {
    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("- 오칙연산 계산기 -");
        System.out.println("숫자와 연산 부호를 입력하세요.");

        int a = scan.nextInt();
        String op = scan.next();
        int b = scan.nextInt();

        int res = 0;

        switch(op){
            case "+" : res = a + b;
                break;

            case "-" : res = a - b;
                break;

            case "*"  : res = a * b;
                break;

            case "/" : res = a / b;
                break;

            case "%" : res = a % b;
                break;

            default : res = a + b;
                break;
        }
        System.out.printf("%d %s %d = %d",a,op,b, res);
    }
}

class BasicSwitchBmi {
    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("나이: ");
        int age = scan.nextInt();
        if(age < 2){
            System.out.println("BMI지수의 참고지 정보는 2세 이상부터 제공됩니다. "
                    + "정확한 정보를 입력하세요");
            return;
        }
        System.out.println("Weight: ");
        double kg = scan.nextDouble();
        System.out.println("Height: ");
        double cm = scan.nextDouble() / 100;
        double bmi = kg / (cm * cm);
        System.out.println("BMI: " + bmi);
        String result = "";
        if (bmi > 30.0) {
            result = "고도비만";
        } else if (bmi > 25.0) {
            result = "비만";
        } else if (bmi > 23.0) {
            result = "과체중";
        } else if (bmi > 18.5) {
            result = "정상";
        } else {
            result = "저체중";
        }
        System.out.println(result);
    }

}
class BasicSwitchSsn {
    /*
       * 주민번호를 입력하면 해당 학생이 남자인지, 여자인지, 외국인인지 자동 으로 출력해 주는 프로그램.
       * 다음과 같이 화면에 출력.
       * 홍길동 : 800101 -1234567 : 남
       * 입력값은 이름과 주민번호이고 남은 자동으로 출력되는 값입니다.
       * 현행법상 1, 3으로 시작되면 남자, 2, 4로 시작되면 여자, 5,6 이면 외국인
       * 사용자가 실수로 0,7,8,9 로 시작 주민번호를 입력하면 "다시 입력하세요" 출력됨.
       성별 String gender = "";
       주민등록번호 800101-1234567 에서 1 을 추출하는 문법
       String ssn = "800101-1234567";
       char ch = ssn.charAt(7); 하면 1 이 추출되어 ch 에 담긴다.
       그러면 내부값은 '1' 이렇게 된다
       if(ch=='0'||ch=='7'||ch=='8'||ch=='9'){...}
 * */
    static void main(){
        Scanner s = new Scanner(System.in);
        System.out.println("주민등록번호를 입력하세요.");
        String ssn=s.next();
        char ch = ssn.charAt(7);
        String gender = "";
        switch (ch) {
            case '1':case '3':
                gender="남자";break;
            case '2':case '4':
                gender="여자";break;
            case '5':case '6':
                gender="외국인";break;
            default:
                System.out.println("다시 입력해주세요.");
                return;
        }
        System.out.println(gender);

    }
}
class BasicSwitchMonth{
    /**
     [1]연도를 4로 나눈값이 0 이고,
     해당 연수가 100으로 나누어 떨어지지 않으면 윤년이다.
     [2]연도를 4로 나눈값이 0 이고,
     해당 연수가 100으로 나누어 떨어지는데,
     400으로 나눠 떨어지면 윤년
     */
    public static void main() {
        Scanner s = new Scanner(System.in);
        System.out.println("Year:");
        int year=s.nextInt();
        System.out.println("Month:");
        int month=s.nextInt();
        int day=0;
        switch(month){
            case 1:case 3:case 5:case 7:case 8:case 10:case 12:
                day=31;break;
            case 4:case 6:case 9:case 11:
                day=30;break;
            case 2:
                if(year%4==0 && year%100!=0) {
                    day=29;
                } else if(year%4==0 && year%100==0 && year%400==0) {
                    day=29;
                } else {
                    day=28;
                }
                break;
            default:System.out.println("Wrong Month");return;
        }
        System.out.println(year+"-"+month+"-"+day);
    }
}
class BasicSwitchNaiveLotto {
    /*
    로또볼 추첨
    1~45 까지 랜덤숫자
    볼갯수는 총 6개
    중복 불허
    출력은 [5,23,23,40,19,22]
     * */
    public static void main() {
        int lottoNum = 0, count = 0;
        int ball1 = 0, ball2 = 0, ball3 = 0, ball4 = 0, ball5 = 0, ball6 = 0;
        while (count < 6) {
            lottoNum = (int) (Math.random() * 45 + 1);
            count++;
            switch (count) {
                case 1:
                    ball1 = lottoNum;
                    break;
                case 2:
                    count=(lottoNum == ball1)?count--:count;
                    ball2 = lottoNum;
                    break;
                case 3:
                    ball3 = lottoNum;
                    count=(lottoNum == ball2 || lottoNum == ball1)?count--:count;
                    break;
                case 4:
                    count=(lottoNum == ball3 || lottoNum == ball2 || lottoNum == ball1)?count--:count;
                    ball4 = lottoNum;
                    break;
                case 5:
                    count=(lottoNum == ball4 || lottoNum == ball3 || lottoNum == ball2 || lottoNum == ball1)?count--:count;

                    ball5 = lottoNum;
                    break;
                case 6:
                    count=(lottoNum == ball5 || lottoNum == ball4 || lottoNum == ball3 || lottoNum == ball2|| lottoNum == ball1)?count--:count;
                    ball6 = lottoNum;
                    break;
            }
        }
        System.out.printf("[%d %d %d %d %d %d]", ball1, ball2, ball3, ball4, ball5, ball6);
    }
}
