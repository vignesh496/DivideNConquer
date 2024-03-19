import java.util.ArrayList;
import java.util.Scanner;

public class MinMax {

    static ArrayList<Integer> list = null;

    public static void print(int[] arr)    {
        System.out.println("\nMin element : "+ arr[0]);
        System.out.println("Position of " + arr[0] + " : " + list.indexOf(arr[0]));
        System.out.println("\nMax element : " + arr[arr.length-1]);
        System.out.println("Position of " + arr[arr.length-1] + " : " + list.indexOf(arr[arr.length-1]));
    }
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.println("Enter elements in an array : ");
        int n = ip.nextInt();
        int[] arr = new int[n];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = ip.nextInt();
            list.add(arr[i]);
        }

        minmax(arr, 0, arr.length - 1);
    }

    public static void minmaxutil(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[(m + 1) + j];

        int i = 0, j = 0, k = l;

        for (k = l; k <= r && i < n1 && j < n2; k++) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
        }

        for (; i < n1; i++, k++)
            arr[k] = L[i];

        for (; j < n2; j++, k++)
            arr[k] = R[j];
    }


    public static void minmax(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            minmax(arr, l, m);
            minmax(arr, m + 1, r);
            minmaxutil(arr, l, m, r);
            for (int i = 0; i < arr.length; i++)    {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            print(arr);
        }
    }
}
