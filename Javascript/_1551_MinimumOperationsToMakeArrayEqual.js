let solution = function(n){
    //1 3 5 = 2 3 4 = 3 3 3
    //1 3 5 7 = 2 3 5 6 = 3 3 5 5 = 4 3 5 4 = 4 4 4 4
    //1 3 5 7 9 = 4 + 2 +0= 6
    //1 3 5 7 9 11 = 5+3+1
    let result = 0;
    for(let i = 0; i<n/2; i++){
        //mid = 2*(n/2) = n
        result += n-(2*i+1);
    }
    return result;
}

console.log(solution(3));
console.log(solution(4));
console.log(solution(5));
console.log(solution(6));
console.log(solution(7));