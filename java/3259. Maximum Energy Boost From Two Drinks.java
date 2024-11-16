class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        Long[][] cache = new Long[energyDrinkA.length][2];
        return Math.max(
                helper(energyDrinkA, energyDrinkB, 0, 0, cache),
                helper(energyDrinkA, energyDrinkB, 0, 1, cache)
            );
    }
    private long helper(int[] arr1, int[] arr2, int index, int first, Long[][] cache) {
        if (index >= arr1.length) return 0;
        if (cache[index][first] != null) return cache[index][first];
        long answer = first == 0 ? arr1[index] : arr2[index];
        return cache[index][first] = answer + Math.max(
                helper(arr1, arr2, index+1, first, cache),
                helper(arr1, arr2, index+2, 1-first, cache)
            );
    }
}

