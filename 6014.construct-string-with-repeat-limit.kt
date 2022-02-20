class Solution 
fun Solution.repeatLimitedString(s: String, repeatLimit: Int): String {
    val n = s.length
    val arr = IntArray(26)
    for(char in s) arr[char-'a']++
    val sb = StringBuilder()
    while(true){
        var x = 25
        var hasPre = false
        while(x>=0){
            if(arr[x]==0) {
                x--
                continue
            }
            if(sb.length>0 && sb[sb.length-1]-'a'==x) {
                hasPre = true
                x--
                continue
            }
            break
        }
        
        if (x<0) break
        var minusNum = Math.min(repeatLimit,arr[x])
        if(hasPre) minusNum = 1
        if(minusNum==0) break
        arr[x] -= minusNum
        val char = 'a'+x
        sb.append("$char".repeat(minusNum))
    }
    return sb.toString()
}