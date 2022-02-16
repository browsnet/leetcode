/*
 * @lc app=leetcode.cn id=1719 lang=kotlin
 *
 * [1719] Number Of Ways To Reconstruct A Tree
 */

// @lc code=start
class Solution 
// 本题的特质是：如果是一颗合法树，那么节点的度数就是它在pairs里出现的次数
// pairs里度数大的肯定是度数小的父节点或者祖节点
// 基于此就可以找到自己的父节点，并且做校验
fun canBuildTree(edges:Map<Int,List<Int>>):Boolean{
    // 最大度
    var maxDegree = 0
    for((node,lst) in edges){
        maxDegree = Math.max(maxDegree,lst.size)
        if(lst.size==edges.size) continue
        // 能得到的大于等于当前度数的最小度
        // 就是自己的直接父节点
        var parent = lst
            .filter { it!=node && edges[it]!!.size>=lst.size}
            .minBy { edges[it]!!.size}
        if (parent == null) return false
        // 检查当前所有子节点是否都在父节点里
        if(!lst.all {it in edges[parent]!!}) return false
    }
    return maxDegree == edges.size 
}
fun Solution.checkWays(pairs: Array<IntArray>): Int {
    val edges = mutableMapOf<Int,MutableList<Int>>()
    for((a,b) in pairs){
        if(edges[a]==null) edges[a] = mutableListOf(a)
        if(edges[b]==null) edges[b] = mutableListOf(b)
        edges[a]?.add(b)
        edges[b]?.add(a)
    }
    if(!canBuildTree(edges)) return 0
    // 如果任意pair里有两个度相同
    val mutiple = pairs.find {(a,b)->edges[a]?.size==edges[b]?.size}!=null
    return if(mutiple) 2 else 1
}
// @lc code=end

