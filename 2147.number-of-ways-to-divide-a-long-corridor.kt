class Solution 
val MOD = 1000000007
// 统计每个座位的下标，然后两两分割，中间的间隔位数就是可选数
fun Solution.numberOfWays(corridor: String): Int {
    val n = corridor.length
    val ids = mutableListOf<Int>()
    for(i in 0 until n)
        if(corridor[i]=='S') ids.add(i)
    val m = ids.size
    // 奇数个座位
    if(m==0 || m%2==1) return 0
    var ret = 1L
    for(i in 1 until m-1 step 2){
        val k = ids[i+1]-ids[i]
        ret = ret*k%MOD
    }
    return ret.toInt()
}