package com.misc;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 9/10/12
 * Time: 3:19 PM
 * To change this template use File | Settings | File Templates.
 */
import java.io.*;
import java.util.*;

public class RandomLine {

    private final static String PATH = "./data/RANDOM.txt";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(int i = 0; i < 1000; ++i)
        {
            String s = random(new File(PATH));
            if(!map.containsKey(s))
                map.put(s, 0);
            map.put(s, map.get(s) + 1);
        }
        //random(new File(PATH));
        //choose(new File("/Users/abyss/workspace/JavaDataStructs/RANDOM.txt"));
        System.out.println(map);
    }

    public static String choose(File f) throws FileNotFoundException
    {
        String result = null;
        Random rand = new Random();
        int n = 0;
        for(Scanner sc = new Scanner(f); sc.hasNext(); )
        {
            ++n;
            String line = sc.nextLine();
            System.out.print(n + ", " + rand.nextInt(n));
            int r = rand.nextInt(n);
            if(r == n)
                result = line;
        }

        return result;
    }

    public static String random(File f) throws  IOException {
        String result = null;
        String line = null;
        Random rand = new Random();
        BufferedReader br = new BufferedReader(new FileReader(f));
        int n = 0;
        while((line = br.readLine()) != null) {
            n++;
            if(rand.nextInt(n) == 0)
                result = line;
        }
        return result;
    }

    public static String[] randomK(File f, int k) throws  IOException {
        String[] result = new String[k];
        String line = null;
        Random rand = new Random();
        BufferedReader br = new BufferedReader(new FileReader(f));
        int n = 0;
        while((line = br.readLine()) != null) {
            n++;
            if(rand.nextInt(n) < k)
                result[rand.nextInt(k)] = line;
        }
        return result;
    }
}

