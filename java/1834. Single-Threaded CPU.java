class Solution {
    public int[] getOrder(int[][] tasks) {
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        Collections.sort(taskList, (a,b) -> {
            if (a.enqueTime != b.enqueTime) return a.enqueTime - b.enqueTime;
            if (a. processingTime != b.processingTime) return a.processingTime - b.processingTime;
            return a.index - b.index;
        });

        PriorityQueue<Task> heap = new PriorityQueue<>((a,b) -> {
            if (a.processingTime != b.processingTime) return a.processingTime - b.processingTime;
            return a.index - b.index;
        });
        int currentTime = taskList.get(0).enqueTime;
        int[] result = new int[tasks.length];
        int resultIndex = 0;
        int i = 0;

        while (!heap.isEmpty() || i < taskList.size()) {
            while (i < taskList.size() && taskList.get(i).enqueTime <= currentTime) {
                heap.add(taskList.get(i));
                i++;
            }
            if (heap.isEmpty()) {
                currentTime = taskList.get(i).enqueTime;
                continue;
            }
            Task currentTask = heap.poll();
            result[resultIndex++] = currentTask.index;
            currentTime += currentTask.processingTime;
        }
        return result;
    }
}

class Task {
    int index;
    int enqueTime;
    int processingTime;
    Task(int index, int enqueTime, int processingTime) {
        this.index = index;
        this.enqueTime = enqueTime;
        this.processingTime = processingTime;
    }
}
