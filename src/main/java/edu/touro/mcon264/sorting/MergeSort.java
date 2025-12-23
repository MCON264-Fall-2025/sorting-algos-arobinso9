package edu.touro.mcon264.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort implements Sorter {

    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        if (a == null || a.length < 2) {
            return; // Base case: 0 or 1 element is already sorted
        }
        mergeSort(a, 0, a.length - 1, comp);
    }

    private <T> void mergeSort(T[] a, int left, int right, Comparator<? super T> comp) {
        // Base Case: If left >= right, the subarray has 1 element
        if (left < right) {
            // Find the midpoint (overflow-safe)
            int mid = left + (right - left) / 2;

            // Divide: Recursively sort the first and second halves
            mergeSort(a, left, mid, comp);
            mergeSort(a, mid + 1, right, comp);

            // Conquer: Merge the sorted halves
            merge(a, left, mid, right, comp);
        }
    }

    private <T> void merge(T[] a, int left, int mid, int right, Comparator<? super T> comp) {
        // Create temporary copies of the subarrays
        // Arrays.copyOfRange (from, to) where 'to' is exclusive
        T[] leftSide = Arrays.copyOfRange(a, left, mid + 1);
        T[] rightSide = Arrays.copyOfRange(a, mid + 1, right + 1);

        int i = 0; // Initial index of leftSide
        int j = 0; // Initial index of rightSide
        int k = left; // Initial index of merged array

        // Compare elements from left and right and merge them back in order
        while (i < leftSide.length && j < rightSide.length) {
            if (comp.compare(leftSide[i], rightSide[j]) <= 0) {
                a[k++] = leftSide[i++];
            } else {
                a[k++] = rightSide[j++];
            }
        }

        // Copy remaining elements of leftSide, if any
        while (i < leftSide.length) {
            a[k++] = leftSide[i++];
        }

        // Copy remaining elements of rightSide, if any
        while (j < rightSide.length) {
            a[k++] = rightSide[j++];
        }
    }
}