class Solution 
fun Solution.construct(grid: Array<IntArray>): Node? {
    return construct(grid.map {it.map{it==1}})
}
fun construct(grid:List<List<Boolean>>):Node{
    val n = grid.size
    if(n==1) return Node(grid[0][0],true)
    val arr = mutableListOf<List<List<Boolean>>>()
    arr.add(grid.take(n/2).map {it.take(n/2)})
    arr.add(grid.take(n/2).map {it.takeLast(n/2)})
    arr.add(grid.takeLast(n/2).map {it.take(n/2)})
    arr.add(grid.takeLast(n/2).map {it.takeLast(n/2)})
    val nodes = arr.map {construct(it)}
    if(nodes.all {it.isLeaf && it.`val` == nodes[0].`val`}) {
        return Node(nodes[0].`val`,true)
    }
    val node = Node(false,false)
    node.topLeft = nodes[0]
    node.topRight = nodes[1]
    node.bottomLeft = nodes[2]
    node.bottomRight = nodes[3]
    return node
}