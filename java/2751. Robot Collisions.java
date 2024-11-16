class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            robots.add(new Robot(i, positions[i], directions.charAt(i), healths[i]));
        }
        Collections.sort(robots, (a,b) -> a.position - b.position);
        Deque<Robot> stack = new ArrayDeque<>();
        loop: for (Robot r : robots) {
            if (stack.isEmpty() || r.direction == 'R') {
                stack.addLast(r);
                continue;
            }
            while (!stack.isEmpty() &&
                    stack.peekLast().direction == 'R') {
                if (stack.peekLast().health == r.health) {
                    stack.pollLast();
                    continue loop;
                } else if (stack.peekLast().health < r.health) {
                    stack.pollLast();
                    r.health -= 1;
                } else {
                    stack.peekLast().health -= 1;
                    continue loop;
                }
            }
            stack.addLast(r);
        }
        List<Robot> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pollFirst());
        }
        Collections.sort(result, (a,b) -> a.index - b.index);
        List<Integer> answer = new ArrayList();
        for (Robot r : result) {
            answer.add(r.health);
        }
        return answer;
    }
}

class Robot {
    int index;
    int position;
    char direction;
    int health;
    Robot(int index, int position, char direction, int health) {
        this.index = index;
        this.position = position;
        this.direction = direction;
        this.health = health;
    }
}