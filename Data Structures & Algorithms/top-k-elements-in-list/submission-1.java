class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a,b)->Integer.compare(freq.get(a),freq.get(b))
        );
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : freq.keySet()) {
            heap.add(num);

            if (heap.size() > k)
                heap.poll();
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}