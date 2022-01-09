class Solution 
fun Solution.shortestWordDistance(wordsDict: Array<String>, word1: String, word2: String): Int {
    if(word1==word2) return check(wordsDict,word1)
    val n = wordsDict.size
    var p1 = -1
    var p2 = -1
    var min = Int.MAX_VALUE
    for(i in 0 until n){
        val str = wordsDict[i]
        if(str!=word1 && str!=word2) continue
        if(p1>=0 && p2>=0){
            min = Math.min(min,Math.abs(p2-p1))
        }
        if(str==word1) p1 = i
        if(str==word2) p2 = i
    }
    if(p1>=0 && p2>=0) min = Math.min(min,Math.abs(p2-p1))
    return min 
}
fun check(wordsDict: Array<String>, word: String):Int{
    val n = wordsDict.size
    var pre = -1
    var min = Int.MAX_VALUE
    for(i in 0 until n){
        val str = wordsDict[i]
        if(str!=word) continue
        if(pre>=0){
            min = Math.min(min,i-pre)
        }
        pre = i
    }
    return min
}