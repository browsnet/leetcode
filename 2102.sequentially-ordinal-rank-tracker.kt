// 双堆解法
class SORTracker() {
    val minHeap = PriorityQueue<Pair<String,Int>> {
        (aName,aScore),(bName,bScore)-> 
            if(aScore==bScore) bName.compareTo(aName)
                else aScore-bScore
    }
    val maxHeap = PriorityQueue<Pair<String,Int>> {
        (bName,bScore),(aName,aScore)-> 
            if(aScore==bScore) bName.compareTo(aName)
                else aScore-bScore
    }

    fun add(name: String, score: Int) {
        minHeap.add(name to score)
        maxHeap.add(minHeap.poll())
    }

    fun get(): String {
        minHeap.add(maxHeap.poll())
        return minHeap.peek()!!.first
    }
}
