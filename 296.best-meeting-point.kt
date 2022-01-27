class Solution 
// 所有人的x坐标中位数就是目标点的x坐标，
// 所有人的y坐标中位数就是目标点的y坐标
fun Solution.minTotalDistance(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    var total = 0
    for(i in 0 until m){
        for(j in 0 until n){
            if(grid[i][j]==0) continue
            total++
        }
    }
    var xnum = 0
    var x = 0
    loop1@for(i in 0 until m){
        for(j in 0 until n){
            if(grid[i][j]==0) continue
            if(xnum==total/2){
                x = i
                break@loop1
            }
            xnum++
        }
    } 
    var ynum = 0
    var y = 0
    loop2@for(j in 0 until n){
        for(i in 0 until m){
            if(grid[i][j]==0) continue
            if(ynum==total/2){
                y = j
                break@loop2
            }
            ynum++
        }
    }
    var ret =0
    for(i in 0 until m){
        for(j in 0 until n){
            if(grid[i][j]==0) continue
            ret += Math.abs(i-x)+Math.abs(j-y)
        }
    } 
    return ret
}