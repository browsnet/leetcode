class Solution 
fun Solution.alertNames(keyName: Array<String>, keyTime: Array<String>): List<String> {
    val map = mutableMapOf<String,MutableList<Int>>()
    val n = keyName.size
    for(i in 0 until n){
        val name = keyName[i]
        val (h,m) = keyTime[i].split(":").map {it.toInt()}
        val time = h*60+m
        if(map[name]==null)
            map[name] = mutableListOf<Int>()
        map[name]?.add(time)
    }  
    val ret = mutableListOf<String>()  
    for((name,lst) in map){
        lst.sort()
        var needWarn = false
        for(i in 2 until lst.size){
            if(lst[i]-lst[i-2]<=60){
                needWarn = true
                break
            }
        }
        if(needWarn) ret.add(name)
    }
    ret.sort()
    return ret
}