class TimeMap {
    class Pair {
        int time;
        String value;
        Pair(int time, String value) {
            this.time = time;
            this.value = value;
        }
    }
    HashMap<String, List<Pair>> map = new HashMap<>();
    public TimeMap() {}

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        List<Pair> temp = map.get(key);
        temp.add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        String ans = "";
            if(!map.containsKey(key))return ans;
        List<Pair> pairs = map.get(key);
        int start = 0;
        int end = pairs.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            Pair currPair = pairs.get(mid);
            if (currPair.time == timestamp) {
                return currPair.value;
            } else if (currPair.time < timestamp) {
                ans = currPair.value;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
