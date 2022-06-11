package LinearAlgebra.Vector

import LinearAlgebra.Vector.Builder.OperableVectorBuilder
import junit.framework.TestCase

class OperableVectorTest : TestCase() {
    val vb = OperableVectorBuilder(true)
    val v1 = vb.addElement(1,2,3).create()
    val v2 = vb.addElement(4,5,6).create()
    fun testPlus()
    {
        val ans = vb.addElement(5,7,9).create()
        assertEquals(v1+v2,ans)

    }

    fun testMinus()
    {
        val ans = vb.addElement(-3,-3,-3).create()
        assertEquals(v1-v2,ans)
    }

    fun testTimes()
    {
        val ans = vb.addElement(2,4,6).create()
        assertEquals(v1*2,ans)
    }

    fun testDiv()
    {
        val ans = vb.addElement(2,2.5,3).create()
        assertEquals(v2/2,ans)
    }

    fun testDot()
    {
        val ans = 32.0
        assertEquals(v1 dot v2,ans)
    }

    fun testCross()
    {
        val ans = vb.addElement(-3,6,-3).create()
        assertEquals(v1 cross v2,ans)
    }
}