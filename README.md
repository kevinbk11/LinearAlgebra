kotlin 線性代數模組
=
矩陣
-
#### 此模組中，矩陣的表示位置與數學上相同，最左上角的元素為(1,1)而非(0,0)
#### 且可以透過m[i][j]來取得矩陣內的元素
#### 而m[i]取出來的為向量

向量
-

- 加減 
```kt
v1(+ -)v2
```
- 內積
```kt
v1 dot v2
```
- 外積
```kt
v1 cross v2
```
- 刪除某元素
```kt
OperableVector.removeAt(i)
```
- 計算模長
```kt
OperableVector.magnitude() 
```
- 回傳該向量是否為0 (在該程式中 0的定義是小於10^-8的值)
```kt
OperableVector.isZeroVector() 
```

其他函式
-
- 複製輸入的矩陣或向量
```kt
copy(OperableMatrix or Vector) 
```
- 將該List中的向量正交單範化
 ```kt
gram(MutableList<OperableVector>) 
```
