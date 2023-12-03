import java.util.Random;
//import HeapSort.HeapSort;
import java.util.Arrays;


public class Test {
    private int upperBound = 10000;
    private int paramLen = 25;
    private int[] generateRandomArray(int len) {
        int[] randomArray = new int[len];
        Random random = new Random();

        for (int i = 0; i < len; i++) {
            // 生成随机整数，范围可以根据需要调整
            randomArray[i] = random.nextInt(this.upperBound) + 1; // 生成1到100（包括1和100）之间的随机整数
        }

        return randomArray;
    }

    private static void checkArrayEquality(int[] array1, int[] array2) {
        if (!Arrays.equals(array1, array2)) {
            throw new ArrayNotEqualException("Arrays are not equal.");
        }
    }

    public void testSort() {
        int[] param = generateRandomArray(paramLen);
        HeapSort heapSort = new HeapSort();
        for (int p : param) {
            int []array = generateRandomArray(p);
            int[] copiedArray = Arrays.copyOf(array, array.length);
            heapSort.sort(array);
            Arrays.sort(copiedArray);
            checkArrayEquality(array, copiedArray);
        }
        System.out.println("All tests successfully finished.\n");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.testSort();
    }
}