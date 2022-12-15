package LinearAlgebra.RandomGenerator

import LinearAlgebra.Matrix.Builder.OperableMatrixBuilder
import LinearAlgebra.Matrix.OperableMatrix

class RandomMatrixGenerator(var row:Int,var column:Int) {
    val builder=OperableMatrixBuilder(clearAfterCreate = true)
    val vectorGenerator=RandomVectorGenerator(column)
    fun genera():OperableMatrix
    {
        for(i in 0 until row)
        {
            builder.addRow(vectorGenerator.genera())
        }
        return builder.create()
    }
}