class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] startBloom = new int[n];
        int[] endBloom = new int[n];
        for (int i = 0; i < n; i++) {
            startBloom[i] = flowers[i][0];
            endBloom[i] = flowers[i][1];
        }
        Arrays.sort(startBloom);
        Arrays.sort(endBloom);

        int[] answer = new int[people.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = findAnswer(startBloom, endBloom, people[i]);
        }
        return answer;
    }
    private int findAnswer(int[] startBloom, int[] endBloom, int time) {
        int startIndex = findSmaller(startBloom, time, true);
        int endIndex = findSmaller(endBloom, time, false);

        // number of flowers which have started to bloom before and on time
        if (startIndex == -1) { // no flower has started to bloom
            return 0;
        }
        int started = startIndex + 1;

        // number of flowers which have ended blooming before time
        if (endIndex == -1) { // no flower has withered
            return started;
        }
        int ended = endIndex + 1;

        return started - ended;
    }

    // find the index of the largest value less than or equal to k
    private int findSmaller(int[] arr, int k, boolean equal) {
        int left = 0;
        int right = arr.length-1;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (equal) {
                if (arr[mid] <= k) {
                    answer = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (arr[mid] < k) {
                    answer = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return answer;
    }
}
