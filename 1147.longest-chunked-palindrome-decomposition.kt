class Solution 
// 字符串哈希可以快速的比较两段字符串是否相等
tailrec fun Solution.longestDecomposition(text: String,ret:Int=0): Int {
    if(text=="") return ret
    var preHash = 0L
    var tailHash = 0L
    val base1 = 131131L
    var base2 = 1L
    val n = text.length
    for(i in 0 until n/2){
        val k = text[i]-'a'
        preHash = preHash*base1+k
        tailHash = (text[n-1-i]-'a')*base2 + tailHash
        base2 *= base1
        if(preHash==tailHash){
            val ns = text.substring(i+1,n-1-i)
            return longestDecomposition(ns,ret+2)
        }
    }
    return ret+1   
}