/*
 * @lc app=leetcode.cn id=1001 lang=kotlin
 *
 * [1001] Grid Illumination
 */

// @lc code=start
class Solution 
val dirs = listOf(-1,0,1)
fun Solution.gridIllumination(n: Int, lamps: Array<IntArray>, queries: Array<IntArray>): IntArray {
    val set = lamps.map {it[0] to it[1]}.toMutableSet()
    val coloums = mutableMapOf<Int,Int>()
    val rows = mutableMapOf<Int,Int>()
    val diagonals = mutableMapOf<Int,Int>()
    val backDiagonals = mutableMapOf<Int,Int>()
    fun MutableMap<Int,Int>.decr(key:Int){
        val x = this[key]
        if(x==null) return
        if(x==1) this.remove(key)
        else this[key] = x-1
    }
    for((a,b) in set){
        coloums[a] = (coloums[a]?:0)+1
        rows[b] = (rows[b]?:0)+1
        diagonals[a-b] = (diagonals[a-b]?:0)+1
        backDiagonals[a+b] = (backDiagonals[a+b]?:0)+1
    }

    var ans = mutableListOf<Int>()
    for((a,b) in queries){
        var ret = 0
        if(coloums[a]!=null || rows[b]!=null || 
            diagonals[a-b]!=null || backDiagonals[a+b]!=null) ret = 1
        ans.add(ret)
        for(da in dirs){
            for(db in dirs){
                val na = a+da
                val nb = b+db
                if(na<0 || nb<0) continue
                if(na>=n || nb>=n) continue
                val p = na to nb
                if(!(p in set)) continue
                set.remove(p)
                coloums.decr(na)
                rows.decr(nb)
                diagonals.decr(na-nb)
                backDiagonals.decr(na+nb)
            }
        }
    }
    return ans.toIntArray()
}
// @lc code=end

