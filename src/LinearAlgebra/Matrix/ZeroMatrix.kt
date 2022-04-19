package LinearAlgebra.Matrix

class ZeroMatrix(m:Int, n:Int, matrix:List<MutableList<Int>> =List(m){MutableList(n){0} }): OperableMatrix(matrix)