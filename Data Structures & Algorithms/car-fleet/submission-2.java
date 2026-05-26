class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            double time = (double) (target - position[i]) / speed[i];
            cars[i] = new double[] {position[i], time};
        }

        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        int fleet = 0;
        Deque<Double> stk = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            double[] currCar = cars[i];
            while (!stk.isEmpty() && stk.peek() <= currCar[1]) {
                stk.pop();
            }
            stk.push(currCar[1]);
        }
        return stk.size();
    }
}
