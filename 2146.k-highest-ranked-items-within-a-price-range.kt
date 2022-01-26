class Solution
data class Point(val row:Int,val col:Int,val distance:Int)
val dirs = listOf(0 to 1,0 to -1, 1 to 0,-1 to 0)
fun Solution.highestRankedKItems(grid: Array<IntArray>, pricing: IntArray, start: IntArray, k: Int): List<List<Int>> {
    val m = grid.size
    val n = grid[0].size
    val lst = mutableListOf<Point> ()
    val (row,col) = start
    val p = Point(row,col,0)
    val arr = mutableListOf(p)
    val visited = mutableSetOf(row to col)
    if(grid[row][col]>=pricing[0] && grid[row][col]<=pricing[1])
        lst.add(p)
    while(arr.size>0){
        val p = arr.removeAt(0)
        for((dRow,dCol) in dirs){
            val nRow = p.row+dRow
            val nCol = p.col+dCol
            if(nRow<0 ||nCol<0) continue
            if(nRow>=m || nCol>=n) continue
            val price =grid[nRow][nCol]
            if(price==0) continue
            val pa = nRow to nCol
            if(pa in visited) continue
            visited.add(pa)
            val point = Point(nRow,nCol,p.distance+1)
            if(price>=pricing[0] && price<=pricing[1]){
                lst.add(point)
            }
            arr.add(point)
        }   
    }
    lst.sortWith(
        compareBy({it.distance}, {grid[it.row][it.col]},{it.row},{it.col}))

    return lst.take(k).map {listOf(it.row,it.col)}
}