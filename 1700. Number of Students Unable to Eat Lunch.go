func countStudents(students []int, sandwiches []int) int {
	count := 0
	for len(students) != 0 && count < len(students) {
		if students[0] == sandwiches[0] {
			students = students[1:]
			sandwiches = sandwiches[1:]
			count = 0
		} else {
			students = append(students, students[0])
			students = students[1:]
			count += 1
		}
	}
	return len(students)
}