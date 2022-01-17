class Solution 
fun Solution.minFlipsMonoIncr(s: String): Int {
    var dp0 = 0
    var dp1 = 0
    if(s[0]=='0'){
        dp1 = 1
    }else{
        dp0 = 1
    }
    for(i in 1 until s.length){
        if(s[i]=='0'){
            dp1 = Math.min(dp0,dp1)+1
        }else{
            dp1 = Math.min(dp0,dp1)
            dp0++
        }
    }
    return Math.min(dp0,dp1)
}