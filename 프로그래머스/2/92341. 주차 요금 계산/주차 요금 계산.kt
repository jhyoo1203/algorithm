class Solution {
    data class Fee(
        val basicTime: Int,
        val basicFee: Int,
        val unitTime: Int,
        val unitFee: Int
    )

    data class ParkingRecord(
        val time: Int,
        val carNum: String,
        val category: RecordCategory
    ) {
        companion object {
            fun from(raw: String): ParkingRecord {
                val (timeStr, carNum, categoryStr) = raw.split(" ")
                
                val time = timeStr.split(":")
                    .let { it[0].toInt() * 60 + it[1].toInt() }
                
                return ParkingRecord(
                    time,
                    carNum,
                    RecordCategory.valueOf(categoryStr)
                )
            }
        }
    }

    enum class RecordCategory {
        IN,
        OUT
    }

    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val fee = Fee(fees[0], fees[1], fees[2], fees[3])
        val recordList = records.map { ParkingRecord.from(it) }

        val inMap = mutableMapOf<String, Int>()
        val totalMap = mutableMapOf<String, Int>()

        for (record in recordList) {
            if (record.category == RecordCategory.IN) {
                inMap[record.carNum] = record.time
            } else {
                val inTime = inMap.remove(record.carNum)!!
                val duration = record.time - inTime
                totalMap[record.carNum] = totalMap.getOrDefault(record.carNum, 0) + duration
            }
        }

        // 출차 안 한 차량 처리
        for ((carNum, inTime) in inMap) {
            val duration = 1439 - inTime
            totalMap[carNum] = totalMap.getOrDefault(carNum, 0) + duration
        }

        // 차량 번호 순서대로 요금 계산
        return totalMap
            .toSortedMap()
            .map { (_, time) -> calculateFee(fee, time) }
            .toIntArray()
    }

    private fun calculateFee(fee: Fee, totalTime: Int): Int {
        if (totalTime <= fee.basicTime) {
            return fee.basicFee
        }
        
        val extra = totalTime - fee.basicTime
        
        // 올림 처리
        val units = (extra + fee.unitTime - 1) / fee.unitTime
        
        return fee.basicFee + units * fee.unitFee
    }
}