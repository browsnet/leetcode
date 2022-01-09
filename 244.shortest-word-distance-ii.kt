class WordDistance(wordsDict: Array<String>) {
  val map = mutableMapOf<String,MutableList<Int>>()
  init{
      for(i in 0 until wordsDict.size){
          val s = wordsDict[i]
          if(map[s]==null) map[s] = mutableListOf<Int>()
          map[s]?.add(i)
      }
  }
  fun shortest(word1: String, word2: String): Int {
      val arr1 = map[word1]!!
      val arr2 = map[word2]!!
      var min = Int.MAX_VALUE
      for(i in arr1){
          var left = 0
          var right = arr2.size-1
          while(left<=right){
              val m = left+(right-left)/2
              val j = arr2[m]
              min = Math.min(min,Math.abs(j-i))
              if(j<i){
                  left = m+1
              }else{
                  right = m-1
              }
          }
      }
      return min
  }
}

/**
* Your WordDistance object will be instantiated and called as such:
* var obj = WordDistance(wordsDict)
* var param_1 = obj.shortest(word1,word2)
*/