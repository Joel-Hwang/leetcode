var twoSum = function(nums, target) {
    let hm = {};

    for(let i = 0; i<nums.length; i++){
        if(hm.hasOwnProperty(target - nums[i])) return [i, hm[ target-nums[i] ]]; 
        else hm[nums[i]] = i;
    }
    return [];
};

console.log(twoSum([2,7,11,15],9));