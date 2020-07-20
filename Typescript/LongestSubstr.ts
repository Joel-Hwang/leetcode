export interface ISet {
    [props: string] : boolean;
}


function lengthOfLongestSubstring(s: string): number {
    let i=0,j=0,ans=0,n = s.length;
    let set: ISet = {};
    while(i<n && j<n){
        let curchar = s.charAt(j);
        if( !set.hasOwnProperty(curchar) ){
            set[curchar] = true;
            j++;
            ans = Math.max(ans, j-i);
        }else{
            let curcharI = s.charAt(i)
            delete set[curcharI];
            i++
        }
    }
    return ans;
};

console.log(lengthOfLongestSubstring("abba"));