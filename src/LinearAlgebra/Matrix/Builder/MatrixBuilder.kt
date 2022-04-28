package LinearAlgebra.Matrix.Builder

import LinearAlgebra.Matrix.Matrix
import LinearAlgebra.Matrix.OperableMatrix
import LinearAlgebra.Matrix.ZeroMatrix
import LinearAlgebra.Vector.OperableVector
import LinearAlgebra.Vector.Vector
import LinearAlgebra.copy

abstract class MatrixBuilder {

    protected var matrix = mutableListOf<Vector>()

    var clearAfterCreate = false

    constructor(matrix : MutableList<Vector>)
    {
        this.matrix=matrix
    }
    constructor()

    fun addRow(v: Vector):MatrixBuilder
    {
        matrix+=v
        return this
    }

    fun addRow(vararg v:Number):MatrixBuilder
    {
        matrix+= OperableVector(v.toMutableList())
        return this
    }

    fun clear():MatrixBuilder
    {
        matrix= mutableListOf()
        return this
    }

    open fun create(): Matrix { return ZeroMatrix(0,0) }
}