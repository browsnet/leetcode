data class Point(val x:Int,val y:Int)
class DetectSquares() {
    val points = mutableMapOf<Point,Int>()
    fun add(point: IntArray) {
        val (x,y) = point
        val p = Point(x,y)
        points[p] = (points[p]?:0)+1
    }

    fun count(point: IntArray): Int {
        var ret = 0
        val (x,y) = point
        for((p,c) in points){
            val i = p.x
            val j = p.y
            if(i==x || j==y) continue
            if(Math.abs(x-i)!=Math.abs(y-j))continue
            val p1 = Point(i,y)
            val p2 = Point(x,j)
            ret += (points[p1]?:0)*(points[p2]?:0)*c
        }
        return ret
    }
}