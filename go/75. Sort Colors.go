func sortColors(nums []int)  {
    left, right, i := 0, len(nums)-1, 0
    for i <= right {
        if nums[i] == 0 {
            nums[i], nums[left] = nums[left], nums[i]
            i += 1
            left += 1
        } else if nums[i] == 2 {
            nums[i], nums[right] = nums[right], nums[i]
            right -= 1
        } else {
            i += 1
        }
    }
}
