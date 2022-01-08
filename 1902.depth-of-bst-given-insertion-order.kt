class Solution 
fun Solution.maxDepthBST(order: IntArray): Int {
    val map = TreeMap<Int,Int>()
    var ret = 1
    for(num in order){
        val lower = map.lowerEntry(num)?.value?:0
        val higher = map.higherEntry(num)?.value?:0
        var depth = Math.max(lower,higher) + 1
        map[num] = depth
        ret = Math.max(ret,depth)
    }
    return ret
}