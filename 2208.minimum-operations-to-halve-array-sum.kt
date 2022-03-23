class Solution 
fun Solution.halveArray(nums: IntArray): Int {
    // 这里Double的比较，必须要判断大小然后返回正负数
    val pq = PriorityQueue<Double> {a,b-> if(b-a>0)1 else -1}
    val n = nums.size
    var x = (nums.fold(0L) {acc,num->acc+num}).toDouble()
    var sum = x/2
    for(num in nums) pq.add(num.toDouble())
    var ret = 0
    while(x>sum){
        var num = pq.poll()
        if(pq.size>0){
            val second = pq.peek()
            while(num>=second){
                if(x<=sum) return ret
                num = num/2
                x -= num
                ret++
            }
            pq.add(num)
        }else{
            val v = num/2
            x -= v
            pq.add(v)
            ret++
        }

    }
    return ret
}