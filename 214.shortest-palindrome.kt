class Solution 
// KMP
fun Solution.shortestPalindrome(s: String): String {
    val n = s.length
    val fail = IntArray(n) 
    var j = 0
    for(i in 1 until n){
        while(j>0 && s[j] != s[i])
            j = fail[j-1]
        if(s[j] == s[i]) fail[i] = ++j
    }
    var best = 0
    for(i in n-1 downTo 0){
        while(best>0 && s[best] != s[i])
            best = fail[best-1]
        if(s[best] == s[i]) best++
    }
    if(best==n) return s
    return s.substring(best).reversed()+s
}
