class LUPrefix {

    boolean[] uploaded;
    int longest;

    public LUPrefix(int n) {
        uploaded = new boolean[n];
        longest = 0;
    }
    
    public void upload(int video) {
        uploaded[video-1] = true;
    }
    
    public int longest() {
        while (longest < uploaded.length && uploaded[longest] == true) {
            longest++;
        }
        return longest;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */
