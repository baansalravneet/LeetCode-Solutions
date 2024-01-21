class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        Character[] arr = new Character[word.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = word.charAt(i);
        }
        for (char c : arr) {
            freq[c-'a']++;
        }
        Arrays.sort(arr, (a,b) -> freq[b-'a'] - freq[a-'a']);
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();
        Set<Character> set4 = new HashSet<>();
        int count = 0;
        for (char c : arr) {
            if (set1.contains(c)) {
                count = count+1;
                continue;
            } else {
                if (set1.size() < 8) {
                    set1.add(c);
                    count = count+1;
                    continue;
                }
            }
            if (set2.contains(c)) {
                count = count+2;
                continue;
            } else {
                if (set2.size() < 8) {
                    set2.add(c);
                    count = count+2;
                    continue;
                }
            }
            if (set3.contains(c)) {
                count = count+3;
                continue;
            } else {
                if (set3.size() < 8) {
                    set3.add(c);
                    count = count+3;
                    continue;
                }
            }
            if (set4.contains(c)) {
                count = count+4;
            } else {
                set4.add(c);
                count = count + 4;
            }
        }
        return count;
    }
}

