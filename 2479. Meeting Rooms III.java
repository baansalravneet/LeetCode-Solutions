class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Long> unoccupiedRooms = new PriorityQueue<>();
        int[] freq = new int[n];
        for (int i = 0; i < n; i++) {
            unoccupiedRooms.add((long)i);
        }
        PriorityQueue<long[]> ongoingMeetings = new PriorityQueue<>((a,b) -> {
            if (a[1] == b[1]) return (int)(a[2] - b[2]);
            if (a[1] < b[1]) return -1;
            else return 1;
        });
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        for (int[] meeting : meetings) {
            while (!ongoingMeetings.isEmpty() && ongoingMeetings.peek()[1] <= meeting[0]) {
                unoccupiedRooms.add(ongoingMeetings.poll()[2]);
            }
            if (!unoccupiedRooms.isEmpty()) {
                long room = unoccupiedRooms.poll();
                ongoingMeetings.add(new long[] {meeting[0], meeting[1], room});
                freq[(int)room]++;
                continue;
            }
            long[] endingMeeting = ongoingMeetings.poll();
            ongoingMeetings.add(new long[] {endingMeeting[1], endingMeeting[1]+meeting[1]-meeting[0], endingMeeting[2]});
            freq[(int)endingMeeting[2]]++;
        }
        int max = 0;
        int answer = -1;
        for (int i = 0; i < n; i++) {
            if (max < freq[i]) {
                answer = i;
                max = freq[i];
            }
        }
        return answer;
    }
}


