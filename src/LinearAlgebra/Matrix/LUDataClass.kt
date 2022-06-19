package LinearAlgebra.Matrix

data class LUDataClass(val L:OperableMatrix,val U:OperableMatrix)
{
    override fun toString(): String { return "L=\n${L}\nU=\n$U" }
}
