class Solution 
fun Solution.numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
    val m = matrix.size
    val n = matrix[0].size
    // 每一列的前缀和
    val sumArr = Array(m) {IntArray(n+1)}
    for(i in 0 until m){
        for (j in 0 until n)
            sumArr[i][j+1] = sumArr[i][j] + matrix[i][j]
    }
    var ret = 0
    // 左右范围枚举定界
    for(i in 0 until n){
        for(j in i until n){
            // 由于每一列都是前缀和，可以直接把[left,right]区间压成一个一维数组
            // 通过HashMap来解决，复杂度O(n)
            val map = mutableMapOf(0 to 1)
            var pre = 0
            for(k in 0 until m){
                // 得到第i行的[left,right]区间和
                pre += sumArr[k][j+1]-sumArr[k][i]
                // 如果有pre-target，表示找到了和为target的区间
                ret +=  (map[pre-target]?:0)
                map[pre] = (map[pre]?:0)+1
            }
        }
    }
    return ret
}