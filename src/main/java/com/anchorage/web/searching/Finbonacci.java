package com.anchorage.web.searching;

import java.util.Scanner;

class FinbonacciMain {
    public static void main(String[] args) {
        FibonacciScanner.main();
        Factorial4037913.main();
        Fibonacci17710.main();
    }
}
class FibonacciScanner {
    /**
     1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
     */
    public static void main() {
        Scanner s = new Scanner(System.in);
        int a=1, b=1, c=2, sum=2;
        System.out.print("Enter the last index of Term"
                + "(Start of index is 1)");
        int last=s.nextInt();
        for(int i=3;i<=last;i++){
            c=a+b;
            sum+=c;
            a=b;
            b=c;
        }
        System.out.printf("The Sum to %d is %d",last,sum);

    }
}

class Fibonacci17710 {
    /**
     첫째 및 둘째 항이 1이며 그 뒤의 모든 항은 바로 앞 두 항의 합인 수열이다.
     처음 여섯 항은 각각 1, 1, 2, 3, 5, 8, 13 ... 이다
     피보나치 수열의 20번째 항까지의 합은 얼마인가? 17710
     5항까지의 합이 12가 나오는 식을 먼저 만듭시다.
     * */
    static void main() {
        int A = 1;
        int B = 1;
        int S = A + B;
        int N = 2; // count
        int C = 0; // 3 ~ 20번째 항
        for(N=2; N< 20; N++) {
            C = A + B;
            //System.out.printf("C is %s\n", C);
            S += C;
            A = B;
            B = C;
        }
        System.out.printf("S is %s", S);
    }
}
