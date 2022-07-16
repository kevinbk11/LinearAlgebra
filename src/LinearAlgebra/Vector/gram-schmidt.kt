package LinearAlgebra.Vector

import kotlin.math.abs


fun gram(vectorSet:MutableList<OperableVector>):MutableList<OperableVector>
{
    val newVectorSet= mutableListOf<OperableVector>()
    newVectorSet.add(vectorSet[0])
    for(i in 1..vectorSet.lastIndex)
    {
        var v=vectorSet[i]

        for(j in i-1 downTo 0)
            v -= newVectorSet[j]*((v dot newVectorSet[j])/(newVectorSet[j].magnitude()*newVectorSet[j].magnitude()))
        if(v.isZeroVector())newVectorSet+=ZeroVector(v.dim)
        else newVectorSet+=v
    }

    for(i in newVectorSet.indices)
        if(!newVectorSet[i].isZeroVector())
            newVectorSet[i]=newVectorSet[i]/(newVectorSet[i].magnitude())


    return newVectorSet

 /*修正gram-schmidt計算線性依賴的向量集合時異常的狀況
    新增專門用來傳遞QR矩陣和LU矩陣的資料類別
    求特徵值的功能完成*/
    //todo 向量集合的實作
}