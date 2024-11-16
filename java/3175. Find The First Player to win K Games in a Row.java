class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        Deque<Player> queue = new ArrayDeque<>();
        int highestSkill = 0;
        for (int i = 0; i < skills.length; i++) {
            queue.addLast(new Player(i, skills[i], 0));
            highestSkill = Math.max(highestSkill, skills[i]);
        }
        while (queue.peekFirst().gamesWon < k && queue.peekFirst().skill != highestSkill) {
            Player player1 = queue.pollFirst();
            Player player2 = queue.pollFirst();
            if (player1.skill > player2.skill) {
                player1.gamesWon++;
                queue.addLast(player2);
                queue.addFirst(player1);
            } else {
                player2.gamesWon++;
                queue.addLast(player1);
                queue.addFirst(player2);
            }
        }
        return queue.peekFirst().index;
    }
}

class Player {
    int index;
    int skill;
    int gamesWon;
    Player(int index, int skill, int gamesWon) {
        this.index = index;
        this.skill = skill;
        this.gamesWon = gamesWon;
    }
}
