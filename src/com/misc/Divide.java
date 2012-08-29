package com.misc;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 8/10/12
 * Time: 8:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class Divide {

    private static HashMap<Integer, String> hashMap = new LinkedHashMap<Integer, String>();

    public static  void main(String ... args) {
        System.out.println(divide(225, 1000, new StringBuffer("")));

    }

    public static String divide(int a, int b, StringBuffer result) {
      if(a == 0)
          return  result.toString();
      if ( a >= b) {
          result.append(a/b);
          return divide(a%b, b, result);
      } else {
          if(result.toString().indexOf(".") == -1) {
              if(result.toString().length() > 0)
                  result.append(".");
              else
                  result.append("0.");
          }

          a = a * 10;
          while(a < b) {
            a = a * 10;
            result.append("0");
          }


          if (hashMap.containsKey(a)) {
            System.out.println(result.toString());
            String parts[];
            parts = result.toString().split("\\.");
            System.out.println(parts.length);
            /*for(String part: parts) {
                System.out.print(part);
            } */
            return parts[0] + ".(" + parts[1]  + ")";
            //return result.toString();
          } else {
             hashMap.put(a, result.toString());
          }
          return divide(a, b, result);
      }
    }
}
