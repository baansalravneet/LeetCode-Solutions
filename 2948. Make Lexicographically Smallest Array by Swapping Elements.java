class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new int[] {nums[i], i});
        }
        Collections.sort(arr, (a,b) -> a[0] - b[0]);
        List<List<int[]>> groups = breakIntoGroups(arr, limit);
        int[] result = new int[n];
        for (int g = 0; g < groups.size(); g++) {
            List<int[]> group = groups.get(g);
            List<Integer> indexes = new ArrayList<>();
            for (int[] i : group) {
                indexes.add(i[1]);
            }
            Collections.sort(indexes);
            int index = 0;
            for (int[] i : group) {
                result[indexes.get(index++)] = i[0];
            }
        }
        return result;
    }
    private List<List<int[]>> breakIntoGroups(List<int[]> arr, int limit) {
        List<List<int[]>> result = new ArrayList<>();
        int i = 0;
        while (i < arr.size()) {
            List<int[]> group = new ArrayList<>();
            int[] current = arr.get(i++);
            group.add(current);
            while (i < arr.size() &&  arr.get(i)[0] - group.get(group.size()-1)[0] <= limit) {
                group.add(arr.get(i));
                i++;
            }
            result.add(group);
        }
        return result;
    }
}
