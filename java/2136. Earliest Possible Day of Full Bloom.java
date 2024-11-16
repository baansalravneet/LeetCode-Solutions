class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<SeedInfo> list = new ArrayList<>();
        for (int i = 0; i < plantTime.length; i++) {
            list.add(new SeedInfo(plantTime[i], growTime[i]));
        }
        Collections.sort(list, (a,b) -> {
            if (b.gt == a.gt) {
                return a.pt - b.pt;
            }
            return b.gt - a.gt;
        });
        int answer = Integer.MIN_VALUE;
        int currentDay = 0;
        for (SeedInfo i : list) {
            answer = Math.max(answer, currentDay + i.pt + i.gt);
            currentDay += i.pt;
        }
        return answer;
    }
}

class SeedInfo {
    int pt;
    int gt;
    SeedInfo(int pt, int gt) {
        this.pt = pt;
        this.gt = gt;
    }
}
