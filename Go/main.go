package main

import (
	"fmt"
	"strconv"
)

func main() {
	var nums = []int{2, 7, 9, 11}
	result := twoSum(nums, 9)
	fmt.Printf(strconv.Itoa(result[0]) + " " + strconv.Itoa(result[1]))
	addTwoNumbers(nil, nil)
}
