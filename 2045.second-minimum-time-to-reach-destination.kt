/*
 * @lc app=leetcode.cn id=2045 lang=kotlin
 *
 * [2045] Second Minimum Time to Reach Destination
 */

// @lc code=start
class Solution 
// 这道题的思路是BFS在图里找最短路径
// 而找到之后，剩下的Set里，再次查找是否能通往n的路径
// 如果能找到就路径+1,如果找不到就+2(表示往前一格的往返)
// 最后通过节点树和时间以及等待规则求解
fun Solution.secondMinimum(n: Int, edges: Array<IntArray>, time: Int, change: Int): Int {
    val pairs = Array(n+1) {mutableListOf<Int>()}
    for((u,v) in edges){
        pairs[u].add(v)
        pairs[v].add(u)
    }
    var num = 0 
    val visited = Array(n+1) {false}
    var current = listOf(1)
    while(!(n in current)){
        val lst = mutableListOf<Int>()
        for(u in current){
            for(v in pairs[u]){
                if(visited[v]) continue
                lst.add(v)
            }
        }
        for(x in current)
           visited[x] = true
        current = lst
        num++
    }
    var extra = 2
    for(u in current){
        if(n in pairs[u]){
            extra = 1
            break            
        }
    }
    num += extra
    var ret = 0
    var mod = change*2
    while(num-->0){
        if(ret%mod>=change)ret += (mod-ret%mod)
        ret += time
    }
    return ret
}
// @lc code=end

