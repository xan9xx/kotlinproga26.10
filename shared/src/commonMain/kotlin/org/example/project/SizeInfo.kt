package org.example.project

data class SizeInfo(
    val xMin: Double, val xMax: Double,
    val yMin: Double, val yMax: Double,
    val width: Float, val height: Float,
) {
    fun toCartesianPoint(sp: ScreenPoint): CartesianPoint {
        var xcount = width / (xMax - xMin)
        var ycount = height / (yMax - yMin)

        //var rastx = width / xcount
        //var rasty = height / ycount

        return CartesianPoint(sp.x / xcount + xMin, yMax - sp.y / ycount)

    }


    fun toScreenPoint(cp: CartesianPoint): ScreenPoint {
        var countx = (xMax - xMin) / width
        var county = (yMax - yMin) / height
        return ScreenPoint(((cp.x - xMin)/ countx).toFloat(), (yMax - cp.y / county).toFloat())

    }
}
