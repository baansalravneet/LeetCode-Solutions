class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) return 1;
        int[] allocations = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            pq.add(new int[] {ratings[i], i});
        }
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int index = current[1];
            if (index == 0) {
                if (allocations[index+1] == 0) allocations[index] = 1;
                else if (ratings[index] == ratings[index]+1) allocations[index] = 1;
                else allocations[index] = allocations[index+1] + 1;
            } else if (index == n-1) {
                if (allocations[index-1] == 0) allocations[index] = 1;
                else if (ratings[index] == ratings[index-1]) allocations[index] = 1;
                else allocations[index] = allocations[index-1] + 1;
            } else {
                if (allocations[index-1] == 0 && allocations[index+1] == 0) allocations[index] = 1;
                else if (allocations[index-1] == 0 && allocations[index+1] != 0) {
                    if (ratings[index+1] == ratings[index]) allocations[index] = 1;
                    else allocations[index] = allocations[index+1] + 1;
                } else if (allocations[index+1] == 0 && allocations[index-1] != 0) {
                    if (ratings[index-1] == ratings[index]) allocations[index] = 1;
                    else allocations[index] = allocations[index-1] + 1;
                } else {
                    if (ratings[index+1] == ratings[index] && ratings[index-1] == ratings[index]) allocations[index] = 1;
                    else {
                        if (ratings[index+1] == ratings[index]) {
                            allocations[index] = allocations[index+1];
                            allocations[index] = Math.max(allocations[index], allocations[index-1]+1);
                        } else if (ratings[index-1] == ratings[index]) {
                            allocations[index] = allocations[index+1];
                            allocations[index] = Math.max(allocations[index], allocations[index+1]+1);
                        } else {
                            allocations[index] = Math.max(allocations[index+1], allocations[index-1]) + 1;
                        }
                    }
                }
            }
        }
        int answer = 0;
        for (int i : allocations) answer += i;
        return answer;
    }
}


