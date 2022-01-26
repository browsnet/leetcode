class Solution 
fun Solution.maxRunTime(n: Int, batteries: IntArray): Long {
    batteries.sort()
    var sum = batteries.fold(0L) {acc,num->acc+num}
    var m = n 
    for (i in batteries.size-1 downTo 0) {
        if (batteries[i] <= sum / m) {
            return sum / m
        }
        sum -= batteries[i]
        m--
    }
    return 0L
}
