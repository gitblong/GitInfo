**注意：**`<>`代表必须有，`[]`代表可有可无
# 创建表
定义基本表

```
CREATE TABLE <表名> (<列明><数据类型> [列级完整性约束条件]
                     [,<列名><数据类型>[列级完整性约束条件]]
                     [,<表级完整性约束条件>]);
```
例子：
```
CREATE TABLE SC
(Sno CHAR(9),
 Cno CHAR(4),
 Grad SMALLINT,
 PRIMARY KEY (Sno,Cno),
 FOREIGN KEY (Sno) REFERENCES Student(Sno),
 FOREIGN KEY (Cno) REFERENCES Course(Cno)
)

-- 或者
CREATE TABLE SC
(Sno CHAR(9) PRIMARY KEY,//设置主键
 Grad SMALLINT,
 FOREIGN KEY (Sno) REFERENCES Student(Sno),
 FOREIGN KEY (Cno) REFERENCES Course(Cno)//设置外键
)
```
## 数值类型
<table>
<tr>

<th>类型</th>	<th>大小</th>	<th>范围（有符号）</th>	<th>范围（无符号）</th>	<th>用途</th>
</tr>
<tr>
<td>TINYINT</td>	<td>1 <td>字节</td>	<td>(-128，127)	(0，255)</td>	<td>小整数值</td>
</tr>
<tr>
<td>SMALLINT</td>	<td>2 字节</td>	<td>(-32 768，32 767)</td>	<td>(0，65 535)</td>	<td>大整数值</td>
</tr>
<tr>
<td>MEDIUMINT</td>	<td>3 字节</td>	<td>(-8 388 608，8 388 607)</td>	<td>(0，16 777 215)</td>	<td>大整数值</td>
</tr><tr>
<td>INT或INTEGER</td>	<td>4 字节</td>	<td>(-2 147 483 648，2 147 483 647)</td>	<td>(0，4 294 967 295)</td>	<td>大整数值</td>
</tr><tr>
<td>BIGINT</td>	<td>8 字节</td>	<td>(-9 233 372 036 854 775 808，9 223 372 036 854 775 807)</td>	<td>(0，18 446 744 073 709 551 615)</td>	<td>极大整数值</td>
</tr><tr>
<td>FLOAT</td>	<td>4 字节</td>	<td>(-3.402 823 466 E+38，-1.175 494 351 E-38)，0，(1.175 494 351 E-38，3.402 823 466 351 E+38)</td>	<td>0，(1.175 494 351 E-38，3.402 823 466 E+38)</td>	<td>单精度浮点数值</td>

</tr><tr>
<td>浮点数值DOUBLE</td>	<td>8 字节</td>	<td>(-1.797 693 134 862 315 7 E+308，-2.225 073 858 507 201 4 E-308)，0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308)	<td>0，(2.225 073 858 507 201 4 E-308，1.797 693 134 862 315 7 E+308)</td>	<td>双精度浮点数值</td>

</tr><tr>
<td>DECIMAL</td>	<td>对DECIMAL(M,D) ，如果M>D，为M+2否则为D+2</td>	<td>依赖于M和D的值</td>	<td>依赖于M和D的值</td>	<td>小数值</td>
</tr>
</table>

## 日期和时间类型
<table>
<tr>
<th>类型</th>	<th>大小
(字节)</th>	<th>范围</th>	<th>格式</th>	<th>用途</th>
</tr>
<tr>
<td>DATE</td>	<td>3</td>	<td>1000-01-01/9999-12-31</td>	<td>YYYY-MM-DD</td>	<td>日期值</td>
</tr><tr>
<td>TIME</td>	<td>3</td>	<td>'-838:59:59'/'838:59:59'</td>	<td>HH:MM:SS</td>	<td>时间值或持续时间</td>
</tr><tr>
<td>YEAR</td>	<td>1</td>	<td>1901/2155</td>	<td>YYYY</td>	<td>年份值</td>
</tr><tr>
<td>DATETIME</td>	<td>8</td>	<td>1000-01-01 00:00:00/9999-12-31 23:59:59	</td><td>YYYY-MM-DD HH:MM:SS	<td>混合日期和时间值</td>
</tr>
<tr>
<td>TIMESTAMP</td>	<td>4</td>	
<td>1970-01-01 00:00:00/2038

