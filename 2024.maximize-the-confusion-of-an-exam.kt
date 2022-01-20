class Solution 
fun Solution.maxConsecutiveAnswers(answerKey: String, k: Int): Int {
    val n = answerKey.length
    var sumt = 0
    var sumf = 0
    var ret = 0
    var left = 0
    for(right in 0 until n){
        if(answerKey[right] == 'T') sumt++
        else sumf++
        // 当两个计数都超过k时, 需要收缩窗口
        while(sumt > k && sumf > k){
            if(answerKey[left] == 'T') sumt--
            else sumf--
            left++
        }
        ret = Math.max(ret, right-left+1)
    }
    return ret
}