package LinearAlgebra.Matrix

import LinearAlgebra.Vector.Vector

abstract class Matrix(private val matrix: MutableList<Vector>) {
    var row=matrix.size
    var column=matrix[0].dim
    fun getMatrix(): Matrix {return this}
    fun getMatrixList():MutableList<Vector>{return matrix}
    operator fun get(row:Int,column:Int):Double
    {
        return matrix[row-1][column-1]
    }

    operator fun get(row:Int): Vector
    {
        return matrix[row-1]
    }

    operator fun set(row:Int,v:Vector)
    {
        matrix[row-1]=v
        matrix[row-1].dim=v.dim
        column=v.dim
    }

    override fun toString(): String {
        var s=""
        for(r in 1..row)
        {
            s+=String.format("[%.${6-(matrix[r-1][1].toString().length-3)}f",matrix[r-1][1])
            for(c in 2..column)
                s+=String.format(" %.${6-(matrix[r-1][c].toString().length-3)}f",matrix[r-1][c])
            s+="]\n"
        }
        return s
    }
}