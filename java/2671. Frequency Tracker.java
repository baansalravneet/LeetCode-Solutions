class FrequencyTracker {

    private int[] numFreq;
    private int[] freqFreq;

    public FrequencyTracker() {
        numFreq = new int[100001];
        freqFreq = new int[100001];
    }

    public void add(int number) {
        int freq = numFreq[number]++;
        if (freq > 0) freqFreq[freq]--;
        freqFreq[freq+1]++;
    }

    public void deleteOne(int number) {
        if (numFreq[number] == 0) return;
        int freq = numFreq[number]--;
        freqFreq[freq]--;
        if (freq > 0) freqFreq[freq-1]++;
    }

    public boolean hasFrequency(int frequency) {
        return freqFreq[frequency] > 0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
