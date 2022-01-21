/*
 * @lc app=leetcode.cn id=1345 lang=kotlin
 *
 * [1345] Jump Game IV
 */

// @lc code=start
class Solution 
fun Solution.minJumps(arr: IntArray): Int {
    val n = arr.size
    val map = mutableMapOf<Int,MutableList<Int>>()
    for(i in 0 until n){
        val num = arr[i]
        if(map[num]==null)
            map[num] = mutableListOf(i)
        else map[num]!!.add(i)
    }
    val queue = mutableListOf(0 to 0)
    val visited = Array(n) {false}
    while(queue.size>0){
        val (i,v) = queue.removeAt(0)
        if(i==n-1) return v
        if(i==n-2) return v+1
        val num = arr[i]
        if(i>0 && !visited[i-1]){
            queue.add(i-1 to v+1)
            visited[i-1] = true
        }
        if(!visited[i+1]){
            queue.add(i+1 to v+1)
            visited[i+1] = true 
        }
        val ids = map[num]
        if(ids==null) continue
        for(j in ids){
            if(visited[j]) continue
            if(j==n-1) return v+1
            queue.add(j to v+1)
            visited[j] = true
        }
        map.remove(num)
    }
    return 0
}
// @lc code=end

