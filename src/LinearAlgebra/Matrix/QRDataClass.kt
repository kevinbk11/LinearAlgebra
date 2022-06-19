package LinearAlgebra.Matrix

data class QRDataClass(val Q:OperableMatrix, val R:OperableMatrix)
{
    override fun toString(): String { return "Q=\n${Q}\nR=\n$R" }
}