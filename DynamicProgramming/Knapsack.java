package com.company.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    public static int knapsack(int price[],int weight[],int w) {

        int dp[][] = new int[price.length + 1][w + 1];

        for(int i = 0; i < dp.length;i++) {

            for(int j = 0; j < dp[i].length;j++) {

                if(i == 0 || j == 0)
                continue;

                if(j >= weight[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i - 1][j - weight[i - 1] ]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        int j = w, i = price.length;
        List<Integer> list = new ArrayList<>();

        while( i > 0 && j > 0) {

            if(dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                list.add(0,i - 1 );
                j-= weight[i - 1];
                i--;
            }
        }

        System.out.println(list);
        return dp[price.length][w];

    }


    public static void main(String args[]) {

    int w = 8;
    int price[] = {0,1,2,5,6};
    int weight[]= {0,2,3,4,5};

    System.out.println(knapsack(price,weight,w));


    }



}
