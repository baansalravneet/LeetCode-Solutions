class Solution {
    public long dividePlayers(int[] skill) {
        int total = 0;
        for (int i : skill) {
            total += i;
        }
        int n = skill.length;
        if (total % (n/2) != 0) return -1L;
        int teamSum = total / (n/2);
        Arrays.sort(skill);
        long answer = 0;
        for (int i = 0; i < n/2; i++) {
            if (skill[i] + skill[n-1-i] != teamSum) return -1L;
            answer += skill[i] * skill[n-1-i];
        }
        return answer;
    }
}
