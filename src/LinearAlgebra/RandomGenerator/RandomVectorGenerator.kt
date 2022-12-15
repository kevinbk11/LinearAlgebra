package LinearAlgebra.RandomGenerator

import LinearAlgebra.Vector.Builder.OperableVectorBuilder
import LinearAlgebra.Vector.OperableVector
import kotlin.random.Random.Default.nextFloat


class RandomVectorGenerator(var vectorDim:Int) {
    val builder = OperableVectorBuilder(clearAfterCreate = true)
    fun genera():OperableVector
    {
        for(i in 0 until vectorDim)
        {
            builder.addElement(nextFloat())
        }
        return builder.create()
    }
}