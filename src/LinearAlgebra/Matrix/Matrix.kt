package LinearAlgebra.Matrix

import LinearAlgebra.Vector.OperableVector
import LinearAlgebra.Vector.Vector

abstract class Matrix(private val matrix: MutableList<Vector>) {

    var row=matrix.size

    var column=matrix[0].dim

    fun getMatrix(): Matrix {return this}

    fun removeRow(r:Int)
    {
       matrix.removeAt(r-1)
       row--
    }

    fun removeColumn(c:Int)
    {
        for(i in 1..row)
            this[i].removeAt(c)
        column--
    }

    operator fun get(row:Int): OperableVector { return matrix[row-1] as OperableVector }

    operator fun set(row:Int,v:Vector) { matrix[row-1]=v }

    override fun toString(): String {
        var s=""
        for(r in 1..row)
        {
            var spaceCount=matrix[r-1][1].toString().split(".")[0].length
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