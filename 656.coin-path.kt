class Solution 
fun Solution.cheapestJump(coins: IntArray, maxJump: Int): List<Int> {
    val n = coins.size
    val nexts = IntArray(n+1) {-1}
    val cached = IntArray(n+1) {-1}
    fun dfs(i:Int):Int{
        if(i<=n && coins[i-1]==-1) return Int.MAX_VALUE
        if(i==n) return coins[i-1]
        if(cached[i]>=0) return cached[i]
        var min = Int.MAX_VALUE
        for(j in i+1..i+maxJump){
            if(j>n) continue
            val v = dfs(j)
            if(v<min){
                min = v
                nexts[i] = j
            }
        }
        if(min==Int.MAX_VALUE) {
            cached[i] = min
            return min
        }
        cached[i] = min+coins[i-1]
        return cached[i]
    }
    val v = dfs(1)
    if(v==Int.MAX_VALUE) return listOf()
    val lst = mutableListOf<Int>(1)
    var i = 1
    while(i<n){
        i = nexts[i]
        lst.add(i)
    }
    return lst
}