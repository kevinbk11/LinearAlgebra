package LinearAlgebra.Matrix
import LinearAlgebra.Vector.Vector
import LinearAlgebra.Vector.ZeroVector

class ZeroMatrix(m:Int, n:Int, matrix:MutableList<Vector> =MutableList(m){ ZeroVector(n) }): OperableMatrix(matrix)
