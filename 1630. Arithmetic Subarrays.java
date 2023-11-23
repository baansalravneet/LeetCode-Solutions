class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> answer = new ArrayList<>();
        x: for (int i = 0; i < l.length; i++) {
            if (r[i] - l[i] <= 1) {
                answer.add(true);
            } else {
                int[] subarray = Arrays.copyOfRange(nums, l[i], r[i]+1);
                Arrays.sort(subarray);
                for (int j = 1; j < subarray.length-1; j++) {
                    if ((long)subarray[j] - subarray[j-1] != (long)subarray[j+1] - subarray[j]) {
                        answer.add(false);
                        continue x;
                    }
                }
                answer.add(true);
            }
        }
        return answer;
    }
}
