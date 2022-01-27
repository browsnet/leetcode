class Solution 
fun Solution.countValidWords(sentence: String) = 
    sentence
    .split(" ")
    .filter { 
        Regex("^([!.,]$|([a-z]+(-[a-z]+)?($|[!.,]$)))")
            .find(it)!=null
    }
    .size