class Solution 
// 记录下三个变量，pre≤first<second
// 找到num>second就返回true
fun Solution.increasingTriplet(nums: IntArray): Boolean {
    val n = nums.size
    if(n<3) return false
    var first = nums[0]
    var second = nums[0]
    var i = 1
    while(i<n){
        if(nums[i]>first){
            second = nums[i]
            break
        }else if(nums[i]<first){
            first = nums[i]
            i++
        }else i++
    }
    // 规定pre要≤first
    var pre = first
    for(j in i+1 until n){
        val num = nums[j]
        if(num>second) return true
        // 可以替换掉second
        if(num<second && num>first){
            second = num
        }else if(num<second && num>pre){
            second = num
            first = pre
        }else if(num<first) pre = num
    }
    return false
}