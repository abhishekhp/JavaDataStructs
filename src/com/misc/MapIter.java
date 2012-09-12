package com.misc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 9/10/12
 * Time: 7:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class MapIter {
    static char count[] = new char[256];
    static Map<String, Integer> countMap = new LinkedHashMap <String, Integer>();

    static String test = "aab acd edef adad aax";
    public static void main(String ... args) {
        for(int i =0; i < test.length(); i++) {
            count[test.charAt(i)]++;
            if(countMap.get(test.substring(i, i+1)) == null)
                countMap.put(test.substring(i, i+1), Integer.valueOf(1));
            else {
                Integer cnt = (Integer)countMap.get(test.substring(i, i+1));
                //System.out.println(countMap.get(test.substring(i, i+1)) + ":" + cnt++);
                countMap.put(test.substring(i, i+1), ++cnt);
            }
        }

        for(int i =0; i < test.length(); i++) {
            if(count[test.charAt(i)] == 1)
                System.out.print(test.charAt(i));
        }
        System.out.println();
        for( String key: countMap.keySet())  {
            if(Integer.valueOf(countMap.get(key)).equals(1))
                System.out.print(key);
        }

        for(Map.Entry entry: countMap.entrySet()) {
            System.out.print(entry.getKey() + ":" + entry.getValue());
        }


    }
}
