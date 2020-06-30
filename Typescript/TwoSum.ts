export interface IHash {
    [props: number] : number;
}

function twoSum2(nums: number[], target: number): number[] {
    for(let i : number = 0; i<nums.length; i++){
        for(let j: number = i+1; j<nums.length; j++){
            if(nums[i] + nums[j] === target) return [i,j];
        }
    }
};

function twoSum(nums: number[], target: number): number[] {
    let hm: IHash = {};

    for(let i : number = 0; i<nums.length; i++){
        if(hm.hasOwnProperty(target - nums[i])) return [i, hm[  target-nums[i] ]]; 
        else hm[nums[i]] = i;
    }
    return [];
};



console.log(twoSum2([2,7,11,15],9));