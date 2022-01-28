class Solution 
fun Solution.findInteger(k: Int, digit1: Int, digit2: Int): Int {
    val a = Math.min(digit1,digit2).toLong()
    val b = Math.max(digit1,digit2).toLong()
    if(a==0L && b==0L) return -1
    val lst = mutableListOf(a,b)
    while(lst.size>0){
        val n = lst.removeAt(0)
        if(n>Int.MAX_VALUE) return -1
        if(n>k && n%k==0L) return n.toInt()
        lst.add(n*10+a)
        lst.add(n*10+b)
    }
    return -1
}