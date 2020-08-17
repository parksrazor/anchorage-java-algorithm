package com.anchorage.web.basic;

import java.util.Scanner;
class BasicIfelseMain{
    public static void main(String[] args) {
        BasicIfelseTax.main();
        BasicIfelseLeapYear.main();
        BasicIfelseReportCard.main();
        BasicTopScoreAndBottomNavie.main();
    }
}
class BasicIfelseTax {

    /**
     * 클라이언트에서 프로그램 개발 요청이 왔습니다.
     * 이름과 연봉을 입력받아서
     * 연봉 ***만원을 받으시는 XXX님께서 납부할
     * 세금은 ???만원입니다.
     * 로 출력하는 프로그램을 만들어 주세요.
     * 현재는 세율이 9.7프로인데, 만약 세율이 바뀌면
     * 바뀐 세율을 적용바랍니다.
     */
    static void main() {
        Scanner scanner = new Scanner(System.in);
        int sal=0,change=0,tax=0;
        double taxRate = 0.0;
        System.out.println("이름을 입력하세요");
        String name = scanner.next();
        System.out.println("연봉을 입력하세요");
        sal = scanner.nextInt();
        System.out.println("세율이 바뀌었습니까?"
                + "그대로이면 1, 바뀌었으면 2 를 입력하세요");
        change = scanner.nextInt();
        if (change==1) {
            taxRate = 0.097;
        } else {
            System.out.println("그럼, 바뀐세율을 입력바랍니다");
            taxRate = scanner.nextDouble();
        }
        tax = (int) (sal * taxRate);
        System.out.println("연봉 "+sal+"만원을 받으시는 "
                +name+"님께서 "
                +"납부할 세금은 "+tax+"만원입니다.");
    }

}
class BasicTopScoreAndBottomNavie {
    /**
     * 저희 반은 학생수가 3명입니다.
     * 학생의 평균점수는 0~100점사이입니다.
     * 3명의 평균점수를 입력하면
     * 1등 홍길동
     * 2등 김유신
     * 3등 김구
     * 이렇게 나오도록 해주세요.동점은 없습니다.
     * 단, 학생이름은 스캐너로 입력받습니다.
     * 홍길동
     * 49
     * 김유신
     * 78
     * 김구
     * 96
     * ==============
     * 1등 김구 96점
     * 2등 김유신 78점
     * 3등 홍길동 49점
     * ==============
     * */
    static void main() {
        Scanner scanner = new Scanner(System.in);
        int avg=0,avg1=0 , avg2=0 , avg3 =0, gradeA1=0,gradeA2=0,gradeA3=0;
        String name="", name1="",name2="",name3="",grade1="",grade3="",grade2="";

        System.out.println("이름,점수 입력");
        name1=scanner.next();
        avg1 =scanner.nextInt();
        System.out.println("이름,점수 입력");
        name2=scanner.next();
        avg2 = scanner.nextInt();
        System.out.println("이름,점수 입력");
        name3=scanner.next();
        avg3 = scanner.nextInt();

        if (avg1>avg2&&avg1>avg3) {
            grade1=name1;
            gradeA1=avg1;
            if (avg2>avg3) {
                grade2=name2;
                gradeA2=avg2;
                grade3=name3;
                gradeA3=avg3;
            } else {
                grade2=name3;
                gradeA2=avg3;
                grade3=name2;
                gradeA3=avg2;
            }
        } else if(avg2>avg3){
            grade1=name2;
            gradeA1=avg2;
            if (avg1>avg3) {
                grade2=name1;
                gradeA2=avg1;
                grade3=name3;
                gradeA3=avg3;
            } else {
                grade2=name3;
                gradeA2=avg3;
                grade3=name1;
                gradeA3=avg1;
            }
        }else {
            grade1=name3;
            gradeA1=avg3;
            if (avg1>avg2) {
                grade2=name1;
                gradeA2=avg1;
                grade3=name2;
                gradeA3=avg2;
            } else {
                grade2=name2;
                gradeA2=avg2;
                grade3=name1;
                gradeA3=avg1;
            }
        }


        System.out.printf("1등 : %s 점수는 %d \n",grade1,gradeA1 );
        System.out.printf("2등 : %s 점수는 %d \n",grade2,gradeA2 );
        System.out.printf("3등 : %s 점수는 %d \n",grade3,gradeA3 );

    }
}
class BasicIfelseLeapYear {
    /**
     연도를 4로 나눈값이 0 이라면 윤년일 수 있다.
     그러나 해당 연수가 100으로 나누어 떨어지면 평년이다.
     2000년은 4로 나눈값이 0 이라서 윤년일 수 있는데..
     다시 이 값이 100으로 나눠 떨어지면 평년이다.
     평년이라 해도 다시 400으로 나눠 떨어지는 연도는 윤년이다.
     **/
    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("년도를 입력하세요.");
        int year = scan.nextInt();
        String result = "";
        if(year % 400==0){
            result = "윤년";
        }else if(year % 100==0){
            result = "평년";
        }else if(year % 4==0){
            result = "윤년";
        }else{
            result = "평년";
        }
        System.out.println(year + "년: " + result );
    }
}
class BasicIfelseReportCard{
    public static void main(){
        Scanner s = new Scanner(System.in);
        System.out.println("Name : ");
        String name = s.next();
        System.out.println("Korean score : ");
        int korean = s.nextInt();
        System.out.println("English score : ");
        int english = s.nextInt();
        System.out.println("Math score : ");
        int math = s.nextInt();
        int total = korean+english+math;
        int average = total/3;
        char grade = 0;
        if(average >=90){
            grade = 'A';
        } else if(average>=80){
            grade = 'B';
        }else if(average>=70){
            grade = 'C';
        }else{
            grade = 'D';
        }

        System.out.println("Name :"+name);
        System.out.println("Total :"+total);
        System.out.println("Average :"+average);
        System.out.println("Grade :"+grade);


    }
}