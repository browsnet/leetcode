class Solution 
fun Solution.constrainedSubsetSum(nums: IntArray, k: Int): Int {
    val n = nums.size
    val dp = IntArray(n)
    dp[0] = nums[0]
    val deque = mutableListOf(0)
    var ret = nums[0]
    for(i in 1 until n){
         // 如果队首的 j 与 i 的差值大于 k，则不满足要求，弹出
        while(deque.size>0 && deque[0]<i-k)
            deque.removeAt(0)
        // 此时队首的 j 即为最优的 j 值
        dp[i] = Math.max(dp[deque[0]],0) + nums[i]
        ret = Math.max(dp[i],ret)
         // 维护队列的单调性，不断从队尾弹出元素
        while(deque.size>0 && dp[i] >= dp[deque.last()])
            deque.removeAt(deque.lastIndex)
        // 将 i 作为之后的新 j 值放入队尾
        deque.add(i)
    }
    return ret
}