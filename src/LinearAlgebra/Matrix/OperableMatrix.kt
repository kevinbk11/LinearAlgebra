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
    operator fun times(m:Int):OperableMatrix
    {
        return this.getMatrix()*m
    }
}