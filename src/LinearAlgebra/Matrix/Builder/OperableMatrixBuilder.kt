package LinearAlgebra.Matrix.Builder

import LinearAlgebra.Matrix.OperableMatrix
import LinearAlgebra.Vector.Vector
import LinearAlgebra.copy

class OperableMatrixBuilder
    (matrix:MutableList<Vector> = mutableListOf(),clearAfterCreate: Boolean=false): MatrixBuilder(matrix, clearAfterCreate)
{
    override fun addRow(v: Vector): OperableMatrixBuilder { return super.addRow(v) as OperableMatrixBuilder }

    override fun addRow(vararg v: Number): OperableMatrixBuilder { return super.addRow(*v) as OperableMatrixBuilder }

    override fun clear(): OperableMatrixBuilder { return super.clear() as OperableMatrixBuilder }

    override fun create():OperableMatrix
    {
        val createdMatrix =  copy(OperableMatrix(matrix))
        if(clearAfterCreate)clear()
        return createdMatrix
    }
}