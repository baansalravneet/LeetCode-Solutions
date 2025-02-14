class ProductOfNumbers:

    def __init__(self):
        self.total = 0
        self.last_zero = 0
        self.current = []

    def add(self, num: int) -> None:
        self.total += 1
        if not num:
            self.last_zero = self.total
            self.current = []
        else:
            if not self.current:
                self.current.append(num)
            else:
                self.current.append(self.current[-1]*num)

    def getProduct(self, k: int) -> int:
        if self.total - self.last_zero < k:
            return 0
        return (
            self.current[-1]
            if k == len(self.current)
            else self.current[-1] // self.current[-1-k]
        )



# Your ProductOfNumbers object will be instantiated and called as such:
# obj = ProductOfNumbers()
# obj.add(num)
# param_2 = obj.getProduct(k)