class SnapshotArray(length: Int) {
  val snaps = mutableListOf<Map<Int,Int>>()
  var map = mutableMapOf<Int,Int>()
  fun set(index: Int, `val`: Int) {
      map[index] = `val`
  }

  fun snap(): Int {
      snaps.add(map.toMap())
      return snaps.size-1
  }

  fun get(index: Int, snap_id: Int): Int {
      val map = snaps[snap_id]
      return map[index]?:0
  }
}