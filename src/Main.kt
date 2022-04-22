import LinearAlgebra.Matrix.IdentityMatrix
import LinearAlgebra.Matrix.OperableMatrix
import LinearAlgebra.Matrix.ZeroMatrix
import LinearAlgebra.Vector.Vector
import kotlin.reflect.jvm.internal.impl.descriptors.VariableAccessorDescriptor

class test<T>
{
    constructor(t:T)
    {
        when(t)
        {
            is Int->
            {

            }
        }
    }
}
fun main(args:Array<String>)
{
    val a:test<Float>
    for(i in 0..0)
    {
        val l1 = mutableListOf(Vector(1f,2f,3f),Vector(4f,5f,6f),Vector(7f,8f,9f),Vector(10f,11f,12f))
        val l2 = mutableListOf(Vector(3f,7f,3f),Vector(4f,9f,6f),Vector(7f,1f,9f))
        val l3 = mutableListOf(Vector(1f,2f),Vector(3f,4f),Vector(5f,6f))
        val l4 = mutableListOf(Vector(1f,2f ,3f),Vector(4f,5f,6f),Vector(7f,8f,9f))
        val l5 = mutableListOf(Vector(1f,4f,7f,9f),Vector(6f,5f,4f,2f),Vector(3f,9f,8f,7f),Vector(6f,5f,0f,1f))
        val l6 = mutableListOf(Vector(1f,4f,7f,9f,3f),Vector(6f,5f,4f,2f,0f),Vector(3f,9f,8f,7f,0f),Vector(6f,5f,0f,1f,2f),Vector(7f,5f,2f,1f,9f))
        val l7 = mutableListOf(Vector(12f,37f,315f),Vector(1f,9999f,9f),Vector(1f,2f,33f))
        val m1 = OperableMatrix(l1)
        val m2 = OperableMatrix(l2)
        val m3 = OperableMatrix(l3)
        val m4 = OperableMatrix(l4)
        val m5 = OperableMatrix(l5)
        val m6 = OperableMatrix(l6)
        val m7 = OperableMatrix(l7)
        println(m2*m2*m2 )
    }

}