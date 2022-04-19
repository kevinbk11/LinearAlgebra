package LinearAlgebra.Matrix

import LinearAlgebra.Operable

open class OperableMatrix(private var matrix: List<MutableList<Int>>): Matrix(matrix), Operable {
    operator fun plus(m: Matrix): OperableMatrix
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
}