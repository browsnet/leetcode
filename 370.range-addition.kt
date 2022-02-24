class Solution 
fun Solution.getModifiedArray(length: Int, updates: Array<IntArray>): IntArray {
    val arr = IntArray(length+1)
    for((start,end,inc) in updates){
        arr[start] += inc
        arr[end+1] -= inc
    }
    for(i in 1..length){
        arr[i] += arr[i-1]
    }
    return arr.dropLast(1).toIntArray()
}