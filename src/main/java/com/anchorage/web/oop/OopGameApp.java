package com.anchorage.web.oop;
import lombok.*;
import java.util.Random;
import java.util.Scanner;
class OopGame {

}
class Constants {
    public final static String MENU= "0.종료\t 1.집전화입력\t 2.집전화출력"
            + "\t 3.휴대전화입력\t 4.휴대전화출력\t 5.아이폰입력\t 6.아이폰출력 \t "
            + "7.갤럭시입력\t 8.갤럭시출력";
    public final static String PHONE_MENU="입력: phoneNumber, name, company";
    public final static String CELPHONE_MENU="입력: phoneNumber, name, company";
    public final static String IPHONE_MENU="입력: phoneNumber, name, company, search";
    public final static String GALAXY_NOTE_MENU="입력: phoneNumber, name, company, search, bigsize";
    public final static String GRADE_MENU="0. 종료 1.성적표입력 2. 성적표출력";
    public final static String GRADE_INPUT="이름,국어,영어,수학  입력";


}
@Getter @Setter class OopGameMember {
    private String userid,passwd,name,ssn, addr;
}
class OopGameMemberGenderChecker {

}
@Getter @Setter class OopGameCalculator {
    private int num1;
    private int num2;

    public int calculate() {
        int c = num1 + num2;
        return c;
    }
}
@Getter @Setter class OopGameKaup  extends OopGame{
    /*
    체중 (kg)÷키²(㎡)
    저체중
    <18.5
    정상체중
    18.5∼22.9
    과체중
    ≥23.0
    위험체중
    23.0∼24.9
    비만 1단계(obese class I)
    25.0∼29.9
    비만 2단계(obese class II)
    > 30
    비만 3단계(obese class III)
    ≥ 40.0

     * */
    private double weight;
    private double height;

    public String calculate() {
        String result = "";
        double kaupIndex = weight / (height * height);
        System.out.println("카우푸지수 : "+kaupIndex);
        if(kaupIndex < 18.5) {
            result = "저체중";
        }else if(kaupIndex < 23.0) {
            result = "정상체중";
        }else if(kaupIndex < 25.0) {
            result = "과체중";
        }else if(kaupIndex < 25.0) {
            result = "위험체중";
        }else if(kaupIndex < 30.0) {
            result = "비만 1단계";
        }else if(kaupIndex < 40.0) {
            result = "비만 2단계";
        }else {
            result = "비만 3단계";
        }

        return result;
    }


}
@Getter @Setter class OopGameDice extends OopGame{
    private String expect;
    private int diceNumber;

    public String switchDice() {
        String result = "";
        switch(diceNumber) {
            case 1:case 3:case 5: result = "홀"; break;
            case 2:case 4:case 6: result = "짝"; break;
        }
        String result2 = "틀림";
        if(expect.equals(result)){
            result2 = "맞음";
        }
        System.out.println(String.format("결과: %s", result2));
        return result2;
    }


    public void ifDice() {
        System.out.println("*** 주사위 홀짝 맞추기 게임 ***");
        System.out.println("기대하는 값 홀/짝 을 입력해 주세요");
        Scanner scanner = new Scanner(System.in);
        String expect = scanner.next();
        System.out.println("사용자 홀짝 예상값 :" + expect);
        Random random = new Random();
        int dice = random.nextInt(6)+1;
        System.out.println("컴퓨터가 생성한 값 :" + dice);
        String result = "";
        if(dice == 1) {
            result = "홀";
        }else if(dice == 2) {
            result = "짝";
        }else if(dice == 3) {
            result = "홀";
        }else if(dice == 4) {
            result = "짝";
        }else if(dice == 5) {
            result = "홀";
        }else {
            result = "짝";
        }
        System.out.println("컴퓨터 홀짝 결과: "+result);
        if(expect.equals(result)) { // object type 의 operation 은 method로 처리한다.
            System.out.println("매칭 결과: 맞음");
        }else {
            System.out.println("매칭 결과: 틀림");
        }
    }
}
@Getter @Setter class OopGameRPS extends OopGame{
    private int userValue;
    private int computerValue;

