class Solution {
    public int compress(char[] chars) {
        int pointer = 0;
        for (int i = 0; i < chars.length; ) {
            char rep = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == rep) {
                i++;
                count++;
            }
            chars[pointer++] = rep;
            if (count > 1) {
                int index = pointer;
                while (count != 0) {
                    int value = count % 10;
                    chars[pointer++] = (char)((int)'0' + value);
                    count /= 10;
                }
                reverse(chars, index, pointer-1);
            }
        }
        return pointer;
    }
    private void reverse(char[] chars, int a, int b) {
        while (a < b) {
            char temp = chars[a];
            chars[a] = chars[b];
            chars[b] = temp;
            a++;
            b--;
        }
    }
}
