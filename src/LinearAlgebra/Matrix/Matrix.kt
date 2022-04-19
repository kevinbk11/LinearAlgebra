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
                if(c==column-1)
                {
                    val lastSpaceCount = matrix.maxOfOrNull{it[column-1]}.toString().length-matrix[r][c].toString().length
                    var lastSpace=""
                    for(i in 1..lastSpaceCount)lastSpace+=" "
                    s+=String.format("%d${lastSpace}",matrix[r][c])
                }
                else
                {
                    s+=String.format("%d${space}",matrix[r][c])
                }


            }
            s+="]\n"
        }
        return s
    }


}