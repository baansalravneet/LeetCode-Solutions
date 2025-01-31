class FrequencyTracker:

    def __init__(self):
        self.num_freq = [0] * 100001
        self.freq_freq = [0] * 100001

    def add(self, number: int) -> None:
        if self.num_freq[number] > 0:
            self.freq_freq[self.num_freq[number]] -= 1
        self.num_freq[number] += 1
        self.freq_freq[self.num_freq[number]] += 1

    def deleteOne(self, number: int) -> None:
        if self.num_freq[number] == 0: return
        self.freq_freq[self.num_freq[number]] -= 1
        self.num_freq[number] -= 1
        self.freq_freq[self.num_freq[number]] += 1

    def hasFrequency(self, frequency: int) -> bool:
        return self.freq_freq[frequency] > 0


# Your FrequencyTracker object will be instantiated and called as such:
# obj = FrequencyTracker()
# obj.add(number)
# obj.deleteOne(number)
# param_3 = obj.hasFrequency(frequency)