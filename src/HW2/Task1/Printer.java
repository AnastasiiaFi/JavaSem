package HW2.Task1;


import java.util.HashMap;
import java.util.Map;
class Answer {
    public static StringBuilder answer(String QUERY, String PARAMS){
        // Напишите свое решение ниже
        StringBuilder myQuery = new StringBuilder();
        myQuery.append(QUERY);
        char[] charArrayParams = PARAMS.toCharArray();
        StringBuilder clearParams = new StringBuilder();
        for (int i = 0; i < PARAMS.length(); i++) {
            if (charArrayParams[i] != '[' &&
                    charArrayParams[i] != '{' &&
                    charArrayParams[i] != '"' &&
                    charArrayParams[i] != '}' &&
                    charArrayParams[i] != ','
            ) {
                if (charArrayParams[i] == ':') {
                    clearParams.append(" ");
                } else {
                    clearParams.append(charArrayParams[i]);
                }
            }
        }
        String[] convertParams = clearParams.toString().split(" ");
        int count = 0;
        for (int i = 0; i < convertParams.length; i += 2) {
            if (!convertParams[i + 1].contains("null")) {
                if (count != 0) {
                    myQuery.append(" and " + convertParams[i] + "='" + convertParams[i + 1]+"'");
                    count++;
                } else {
                    myQuery.append(convertParams[i] + "='" + convertParams[i + 1]+"'");
                    count++;
                }
            }
        }
        return myQuery;
    }
}


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
    public static void main(String[] args) {
        String QUERY = "";
        String PARAMS = "";

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            QUERY = "select * from students where ";
            PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
        }
        else{
            QUERY = args[0];
            PARAMS = args[1];
        }

        Answer ans = new Answer();
        System.out.println(ans.answer(QUERY, PARAMS));
    }
}