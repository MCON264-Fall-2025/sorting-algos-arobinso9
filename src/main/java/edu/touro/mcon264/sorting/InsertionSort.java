package edu.touro.mcon264.sorting;

import java.util.Comparator;

public class InsertionSort implements Sorter {

    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        // Iterate through the array starting from the second element
        for (int i = 1; i < a.length; i++) {
            T key = a[i];
            int j = i - 1;

            // Move elements of a[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && comp.compare(a[j], key) > 0) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            // Place the key in its correct location
            a[j + 1] = key;
        }
    }
}