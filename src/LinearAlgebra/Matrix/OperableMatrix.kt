package LinearAlgebra.Matrix

import LinearAlgebra.Operable


open class OperableMatrix(private var matrix: List<MutableList<Int>>): Matrix(matrix),Operable {
    operator fun plus(m: Matrix): OperableMatrix
    {
        return m+this
    }

    operator fun minus(m:Matrix):OperableMatrix
    {
        return m+(this)*-1
    }

    operator fun times(k:Int):OperableMatrix
    {
        return this.getMatrix()*k
    }

    operator fun times(m:Matrix):OperableMatrix
    {
        return this.getMatrix()*m
    }

}