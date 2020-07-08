package main

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