    public String game() {
        String result = "";
        if (userValue == 1) {
            if (computerValue == 1) {
                result = "비김";
            } else if (computerValue == 2) {
                result = "컴퓨터 승리";
            } else if (computerValue == 3) {
                result = "사용자 승리";
            }
        } else if (userValue == 2) {
            if (computerValue == 2) {
                result = "비김";
            } else if (computerValue == 1) {
                result = "사용자 승리";
            } else if (computerValue == 3) {
                result = "컴퓨터 승리";
            }
        } else if (userValue == 3) {
            if (computerValue == 3) {
                result = "비김";
            } else if (computerValue == 1) {
                result = "컴퓨터 승리";
            } else if (computerValue == 2) {
                result = "사용자 승리";
            }
        }
        return result;
    }


}
interface OopGameService {
    void add(OopGame game);
    OopGame[] list();
    OopGame detail(OopGame game);
    int count();
    void update(OopGame game);
    void delete(OopGame game);
    void genderChecker();
}
class OopGameServiceImpl implements OopGameService{
    @Override
    public void add(OopGame game) {

    }

    @Override
    public OopGame[] list() {
        return new OopGame[0];
    }

    @Override
    public OopGame detail(OopGame game) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void update(OopGame game) {

    }

    @Override
    public void delete(OopGame game) {

    }

    @Override public void genderChecker() {
        System.out.println("주민번호를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        String ssn = scanner.next();
        System.out.println(ssn);
        char ch = ssn.charAt(7);
        String result = "";
        switch(ch) {
            case '1':case '3': result = "남성"; break;
            case '2':case '4': result = "여성"; break;
            case '5':case '6': result = "외국인"; break;
            default: result = "외국인"; break;
        }
        System.out.println(result);
    }
}
class OopGameController {
    private String  test;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        OopGameMember member = new OopGameMember();
        OopGameCalculator calculator = null;
        OopGameDice dice = null;
        OopGameRPS rpsGame = null;
        OopGameKaup kaup = null;
        while (true) {
            System.out.println(
                    "0. 종료 " + "1. 회원가입 " + "2. 로그인 " + "3. 계산기 " + "5. 주사위 홀짝 맞추기 "
                            + "6. 카우푸지수" + "4. 가위바위보"
                            + "");
            int flag = scanner.nextInt();
            switch (flag) {
                case 0:
                    System.out.println("종료");
                    return;
                case 1:
                    System.out.println("회원가입");
                    System.out.println("아이디 입력");
                    String userid = scanner.next();
                    member.setUserid(userid);

                    break;
                case 2:
                    System.out.println("로그인");
                    System.out.println("아이디 입력");
                    String id2 = scanner.next();
                    String returnId = member.getUserid();
                    System.out.println("로그인된 아이디: " + returnId);
                    if (id2.equals(returnId)) {
                        System.out.println("로그인 성공");
                    } else {
                        System.out.println("로그인 실패");
                    }
                    break;
                case 3:
                    calculator = new OopGameCalculator();
                    System.out.println("계산기");
                    System.out.println("첫번째 수 입력");
                    int a = scanner.nextInt();
                    calculator.setNum1(a);
                    System.out.println("두번째 수 입력");
                    int b = scanner.nextInt();
                    calculator.setNum2(b);
                    int c = calculator.calculate();
                    System.out.println("두수의 합" + c);
                    break;
                case 4:
                    rpsGame= new OopGameRPS();
                    System.out.println("**가위바위보 게임**");
                    System.out.println("가위1, 바위2, 보 3 을 입력하세요");
                    int user = scanner.nextInt();
                    System.out.println("사용자가 입력한 값:" + user);
                    rpsGame.setUserValue(user);

                    int com = random.nextInt(3) + 1;
                    System.out.println("컴퓨터가 입력한 값:" + com);
                    rpsGame.setComputerValue(com);
                    String gameResult = rpsGame.game();
                    System.out.println(gameResult);
                    break;
                case 5:
                    dice = new OopGameDice();
                    System.out.println("주사위 홀짝 맞추기 게임");
                    System.out.println("기대하는 값 홀/짝 을 입력해 주세요");
                    String expect = scanner.next();
                    System.out.println(String.format("사용자가 입력한 값: %s ", expect));
                    dice.setExpect(expect);
                    int diceNumber = random.nextInt(4);
                    System.out.println(String.format("컴퓨터가 생성한 값: %d", diceNumber));
                    dice.setDiceNumber(diceNumber);
                    System.out.println(dice.switchDice());
                    break;
                case 6:
                    kaup = new OopGameKaup();
                    System.out.println("키 ?");
                    new OopGameKaup().setHeight(scanner.nextDouble());
                    System.out.println("몸무게 ?");
                    kaup.setWeight(scanner.nextDouble());
                    System.out.println(kaup.calculate());
                    break;
            }

        }
    }

}



