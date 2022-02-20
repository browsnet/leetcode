class Solution 
fun Solution.coutPairs(nums: IntArray, k: Int): Long {
    val factors = mutableMapOf<Int,Long>(k to 0)
    for(i in 2..sqrt(k)){
        if(k%i!=0) continue
        factors[i] = 0L
        factors[k/i] = 0L
    }
    for(key in factors.keys){
        if(nums[0]%key!=0) continue
        factors[key] = (factors[key]?:0L)+1L
    }
    val n = nums.size
    val arr = nums.map {gcd(it,k)}
    var ret = 0L
    for(i in 1 until n){
        val num = nums[i]
        val p = gcd(num,k)
        val y = k/p
        // 全部都是
        if(y==1) ret += i
        else {
            // 在前面寻找能被y整除的数字
            ret += (factors[y]?:0L)
        }
        val keys = factors.keys
        for(key in keys){
            if(num%key!=0) continue
            factors[key] = (factors[key]?:0L)+1L
        }
    }
    return ret
}
fun sqrt(i:Int):Int{
    return Math.sqrt(i.toDouble()).toInt()
}
tailrec fun gcd(a:Int,b:Int):Int{
    if(a==b) return a
    if(a>b) return gcd(b,a)
    if(a==0) return b
    return gcd(b%a,a)
}