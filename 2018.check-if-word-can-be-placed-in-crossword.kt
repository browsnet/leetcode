class Solution 
fun Solution.placeWordInCrossword(board: Array<CharArray>, word: String): Boolean {
    val m = board.size
    val n = board[0].size
    val word2 = word.reversed()
    for(i in 0 until m){
        if(check(board[i].toList(),word,word2)) return true
    }
    for(j in 0 until n){
        if(check((0 until m).map {board[it][j]},word,word2)) return true
    }
    return false
}
fun check(lst:List<Char>,word: String,word2:String): Boolean {
    val arr = lst.joinToString("").split("#")
    for(str in arr){
        if(comapre(str,word)) return true
        if(comapre(str,word2)) return true
    }
    return false
}
fun comapre(a:String,b:String):Boolean{
    if(a.length!=b.length)return false
    for(i in 0 until a.length){
        if(a[i]==' ') continue
        if(a[i]!=b[i]) return false
    }
    return true
}