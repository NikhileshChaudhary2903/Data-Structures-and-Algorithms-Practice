package com.company.dynamicProgramming;

public class LCS {


    public static int lcs(String x,String y) {

        int dp[][] = new int[x.length() + 1][y.length() + 1];

        for(int i = 0;i < dp.length ;i++) {

            for(int j = 0; j < dp[i].length;j++) {

                if(i == 0 || j == 0) continue;

                else if(x.charAt( i - 1 ) == y.charAt( j - 1 )) {
                    dp[i][j] = 1 + dp[ i - 1 ] [ j- 1 ];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }

        int i = x.length(), j = y.length();
        StringBuilder sb = new StringBuilder();

        while( i > 0 && j > 0) {

            if(x.charAt(i - 1) == y.charAt(j - 1))
            {
               sb.insert(0,x.charAt(i-1));
               i--;
               j--;
            }
            else {
                int upper = dp[i - 1][j];
                int left = dp[i][j - 1];

                if(upper > left)
                    i--;
                else
                    j--;
            }
        }

        System.out.println(sb.toString());
        return dp[x.length()][y.length()];
    }

    public static void main(String args[]) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println(lcs(s1,s2));
    }


}
