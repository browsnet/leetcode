class Solution
// 如果之前把前缀和的差记录下来
// 那么再遇到相同的差，表示区间和一致了
fun Solution.widestPairOfIndices(nums1: IntArray, nums2: IntArray): Int {
    val n = nums1.size
    var ret = 0 
    var pre1 = 0
    var pre2 = 0
    val map = mutableMapOf(0 to -1)
    for(i in 0 until n){
        pre1 += nums1[i]
        pre2 += nums2[i]
        val diff = pre2-pre1
        if(map[diff]!=null){
            ret = Math.max(ret,i-map[diff]!!)
        }else{
            map[diff] = i
        }
    }
    return ret
}