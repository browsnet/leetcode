class Solution 
fun Solution.kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    val m = nums1.size
    val n = nums2.size
    val heap = PriorityQueue<Pair<Int,Int>>(k) {
        (a1,b1),(a2,b2) -> nums1[a1]-nums1[a2]+nums2[b1]-nums2[b2]
    }
    for(i in 0 until Math.min(m,k))
        heap.add(i to 0)
    val ret = mutableListOf<List<Int>>()
    while(heap.size>0){
        val (a,b) = heap.poll()
        ret.add(listOf(nums1[a],nums2[b]))
        if(ret.size==k) break
        if(b<n-1) heap.add(a to b + 1)
    }
    return ret
}