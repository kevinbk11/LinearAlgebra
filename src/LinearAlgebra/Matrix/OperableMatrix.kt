package LinearAlgebra.Matrix

import LinearAlgebra.Matrix.Builder.OperableMatrixBuilder
import LinearAlgebra.Operable
import LinearAlgebra.Vector.Builder.OperableVectorBuilder
import LinearAlgebra.Vector.OperableVector
import LinearAlgebra.Vector.Vector
import LinearAlgebra.copy
import java.lang.Math.pow

open class OperableMatrix(private var matrix: MutableList<Vector>): Matrix(matrix),Operable {

    operator fun plus(m: Matrix): OperableMatrix { return m+this }

    operator fun minus(m:Matrix):OperableMatrix { return this+(m*-1.0) }

    operator fun times(k:Number):OperableMatrix { return this.getMatrix()*k.toDouble() }

    operator fun times(m:Matrix):OperableMatrix { return this.getMatrix()*m }

    operator fun div(k:Number):OperableMatrix { return this.getMatrix()*(1.0/k.toDouble()) }

    operator fun div(m:OperableMatrix):OperableMatrix { return this.getMatrix()*m.inverse()}

    fun T():OperableMatrix
    {
        val newMatrix= ZeroMatrix(column,row)
        for(r in 1..column)
            for(c in 1..row)
                newMatrix[r][c]=this[c][r]
        return newMatrix
    }

    fun det():Double
    {
        if(row!=column)throw error("This matrix is not m*m matrix!")
        if(row==1)return this[1][1]
        if(row==2)return this[1][1]*this[2][2]-this[1][2]*this[2][1]
        var total = 0.0
        for(c in 1..column)
        {
            total+=this[1][c]*cofactor(1,c)*pow(-1.0,c.toDouble()+1.0 )
        }
        return total
    }
    fun cofactor(m:Int,n:Int):Double
    {
        val mat = copy(this)

        mat.removeRow(m)
        mat.removeColumn(n)

        return (mat).det()
    }

    fun inverse():OperableMatrix
    {
        if(row!=column)throw error("this matrix is m*m matrix!")
        if(det()!=0.0)
        {
            val adjMatrix = adj()
            return adjMatrix/det()
        }
        else throw error("this matrix is not invertible! (det=0)")
    }

    fun adj():OperableMatrix
    {
        if(row!=column)throw error("this matrix is not square matrix!")

        val mBuilder = OperableMatrixBuilder()
        mBuilder.clearAfterCreate=true
        val vBuilder = OperableVectorBuilder()
        vBuilder.clearAfterCreate=true
        for(i in 1..row)
        {
            for(j in 1..row)
                vBuilder.addElement(cofactor(i,j)*(pow(-1.0, ((i+j)).toDouble()).toInt()))
            mBuilder.addRow(vBuilder.create())
        }
        return mBuilder.create().T()
    }

    fun solveEquation(B:Matrix):Matrix?
    {
        return ZeroMatrix(0,0)
    }
}