package LinearAlgebra

import LinearAlgebra.Matrix.Matrix
import LinearAlgebra.Matrix.ZeroMatrix
import LinearAlgebra.Vector.Vector
import LinearAlgebra.Vector.ZeroVector

fun <T> copy(t:T):T
{
    when(t)
    {
        is Vector ->
        {
            val v = ZeroVector(t.dim)
            for(i in 1..t.dim)v[i]=t[i]
            return v as T
        }
        is Matrix ->
        {
            val m = ZeroMatrix(t.row,t.column)
            for(i in 1..t.row)m[i]=copy(t[i])
            return m as T
        }
    }
    throw error("It's not Vector or Matrix.")
}