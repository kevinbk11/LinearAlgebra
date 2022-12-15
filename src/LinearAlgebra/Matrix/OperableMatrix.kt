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
        var total = 0.0
        for(c in 1..column)
        {
            total+=this[1][c]*cofactor(1,c)*pow(-1.0,c.toDouble()+1.0 )
        }
        return if(abs(total)<0.000001)0.0 else total
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

        val move:(Int,Boolean)-> Unit = {r,reverse->
            if(reverse)
                for(i in r until 1)
                    U[i]=U[i-1].also { U[i-1]=U[i] }
            else
                for(i in r until row)
                    U[i]=U[i+1].also { U[i+1]=U[i] }
        }

        for(c in 1..U.column)
            for(r in c+1..U.row)
            {
                if(U[c][c]==0.0)
                    move(c,false)
                minus(r,c)
            }

        return LUDataClass(L,U)
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
            t++

            for(i in 1..row)
                thisEigenvalue.add(String.format("%.4f",A[i][i]).toDouble())

            /*for(i in lastEigenvalue.indices)
                if(abs(lastEigenvalue[i]-thisEigenvalue[i])<0.0000000001)
                {
                    eigenvalue.add(thisEigenvalue[i])

                }*/
            if(t>row*10)
            {
                return thisEigenvalue
            }
            println(thisEigenvalue)
        }while(thisEigenvalue!=lastEigenvalue)
        return thisEigenvalue
    }

    fun eigenvector()
    {
        val eigenvalue=eigenvalue()
        for(i in eigenvalue.indices)
        {
            println(eigenvalue[i])
            val A=copy(this)
            for(j in 1..row)
                A[j][j]-=eigenvalue[i]
            println(A.det())
        }
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

        val move:(Int,Boolean)-> Unit = {r,reverse->
            if(reverse)
                for(i in r downTo 2)
                    m[i]=m[i-1].also { m[i-1]=m[i] }
            else
                for(i in r until row)
                    m[i]=m[i+1].also { m[i+1]=m[i] }
        }

        for(c in 1..column)
        {
            for(r in c+1..row)
            {
                if(m[c][c]==0.0)
                    move(c,false)
                minus(r,c)
            }
        }
        if(m.isReducedRowEchelonForm())return m

        for(c in column downTo 1)
        {
            for(r in c-1 downTo 1)
            {
                if(m[c][c]==0.0)
                    continue
                minus(r,c)
            }
            if(m[c][c]!=0.0)m[c]=m[c]/m[c][c]
        }

        return m
    }
}