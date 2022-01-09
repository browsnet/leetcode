class Vector2D(val vec: Array<IntArray>) {
  var outer = 0
  var inner = 0
  fun next(): Int {
      if (!hasNext()) return 0
      return vec[outer][inner++]
  }

  fun hasNext(): Boolean {
      while (outer < vec.size && inner == vec[outer].size) {
          inner = 0
          outer++
      }
      return outer < vec.size
  }
}

/**
* Your Vector2D object will be instantiated and called as such:
* var obj = Vector2D(vec)
* var param_1 = obj.next()
* var param_2 = obj.hasNext()
*/
