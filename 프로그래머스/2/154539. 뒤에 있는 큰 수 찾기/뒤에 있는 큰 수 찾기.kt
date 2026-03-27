class Solution {
    fun solution(numbers: IntArray): IntArray {
        val stack = mutableListOf<Int>()
        val answer = IntArray(numbers.size) { -1 }
        
        for (i in numbers.indices) {
            while (stack.isNotEmpty() && numbers[i] > numbers[stack.last()]) {
                answer[stack.last()] = numbers[i]
                stack.removeLast()
            }
            stack.add(i)
        }
        
        return answer
    }
}