package LinearAlgebra.Vector


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

    override fun toString(): String {
        return vector.toString()
    }

    operator fun get(m:Int):Double{return vector[m-1]}

    operator fun set(i: Int, value: Number) { vector[i-1]=value.toDouble() }

    open infix fun dot(v:Vector):Double
    {
        var total = 0.0
        for(i in 1..dim)
            total+=v[i]*this[i]
        return total
    }

}