class Solution 
fun TreeNode?.count():Int = 
    if(this==null) 0 else left.count()+right.count()+1

fun findNode(node:TreeNode?, x:Int): TreeNode?{
    if(node == null) return null
    if(node.`val` == x) return node
    val left = findNode(node.left, x)
    val right = findNode(node.right, x)
    return if(left != null) left else right
}
// 贪心算法，已知红色节点，那么蓝色点可以下在红色节点的左、右或者父节点的其他分支任意位置
// 然而只有最靠近红色节点才是最优选择，放在其他格子上就白白送子
// 如果红色和红色子树小于一半，那么下在红色的父元素也能获胜
// 否则不可能获胜
fun Solution.btreeGameWinningMove(root: TreeNode?, n: Int, x: Int): Boolean {
    val node = findNode(root, x)
    val left = node?.left.count()
    val right = node?.right.count()
    val half = n/2
    return left > half || right > half || left + right < half
}