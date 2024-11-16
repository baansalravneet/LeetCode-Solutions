class SeatManager(object):

    def __init__(self, n):
        """
        :type n: int
        """
        self.marker = 1
        self.available_seats_before_marker = []

    def reserve(self):
        """
        :rtype: int
        """
        if self.available_seats_before_marker:
            return heappop(self.available_seats_before_marker)

        seat_number = self.marker
        self.marker += 1
        return seat_number

    def unreserve(self, seat_number):
        """
        :type seatNumber: int
        :rtype: None
        """
        heappush(self.available_seats_before_marker, seat_number)
        


# Your SeatManager object will be instantiated and called as such:
# obj = SeatManager(n)
# param_1 = obj.reserve()
# obj.unreserve(seatNumber)
