func maximumTime(time string) string {
    r := []rune(time)
    if r[0] == '?' {
        if r[1] != '?' && r[1] >= '4' && r[1] <= '9' {
            r[0] = '1'
        } else {
            r[0] = '2'
        }
    }
    if r[1] == '?' {
        if r[0] == '2' {
            r[1] = '3'
        } else {
            r[1] = '9'
        }
    }
    if r[3] == '?' {
        r[3] = '5'
    }
    if r[4] == '?' {
        r[4] = '9'
    }
    return string(r)
}
