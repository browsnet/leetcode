class Solution 
// 位运算枚举单词表，然后验证
fun Solution.maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
    val n = words.size
    val right = Math.pow(2.0,n.toDouble()).toInt()-1
    val letterArray = IntArray(26)
    var max = 0
    for(char in letters){
        letterArray[char-'a']++
    }
    loop@for(i in 1..right){
        var arr = IntArray(26)
        for(j in 0 until n){
            if((i shr j) and 1 == 1){
                for(char in words[j]){
                    arr[char-'a']++
                }
            }
        }
        for(i in 0..25){
            if(arr[i]>letterArray[i]) continue@loop
        }
        var num = 0
        for(i in 0..25) num += arr[i]*score[i]
        max = Math.max(max,num)
    }
    return max
}