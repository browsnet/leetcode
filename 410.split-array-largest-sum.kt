class Solution 
fun Solution.splitArray(nums: IntArray, m: Int): Int {
    var left = 0
    var right = Int.MAX_VALUE
    loop@while(left<right){
        val middle = left+(right-left)/2
        var n = 1
        var pre = 0
        for(num in nums){
            // 根本不够分
            if(num>middle){
                left = middle+1
                continue@loop
            }
            pre += num
            if(pre>middle){
                pre = num
                n++
            }
        }
        if(n<=m){
            right = middle
        }else left = middle+1
    }
    return right
}