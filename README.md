kotlin 線性代數模組
=
矩陣
-
#### 此模組中，矩陣的表示位置與數學上相同，最左上角的元素為(1,1)而非(0,0)
#### 且可以透過m[i][j]來取得矩陣內的元素
#### 而m[i]取出來的為向量
- 加減乘除 m1(+ - * / )m2
- 行列式 Matrix.det()
- 餘因子 Matrix.det(i,j)
- 求逆 Matrix.inverse()
- 伴隨矩陣 Matrix.adj()
- 刪除某行或某列
向量
-

- 加減 v1(+ -)m2
- 內積 v1 dot v2 (infix)

其他函式
-
- copy(Matrix or Vector) 可以複製輸入的矩陣或向量
