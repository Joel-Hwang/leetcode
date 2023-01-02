/**
 * @param {string} columnTitle
 * @return {number}
 */
var titleToNumber = function(columnTitle) {
    let chars = columnTitle.split('');
    let res = 0;
    let unit = 0;
    for(let i = chars.length-1; i>=0; i--) {
        res += (chars[i].charCodeAt(0)-64)*Math.pow(26,unit++);
    }
    return res;
};



console.log(titleToNumber("A"));
console.log(titleToNumber("Z"));
console.log(titleToNumber("AA"));
console.log(titleToNumber("AZ"));
console.log(titleToNumber("ZZ"));
console.log(titleToNumber("AAA"));