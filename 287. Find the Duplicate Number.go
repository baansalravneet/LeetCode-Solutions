func findDuplicate(nums []int) int {
    slow, fast := nums[0], nums[0]
    for {
        slow, fast = nums[slow], nums[nums[fast]]
        if slow == fast {
            break
        }
    }
    slow = nums[0]
    for slow != fast {
        slow, fast = nums[slow], nums[fast]
    }
    return slow
}

