var strStr = function(haystack, needle) {
    for(let i = 0; i<haystack.length; i++){
        if(needle[0] !== haystack[i]) continue;
        let isSame = true;
        for(let j = 0; j<needle.length; j++){
            if(needle[j] !== haystack[i+j]){
                isSame = false;
                break;
            }
        }
        if(isSame) return i;
        
    }
    return -1;
};


console.log(strStr("bcdeac","acd"));