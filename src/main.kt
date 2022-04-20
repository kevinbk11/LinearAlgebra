import LinearAlgebra.Matrix.OperableMatrix
import kotlin.random.Random.Default.nextInt as r


fun main(args:Array<String>)
{
    for(i in 0..0)
    {
        val l1 = listOf(mutableListOf(1,2,3),mutableListOf(4,5,6),mutableListOf(7,8,9),mutableListOf(10,11,12))
        val l2 = listOf(mutableListOf(3,7,3),mutableListOf(4,9,6),mutableListOf(7,1,9))
        val l3 = listOf(mutableListOf(1,2),mutableListOf(3,4),mutableListOf(5,6))
        val l4 = listOf(mutableListOf(1,3 ,3),mutableListOf(4,5,6),mutableListOf(7,8,9))
        val m1 = OperableMatrix(l1)
        val m2 = OperableMatrix(l2)
        val m3 = OperableMatrix(l3)
        val m4 = OperableMatrix(l4)
        print(m2)
        print(m2.T())
    }
}