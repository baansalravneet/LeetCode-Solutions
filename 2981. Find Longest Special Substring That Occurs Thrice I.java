class Solution {
    public int maximumLength(String s) {
        List<List<Integer>> counts = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            counts.add(new ArrayList<>());
        }
        int answer = -1;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            int count = 0;
            while (i < s.length() && s.charAt(i) == c) {
                freq[c-'a']++;
                count++;
                i++;
            }
            if (count >= 3) {
                answer = Math.max(answer, count - 2);
            }
            counts.get(c-'a').add(count);
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] < 3) {
                continue;
            }
            answer = Math.max(answer, findThird(counts.get(i)));
        }
        return answer;
    }

    private int findThird(List<Integer> count) {
        int a = -1, b = -1, c = -1;
        for (int i : count) {
            if (i > a) {
                c = b;
                b = a;
                a = i;
            } else if (i > b) {
                c = b;
                b = i;
            } else if (i > c) {
                c = i;
            }
        }
        int answer1 = a > 3 ? a-2 : -1;
        int answer2 = b > -1 ? Math.min(a-1, b) : -1;
        int answer3 = c > -1 ? c : -1;
        return Math.max(answer1, Math.max(answer2, answer3));
    }
}

