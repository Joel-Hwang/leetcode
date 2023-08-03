/**
 * @param {string} word
 * @return {number}
 */
 var minTimeToType = function(word) {
    let answer = word.length; 
    let prevChar = 'a';
    for(let currentChar of word){
        let distance = Math.abs(currentChar.charCodeAt(0)-prevChar.charCodeAt(0));
        answer += Math.min(distance,26-distance);
        prevChar=currentChar;
    }
    return answer;
 };

console.log(minTimeToType("abc"));