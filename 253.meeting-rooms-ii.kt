class Solution 
// 维持一个最小堆，从start算起，把end推进队列里，如果之前的end小于当前start就出列
// 队列长度就是会议室的最小数量
fun Solution.minMeetingRooms(intervals: Array<IntArray>): Int {
    val n = intervals.size
    intervals.sortBy {it[0]}
    val queue = PriorityQueue<Int> {a,b->a-b}
    var ret = 1
    for(i in 0 until n){
        val (start,end) = intervals[i]
        while(queue.size>0 && queue.peek()<=start)
            queue.poll()
        queue.add(end)
        ret = Math.max(ret,queue.size)
    }
    return ret
}