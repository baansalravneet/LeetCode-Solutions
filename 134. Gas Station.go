func canCompleteCircuit(gas []int, cost []int) int {
    totalGas := 0
    totalCost := 0
    for i := range gas {
        totalGas += gas[i]
        totalCost += cost[i]
    }
    if totalGas < totalCost {
        return -1
    }
    start := 0
    current := 0
    for i := range gas {
        current += gas[i]
        current -= cost[i]
        if current < 0 {
            start = i+1
            current = 0
        }
    }
    return start%len(gas)
}
