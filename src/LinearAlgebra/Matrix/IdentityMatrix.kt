package LinearAlgebra.Matrix
import LinearAlgebra.Vector.Vector
class IdentityMatrix(m:Int):OperableMatrix(MutableList<Vector>(m){Vector(MutableList<Int>(m){0} )})
{
    init {
        for(i in 1 until m)this[i][i]=1
    }
}