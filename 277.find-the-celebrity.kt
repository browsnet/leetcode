
class Solution: Relation() {
  override fun findCelebrity(n: Int) : Int {
      // 刚开始假设名人是0
      var ret = 0
      for(i in 0 until n)
          // 如果名人认识i，那他就是个假名人，换成i尝试
          if(knows(ret,i)) ret = i
  
      // 然后检查是否为真的名人
      for(i in 0 until n){
          if(i==ret) continue
          if(!knows(i,ret) || knows(ret,i)) return -1
      }
      return ret
  }
}