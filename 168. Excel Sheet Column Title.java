class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int value = columnNumber % 26;
            sb.append((char) ('A' + value));
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}

