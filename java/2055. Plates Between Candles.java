class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] prefix = getPrefix(s);
        List<Integer> candleIndexes = getCandleIndexes(s);
        int[] result = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            int left = q[0];
            int right = q[1];
            int leftMost = findCandle(candleIndexes, left, right, true);
            int rightMost = findCandle(candleIndexes, left, right, false);
            if (leftMost == -1) {
                i++;
                continue;
            }
            result[i++] = prefix[rightMost] - prefix[leftMost];
        }
        return result;
    }

    private List<Integer> getCandleIndexes(String s) {
        List<Integer> answer = new ArrayList<>();
        for (int x = 0; x < s.length(); x++) {
            if (s.charAt(x) == '|') answer.add(x);
        }
        return answer;
    }

    private int[] getPrefix(String s) {
        int n = s.length();
        int[] prefix = new int[n];
        int index = 0;
        while (index < n && s.charAt(index) == '*') {
            index++;
        }
        index++;
        int currentCount = 0;
        while (index < n) {
            if (s.charAt(index) == '*') {
                prefix[index] = prefix[index-1];
                currentCount++;
            } else {
                prefix[index] = currentCount + prefix[index-1];
                currentCount = 0;
            }
            index++;
        }
        return prefix;
    }

    private int findCandle(List<Integer> indexes, int left, int right, boolean leftMost) {
        int low = 0;
        int high = indexes.size()-1;
        int answer = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (indexes.get(mid) > right) {
                high = mid - 1;
                continue;
            }
            if (indexes.get(mid) < left) {
                low = mid + 1;
                continue;
            }
            answer = indexes.get(mid);
            if (leftMost) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}
