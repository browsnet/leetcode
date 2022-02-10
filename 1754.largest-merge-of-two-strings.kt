/*
 * @lc app=leetcode.cn id=1754 lang=kotlin
 *
 * [1754] Largest Merge Of Two Strings
 */

// @lc code=start
class Solution 
fun Solution.largestMerge(word1: String, word2: String): String {
    val m = word1.length
    val n = word2.length
    var i = 0
    var j = 0
    val ret = StringBuilder()
    while (i < m || j < n) {
        val a = word1.substring(i)
        val b = word2.substring(j)
        ret.append(if (a<b) word2[j] else word1[i])
        if (a<b) j++ else i++
    }
    return ret.toString()
}
// @lc code=end

