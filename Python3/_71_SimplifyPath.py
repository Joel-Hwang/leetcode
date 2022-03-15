class Solution:
    def simplifyPath(self, path: str) -> str:
        list = path.split("/")
        pathList = []
        for block in list:
            if block == "..": 
                if len(pathList)>0:
                    pathList.pop()
            elif block == "." or block == "": continue
            else: pathList.append(block)

        res = ""
        for block in pathList:
            res += "/" + block  
        if res == "": return "/"
        return res

test = Solution()
print(test.simplifyPath("/Z/Iyy/HSyT/ItVqc/.././//Z/.././.././../a/gK/../ZurH///x/../////././../.."))
print(test.simplifyPath("/../"))
print(test.simplifyPath("/home//foo/"))
print(test.simplifyPath("/home/"))