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

  *加强型(for-each)：*  
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
`类名`:首字母大写，其余字母小写的驼峰命名式  
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
类中默认为default类型  

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

修饰符 | 类 | 包 | 子类 | 所有环境
---|---|---|---|---
Public | Y | Y | Y | Y
Protected | Y | Y | Y | N
无修饰符 | Y | Y | N | N
Private | Y | N | N | N  

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
方法引用的种类  
方法引用有4种。  

种类 | 实例  
--- | ---  
静态方法引用 | ContainingClass::staticMethodName  
特定引用的实例化方法引用 | containingObject::instanceMethodName  
特定类型任意对象的实例化方法引用 | ContainingType::methodName  
构造器引用 | ClassName::new  

<br>**Lambda表达式相当于用`() -> {}`代替了整个匿名类**  
> Lambda只支持函数式接口，即只有一个抽象方法的接口。  
> Lambda 表达式中的参数类型都是由编译器推断得出的。 Lambda 表达式中无需指定类型，程序依然 以编译，这是因为javac根据程序的上下文，在后台推断出了参数的类型。Lambda表达式的类型依赖上下文环境，是由编译器推断出来的。这就是所谓的 “类型推断”。  


使用lambda表达式对列表进行迭代  
  ```java
List testList = Arrays.asList("Lambda", "Interface", "Stream API");
testList.forEach(n -> System.out.println(n));
   ```  
调用List的forEach方法，迭代List中的对象加入Lambda表达式对遍历对象输出。  

<br>**何时使用嵌套类、局部类、匿名类和Lambda表达式**  
·局部类。创造一个类的多个实例、访问其构造器或引入新的类型。  
·匿名类。声明字段或其他方法时使用匿名类。  
·Lambda表达式。  
```
封装要传送给其他代码的单元行为。
需要功能接口的简单实例或不需要构造器、命名类型、字段或其他方法。
```  

·嵌套类。如果需求和局部类相似，想让类型更可靠，不需要访问局部变量方法参数，则使用嵌套类。如果要访问所属实例的非共有字段和方法，则可以使用非静态嵌套类（或内部类）；反之，使用静态嵌套类。  

### 枚举类型  
`枚举类型`是允许变量为一组预定义常量的特殊的数据类型。Java使用`enum`关键字定义枚举类型。例如星期的枚举类型定义如下：  
  ```java
public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, 
    THURSDAY, FRIDAY, SATURDAY
}  
  ```  
Java的enum定义了一个`类`，枚举类型的类体可以包含方法和其他字段。例如有一个静态值方法(values())，它返回一个数组，该数组由枚举的所有值按声明顺序组成。该方法通常与`for-each`构造一起使用以迭代枚举类型的所有值。  
> 所有枚举类型都隐式继承java.lang.Enum。因为一个类只能继承一个父类，Java不支持状态的多重继承，所以枚举类型不能继承其他任何类。  

  ```java
for （Planet p : Planet.values()) {
    System.out.printf("Your weight on %s is %f%n", 
                      p, p.surfaceWeight(mass));
}
  ```  

对于一个Planet类，同时声明其质量和半径。创建这些常量时，会将这些值传给构造器。Java要求在声明字段或方法之前，首先定义这些常量。有字段和方法时，枚举常量也要以`分号`结束。  
  ```java
public enum Planet {
    EARTH(5.976e+24, 6.37814e6);
    private final double mass;
    private final double radius;
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
}
    ...
  ```  
## 第5章 注解  
> `注解`(annotation)，是一种元数据形式，它提供程序数据，但不是程序本身的组成部分。注解不会直接影响它们所注解的代码行为。注解有很多用处，包括：  
·为编译器提供信息。编译器可以使用注解检测错误或抑制警告。  
·编译时和部署时处理。软件工具可根据注解生成代码、XML文件等。  
·运行时处理。有些注解可在运行时检查。  

### 注解基础知识  
**注解的格式**  
`@`字符之后为注解内容。  
如下为最简单的注解格式：  
```
@Entity
```  

如果注解没有元素，则可以省略括号。  
注解可以包含待值的元素（可以命名、也可以不命名）：  
  ```java
@Author(
    name = "Benjamin Franklin", 
    date = "3/27/2014"
)
class MyClass() {...}
  ```  
如果只有一个元素，而且元素名为value，则可省略元素名，如下：
  ```java
@SuppressWarnings("unchecked")
void myMethod() {...}
  ```  
