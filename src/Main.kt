import LinearAlgebra.Matrix.IdentityMatrix
import LinearAlgebra.Matrix.OperableMatrix
import LinearAlgebra.Matrix.ZeroMatrix
import LinearAlgebra.Vector.Vector

fun main(args:Array<String>)
{
    for(i in 0..0)
    {
        val l1 = mutableListOf(Vector(1,2,3),Vector(4,5,6),Vector(7,8,9),Vector(10,11,12))
        val l2 = mutableListOf(Vector(3,7,3),Vector(4,9,6),Vector(7,1,9))
        val l3 = mutableListOf(Vector(1,2),Vector(3,4),Vector(5,6))
        val l4 = mutableListOf(Vector(1,2,3),Vector(4,5,6),Vector(7,8,9))
        val l5 = mutableListOf(Vector(1,4,7,9),Vector(6,5,4,2),Vector(3,9,8,7),Vector(6,5,0,1))
        val l6 = mutableListOf(Vector(1,4,12,9,3),Vector(6,5,4,2,0),Vector(3,9,8,7,0),Vector(6,5,0,1,2),Vector(7,5,2,1,9))
        val l7 = mutableListOf(Vector(-12,-37,315),Vector(1,-99999,9),Vector(1,2,33))
        val l8 = mutableListOf(Vector(1.5,3.5,1.5),Vector(2.0,4.5,3.0),Vector(3.0,0.5,4.5))
        val m1 = OperableMatrix(l1)
        val m2 = OperableMatrix(l2)
        val m3 = OperableMatrix(l3)
        val m4 = OperableMatrix(l4)
        val m5 = OperableMatrix(l5)
        val m6 = OperableMatrix(l6)
        val m7 = OperableMatrix(l7)
        val m8 = OperableMatrix(l8)
        println(m7)
    }

}