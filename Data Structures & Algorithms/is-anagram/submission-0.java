class Solution {
    public boolean isAnagram(String s, String t) {

        int n = s.length();
        int m = t.length();

        if(n != m){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0 ; i < n; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) +1);
        }

        for(int i = 0; i < m; i++){
            char ch = t.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) -1);

            if(map.get(ch) < 0){
                return false;
            }
        }

        return true;
    }
}
