package LinearAlgebra.Vector


abstract class Vector(list: MutableList<Number>) {
    var dim:Int
    var vector:MutableList<Double> = mutableListOf()

    init {
        vector=list.toMutableList() as MutableList<Double>
        dim=list.size
    }
    fun getVector():Vector {return this}
    /*constructor(array: MutableList<Int>)
    {
        val newMutableList= mutableListOf<Double>()
        for(element in array)
        {
            newMutableList+=element.toDouble()
        }
        vector=newMutableList
        dim=array.size
    }*/


    fun getVectorList():MutableList<Double>{return vector}

    override fun toString(): String {
        return vector.toString()
    }

    operator fun get(m:Int):Double{return vector[m-1]}

    operator fun set(i: Int, value: Double) { vector[i-1]=value }

    open infix fun dot(v:Vector):Double
    {
        var total = 0.0
        for(i in 1..dim)
            total+=v[i]*this[i]
        return total
    }

}