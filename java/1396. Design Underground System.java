class UndergroundSystem {
    private Map<Integer, Integer> customerTime;
    private Map<Integer, String> customerStart;
    private Map<String, Double> travelTime;
    private Map<String, Integer> travelCount;

    public UndergroundSystem() {
        customerTime = new HashMap<>();
        customerStart = new HashMap<>();
        travelTime = new HashMap<>();
        travelCount = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        customerTime.put(id, t);
        customerStart.put(id, stationName);
    }
    
    public void checkOut(int id, String stationName, int t) {
        int startTime = customerTime.remove(id);
        String startStation = customerStart.remove(id);
        String key = getKey(startStation, stationName);
        travelTime.put(key, travelTime.getOrDefault(key, 0.0) + t - startTime);
        travelCount.put(key, travelCount.getOrDefault(key, 0) + 1);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = getKey(startStation, endStation);
        double time = (double)travelTime.get(key);
        return time/travelCount.get(key);
    }

    private String getKey(String s1, String s2) {
        return s1 + "," + s2;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */

