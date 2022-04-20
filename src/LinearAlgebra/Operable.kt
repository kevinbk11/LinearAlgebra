package LinearAlgebra

import LinearAlgebra.Matrix.Matrix
import LinearAlgebra.Matrix.OperableMatrix
import LinearAlgebra.Matrix.ZeroMatrix

interface Operable {
    operator fun Matrix.plus(m: Matrix): OperableMatrix
    {
        if(m.row==this.row && m.column==this.column)
        {
            var newMatrix= ZeroMatrix(m.row,m.column)
            for(r in 0..m.row-1)
                for(c in 0..m.column-1)
                    newMatrix[r][c]=m[r][c]+this[r][c]
            return newMatrix
        }
        else
        {
            throw error("Matrix's size not match.")
        }
    }
    operator fun Matrix.times(k:Int):OperableMatrix
    {
        var newMatrix= ZeroMatrix(row,column)
        for(r in 0..row-1)
            for(c in 0..column-1)
                newMatrix[r][c]+=this[r][c]*k
        return newMatrix
    }
    operator fun Matrix.times(m:Matrix):OperableMatrix
    {
        if(column!=m.row)throw error("Matrix's size not match.")
        var newMatrix= ZeroMatrix(row,m.column)
        for(i in 0 until row)
            for(j in 0 until m.column)
                for(k in 0 until column)
                    newMatrix[i][j]+=this[i][k]*m[k][j]
        return newMatrix
    }
    fun T(m:Matrix):OperableMatrix
    {
        val newMatrix= ZeroMatrix(m.column,m.row)
        for(r in 0 until m.column)
            for(c in 0 until m.row)
                newMatrix[r][c]=m[c][r]
        return newMatrix
    }
}