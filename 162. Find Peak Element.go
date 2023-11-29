func findPeakElement(nums []int) int {
    if len(nums) == 1 {
        return 0
    }
    return binarySearch(nums, 0, len(nums)-1)
}

func binarySearch(nums []int, left, right int) int {
    if left > right {
        return -1
    }
    mid := (left + right) / 2
    if mid == 0 {
        if nums[mid] > nums[mid+1] {
            return mid
        } else {
            return binarySearch(nums, mid+1, right)
        }
    }
    if mid == len(nums)-1 {
        if nums[mid] > nums[mid-1] {
            return mid
        } else {
            return binarySearch(nums, left, mid-1)
        }
    }
    if nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1] {
        return mid
    }
    if nums[mid] <= nums[mid-1] {
        return binarySearch(nums, left, mid-1);
    } else {
        return binarySearch(nums, mid+1, right);
    }
}
