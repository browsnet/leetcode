class Solution 
fun Solution.stoneGameIX(stones: IntArray): Boolean {
    // 把石子分成三类，用价值余3进行分类
    val cnts = IntArray(3)
    for(i in stones) cnts[i%3]++
    val (a,b,c) = cnts
    // 如果类型 a 的石子的个数为偶数，那么 Alice 获胜当且仅当类型 b 和类型 c 的石子至少都有 1 个；
    if(a%2==0) return b>0 && c>0
    // 如果类型 a 的石子的个数为奇数，那么 Alice 获胜当且仅当「在没有类型 a 石子的情况下，Bob 获胜且原因不是因为所有石子都被移除」。
    // 对应到上面的分析即为「类型 b 的石子比类型 c 多超过 2 个」或者「类型 c 的石子比类型 b 多超过 2 个」。
    return b>c+2 || b<c-2
}