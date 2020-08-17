package com.anchorage.web.basic;
class BasicMatrixMain{
    public static void main(String[] args) {
        BasicMatrix5by5.main();
        BasicMatrixDiff5.main();
        BasicMatrixNaiveGugudan.main();
        BasicMatrixGugudan.main();
        BasicMatrixDiamond.main();
        BasicMatrixMrSmith.main();
        BasicMatrixTeamSpec.main();
        BasicMatrixZigzag.main();
    }
}
class BasicMatrix5by5 {
    /**
     [0,0][0,1][0,2][0,3][0,4]
     [1,0][1,1][1,2][1,3][1,4]
     [2,0][2,1][2,2][2,3][2,4]
     [3,0][3,1][3,2][3,3][3,4]
     [4,0][4,1][4,2][4,3][4,4]
     * */
    static void main() {
        int[][]mtx=new int[5][5];
        for(int i=0;i<mtx.length;i++){
            System.out.println("");
            for(int j=0;j<mtx[i].length;j++){
                System.out.printf("[%d,%d]",i,j);
            }
        }

    }
}
class BasicMatrixDiff5 {
    /*
    5	10	15	20	25
    30	35	40	45	50
    55	60	65	70	75
    80	85	90	95	100
    105	110	115	120	125
     * */
    public static void main() {
        int[][]mtx=new int[5][5];
        int k=0;
        for(int i=0;i<mtx.length;i++){
            System.out.println("");
            for(int j=0;j<mtx[i].length;j++){
                mtx[i][j]=k+=5;
                System.out.printf("%d\t",mtx[i][j]);
            }
        }

    }
}
class BasicMatrixNaiveGugudan{
    /*
    2X1=2*1  3X1=3*1 4X1=4*1  5X1=5*1
    2X2=2*2 [1,1][1,2][1,3][1,4]
    2X3=2*3 [2,1][2,2][2,3][2,4]
    2X4=2*4 [3,1][3,2][3,3][3,4]
    2X5=2*5 [4,1][4,2][4,3][4,4]
     * */
    public static void main() {
        // i * j = i*j
        int[][]mtx=new int[10][10];
        for(int i=2; i<mtx.length; i++){
            System.out.println("");
            for(int j=1; j<mtx[i].length; j++){
                System.out.printf("%dX%d\t",i,j);
            }
        }
    }
}
class BasicMatrixGugudan {
    public static void main() {
        for(int i = 1; i < 10; i++) {
            for(int dan=2; dan<6; dan++) {
                System.out.print(String.format("%d * %d = %d \t", dan, i, dan*i));
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 1; i < 10; i++) {
            for(int dan=6; dan<10; dan++) {
                System.out.print(String.format("%d * %d = %d \t", dan, i, dan*i));
            }
            System.out.println();
        }

    }
}
class BasicMatrixDiamond {
    /*
    0	0	1	0	0
    0	2	3	4	0
    5	6	7	8	9
    0	10	11	12	0
    0	0	13	0	0
     * */
    static void main() {
        int len=5, col= len, row= len, val=0, start=0, end=0; //배열에 저장할 변수
        int[][] arr = new int[ col][ row];
        start=3; //열의 시작 위치
        end=3; //열의 끝 위치


    }
}
class BasicMatrixMrSmith {
    /**
     Good Morning	Mr.Smith 을 출력하시오
     * */
    static void main() {
        String[][] name={
                {"Good Morning","Good Afternoon","Good Evening","Good Bye"},
                {"Mr.","Mrs.","Miss"},
                {"Smith","Alex","Johnson"}};
        String people="";
        people=name[0][0]+"\t";
        people+=name[1][0];
        people+=name[2][0];
        // Miss.Alex

        System.out.printf("%s",people);

    }
}
class BasicMatrixTeamSpec {
    static void main() {
        String[] vivace = {"은지","서우","지우","창준","현일"};
        String[] royal = {"창하","수호","은영","정욱",""};
        String[] atlas = {"동준","이레","종협","지은",""};
        String[] ntom = {"정우","기호","승아","태혁",""};
        System.out.println("팀장만 ?");
        String[] res = new String[4];
        String[][] mtx = {vivace,royal,atlas,ntom};

        for(int i=0;i<mtx.length;i++) {
            for(int j =0;j<1;j++) {
                res[i] = mtx[i][j];
            }
        }
        for(int i=0;i<res.length;i++) {
            System.out.print(res[i]+"\t");
        }
    }
}
class BasicMatrixZigzag {
    /*
      1   2   3   4   5
     10   9   8   7   6
     11  12  13  14  15
     20  19  18  17  16
     21  22  23  24  25
     * */
    public static void main() {
        int length = 5; // 배열 길이
        int[][] arr = new int[length][length];
        int k = 1; // 넣을 값
        int flag = 1; // 스위치변수
        int i = 0; // 행
        int j = 0; // 열


    }
}
