class Solution 
fun Solution.minimumCost(cost: IntArray): Int {
    cost.sortDescending()
    val n = cost.size
    val k = n/3
    var ret = 0
    for(i in 0 until k){
        ret +=  cost[3*i]
        ret +=  cost[3*i+1]
    }
    for(i in 3*k until n){
        ret += cost[i]
    }
    return ret
}