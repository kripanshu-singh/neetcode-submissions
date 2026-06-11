class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1)
            return stones[0];
        Queue<Integer> mini = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int num : stones) {
            mini.offer(num);
        }
        while (mini.size() - 1 != 0) {
            int a = mini.poll();
            int b = mini.poll();
            if (a == b) {
                if (mini.size() == 0)
                    return 0;
                continue;
            } else {
                mini.offer(Math.abs(a - b));
            }
        }
        return mini.poll();
    }
}
