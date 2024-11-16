class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int answer = 0;
        int empty = 0;
        while (numBottles > 0) {
            answer += numBottles;
            empty += numBottles;
            numBottles = 0;
            while (empty >= numExchange) {
                numBottles += 1;
                empty -= numExchange;
                numExchange += 1;
            }
        }
        return answer;
    }
}