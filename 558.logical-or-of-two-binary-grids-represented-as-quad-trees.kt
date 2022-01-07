/**
 * Definition for a QuadTree node.
 * class Node(var `val`: Boolean, var isLeaf: Boolean) {
 *     var topLeft: Node? = null
 *     var topRight: Node? = null
 *     var bottomLeft: Node? = null
 *     var bottomRight: Node? = null
 * }
 */
val Node.tl:Node get() = topLeft?:this
val Node.tr:Node get() = topRight?:this
val Node.bl:Node get() = bottomLeft?:this
val Node.br:Node get() = bottomRight?:this
class Solution 
fun Solution.intersect(quadTree1: Node?, quadTree2: Node?): Node? {
    if(quadTree1==null || quadTree2==null) return null
    if(quadTree1.isLeaf && quadTree2.isLeaf)
        return Node(quadTree1.`val` or quadTree2.`val`,true)
    val lst = mutableListOf<Node?>()
    lst.add(intersect(quadTree1.tl,quadTree2.tl))
    lst.add(intersect(quadTree1.tr,quadTree2.tr))
    lst.add(intersect(quadTree1.bl,quadTree2.bl))
    lst.add(intersect(quadTree1.br,quadTree2.br))
    if(lst.all {it!=null && it.isLeaf && it.`val`==lst[0]?.`val`}){
        return Node(lst[0]!!.`val`,true)
    }
    val node = Node(false,false)
    node.topLeft = lst[0]
    node.topRight = lst[1]
    node.bottomLeft = lst[2]
    node.bottomRight = lst[3]
    return node
}