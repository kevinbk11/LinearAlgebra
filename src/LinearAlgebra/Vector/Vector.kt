package LinearAlgebra.Vector

import LinearAlgebra.Matrix.Builder.OperableMatrixBuilder
import kotlin.math.abs
import kotlin.math.sqrt


abstract class Vector(list: MutableList<Number>) {
    var dim:Int
    var vector:MutableList<Double> = mutableListOf()

    fun removeAt(i:Int)
    {
        vector.removeAt(i-1)
        dim--
    }

    init {
        vector=list.toMutableList() as MutableList<Double>

        for(index in vector.indices)
            if(abs(vector[index])<0.000001)
                vector[index]=0.0

        dim=list.size
    }

    fun getVector():Vector {return this}

    override fun toString(): String
    {
        var s="[%.6f".format(this[1])
        for(e in vector.slice(1 until dim))
            s+=",%.6f".format(e)
        s+="]"
        return s
    }

    operator fun get(m:Int):Double{return vector[m-1]}

    operator fun set(i: Int, value: Number) { if(abs(value as Double)>0.00001) vector[i-1]=value.toDouble() else vector[i-1]=0.0 }

    override fun equals(other: Any?): Boolean {

        when(other)
        {
            is Vector->
            {
                if(other.dim!=dim)return false
                else
                {
                    for(i in 1..dim)
                        if(other[i].toFloat()!=this[i].toFloat()) return false
                    return true
                }
            }
            else -> return false
        }
    }

    open infix fun dot(v:Vector):Double
    {
        var total = 0.0

        for(i in 1..dim)
            total+=v[i]*this[i]

        return if(abs(total)>0.00000001) total else 0.0
    }

    open infix fun cross(v: Vector): OperableVector {
        val builder = OperableMatrixBuilder()
        builder.addRow(1, 1, 1)
            .addRow(this)
            .addRow(v)
        val m = builder.create()
        return OperableVector(m.cofactor(1, 1), -m.cofactor(1, 2), m.cofactor(1, 3))
    }

    open fun isZeroVector():Boolean
    {
        if(magnitude()>0.00000001)return false
        return true
    }

    open fun isNotZeroVector():Boolean
    {
        return !isZeroVector()
    }

    open fun magnitude():Double
    {
        var total = 0.0
        for(ele in vector)
            total+=(ele*ele)
        return sqrt(total)
    }
}