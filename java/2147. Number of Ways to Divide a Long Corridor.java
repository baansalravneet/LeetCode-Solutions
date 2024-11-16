/*
* S = seat
* P = plant
* each section will have exactly 2 seats with any number of plants
* return the number of way you can divide the corridor
*/
class Solution {
    private static final int MOD = 1_000_000_007;
    public int numberOfWays(String corridor) {
        List<Integer> segment = new ArrayList<>();
        int seatCount = 0;
        int index = 0;
        while (index < corridor.length()) {
            char c = corridor.charAt(index);
            if (c == 'S') {
                seatCount++;
            }
            index++;
            if (seatCount > 0 && seatCount % 2 == 0) {
                int plants = 0;
                while (index < corridor.length() && corridor.charAt(index) == 'P') {
                    plants++;
                    index++;
                }
                segment.add(plants+1);
            }
        }
        if (seatCount == 0 || seatCount % 2 != 0) return 0;
        long answer = 1;
        for (int i = 0; i < segment.size() - 1; i++) {
            answer *= segment.get(i);
            answer %= MOD;
        }
        return (int)answer;
    }
}
