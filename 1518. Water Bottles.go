func numWaterBottles(numBottles int, numExchange int) int {
    return helper(numBottles, numExchange, 0)
}

func helper(numBottles, numExchange, empty int) int {
    if numBottles == 0 && empty < numExchange {
        return 0
    }
    if numBottles > 0 {
        return numBottles + helper(0, numExchange, empty+numBottles)
    }
    return helper(empty/numExchange, numExchange, empty % numExchange)
}
