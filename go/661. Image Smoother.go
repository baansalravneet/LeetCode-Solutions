func imageSmoother(img [][]int) [][]int {
    result := make([][]int, len(img))
    for i := range img {
        result[i] = make([]int, len(img[0]))
    }
    for i := range img {
        for j := range img[i] {
            result[i][j] = change(&img, i, j)
        }
    }
    return result;
}
func change(image *[][]int, i, j int) int {
    count := 1
    sum := (*image)[i][j]
    for _, d := range [][]int{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}} {
        if i + d[0] < 0 || i + d[0] >= len(*image) {
            continue
        }
        if j + d[1] < 0 || j + d[1] >= len((*image)[i]) {
            continue
        }
        count++
        sum += (*image)[i+d[0]][j+d[1]]
    }
    return sum / count
}
