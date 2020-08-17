package com.anchorage.web.basic;

import java.util.Scanner;

class BasicForloopMain {
    public static void main(String[] args) {
        BasicForloopSum1To10.main();
        BasicForloopReportCard.main();
        BasicForloopGrade.main();
        BasicForloopInputSum.main();
        BasicForloopReverse.main();
        BasicForLoopExceptMultiple3.main();
    }
}
class BasicForloopReverse {
    static void main() {
        int i=10;
        for (; i >-1; i-=2) {
            System.out.printf("%d\t",i);
        }
    }
}
class BasicForloopSum1To10 {
    static void main() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            sum += i;
        }
        System.out.println("합 : "+sum);

    }
}
class BasicForloopReportCard{
    static void main(){
        Scanner s = new Scanner(System.in);
        int[] arr = new int[5];
        int sum=0;
        String subgrade="";
        System.out.println("Name : ");
        String name = s.next();
        System.out.println("If you want to stop, Type -1");
        System.out.println("If the number of Subject is 6, Auto quit!!");
        for(int i=0; i<arr.length; i++){
            arr[i] = s.nextInt();
        }
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            subgrade+=arr[i]+"\t";
        }


        int average = sum/arr.length;
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
        String sub[] = {"이름","국어","영어","수학","과학","사회","평균","학점"};
        String sub2="";
        int i=0;
        for(i=0;i<sub.length;i++){
            sub2+=sub[i]+"\t";
        }
        String line = "====================================================================";
        String line1 = "-------------------------------------------------------------------";

        System.out.printf("%s\n%s\n%s\n%s\t%s%d\t%c\n%s",line, sub2, line1,name,subgrade,average,grade,line );

    }
}
class BasicForloopGrade {
    static void main() {
        Scanner s = new Scanner(System.in);
        String str = "=============================================================\n";
        str = "이름\t";
        System.out.printf("%s\n", "이름을 입력해주세요.");
        String name = s.next();
        System.out.printf("%s\n", "입력하실 과목수를 입력해주세요.");
        int length = s.nextInt();
        int i = 0, total = 0, average = 0, sw = 0;
        String arr[] = new String[length];
        int arr2[] = new int[length];
        String temp = "";
        for (i = 0; i < arr.length; i++) {
            System.out.printf("과목을 입력해주세요.\n");
            arr[i] = s.next();
            System.out.printf("점수를 입력해주세요.\n");
            arr2[i] = s.nextInt();
            total += arr2[i];
            str += arr[i] + "\t";
            temp += arr2[i] + "\t";
        }
        str += "평균\t" + "학점\n";
        str += "-------------------------------------------------------------\n";
        str += name + temp;
        average = total / length;
        sw = average / 10;
        char grade = 0;
        switch (sw) {
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            default:
                grade = 'D';
                break;
        }
        str += average + "\t" + grade+"\n";
        str += "=============================================================";
        System.out.printf("%s",str);

    }
}
class BasicForloopInputSum {
    // 두개의 정수를 입력받아서 그 범위내의 정수의 합 구하기 (단, 음수는 없음)
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("두 수 입력");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int max = (num1 > num2) ? num1 : num2;
        int min = (num1 < num2) ? num1 : num2;
        int sum = 0;
        for (int i = min + 1; i < max; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
class BasicForLoopExceptMultiple3 {
    /*3의배수를 제외한 1부터 10까지 수열는?
    (단,공차는 1..!,if-else 사용금지) */
    static void main() {
        int i=0;
        for (i = 1; i <= 10; i++) {
            if (i%3 == 0) {
                continue;
            }
            System.out.print(i+"\t");
        }
        System.out.println("for loop 바깥");

    }
}
