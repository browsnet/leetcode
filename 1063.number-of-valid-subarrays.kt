class Solution 
// 使用单调非递减栈保存之前的下标
fun Solution.validSubarrays(nums: IntArray): Int {
    val n = nums.size
    var ret = 0 
    val stack = mutableListOf<Int>()
    for(i in 0 until n){
        val num = nums[i]
        while(stack.size>0 && nums[stack.last()]>num){
            // 之前的下标
            val j = stack.removeAt(stack.lastIndex)
            ret += i-j
        }
        stack.add(i)
    }
    while(stack.size>0){
        ret += n-stack.removeAt(stack.lastIndex)
    }
    return ret
}