package LinearAlgebra.Matrix.Builder

import LinearAlgebra.Matrix.OperableMatrix
import LinearAlgebra.Vector.Vector
import LinearAlgebra.copy

class OperableMatrixBuilder:MatrixBuilder {
    constructor()
    constructor(matrix : MutableList<Vector>):super(matrix)

    override fun create():OperableMatrix
    {
        val createdMatrix =  copy(OperableMatrix(matrix))
        if(clearAfterCreate)clear()
        return createdMatrix
    }
}