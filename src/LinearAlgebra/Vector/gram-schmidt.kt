package LinearAlgebra.Vector

fun gram(vectorSet:MutableList<OperableVector>):MutableList<OperableVector>
{
    val newVectorSet= mutableListOf<OperableVector>()
    newVectorSet.add(vectorSet[0])
    for(i in 1..vectorSet.lastIndex)
    {
        var v=vectorSet[i]

        for(j in i-1 downTo 0)
            v -= newVectorSet[j]*((v dot newVectorSet[j])/(newVectorSet[j].magnitude()*newVectorSet[j].magnitude()))

        newVectorSet.add(v)
    }

    for(i in newVectorSet.indices)
        newVectorSet[i]=newVectorSet[i]/(newVectorSet[i].magnitude())

    return newVectorSet
}