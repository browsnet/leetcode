class Solution 
fun Solution.maximumEvenSplit(finalSum: Long): List<Long> {
    if(finalSum%2L !=0L) return listOf<Long>()
    val sum = finalSum/2L
    var k = 1L
    var x = 1L
    while(x<=sum){
        k++
        x += k
    }
    x -= k
    k--
    if(x==sum) return (1L..k).map {it*2}
    if(sum-x<=k){
        x -= k
        k--
    }
    val ret = (1L..k).map {it*2}.toMutableList()
    ret.add(finalSum-ret.sum())
    return ret
}