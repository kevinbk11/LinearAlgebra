package LinearAlgebra.Matrix

import LinearAlgebra.Vector.Builder.OperableVectorBuilder
import LinearAlgebra.Vector.OperableVector
import LinearAlgebra.Vector.Vector

abstract class Matrix(private val matrix: MutableList<Vector>) {

    var row=matrix.size

    var column=matrix[0].dim

    fun getMatrix(): Matrix {return this}

    fun getRowVector(row:Int):OperableVector {return matrix[row-1] as OperableVector}

    fun getColumnVector(column:Int):OperableVector
    {
        val builder = OperableVectorBuilder()

        for(i in matrix)
            builder.addElement(i[column])

        return builder.create()
    }

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

    override fun equals(other:Any?):Boolean
    {
        when(other)
        {
            is Matrix->
            {
                if(other.row!=row || other.column!=column) return false
                for(i in 1..other.row)
                    for(j in 1..other.column)
                        if(other[i][j].toFloat()!=this[i][j].toFloat()) return false
                return true
            }
            else -> return false
        }
    }

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
            s+="]"
            if(r!=row)s+="\n"
        }
        return s
    }

    operator fun iterator(): Iterator<OperableVector> {
        return object : Iterator<OperableVector> {
            var i = 0

            override fun hasNext(): Boolean = i < matrix.size

            override fun next(): OperableVector = matrix[i++] as OperableVector

        }
    }

}