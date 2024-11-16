class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<int[]> fractions = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                fractions.add(new int[]{arr[i], arr[j]});
            }
        }
        Collections.sort(fractions, (a,b) -> {
            int n1 = a[0], d1 = a[1], n2 = b[0], d2 = b[1];
            return n1*d2 - n2*d1;
        });
        return fractions.get(k-1);
    }
}
