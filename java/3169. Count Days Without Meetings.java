class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        int i = 0;
        int answer = meetings[0][0] - 1;
        int end = 0;
        while (i < meetings.length) {
            end = meetings[i][1];
            while (i < meetings.length && meetings[i][0] <= end) {
                end = Math.max(end, meetings[i][1]);
                i++;
            }
            if (i < meetings.length) {
                answer += meetings[i][0] - end - 1;
            }
        }
        answer += days - end;
        return answer;
    }
}
