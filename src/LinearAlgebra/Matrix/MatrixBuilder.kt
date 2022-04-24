package LinearAlgebra.Matrix

import LinearAlgebra.Vector.OperableVector
import LinearAlgebra.Vector.Vector
import LinearAlgebra.copy

class MatrixBuilder {
    var matrix = mutableListOf<Vector>()
    constructor(matrix : MutableList<Vector>)
    {
        this.matrix=matrix
    }
    constructor()

    fun addVector(v:Vector):MatrixBuilder
    {
        matrix+=v
        return this
    }

    fun addVector(vararg v:Number):MatrixBuilder
    {
        matrix+=OperableVector(v.toMutableList())
        return this
    }

    fun clear():MatrixBuilder
    {
        matrix= mutableListOf()
        return this
    }
    fun create():Matrix{ return copy(OperableMatrix(matrix))}
}