如果类型相同，则称为`重复注解`。  
  ```java
@Author(name = "Jane Doe")
@Author(name = "John Smith")
void myMethod() {...}
  ``` 
Java SE 8支持重复注解。  
注解类型可以使Java SE API的java.lang和java.lang.annotation包中定义的类型。也可以自定义类型(Author)。  
<br>注解的使用场景  
注解可用于类、字段、方法以及其他程序组成部分的声明。在声明中使用注解时，每个注解都会独立成行。  
Java SE 8也支持将注解用于类型的使用。  
·类实例创建表达式：  
  ```java
new @Interned MyObject();
  ```
·类型捕获：  
  ```java
myString = (@NonNull String) str;
  ```  
·implements子句：  
  ```java
class UnmodifiableList<T> implements
    @Readonly List<@Readonly T> {...}
  ```  
·抛出异常声明：  
  ```java
void monitorTemperature() throws
    @Critical TemperatueException {...}
   ```  
这种注解形式称为`类型注解`。  
<br>**声明注解类型**  
许多注解可以替代代码的注释。软件开发小组在编写类体时，习惯以重要信息的注释开始，先定义`注释类型`：  
  ```java
@interface ClassPreamble {
    String author();
    String date();
    int currentRevision() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
    /**Note use of array/
    String[] reviewers();
}
  ```  
注解类型的定义有点像接口的定义。在注解类型中，关键字`interface`写在@字符之后(@ = "AT")。注解类型其实是`接口`的一种形式。  
上述注解定义中包含`注解类型元素`声明，有点像方法。这些可用于定义可选的默认值。  
定义注解类型后，就可以使用该类型进行注解，填入相应的值。  
  ```java
@ClassPreamble (
    author = "John Doe", 
    date = "3/17/2002/", 
    currentRevision = 6, 
    lastModified = "4/12/2004", 
    lastModifiedBy = "Jane Doe", 
    reviewers = {"Alice", "Bob", "Cindy"}
)
public class Generation3List extends Generation2List {
    ...
}
  ```  
> 要在`Javadoc`生成的文档中显示@ClassPreamble的信息，必须将@ClassPreamble定义本身用@Documented注解：  

**预定义注解类型**  
Java语言使用的注解类型  
java.lang中预定义的注解类型包含@deprecated, @Override, @SuppressWarnings, @SafeVarargs, @FunctionalInterface。  
<br>1.@Deprecated  
`@Deprecated`注释表示被标记的元素已被弃用。程序使用带@Deprecated注解的方法、类或字段时，编译器会发出警告。元素被弃用时，应该使用Javadoc的@deprecated标记，Javadoc标记以小写d开头，注释以大写D开头。  
  ```java
/**
 *  @deprecated
 */ 
    @Deprecated
    static void deprecatedMethod() { }
}
  ```
<br>2.@Override  
`@Override`注释通知编译器该元素覆盖了超类中声明的元素。  
<br>3.@SuppressWarning  
`@SuppressWarning`注释通知编译器忽略指定类型的警告。每个编译器警告都属于一个警告类。Java语言规范列出两种警告类：deprecation和unchecked。和泛型之前的遗留代码对接时会报unchecked警告。要忽略多类警告使用下述语法：  
  ```java
@SuppressWarnings({"unchecked", "deprecation"})
  ```  
<br>4.@SafeVarargs  
应用于方法或构造器时，`@SafeVarargs`注解声明代码不能执行可变参数上潜在不安全的操作。使用该注解类型时，会忽略与可变参数相关的unchecked警告。  
<br>5.@FunctionalInterface  
Java SE 8引入`@FunctionalInterface`注解。该注解表示声明时Java语言规范定义的功能接口。  
<br>**应用于其他注解的注解**  
应用于其他注解的注解通常称为`元注解`。java.lang.annotation中定义了几个元注解类型：  
<br>1.@Retation  
`@Retation`注解指定被标记注解的存储方式：  

```
·RetentionPolicy.SOURCE——被标记的注解只保留到源码级，会被编译器忽略。  
·RetentionPolicy.CLASS——被标记的注解在编译时会被编译器识别，但会被Java虚拟机忽略。  
·RetentionPolicy.RUNTIME——被标记的注解会被Java虚拟机识别，因此可用于运行时环境。
```   
<br>2.@Documented  
`@Documented`注解表示只要它指定的注解的元素都应该用Javadoc工具文档化。  
<br>3.@Target  
`@Target`注解限制了其注解的注解可用于哪些Java元素。  
<br>4.@Inherited  
`@Inherited`注解表示注解类型可从超类继承。该注解只用于类声明。  
<br>5.@Repeatable  
Java SE 8引入`@Repeatable`注解。注解的注解可多次用于同一个声明或类型使用。  
<br>**重复注解**  
声明重复注解类型  
注解类型必须用`@Repeatable`元注解标记。大括号内为@Repeatable元注解的值，是Java编译器创建用于保存重复注解的容器注解类型。  

