class Solution 
fun Solution.shareCandies(candies: IntArray, k: Int): Int {
    val n = candies.size
    val map = mutableMapOf<Int,Int>()
    for(i in 0 until n)
        map.incr(candies[i])

    if(k==0) return map.size
    for(i in 0 until k){
        map.decr(candies[i])
    }
    var ret = map.size
    for(i in k until n){
        map.incr(candies[i-k])
        map.decr(candies[i])
        ret = Math.max(ret,map.size)
    }
    return ret
}
fun MutableMap<Int,Int>.incr(v:Int){
    this[v] =  (this[v]?:0)+1
}
fun MutableMap<Int,Int>.decr(v:Int){
    if(this[v]==1) this.remove(v)
    else this[v] = this[v]!!-1
}