class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        count = 0
        while len(students) != 0 and count < len(students):
            if students[0] == sandwiches[0]:
                students = students[1:]
                sandwiches = sandwiches[1:]
                count = 0
            else:
                students.append(students[0])
                students = students[1:]
                count += 1
        return len(students)
