class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        
        val map = mutableMapOf<Int, Int>()
        
        for (item in tangerine) {
            map.merge(item, 1, Int::plus)
        }
        
        val sortedList = map.toList().sortedByDescending { it.second }
        
        var countSum = 0
        for (pair in sortedList) {
            countSum += pair.second
            answer++
            
            if (countSum >= k) {
                break
            }
        }
        
        return answer
    }
}