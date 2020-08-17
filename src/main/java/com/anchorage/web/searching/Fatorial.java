package com.anchorage.web.searching;

import java.util.Random;
import java.util.Scanner;

class FatorialMain {
    public static void main(String[] args) {
        Factorial4037913.main();
        Factorization.main();
        CountScores.main();
        MaxMin.main();
        PrimeFactorization.main();
    }
}
class Factorial4037913 {
    /*
    1 = 1
    2 = 2 * 1
    3 = 3 * 2 * 1
    4 = 4 * 3 * 2 * 1
    10항까지의 시리즈는 4037913 이다
     * */
    public static void main() {
        int S = 1;
        int F = 1;
        int N = 1;

        while(true) {
            N++;
            // 문제
            S += F;
			/*if() {
				break;
			}*/
        }
        // System.out.printf("S is %d",S); // 4037913
    }
}
class Factorization {
    /*
     합성수를 소수의 곱으로 나타내는 방법
     20=2×2×5
     * */
    static void main() {
        Scanner scan = new Scanner(System.in);

        int N = 0; // 소수의 갯수
        int i = 0;
        int C = 20; // 배열의 최대 크기
        int[] A = new int[C]; // 소수를 담는 배열
        System.out.println("소인수분해 하려는 숫자를 입력하세요");
        int T = scan.nextInt(); // 입력값
        int Target = T;
        if (T < 2) {
            System.out.println("2보다 작습니다");
            return;
        }
        do {
            i = 2;
            while (T % i != 0) {
                i++;
            }
            N++;
            A[N - 1] = i;
            T = T / i;

        } while (T != 1);
        System.out.print(Target + " = ");
        if (N == 1) {
            System.out.println("\n 소수");
        } else {
            for (i = 0; i < N; i++) {
                if(i != (N-1)) {
                    System.out.print(A[i] + " * ");
                }else {
                    System.out.print(A[i] + "  ");
                }

            }
        }

    }
}
class PrimeFactorization {
    static void main() {
        new PrimeFactorization().execute();
    }
    int dividend; // 피젯수
    int divisor; // 젯수
    int quotient; // 몫
    int remainder; // 나머지
    int i; // loop 인덱스
    int input; // 입력받는 수
    int count; // divisor 의 갯수
    int[] primes; // 소수들의 집합
    void execute(){
        count = 0;
        primes = new int[10]; // 10칸 짜리 기본 배열
        System.out.println("ENTER A INTEGER");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();
        dividend = input;
        if(dividend < 2){return;}
        while(dividend != 1){
            divisor = 2;
            // 알고리즘 코딩
        }
        if(count==1){
            System.out.println(input + " is prime number");
        }else{
            print();
        }
    }
    void print(){
        System.out.println("DIVIDEND : "+dividend);
        System.out.println("DIVISOR : "+divisor);
        String result = "";
        for(i=0;i<primes.length;i++){
            result += primes[i]+" X ";
        }
        System.out.println("PRIMES : \n"
                +result.substring(0, result.length()-2));

    }
}
class CountScores {
    /**
     <문제>
     영어 시험 성적이 80점 이상인 학생들의 수를 구하는 알고리즘을 제시하라.
     - 전체 학생의 수는 100명이다.
     - 영어 점수는 100점 만점을 기준으로 채점되었다.
     - 영어 점수는 배열 변수 JUMSU(100)에 이미 저장되어 있다고 가정한다.
     * */
    public static void main() {
        int[] JUMSU = new int[100];
        Random random = new Random();
        int count=0;
        for(int i=0;i<JUMSU.length;i++) {
            JUMSU[i] = random.nextInt(101);
        }
        for(int i=0;i<JUMSU.length;i++) {
            System.out.print("i 값:"+i+"\t");
            System.out.println("JUMSU[i] 값:"+JUMSU[i]+"\t");
            System.out.println("JUMSU 값:"+JUMSU+"\t");
            if(JUMSU[i] >= 80) {
                count++;
            }
        }
        //System.out.printf("영어 시험 성적이 80점 이상인 학생들의 수는 %d명이다",count);
    }
}
class MaxMin {
    /**
     <문제>
     1개 반의 학생의 몸무게를 측정하였다.
     - 각 반의 학생의 수는 30명이다.
     - 각 반의 학생 몸무게의 최대, 최소값을 구하시오.
     - 단, 몸무게는 40 ~ 100사이에서만 램덤으로 생성시키시오
     * */
    public static void main() {
        int max = 40, min= 100;
        int[] a = new int[30];
        Random random = new Random();

        for(int i=0;i<a.length;i++) {
            a[i] = random.nextInt(61)+40;
            if(a[i]>=max) {
                max = a[i];
            }
            if(a[i]<=min) {
                min = a[i];
            }
        }
        System.out.printf("최대값은 %d, 최소값은 %d",max,min);
    }
}