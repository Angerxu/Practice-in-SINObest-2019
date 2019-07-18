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
> <br>软件对象使用`字段`(`field`，又称variable即变量)定义状态，用`方法`(`method`，又称function)函数定义行为  
<br>隐藏对象内部状态，所有通信通过对象的方法实现的行为，是面向对象编程(`OOP`，Object Oriented Programming)的基本原则，通常称为`数据封装`  

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
<br>子类创建，使用`extends`方法。
  
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
<br>**如果类声明实现一个接口，那么接口中定义的所有方法都必须出现在该类中，否则编译不通过。**  

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
> 1.`实例变量`（非静态字段）  
2.`类变量`（静态字段）  
3.使用`static`修饰符声明的字段，该变量只存在一个副本。  
4.`局部变量`  
5.`参数`。方法声明中的变量。  


### 命名  
变量名区分大小写，首字母字母开头，不支持空格、美元符($)  
<br>使用完整单词提高可读性  
<br>第一个单词首字母小写，其他单词首字母大写其余小写的`驼峰式命名`  


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
System类的`arraycopy()`方法  
  ```java
public static void arraycopy(Object src, int srcPos,  
Object dest, int destPos, int length)
  ```  
两个Object，src-原数组，dst-目标数组。将原数组从srcPos位置length长度的元素复制到目的数组的destPos位置。  


### 运算符  
*比较运算符的左值可以为常量*  
`instanceof`用于测试对象是否为类的实例、子类的实例或者特定接口的实例。null不是任何类的实例  
<br>前置运算符（运算后的结果）和后置运算符（运算前的结果）的区别。  


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
> `修饰符`：public, private, protected, default  
`类名`:首字母大写  
如果有超类，在超类名称前加`extends`关键字。如果有接口，在接口前添加`implements`关键字。  
`类体`：花括号之间的部分  

    
### Java中的public class  
一个Java源文件中，**只能有一个`public`类**。  
> main方法是程序的入口，JVM运行时寻找main方法，执行程序。Java规定文件名必须与public class相同，public class提供了编译的数据接口。  
若没有public类，每个类编译生成一个class文件，运行时选择一个作为数据来源。  


### 声明成员变量  
类中的成员变量，通常称为`字段`  
方法或代码块中的变量，通常称为`局部变量`  
方法声明中的变量，通常称为`参数`  

**访问修饰符**
`public`，所有类都可以访问该字段  
`private`，只有类内部可以访问该字段  
<br>**类型**  
<br>**变量名**  
  
### 定义方法  
命名方法  
> 单个动词，小写；多个动词组成，首字母小写，其余驼峰命名。  

<br>**必需元素**
(1)修饰符
(2)返回类型
(3)方法名
(4)圆括号内的参数列表
(5)异常列表
(6)花括号内的方法体
<br>重载方法  
> 方法名相同，参数列表不同  


### 构建构造器  
***每个类都包含构造器，调用构造器从类中构造对象，声明构造器名称与类名相同***  
> Java平台可以根据参数列表区分构造器，同一个类不能包含参数`数目`和`类型`都**相同**的两个构造器，否则产生编译错误。  

编译器会为没有构造器的类创建一个无参数的`默认构造器`。`默认构造器`会调用超类的无参数构造器。在这种情形下，如果超类没有`默认构造器`，编译器就会报错，所以必须先验证超类是否包含无参数构造器。  
> 如果一个类没有显式的超类，那么它有一个隐式的Object超类（包含无参数构造器）  

### 消息传递方式  
**形参与实参**  

> `形参`是指方法声明中的变量列表。  
`实参`是方法调用时实际传递的值。  
调用方法时，所使用的`实参`与声明中的`形参`的类型和次序必须相匹配。  
  
