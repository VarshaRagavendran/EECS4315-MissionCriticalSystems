package main;

public class ArraySample {
    public static void main(String[] args) {
        int[] array = new int[2];
        array[0] = 1;
        array[1] = array[0];
        array[0]++;
        array[1] = 2;
    }
}