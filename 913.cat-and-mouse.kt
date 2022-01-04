class Solution 
data class State(val cat:Int,val mouse:Int,val count:Int) 
val State.num: Int get() = if(count%2==0) cat else mouse
fun Solution.catMouseGame(graph: Array<IntArray>): Int {
    val cached = mutableMapOf<State,Int>()
    fun dfs(current:State):Int{
        if(current.cat==current.mouse) return 2 // 结束1
        if(current.mouse==0) return 1 // 结束2
        val count = current.count
        if(count>2*graph.size) return 0 // 结束3
        if(cached[current]!=null) return cached[current]!!
        fun move():Int{
            // count为奇数的时候老鼠出发
            val isCat = current.count%2==0
            var canDraw = false
            for(it in graph[current.num]){
                if(isCat && it==0) continue
                val np = if(isCat) State(it,current.mouse,count+1)
                        else State(current.cat,it,count+1)
                var ret = dfs(np)
                if(isCat && ret==2) return ret // 猫可以胜
                if(!isCat && ret==1) return ret // 鼠可以胜
                if(ret==0) canDraw = true // 可以平局
            }
            if(canDraw==true) return 0
            return if(isCat) 1 else 2
        }
        cached[current] = move()
        return cached[current]!!
    }
    return dfs(State(2,1,1))
}