可变参数  
可变参数(varargs)构造可用于向方法传递任意数目的值。不清楚传递给方法的某种类型实参的数量时，可以使用可变参数。  
<br>要使用可变参数，要在最后一个参数的类型后添加`省略号`(...)，然后添加空格和参数名。调用方法时，可以携带任意数目的该参数，包括`零个`  
  ```java
public Polygon polygonFrom(Point... corners) {
    int numberOfSides = corners.length;
    double squareOfSide1, lengthOfSide1;
    squareOfSide1 = (corners[1].x - corners[0].x) 
                    * (corners[1].x - corners[0].x)
                    + (corners[1].y - corners[0].y)
                    * (corners[1].y - corners[0].y);
    lengthOfSide1 = Math.sqrt(squareOfSide1);
}  
  ```
通常，可变参数和打印方法可以一起使用。printf的方法实例：  
  ```java
public PrintStream printf(String format, Object... args)
  ```  
其调用形式如下：  
  ```java
System.out.printf("%s: %d, %s%n", name, idnum, address);
  ```  
形参名  
声明方法或构造器的形参时，要给这些形参指定名称。  
在作用域内，形参名必须唯一。它不能与同一方法或构造器内的其他形参名相同，也不能与方法或构造器内的局部变量名相同。  
<br>形参可以与类的一个字段同名。在这种情况下，形参会`覆盖`字段，覆盖字段会降低代码的可读性。通常约定覆盖只用于构造器和设置特定字段的方法内。  
<br>**传递基本数据类型实参**  
基本数据类型（如int, double）的实参通过`传值方式`传入方法。这就意味着，对参数值得任意改变都**只能发生在方法的`作用域`内**。方法返回时，`形参`失效，对形参的改变也将丢失。  
<br>**传递引用数据类型实参**  
引用数据类型（对象等）也可以通过传值方式传入方法。方法返回时，输入的引用仍会引用相同的对象。但是，**其值可以在方法内改变**。  
  ```java
public void moveCircle(Circle circle, int deltaX, int deltaY) {
circle.setX(circle.getX() + deltaX);
circle.setY(circle.getY() + deltaY);

circle = new Circle(0, 0);
  ```  
实参调用方法：moveCircle(myCircle, 23,  56)  
在方法内，方法引用的对象为myCircle，将x和y坐标修改为23和56。方法返回时，x和y的值仍为23和56。然后调用new方法创建新的Circle对象，由于以传值方式传入，所以不对myCircle对象的x和y值修改，在方法返回后myCircle仍然引用调用方法前使用的同一个Circle对象。  
### 对象  
**创建对象**  
> 类为对象提供了一个实现框架，可以从类创建对象  

创建对象的语句由一下三个部分组成：  
(1)声明。  
(2)实例化。new关键字是一个Java运算符，用于创建对象。  
(3)初始化。new运算符后跟一个构造器调用（用于初始化新对象）。  
<br>1.声明引用对象的变量
```  
type name;
```  
类的声明也是类似的，简单声明引用变量没有创建对象。若要创建对象，则需要使用`new`运算符。  
<br>2.实例化类  
`new`运算符实例化类时，会为新对象**分配内存返回该内存的引用**。``new``运算符也会调用对象的构造器。  
> 术语`实例化类`也就是指`创建对象`。创建对象时，会创建类的`实例`，因此也称`实例化类`。  

