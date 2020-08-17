package com.anchorage.web.searching;

import java.util.Scanner;
class SequenceMain{
    public static void main(String[] args) {
        Sequence119800.main();
        Sequence59048.main();
        Sequence5050.main();
        Sequence1350.main();
        Sequence369.main();
        Sequence70.main();
        Sequence30.main();
    }
}
class Sequence59048 {
    /**
     등비수열 : 각 항이 그 앞 항과. 일정한 비(곱셈)를 가지는 수열
     공비(共比, common ratio)
     2 + 6 + 18 + 54 = 80 4항까지의 합이다.
     그렇다면 10항까지의 합(=시리즈)은 얼마인가? 59048
     2 + (2*3) + (2 * 3 * 3) + (2 * 3 * *3 * 3)
     * */
    public static void main() {
        int A = 2; // 초항 init
        int R = 3; // 공비 common rate
        int S = A; // series
        int N = 2; // count
        int AN = 0;
        while(true) {
            A *= R;
            S += A;
            N++;
            if(N > 10) {
                break;
            }

        }
        System.out.printf("S is %s", S);
    }
}
class Sequence119800 {
    /**
     Count is 2, Number is 8, Sum is 10
     8 = 2 + 1 * 6;
     14 = 2 + 2 * 6;
     20 = 2 + 3 * 6;
     26 = 2 + 4 * 6;
     Count is 3, Number is 14, Sum is 24
     Count is 4, Number is 20, Sum is 44
     Count is 5, Number is 26, Sum is 70
     Count is 6, Number is 32, Sum is 102
     Count is 7, Number is 38, Sum is 140
     Count is 8, Number is 44, Sum is 184
     Count is 9, Number is 50, Sum is 234
     Count is 10, Number is 56, Sum is 290
     // 중간 생략
     Count is 198, Number is 1184, Sum is 117414
     Count is 199, Number is 1190, Sum is 118604
     Count is 200, Number is 1196, Sum is 119800
     S is 119800
     * */
    static void main() {
        int A = 2; // init
        int D = 6; // diff
        int S = A; // series
        int N = 2; // count
        int AN = 0; // term
        while(true){
            AN = A + (N-1)*D;
            S += AN;
            N ++;
            System.out.printf("Count is %d, Number is %d, Sum is %d \n",
                    (N-1),AN,S);
            if(N == 201) {
                break;
            }
        }
        System.out.printf("S is %d", S);

    }
}
class Sequence5050 {
    /**
     1+2+3+4+...+100 까지의 합계를 구하는 순서도를 작성하시오
     [변수]
     i : 항
     sum : 합계
     [결과]
     ====================
     1+2+3+...+100까지 합
     =====================
     5050
     =====================
     * */
    static void main() {
        int i=0, x=0;
        while(true) {
            i++;
            x += i;
            if(i<100) {
                continue;
            }else {
                break;
            }
        }

        System.out.println("====================");
        System.out.println("1+2+3+...+100까지 합");
        System.out.println("====================");
        System.out.println(x);
        System.out.println("=====================");

    }
}

class Sequence1350 {
    // 1+2+4+7+11+16+22
    //       1350
    static void main() {
        int i = 0, d = 1, sum = 1;

        while (true) {
            i++;
            d += i;
            sum += d;
            if(i < 19) {
                continue;
            }else {
                break;
            }
        }

        System.out.printf(
                "======================================================\n"
                        + "1+2+4+7+11+16+22+... 증가하는 수열의 20번째 항까지 합 \n"
                        + "======================================================\n"
                        + " %d \n"
                        + "=======================================================",sum);


    }
}
class Sequence369 {
    /**
     3의 배수를 제외한 1 부터 10까지 정수 출력
     [결과] 1 2 4 5 7 8 10
     */
    public static void main() {
        String res = "";
        for(int i=0;i<10;i++) {
            if((i+1) % 3 != 0 ) {
                res += (i+1)+" ";
            }
        }
        System.out.println(res);
    }
}
class Sequence70 {
    /**
     등차수열: 연속하는 두 항의 차이가 모두 일정한 수열
     공차(common difference) : 공통적으로 나타나는 차이
     2+8+14+20+26=70
     * */
    static void main() {
        int A = 2; // 초항 2
        int S = A;
        int D = 6; // 공차
        int N = 2; // 번째
        int AN = 0;
        // 2 + 8 + 14 + 20
        // 2 + (2+6) + (2+6+6)+ (2+6+6+6)
        String ex = "2";
        while (true) {
            // 이 곳을 채우시오
        }
        // System.out.println(ex + "=" + S); // syso

    }
}
class Sequence30 {
    public static void main() {
        Scanner scanner = new Scanner(System. in);
        System. out.println( "1부터 합산고자 하는 한계 숫자를 입력하세요");
        System. out.println( "1부터 입력값 범위내의 짝수만 합산됩니다.");
        int sum = 0;
        int num = scanner.nextInt();
        for ( int i = 1; i <= num; i++) {
            if ( i % 2 == 1) { // 홀수인 경우
                continue; // 더하지 않고 다음 반복으로 진행
            }else { // 짝수인 경우
                sum += i;
            }
        }
        System. out.println( "1부터 " + num + "까지 짝수의 합은 " + sum);
    }
}

