class Solution 
val coprimeGrid = isCoprimeGrid(50)
// 先建树，再DFS先序遍历
// 使用50个栈来保持从root到当前节点的所有编号和层数
// 提前计算好互质的对应关系，然后就可以查找和当前节点的数字互质的数
// 在互质的数理找到对应的栈，栈最后一位就是最近的，对比一下每个栈最后一位，就能找到最近祖先节点
fun Solution.getCoprimes(nums: IntArray, edges: Array<IntArray>): IntArray {
    val n = nums.size
    val graphs = buildGraph(n,edges)
    val max = nums.max()!!
    val stacks = Array(max+1) {mutableListOf<Pair<Int,Int>>()}
    val ret = IntArray(n)
    fun getCoprime(i:Int):Int{
        val num = nums[i]
        var near = -1 to -1
        for(k in 1..max){
            if(!coprimeGrid[num][k]) continue
            if(stacks[k].size==0) continue
            val last = stacks[k].last()
            if(last.second>near.second) near = last
        }
        return near.first
    }
    fun dfs(i:Int,depth:Int){
        ret[i] = getCoprime(i)
        val lst = graphs[i]
        if(lst.size==0) return
        val stack = stacks[nums[i]]
        stack.add(i to depth)
        for(j in lst) dfs(j,depth+1)
        stack.removeAt(stack.lastIndex)
    }
    dfs(0,0)
    return ret
}
// 建立互质数字表
fun isCoprimeGrid(max:Int):Array<Array<Boolean>>{
    val checks = Array(max+1) {Array(max+1) {false}}
    checks[1][1] = true
    for(i in 1..max){
        for(j in i+1..max){
            if(gcd(j,i)!=1) continue
            checks[i][j] = true
            checks[j][i] = true
        }
    }
    return checks
}
// 通过边建立一颗树，返回的是每个节点的children
fun buildGraph(n:Int, edges: Array<IntArray>):List<List<Int>>{
    val deps = Array(n) {mutableSetOf<Int>()}
    for((a,b) in edges){
        deps[a].add(b)
        deps[b].add(a)
    }
    fun dfs(i:Int){
        val lst = deps[i]
        if(lst.size==0) return  
        for(j in lst) deps[j].remove(i)
        for(j in lst) dfs(j)
    }
    dfs(0)
    return deps.map {it.toList()}
}

tailrec fun gcd(a:Int,b:Int):Int{
    if(b==0) return a
    return gcd(b,a%b)
}