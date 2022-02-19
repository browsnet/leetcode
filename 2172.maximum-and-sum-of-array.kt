/*
 * @lc app=leetcode.cn id=2172 lang=kotlin
 *
 * [2172] Maximum AND Sum of Array
 */

// @lc code=start
class Solution 
// 三进制状态压缩，DP
fun Solution.maximumANDSum(nums: IntArray, numSlots: Int): Int {
    var mask_max = powerOf3(numSlots)
    val cached = IntArray(mask_max)
    fun dfs(mask:Int):Int{
        if(mask<=0) return 0
        if(cached[mask]>0) return cached[mask]
        var cnt = 0
        var dummy = mask
        for(i in 0 until numSlots){
            cnt += dummy%3
            dummy /= 3
        }
        if(cnt>nums.size) return 0
        dummy = mask
        var ret = 0
        for(i in 0 until numSlots){
            if(dummy%3!=0){
                val k = powerOf3(i)
                val v = dfs(mask-k)+(nums[cnt-1] and (i+1))
                ret = Math.max(ret, v)
            }
            dummy /= 3
        }
        cached[mask] = ret
        return ret
    }
    var ret = 0
    for(i in 1 until mask_max) ret = Math.max(ret,dfs(i))
    return ret
}
fun powerOf3(i:Int):Int
  = Math.pow(3.0,i.toDouble()).toInt()
// @lc code=end

