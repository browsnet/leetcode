class Solution 
fun Solution.updateMatrix(mat: Array<IntArray>): Array<IntArray> {
    val m = mat.size
    val n = mat[0].size
    val ret = Array(m) {IntArray(n) {10000}}
    for(i in 0 until m){
        for(j in 0 until n){
            ret[i][j] = when{
                mat[i][j]==0 -> 0
                i==0 && j==0 -> ret[i][j]
                i==0 -> ret[i][j-1]+1
                j==0 -> ret[i-1][j]+1
                else -> Math.min(ret[i-1][j],ret[i][j-1])+1
            }
        }
    }
    for(i in m-1 downTo 0){
        for(j in n-1 downTo 0){
            val v = when{
                mat[i][j]==0 -> 0
                i==m-1 && j==n-1 -> ret[i][j]
                i==m-1 -> ret[i][j+1]+1
                j==n-1 -> ret[i+1][j]+1
                else -> Math.min(ret[i+1][j],ret[i][j+1])+1
            }
            ret[i][j] = Math.min(ret[i][j],v)
        }
    }
    return ret    
}