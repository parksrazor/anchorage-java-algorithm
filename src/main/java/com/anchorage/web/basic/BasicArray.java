package com.anchorage.web.basic;

import java.util.Scanner;

class BasicArrayMain {
    public static void main(String[] args) {
        BasicArrayNames.main();
        BasicArrayLotto.main();
        BasicArraySumOfInput.main();
        BasicArrayGradeNaive.main();
        BasicArrayGrade.main();
    }
}
class BasicArrayNames {
    static void main() {
        String[]a={"father","mom","son","daughter"};
        System.out.printf("Array length:%d\n",a.length);
        System.out.printf("Array 3번째 값:%d\n",a[2]);
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%s",a[i]);
        }

    }
}
class BasicArrayLotto {
    public static void main() {
        int lottoNum = 0, count = 0,i=0;
        int[]balls=new int[6];
        String result="";
        for(;i<balls.length;i++){
            balls[i]=0;// [2,43,12,12,30,19]
        }
        System.out.printf("%s", result);
    }
}
class BasicArraySumOfInput {
    static void main() {
        Scanner s=new Scanner(System.in);
        int i=0,sum=0;
        System.out.println("덧셈하려는 숫자를 입력하세요. 단,5개까지만 가능");
        int[]arr=new int[5];
        for(i=0;i<arr.length;i++){
            arr[i]=s.nextInt();
        }
        for(i=0;i<arr.length;i++){
            sum+=arr[i];
            System.out.printf("%s",(arr[i]==arr.length)?arr[i]+"=":arr[i]+"+");
        }
        System.out.printf("%d",sum);
    }
}
class BasicArrayGradeNaive {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        int i=0;
        int[]avg = new int[3];
        int[]score = new int[3];
        String[] name = new String[3];
        String[] grade = new String[3];

        for (;i<avg.length;i++) {
            System.out.println("이름,점수 입력");
            name[i]=scanner.next();
            avg[i] =scanner.nextInt();
        }

        if (avg[0]>avg[1]&&avg[0]>avg[2]) {
            grade[0]=name[0];
            score[0]=avg[0];
            if (avg[1]>avg[2]) {
                grade[1]=name[1];
                score[1]=avg[1];
                grade[2]=name[2];
                score[2]=avg[2];
            } else {
                grade[1]=name[2];
                score[1]=avg[2];
                grade[2]=name[1];
                score[2]=avg[1];
            }
        } else if(avg[1]>avg[2]){
            grade[0]=name[1];
            score[0]=avg[1];
            if (avg[0]>avg[2]) {
                grade[1]=name[0];
                score[1]=avg[0];
                grade[2]=name[2];
                score[2]=avg[2];
            } else {
                grade[1]=name[2];
                score[1]=avg[2];
                grade[2]=name[0];
                score[2]=avg[0];
            }
        }else {
            grade[0]=name[2];
            score[0]=avg[2];
            if (avg[0]>avg[1]) {
                grade[1]=name[0];
                score[1]=avg[0];
                grade[2]=name[1];
                score[2]=avg[1];
            } else {
                grade[1]=name[1];
                score[1]=avg[1];
                grade[2]=name[0];
                score[2]=avg[0];
            }
        }


        System.out.printf("1등 : %s 점수는 %d \n",grade[0],score[0] );
        System.out.printf("2등 : %s 점수는 %d \n",grade[1],score[1] );
        System.out.printf("3등 : %s 점수는 %d \n",grade[2],score[2] );

    }
}
class BasicArrayGrade {
    static void main() {
        /**
         * 전교생이 몇명인지 몰라요.
         * 전교생 수를 입력받고
         * 학생의 이름과 점수를
         * 입력받고, 이것을 1등부터 꼴등까지 출력하세요
         * */
        Scanner scanner = new Scanner(System.in);
        int i = 0,count=0;
        System.out.println("학생 수가 몇명입니까?");
        count = scanner.nextInt();
        int[] hakbun = new int[count];
        int[] age = new int[count];
        String[]name = new String[count];
        System.out.println("?명의 이름,나이을 입력하세요");
        for (;i  < name.length; i++) {
            // ---- 학번
            name[i] = scanner.next();
            age[i]= scanner.nextInt();
        }
        System.out.print("====================\n");
        System.out.print("학번 | 이름 | 나이 \n");
        System.out.print("====================\n");
        for (i= 0; i < age.length; i++) {
            System.out.printf("%s\t%s\t%d\n",hakbun[i],name[i],age[i]);
        }
    }
}