package LinearAlgebra.Vector.Builder

import LinearAlgebra.Vector.OperableVector
import LinearAlgebra.Vector.Vector

class OperableVectorBuilder(clearAfterCreate:Boolean=false): VectorBuilder(clearAfterCreate) {

    override fun addElement(vararg e: Number): OperableVectorBuilder { return super.addElement(*e) as OperableVectorBuilder }

    override fun addElement(e: Number): OperableVectorBuilder { return super.addElement(e) as OperableVectorBuilder }

    override fun setElement(m: MutableList<Number>): OperableVectorBuilder { return super.setElement(m) as OperableVectorBuilder }

    override fun create(): OperableVector
    {
        val v = OperableVector(vector)
        if(clearAfterCreate) { clear() }
        return v as OperableVector
    }

    override fun clear(): OperableVectorBuilder {
        return super.clear() as OperableVectorBuilder
    }

}