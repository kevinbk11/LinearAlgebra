package LinearAlgebra.Vector

import LinearAlgebra.Matrix.Builder.OperableMatrixBuilder


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
        dim=list.size
    }

    fun getVector():Vector {return this}

    override fun toString(): String { return vector.toString() }

    operator fun get(m:Int):Double{return vector[m-1]}

    operator fun set(i: Int, value: Number) { vector[i-1]=value.toDouble() }

    open infix fun dot(v:Vector):Double
    {
        var total = 0.0
        for(i in 1..dim)
            total+=v[i]*this[i]
        return total
    }

    open infix fun cross(v: Vector): Vector {
        val builder = OperableMatrixBuilder()
        builder.addRow(1, 1, 1)
            .addRow(this)
            .addRow(v)
        val m = builder.create()
        return OperableVector(m.cofactor(1, 1), -m.cofactor(1, 2), m.cofactor(1, 3))
    }

    open fun isZeroVector():Boolean
    {
        for(ele in vector)
            if(ele!=0.0)return false
        return true
    }
}