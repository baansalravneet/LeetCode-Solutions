func destCity(paths [][]string) string {
    toCities := make(map[string]bool)
    for _, path := range paths {
        to := path[1]
        toCities[to] = true
    }
    for _, path := range paths {
        from := path[0]
        delete(toCities, from)
    }
    for k, _ := range toCities {
        return k
    }
    return ""
}
