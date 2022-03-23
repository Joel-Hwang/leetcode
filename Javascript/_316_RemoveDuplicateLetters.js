/**
 * @param {string} s
 * @return {string}
 */
 var removeDuplicateLetters = function(s) {
    lastIndex = {};
    seen = {};
    for(let i = 0; i<s.length; i++){
        lastIndex[s.charAt(i)] = i;
    }
    stk = [];
    
    for(let i = 0; i<s.length; i++){
        if(seen[s.charAt(i)]) continue;
        while(stk.length>0 && stk[stk.length-1] > s.charAt(i) && lastIndex[stk[stk.length-1] ] > i){
            seen[stk[stk.length-1]] = false;
            stk.pop();
        }
        stk.push(s.charAt(i));
        seen[s.charAt(i)] = true;
    }

    res = "";
    for(let i = 0; i<stk.length; i++){
        res += stk[i];
    }

    return res;
};


console.log(removeDuplicateLetters("cbacdcbc"));
console.log(removeDuplicateLetters("bcabc"));