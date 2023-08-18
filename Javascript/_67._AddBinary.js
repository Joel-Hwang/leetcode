/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function(a, b) {
    //a랑 b를 뒤에서부터 split 한다.
    //더한거랑 캐리온 합친거가 2를 넘으면 2를 뺜결 결과에 넣고 케리온애 1넣음
    let result = "";
    let carryOn = 0;
    for(let i = 0; i<Math.max(a.length,b.length); i++){
        let firstNumber = getDigitInReversePosition(a,i);
        let secondNumber = getDigitInReversePosition(b,i);
        let sum = firstNumber + secondNumber + carryOn;
        let currentDigit = getCurrentDigit(sum);
        carryOn = getCarryOn(sum);
        result = currentDigit + result;
    }
    if(carryOn > 0) result = carryOn + result;
    return result;
};

function getDigitInReversePosition(number, position){
    if(position<0 || position >= number.length) return 0;
    return parseInt(number[number.length-1-position]);
}

function getCarryOn(sum){
    if(sum > 1) return 1;
    return 0;
}
function getCurrentDigit(sum){
    if(sum > 1) return sum-2;
    return sum;
}

console.log(addBinary("101","11"))
