class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Fint MaxFreq
        // Number of ele have that MaxFreq
        // Formula = (MaxFreq - 1) * (n+1) + NumberOfMax
        // Formula breakdown: tasks = [A,A,A,B,B,B] | n = 2
        // - (MaxFreq - 1) = Number of Gap (excludinglast) = A _ _ A _ _ A
        // - (n+1) = Size of Gap = n+1 = 3

        // Finding MaxFreq
        int[] freqArr = new int[26];
        int maxFreq = 0;
        for (char curr : tasks) {
            freqArr[curr - 'A']++;
            maxFreq = Math.max(maxFreq, freqArr[curr - 'A']);
        }

        // Finding numberOfMax
        int numOfMax = 0;
        for (int freq : freqArr) {
            if (freq == maxFreq)
                numOfMax++;
        }

        return Math.max(tasks.length, ((maxFreq - 1) * (n + 1)) + numOfMax);
    }
}
