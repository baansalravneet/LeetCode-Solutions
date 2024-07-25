func sortArray(nums []int) []int {
    mergeSort(nums, 0, len(nums)-1)
    return nums
}

func mergeSort(nums []int, left, right int) {
	if left >= right {
		return
	}
	mid := (left + right) / 2
	mergeSort(nums, left, mid)
	mergeSort(nums, mid+1, right)
	i, j := left, mid+1
    arr := []int{}
    for index := left; index <= right; index++ {
		if i <= mid && (j > right || nums[i] < nums[j]) {
            arr = append(arr, nums[i])
            i++
		} else {
            arr = append(arr, nums[j])
			j++
		}
	}
    i = 0
    for index := left; index <= right; index++ {
        nums[index] = arr[i]
        i++
    }
}