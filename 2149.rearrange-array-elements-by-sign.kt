class Solution 
fun Solution.rearrangeArray(nums: IntArray): IntArray {
    val n = nums.size
    val lst1 = mutableListOf<Int>()
    val lst2 =  mutableListOf<Int>()
    for(num in nums){
        if(num>0) lst1.add(num)
        else lst2.add(num)
    }
    val ret = IntArray(n)
    for(i in 0 until lst1.size){
        ret[2*i] = lst1[i]
        ret[2*i+1] = lst2[i]
    }
    return ret
}