new运算符需要一个后置的实参以调用构造器。构造器的名称是待初始化的类名。  
<br>3.初始化对象  
**当使用一个已经实例化的对象对另一个对象进行初始化时，两个引用会指向同一个对象**  
<br>可以调用无参构造器，即`默认构造器`。默认构造器会调用父类的无参构造器，如果没有父类，会调用Object构造器。如果父类没有构造器，即使Object有构造器，编译器也会报错。  
<br>**使用对象**  
<br>1.引用对象的字段  
对象的字段通过字段名来访问，且字段名必须是唯一的。对象类外的代码要访问字段，必须使用对象引用或“表达式+点操作符(英文句号.)+字段名”的形式。  
<br>2.调用对象的方法  
通过对象引用可以调用对象的方法，“类名+点操作符+方法名+圆括号（()）”，若括号内有参数则可以包含需要传入的参数。  
<br>3.垃圾收集器  
Java平台支持创建任意多对象，而且不需要摧毁他们。当JRE确定不再使用某些对象时，就会删除它们。这个过程叫做`垃圾收集`。  
### 类的更多细节  
**从方法返回值**  
当方法内的语句执行完时,会到达一个return语句，或抛出异常。  
任何声明为void类型的方法都不会返回值。  
<br>**返回类或接口**  
当方法使用`类名`作为返回类型时，返回的对象类型必须是该类本身**或其子类**。该技术称为`协变返回类型`，也就是说，返回类型可以是任意子类。  
<br>**使用this关键字**
`this`关键字是当前对象的引用。在实例方法或构造器内部，可以使用this访问当前对象的所有成员。  
<br>**联合使用this构造器**  
从构造器内部使用this关键字可以调用同一个类的其他构造器。通常称这种做法为显式构造器调用。  
  ```java
public class Rectangle {
    private int x, y;
    private int width, height;

    public Rectangle() {
        this(0, 0, 1, 1);
    }
    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height =  height;
    }
}
  ```  
该类同时包含一组构造器。每个构造器初始化rectangle对象的一些或所有成员变量。这些构造器为那些没有被实参初始化的成员变量提供默认值。  
**对this()的调用必须在类代码块的第一行**  
<br>控制对类成员的访问  
访问级别修饰符决定其他类是否可以访问特定字段、调用特定方法。访问控制有两个级别：  
·顶级：public或包级私有（无显式修饰符）  
·成员级：public、private、protected或包级私有（无显式修饰符）  
用public修饰符声明类时，该类**对于其他任意类都可见**。  
private修饰符指定成员只能在类内部访问。  
protected修饰符指定成员可以在包内部访问（与包级私有一样），也可以由该类在其他包的子类访问。  

修饰符|类|包|子类|所有环境
---|---|---|---|---
Public|Y|Y|Y|Y
Protected|Y|Y|Y|N
无修饰符|Y|Y|N|N
Private|Y|N|N|N  

> 对各自的成员使用最为严格的访问级别。除非有足够的理由，否则都用private。  
除了常量，尽量避免用public字段。使用public容易导致实现特殊化，并限制代码的灵活性。  


<br> 类成员  
有时需要有些变量对所有对象都公开。这可以由`static`修饰符实现。声明中有static修饰符的字段称为`静态字段`或`类变量`。类的每个实例都共享同一个类变量，该类变量存储在内存的固定位置。任何对象都能改变类变量的值。  
类变量由类名直接饮用，如下所示：  
```
Bicycle.numberOfBicycles
```  
> 静态字段也可以用对象引用，如`myBike.numberOfBicycles`，但并推荐这种饮用方式，因为这不能清除表明这是类变量。  
 
<br>**常量**  
联合使用`static`和`final`修饰符可定义常量。final修饰符表示字段的值不能更改。
  ```java
static final double PI=3.1415926535897932384626
  ```  
**子类不能覆盖`final`方法。**
常量不能重新赋值。常量使用**大写字母**，多个单词用下划线分隔。

<br>初始化字段  
静态初始化块是以`static`关键字开头、写在花括号中的普通代码块。
  ```java
static {
    // code
}
  ```  
<br>嵌套类  
Java语言支持嵌套类，也就是说，在类内定义另一个类，形式如下：  
  ```java
class OuterClass {
    ...
    static class NestedClass {
        ...
    }    
}
  ```  
> 用static修饰符声明的嵌套类称为`静态嵌套类`；非静态嵌套类称为`内部类`。  

