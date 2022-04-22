package LinearAlgebra.Vector


open class Vector {
    var dim:Int
    private var vector:MutableList<Double> = mutableListOf()
    var test = mutableListOf<Number>()
    constructor(vararg ele:Double)
    {
        vector=ele.toMutableList()
        dim=ele.size
    }
    constructor(vararg ele:Int)
    {
        val newMutableList = mutableListOf<Double>()
        for(i in ele)
        {
            newMutableList+=i.toDouble()
        }
        vector=newMutableList
        dim=ele.size
    }
    constructor(list: MutableList<Double>)
    {
        vector=list
        dim=list.size
    }



    fun getVectorList():MutableList<Double>{return vector}

    override fun toString(): String {
        return vector.toString()
    }

    operator fun get(m:Int):Double{return vector[m-1]}

    operator fun set(i: Int, value: Double) { vector[i-1]=value }


}