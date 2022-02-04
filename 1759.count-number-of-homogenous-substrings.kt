class Solution 
val MOD = 1000000007
fun Solution.countHomogenous(s: String): Int {
    var ret = 0L
    // 连续k个相同字符
    var k = 1L
    for(i in 1..s.length){
        if(i<s.length && s[i]==s[i-1]){
            k++
        }else{
            ret = (ret + k*(k+1)/2)%MOD
            k = 1L
        }
    }
    return ret.toInt()
}