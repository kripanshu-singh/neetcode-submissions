class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int ans = 0;
        for(int num:nums){
            // check for the last element of seq
            int count = 0;
            if(!set.contains(num-1)){
                while(set.contains(num)){
                    num++;
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