## 第6章 接口与继承  
Java程序语言中，`接口`与类类似，是一个引用类型，它只包含常量（如枚举类型）、方法签名、默认方法、静态方法和嵌套类型。其中，只有默认方法和静态方法有方法体。接口不能实例化，只能通过类来实现，或被其他接口继承。  
接口的定义方式类似于创建类：  
  ```java
public interface OperateCar {
    int turn(Direction direction, 
                double radius, 
                double startSpeed, 
                double endSpeed);
    ...
}
  ```  
注意，上述方法没有花括号，直接以分号结束。  
<br>**定义接口**  
接口声明包括修饰符、`interface`关键字、接口名、以逗号分隔的父接口（如果有），以及接口体。  
`public`修饰符表示任意包内的任意类都可使用该接口。如果接口不声明为public，就只有与接口同一个包的类可以访问该接口。  
接口可以继承其他接口，就像类可以继承其他类一样。但是，类只能继承一个类，而接口可以继承任意多个接口。接口声明包含了它所继承的接口列表(以逗号分隔)。  
<br>**接口体**  
接口体包含抽象方法、默认方法和静态方法。接口内的抽象方法以分号结束，没有括号（因为抽象方法不包含实现）。默认方法用默认的修饰符定义，静态方法用关键字`static`修饰。在接口中，抽象方法、默认方法和静态方法隐式用public修饰，因此也可以省略public修饰符。  
接口内定义的所有常量值都隐式声明为public、static和final。当然也可以省略。  
<br>**实现接口**  
要声明类实现一个接口，就要在类声明中加入`implements`子句。类可以实现多个接口，所以`implements`后可跟类所实现的接口列表，且接口之间用逗号分隔。按约定，如果有extends子句，要先写extends子句，再写implements子句。实现接口的类必须实现接口内声明的所有方法。  
> 类型转换会告知编译器该对象的实际类型。将接口实例化为一个类型。  

  ```java
public Object findLargest(Object object1, Object object2) {
    Relatable obj1 = (Relatable) object1;
    Relatable obj2 = (Relatable) object2;
    if ((obj1).isLargerThan(obj2) > 0)
        return object1;
    else
        return object2;
}
  ```  
<br>**进化接口**  
可以使用`extends`继承旧的接口。  
  ```java
public interface DoItPlus extends DoIt {
    ...
}
  ```  
也可以将新方法定义为默认方法。  
  ```java
public interface DoIt {
    void doSomething(int i, double x);
    int doSomethingElse(String s);
    default boolean didItWork(int i, double x, String s) {
        ...
    }
}
  ```  
**必须考虑默认方法的实现**，也可以定义现有接口的新的静态方法。  
<br>**默认方法**  
在接口中，方法签名起始位置使用关键字`default`指定的方法定义是默认方法。  
<br>继承含默认方法的接口  
继承含默认方法的接口，有三种方式供选择：  
·不要提及默认方法，这样会继承接口的默认方法。  
·重新声明默认方法，将其类型声明为abstract。  
·重新定义默认方法，覆盖原有方法。  
<br>静态方法  
方法签名起始位置使用关键字static指定的方法定义是静态方法。  
**静态方法可以直接通过类名调用，即类名+点标识符(.英文句号)访问**  
<br>将默认方法集成到现有库  
默认方法可在接口中添加新功能。尤其是，默认方法可用于添加那些接受Lambda表达式作为参数传给现有接口的方法。  
### 继承  
Object类在Java.lang包内定义，它定义和实现所有类的通用行为。在Java平台中，许多类直接由Object派生而得，其他类又由这些类派生而得，等等。Object是所有类中最一般的类。越靠近底端的类的行为越特殊。  
<br>不管子类在哪个包，它都会继承超类的**所有public和protected成员**。如果子类和超类在同一个包，它也会继承超类的`包级私有`成员。  
·声明与超类相同的字段名。这样会`覆盖`超类的相应字段(不推荐)。  
·声明与超类中方法签名相同的新的实例方法。这样会`覆盖`超类的相应方法。  
·声明与超类中方法签名相同的新的静态方法。这样会`屏蔽`超类的相应方法。  
·编写子类构造器，隐式或使用super关键字调用超类的构造器。  
<br>超类的私有成员  
***子类不会继承的私有成员***。但是，如果超类声明了public或protected方法访问这些私有字段，子类也可以使用这些方法访问这些字段。  
嵌套类可以访问其封闭类的所有私有成员，包括字段和方法。子类继承下来的public或protected嵌套类不能直接访问超类的所有私有成员。  
> **(与c++的区别)**c++中，子类会继承父类的私有成员。但是相同地，子类都不能使用或者访问父类的私有数据。子类继承时，都会调用父类构造器产生一个副本。需要访问私有数据仍然需要调用父类的公有方法对私有数据进行访问。  

