class Solution 
val MOD = 1000000007
fun Solution.maxSum(nums1: IntArray, nums2: IntArray): Int {
    val m = nums1.size
    val n = nums2.size
    val max = Math.max(nums1[m-1],nums2[n-1])
    val cached = LongArray(max+1)
    fun dfs(num:Int):Long{
        if(cached[num]>0L) return cached[num]
        val a = binarySearch(nums1,num)
        val b = binarySearch(nums2,num)
        cached[num] = (0L+num + when{
            a<0 -> if(b==n-1) 0 else dfs(nums2[b+1])
            b<0 -> if(a==m-1) 0 else dfs(nums1[a+1])
            a==m-1 && b==n-1 -> 0
            a==m-1 -> dfs(nums2[b+1])
            b==n-1 -> dfs(nums1[a+1])
            else -> Math.max(dfs(nums1[a+1]),dfs(nums2[b+1]))
        })
        return cached[num]
    }
    return (Math.max(dfs(nums1[0]),dfs(nums2[0]))%MOD).toInt()
    
}
fun binarySearch(nums:IntArray,target:Int):Int{
    var left = 0
    var right = nums.size-1
    while(left<=right){
        val m = left+(right-left)/2
        if(nums[m]>target){
            right = m-1
        }else if(nums[m]<target){
            left = m+1
        }else return m
    }
    return -1
}