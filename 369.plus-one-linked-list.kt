class Solution 
fun Solution.plusOne(head: ListNode?): ListNode? {
    val x = reverse(head)
    var current = x
    var one = true
    while(current!=null){
        if(!one) break
        val v = current.`val`+1
        current.`val` = v%10
        if(v<10) one = false
        if(current.next==null) break
        current = current.next
    }
    if(one) current?.next = ListNode(1)
    return reverse(x)
}
fun reverse(head:ListNode?):ListNode?{
    val dummy = ListNode()
    var current = head
    while(current!=null){
        val next = current.next
        current.next = dummy.next
        dummy.next = current
        current = next
    } 
    return dummy.next
}