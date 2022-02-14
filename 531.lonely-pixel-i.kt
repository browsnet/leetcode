class Solution 
fun Solution.findLonelyPixel(picture: Array<CharArray>): Int {
    val m = picture.size
    val n = picture[0].size
    val rows = IntArray(m)
    val cows = IntArray(n)
    val lst = mutableListOf<Pair<Int,Int>>()
    for(i in 0 until m){
        for(j in 0 until n){
            if(picture[i][j]=='W') continue
            rows[i]++
            cows[j]++
            lst.add(i to j)
        }
    }
    var ret = 0
    for((i,j) in lst){
        if(rows[i]==1 && cows[j]==1)
            ret++
    }
    return ret
}