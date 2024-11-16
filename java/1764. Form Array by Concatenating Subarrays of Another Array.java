class Solution {
    public boolean canChoose(int[][] g, int[] n) {
        String[] groups = new String[g.length];
        for (int i = 0; i < g.length; i++)  {
            groups[i] = getString(g[i]);
        }
        String nums = getString(n);
        int previousEnd = -1;
        for (int i = 0; i < groups.length; i++) {
            int index = nums.indexOf(groups[i], previousEnd);
            if (index == -1 || index <= previousEnd) return false;
            if (index != 0 && Character.isDigit(nums.charAt(index-1))) {
                i--;
                previousEnd++;
                continue;
            }
            previousEnd = index + groups[i].length();
        }
        return true;
    }
    private String getString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length-1; i++) {
            sb.append(arr[i]+ ",");
        }
        sb.append(arr[arr.length-1]);
        return sb.toString();
    }
}
