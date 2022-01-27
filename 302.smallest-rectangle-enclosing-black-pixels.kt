class Solution 
// 在[x,y]初遍历连接点，找到最大最小区域
fun Solution.minArea(image: Array<CharArray>, x: Int, y: Int): Int {
    val m = image.size
    val n = image[0].size
    var top = m
    var left = n
    var right = 0
    var bottom = 0
    val visited = Array(m) {Array(n) {false}}
    fun dfs(i:Int,j:Int){
        if(i<0 || j<0) return
        if(i>=m || j>=n) return
        if(image[i][j]=='0') return
        if(visited[i][j] == true) return
        visited[i][j] = true
        left = Math.min(left,j)
        right = Math.max(right,j)
        top = Math.min(top,i)
        bottom = Math.max(bottom,i)
        dfs(i+1,j)
        dfs(i-1,j)
        dfs(i,j+1)
        dfs(i,j-1)
    }
    dfs(x,y)
    val height = bottom-top+1
    val width = right-left+1
    return width*height
}