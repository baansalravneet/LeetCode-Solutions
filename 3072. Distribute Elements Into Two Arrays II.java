class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> sortedList1 = new ArrayList<>();
        List<Integer> sortedList2 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        insert(nums[0], list1, sortedList1);
        insert(nums[1], list2, sortedList2);
        for (int i = 2; i < nums.length; i++) {
            int g1 = getGreater(nums[i], sortedList1);
            int g2 = getGreater(nums[i], sortedList2);
            if (g1 < g2) insert(nums[i], list2, sortedList2);
            else if (g1 > g2) insert(nums[i], list1, sortedList1);
            else {
                if (list1.size() <= list2.size()) insert(nums[i], list1, sortedList1);
                else insert(nums[i], list2, sortedList2);
            }
        }
        int[] result = new int[nums.length];
        int index = 0;
        for (int i : list1) result[index++] = i;
        for (int i : list2) result[index++] = i;
        return result;
    }
    private int getGreater(int val, List<Integer> list) {
        int left = 0;
        int right = list.size()-1;
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > val) {
                answer = list.size() - mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    private void insert(int val, List<Integer> list, List<Integer> sortedList) {
        list.add(val);
        if (sortedList.isEmpty() || sortedList.get(sortedList.size()-1) <= val) {
            sortedList.add(val);
            return;
        }
        int index = Collections.binarySearch(sortedList, val);
        if (index < 0) index = - index - 1;
        sortedList.add(index, val);
    }
}

