class Solution 
fun Solution.minimumTime(s: String): Int {
    val n = s.length
    val left = IntArray(n+1)
    val right = IntArray(n+1)
    for(i in 1..n){
        if (s[i-1] == '0')
            left[i] = left[i-1]
        else
            left[i] = Math.min(left[i-1] + 2, i)
    }
    for(i in 1..n){
        if (s[n-i] == '0')
            right[i] = right[i-1]
        else
            right[i] = Math.min(right[i-1]+2,i)
    }
    var min = n*2
    for(i in 0..n){
        min = Math.min(min,left[i]+right[n-i])
    }
    return min
}