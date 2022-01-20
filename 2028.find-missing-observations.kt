class Solution 
fun Solution.missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
    val m = rolls.size
    val total = (n+m)*mean
    val sum = total - rolls.sum()
    val x = sum/n
    var rest = sum-x*n
    // 得到的数字不是1到6，肯定是不可能的
    if(x<1 || x>6) return intArrayOf()
    // 如果都是6，那不可能有余数
    if(x==6 && rest>0) return intArrayOf()
    val ret = IntArray(n) {x}
    for(i in 0 until n){
        if(rest==0) break
        ret[i]++
        rest--
    }
    return ret
}