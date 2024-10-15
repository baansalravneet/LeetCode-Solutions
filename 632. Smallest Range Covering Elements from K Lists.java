class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        List<Entry> arr = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                arr.add(new Entry(nums.get(i).get(j), i));
            }
        }
        Collections.sort(arr, (a,b) -> a.value - b.value);
        Map<Integer, Integer> counts = new HashMap<>();
        int value = Integer.MAX_VALUE;
        int[] answer = new int[2];
        for (int left = 0, right = 0; right < arr.size(); right++) {
            int list = arr.get(right).list;
            counts.put(list, counts.getOrDefault(list, 0) + 1);
            while (left <= right && counts.size() == k) {
                if (value > arr.get(right).value - arr.get(left).value) {
                    answer[0] = arr.get(left).value;
                    answer[1] = arr.get(right).value;
                    value = arr.get(right).value - arr.get(left).value;
                }
                if (counts.get(arr.get(left).list) == 1) counts.remove(arr.get(left).list);
                else counts.put(arr.get(left).list, counts.get(arr.get(left).list) - 1);
                left++;
            }
        }
        return answer;
    }
}

class Entry {
    int value;
    int list;
    Entry(int value, int list) {
        this.value = value;
        this.list = list;
    }
}
