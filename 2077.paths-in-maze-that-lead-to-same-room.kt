class Solution
fun Solution.numberOfPaths(n: Int, corridors: Array<IntArray>): Int {
    val arr = Array(n) {Array(n) {false}}
    for ((a,b) in corridors){
        arr[a-1][b-1] = true
        arr[b-1][a-1] = true
    }
    var ret = 0
    for ((a,b) in corridors){
        //只遍历比边上两点序号都小的第三点以去重
        val c = Math.min(a, b)-1
        for(i in 0 until c){
            if(arr[a-1][i] && arr[b-1][i])
                ret++
        }
    }
    return ret
}