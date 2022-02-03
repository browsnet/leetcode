class Solution 
enum class Sign{
    Plus,Minus,Times,Divs
}
sealed class Expr()
class Single(var num:Int):Expr()
class Compound():Expr(){
    val exprs = mutableListOf<Expr>()
    val signs = mutableListOf<Sign>()
}
// 先解析成树再递归执行
fun Solution.calculate(s: String): Int {
    return exec(parse(s))
}
fun parse(s:String):Compound{
    val root = Compound()
    val stack = mutableListOf(root)
    for(i in 0 until s.length){
        when(s[i]){
            '(' -> {
                val last = stack.last()
                val current = Compound()
                last.exprs.add(current)
                stack.add(current)
            }
            ')' -> stack.removeAt(stack.lastIndex)
            in '0'..'9' -> {
                val last = stack.last()
                if(i>0 && s[i-1] in '0'..'9'){
                    val numExpr = last.exprs.last()
                    if(numExpr is Single){
                        numExpr.num *=10
                        numExpr.num += (s[i]-'0')
                    }
                }else{
                    val numExpr = Single(s[i]-'0')
                    last.exprs.add(numExpr)
                }
            }
            else -> {
                val last = stack.last()
                last.signs.add(when(s[i]){
                    '+' -> Sign.Plus
                    '-' -> Sign.Minus
                    '*' ->  Sign.Times
                    else -> Sign.Divs
                })
            }
        }
    }
    return root
}
fun exec(e:Expr):Int=
  when(e){
    is Single -> e.num
    is Compound -> {
        val nums =  e.exprs.map {exec(it)}
        var ret = nums[0]
        val stack = mutableListOf(nums[0])
        for(i in 0 until e.signs.size){
            stack.add(when(e.signs[i]){
                Sign.Plus -> nums[i+1]
                Sign.Minus -> -nums[i+1]
                Sign.Times -> {
                    val v = stack.removeAt(stack.lastIndex)
                    v*nums[i+1]
                }
                Sign.Divs -> {
                    val v = stack.removeAt(stack.lastIndex)
                    v/nums[i+1]
                }
            })
        }
        stack.sum()
    }
 }