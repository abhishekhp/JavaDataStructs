package com.dynamicprog;

/**
 * Created with IntelliJ IDEA.
 * User: abyss
 * Date: 9/13/12
 * Time: 4:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class Diff {

    public static void main(String[] args) {

        // read in lines of each file
        /*In in0 = new In(args[0]);
        In in1 = new In(args[1]);
        String[] x = in0.readAll().split("\\n");
        String[] y = in1.readAll().split("\\n");*/
        String []x = new String[10];
        String []y = new String[10];

        // number of lines of each file
        int M = x.length;
        int N = y.length;

        // opt[i][j] = length of LCS of x[i..M] and y[j..N]
        int[][] opt = new int[M+1][N+1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = M-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if (x[i].equals(y[j]))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
            }
        }

        // recover LCS itself and print out non-matching lines to standard output
        int i = 0, j = 0;
        while(i < M && j < N) {
            if (x[i].equals(y[j])) {
                i++;
                j++;
            }
            else if (opt[i+1][j] >= opt[i][j+1]) System.out.println("< " + x[i++]);
            else                                 System.out.println("> " + y[j++]);
        }

        // dump out one remainder of one string if the other is exhausted
        while(i < M || j < N) {
            if      (i == M) System.out.println("> " + y[j++]);
            else if (j == N) System.out.println("< " + x[i++]);
        }
    }

}

