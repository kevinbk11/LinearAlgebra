package LinearAlgebra.Vector

open class Vector {
    var dim:Int
    private var vector:MutableList<Int> = mutableListOf()
    constructor(vararg ele:Int)
    {
        vector=ele.toMutableList()
        dim=ele.size
    }
    constructor(list: MutableList<Int>)
    {
        vector=list
        dim=list.size
    }

    fun getVectorList():MutableList<Int>{return vector}

    override fun toString(): String {
        return vector.toString()
    }

    operator fun get(m:Int):Int{return vector[m-1]}

    operator fun set(i: Int, value: Int) { vector[i-1]=value }


}