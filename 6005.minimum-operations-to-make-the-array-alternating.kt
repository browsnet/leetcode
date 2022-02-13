class Solution 
fun Solution.minimumOperations(nums: IntArray): Int {
    val n = nums.size
    if(n==1) return 0
    val map1 = mutableMapOf(0 to 0)
    val map2 = mutableMapOf(0 to 0)
    for(i in 0 until n){
        if(i%2==0) map1[nums[i]] = (map1[nums[i]]?:0)+1
        else map2[nums[i]] = (map2[nums[i]]?:0)+1
    }
    val lst1 = map1.entries.sortedByDescending {it.value}
    val lst2 = map2.entries.sortedByDescending {it.value}
    val v1 = lst1.map {it.value}
    val v2 = lst2.map {it.value}
    if (lst1[0].key!=lst2[0].key) return n-v1[0]-v2[0]
    return n-Math.max(v1[0]+v2[1],v1[1]+v2[0])
}