func numberToWords(num int) string {
	belowTwenty := []string {
        "",        "One",     "Two",       "Three",    "Four",
        "Five",    "Six",     "Seven",     "Eight",    "Nine",
        "Ten",     "Eleven",  "Twelve",    "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
	}
	belowHundred := []string {
        "",      "",      "Twenty",  "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety",
	}
	var helper func(int) string
	helper = func(num int) string {
		var sb strings.Builder
		if num < 20 {
			sb.WriteString(belowTwenty[num])
		} else if num < 100 {
			sb.WriteString(belowHundred[num/10])
			sb.WriteString(" ")
			sb.WriteString(belowTwenty[num%10])
		} else if num < 1000 {
			sb.WriteString(belowTwenty[num/100])
			sb.WriteString(" Hundred ")
			sb.WriteString(helper(num%100))
		} else if num < 1000000 {
			sb.WriteString(helper(num/1000))
			sb.WriteString(" Thousand ")
			sb.WriteString(helper(num%1000))
		} else if num < 1000000000 {
			sb.WriteString(helper(num/1000000))
			sb.WriteString(" Million ")
			sb.WriteString(helper(num%1000000))
		} else {
			sb.WriteString(helper(num/1000000000))
			sb.WriteString(" Billion ")
			sb.WriteString(helper(num%1000000000))
		}
		return strings.Trim(sb.String(), " ")
	}
	if num == 0 {
		return "Zero"
	}
	return helper(num)
}