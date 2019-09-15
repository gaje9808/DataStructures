package mustDo.coding.problems.Amazon;
// https://www.geeksforgeeks.org/must-coding-questions-company-wise/#amazon

// This problem is solved using different ways of sorting

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KLargestElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0;i<t;i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int j=0;j<n;j++) {
                a[j] = sc.nextInt();
            }
            findklargest(a,n,k);
            System.out.println();
        }
    }

    public static void findklargest(int[] a,int n, int k) {
        if (k <n) {
            countSort(a);
//            heapSort(a);
//            quickSort(a,0,n-1);
//            mergeSort(a,0,n-1);
//            bubbleSort(a);
//            selectionSort(a);
//            Arrays.sort(a);
//            insertionSort(a);

            for (int i=n-1;i>=n-k;i--){
                System.out.print(a[i]+" ");
            }
        }
    }

    public static void countSort(int[] a) {
        int n = a.length;
        int min = Arrays.stream(a).min().getAsInt();
        int max = Arrays.stream(a).max().getAsInt();

        int range = max-min+1;
        int[] count = new int[range];
        int[] output = new int[n];

        for (int i=0;i<n;i++) count[a[i] - min]++;
        for (int i=1;i<count.length;i++) count[i] += count[i-1];
        for (int i=0;i<n;i++) {
            output[count[a[i] -min] -1 ]= a[i];
            count[a[i] -min]--;
        }
        for (int i=0;i<n;i++) {
            a[i] = output[i];
        }
    }

    public static void heapSort(int[] a){
        int n = a.length;
        for (int i=(n/2)-1;i>=0;i--) {
            heapify(a,n,i);
        }

        for (int i=n-1;i>=0;i--) {
            swap(a,0,i);
            heapify(a,i,0);
        }
    }

    public static void heapify(int[] a, int n, int i) {
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if (l<n && a[l] > a[largest]) largest = l;
        if (r<n && a[r] > a[largest]) largest = r;

        if (largest != i) {
            swap(a,i,largest);
            heapify(a, n, largest);
        }
    }

    public static void quickSort(int[] a, int l, int r) {
        if (l<r){
            int pi = partition(a, l, r);
            quickSort(a,l,pi-1);
            quickSort(a,pi+1,r);
        }
    }

    public static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l-1;
        for (int j=l;j<r;j++){
            if (a[j] < pivot){
                i++;
                swap(a,i,j);
            }
        }
        swap(a,i+1,r);
        return i+1;
    }

    public static void mergeSort(int[] a, int l, int r) {
        if (l<r){
            int m = (l+r)/2;
            mergeSort(a,l,m);
            mergeSort(a,m+1,r);
            mergeSortutil(a,l,m,r);
        }
    }

    public static void mergeSortutil(int[] a, int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i=0;i<n1;i++){
            L[i] = a[l+i];
        }

        for (int j=0;j<n2;j++){
            R[j] = a[m+j+1];
        }

        int i=0, j=0,k=l;

        while (i<n1 && j<n2) {
            if (L[i] < R[j]){
                a[k++] = L[i++];
            }
            else a[k++] = R[j++];
        }
        while (i<n1) a[k++] = L[i++];
        while (j<n2) a[k++] = R[j++];
    }

    public static void insertionSort(int[] a) {
        int n = a.length;
        for (int i=1;i<n;i++) {
            int key = a[i];
            int j = i-1;

            while (j>=0 && a[j] > key) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }

    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i=0;i<n-1;i++){
            int min = i;
            for (int j=i+1;j<n;j++){
                if (a[j] < a[min]){
                    min = j;
                }
            }
            swap(a,i,min);
        }

    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i=0;i<n-1;i++) {
            boolean swapped = false;
            for (int j=0;j<n-1-i;j++) {
                if (a[j] > a[j+1]){
                    swap(a,j,j+1);
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
