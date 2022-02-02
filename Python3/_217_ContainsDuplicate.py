from operator import truediv


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        map = set()
        for n in nums:
            if n in map:
                return True
            map.add(n)
        return False