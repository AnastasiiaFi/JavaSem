package Sem2;

public class Task3 {
//    Напишите метод, который принимает на вход строку (String) и
//    определяет является ли строка палиндромом (возвращает boolean значение).
//
//    Полиндром - Слово или фраза, которые одинаково читаются слева
//    направо и справа налево.
    public static void main(String[] args) {
        String x = "Потоп";
        if(polindrom(x)){
            System.out.println("Является полнидромом");
        }
        else{
            System.out.println("Не является полнидромом");
        }
    }
    static boolean polindrom(String x){
        x = x.toLowerCase();
        char [] sum = x.toCharArray();
        for (int i = 0; i < sum.length / 2; i++) {
            if (sum[i] != sum[sum.length-1-i])
                return false;
        }
        return true;
    }
    static boolean polindromV2(String x){
        String s1 = x.toLowerCase();
        StringBuilder res = new StringBuilder(s1);
        String s2 = res.reverse().toString();
        return s1.equals(s2);
    }
}
