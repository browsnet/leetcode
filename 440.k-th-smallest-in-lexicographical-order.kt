class Solution 
// 十叉树找数量
fun Solution.findKthNumber(n: Int, k: Int): Int {
    var i = 1L
    var m = k.toLong()-1
    while(m>0){
        var num = 0L
        var j = i
        var next = j + 1
        while(j <= n){
            num += Math.min(n - j + 1, next - j)
            next *= 10
            j *= 10
        }
        if (m >= num) {
            m -= num
            i++
        } else {
            m--
            i *= 10
        }
    }
    return i.toInt()
}