package com.company;

import java.util.HashMap;

public class TwoSum {

    HashMap<Integer, Integer> map = new HashMap<>();

    public void add(int number) {

        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);

        }
    }

    public boolean find(int value) {

        for(int num:map.keySet()) {

            int temp = value - num;

            if(map.containsKey(temp)) {

                // duplicate values only one of them exists ie val = 10 you have only 1 element as 5
               if(num == temp && map.get(temp) < 2)
                   continue;

               return true;
            }

        }

        return false;

    }

}
