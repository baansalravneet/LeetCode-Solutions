class Solution {
    public int compareVersion(String version1, String version2) {
        String[] revision1 = version1.split("\\.");
        String[] revision2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < revision1.length || j < revision2.length) {
            int r1 = i < revision1.length ? Integer.parseInt(revision1[i]) : 0;
            int r2 = i < revision2.length ? Integer.parseInt(revision2[i]) : 0;
            if (r1 > r2) return 1;
            else if (r1 < r2) return -1;
            i++;
            j++;
        }
        return 0;
    }
}