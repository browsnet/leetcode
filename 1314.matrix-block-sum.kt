class Solution 
fun Solution.matrixBlockSum(mat: Array<IntArray>, k: Int): Array<IntArray> {
    val m = mat.size
    val n = mat[0].size
    val sums = Array(m+1) {IntArray(n+1)}
    val ret = Array(m) {IntArray(n)} 
    for(i in 1..m){
        for(j in 1..n){
            sums[i][j] = sums[i-1][j]+sums[i][j-1]+mat[i-1][j-1]-sums[i-1][j-1]
        }
    }
    for(i in 0 until m){
        for(j in 0 until n){
            val i1 = if(i-k<0) 0 else i-k
            val j1 = if(j-k<0) 0 else j-k
            val i2 = if(i+k>=m) m-1 else i+k
            val j2 = if(j+k>=n) n-1 else j+k
            ret[i][j] = sums[i2+1][j2+1]+sums[i1][j1]-sums[i2+1][j1]-sums[i1][j2+1]
        }
    }
    return ret   
}