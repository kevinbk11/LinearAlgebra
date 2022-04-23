package LinearAlgebra.Vector

import LinearAlgebra.Operable

open class OperableVector:Vector,Operable {
    constructor(vararg ele: Number) : super(ele.toMutableList())
    constructor(ele:MutableList<Number>):super(ele.toMutableList())

    operator fun plus(v:Vector):Vector { return this.getVector()+v }

    operator fun minus(v:Vector):Vector { return this.getVector()+(v*-1)}

    operator fun times(k:Number):Vector {return this.getVector()*k.toDouble()}

    operator fun div(k:Number):Vector {return this.getVector()*(1.0/k.toDouble())}
}