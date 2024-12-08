import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AndroidTrainingTest {
    @Test
    fun testCompareTimeSpent() {
        val androidTraining = AndroidTraining()
        assertTrue(androidTraining.compareTimeSpent(300, 250))
        assertFalse(androidTraining.compareTimeSpent(300, 300))
        assertFalse(androidTraining.compareTimeSpent(200, 220))
    }
}