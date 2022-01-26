class Solution 
fun Solution.asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
    val mins = IntArray(17) {Int.MAX_VALUE}
    val sums = IntArray(17)
    for(num in asteroids){
        val i = 31-Integer.numberOfLeadingZeros(num)
        mins[i] = Math.min(mins[i],num)
        sums[i] += num
    }
    var current = mass
    for(i in 0..16){
        if(sums[i]>0 && current<mins[i]) return false
        current += sums[i]
    }
    return true
}