class Solution 
fun Solution.pushDominoes(dominoes: String): String {
    val arr = dominoes.toCharArray()
    val n = arr.size
    val visited = IntArray(n)
    var set = mutableSetOf<Pair<Int,Boolean>>()
    for(i in 0 until n){
        if(dominoes[i]=='.') continue
        visited[i] = if(dominoes[i]=='R') 1 else 2
        set.add(i to (dominoes[i]=='R'))
    }
    while(set.size>0){
        val newSet = mutableSetOf<Pair<Int,Boolean>>()
        for((i,isRight) in set){
            val j = if(isRight) i+1 else i-1
            if(j<0 || j>=n) continue
            if(visited[j]!=0) continue
            val p = j to !isRight
            if(p in newSet) newSet.remove(p)
            else newSet.add(j to isRight)
        }
        for((i,isRight) in newSet)
            visited[i] = if(isRight) 1 else 2
        set = newSet
    }
    return visited.map {
        when(it){
            1-> 'R'
            2-> 'L'
            else -> '.'
        }
    }.joinToString("")
}