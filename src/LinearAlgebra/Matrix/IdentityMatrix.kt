package LinearAlgebra.Matrix
import LinearAlgebra.Vector.Vector
class IdentityMatrix(m:Int):OperableMatrix(MutableList<Vector>(m){Vector(MutableList<Float>(m){0f} )})
{
    init {
        for(i in 1 until m)this[i][i]=1f
    }
}