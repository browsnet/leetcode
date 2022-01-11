class Solution 
typealias Point = Pair<Int,Int>
val dirs = listOf(-1 to 0,1 to 0,0 to -1, 0 to 1)
fun Solution.isEscapePossible(blocked: Array<IntArray>, source: IntArray, target: IntArray): Boolean {
    val n = blocked.size
    val blockedSet = blocked.map {(a,b)->a to b}.toSet()
    val s = source[0] to source[1]
    val t = target[0] to target[1]
    val total = (n*n+n)/2 // 最大截止条件
    fun dfs(current:Point,target:Point,visited:MutableSet<Point> = blockedSet.toMutableSet()):Boolean{
        if(current==target) return true
        val (a,b) = current
        if(a<0 || b<0 || a>999999 || b>999999) return false
        if(current in visited) return false
        visited.add(current)
        if(visited.size>total) return true
        var ret = false
        for((da,db) in dirs){
            ret = ret || dfs(da+a to db+b,target,visited)
            if(ret) return true
        }
        return ret
    }
    return dfs(s,t) && dfs(t,s)
}