import java.util.Arrays;
import java.util.Random;

public class ChoseSort {

    public static void sort(int[] array) {

        for (int i = 0; i < array.length-1; i++) {
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    int change = array[j];
                    array[j] = min;
                    min = change;
                }
            }
            array[i] = min;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[30000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(30000);
        }
        System.out.println(Arrays.toString(array));
        System.out.println();
        long time = System.currentTimeMillis();
        sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println();
        System.out.println((System.currentTimeMillis() - time) + " miliseconds");
    }
}
