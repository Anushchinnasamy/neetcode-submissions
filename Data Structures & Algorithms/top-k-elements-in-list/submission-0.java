class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num , 0) +1);
        }

        List<Integer>[] buckets = new List[n+1];

        for(int i = 0 ; i <= n; i++){
            buckets[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            buckets[count].add(num);
        }

        int[] result = new int[k];
        int idx = 0;

        for(int i = n ; i >=1 && idx < k; i--){
            for(int num : buckets[i]){
                result[idx++] = num;
                if(idx == k){
                    break;
                }
            }
        }
        return result;
    }
}
