func latestTimeCatchTheBus(buses []int, passengers []int, capacity int) int {
    sort.Ints(buses)
    sort.Ints(passengers)
    lastPassenger := 0
    j := 0
    boarded := make(map[int]bool)
    for i := range buses {
        count := 0
        for j < len(passengers) && count < capacity && passengers[j] <= buses[i] {
            lastPassenger = passengers[j]
            boarded[lastPassenger] = true
            count++
            j++
        }
        if i == len(buses)-1 && count < capacity && lastPassenger < buses[i] {
            return buses[i]
        }
    }
    if len(boarded) == 0 {
        return buses[len(buses)-1]
    }
    for {
        if _, ok := boarded[lastPassenger]; ok {
            lastPassenger--
        } else {
            break
        }
    }
    return lastPassenger
}

