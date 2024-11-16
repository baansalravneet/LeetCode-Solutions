class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 1) return new ArrayList<>(Arrays.asList(0, 1));
        List<Integer> result = grayCode(n-1);
        int add = (int)Math.pow(2, n-1);
        int size = result.size();
        for (int i = 0; i < size; i++) {
            result.add(result.get(size-1-i) + add);
        }
        return result;
    }
}

