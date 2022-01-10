/*
 * @lc app=leetcode.cn id=306 lang=kotlin
 *
 * [306] Additive Number
 */

// @lc code=start
class Solution 
// 枚举前两个数
fun Solution.isAdditiveNumber(num: String): Boolean {
    val n = num.length/3
    fun check(a:Long,b:Long,s:String):Boolean{
        var num1 = a
        var num2 = b
        var str = "$a$b"
        while(str.length<s.length){
            var c = num2
            num2 = num1+num2
            num1 = c
            str += "$num2"
        }
        return str==s
    }
    for(i in 1..n){
        // 不能有前导0
        if(num[0]=='0' && i>1) return false
        val a = num.substring(0,i).toLong()
        for(j in i+1..n*2){
            // 不能有前导0
            if(num[i]=='0' && j-i>1) break
            val b = num.substring(i,j).toLong()
            if(check(a,b,num)) return true
        }
    }
    return false
}
// @lc code=end