结束时间是第 2147483647 秒，北京时间 2038-1-19 11:14:07，格林尼治时间 2038年1月19日 凌晨 03:14:07
</td>

<td>YYYYMMDD HHMMSS</td>	<td>混合日期和时间值，时间戳</td>
</tr>
</table>


## 字符串类型
<table>
<tr>
<th>类型</th>	<th>大小</th>	<th>用途</th><tr>
<tr>
<td>CHAR</td>	<td>0-255字节</td>	<td>定长字符串</td>
</tr><tr>
<td>VARCHAR</td>	<td>0-65535 字节</td>	<td>变长字符串</td>
</tr><tr>
<td>TINYBLOB</td>	<td>0-255字节</td>	<td>不超过 255 个字符的二进制字符串</td>
</tr><tr>
<td>TINYTEXT</td>	<td>0-255字节</td>	<td>短文本字符串</td>
</tr><tr>
<td>BLOB</td>	<td>0-65 535字节</td>	<td>二进制形式的长文本数据</td>
</tr><tr>
<td>TEXT</td>	<td>0-65 535字节</td>	<td>长文本数据</td>
</tr><tr>
<td>MEDIUMBLOB</td>	<td>0-16 777 215字节</td>	<td>二进制形式的中等长度文本数据</td>
</tr><tr>
<td>MEDIUMTEXT</td>	<td>0-16 777 215字节</td>	<td>中等长度文本数据</td>
</tr><tr>
<td>LONGBLOB</td>	<td>0-4 294 967 295字节</td>	<td>二进制形式的极大文本数据</td>
</tr><tr>
<td>LONGTEXT</td>	<td>0-4 294 967 295字节</td>	<td>极大文本数据
</tr>
</table>

## 修改基本表ALTER
```
ALTER TABLE <表名>
[ADD <新列名> <数据类型> [完整约束]]
[DROP <完整性约束名>]
ALTER COLUMN <列名> <数据类型>];
```
例子：
```
//向Student表增加“入学时间”列，其数据类型为日期型。
ALTER TABLE Student ADD S_entrance DATE;
//不论表中原来是否已有数据，新增加的列一律为空值。

//将年龄的数据类型由字符型改为整数
ALTER TABLE Student ALTER COLUMN Sage INT;

//增加课程名称必须取得、唯一值的约束条件
ALTER TABLE Course ADD UNIQUE(Cname);

//ALTER 命令及 DROP 子句来删除以上创建表的 i 字段：
ALTER TABLE test  DROP i;

//修改字段类型及名称, 你可以在ALTER命令中使用 MODIFY 或 CHANGE 子句 。
//MODIFY方式
ALTER TABLE test MODIFY c CHAR(10);
//CHANGE方式，在CHANGE关键字之后，紧跟着的是你要修改的字段名，然后指定新字段名及类型
ALTER TABLE tset CHANGE i j BIGINT;

//指定字段 j 为 NOT NULL 且默认值为100 
ALTER TABLE tset MODIFY j BIGINT NOT NULL DEFAULT 100;
//如果你不设置默认值，MySQL会自动设置该字段默认为 NULL。

//修改字段默认值
ALTER TABLE test ALTER i SET DEFAULT 1000;

//展示表的列属性
 SHOW COLUMNS FROM test;

//修改表的引擎
 ALTER TABLE test ENGINE = MYISAM;
 
//修改表名
ALTER TABLE test RENAME TO alter_test;
```

## 删除基本表
```
//RESTRICT删除表存在限定条件（其它表中不存在与本表相关的数据）
//CASCADE删除表不存在限定条件（该表删除，也会删除相关联的表）
DROP TABLE<表名>[RESTRICT | CASCADE];
```

## 索引的建立
**索引一经建立，就由系统使用和维护它，不需要用户干预。建立索引时为了减少查询操作的时间，但如果增删改频繁，系统会花费许多时间来维护索引，从而降低了查询效率。**

### 创建索引语法

```
//UNIQUE表明此索引的每一个索引值只对应唯一的数据记录
//CLUSTER表明要建立的索引时聚簇索引。所谓聚簇索引时指索引项的顺序与表中记录的物理顺序一致的索引组织。
CREATE [UNIQUE][CLUSTER]INDEX<索引名>
ON <表名>(<列名>[次序][,<列名>[<次序>]]···)
```

