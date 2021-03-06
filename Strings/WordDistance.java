package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class WordDistance {

    HashMap<String, ArrayList<Integer>> map;

    public WordDistance(String[] words) {

        this.map = new HashMap<>();

        for(int i = 0;i<words.length;i++) {

            if(map.containsKey(words[i]))
            map.get(words[i]).add(i);
            else {
                map.put(words[i],new ArrayList<>());
                map.get(words[i]).add(i);
            }
        }

    }

    public int shortest(String word1, String word2) {

        ArrayList<Integer> l1 = map.get(word1);
        ArrayList<Integer> l2 = map.get(word2);

        int result = Integer.MAX_VALUE;
        int i=0;
        int j=0;
        while(i<l1.size() && j<l2.size()){
            result = Math.min(result, Math.abs(l1.get(i)-l2.get(j)));
            if(l1.get(i)<l2.get(j)){
                i++;
            }else{
                j++;
            }
        }

        return result;

    }
     public static int shortestDistance(String[] words, String word1, String word2) {

        int m = -1,n = -1,min = Integer.MAX_VALUE;

        for(int i = 0;i<words.length;i++) {

            if(word1.equals(words[i]))
            {
                m = i;

                if(n!=-1)
                  min = Math.min(min,m-n);

            } else if(word2.equals(words[i])) {

                n = i;

                if(m!=-1)
                    min = Math.min(min,n-m);
            }
        }
            return min;
    }
}
