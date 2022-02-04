class Solution 
// 二分检查
fun Solution.minmaxGasDist(stations: IntArray, k: Int): Double {
    val n = stations.size
    // 假设penalty值，查看是否可以在新增k个加油站的基础上达成
    fun check(penalty:Double):Boolean{
        var num = 0
        for(i in 1 until n){
            val distance = (stations[i]-stations[i-1]).toDouble()
            if(distance<=penalty) continue
            num += Math.ceil(distance/penalty).toInt()-1
        }
        return num<=k
    }
    var left:Double = 0.0
    var right = (stations.last()-stations[0]).toDouble()
    var ret = 0.0
    while(left<right-0.000001){
        val m = left+(right-left)/2
        if(check(m)){
            right = m
        }else{
            left = m
        }
    }
    return left
}