### 删除索引语法

```
DROP INDEX <索引名>
```

# 数据查询
## **SELECT语句的一般语法格式**
```
SELECT [ALL|DISTINCT]<目标列表表达式>[别名][,<目标列表达式>[别名]]···
FROM <表名或视图名>[别名][,<表名或视图名>[别名]]···
[WHERE <条件表达式>]
GROUP BY <列名1> [HAVING<条件表达式>]]
ORDER BY <列名2> [ASC|DESC];

```

### 目标列表达式有以下可选格式：
（1）*

（2）<表名>.*

（3）COUNT([DISTINCT|ALL] *)

（4）[<表名>.]<属性列名表达式>[,[<表名>.]<属性列名表达式>]···
其中<属性列名表达式>可以是由属性列、作用域属性列的聚集函数和常用的任意算术运算（+，-，*，/）组成的运算公式。
### 聚集函数的一般格式为：
```
COUNT([DISTINCT|ALL]<列名>)
SUM([DISTINCT|ALL]<列名>)
AVG([DISTINCT|ALL]<列名>)   
MAX([DISTINCT|ALL]<列名>)
MIN([DISTINCT|ALL]<列名>)
```
### WHERE 子句的条件表达式有以下可选格式：
（1）
```
<属性名>&<属性列名>
<属性名>&<常量>
<属性名>&[ANY|ALL](SELECT语句)
```
（2）
```
<属性列名> [NOT] BETWEEN <属性列名> AND <属性列名>
<属性列名> [NOT] BETWEEN <常量> AND <常量>
<属性列名> [NOT] BETWEEN <SELECT语句> AND <SELECT语句>
```
(3)
```
<属性列名> [NOT]IN (<值1>[,<值2>]···)
<属性列名> [NOT]IN（SELECT语句)
```
(4)
```
<属性列名> [NOT] LIKE <匹配串>
```
(5)
```
<属性列名> IS [NOT] NULL
```
(6)
```
<条件表达式> AND <条件表达式> AND <条件表达式>···
<条件表达式> OR <条件表达式> OR <条件表达式>···
```

## 条件查询
* **`DISTINCT`查找不重复数据**
```
SELECT DISTINCT Sno FROM SC;
```
* **查询满足条件的元组**
<table>
<tr>
<th>查寻条件-------------</th><th>谓词</th>
</tr>
<tr>
<td>比较</td><td>=,>,<,>=,<=,!=,<>,!>,!<;NOT + 上述比较运算符</td>
</tr>
<td>确定范围</td><td>BETWEEN AND,NOT BETWEEN AND</td>
<tr>
<td>确认集合</td><td>IN,NOT IN</td>
</tr>
<tr>
<td>字符匹配</td><td>LIKE,NOT LIKE</td>
</tr>
<tr>
<td>空值</td><td>IS NULL,IS NOT NULL</td>
</tr>
<tr>
<td>多重条件（逻辑运算）</td><td>AND,OR,NOT</td>
</tr>
</table>

例子
```
SELECT Sname,Ssex
FROM Student
WHERE Sdept IN ('CS','MA','IS');
```
* **`LIKE`字符匹配`%`:任意字符，`_`单个字符**

* **排序`ORDER BY`,`ASC`升序，`DESC`降序**

* **分组`GROUP BY`子句结合HAVING <条件语句>选择分组条件**

例子
```
SELECT Sno
FROM SC
GROUP BY Sno
HAVING COUNT(*) >3;
```

## 连接查询
***等值连接与非等值连接**
当连接运算符为=时，称为**等值连接**。使用其它运算符称为**非等值连接**

**自身连接**

例子
```
SELECT FIRST.Cno,SECOND.Cpno
FROM Course FIRST,COURSE SECOND
WHERE FIRST.Cpno = SECOND.Cno;
```
**外链接**
* 左外连接
列出左边关系中的所有元组，右边的表若没有匹配则用NULL代替
* 右外链接
列出右边关系中的所有元组，左边的表若没有匹配则用NULL代替
```
SELECT Student.Sno,Sname,Ssex,Sage,Sdept,Cno,Grade
FROM Student LEEF OUT JOIN SC ON (Student.Sno = SC.Sno);
```
**嵌套查询**
```
SELECT Sname 
FROM Student
WHERE Sno IN/[<条件运算符>]                 //见上表条件运算符
           (SELECT Sno
           FROM SC
           WHERE Cno = '2');
```
或
```
SELECT Sname,(
SELECT Sno FROM SC
WHERE Cno = '2') AS no
WHERE Sno IN ('12131','121212')
```
**ANY、ALL的查询**

