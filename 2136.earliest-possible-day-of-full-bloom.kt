class Solution
// 贪心，需要证明最优方案是：先选生长时间最长的
fun Solution.earliestFullBloom(plantTime: IntArray, growTime: IntArray): Int {
    val n = plantTime.size
    var ret = 0
    var plant = 0
    val arr = (0 until n).sortedByDescending {growTime[it]}
    for(i in arr){
        plant += plantTime[i]
        ret = Math.max(ret, plant + growTime[i])
    }
    return ret
}