class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> sandwichQueue = new LinkedList<>();
        Deque<Integer> studentQueue = new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            studentQueue.add(students[i]);
            sandwichQueue.add(sandwiches[i]);
        }
        while (!studentQueue.isEmpty() && count < studentQueue.size()) {
            if (studentQueue.peek() == sandwichQueue.peek()) {
                studentQueue.poll();
                sandwichQueue.poll();
                count = 0;
            } else {
                studentQueue.add(studentQueue.poll());
                count++;
            }
        }
        return studentQueue.size();
    }
}