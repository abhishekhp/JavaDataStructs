package com.misc;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/12/12
 * Time: 10:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class FibonacciRec {

   private static int fibonacci(int n) {
       if(n == 0)
           return  0;
       if(n == 1)
           return 1;
       return fibonacci(n-1) + fibonacci(n-2);
   }

   public static  void main(String ... args) {
       for(int n = 0; n < 10; n++)
           System.out.println(fibonacci(n));
   }
}
