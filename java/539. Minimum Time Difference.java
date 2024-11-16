class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> nums = new ArrayList<>();
        for (String i : timePoints) {
            nums.add(getNum(i));
        }
        Collections.sort(nums);
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < nums.size(); i++) {
            answer = Math.min(answer, nums.get(i) - nums.get(i-1));
        }
        answer = Math.min(answer, nums.get(0) + 24*60 - nums.get(nums.size()-1));
        return answer;
    }
    private int getNum(String time) {
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3,5));
        return hour * 60 + minute;
    }
}
