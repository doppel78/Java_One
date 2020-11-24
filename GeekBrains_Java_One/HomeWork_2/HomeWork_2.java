package GeekBrains_Java_One.HomeWork_2;

import java.util.Arrays;

public class HomeWork_2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            printTask(i);
        }
    }

    public static void printTask(int number) {
        System.out.println("Задание " + number + ":");
        switch (number) {
            case 1:
                invertArray();
                break;
            case 2:
                fillArray();
                break;
            case 3:
                changeArray();
                break;
            case 4:
                fillDiagonal();
                break;
            case 5:
                findMinMax();
                break;
            case 6:
                int[] arr = {1, 1, 1, 2, 1};
//             int[] arr = {2, 1, 1, 2, 1};
                System.out.println(Arrays.toString(arr));
                System.out.println("Cумма левой и правой части массива " + (checkBalance(arr) ? "равны" : "не равны"));
                break;
            case 7:
                int[] arrOffset = {1, 2, 3, 4, 5};
                System.out.println(Arrays.toString(arrOffset));
                offset(arrOffset, 2);
                break;
        }
        System.out.println();

    }


     // Задание 1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     // С помощью цикла и условия заменить 0 на 1, 1 на 0;

    public static void invertArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


     // Задание 2 Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями
     // 0 3 6 9 12 15 18 21;
    public static void fillArray() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr));
    }


     // Задание 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие
     // 6 умножить на 2;
    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

     // Задание 4 Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void fillDiagonal() {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }
        System.out.println(Arrays.deepToString(arr));
    }

     // Задание 5 ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void findMinMax() {
        int[] arr = {7, 5, 3, 2, 11, 4, 5, 1, 4, 8, 9, 2};
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Минимальный: " + min);
        System.out.println("Максимальный: " + max);
    }

     // Задание 6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
     // метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
     // Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance
     // ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят.;
    public static boolean checkBalance(int[] arr) {
        int i = 0;
        int j = arr.length;
        int sumBegin = 0;
        int sumEnd = 0;
        while (i != j) {

            sumBegin = sumBegin + arr[i];
            i++;
            while (sumBegin > sumEnd && i != j) {
                j--;
                sumEnd = sumEnd + arr[j];
            }
        }

        return sumBegin == sumEnd;
    }

     // Задание 7 **** Написать метод, которому на вход подается одномерный массив и число n
     // (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива
     // на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    public static void offset(int[] arr, int n) {
        int buffer1 = arr[0];
        int buffer2 = 0;
        int i = 0;

        do {
            i = i + n;
            if (i >= arr.length) {
                i = i - arr.length * (i / arr.length);
            }
            if (i < 0) {
                int remain = (Math.abs(i) % arr.length) != 0 ? 1 : 0;
                i = arr.length * ((Math.abs(i) / arr.length) + remain) + i;
            }

            buffer2 = buffer1;
            buffer1 = arr[i];
            arr[i] = buffer2;

        } while (i != 0);

        System.out.println("После смещения на " + n + " позиций");
        System.out.println(Arrays.toString(arr));

    }
}
