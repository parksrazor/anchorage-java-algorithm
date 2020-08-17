package com.anchorage.web.basic;

import javax.swing.*;
import java.util.Scanner;

class BasicWhileLoopMain {
    public static void main(String[] args) {
        BasicWhileLoopPrintHelloWorld10Times.main();
        BasicWhileLoopMenu.main();
        BasicWhileLoopContinueDemo.main();
        BasicWhileLoopReportCard.main();
        BasicWhileLoopSeries1To5Diff2.main();
        BasicWhileLoopSeriesOneToFive.main();
        BasicWhileLoopFindTheSumOf5Numbers.main();
        BasicWhileLoopFindTheSumOfMulti5.main();
        BasicWhileloopGugudan.main();
        BasicWhileloopSeriesDiffChange.main();
        BasicWhileloopSeriesSwitch.main();
    }
}
class BasicWhileLoopMenu {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String result = JOptionPane.showInputDialog(null, "[메뉴]1.출력 2.종료");
            switch (Integer.parseInt(result)) {
                case 1:
                    for (int i = 0; i < 10; i++) {
                        System.out.printf("%s",(i+1));
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "종료하십니까?");
                    return;
                case 3:

                    break;
                default:
                    JOptionPane.showMessageDialog(null, "잘못된 값");
                    break;
            }
            System.out.println();
        }
    }

}
class BasicWhileLoopPrintHelloWorld10Times {
    static void main() {
        int count = 0;
        while(count<10){
            System.out.println("Hello World");
            count++;
        }
    }
}
class BasicWhileLoopContinueDemo {
    static void main() {
        int num = 0, sum=0;
        while(true){
            num++;
            sum+=num;
            if(num<100){
                continue;
            }else{
                break;
            }
        }
        System.out.printf("%s: \n"
                + "%d","합",sum);
    }
}
class BasicWhileLoopReportCard{
    public static void main(){
        Scanner s = new Scanner(System.in);
        System.out.println("Name : ");
        String name = s.next();
        System.out.println("Score : ");
        System.out.println("If you want to stop, Type -1");
        System.out.println("If the number of Subject is 6, Auto quit!!");
        int score = s.nextInt();

        int total = 0;
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
class BasicWhileLoopSeries1To5Diff2 {
    public static void main() {
        int sum=0;
        int num=1;
        while(num<=20){
            System.out.println("num: "+num);
            sum+=num;
            num+=2;
        }
        System.out.println("SUM: "+sum);
    }
}
class BasicWhileLoopSeriesOneToFive {
    public static void main() {
        int sum=0;
        int num=1;
        while(true){
            sum=sum+num;
            if(num==5){break;}
            num=num+1;
        }
        sum=1+2+3+4+5;
        System.out.println("SUM: "+sum);
    }
}
class BasicWhileLoopFindTheSumOf5Numbers {
    public static void main(){
        Scanner scanner= new Scanner(System.in);
        int sum=0,count=0,n=0;
        while(count<5){
            n=scanner.nextInt();
            sum+=n;
            count++;
        }
        System.out.printf("SUM: %d",sum);
    }
}
class BasicWhileLoopFindTheSumOfMulti5 {
    /**[Console]
    Integer From 1 To [input]
    The Number of Multi 5: ?
    The Sum:
            ※ If Input less than 4 && not -1, please input again!
            ※ If you want to stop, enter -1
    ex)
    Integer From 1 To 100
    The Number of Multi 5:20
    The Sum:1050
            */
    public static void main() {
        Scanner s=new Scanner(System.in);
        int target=0,sum=0,count=0,i=0;
        while(true){
            System.out.print("Enter Integer\n");
            target=s.nextInt();
            if(target<5){
                System.out.println((target==-1)?"Bye~":"please input again!");
            }else{
                count=0;
                sum=0;
                for(i=1;i<=target;i++){
                    if(i%5==0){
                        count++;
                        sum+=i;
                    }
                }
                System.out.printf("Integer From 1 To %d\n"
                        + "The Number of Multi 5:%d\n"
                        + "The Sum:%d\n",target,count,sum);
            }
        }
    }
}
class BasicWhileloopGugudan {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("출력할 단을 입력하세요");
            int dan = scanner.nextInt();
            if (dan > 0) {
                System.out.println(dan + "단");
                for (int i = 1; i < 10; i++) {
                    System.out.println(dan + " * " + i + " = " + dan * i);
                }
            } else {
                System.out.println("올바른 값을 입력 해 주세요.");
            }
        }
    }
}
class BasicWhileloopSeriesDiffChange {
    static void main() {
        int i=0, d=1, sum=1;
        while (true) {
            i++;
            d+=i;
            sum+=d;
            if(i==19)break;
        }
        System.out.printf(
                "============================================\n"
                        + "1+2+4+7+11+16+22+... 증가하는 수열의 20번째 항까지 합 \n"
                        + "--------------------------------------------\n"
                        + "%d \n"
                        + "============================================",
                sum);
    }
}
class BasicWhileloopSeriesSwitch {
    public static void main() {
        int i = 0, sum = 0, sw = 0;
        while(i < 100){
            i++;
            if(i%2==0){
                sw=-1;
                sum+=sw;
            }
        }
        System.out.printf(
                "==============================\n"
                        + "1-2+3-4+5-6...+99-100까지 합계    \n"
                        + "==============================\n"
                        + "%d \n"
                        + "==============================",sum);
    }
}