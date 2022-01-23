class Solution 
fun Solution.findLonely(nums: IntArray): List<Int> {
    val map = mutableMapOf<Int,Int>()
    for(num in nums){
        map[num] = (map[num]?:0)+1
    }
    return nums.filter {num->
        map[num]==1 && map[num-1]==null && map[num+1]==null
    }
}
