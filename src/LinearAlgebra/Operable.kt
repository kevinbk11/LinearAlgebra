package LinearAlgebra

import LinearAlgebra.Matrix.IdentityMatrix
import LinearAlgebra.Matrix.Matrix
import LinearAlgebra.Matrix.OperableMatrix
import LinearAlgebra.Matrix.ZeroMatrix

interface Operable {

    operator fun Matrix.plus(m: Matrix): OperableMatrix
    {
        if(m.row==this.row && m.column==this.column)
        {
            var newMatrix= ZeroMatrix(m.row,m.column)
            for(r in 1..m.row)
                for(c in 1..m.column)
                {
                    newMatrix[r][c]=m[r][c]+this[r][c]
                }

            return newMatrix
        }
        else
        {
            throw error("Matrix's size not match.")
        }
    }

    operator fun Matrix.times(k:Double):OperableMatrix
    {
        var newMatrix= ZeroMatrix(row,column)
        for(r in 1..row)
            for(c in 1..column)
                newMatrix[r][c]+=this[r][c]*k
        return newMatrix
    }

    operator fun Matrix.times(m:Matrix):OperableMatrix
    {
        if(column!=m.row)throw error("Matrix's size not match.")
        var newMatrix= ZeroMatrix(row,m.column)
        for(i in 1..row)
            for(j in 1..m.column)
                for(k in 1..column)
                    newMatrix[i][j]+=this[i][k]*m[k][j]
        return newMatrix
    }
}