class Solution
// 使用二进制枚举所有状态，0为好人1为坏人
// 只检查好人的表述是否冲突
fun Solution.maximumGood(statements: Array<IntArray>): Int {
    val n = statements.size
    val max = Math.pow(2.0,n.toDouble()).toInt()
    var ret = 0
    fun check(arr:Array<Boolean>):Boolean{
        for(i in 0 until n){
            if(!arr[i]) continue
            // 认定i的话都是真的
            for(j in 0 until n){
                val a = statements[i][j]
                if(a==2) continue
                // 如果认为j是坏人，但之前假设了j是好人，那么假设错了
                if(a==0 && arr[j]) return false
                if(a==1 && !arr[j]) return false
            }
        }
        return true
    }
    for(num in 0 until max){
        val arr = Array(n) {false}
        var k = 0
        for(i in 0 until n){
            if(((num shr i) and 1)==1) continue
            arr[i] = true
            k++
        }

        if(check(arr))
           ret = Math.max(ret,k)
    }
    return ret
}