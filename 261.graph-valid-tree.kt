class Solution 
fun Solution.validTree(n: Int, edges: Array<IntArray>): Boolean {
    val deps = Array(n) {mutableListOf<Int>()}
    for((a,b) in edges){
        deps[a].add(b)
        deps[b].add(a)
    }
    var visited = Array(n) {false}
    fun dfs(i:Int,parent:Int):Int{
        visited[i] = true
        var count = 1
        for(j in deps[i]){
            if(j==parent) continue
            if(visited[j]) return -1
            val c = dfs(j,i)
            if(c==-1) return -1
            else count += c
        }
        visited[i] = false
        return count
    }
    for(i in 0 until n){
        if(dfs(i,-1)==n) return true
    }
    return false
}