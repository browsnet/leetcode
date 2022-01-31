class Solution 
data class Job(val start:Int,val end:Int,val profit:Int)
// 按结束时间排序
fun Solution.jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
    val n = startTime.size
    val jobs = mutableListOf<Job>()
    for(i in 0 until n)
        jobs.add(Job(startTime[i],endTime[i],profit[i]))
    jobs.sortBy {it.end}
    val cached = IntArray(n)
    fun dfs(i:Int):Int{
        if(i<0) return 0
        // 只有1份
        if(i==0) return jobs[0].profit
        if(cached[i]>0) return cached[i]
        // 要找到比当前start小的end
        val start = jobs[i].start
        var left = 0
        var right = i-1
        var index = -1
        while(left<=right){
            val m = left+(right-left)/2
            val v = jobs[m].end
            if(v<=start){
                index = m
                left = m+1
            }else right = m-1
        }
        var max = jobs[i].profit + dfs(index)
        max = Math.max(max,dfs(i-1))
        cached[i] = max
        return max
    }
    return dfs(n-1)
}