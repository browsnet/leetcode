class Solution 
fun Solution.minimumRemoval(beans: IntArray): Long {
    beans.sort()
    val n = beans.size
    var sum = beans.fold(0L) {s,n->s+n}
    var min = sum
    var pre = 0L
    for(i in 0 until n){
        // 假设都变为beans[i]
        min = Math.min(min,pre+sum-(n-i).toLong()*beans[i])
        sum -= beans[i]
        pre += beans[i]
    }
    return min
}