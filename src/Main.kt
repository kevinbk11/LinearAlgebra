import LinearAlgebra.Matrix.*
import LinearAlgebra.Vector.*
fun main(args:Array<String>)
{

    for(i in 0..0)
    {
        val l1 = mutableListOf<Vector>(
            OperableVector(1,2,3),
            OperableVector(4,5,6),
            OperableVector(7,8,9),
            OperableVector(10,11,12))

        val l2 = mutableListOf<Vector>(
            OperableVector(3,7,3),
            OperableVector(4,9,6),
            OperableVector(7,1,9))

        val l3 = mutableListOf<Vector>(
            OperableVector(1,2),
            OperableVector(3,4),
            OperableVector(5,6))

        val l4 = mutableListOf<Vector>(
            OperableVector(1,2,3),
            OperableVector(4,5,6),
            OperableVector(7,8,9))

        val l5 = mutableListOf<Vector>(
            OperableVector(1,4,7,9),
            OperableVector(6,5,4,2),
            OperableVector(3,9,8,7),
            OperableVector(6,5,0,1))

        val l6 = mutableListOf<Vector>(
            OperableVector(1,4,12,9,3),
            OperableVector(6,5,4,2,0),
            OperableVector(3,9,8,7,0),
            OperableVector(6,5,0,1,2),
            OperableVector(7,5,2,1,9))

        val l7 = mutableListOf<Vector>(
            OperableVector(-12,-37,315),
            OperableVector(1,-99999,9),
            OperableVector(1,2,33))

        val l8 = mutableListOf<Vector>(
            OperableVector(1.5,3.5,1.5),
            OperableVector(2.0,4.5,3.0),
            OperableVector(3.0,0.5,4.5))

        val m1 = OperableMatrix(l1)
        val m2 = OperableMatrix(l2)
        val m3 = OperableMatrix(l3)
        val m4 = OperableMatrix(l4)
        val m5 = OperableMatrix(l5)
        val m6 = OperableMatrix(l6)
        val m7 = OperableMatrix(l7)
        val m8 = OperableMatrix(l8)
        print(m1+m1)

        val v1 = OperableVector(1,2,3)
        val v2 = OperableVector(4,5,6)
        print(v1 dot v2)
    }

}