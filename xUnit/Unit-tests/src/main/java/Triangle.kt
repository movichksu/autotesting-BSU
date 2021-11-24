class Triangle() {

    fun isTriangleExists(triangle: AbstractTriangle): Boolean {
        with(triangle) {
            if (firstSide > 0 && secondSide > 0 && thirdSide > 0) {
                if ((firstSide + secondSide > thirdSide) && (firstSide + thirdSide > secondSide)
                        && (secondSide + thirdSide > firstSide)) return true;
            } else {
                throw ArithmeticException("Side can't be negative or zero"); }

            return false;
        }
    }

    fun isRightTriangle(triangle: AbstractTriangle): Boolean {
        if (!isTriangleExists(triangle)) return false
        with(triangle) {
            return when {
                ((firstSide * firstSide) + (secondSide * secondSide)) == (thirdSide * thirdSide) -> true
                ((firstSide * firstSide) + (thirdSide * thirdSide)) == (secondSide * secondSide) -> true
                ((thirdSide * thirdSide) + (secondSide * secondSide)) == (firstSide * firstSide) -> true
                else -> false
            }
        }
    }

    fun isEquilateral(triangle: AbstractTriangle): Boolean {
        if (!isTriangleExists(triangle)) return false
        with(triangle) {
            return firstSide == secondSide && secondSide == thirdSide
        }
    }

    fun isScaleneTriangle(triangle: AbstractTriangle): Boolean {
        if (!isTriangleExists(triangle)) return false
        with(triangle) {
            return firstSide != secondSide && secondSide != thirdSide && thirdSide != firstSide
        }
    }

    fun isIsoscelesTriangle(triangle: AbstractTriangle): Boolean {
        if (!isTriangleExists(triangle)) return false
        with(triangle) {
            return when {
                firstSide == secondSide && secondSide != thirdSide -> true
                secondSide == thirdSide && thirdSide != firstSide -> true
                thirdSide == firstSide && firstSide != secondSide -> true
                else -> false
            }
        }
    }
}