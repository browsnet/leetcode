class Solution 
fun Solution.groupStrings(words: Array<String>): IntArray {
    val n = words.size
    val nums = words.map {
        var num = 0
        for(char in it){
            num = num or (1 shl (char-'a'))
        }
        num
    }
    val map = mutableMapOf(nums[0] to nums[0])
    fun getParent(num:Int):Int{
        var current = num
        while(map[current] != current){
            current = map[current]!!
        } 
        map[num] = current
        return current
    }
    fun merge(a:Int,b:Int){
        if(map[a]==null) map[a] = a
        if(map[b]==null) map[b] = b
        map[getParent(b)] = getParent(a)
    }
    for(i in 1 until n){
        val num = nums[i]
        for(j in 0 until 26){
            val v1 = 1 shl j
            val num1 = v1 xor num
            if(map[num1]!=null){
                merge(num1,num)
            } 
            if((num shr j) and 1 ==0) continue
            for(k in 0 until 26){
                if((num shr k) and 1 ==1) continue
                val v2 = 1 shl k
                val v3 = v1 or v2
                val num2 = v3 xor num
                if(map[num2]!=null){
                    merge(num2,num)
                } 
            }
        }
        if(map[num]==null) map[num] = num
    }
    val counter = mutableMapOf<Int,Int>()
    for(i in 0 until n){
        val num = nums[i]
        val p = getParent(num)
        counter[p] = (counter[p]?:0)+1
    }
    val size = counter.size
    val max = counter.values.max()?:1
    return intArrayOf(size,max)
}
