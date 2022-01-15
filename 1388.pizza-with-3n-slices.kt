class Solution 
fun Solution.maxSizeSlices(slices: IntArray): Int {
    val n = slices.size
    val a = calculate(slices.take(n-1))
    val b = calculate(slices.takeLast(n-1))
    return Math.max(a, b)
}
fun calculate(lst:List<Int>):Int{
    val n = lst.size
    var choose = (n+1)/3
    val dp = Array(n+1) {IntArray(choose+1)}
    for(i in 1..n){
        for(j in 1..choose){
            val v = if(i>=2)  dp[i-2][j-1] else 0
            dp[i][j] = Math.max(dp[i-1][j],v+lst[i-1])
        }
    }
    return dp[n][choose]
}