package LinearAlgebra.Matrix

import LinearAlgebra.Matrix.Builder.OperableMatrixBuilder
import junit.framework.TestCase

class OperableMatrixTest : TestCase()
{
    val builder=OperableMatrixBuilder()

    val m1 = builder
        .addRow(1,2,3)
        .addRow(4,5,6)
        .addRow(7,8,9)
        .create()
    val m2 = builder
        .clear()
        .addRow(3,6,8)
        .addRow(1,5,8)
        .addRow(7,5,3)
        .create()

    fun testPlus()
    {
        val test = this.m1+this.m2

        val ans = builder
            .clear()
            .addRow(4.0,8.0,11.0)
            .addRow(5.0,10.0,14.0)
            .addRow(14.0,13.0,12.0)
            .create()

        if (test.toString() != ans.toString()) throw error("testPlus error")
    }

    fun testMinus()
    {
        val test = this.m1-this.m2

        val ans = builder
            .clear()
            .addRow(-2.0,-4.0,-5.0)
            .addRow(3.0,0.0,-2.0)
            .addRow(0.0,3.0,6.0)
            .create()

        if (test.toString() != ans.toString()) throw error("testMinus error")
    }

    fun testTimes()
    {
        val test = this.m1 * this.m2

        val ans = builder
            .clear()
            .addRow(26.0, 31.0, 33.0)
            .addRow(59.0, 79.0, 90.0)
            .addRow(92.0, 127.0, 147.0)
            .create()

        if (test.toString() != ans.toString()) throw error("testTimes error")
    }


    fun testTestTimes()
    {
        val test = this.m1 * 3.7

        val ans = builder
            .clear()
            .addRow(3.7,7.4,11.1)
            .addRow(14.8, 18.5, 22.2)
            .addRow(25.9, 29.6, 33.3)
            .create()

        if (test.toString() != ans.toString()) throw error("testTimesWithK error")
    }
    fun testTestDiv()
    {
        val test = this.m1 / this.m2

        val ans = builder
            .clear()
            .addRow(-3.0,3.0,1.0)
            .addRow(-5.0,5.0, 2.0)
            .addRow(-7.0, 7.0, 3.0)
            .create()

        if (test.toString() != ans.toString()) throw error("testDiv error")
    }
    fun testDiv()
    {
        val test = this.m1 /2

        val ans = builder
            .clear()
            .addRow(0.5,1.0,1.5)
            .addRow(2.0,2.5,3.0)
            .addRow(3.5,4.0, 4.5)
            .create()

        if (test.toString() != ans.toString()) throw error("testDivWithK error")
    }

    fun testT()
    {
        val test = this.m1.T()

        val ans = builder
            .clear()
            .addRow(1,4,7)
            .addRow(2,5,8)
            .addRow(3,6,9)
            .create()

        if (test.toString() != ans.toString()) throw error("testT error")
    }

    fun testDet() {
        val test1 = this.m1.det()

        val ans1 = 0.0

        val test2 = this.m2.det()

        val ans2 = 3.0
        if ((test1!=ans1)||(test2!=ans2)) throw error("testDet error")
    }

    fun testInverse()
    {
        val test = m2.inverse()

        val ans = builder
            .clear()
            .addRow(-25.0/3,22.0/3,8.0/3)
            .addRow(53.0/3,-47.0/3,-16.0/3)
            .addRow(-10.0,9.0,3.0)
            .create()

        if (test.toString() != ans.toString()) throw error("testT error")
    }

    fun testAdj()
    {
        val test = m2.adj()

        val ans = builder
            .clear()
            .addRow(-25.0,22.0,8.0)
            .addRow(53.0,-47.0,-16.0)
            .addRow(-30.0,27.0,9.0)
            .create()

        if (test.toString() != ans.toString()) throw error("testT error")
    }
}
