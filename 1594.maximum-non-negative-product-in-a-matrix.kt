class Solution
val MOD = 1000000007 
fun Solution.maxProductPath(grid: Array<IntArray>): Int {
    val  m =grid.size
    val n = grid[0].size
    val dp1 = Array(m) {LongArray(n)}
    val dp2 = Array(m) {LongArray(n)}
    var hasZero = grid[0][0]==0
    if(grid[0][0]>0) dp1[0][0] = grid[0][0].toLong()
    if(grid[0][0]<0) dp2[0][0] = grid[0][0].toLong()
    for(i in 1 until n){
        val num = grid[0][i]
        val a = (dp1[0][i-1]*num)
        val b = (dp2[0][i-1]*num)
        if(num>0){
            dp1[0][i] = a
            dp2[0][i] = b
        }else if(num<0){
            dp1[0][i] = b
            dp2[0][i] = a 
        }else hasZero = true
    }
    for(i in 1 until m){
        val num = grid[i][0]
        val a = (dp1[i-1][0]*num)
        val b = (dp2[i-1][0]*num)
        if(num>0){
            dp1[i][0] = a
            dp2[i][0] = b
        }else if (num<0){
            dp1[i][0] = b
            dp2[i][0] = a 
        }else hasZero = true
    }
    for(i in 1 until m){
        for(j in 1 until n){
            val num = grid[i][j]
            val a = (Math.max(dp1[i-1][j],dp1[i][j-1])*num)
            val b = (Math.min(dp2[i-1][j],dp2[i][j-1])*num)
            if(num>0){
                dp1[i][j] = a
                dp2[i][j] = b
            }else if(num<0){
                dp1[i][j] = b
                dp2[i][j] = a 
            }  else hasZero = true       
        }
    }
    val ret = (dp1[m-1][n-1]%MOD).toInt()
    return if(ret>0) ret else if(hasZero) 0 else -1  
}