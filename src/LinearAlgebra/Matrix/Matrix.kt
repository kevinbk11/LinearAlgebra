package LinearAlgebra.Matrix

import LinearAlgebra.Vector.Vector
import java.lang.Math.abs

abstract class Matrix(private val matrix: MutableList<Vector>) {
    var row=matrix.size
    var column=matrix[0].dim
    fun getMatrix(): Matrix {return this}
    fun getMatrixList():MutableList<Vector>{return matrix}
    operator fun get(row:Int,column:Int): Int
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
        val maxInt:Number? = matrix.maxOfOrNull { it.getVectorList().maxOf { it.toFloat() } }
        val maxLength = maxInt.toString().length
        var s=""
        for(r in 1..row)
        {
            s+="["
            for(c in 1..column)
            {
                val spaceCount=maxLength-matrix[r-1][c].toString().length
                var space=""
                for(i in 1..spaceCount)space+=" "
                if(c==column)
                {
                    val lastSpaceCount = matrix.maxOfOrNull{it[column].toString().length}!!-matrix[r-1][c].toString().length
                    var lastSpace=""
                    for(i in 1..lastSpaceCount)lastSpace+=" "
                    s+=String.format("%d${lastSpace}",matrix[r-1][c])
                }
                else
                {
                    s+=String.format("%d${space}",matrix[r-1][c])
                }
            }
            s+="]\n"
        }
        return s
    }
}