例子
```
SELECT Sname,Sage
FROM Student
WHERE Sage < ANY/ALL (SELECT Sage
                      FROM Student
                      WHERE Sdept = 'CS')
    AND Sdept <> 'CS';
```
**ANY(或SOME),ALL谓词与聚集函数、IN谓词等价转换关系**
下表中，=ANY等价于IN谓词，<ANY等价于<MAX,<>ALL等价于NOT IN谓语，<ALL等价于<MIN，等。

<table>
<tr>
<th></th>
<th>=</th>
<th><>或!=</th>
<th><</th>
<th><=</th>
<th>></th>
<th>>=</th>
</tr>
<tr>
<td>ANY</td>
<td>IN</td>
<td>--</td>
<td><MAX</td>
<td><=MAX</td>
<td>>MIN</td>
<td>>=MIN</td>
</tr>
<tr>
<td>ALL</td>
<td>--</td>
<td>NOT IN</td>
<td><MIN</td>
<td><=MIN</td>
<td>>MAX</td>
<td>>=MAX</td>
</tr>
</table>




**EXISTS的子查询**

例子
```
SELECT Sname 
From Student
WHERE EXISTS
        (SELECT * 
         FROM SC
         WHERE Sno = Student.Sno AND Cno ='1')
```
**`IN`与`EXISTS`的区别，`IN`是确定的值的范围，`EXISTS`确定的是行的范围**

## 集合查询

**并操作`UNION`**
```
//查询计算机科学系的学生及年龄不大于19岁的学生。
SELECT * FROM Student
WHERE Sdept ='CS'
UNION
SELECT * 
FROM Student
WHERE Sage<=19;
```
使用`UNION`将多个查询结果合并起来是，系统会自动去掉重复元组。如果要保留重复元组则用`UNION ALL`操作字符

**交操作`INTERSECT`**

```
//查询计算机科学系的学生与年龄不大于19岁的学生的交集
SELECT * 
FROM Student
WHERE Sdept = 'CS'
INTERSECT
SELECT * 
FROM Student
WHERE Sage<=19;
-----
//等同于
SELECT * 
FROM Student
WHERE Sdept = 'CS' AND
      Sage <= 19;
```

**差操作`EXCEPT`**
```
//查询计算机科学系的学生与年龄不大于19岁的学生的差集
SELECT * 
FROM Student
WHERE Sdept='CS'
EXCEPT
SELECT * 
FROM Student
WHERE Student
WHERE Sage <=19；
----------
//等同于
SELECT * 
FROM Student
WHERE Sdept = 'CS' AND Sage>19
```
# 插入数据

## 插入元组
```
INSERT
INTO <表名>[<属性1>[,<属性2>···]]
VALUES (<常量1>[,<常量2>···]);
```


## 插入子查询结果
```
INSERT
INTO <表名>[(<属性列1>[,<属性列2>···]]
子查询；
```
例子
```
INSERT INTO TEST
SELECT * FROM Student
GROUP BY Sdept
------
INSERT INTO TEST(Sdept,Avg_age)
SELECT * FROM Student
GROUP BY Sdept
```
# 修改数据
## 一般语法格式
```
UPFATE <表名>
SET <列名>=<表达式>[,<列名>=<表达式>]···
[WHERE <条件>];

```

# 删除数据
一般语法格式
```
DELET
FROM <表名>
[WHERE <条件>];
```
# 视图
## 一般语法格式
```
CREATE VIEW<视图名>[(<列名>[,<列名>]···)]
AS <子查询>
[WITH CHECK OPTION]
```
**查询视图语法与查询表语法相似不做阐述**

**视图有时不能够更新**

## 视图的作用
* 视图能够简化用户的操作
* 视图使用户能以多种角度看待同一数据
* 视图对重构数据库提供了一定程度的逻辑独立性
* 视图能够对机密数据提供安全保护
* 适当利用视图可以更清晰的表达查询