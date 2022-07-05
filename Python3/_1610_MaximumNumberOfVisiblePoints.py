from audioop import add
from typing import List
import math

class Solution:
    def visiblePoints(self, points: List[List[int]], angle: int, location: List[int]) -> int:
        angles = []
        addition = 0
        for point in points:
            if point[0] == location[0] and point[1] == location[1] :
                addition += 1
                continue
            angles.append( self.getAngle(point,location) )
        n = len(angles)
        for i in range(n):
            angles.append(angles[i]+360)
        angles.sort()
        res = addition
        j = 0
        for i in range(len(angles)):
            cur = 0
            while angles[i] - angles[j] > angle:
                j+=1
            cur = i - j + 1 + addition
            res = max(res,cur)
        return res

    def getAngle(self,start:List[int], end:List[int]) -> int:
        dx = end[0] - start[0]
        dy = end[1] - start[1]
        return math.atan2(dy,dx)*(180/math.pi)