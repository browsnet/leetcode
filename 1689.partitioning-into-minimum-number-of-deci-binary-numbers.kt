class Solution 
tailrec fun Solution.minPartitions(n: String,ret:Int=0): Int {
    if(n=="" || n=="0") return ret
    val sb = StringBuilder()
    var preZero = true
    for(char in n){
        val newChar = if(char>='1') char-1 else char
        if(newChar=='0' && preZero) continue
        preZero = false
        sb.append(newChar)
    }
    return minPartitions(sb.toString(),ret+1)
}