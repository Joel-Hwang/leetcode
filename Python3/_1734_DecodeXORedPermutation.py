from typing import List


class Solution:
    def decode(self, encoded: List[int]) -> List[int]:
        res = []
        res.append(0)
        for i in range(1, len(encoded),2):
            res[0] ^= i
            res[0] ^= i + 1
            res[0] ^= encoded[i]
        res[0] ^= len(encoded) + 1

        for v in encoded:
            res.append(res[-1]^v)
        return res