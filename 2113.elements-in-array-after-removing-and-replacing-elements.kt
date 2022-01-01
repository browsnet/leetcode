class Solution 
fun Solution.elementInNums(nums: IntArray, queries: Array<IntArray>): IntArray {
    val n = nums.size
    fun getValue(query:IntArray):Int{
        val (time,index) = query
        if(index>=n) return -1
        val m = time%(2*n)
        if(m==n) return -1
        if(m==0) return nums[index]
        if(m>n) return if(index<m-n) nums[index] else -1
        if(index+m>=n) return -1
        return nums[index+m]
    }
    return queries.map {getValue(it)}.toIntArray()
}