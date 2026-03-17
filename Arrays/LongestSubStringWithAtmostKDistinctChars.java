class Solution{
public int longestSubStringWithAtmostKDistinctChars(int k, String s) {
        int ans = 0;
        int i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        if(k == 0) return 0;

        while (j < s.length()) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if(map.size() <= k) {
                ans = Math.max(ans, j - i + 1);
            }
            else if (map.size() > k) {
                while (map.size() > k) {
                    char ch1 = s.charAt(i);
                    map.put(ch1, map.get(ch1) - 1);
                    if (map.get(ch1) == 0)
                        map.remove(ch1);
                    i++;
                }
                ans = Math.max(ans, j - i + 1);
            }
            j++;
        }

        return ans;
    }
}
