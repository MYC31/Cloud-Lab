import java.util.Scanner;

public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;
        // 初始化最大堆
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        // 逐步提取最大元素（堆顶元素），并重建堆
        for (int i = n - 1; i > 0; i--) {
            // 将当前堆顶元素（最大值）与数组末尾元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 重新构建最大堆
            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i; // 初始化根节点为最大值
        int left = 2 * i + 1; // 左子节点
        int right = 2 * i + 2; // 右子节点
        // 如果左子节点比根节点大
        if (left < n && arr[left] > arr[largest])
            largest = left;
        // 如果右子节点比当前最大节点大
        if (right < n && arr[right] > arr[largest])
            largest = right;
        // 如果最大值不是当前节点，交换节点并递归调整堆
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // 发生调整后，需要再验证调整一下子节点是否是其它堆的父节点
            heapify(arr, n, largest);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要排序的数组长度:");
        int len = scanner.nextInt();
        int[] arr = new int[len];
        System.out.println("请输入数组的元素:");
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        System.out.println("排序后的数组为:");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
