package HW2.Task2;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
//
//Напишите свой код в методе sort класса BubbleSort. Метод sort принимает на вход один параметр:
//
//int[] arr - числовой массив
//
//После каждой итерации, ваш код должен делать запись в лог-файл 'log.txt' в формате год-месяц-день час:минуты {массив на данной итерации}.

class BubbleSort {
    private static File log;

    private static FileWriter fileWriter;

    private static void logLine(String logLine){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-d HH:mm");
        String date = dateFormat.format(new Date());
        try {
            fileWriter.write( date + " " + logLine);
            fileWriter.write("\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
        }

    }

    public static void sort(int[] mas) {
        log = new File("src/HW2/Task2/log.txt");
        try {
            fileWriter = new FileWriter(log) ;
        } catch (IOException e) {
            System.out.println("Невозможно открыть файл");
            return;
        }
        for (int i = 0; i < mas.length - 1; i++) {
            boolean flag = true;
            for(int j = 0; j < mas.length - i - 1; j++) {
                if(mas[j + 1] < mas[j]) {
                    flag = false;
                    int swap = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = swap;
                }

            }
            if (flag){
                break;
            }
            logLine(Arrays.toString(mas));

        }
        logLine(Arrays.toString(mas));

    }
}

//class BubbleSort {
//    private static File log;
//    private static FileWriter fileWriter;
//
//    public static void sort(int[] mas) {
//        try {
//            log = new File("log.txt");
//            log.createNewFile();
//            fileWriter = new FileWriter(log);
//            bubbleSort(mas);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fileWriter.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private static int[] bubbleSort(int[] mas) {
//        boolean isSorted = false;
//        int buffer;
//
//        while (!isSorted) {
//            isSorted = true;
//            for (int i = 0; i < mas.length - 1; i++) {
//                if (mas[i] > mas[i + 1]) {
//                    isSorted = false;
//
//                    buffer = mas[i];
//                    mas[i] = mas[i + 1];
//                    mas[i + 1] = buffer;
//                }
//            }
//            logStep(Arrays.toString(mas));
//        }
//        return mas;
//    }
//
//    public static void logStep(String note){
//      try {
//          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//          String timestamp = dateFormat.format(new Date());
//          fileWriter.write(timestamp + " " + note + "\n");
//      } catch (IOException e) {
//          e.printStackTrace();
//      }
//  }
//
//}





// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
    public static void main(String[] args) {
        int[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
