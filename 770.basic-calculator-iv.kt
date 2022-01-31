class Solution 
// 运算符
enum class Sign { Plus,Minus,Times }
sealed class Block()
class NumBlock(var num:Int):Block()
class VarBlock(var variable:String):Block()
class Expression():Block(){
    val blocks = mutableListOf<Block>()
    val signs = mutableListOf<Sign>()
}
fun Solution.basicCalculatorIV(expression: String, evalvars: Array<String>, evalints: IntArray): List<String> {
    val n =  evalvars.size
    val map = mutableMapOf<String,Int>()
    for(i in 0 until n){
        map[evalvars[i]] = evalints[i]
    }
    val expr = parse(expression)
    val lst = calc(expr,map)
    val ret = mutableListOf<Item>()
    for(item in lst){
        if(item.num==0) continue
        ret.add(item)
    }
    ret.sort()
    return ret.map {
        if(it.vars=="") "${it.num}" 
        else "${it.num}*${it.vars}"
    }
}

fun parse(expression:String):Expression{
    val n = expression.length
    val root = Expression()
    val stack = mutableListOf(root)
    var pre:Block? = root
    for(i in 0 until n){
        val char = expression[i]
        when(char){
            '('-> {
                val parent = stack.last()
                val current = Expression()
                parent.blocks.add(current)
                stack.add(current)
            }
            ')' -> stack.removeAt(stack.lastIndex)
            in '0'..'9' -> {
                val parent = stack.last()
                // 接上之前的数字
                if(i>0 && expression[i-1] in '0'..'9'){
                    val pre = parent.blocks.last() as NumBlock
                    pre.num = pre.num*10+(char-'0')
                }else{
                    val current = NumBlock(char-'0')
                    parent.blocks.add(current)
                }
            }
            in 'a'..'z' ->{
                val parent = stack.last()
                // 接上之前的变量名
                if(i>0 && expression[i-1] in 'a'..'z'){
                    val pre = parent.blocks.last() as VarBlock
                    pre.variable = pre.variable+char
                }else{
                    val current = VarBlock("$char")
                    parent.blocks.add(current)
                }               
            }
            '+' -> stack.last().signs.add(Sign.Plus)
            '-' -> stack.last().signs.add(Sign.Minus)
            '*' -> stack.last().signs.add(Sign.Times)
            else -> null
        }
    }
    return root
}
fun calc(block:Block,map:Map<String,Int>):List<Item> =
 when(block){
    is NumBlock -> listOf(Item(block.num,"",0))
    is VarBlock -> listOf(if(map[block.variable]==null)
        Item(1,block.variable,1) else 
        Item(map[block.variable]!!,"",0))
    is Expression ->{
        val n = block.signs.size
        val lst = block.blocks.map {calc(it,map)}
        val stack = mutableListOf<List<Item>>(lst[0])
        for(i in 0 until n){
            stack.add(when(block.signs[i]){
                Sign.Times ->
                    stack.removeAt(stack.lastIndex) * lst[i+1]
                Sign.Plus -> lst[i+1]
                Sign.Minus -> -lst[i+1]
            })
        }
        while(stack.size>1){
            val a = stack.removeAt(stack.lastIndex)
            val b = stack.removeAt(stack.lastIndex)
            stack.add(a+b)
        }
        stack.removeAt(stack.lastIndex)
    }
}
data class Item(val num:Int,val vars:String,val size:Int): Comparable<Item>{
    operator fun times(other:Item):Item{
        val newNum = num*other.num
        var newVars = ""
        if(vars!="" && other.vars!=""){
            val lst = vars.split("*") + other.vars.split("*")
            newVars = lst.sorted().joinToString("*")
        }
        else if(vars!="") newVars=vars
        else if(other.vars!="") newVars = other.vars
        return Item(newNum,newVars,size+other.size)
    }   
    override fun compareTo(other: Item): Int {
        if (this.size != other.size) {
            return other.size - this.size
        } 
        return this.vars.compareTo(other.vars)
    }
}

operator fun List<Item>.times(other:List<Item>):List<Item>{
    var ret = other.map {it * this[0]}
    for(i in 1..size-1){
        ret = ret + other.map {it* this[i]}
    }
    return ret
}
operator fun List<Item>.unaryMinus():List<Item>{
    return map { Item(0-it.num,it.vars,it.size) }
}
operator fun List<Item>.plus(other:List<Item>):List<Item>{
    val map = mutableMapOf<String,Int>()
    val sizeMap = mutableMapOf<String,Int>()
    var onlyNum = null
    for(a in this){
        map[a.vars] = (map[a.vars]?:0)+a.num
        sizeMap[a.vars] = a.size
    }
    for(a in other){
        map[a.vars] = (map[a.vars]?:0)+a.num
        sizeMap[a.vars] = a.size
    }
    val ret = mutableListOf<Item>()
    for((vars,num) in map){
        ret.add(Item(num,vars,sizeMap[vars]!!))
    }
    return ret
}