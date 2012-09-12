package com.misc;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 9/10/12
 * Time: 7:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class XorDuplicates {

    static int a[] = {2,3,2,3,7,5,5};
    public  static  void main(String ... args) {
        int result = a[0];
        for(int i = 1; i < a.length; i++)
            result = result ^ a[i];
        System.out.print(result);
    }
}
