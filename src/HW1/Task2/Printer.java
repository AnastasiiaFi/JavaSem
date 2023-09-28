package HW1.Task2;


class Answer {
    public void printPrimeNums(){
        // Напишите свое решение ниже
        boolean b = true;
        for (int i = 1; i < 1001; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    b = false;
                    break;
                }
            }
            if (b) System.out.println(i);
            else b = true;
        }
    }
}
public class Printer {
    //    Напишите функцию printPrimeNums, которая выведет на экран все простые числа в промежутке от 1 до 1000, каждое на новой строке.
//
//    Напишите свой код в методе printPrimeNums класса Answer.
    public static void main(String[] args) {

        Answer ans = new Answer();
        ans.printPrimeNums();
    }
}
//Эталонное решение

//class Answer {
//    public void printPrimeNums(){
//        boolean isPrime;
//        for(int i = 1; i < 1000; i++) {
//            isPrime = i == 1;
//            for(int j = 2; j < 1000; j++) {
//                if (i >= j && i % j == 0) {
//                    if(j == i) {
//                        isPrime = true;
//                    }
//                    break;
//                }
//            }
//            if(isPrime) System.out.println(i);
//        }
//    }
//}
//
//public class Printer{
//    public static void main(String[] args) {
//
//        Answer ans = new Answer();
//        ans.printPrimeNums();
//    }
//}