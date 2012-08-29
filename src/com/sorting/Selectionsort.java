package com.sorting;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/9/12
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Selectionsort {

    private int[] numbers;


    public void sort(int[] values) {
        // Check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;

        for(int i = 0; i < values.length -1; i++) {
            int minpos = i;
            for( int j = i+1; j < values.length; j++) {
                 if(numbers[j] < numbers[minpos]) {
                     minpos = j;
                 }
            }

            if(i != minpos)
                exchange(i, minpos);
        }

        for(int n=0; n< numbers.length; n++) {
            System.out.print(numbers[n] + ", ");
        }
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String ... args)  {
        Selectionsort ss = new Selectionsort();
        int a[] = {3,7,8,5,2,1,9,5,4};
        ss.sort(a);
    }}
