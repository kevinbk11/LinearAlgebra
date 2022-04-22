package LinearAlgebra.Vector


open class Vector {
    var dim:Int
    private var vector:MutableList<Float> = mutableListOf()
    var test = mutableListOf<Number>()
    constructor(vararg ele:Float)
    {
        vector=ele.toMutableList()
        dim=ele.size
    }
    constructor(vararg ele:Int)
    {
        val newMutableList = mutableListOf<Float>()
        for(i in ele)
        {
            newMutableList+=i.toFloat()
        }
        vector=newMutableList
        dim=ele.size
    }
    constructor(list: MutableList<Float>)
    {
        vector=list
        dim=list.size
    }



    fun getVectorList():MutableList<Float>{return vector}

    override fun toString(): String {
        return vector.toString()
    }

    operator fun get(m:Int):Float{return vector[m-1]}

    operator fun set(i: Int, value: Float) { vector[i-1]=value }


}