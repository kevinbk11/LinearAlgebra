package LinearAlgebra.Vector.Builder

import LinearAlgebra.Vector.OperableVector
import LinearAlgebra.Vector.Vector

class OperableVectorBuilder: VectorBuilder() {
    override fun create(): Vector
    {
        val v = OperableVector(vector)
        if(clearAfterCreate) { clear() }
        return v
    }
}