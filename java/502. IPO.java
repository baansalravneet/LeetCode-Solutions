class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> profitHeap = new PriorityQueue<>((a,b) -> b.profit - a.profit);
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            projects.add(new Project(profits[i], capital[i]));
        }
        Collections.sort(projects, (a,b) -> a.capital - b.capital);
        int answer = w;
        for (int i = 0; i < projects.size() && k > 0; i++) {
            if (projects.get(i).capital <= w) {
                profitHeap.add(projects.get(i));
                continue;
            } else {
                i--;
            }
            if (profitHeap.isEmpty()) break;
            Project current = profitHeap.poll();
            answer += current.profit;
            w += current.profit;
            k--;
        }
        while (!profitHeap.isEmpty() && k > 0) {
            Project current = profitHeap.poll();
            answer += current.profit;
            w -= current.capital;
            w += current.profit;
            k--;
        }
        return answer;
    }
}

class Project {
    int profit;
    int capital;
    Project (int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}