<br>转换对象  
假定MountainBike由Bicycle和Object衍生而来。因此，MountainBike既是Bicycle类又是Object类型，可以当做Bicycle对象或Object对象来调用。反之不然。编译器并不知道obj对象是MountainBike对象，需要`显式转换`来实现：  
  ```java  
MountainBike myBike = (MountainBike) obj;
  ```

> 可以使用instanceof运算符避免类型转换出现的错误：  
  if (obj instanceof MountainBike) {
    MountainBike myBike = (MountainBike) obj;
}

<br>状态、实现和类型的多重继承  
实现的`多重继承`是继承多个类的方法定义的能力。这类多重继承会引发命名冲突和二义性等问题。  
Java程序语言支持类型的多重继承，这是类实现多个接口的能力。一个对象可以有多重类型：它本身的类型和它所实现的所有接口的类型。  
<br>覆盖和屏蔽方法  
如果子类的方法签名（方法名+参数数量和类型）和返回类型都与超类的实例方法相同，就会`覆盖`超类的方法。覆盖方法也可以返回被覆盖方法所返回类型的子类型。这种技术叫做`协变返回类型`。  
<br>静态方法  
如果子类定义一个静态方法，其方法签名和超类的静态方法相同，那么子类会`屏蔽`超类的方法。屏蔽静态方法和覆盖实例方法两者有很大的区别：  
·覆盖实例方法时调用的是子类中的方法。  
·屏蔽静态方法时调用哪个方法取决于该方法调用自哪个类：超类和子类  
<br>接口方法  
接口中的默认方法和抽象方法也可以像实例方法一样被继承。类或接口的超类行提供了方法签名相同的多个默认方法时，Java编译器会根据继承规则来解决命名冲突。这些规则由以下两条原则派生而得：  
(1)实例方法优先于接口默认方法。  
(2)忽略已经被覆盖的方法。  
关键字super可以用于在类和接口中调用默认的方法。  
> 接口中的静态方法不能被继承。
> **(与c++的区别)**c++中，一个类的static函数为该类共享，但不属于任何一个对象。Java中的static方法有屏蔽效应，接口中的static方法不能被继承。  


<br>修饰符  
覆盖方法的访问修饰符权限可以高于（但不能低于）被覆盖方法。超类中protected实例方法可以在子类声明为public，但不能为private。

<br>子类和超类方法签名相同时的情形  

类型 | 超类的实例方法 | 超类的静态方法  
--- | --- | --- 
子类的实例方法 | 覆盖 | 生成编译时错误  
子类的静态方法 | 生编译时错误 | 屏蔽  

<br>使用super关键字  
·访问超类的成员  
如果一个方法覆盖了父类的方法，就要用super关键字调用被覆盖的方法。  
<br>子类构造器  
使用super()方法调用超类构造器。**超类构造器的调用必须写在子类构造器的第一行**
<br>Object用作超类  
1.clone()方法  
如果类或它的一个超类实现了Cloneable接口，就可以使用clone()方法创造现有对象的副本。  
2.equals()方法  
equals()方法比较两个对象是否相等，如果相等返回true。Object测试对象引用是否相等。  
3.finalize()方法  
当对象成为垃圾时，可能调用该方法。  
4.getClass()方法  
getClass()方法不能被覆盖。getClass()方返回Class对象，如类名、继承的超类和实现的接口。  
5.hashCode()返回对象的哈希码  
如果两个对象相等，那它们的哈希码也必须相等。  
6.toString()方法
返回对象的字符串。  
<br>final类方法。
声明`final`关键字表示该方法不能被子类覆盖。  
构造器调用的方法都应该声明为final。  
也可以把类声明为final，final类不能被继承。（如String类）  
<br>抽象方法和类  
`抽象类`使用`abstract`声明，它可能包含抽象方法。**抽象类不能被实例化**，但可以被继承。   
`抽象方法`是声明时没有实现的方法（没有方法体）。如果类中包含抽象方法，则类本身必须声明为abstract。  
当抽象类被继承时，子类往往要实现父类的所有抽象方法。不过不实现所有抽象方法，子类也必须声明为abstract。  
>  接口所有方法都是`隐式`抽象的。  

