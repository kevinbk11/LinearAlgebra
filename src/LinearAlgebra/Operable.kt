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
            {
                for(c in 0..m.column-1)
                {
                    newMatrix[r][c]=m[r][c]+this[r][c]
                }
            }
            return newMatrix
        }
        else
        {
            throw error("Matrix's size not match.")
        }
    }
    operator fun Matrix.times(m:Int):OperableMatrix
    {
        var newMatrix= ZeroMatrix(row,column)
        for(r in 0..row-1)
        {
            for(c in 0..column-1)
            {
                newMatrix[r][c]+=this[r][c]*m
            }
        }
        return newMatrix
    }
}