<br>**局部类和匿名类**  
内部类还有两种类型：一种叫局部类，它在方法体内声明；另一种叫匿名内部类，它也在方法体内声明，但不对类命名，**即没有类名**。
(1)声明局部类  
局部类可在任意块中定义。可以在方法体内的`for`循环中定义，也可以在`if`语句中定义。  
(2)访问所属类的成员  
局部类可以访问所属类的成员。  
除此之外，局部类也可以访问局部变量，但只能访问声明为`final`的局部变量。局部类访问呢所属块的局部变量或参数时，它会捕捉局部变量或参数。  
(3)局部类与内部类相似  
局部类都是**非静态的**，因为它们要访问所属块的实例成员。因此不能包含静态声明。  
块中不能声明接口，因为接口是**`内在静态`**的。  
<br>匿名类  
(1)声明匿名类  
局部类是类声明，而匿名类是表达式。也就是说，**匿名类是定义在表达式中的**。  
  ```java
public class HelloWorldAnonymousClasses {
    interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
}
s
    HelloWorld englishGreeting = new EnglishGreeting();

    HelloWorld frenchGreeting = new HelloWorld() {
        String name = "tout le monde";
        ...
    };
}
  ```  
上述例子在初始化变量`englishGreeting`用到了局部类，`freanchGreeting`使用了匿名类，即使用表达式初始化一个类。  
(2)匿名类的语法  
匿名类表达式包含如下内容：  
·`new`运算符。  
·实现的接口名或继承的类名。（HellowWorld()）  
·将参数包含入构造器的括号，和通常的类实例创建表达式类似。  
·类声明体。  
(3)声明、访问匿名类的成员  
匿名类可以访问其所属类的成员。  
匿名类中可以声明如下内容：  
·字段  
·补充方法  
·实例初始化内容  
·局部类  
**但是不能在匿名类中声明构造器**  

### Lambda表达式  
Lambda表达式的语法：  
·括号内用逗号分隔的形式化参数列表。  
> Lambda表达式中，可以省略参数的数据类型。另外，如果只有一个参数，则括号也可以省略。例如下述Lambda表达式也是有效的：  
  ```java
p -> p.getGender() == Person.Sex.MALE
    && p.getAge() >= 18
    && p.getAge() <= 25
  ```  
p代表类Person的一个实例。  

·箭头(->)  
·由单个表达式或语句块组成的主体。  
> Lambda表达式看起来像方法声明，可以将Lambda表达式理解为匿名方法——没有名称的方法。  

使用`return`语句：  
  ```java
p -> {
    return p.getGender() == Person.Sex.MALE 
        && p.getAge() >= 18 
        && p.getAge() <= 25;
}
  ```  
return不是表达式，但是在Lambda表达式中，语句必须写在花括号内。    
<br>访问所属范围内的局部变量  
和局部类与匿名类一样，Lambda表达式也能捕获变量；Lambda表达式可以根据词法确定作用范围，这就意味着它们不会继承超类的任意名称，也不会引入新的作用范围。  
<br>方法引用  
Lambda表达式可以**调用现有方法**，使用匿名方法使方法紧凑易读。  
  ```java
Arrays.sort(rosterAsArray, 
    Person a, Person b) -> {
        return a.getBirthday().comPareTo(b.getBirthday());
    }
);
  ```  
或者调用现有方法：  
  ```java
Arrays.sort(rosterAsArray, 
    (a, b) -> Person.compareByAge(a, b)
);
  ```  
**匿名类相当于用`() -> {}`代替了整个匿名类**  
> Lambda只支持函数式接口，即只有一个抽象方法的接口。  
> Lambda 表达式中的参数类型都是由编译器推断得出的。 Lambda 表达式中无需指定类型，程序依然 以编译，这是因为javac根据程序的上下文，在后台推断出了参数的类型。Lambda表达式的类型依赖上下文环境，是由编译器推断出来的。这就是所谓的 “类型推断”。  


使用lambda表达式对列表进行迭代  
  ```java
List testList = Arrays.asList("Lambda", "Interface", "Stream API");
testList.forEach(n -> System.out.println(n));
   ```  
调用List的forEach方法，迭代List中的对象加入Lambda表达式对遍历对象输出。  

