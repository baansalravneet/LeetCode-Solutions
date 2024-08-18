func maxEnergyBoost(energyDrinkA []int, energyDrinkB []int) int64 {
    cache := make([][]int64, len(energyDrinkA))
    for i := range cache {
        cache[i] = make([]int64, 2)
        for j := range cache[i] {
            cache[i][j] = -1
        }
    }
    return max(helper(energyDrinkA, energyDrinkB, 0, 0, cache), helper(energyDrinkA, energyDrinkB, 0, 1, cache))
}

func helper(arr1, arr2 []int, index, first int, cache [][]int64) int64 {
    if index >= len(arr1) { return 0 }
    if cache[index][first] != -1 {
        return cache[index][first]
    }
    var answer int64
    if first == 0 {
        answer = int64(arr1[index])
    } else {
        answer = int64(arr2[index])
    }
    cache[index][first] = answer + max(helper(arr1, arr2, index+1, first, cache), helper(arr1, arr2, index+2, 1-first, cache))
    return cache[index][first]
}

