func getCommon(nums1 []int, nums2 []int) int {
    left := 0
    right := 0
    for left < len(nums1) && right < len(nums2) {
        if nums1[left] == nums2[right] {
            return nums1[left]
        }
        if nums1[left] < nums2[right] {
            left++
        } else {
            right++
        }
    }
    return -1
}
