import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class TriangleTest {

    private val triangleUtil = Triangle()

    @Test
    fun `isTriangle should throw exception with specific message`() {
        val triangle = AbstractTriangle(-2, 4, 6)

        val exception = assertThrows(ArithmeticException::class.java) {
            triangleUtil.isTriangleExists(triangle)
        }
        assertEquals(EXPECTED_EXCEPTION_MESSAGE, exception.message)
    }

    @ParameterizedTest
    @MethodSource("streamOfNotExistTriangles")
    fun `triangle shouldn't exist`(triangle: AbstractTriangle) {
        val actualResult = triangleUtil.isTriangleExists(triangle)

        assertFalse(actualResult)
    }

    @ParameterizedTest
    @MethodSource("streamOfExistTriangles")
    fun `triangle should exist`(triangle: AbstractTriangle) {
        val actualResult = triangleUtil.isTriangleExists(triangle)

        assertTrue(actualResult)
    }

    @ParameterizedTest
    @MethodSource("streamOfRightTriangles")
    fun `triangle should be right`(triangle: AbstractTriangle) {
        val actualResult = triangleUtil.isRightTriangle(triangle)

        assertTrue(actualResult)
    }

    @ParameterizedTest
    @MethodSource("streamOfNotRightTriangles")
    fun `triangle shouldn't be right`(triangle: AbstractTriangle) {
        val actualResult = triangleUtil.isRightTriangle(triangle)

        assertFalse(actualResult)
    }

    @Test
    fun `triangle should be equilateral`() {
        val triangle = AbstractTriangle(3, 3, 3)

        val actualResult = triangleUtil.isEquilateral(triangle)

        assertTrue(actualResult)
    }

    @ParameterizedTest
    @MethodSource("streamOfNotEquilateralTriangles")
    fun `triangle shouldn't be equilateral`(triangle: AbstractTriangle) {
        val actualResult = triangleUtil.isEquilateral(triangle)

        assertFalse(actualResult)
    }

    @Test
    fun `triangle should be scalene`() {
        val triangle = AbstractTriangle(3, 4, 5)

        val actualResult = triangleUtil.isScaleneTriangle(triangle)

        assertTrue(actualResult)
    }

    @ParameterizedTest
    @MethodSource("streamOfNotScaleneTriangles")
    fun `triangle shouldn't be scalene`(triangle: AbstractTriangle) {
        val actualResult = triangleUtil.isScaleneTriangle(triangle)

        assertFalse(actualResult)
    }

    @ParameterizedTest
    @MethodSource("streamOfIsoscelesTriangles")
    fun `triangle should be isosceles`(triangle: AbstractTriangle) {
        val actualResult = triangleUtil.isIsoscelesTriangle(triangle)

        assertTrue(actualResult)
    }

    @ParameterizedTest
    @MethodSource("streamOfNotIsoscelesTriangles")
    fun `triangle shouldn't be isosceles`(triangle: AbstractTriangle) {
        val actualResult = triangleUtil.isIsoscelesTriangle(triangle)

        assertFalse(actualResult)
    }

    private companion object {
        private const val EXPECTED_EXCEPTION_MESSAGE = "Side can't be negative or zero"

        @JvmStatic
        private fun streamOfNotExistTriangles() = Stream.of(
                AbstractTriangle(1, 2, 1),
                AbstractTriangle(1, 2, 5),
                AbstractTriangle(8, 2, 16),
                AbstractTriangle(3, 1, 1)
        )

        @JvmStatic
        private fun streamOfExistTriangles() = Stream.of(
                AbstractTriangle(2, 3, 4),
                AbstractTriangle(12, 13, 15),
                AbstractTriangle(3, 3, 3),
                AbstractTriangle(3, 3, 4)
        )

        @JvmStatic
        private fun streamOfRightTriangles() = Stream.of(
                AbstractTriangle(12, 9, 15),
                AbstractTriangle(3, 4, 5),
                AbstractTriangle(5, 13, 12),
                AbstractTriangle(13, 12, 5)
        )

        @JvmStatic
        private fun streamOfNotRightTriangles() = Stream.of(
                AbstractTriangle(2, 3, 4),
                AbstractTriangle(12, 13, 15),
                AbstractTriangle(3, 3, 3),
                AbstractTriangle(3, 3, 4)
        )

        @JvmStatic
        private fun streamOfNotEquilateralTriangles() = Stream.of(
                AbstractTriangle(2, 3, 4),
                AbstractTriangle(12, 13, 15),
                AbstractTriangle(3, 4, 5),
                AbstractTriangle(4, 3, 3)
        )

        @JvmStatic
        private fun streamOfNotScaleneTriangles() = Stream.of(
                AbstractTriangle(2, 2, 3),
                AbstractTriangle(12, 12, 15),
                AbstractTriangle(5, 5, 5)
        )

        @JvmStatic
        private fun streamOfIsoscelesTriangles() = Stream.of(
                AbstractTriangle(3, 3, 4),
                AbstractTriangle(4, 3, 3),
                AbstractTriangle(3, 4, 3)
        )

        @JvmStatic
        private fun streamOfNotIsoscelesTriangles() = Stream.of(
                AbstractTriangle(4, 4, 4),
                AbstractTriangle(12, 13, 15),
                AbstractTriangle(4, 5, 6)
        )
    }
}