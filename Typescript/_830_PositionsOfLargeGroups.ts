function largeGroupPositions(s: string): number[][] {
    let res: number[][] = []
    let curNumCount:number = 1;
    let start:number = 0;

    for(let i = 1; i < s.length; i++) {
        if(s[i] === s[i-1]) curNumCount++;
        else{
            if(curNumCount > 2){
                res.push( [start , i -1] );
            }
            curNumCount = 1;
            start = i;
        }
    }

    if(curNumCount > 2){
        res.push( [start , s.length-1] );
    }

    return res;
};


console.log(largeGroupPositions("xxxx"));