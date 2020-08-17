package com.anchorage.web.searching;

import java.util.Scanner;

class SortMain {
    public static void main(String[] args) {
        BubbleSort.main();
    }
}
class BubbleSort {
    public static void main() {
        int i,j,temp,length=5;
        int datas[] = new int[length];
        Scanner scanner = new Scanner(System.in);
        System.out.println("TOTAL COUNT is 5.. ");
        for(i=0;i<length;i++){}
        System.out.println();
        for(i=0;i<length;i++){}
        System.out.println("DATA COUNT : "+length);
        String result = "";
        for(i=0;i<datas.length;i++){
            result += datas[i]+" , ";
        }
        System.out.println("DATA in ascending order \n"
                +result.substring(0, result.length()-2));

    }
}
