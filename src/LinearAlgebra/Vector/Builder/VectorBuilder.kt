package LinearAlgebra.Vector.Builder

import LinearAlgebra.Vector.Vector
import LinearAlgebra.Vector.ZeroVector

abstract class VectorBuilder {
    protected var vector = mutableListOf<Number>()
    var clearAfterCreate = false
    fun addElement(e:Number):VectorBuilder
    {
        vector+=e
        return this
    }

    fun addElement(vararg e:Number):VectorBuilder
    {
        vector+=e
        return this
    }

    fun setElement(m:MutableList<Number>):VectorBuilder
    {
        vector=m
        return this
    }

    fun clear():VectorBuilder
    {
        vector= mutableListOf()
        return this
    }

    open fun create():Vector { return ZeroVector(0) }
}