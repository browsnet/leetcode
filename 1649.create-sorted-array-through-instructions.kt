class Solution 
val MOD = 1000000007
fun Solution.createSortedArray(instructions: IntArray): Int {
    val n = instructions.size
    val max = instructions.max()!!
    val tree = BIT(max)
    var ret = 0     
    for (i in 0 until n) {
        val num = instructions[i]
        // 小于num的数量
        val left = tree.query(num-1)
        // 总数i减去小于等于num的数量，也就是大于num的数量
        val right = i-tree.query(num)
        ret = (ret+Math.min(left,right))%MOD
        tree.add(num)
    }
    return ret
}
// 树状数组
class BIT(val n:Int){
    val tree = IntArray(n+1)
    tailrec fun add(x:Int):Unit{
        if(x>n) return
        tree[x]++
        return add(x+Integer.lowestOneBit(x))
    }
    tailrec fun query(x:Int,ret:Int=0):Int{
        if(x==0) return ret
        return query(x-Integer.lowestOneBit(x),ret+tree[x])
    }
}