# JavaSE学习笔记  
## 第1章 快速入门  
环境搭建 `JDK` 下载与安装  
```
https://www.oracle.com/technetwork/java/javase/downloads/index.html
```    
IntelliJ IDE安装  
```
http://www.jetbrains.com/idea/download/  
```  

---  
## 第2章 面向对象的编程概念  
### 对象  
***基本属性：`行为`和`状态`***  
<br>软件对象使用`字段`(`field`，又称variable即变量)定义状态，用`方法`(`method`，又称function)函数定义行为  
隐藏对象内部状态，所有通信通过对象的方法实现的行为，是面向对象编程(`OOP`，Object Oriented Programming)的基本原则，通常称为`数据封装`  

### 类  
***类是创造个体对象的蓝图***  
<br>Java中Bicycle类的实现  
  ```javascript  
class Bicycle{  
	int cadence = 0;  
	int speed = 0;  
	int gear = 1;  
	void changeCadence(int newValue){  
		cadence = newValue;  
	}  
	  
	void changeGear(int newValue){  
		gear = newValue;  
	}  
  
	void changeSpeed(int newValue){  
		speed = newValue;  
	}  
}  
  ```  
  
### 继承  
***类可以`继承`其他类的状态和行为。***  
<br>在Java中，每个类只能有一个直接超类(superclass，即父类)。  
子类创建，使用`extends`方法。  
   ```java  
class MountainBike extends Bicycle{  
	//new fields and methods defining  
}  
  ```  
### 接口  
*对象通过接口与外界交互，因此，**方法是对象与外界的`接口`。***  
<br>**绝大多数情况下，接口被定义为一组方法体为空的相关方法的集合**  
  ```javascript
interface Bicycle{
	void ChangeCadence(int NewValue);
	void ChangeGear(int NewValue);
	void ChangeSpeed(int NewValue);
}
  ```  
实现该接口时，要更换类名，并使用关键字`implements`。  
  ```javascript
class ACMEBicycle implements Bicycle{
	int cadence = 0;
	int speed = 0;
	int gear = 1;
	/**The compiler will now require that methods
	*ChangeCadence, ChangeGear, ChangeSpeed
	*all be implemented. Compiler will fail
	*if those methods are missing from this class.
	*/
	void ChangeCadence(int NewValue){
		cadence = NewValue;
	}

	void ChangeSpeed(int NewValue){
		speed = NewValue;
	}

	void ChangeGear(int NewValue){
		gear = NewValue;
	}	 	
}
  ```  
通过实现接口，类可以更形式化地定义行为。  
**如果类声明实现一个接口，那么接口中定义的所有方法都必须出现在该类中，否则编译不通过。**  

### 包  
***包是相关类和接口的命名空间***  
<br>Java平台提供了庞大的类库用于开发应用程序。该类库通常称为`应用程序接口`(API，Application Programming Interface)。  
例如：  
	- `String`对象包含字符串的状态和行为  
	- `File`对象创建、删除、检查、修改、比较系统中的文件  
	- `Socket`对象支持网络套接字的创建和使用  

---  
## 第3章 语言基础  
### 变量  
1.`实例变量`（非静态字段）  
2.`类变量`（静态字段）  
3.使用`static`修饰符声明的字段，该变量只存在一个副本。  
4.`局部变量`  
5.`参数`  


### 命名  
变量名区分大小写，首字母字母开头，不支持空格、美元符($)  
使用完整单词提高可读性  
第一个单词首字母小写，其他单词首字母大写其余小写的驼峰式命名  


### 基本数据类型  
1.`byte`，8位带符号二进制补码整数。  
2.`short`，16位带符号二进制补码整数。  
3.`int`，32位带符号二进制补码整数。  
4.`long`，64位带符号二进制补码整数。  
5.`float`，32位单精度浮点数。  
6.`double`，64位双精度浮点数。  
7.`boolean`，逻辑类型，`true`和`false`两个值。  
8.`char`，16位Unicode字符。  
数据中数字之间使用下划线，便于区分  


### 数组  
***数组是固定数目的单一数据类型值的容器对象***  

数组声明  
  ```java
type[] anArrayOfType//type类型的数组，未指定大小
type anArrayOfType[]//也可以将方括号写在数组名后面
  ```  
创建使用new  
  ```java
anArray = new int[10];
  ```  
快捷方式定义和初始化数组  
  ```java
int[] anArray = {
		100, 200, 300
};
  ```  
多维数组  
  ```java
String[][] names = {
		{"Mr. ", "Mrs. "},
		{"Smith", "Jones"}
};	
  ```  
数组操作  
System类的arraycopy()方法  
  ```java
public static void arraycopy(Object src, int srcPos,  
Object dest, int destPos, int length)
  ```  
两个Object，src-原数组，dst-目标数组。将原数组从srcPos位置length长度的元素复制到目的数组的destPos位置。  


### 运算符  
*比较运算符的左值可以为常量*  
`instanceof`用于测试对象是否为类的实例、子类的实例或者特定接口的实例。null不是任何类的实例  
前置运算符（运算后的结果）和后置运算符（运算前的结果）的区别。  


### 表达式、语句和块  
`表达式`由变量、运算符和方法调用构造  
`语句`由;（分号）分隔  
`块`是一对花括号之间的语句  


### 控制流语句  
`if-then`语句，`if-then-else`语句，`while`语句与C语言类似  
`switch`语句，switch块逻辑与C类似，但是判断类型不限于基本类型，如String  
`for`语句  
 一般形式：  
  ```java
for(initialization; temination; increment){  
		statement(s);
}
  ```  

  *加强型：*  
  ```java
class EnhancedForDemo{
		public static void main(String[] args){
		int[] numbers = {1,2,3,4,5,6,7,8,9,10};
		for(int item : numbers){
			System.out.println(item);
		}
}
  ```  
  
`break`、`continue`、`return`语句  
	
---  
## 第4章 类与对象  
### 类的声明  
`修饰符`：public, private, protected, default  
`类名`:首字母大写  
如果有超类，在超类名称前加`extends`关键字。如果有接口，在接口前添加`implements`关键字。  
`类体`：花括号之间的部分  

    
### Java中的public class  
一个Java源文件中，**只能有一个`public`类**。  
main方法是程序的入口，JVM运行时寻找main方法，执行程序。Java规定文件名必须与public class相同，public class提供了编译的数据接口。  
若没有public类，每个类编译生成一个class文件，运行时选择一个作为数据来源。  


### 声明成员变量  
类中的成员变量，通常称为`字段`  
方法或代码块中的变量，通常称为`局部变量`  
方法声明中的变量，通常称为`参数`  
**访问修饰符**
	public，所有类都可以访问该字段  
	private，只有类内部可以访问该字段  
**类型**  
**变量名**  
  
### 定义方法  
命名方法  
单个动词，小写；多个动词组成，首字母小写，其余驼峰命名。  
重载方法  
方法名相同，参数列表不同  


### 构建构造器  
***每个类都包含构造器，调用构造器从类中构造对象，声明构造器名称与类名相同***  





