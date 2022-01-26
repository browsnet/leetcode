class Solution 
fun Solution.numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
    val n = differences.size
    val sums = IntArray(n+1)
    for(i in 0 until n){
        sums[i+1] = sums[i]+differences[i]
    }
    val min = sums.min()!!
    val max = sums.max()!!
    val diff = max.toLong()-min
    val diff2 = upper.toLong()-lower
    if(diff2<diff) return 0
    return (diff2-diff+1).toInt()
}