import LinearAlgebra.Matrix.OperableMatrix
import kotlin.random.Random.Default.nextInt as r


fun main(args:Array<String>)
{
    for(i in 0..0)
    {
        val l1 = listOf(
            mutableListOf(
                r(10, 10000),
                r(10, 100000),
                r(10, 1000)
            )
            , mutableListOf(r(10, 10000),
                r(10, 100000),
                r(10, 1000))
            , mutableListOf(r(10,1000),r(10,100),r(10,1000))
        )
        val l2 = listOf(
            mutableListOf(100,2880,37340)
            , mutableListOf(40,250,60)
            , mutableListOf(70,80,990)
        )
        val m1 = OperableMatrix(l1)
        val m2 = OperableMatrix(l2)
        print(m1+m2)
    }

}