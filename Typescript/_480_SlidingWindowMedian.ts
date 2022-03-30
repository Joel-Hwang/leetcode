function medianSlidingWindow(nums: number[], k: number): number[] {
    let res:number[] = [];
    let curArr:number[] = [];
    for(let i = 0; i<k; i++){
        add(curArr,nums[i]);
    }
    res.push(getMedian(curArr));
    
    for(let i = 1; i<nums.length-k+1; i++){
        del(curArr,nums[i-1]);
        add(curArr,nums[k+i-1]);
        res.push(getMedian(curArr));
    }

    return res;
};

function add(curArr:number[], num:number):void{
    let l:number = 0, r:number = curArr.length-1;
    if(num <= curArr[l]){
        curArr.splice(0,0,num);
        return;
    }
    if(num >= curArr[r]){
        curArr.splice(curArr.length,0,num);
        return;
    }

    while(l < r){
        let mid:number = Math.floor((l+r)/2);
        if(curArr[mid] < num){
            l = mid+1;
        }else{
            r = mid;
        }
    }
    curArr.splice(l,0,num);
}

function del(curArr:number[], num:number):void{
    let l:number = 0, r:number = curArr.length-1;
    while(l <= r){
        let mid:number = Math.floor((l+r)/2);
        if(curArr[mid] == num){
            curArr.splice(mid,1);
            return;
        }else if(curArr[mid] < num){
            l = mid+1;
        }else{
            r = mid;
        }
    }
}

function getMedian(curArr:number[]){
    let half:number = Math.floor(curArr.length/2);
    if(curArr.length%2 == 1) return curArr[half];
    return (curArr[half-1]+curArr[half])/2;
}




medianSlidingWindow([1,3,-1,-3,5,3,6,7],3);
/*
add([-3,5],3);
add([1,2,3,5,6],1);
add([1,2,3,5,6],6);
add([1,2,3,5,6],4);
add([1,2,3,4,5,6],5);
add([1,2,3,4,5,6],0);
add([1,2,3,4,5,6],8);

del([1,2,3,4,5,6],1);
del([1,2,3,4,5,6],1);
del([1,1,2,3,4,5],1);
del([1,2,3,4,5,6],3);
del([1,2,3,3,5,6],3);
del([1,2,3,4,5,6],6);
del([1,2,3,4,6,6],6);
*/