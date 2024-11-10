class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftSide = new PriorityQueue<>();
        PriorityQueue<Integer> rightSide = new PriorityQueue<>();
        int left = 0;
        int right = costs.length-1;
        while (left <= right && candidates > 0) {
            if (left == right) {
                leftSide.add(costs[left++]);
                continue;
            }
            leftSide.add(costs[left++]);
            rightSide.add(costs[right--]);
            candidates--;
        }
        long answer = 0;
        while (k-- > 0) {
            int current = Integer.MAX_VALUE;
            if (!leftSide.isEmpty() && !rightSide.isEmpty()) {
                if (leftSide.peek() <= rightSide.peek()) {
                    answer += leftSide.poll();
                    if (left <= right) {
                        leftSide.add(costs[left++]);
                    }
                } else {
                    answer += rightSide.poll();
                    if (left <= right) {
                        rightSide.add(costs[right--]);
                    }
                }
            } else if (leftSide.isEmpty()) {
                answer += rightSide.poll();
                if (left <= right) {
                    rightSide.add(costs[right--]);
                }
            } else {
                answer += leftSide.poll();
                if (left <= right) {
                    leftSide.add(costs[left++]);
                }
            }
        }
        return answer;
    }
}