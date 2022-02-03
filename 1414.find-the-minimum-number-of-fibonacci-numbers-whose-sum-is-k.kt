class Solution 
fun Solution.findMinFibonacciNumbers(k: Int): Int {
    val lst = mutableListOf(1,1)
    while(true){
        val n = lst.size
        val v = lst[n-1]+lst[n-2]
        if(v>k) break
        lst.add(v)
    }
    tailrec fun dfs(k:Int,ret:Int):Int{
        if(k==0) return ret
        var left = 0
        var right = lst.size-1
        var index = 0
        while(left<=right){
            val m = left+(right-left)/2
            if(lst[m]<=k){
                index = m
                left = m+1
            }else right = m-1
        }
        return dfs(k-lst[index],ret+1)
    }
    return dfs(k,0)
}