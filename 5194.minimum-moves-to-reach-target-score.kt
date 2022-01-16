class Solution 
tailrec fun minMoves(target: Int, maxDoubles: Int,ret:Int):Int{
    if(target==1) return ret
    if(maxDoubles==0) return maxDoubles+ret-1
    if(target%2==1) 
        return minMoves(target-1,maxDoubles,ret+1)
    return minMoves(target/2,maxDoubles-1,ret+1)
}
fun Solution.minMoves(target: Int, maxDoubles: Int): Int {
    return minMoves(target,maxDoubles,0)
}