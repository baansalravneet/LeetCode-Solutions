class Solution {
    public int countPairs(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> freq = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> swaps = getAll(nums[i]);
            Set<Integer> total = new HashSet<>();
            for (int j : swaps) {
                for (int k : getAll(j)) {
                    total.add(k);
                }
            }
            for (int j : total) {
                answer += freq.getOrDefault(j, 0);
            }
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        return answer;
    }
    private Set<Integer> getAll(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        Set<Integer> possible = new HashSet<>();
        possible.add(num);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                possible.add(Integer.parseInt(String.valueOf(arr)));
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return possible;
    }
}
