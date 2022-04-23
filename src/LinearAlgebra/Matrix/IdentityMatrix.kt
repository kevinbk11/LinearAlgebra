package LinearAlgebra.Matrix
import LinearAlgebra.Vector.OperableVector

class IdentityMatrix(m:Int):OperableMatrix(MutableList(m){OperableVector(MutableList(m){0} ) })
{
    init {
        for(i in 1 until m)this[i][i]=1.0
    }
}