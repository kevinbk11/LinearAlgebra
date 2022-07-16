package LinearAlgebra.Matrix

import LinearAlgebra.Matrix.Builder.OperableMatrixBuilder
import LinearAlgebra.Operable
import LinearAlgebra.Vector.Builder.OperableVectorBuilder
import LinearAlgebra.Vector.OperableVector
import LinearAlgebra.Vector.Vector
import LinearAlgebra.Vector.gram
import LinearAlgebra.copy
import java.lang.Math.abs
import java.lang.Math.pow


open class OperableMatrix(private var matrix: MutableList<Vector>): Matrix(matrix),Operable {

    operator fun plus(m: Matrix): OperableMatrix { return m+this }

    operator fun minus(m:Matrix):OperableMatrix { return this+(m*-1.0) }

    operator fun times(k:Number):OperableMatrix { return this.getMatrix()*k.toDouble() }

    operator fun times(m:Matrix):OperableMatrix { return this.getMatrix()*m }

    operator fun div(k:Number):OperableMatrix { return this.getMatrix()*(1.0/k.toDouble()) }

    operator fun div(m:OperableMatrix):OperableMatrix { return this.getMatrix()*m.inverse()}

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
        if(row==1)return this[1][1]
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

        val mBuilder = OperableMatrixBuilder()
        mBuilder.clearAfterCreate=true
        val vBuilder = OperableVectorBuilder()
        vBuilder.clearAfterCreate=true
        for(i in 1..row)
        {
            for(j in 1..row)
                vBuilder.addElement(cofactor(i,j)*(pow(-1.0, ((i+j)).toDouble()).toInt()))
            mBuilder.addRow(vBuilder.create())
        }
        return mBuilder.create().T()
    }

    fun QR():QRDataClass
    {
        val vectorSet = mutableListOf<OperableVector>()

        for(v in 1..column)
            vectorSet.add(getColumnVector(v))

        val gramed= gram(vectorSet)
        val vBuilder = OperableVectorBuilder(clearAfterCreate = true)
        val mBuilder = OperableMatrixBuilder(clearAfterCreate = true)

        for(v in gramed)
            mBuilder.addRow(v)

        val Q=mBuilder.create().T()
        for(i in 1..column)
        {
            val RList= mutableListOf<Double>()
            for(j in 1 until i)
                RList+=0.0
            for(j in i..column)
                RList+=(getColumnVector(j) dot Q.getColumnVector(i))
            mBuilder.addRow(vBuilder.setElement(RList as MutableList<Number>).create())
        }
        val R = mBuilder.create()
        return QRDataClass(Q,R)
    }

    fun LU():LUDataClass
    {
        val L=IdentityMatrix(row)
        val U = copy(this)

        val minus:(Int,Int) -> Unit = {r,c->
            val k = U[r][c]/U[c][c]
            U[r]-=U[c]*k
            L[r][c]=k
        }

        var deleted = 0//已被刪除的向量數量

        for(c in 1..column)//這裡面在刪除列零向量
        {
            if(U.getColumnVector(c-deleted).isZeroVector())
            {
                U.removeColumn(c-deleted)
                deleted++
                //若要刪除原本的1 2 4行 刪除第1行之後 原本的2 4行在新的矩陣中是1 3 所以要把2跟4扣除1
                //而刪除原本的2(新的1)之後 若要刪除原本的4(新的2) 必須要將4扣除2 才會正確
            }
        }

        for(c in 1..U.column)
            for(r in c+1..U.row)
                if(U[r][c]!=0.0)
                    minus(r,c)

        val newU=ZeroMatrix(row,column)

        for(r in 1..row)
        {
            var Ucolumn=1
            for(c in 1..column)
            {
                if(this.getColumnVector(c).isNotZeroVector())
                {
                    newU[r][c]=U[r][Ucolumn]
                    Ucolumn++
                }
            }
        }

        return LUDataClass(L,newU)
    }

    fun eigenvalue():List<Double>
    {
        var A=copy(this)
        var QR:QRDataClass
        var lastEigenvalue:MutableList<Double>
        val thisEigenvalue = mutableListOf<Double>()
        val eigenvalue = mutableListOf<Double>()
        var t = 0

        do
        {
            lastEigenvalue=thisEigenvalue.toMutableList()
            thisEigenvalue.clear()
            QR=A.QR()
            A=QR.R*QR.Q
            for(i in 1..row)
                thisEigenvalue.add(A[i][i])
            for(i in lastEigenvalue.indices)
                if(abs(lastEigenvalue[i]-thisEigenvalue[i])<0.0000000001)
                {
                    eigenvalue.add(thisEigenvalue[i])
                    t++
                }
            if(t>row*100)
            {
                return eigenvalue
            }
            eigenvalue.clear()
        }while(thisEigenvalue!=lastEigenvalue)
        return thisEigenvalue
    }

    fun solveEquationWithLU(B:OperableMatrix):OperableMatrix
    {
        fun solve(m: OperableMatrix,b:OperableMatrix):OperableMatrix
        {
            val Y=ZeroMatrix(B.row,1)
            Y[1][1]=b[1][1]/m[1][1]
            for(i in 2..row)
            {
                var total = b[i][1]
                for(j in 1..i)
                {
                    total-=m[i][j]*Y[j][1]
                }
                Y[i][1]=total/m[i][i]
            }
            return Y
        }

        val LU=LU()
        val L=LU.L
        val U=LU.U
        val Y=solve(L,B)
        val UT=U.T()

        for(i in 1..row/2)
        {
            UT[i][i]=UT[row+1-i][row+1-i].also{UT[row+1-i][row+1-i]=UT[i][i]}
            Y[i][1]=Y[row+1-i][1].also{Y[row+1-i][1]=Y[i][1]}
        }
        val X=solve(UT,Y)
        for(i in 1..row/2)X[i][1]=X[row+1-i][1].also { X[row+1-i][1]= X[i][1]}
       return X
    }
    fun gauss():OperableMatrix
    {
        val m = copy(this)

        val minus:(Int,Int) -> Unit = {r,c->
            val k = m[r][c]/m[c][c]
            m[r]-=m[c]*k
        }

        for(c in 1..column)
            for(r in c+1..row)
                if(m[r][c]!=0.0)
                    minus(r,c)

        for(c in column downTo 1)
        {
            for(r in c-1 downTo 1)
                if(m[r][c]!=0.0)
                    minus(r,c)
            m[c]=m[c]/m[c][c]
        }

        return m
    }
}