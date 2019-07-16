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
## 第2章 面向对象的编程概念  
1. ### 对象  
***基本属性：`行为`和`状态`***  
<br>软件对象使用`字段`(`field`，又称variable即变量)定义状态，用`方法`(`method`，又称function)函数定义行为  
隐藏对象内部状态，所有通信通过对象的方法实现的行为，是面向对象编程(`OOP`，Object Oriented Programming)的基本原则，通常称为`数据封装`  

2. ### 类  
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
3. ### 继承  
***类可以`继承`其他类的状态和行为。***  
<br>在Java中，每个类只能有一个直接超类(superclass，即父类)。  
子类创建，使用`extends`方法。  
	```javascript
	class MountainBike extends Bicycle{
		//new fields and methods defining
	}
	```  
4. ### 接口  
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

5. ### 包  
***包是相关类和接口的命名空间***  
<br>Java平台提供了庞大的类库用于开发应用程序。该类库通常称为`应用程序接口`(API，Application Programming Interface)。  
例如：  
	- `String`对象包含字符串的状态和行为  
	- `File`对象创建、删除、检查、修改、比较系统中的文件  
	- `Socket`对象支持网络套接字的创建和使用