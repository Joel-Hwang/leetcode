/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let i=0,j=0,ans=0,n= s.length;
    let set = {};
    while(i<n && j <n ){
        if(!set.hasOwnProperty( s.charAt(j)  )){
            set[s.charAt(j++)] = true;
            ans = Math.max(ans, j-i);
        }else{
            delete set[s.charAt(i++)]
        }
    }
    return ans;
};

console.log(lengthOfLongestSubstring("abba"));