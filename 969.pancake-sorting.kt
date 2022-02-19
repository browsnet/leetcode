class Solution 
fun Solution.pancakeSort(arr: IntArray): List<Int> {
    val n = arr.size
    fun reverse(end:Int) {
        var i = 0
        var j = end
        while(i<j){
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
            i++
            j--
        }
    }
    val ret = mutableListOf<Int>()
    for (j in n downTo 2) {
        var i = (0 until j).maxBy {arr[it]}!!
        if (i == j - 1) continue
        reverse(i)
        reverse(j - 1)
        ret.add(i + 1)
        ret.add(j)
    }
    return ret
}