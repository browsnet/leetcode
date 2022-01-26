class Solution 
fun Solution.numberOfBeams(bank: Array<String>): Int {
    val m = bank.size
    val n = bank[0].length
    val emptyStr = "0".repeat(n)
    var ret = 0
    var pre = 0
    for(i in 0 until m){
        val s = bank[i]
        if(s==emptyStr) continue
        val num = s.fold(0) {acc,s->acc+(s-'0')}
        ret += (num*pre)
        pre = num
    }
    return ret
}