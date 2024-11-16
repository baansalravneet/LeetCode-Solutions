class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int hc = 1;
        int vc = 1;
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int i = horizontalCut.length-1;
        int j = verticalCut.length-1;
        int answer = 0;
        while (i >= 0 || j >= 0) {
            if (j >= 0 && (i < 0 || horizontalCut[i] < verticalCut[j])) {
                vc++;
                answer += hc * verticalCut[j--];
            } else {
                hc++;
                answer += vc * horizontalCut[i--];
            }
        }
        return answer;
    }
}