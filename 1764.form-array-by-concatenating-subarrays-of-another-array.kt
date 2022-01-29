class Solution 
// 双指针，i代表当前待匹配的groups下标，j代表当前匹配到nums下标
// k代表当前匹配groups[i]里的下标, _j为临时下标，匹配失败后要从j+1开始
fun Solution.canChoose(groups: Array<IntArray>, nums: IntArray): Boolean {
    val n = groups.size
    val m = nums.size
    var i = 0
    var j = 0
    while(i<n && j<m){
        val arr = groups[i]
        var k = 0
        var _j = j
        while(k<arr.size && _j<m){
            if(arr[k]!=nums[_j]) {
                k = 0
                _j = ++j
            }else{
                k++
                _j++
            }
        }
        j = _j
        // 成功一个
        if(k==arr.size) i++
    }
    return i==n
}