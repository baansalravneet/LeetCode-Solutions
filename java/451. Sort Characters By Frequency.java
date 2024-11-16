class Solution {
    public String frequencySort(String s) {
        List<Character> arr = s.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        int[] freq = new int[255];
        for (char c : arr) {
            freq[c]++;
        }
        Collections.sort(arr, (a,b) -> {
            if (freq[a] == freq[b]) {
                return a-b;
            }
            return freq[b] - freq[a];
        });
        return arr.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
