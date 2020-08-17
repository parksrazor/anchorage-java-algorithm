package com.anchorage.web.basic;
import java.util.*;
class BasicHashSetMain{
    public static void main(String[] args) {
        BasicHashSet.main();
    }
}
class BasicHashSet {
    static void main() {
        Scanner s = new Scanner(System.in);
        String[] arr={"Java","JSP","Spring","JS","Html"};
        // 1.추가..위에 주어진 배열 arr 을 set 에 추가하기
        HashSet<String> set=new HashSet<String>();
        for(String i:arr){
            set.add(i); // "Java","JSP","Spring","JS"
        }
        System.out.print("ARRAY: "+set.toString());
        // 2.검색(1)..첫글자가 H 로 시작하는 단어가 있는지 체크
        Set<String> result = new HashSet<String>();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (it.next().equals("Html")){
                //result.add(it.get());
                break;
            }
        }
        System.out.println(result.toString());
        // 3.검색(some)...첫글자가 J로 시작하는 단어를 출력


        // 4.전체 출력
        // 5.수정 (JS 를 Javascript) 로 변경

        // 수정이 끝나면 배열 arr 을 프린트하기
        // 6.삭제 (Spring 을 삭제)
        // 삭제가 끝나면 배열 arr 을 프린트하기
        for(int i=0;i<arr.length;i++){
            System.out.printf("%s,",arr[i]);
        }
        System.out.println();
        System.out.print("SET : "+set.toString());
        System.out.println("삭제를 원하는 값 입력하세요");
        String del = s.next();
        String strResult = "";
        int i;
        for(i=0;i<arr.length;i++){
            if(del.equals(arr[i])){

                arr[i]=arr[arr.length-1];
                arr[arr.length-1]=null;
                strResult="del삭제!";

                break;

            }else{
                strResult=del+"는 없는 값입니다";
            }
        }
        System.out.println(result); //이러면 4번 출력되자나
        String res2 = "";
        for(i=0;i<arr.length-1;i++){
            res2+=arr[i]+"\t";
        }
        System.out.print(res2);
    }
}
