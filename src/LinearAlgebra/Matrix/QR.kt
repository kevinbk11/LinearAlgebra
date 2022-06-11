package LinearAlgebra.Matrix

import LinearAlgebra.Matrix.Builder.OperableMatrixBuilder
import LinearAlgebra.Vector.Builder.OperableVectorBuilder
import LinearAlgebra.Vector.OperableVector
import LinearAlgebra.Vector.gram

fun QR(matrix: OperableMatrix):Pair<OperableMatrix,OperableMatrix>
{
    val vectorSet = mutableListOf<OperableVector>()

    for(v in 1..matrix.column)
        vectorSet.add(matrix.getColumnVector(v))

    val gramed=gram(vectorSet)
    val vBuilder = OperableVectorBuilder(clearAfterCreate = true)
    val mBuilder = OperableMatrixBuilder(clearAfterCreate = true)

    for(v in gramed)
        mBuilder.addRow(v)

    val Q=mBuilder.create().T()
    for(i in 1..matrix.column)
    {
        val RList= mutableListOf<Double>()
        for(j in 1 until i)
            RList+=0.0
        for(j in i..matrix.column)
            RList+=(matrix.getColumnVector(j) dot Q.getColumnVector(i))
        mBuilder.addRow(vBuilder.setElement(RList as MutableList<Number>).create())
    }
    val R = mBuilder.create()
    return Pair(Q,R)
}