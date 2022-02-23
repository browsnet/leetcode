class Solution 
val factors = listOf(2,3,5,7)
fun Solution.smallestFactorization(num: Int): Int {
    if(num<10) return num
    fun dfs(num:Int):List<Int>?{
        if(num==1) return listOf<Int>()
        var f = 1
        for(factor in factors){
            if(num%factor==0){
                f = factor
                break
            }
        }
        if(f==1) return null
        val ret = dfs(num/f)
        if(ret==null) return null
        return ret+f
    }
    val lst = dfs(num)
    if(lst==null) return 0
    val map = IntArray(10)
    for(num in lst) map[num]++
    while(map[2]>=3){
        map[2] -= 3
        map[8] += 1
    } 
    while(map[3]>=2){
        map[3] -= 2
        map[9] += 1
    } 
    while(map[2]>=1 && map[3]>=1){
        map[3] -= 1
        map[2] -= 1
        map[6] += 1
    } 
    while(map[2]>=2){
        map[2] -= 2
        map[4] += 1
    } 
    val arr = (2..9).filter {map[it]>0}.flatMap {e->IntArray(map[e]) {e}.toList()}.sorted()
    if(arr.size>10) return 0
    val ret = arr.joinToString("").toLong()
    if(ret>Int.MAX_VALUE) return 0
    return ret.toInt()
}