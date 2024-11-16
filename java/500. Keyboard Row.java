class Solution {
    private static final Set<Character> firstRow = new HashSet<>(Arrays.asList(
            'q','w','e','r','t','y','u','i','o','p',
            'Q','W','E','R','T','Y','U','I','O','P'
        ));

    private static final Set<Character> secondRow = new HashSet<>(Arrays.asList(
            'a','s','d','f','g','h','j','k','l',
            'A','S','D','F','G','H','J','K','L'
        ));
    private static final Set<Character> thirdRow = new HashSet<>(Arrays.asList(
            'z','x','c','v','b','n','m',
            'Z','X','C','V','B','N','M'
        ));
    public String[] findWords(String[] words) {
        return Arrays.stream(words)
            .filter(word -> check(word, firstRow) || check(word, secondRow) || check(word, thirdRow))
            .toArray(String[]::new);
    }
    private boolean check(String word, Set<Character> set) {
        word.chars().allMatch(c -> set.contains((char) c));
    }
}
