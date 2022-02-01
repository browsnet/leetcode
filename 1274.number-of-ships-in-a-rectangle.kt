/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     fun hasShips(topRight: IntArray, bottomLeft: IntArray): Boolean{}
 * }
 */

class Solution 
fun Solution.countShips(sea: Sea, topRight: IntArray, bottomLeft: IntArray): Int {
    // 这里的silent表示，该区域肯定有ship，不需要再检查了
    // 这是因为一个大区域检查有ship，而左边检查没有，那么右边一定有，反之亦然
    fun dfs(topRight:IntArray,bottomLeft:IntArray,silent:Boolean=false):Int{
        val (x1,y1) = topRight
        val (x2,y2) = bottomLeft
        if (x1 < x2 || y1 < y2) return 0
        val v = silent || sea.hasShips(topRight,bottomLeft)
        if(!v) return 0
        if(x1==x2 && y1==y2) return 1
        if(x1==x2){
            //上下切
             val m = y2 +(y1-y2)/2
            val v1 = dfs(intArrayOf(x1,m),bottomLeft)
            if(v1==0) return dfs(topRight,intArrayOf(x2,m+1),true)
            return v1+dfs(topRight,intArrayOf(x2,m+1))
        }
        // 左右切
        val m = x2 +(x1-x2)/2
        val v1 =  dfs(intArrayOf(m,y1),bottomLeft)
        if(v1==0) return dfs(topRight,intArrayOf(m+1,y2),true)
        return v1 + dfs(topRight,intArrayOf(m+1,y2))
    } 
    return dfs(topRight,bottomLeft)
}