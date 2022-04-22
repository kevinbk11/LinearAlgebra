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
            var spaceCount=matrix[r-1][1].toString().split(".")[0].length
            println(spaceCount)
            s+=String.format("[%.${8-spaceCount}f",matrix[r-1][1])
            for(c in 2..column)
            {
                spaceCount=matrix[r-1][c].toString().split(".")[0].length
                s+=String.format(" %.${8-spaceCount}f",matrix[r-1][c])
            }

            s+="]\n"
        }
        return s
    }
}