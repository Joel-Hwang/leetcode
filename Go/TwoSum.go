package main

import (
	"fmt"
	"strconv"
)

func main() {
	var nums = []int{2, 7, 9, 11}
	result := twoSum(nums, 9)
	fmt.Printf(strconv.Itoa(result[0]) + " " + strconv.Itoa(result[1]))
}

func twoSum(nums []int, target int) []int {
	var idMap map[int]int
	idMap = make(map[int]int)

	for i := 0; i < len(nums); i++ {
		v, found := idMap[target-nums[i]]
		if found {
			return []int{v, i}
		} else {
			idMap[nums[i]] = i
		}
	}

	return []int{}
}
