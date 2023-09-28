package Sem1;

import java.util.Arrays;

public class Main2 {
//     Дан массив nums = [3,2,5,3] и число val = 3. 
// Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива. 
// Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.
    public static void main(String[] args) {
        int[] arr = {3,2,5,3};
        int val = 3;
        int[] res = sort(arr, val);
        System.out.println(Arrays.toString(res));
    }
    static int[] sort(int[] arr, int val) {
        int[] res = new int[arr.length];
        Arrays.fill(res, val);
        for (int i = 0, j = 0; i < res.length; i++) {
            if (arr[i] != val){
                res[j++] = arr[i];
                // j++;
            }
        }
        return res;
    }
}
