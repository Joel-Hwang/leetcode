package main

func lengthOfLongestSubstring(s string) int {
	n := len(s)
	ans, i, j := 0, 0, 0
	var set map[rune]bool
	set = make(map[rune]bool)

	for i < n && j < n {
		charAtJ := []rune(s)[j]
		if !set[charAtJ] {
			set[charAtJ] = true
			j++
			ans = Max(ans, j-i)
		} else {
			charAtI := []rune(s)[i]
			set[charAtI] = false
			i++
		}
	}

	return ans
}

func Max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
