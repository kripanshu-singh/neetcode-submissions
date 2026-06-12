class Solution {
    public int[][] kClosest(int[][] points, int k) {
        class Point{
            int ind;
            int dist;
            Point(int ind, int dist){
                this.ind = ind;
                this.dist = dist;
            }
        }
        int[][] ans = new int[k][2];
        Queue<Point> maxi = new PriorityQueue<>((a,b)->Integer.compare(b.dist,a.dist));
        for(int i = 0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = (x*x) + (y*y);
            Point curr = new Point(i,dist);
            if(maxi.size()>=k){
                if(maxi.peek().dist>dist){
                    maxi.poll();
                    maxi.offer(curr);
                }
                else{
                    continue;
                }
            }else{
                maxi.offer(curr);
            }
        }
       int idx = 0;
        while (!maxi.isEmpty()) {
            ans[idx++] = points[maxi.poll().ind];
        }
        return ans;
    }
}