package LinearAlgebra.Matrix

import LinearAlgebra.Vector.Vector
import java.lang.Math.abs
import java.math.BigDecimal
import java.text.NumberFormat

abstract class Matrix(private val matrix: MutableList<Vector>) {
    var row=matrix.size
    var column=matrix[0].dim
    fun getMatrix(): Matrix {return this}
    fun getMatrixList():MutableList<Vector>{return matrix}
    operator fun get(row:Int,column:Int):Float
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
        var instance = NumberFormat.getInstance()
        instance.isGroupingUsed=false
        val maxLength = instance.format(matrix.maxOfOrNull { it.getVectorList().maxOf { it.toBigDecimal() } }).length
        println(maxLength)
        var s=""
        for(r in 1..row)
        {
            s+="["
            for(c in 1..column)
            {
                val spaceCount=(maxLength-instance.format(matrix[r-1][c]).length)
                var space=""
                for(i in 1..spaceCount)space+=" "
                if(c==column)
                {
                    val lastSpaceCount = matrix.maxOfOrNull{instance.format(it[column]).length}!!-instance.format(matrix[r-1][c]).length
                    var lastSpace=""
                    for(i in 1..lastSpaceCount)lastSpace+=" "
                    s+=String.format("%.2f${lastSpace}",matrix[r-1][c])
                }
                else
                {
                    s+=String.format("%.2f${space}",matrix[r-1][c])+" "
                }
            }
            s+="]\n"
        }
        return s
    }
}