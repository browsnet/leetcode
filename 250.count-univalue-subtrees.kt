class Solution 
fun Solution.countUnivalSubtrees(root: TreeNode?): Int {
    var ret = 0
    fun dfs(node:TreeNode?):Boolean{
        if(node==null) return true
        val matchLeft = if(node.left==null) true else
            dfs(node.left) && node.`val` == node.left.`val`
        val matchRight = if(node.right==null) true else
            dfs(node.right) && node.`val` == node.right.`val`
        if(matchLeft && matchRight){
            ret++
            return true
        }
        return false
    }
    dfs(root)
    return ret
}