## 第7章 泛型  
> 简而言之，在定义类、接口和方法时，泛型(Generics)能将`类型`(类和接口)作为参数使用。类似于我们更熟悉的在方法声明中使用的一般化参数，类型形式参数提供了对不通过输入重复使用同一段代码的一个途径。区别在于，一般形式化参数的输入是值，而类型形式参数的输入是类型。  

<br>**泛型类型**  
`泛型类型`是泛型类或者接口，能够参数化类型。  
一个`泛型类`的定义格式如下：  
  ```java
class Name<T1, T2, ..., Tn> {
    /* ... */
}
  ```  
类后面用"<>"标示出来的是类型形式参数部分，指明`类型形式参数`(也称为类型变量)是T1, T2, ..., Tn。  
一个Box类的定义如下形式：  
  ```java
public class Box<T> {
    private T t;

    public void set(T t) {
    this.t = t;
}

    public T get() {
    return t;
}
  ```  
一个类型变量可以是用户指定的任何`非基本数据类型`,如类、接口、数组，甚至可以使其他类型变量。  
<br>类型参数命名约定  
约定：类型形式参数的名字用单个、大写字母表示。如下列出的是常用的类型形式参数名：  
·E——元素(Element, 广泛应用于Java collections集合框架)  
·K——键值(Key)  
·N——数字(Number)  
·T——类型(Type)  
·V——值(value)  
·S, U, V等——第二、第三、第四类型  
<br>泛型类型的调用和实例化  
要在代码中引用Box类，必须执行`泛型类型调用`(generic type invocation)，即用某个具体的值（如整数）代替T：  
  ```java
Box<Integer> integerBox;
  ```  
泛型类型调用类似于一般方法调用，只是在传递参数方面不同于一般方法，泛型调用中是把`类型实际参数`（这里是整数型Integer）传递给Box类型自身。  
> 许多开发者会混用`类型形式参数`(type parameter)和`类型实际参数`(type argument)，但这两个术语是不同的。编码时，我们会使用类型实际参数(type argument)来创建一个参数化了的类型(parameterized typed)。所以，Foo<T>中的T是一个类型形式参数，而Foo<String>则是类型实际参数。  

这段代码其实不会创建一个新的Box对象，而只是简单地声明integerBox保有指向"Box<Integer>（整数型的Box）"的引用。  
泛型类型的调用即通常所说的参数化类型。实例化时，也是使用关键字`new`，只是在类名和圆括号之间要放上<Integer>:  
  ```java
Box<Integer> integerBox = new Box<Integer>();
  ```  

<br>钻石运算符  
调用泛型类的构造函数时，只要编译器能通过上下文确定或推断出类型实际参数，就可以用类型实际参数的空集("<>")代替类型实际参数，其中：尖括号称为钻石运算符。例如：
  ```java
Box<Integer> integerBox = new Box<>();
  ```  
<br>多个类型参数  
泛型类可以有多个参数。如下泛型类OrderedPair实现了泛型接口Pair:  
  ```java
public interface Pair<K, V> {
    public K getKey();
    public V getValue();
}

public class OrderedPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;
}

public OrderedPair(K key, V value) {
    this.key = key;
    this.value = value;
}

public K getKey() {
    return key;
}
public V getValue() {
    return value;
}
  ```  
以下语句创建了两个OrderedPair类实例：  
  ```java
Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
Pair<String, String> p2 =new OrderedPair<String, String>("hello", "world");
  ```  
new OrderedPair<String, Integer>把K和V分别实例化为String和Integer。  
使用钻石符号可以缩减为：  
  ```java
Pair<String, Integer> p1 = new OrderedPair<>("Even", 8);
Pair<String, String> p2 =new OrderedPair<>("hello", "world");
  ```  
创建泛型接口和创建泛型类方法相同。  
<br>参数化类型  
也可以用参数化类型(如List<String>)代替类型形式参数(如K、V)。  
  ```java
OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", 
    new Box<Integer> (...));
  ```  
