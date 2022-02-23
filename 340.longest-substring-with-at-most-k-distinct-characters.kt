class Solution 
// 二分查找，假设t，然后通过t来算出最小包含不同字符，和题目的k做对比
fun Solution.lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
    val n = s.length
    fun check(m:Int):Boolean{
        val count = mutableMapOf<Char,Int>()
        for(i in 0 until m){
            val char = s[i]
            count[char] = (count[char]?:0)+1
        }
        var min = count.size
        if(min<=k) return true
        for(i in m until n){
            val char = s[i]
            val old = s[i-m]
            count[char] = (count[char]?:0)+1
            if(count[old]!! == 1) count.remove(old)
            else count[old] = (count[old]?:0)-1
            min = Math.min(min,count.size)
        }
        return min<=k
    }
    var left = 0
    var right = n
    var ret = 0 
    while(left<=right){
        val m = left+(right-left)/2
        if(check(m)){
            left = m+1
            ret = m
        }else right = m-1
    }
    return ret
}