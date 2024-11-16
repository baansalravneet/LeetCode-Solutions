class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] answer = new int[queries.length];
        Data data = new Data(items);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = data.get(queries[i]);
        }
        return answer;
    }
}

class Data {
    private int[][] items;
    Data(int[][] items) {
        this.items = items;
        Arrays.sort(items, (a,b) -> a[0] - b[0]);
        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i-1][1], items[i][1]);
        }
    }
    
    int get(int price) {
        int left = 0;
        int right = items.length-1;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right)/2;
            if (items[mid][0] > price) {
                right = mid - 1;
            } else {
                answer = items[mid][1];
                left = mid + 1;
            }
        }
        return answer;
    }
}