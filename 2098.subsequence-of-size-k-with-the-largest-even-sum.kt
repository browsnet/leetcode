/*
 * @lc app=leetcode.cn id=2022 lang=kotlin
 *
 * [2022] 将一维数组转变成二维数组
 */

// @lc code=start
class Solution 
fun Solution.largestEvenSum(nums: IntArray, k: Int): Long {
    val n = nums.size
    nums.sortDescending()
    var even1:Int? = null
    var odd1:Int? = null
    var sum = 0L
    for(i in 0 until k) {
        sum += nums[i]
        if(nums[i]%2==0) even1 = nums[i]
        else odd1 = nums[i]
    }
    if(sum%2==0L) return sum
    var even2:Int? = null
    var odd2:Int? = null
    for(i in k until n){
        val num = nums[i]
        if(even2==null && num%2==0)
            even2 = num
        else if(odd2==null && num%2==1)
            odd2 = num
        if(even2!=null && odd2!=null) break
    }
    var sum1 = 1L
    var sum2 = 1L
    if(even1!=null && odd2!=null)
        sum1 = sum-even1+odd2
    
    if(odd1!=null && even2!=null)
        sum2 = sum-odd1+even2
    // 都是奇数
    if(sum1%2==1L && sum2%2==1L) return -1
    if(sum1%2==0L && sum2%2==0L) return Math.max(sum1,sum2)
    return if(sum1%2==0L) sum1 else sum2
}
// @lc code=end

