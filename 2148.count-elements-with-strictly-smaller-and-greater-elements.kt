class Solution 
fun Solution.countElements(nums: IntArray): Int {
    val min = nums.min()!!
    val max = nums.max()!!
    var minNum = 0
    var maxNum = 0
    for(num in nums){
        if(num==min) minNum++
        if(num==max) maxNum++
    }
    val v = nums.size-minNum-maxNum
    return if(v>0) v else 0
}