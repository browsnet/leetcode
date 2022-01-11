class Solution 
fun Solution.minMoves(nums: IntArray, k: Int): Int {
    val n = nums.size
    val lst = mutableListOf<Long>()
    for(i in 0 until n){
        if(nums[i]==0) continue
        val v = i-lst.size - 1
        lst.add(v.toLong())
    }
    val sum = LongArray(lst.size+1) {0L}
    for(i in 1..lst.size){
        sum[i] = sum[i-1] +lst[i-1]
    }
    var min = Long.MAX_VALUE
    for(i in 0 until lst.size+1-k){
        val j = i+k-1
        val mid = (i+j)/2
        val left = lst[mid]*(mid-i) - (sum[mid]-sum[i])
        val right = sum[j + 1] - sum[mid + 1] - (j - mid) * lst[mid]
        min = Math.min(min, left + right)
    }
    return min.toInt()
}