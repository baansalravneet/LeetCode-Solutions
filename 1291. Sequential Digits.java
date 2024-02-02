class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> fullList = getFullList();
        List<Integer> answer = new ArrayList<>();
        for (int i : fullList) {
            if (i >= low && i <= high) {
                answer.add(i);
            }
        }
        Collections.sort(answer);
        return answer;
    }
    private List<Integer> getFullList() {
        List<Integer> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            helper(answer, String.valueOf(i));
        }
        return answer;
        // return List.of(
        //         1,2,3,4,5,6,7,8,9,12,23,34,45,56,67,78,
        //         89,123,234,345,456,567,678,789,1234,2345,
        //         3456,4567,5678,6789,12345,23456,34567,
        //         45678,56789,123456,234567,345678,456789,
        //         1234567,2345678,3456789,12345678,23456789,123456789
        // );
    }
    private void helper(List<Integer> answer, String current) {
        long value = Long.parseLong(current.toString());
        if (value > Integer.MAX_VALUE) return;
        else answer.add((int)value);
        char next = (char)((int)current.charAt(current.length()-1)+1);
        if (next == ':') return;
        helper(answer, current+next);
    }
}