<br>**原生类型**  
`原生类型`是不带有任何类型参数的泛型类或接口的名字。例如，前面介绍的泛型类Box，创建Box<T>的参数化类型，需要给类型形式参数T赋一个类型实际参数：  
  ```java
Box<Integer> intBox = new Box<>();
  ```  
若忽略类型实际参数，可以创建Box<T>的原生类型：  
Box rawBox = new Box();
<br>如果把一个原生类型赋值给参数化类型，会显示警告。如果用原生类型去调用相应泛型类型的泛型方法，也会显示警告。  
<br>**泛型方法**  
泛型方法的语法中，类型形式参数出现在尖括号内，位于该方法返回类型前。对于泛型方法，类型形式参数部分一定位于该**方法返回类型前面**。  
Util类有一个泛型方法compare，用于比较两个序对(Pair)对象。  
  ```java
public class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.geKey()) && 
               p1.getValue().equals(p2.getValue());
    }
}
  ```  
<br>受限类型形式参数  
在参数华类型中，我们有时需要约束可以作为`类型实际参数`使用的类型。例如可能只希望接收数字类型，这就是`受限类型形式参数`所要发挥的作用。  
声明一个受限类型形式参数，要列出类型形式参数名，然后是关键字`extends`，接下来是该参数的`上界`(如Number)。  
  ```java
public class <Box T> {
    private T t;
    public void set(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }
    /* 限定Number类型的上界 */
    public <U extends Number> void inspect(U u) {
         System.out.println("T: " + t.getClass().getName());
         System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(new Integer(10));
        integerBox.inspect("some text); // error: String
    }
}
  ```  
<br>多重限制  
一个类型形式参数可以有`多重限制`。
  ```java
<T extends B1 & B2 & B3>
  ```  
**如果类是限制之一，则必须先指定**  
  ```java
class A {
    ...
}

class D <T extends A & B & C> { 
    ...
}

class D <T extends B & A & C> { // compile error
    ...
}
  ```  

<br>无界通配符  
无界通配符类型用通配符符号(?)给出，例如List<?>，即所谓的"未知类型列表"。无界通配符适用于以下两种情况：  
·当一个方法可以用Object类提供的功能来实现时，无界通配符是适用的。
·若代码使用了泛型类中的方法，而这些方法又是不依赖于类型形式参数的，那么无界通配符也是有用的。  
<br>下界通配符  
`下界通配符`将未知类型限制为某个指定类型或者该类型的子类型，并用关键字`extends`表示。下界通配符将未知类型限制为某个指定类型或该类型的超类型。下界通配符用"通配符符号(?) + 关键字super + 下界"表示：<? super A>。  
> 可以为通配符指定上界或下界，但不能两者都指定  

<br>泛型的局限性  
1.不能用基本数据类型实例化泛型类型  
创建Pair对象时，不能用基本数据类型代替类型形式参数K或V：  
  ```java
Pair<int, char> p =new Pair<>(8, 'a'); // compile error
  ```  
只能用非基本数据类型代替类型形式参数K或V：   
  ```java
Pair<Intger, Character> p =new Pair<>(8, 'a'); // compile error
  ```  
<br>2.不能创建类型参数实例  
  ```java
public static <E> void append(List<E> list) {
    E elem = new E();//compile error
    list.add(elem);
}
  ```  
一个变通方案是，通过反射创建类型参数的对象：  
  ```java
public static <E> void append(List<E> list, Class<E> cls) 
throws Exception {
    E elem = cls.newInstance();
    list.add(elem);
}
  ```  
<br>3.不能声明类型为"类型参数"的静态字段  
<br>4.对参数化类型不能用类型转换或instanceof运算符  
由于Java编译器擦除了泛型代码中所有类型参数，所以运行无法验证正在使用泛型类型的是哪个参数化类型。  
<br>5.不能创建参数化类型数组  
由于泛型方法擦除，数组元素的多样化的可能性，可能存在ArrayStoreException的RTE  
<br>6.不能创建、捕获或抛出参数化类型的对象  
<br>7.每次重载时其形式参数类型都被擦除为相同的原生类型的方法不能重载  
一个类不能有两个被重载的方法，它们在类型擦除后会有相同的声明：  
  ```java
public class Example {
    public void print(Set<String> strSet) {
    ...
    }
    public void print(Set<Integer> intSet) {
    ...
    }
}
  ```  
重载将全部共享相同的类文件表示并生成编译时的错误。  
