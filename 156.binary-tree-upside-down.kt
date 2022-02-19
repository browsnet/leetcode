class Solution 
fun Solution.upsideDownBinaryTree(root: TreeNode?): TreeNode? {
    if(root==null) return null
    fun dfs(node:TreeNode,parent:TreeNode?):TreeNode{
        var root = node
        if(node.left!=null)
            root = dfs(node.left!!,node)
        node.left = parent?.right
        node.right = parent
        return root
    }
    return dfs(root,null)
}