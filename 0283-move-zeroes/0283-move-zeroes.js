/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    let idx=0,i=0;

    while(i<nums.length){
        if(nums[i] != 0){
            nums[idx] = nums[i];
            idx++;
        }
        i++;
    }

    while(idx<nums.length){
        nums[idx]=0;
        idx++;
    }
};