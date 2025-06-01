import java.util.*;
// This program finds the largest element in an array of integers.
public class LargestElement {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 5 integers:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        // Find the largest element in the array
        int largest = findLargest(arr);
        System.out.println("The largest element is: " + largest);
    }

    public static int findLargest(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty or null.");
        }
        
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }
}