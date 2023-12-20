class Solution {
    public String rankTeams(String[] votes) {
        int[][] voteCount = new int[26][26]; // for i, jth rank count
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                int character = vote.charAt(i)-'A';
                voteCount[character][i]++;
            }
        }
        List<Character> result = new ArrayList<>();
        for (char c : votes[0].toCharArray()) {
            result.add(c);
        }
        Collections.sort(result, (a,b) -> {
            for (int i = 0; i < 26; i++) {
                if (voteCount[a-'A'][i] != voteCount[b-'A'][i]) {
                    return voteCount[b-'A'][i] - voteCount[a-'A'][i];
                }
            }
            return a-b;
        });
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }
        return sb.toString();
    }
}
