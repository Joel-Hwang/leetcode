class Solution:
    #밑에서부터 위로 올라감
    #맨 밑이 tx,ty이면 (부모x+부모y,y) 또는 (x,부모x+부모y)가 tx,ty임. tx>ty이면 앞 케이스 else면 뒤 케이스
    #또한 부모는 ( tx-ty, ty )거나 ( tx, ty-tx )로 정리됨.
    # 그 위 부모는 ( tx-2ty, ty )거나 ( tx, ty-2tx )로 정리됨.
    # 그래서 mod 연산으로 올라갈 수 있을만큼 우선 올라감.
    # 올라갈만큼 올라가면 노드값은 (sx+k*sy, sy) 또는 (sx, k*sx+sy)가 됨
    # 두 경우(sy==ty 이고 sx+k*sy == tx를 만족하는 K가 자연수이거나 그 반대의 경우 둘 중) 하나만 참이면 return true.
    def reachingPoints(self, sx: int, sy: int, tx: int, ty: int) -> bool:
        while tx > sx and ty > sy:
            if tx>ty:
                tx %= ty
            else:
                ty %= tx

        return sx == tx and sy <= ty and (ty-sy)%sx==0 or sy == ty and sx <= tx and (tx-sx)%sy==0
