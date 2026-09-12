//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//void main() {
//   /* String word = "나난옳오";
//    String mmm = "너넌 옳오";
//    int result = 0;
//
//    for (int cp : word.codePoints().toArray()){
//        System.out.println(cp);
//        for (int pc : mmm.codePoints().toArray()){
//            int plus = pc == cp ? 1:0;
//            result += plus;
//        }
//    }
//    System.out.println(result);
//    Predicate<String> isEmpty = s -> s.isEmpty();
//    Supplier<String> hello = () -> "안녕";
//    System.out.println(hello.get());
//    @FunctionalInterface
//    interface ThreeNumSum_Function<A, B, C, R> {
//        R apply(A a, B b, C c, R r);
//    }
//
//    ThreeNumSum_Function<String, String, String, String>
//            say = (a, b, c, d) -> a+b+c+d;
//
//    System.out.println(say.apply("안녕하세요. \n","천승환입니다. \n","한번 람다함수로", "문자열 출력해볼게요"));*/
//    /*Predicate<Integer> isEven = num -> num%2==0/* 여기
//    System.out.println(isEven.test(4));  // true
//    System.out.println(isEven.test(7));  // false
//
//    @FunctionalInterface
//    interface AvgFunction{
//        Double apply(int a, int b,int c);
//    }
//    AvgFunction avg = (a, b, c) -> (a+b+c)/3.0;
//    System.out.println(avg.apply(10, 20, 30)); // 20.0*/
//
//
//
//// numbers_len은 배열 numbers의 길이입니다.
//
//}
//class Solutio {
//    public int[] solution(int[] numbers, int num1, int num2) {
//        int[] answer = {};
//        answer = new int[num2-num1+1];
//        for (int i=num1; i<=num2; i++){
//            answer[i-num1] = numbers[i];
//        }
//
//        return answer;
//    }
//}
//class Solution {
//    public int[] solution(int[] numbers) {
//        int[] answer = {};
//        answer = new int[numbers.length];
//        for (int i=0; i<answer.length; i++){answer[i]=numbers[i]*2;}
//        return answer;
//    }
//}
//
//public class Main {
//    public static void main(String[] args){
//        int num1= 3, num2=5;
//        int[] num= {1,3,5,7,9,11};
//        Solution sol = new Solution();
//        int[] ary = sol.solution(num, num1, num2);
//        for (int i=0; i<ary.length; i++) System.out.println(ary[i]);
//    }
//}