class Solution
fun Solution.getFactors(n: Int,start:Int=2): List<List<Int>> {
    if(n<=start) return emptyList()
    val end = Math.sqrt(n.toDouble()).toInt()
    val ret = mutableListOf<List<Int>>()
    for(i in start..end){
        if(n%i!=0) continue
        val k = n/i
        ret.add(listOf(i,k))
        for(lst in getFactors(k,i)){
            ret.add(listOf(i)+lst)
        }
    }
    return ret
}