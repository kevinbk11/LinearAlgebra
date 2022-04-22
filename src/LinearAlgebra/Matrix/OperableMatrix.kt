package LinearAlgebra.Matrix

import LinearAlgebra.Operable
import LinearAlgebra.Vector.Vector
import java.lang.Math.pow


open class OperableMatrix(private var matrix: MutableList<Vector>): Matrix(matrix),Operable {

    operator fun plus(m: Matrix): OperableMatrix
    {
        return m+this
    }

    operator fun minus(m:Matrix):OperableMatrix
    {
        return m+(this)*-1
    }

    operator fun times(k:Int):OperableMatrix
    {
        return this.getMatrix()*k
    }

    operator fun times(m:Matrix):OperableMatrix
    {
        return this.getMatrix()*m
    }


    fun T():OperableMatrix
    {
        val newMatrix= ZeroMatrix(column,row)
        for(r in 1..column)
            for(c in 1..row)
                newMatrix[r][c]=this[c][r]
        return newMatrix
    }

    fun det():Int
    {
        if(row!=column)throw error("This matrix is not m*m matrix!")
        if(row==2)return this[1][1]*this[2][2]-this[1][2]*this[2][1]
        var total = 0
        for(c in 1..column)
        {
            total+=pow(-1.0,c-1.0).toInt()*this[1][c]*cofactor(1,c)
        }
        /*for(r in 0 until row)
        {
            var pdiaTotal = 1
            var ndiaTotal = 1
            for(c in 0 until column)
            {
                pdiaTotal*=this[(r+c)%(row)+1][c+1]
                //print(this[(r+c)%(row)+1][c+1])
                ndiaTotal*=this[(r+c)%(row)+1][(column-1-c+row)%(row)+1]
                total=pdiaTotal-ndiaTotal
            }
            println()
        }*/
        return total
    }
    fun cofactor(m:Int,n:Int):Int
    {
        val matrixList = getMatrixList().toMutableList()
        matrixList.removeAt(m-1)

        for(k in 0 until row-1)
        {
            matrixList[k]=Vector(matrixList[k].getVectorList().toMutableList())
            matrixList[k].getVectorList().removeAt(n-1)
            matrixList[k].dim--
        }

        return OperableMatrix(matrixList).det()
    }

    fun inverse():OperableMatrix
    {
        if(row!=column)throw error("this matrix is not square matrix!")
        val newList= mutableListOf<Vector>()
        if(det()!=0)
        {
            for(i in 1..row)
            {
                val newVectorList= mutableListOf<Int>()
                for(j in 1..row)
                {
                    newVectorList+=cofactor(i,j)
                }
                newList+=Vector(newVectorList)
            }

            return OperableMatrix(newList)
        }
        else throw error("this matrix is not invertible! (det=0)")
    }
    fun adj():OperableMatrix
    {
        if(row!=column)throw error("this matrix is not square matrix!")
        val newList = mutableListOf<Vector>()
        for(i in 1..row)
        {
            val newVectorList= mutableListOf<Int>()
            for(j in 1..row)
            {
                newVectorList+=cofactor(i,j)*(pow(-1.0, ((i+j)%2).toDouble()).toInt()) // 正負正 :)
            }
            newList+=Vector(newVectorList)
        }
        return OperableMatrix(newList).T()
    }
}