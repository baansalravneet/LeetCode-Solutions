func finalPositionOfSnake(n int, commands []string) int {
    x, y := 0, 0
    for _, c := range commands {
		switch c {
		case "LEFT":
			y--
		case "RIGHT":
			y++
		case "UP":
			x--
		default:
			x++
		}
    }
	return x*n + y
}