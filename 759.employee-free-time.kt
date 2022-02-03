class Solution 
data class Job(val id:Int,val index:Int)
fun Solution.employeeFreeTime(schedule: ArrayList<ArrayList<Interval>>): ArrayList<Interval> {
    val n = schedule.size
    val ret = ArrayList<Interval>()
    val pq = PriorityQueue<Job> {
        a,b->schedule[a.id][a.index].start - schedule[b.id][b.index].start
    }
    var anchor = Int.MAX_VALUE
    for(i in 0 until n){
        val employee = schedule[i]
        pq.add(Job(i,0))
        anchor = Math.min(anchor,employee[0].start)
    }
    while (pq.size>0) {
        val job = pq.poll()
        val iv = schedule[job.id][job.index]
        if (anchor < iv.start)
            ret.add(Interval(anchor, iv.start))
        anchor = Math.max(anchor, iv.end)
        // 把该员工的下一个工作加进去
        if (job.index< schedule[job.id].size-1)
            pq.add(Job(job.id,job.index+1))
    }
    return ret
}