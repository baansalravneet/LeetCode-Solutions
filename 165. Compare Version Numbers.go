func compareVersion(version1 string, version2 string) int {
	revision1 := strings.Split(version1, ".")
	revision2 := strings.Split(version2, ".")
	for i := 0; i < len(revision1) || i < len(revision2); i++ {
		var num1, num2 int
		if i < len(revision1) {
			num1, _ = strconv.Atoi(revision1[i])
		}
		if i < len(revision2) {
			num2, _ = strconv.Atoi(revision2[i])
		}
		if num1 > num2 {
			return 1
		}
		if num1 < num2 {
			return -1
		}
	}
	return 0
}