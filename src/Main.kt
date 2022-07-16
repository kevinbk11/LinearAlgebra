import LinearAlgebra.Matrix.*
import LinearAlgebra.Matrix.Builder.OperableMatrixBuilder
import LinearAlgebra.Vector.*
import LinearAlgebra.Vector.Builder.OperableVectorBuilder

import LinearAlgebra.copy
import java.lang.Math.pow
import java.lang.Math.sqrt
import java.math.BigDecimal
import java.math.BigInteger



fun main(args:Array<String>)
{
    val operableMatrixBuilder=OperableMatrixBuilder()
    operableMatrixBuilder.clearAfterCreate=true

    with(operableMatrixBuilder)
    {
        val m1 = this
            .addRow(1,2,3)
            .addRow(4,5,6)
            .addRow(7,8,9)
            .addRow(10,11,12)
            .create()
        val m2 = this
            .addRow(1,4,3)
            .addRow(2,1,9)
            .addRow(3,6,7)
            .create()
        val m3 = this
            .addRow(1,2)
            .addRow(3,4)
            .addRow(5,6)
            .create()
        val m4 = this
            .addRow(1,2,3)
            .addRow(4,5,6)
            .addRow(7,8,9)
            .create()
        val m5 = this
            .addRow(3,2,6,9)
            .addRow(1,8,4,3)
            .addRow(1,4,8,9)
            .addRow(2,6,4,3)
            .create()
        val m6 = this
            .addRow(1,4,12,9,3)
            .addRow(6,5,4,2,0)
            .addRow(3,9,8,7,0)
            .addRow(6,5,0,1,2)
            .addRow(7,5,2,1,9)
            .create()
        val m7 = this
            .addRow(-2,5,1,3,4,-1)
            .addRow(2,-1,-5,-2,6,4)
            .addRow(-1,6,-4,-5,3,-1)
            .addRow(4,3,-6,-5,-2,-2)
            .addRow(-3,6,4,2,-6,4)
            .addRow(2,4,4,4,5,-4)
            .create()
        val m8 = this
            .addRow(0)
            .addRow(1)
            .addRow(-6)
            .addRow(10)
            .addRow(-6)
            .addRow(-2)
            .create()
        //print(copy(m7).det())
        val m9 = this
            .addRow(0,1,3)
            .addRow(4,1,7)
            .addRow(-6,-2,-12)
            .create()
        val m10 = this
            .addRow(1)
            .addRow(1)
            .addRow(2)
            .create()
        //print(m9.solveEquation(m10))
        //print(m7.inverse()*m8)
        val m11 = this
            .addRow(1,-1,4)
            .addRow(1,4,-2)
            .addRow(1,4,2)
            .addRow(1,-1,0)
            .create()
        var mkv = this
            .addRow(0.5,0.4,0.6)
            .addRow(0.2,0.2,0.3)
            .addRow(0.3,0.4,0.1)
            .create()
        var a = this
            .addRow(7,1)
            .addRow(0,1)
            .addRow(-2,1)
            .create()
        var b = this
            .addRow(-1)
            .addRow(5)
            .addRow(-2)
            .create()
        var test1 = this
            .addRow(0,2,3)
            .addRow(0,5,6)
            .addRow(0,7,8)
            .create()
        var test2 = this
            .addRow(1,2,3)
            .addRow(4,5,6)
            .addRow(7,8,9)
            .create()
        var test3 = this
            .addRow(1,2,5)
            .addRow(4,7,6)
            .addRow(3,8,9)
            .create()
        var test4 = this
            .addRow(0,2,3,0)
            .addRow(0,5,6,0)
            .addRow(0,7,8,0)
            .addRow(0,0,0,0)
            .create()
        print(test2.LU())


    }
    val vb = OperableVectorBuilder()

    with(operableMatrixBuilder)
    {
        /*val m1 = this
            .addRow(1,1)
            .addRow(2,1)
            .addRow(3,1)
            .addRow(4,1)
            .create()
        val m2 = this
            .addRow(2)
            .addRow(3)
            .addRow(5)
            .addRow(7)
            .create()
        //print(m1.T()*m1)
    print(((m1.T()*m1).inverse()*m1.T())*m2)*/
    }

    /*val l20 = mutableListOf<Vector>(
        OperableVector(-2,5,1,3,4,-1),
        OperableVector(-2,5,1,3,4,-1),
        OperableVector(-2,5,1,3,4,-1),
        OperableVector(-2,7,1,6,4,-12),
        OperableVector(-6,7,4,5,3,-9),
        OperableVector(-8,5,4,4,0,-1))
    val l21 = mutableListOf<Vector>(
        OperableVector(-2),
        OperableVector(-2),
        OperableVector(-2),
        OperableVector(-3),
        OperableVector(-4),
        OperableVector(-1))*/

    /*val m20=OperableMatrix(l20)
    val m21=OperableMatrix(l21)*/

    /*val l10 = mutableListOf<Vector>(
        OperableVector(0),
        OperableVector(1),
        OperableVector(-6),
        OperableVector(10),
        OperableVector(-6),
        OperableVector(-2),
    )*/



    //todo 無解 和 無限多解
}