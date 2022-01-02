class Solution 
fun Solution.maximumInvitations(favorite: IntArray): Int {
    val n = favorite.size
    val color = IntArray(n)
    val dep = IntArray(n)
    val pairs = mutableListOf<Pair<Int,Int>>()
    var max = 0
    var from_pairs = 0
    val rev = Array(n) {mutableListOf<Int>()}
    fun dfs(u:Int){
        color[u] = 1
        for(v in rev[u]){
            if(color[v]==0){
                dep[v] = dep[u]+1
                dfs(v)
            }else if(color[v]==1){
                max = Math.max(max,dep[u]-dep[v]+1)
                if(dep[u]-dep[v]==1)
                    pairs.add(u to v)
            }
        }
        color[u] = 2
    }
    fun dfs2(u:Int,p:Int,d:Int):Int{
        var max_depth = d
        for(v in rev[u]){
            if(v==p) continue
            max_depth = Math.max(max_depth,dfs2(v,p,d+1))
        }
        return max_depth
    }

    for(i in 0 until n)
        rev[favorite[i]].add(i)
    for(i in 0 until n)
        if(color[i]==0) dfs(i)
    for((u,v) in pairs){
        from_pairs += dfs2(u, v, 1);
        from_pairs += dfs2(v, u, 1); 
    }
    return Math.max(max, from_pairs)
}