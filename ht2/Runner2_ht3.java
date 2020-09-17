import java.util.Arrays;
import java.util.Scanner;

/**
 * Task #3 (lesson2)
 * @author Alexander Butkevich
 */
public class Runner2_ht3 {
    /**
     * работа с массивом int[] с размерностью вводимой с консоли
     */
    public static void main(String[] args) {

        // объявление массива
        int[] arr;

        // задание размера с консоли
        Scanner sc = new Scanner(System.in);
        System.out.print("input array size: ");
        int size = 0;
        while(size <= 0 || size > 50) {
            size = sc.nextInt();
            if (size <= 0) System.out.print("incorrect value, repeat: ");
        }


        // создание массива
        arr = new int[size];


        // инициализация массива
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("array item #%d = ", i + 1);
            arr[i] = sc.nextInt();
        }

        // вывод значений массива в консоль
        System.out.print("array:     ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s%5d", (i == 0 ? "" : ", "), arr[i]);
        }
        System.out.print("\nrev array: ");
        for (int i = arr.length - 1; i >=0 ; i--) {
            System.out.printf("%5d%s", arr[i], (i == 0 ? "" : ", "));
        }

        // переменные результата
        double avgAux = 0.;
        int avgAuxCnt = 0;
        int[] arr2 = new int[arr.length];
        size = 0;

        for (int item: arr) {

            // вычисление ср. ар. элем. кратных 5 и не кратных 10
            if (item % 5 == 0 && item % 10 != 0) {
                avgAux += item;
                avgAuxCnt++;
            }

            // формирование второго массива из элем. первого
            // отрицательные, кратные 3, четные положительные
            if ((item < 0 && item % 3 == 0) ||
                    (item > 0 && item % 2 == 0)) {
                arr2[size++] = item;
            }
        }

        // вывод результатов
        if (avgAuxCnt > 0) {
            System.out.printf("\n\nresult = %.2f\n", avgAux/avgAuxCnt);
        } else {
            System.out.println("\nout of result");
        }

        if (size > 0) {
            arr2 = Arrays.copyOf(arr2, size);

            // вывод полученного массива в консоль
            System.out.print("\nnew array:     ");
            for (int i = 0; i < arr2.length; i++) {
                System.out.printf("%s%5d", (i == 0 ? "" : ", "), arr2[i]);
            }

            // сортировка массива по убыванию
            boolean flag = true;
            for (int i = 1; i < arr2.length && flag; i++) {
                flag = false;
                for (int j = 0; j < (arr2.length - i); j++) {
                    if (arr2[j] < arr2[j + 1]) {
                        int swap = arr2[j];
                        arr2[j] = arr2[j + 1];
                        arr2[j +1] = swap;
                        flag = true;
                    }
                }
            }

            // вывод осортированного массива
            System.out.print("\nrev new array: ");
            for (int i = 0; i < arr2.length; i++) {
                System.out.printf("%s%5d", (i == 0 ? "" : ", "), arr2[i]);
            }
        } else {
            System.out.println("no elements for new array");
        }

        sc.close();
    }
}
