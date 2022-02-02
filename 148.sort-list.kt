class Solution 
// 归并排序，把链表拆成两半，各自排序，最后合并两个已排序的链表
fun Solution.sortList(head: ListNode?): ListNode? {
    // 单元素
    if(head?.next==null) return head
    var slow:ListNode? = ListNode()
    slow?.next = head
    var fast = slow
    while(fast?.next!=null){
        slow = slow?.next
        fast = fast?.next.next
    }
    val next = slow?.next
    slow?.next = null
    var left = sortList(head)
    var right = sortList(next)
    // 合并两个有序链表
    val dumy = ListNode()
    var current = dumy
    while(left!=null && right!=null){
        val node = if(left.`val`<right.`val`) left else right
        val next = node.next
        node.next = null
        current.next = node
        current = node
        if(node==left) left = next
        else right = next
    }
    if(left!=null) current.next = left
    if(right!=null) current.next = right
    return dumy.next
}