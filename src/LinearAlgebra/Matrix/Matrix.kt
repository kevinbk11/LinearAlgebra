package LinearAlgebra.Matrix

abstract class Matrix(private var matrix: List<MutableList<Int>>) {
    var row=matrix.size
    var column=matrix[0].size
    fun getMatrix(): Matrix {return this}

    operator fun get(row:Int,column:Int): Int
    {
        return matrix[row][column]
    }

    operator fun get(row:Int): MutableList<Int>
    {
        return matrix[row]
    }

    operator fun set(row:Int,column:Int,num:Int){}

    override fun toString(): String {
        val maxNumber:Number? = matrix.maxOfOrNull { it.maxOf { it.toFloat() } }
        val maxLength = maxNumber.toString().length
        var s=""
        for(r in matrix.indices)
        {
            s+="["
            for(c in matrix[0].indices)
            {
                val spaceCount=maxLength-matrix[r][c].toString().length
                var space=""
                for(i in 1..spaceCount)space+=" "
                s+=String.format("%d${space}",matrix[r][c])
                s+= if(c==column-1)"" else " "
            }
            s+="]\n"
        }
        return s
    }


}