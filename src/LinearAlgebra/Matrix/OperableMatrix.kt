package LinearAlgebra.Matrix

import LinearAlgebra.Operable
import LinearAlgebra.Vector.OperableVector
import LinearAlgebra.Vector.Vector
import LinearAlgebra.copy
import java.lang.Error
import java.lang.Math.pow

open class OperableMatrix(private var matrix: MutableList<Vector>): Matrix(matrix),Operable {

    operator fun plus(m: Matrix): OperableMatrix { return m+this }

    operator fun minus(m:Matrix):OperableMatrix { return m+(this)*-1.0 }

    operator fun times(k:Number):OperableMatrix { return this.getMatrix()*k.toDouble() }

    operator fun times(m:Matrix):OperableMatrix { return this.getMatrix()*m }

    operator fun div(k:Number):OperableMatrix { return this.getMatrix()*(1.0/k.toDouble()) }


    fun T():OperableMatrix
    {
        val newMatrix= ZeroMatrix(column,row)
        for(r in 1..column)
            for(c in 1..row)
                newMatrix[r][c]=this[c][r]
        return newMatrix
    }

    fun det():Double
    {
        if(row!=column)throw error("This matrix is not m*m matrix!")
        if(row==2)return this[1][1]*this[2][2]-this[1][2]*this[2][1]
        var total = 0.0
        for(c in 1..column)
        {
            total+=this[1][c]*cofactor(1,c)*pow(-1.0,c.toDouble()+1.0 )
        }
        return total
    }
    fun cofactor(m:Int,n:Int):Double
    {
        val mat = copy(this)

        mat.removeRow(m)
        mat.removeColumn(n)

        return (mat).det()
    }

    fun inverse():OperableMatrix
    {
        if(row!=column)throw error("this matrix is m*m matrix!")
        if(det()!=0.0)
        {
            val adjMatrix = adj()
            return adjMatrix/det()
        }
        else throw error("this matrix is not invertible! (det=0)")
    }

    fun adj():OperableMatrix
    {
        if(row!=column)throw error("this matrix is not square matrix!")
        val newList = mutableListOf<Vector>()
        for(i in 1..row)
        {
            val newVectorList= mutableListOf<Number>()
            for(j in 1..row)
                newVectorList+=cofactor(i,j)*(pow(-1.0, ((i+j)).toDouble()).toInt())
            newList+=OperableVector(newVectorList)
        }
        return OperableMatrix(newList).T()
    }

    fun solveEquation(B:Matrix):Matrix?
    {
        var oneSolution = true

        val newThis=copy(this)
        val newB = copy(B)

        val removeZeroVector = {i:Int->
            newThis.removeRow(i)
            newB.removeRow(i)
        }

        val rowOperation = {i:Int,j:Int,k:Double->
            newThis[j]=newThis[j]-(newThis[i]*k)
            newB[j]=newB[j]-(newB[i]*k)
        }
        for(i in 1..newThis.row)
        {
            var removed = 0
            for(j in i+1..newThis.row)
            {
                val realJ=j-removed
                if(newThis[realJ][i]==0.0) { newThis[realJ]=newThis[realJ+1].also { newThis[realJ+1]=newThis[realJ] } }

                val k = (newThis[realJ][i]/newThis[i][i])

                rowOperation(i,realJ,k)

                if(newThis[realJ].isZeroVector() && newB[realJ].isZeroVector()) { removeZeroVector(realJ) ; removed++}
                else if(newThis[realJ].isZeroVector()) { return null }
            }
        }

        for(i in newThis.row downTo 1)
        {
            var removed = 0
            for(j in i-1 downTo 1)
            {
                val realJ=j-removed
                if(newThis[realJ][i]==0.0) { newThis[realJ]=newThis[realJ+1].also { newThis[realJ+1]=newThis[realJ] } }

                val k = (newThis[realJ][i]/newThis[i][i])

                rowOperation(i,realJ,k)

                if(newThis[realJ].isZeroVector() && newB[realJ].isZeroVector()) { removeZeroVector(realJ) ; removed++}
                else if(newThis[realJ].isZeroVector()) { return null }
            }
        }

        val builder=MatrixBuilder()

        if(newThis.row!=row)
        {
            for(i in 1..newThis.row)
            {
                val k = newThis[i][i]
                newThis[i]=newThis[i]/k
                newB[i]=newB[i]/k

                val vectorList = mutableListOf<Number>()
                for(j in 1..newThis.column)
                    vectorList.add(newThis[i][j])

                vectorList.add(newB[i][1])
                builder.addVector(OperableVector(vectorList))
            }
            return builder.create()
        }
        else return newB
    }
}