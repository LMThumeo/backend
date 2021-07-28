# IoC & DI

## I. IoC (Inversion of Control)

Inversion of Control: là một design pattern tuân thủ theo nguyên lí Dependency Inversion, trong đó các thành phần nó dựa vào để làm việc bị đảo ngược quyền điều khiển khi so sánh với lập trình truyền thống.

## II. Spring IoC container and beans

- IoC Container sẽ tạo các đối tượng, lắp ráp chúng lại với nhau, cấu hình các đối tượng và quản lí vòng đời của chúng. Bean chính là các thành phần đối tượng này.

- Giao diện **org.springframework.context.ApplicationContext** đại diện cho Spring IoC container. Container đọc hướng dẫn về đối tượng khi nào cần khởi tạo, định cấu hình, lắp ráp bằng cách đọc configuration metadata. Configuration metadata được biểu diễn bằng XML, Java annotation, hoặc Java code.

1. Annotation-based configuration

    a. @Required

    - Dùng trên method setter để chú thích các dependency muốn đưa vào thông qua XML

    ```java
    pulic class Student{
        private Name name;
        void setName( String name){
            this.name = name;
        }
    }
    ```

    ```xml
    <bean id = "student" class = "Student">
        <property name = "name" value = "Thu"/>
    </bean>
    ```

    - Nếu trong XML không có giá tri cho biến đó thì container sẽ ném ra BeanInitializationException.

    b. Autowired

    - Dùng để chú thích một dependency sẽ được tiêm vào từ Spring IoC Container.

    - Có 3 kiểu @Autowired

        - Contructor:

        ```java
        pulic class Student{
            private Task task;

            @Autowired
            public Student(Task task){
                this.task = task;
            }
        }
        ```

        - Setter:

        ```java
        pulic class Student{
            private Task task;

            @Autowired
            public setTask(Task task ){
                this.task = task;
            }
        }
        ```

        - Attribute:

        ```java
        pulic class Student{

            @Autowired
            private Task task;
        }
        ```

    c. Qualifiter

    - @Qualififiter có chức năng tương tự như @AutoWired nhưng được dùng trong khi có nhiều hơn một bean có cùng kiểu dữ liệu trong Spring IoC container.

    ```java

    @Qualifiter("primaryStudent")
    public class PrimaryStudent implements Student {}

    @Qualifiter("secondaryStudent")
    public class SecondaryStudent implements Student {}
    ```

    ```java
    public class Fee {
        @Autowired
        @Qualifider("primaryStudent")
        Student student;
    }
    ```

    >Nếu có nhiều hơn 1 bean cùng loại trong vùng chứa, ngoại lệ NoUniqueBeanDefinitionException sẽ dược ném ra

2. Java-based configuration

## II. DI (Dependency injection)

### 1. DI là gì (What)

- Dependency: sự phụ thuộc. Theo cách truyền thống, nếu 1 class A muốn sử dụng một số chức năng của class B thì nó sẽ tạo một đối tượng của class B ngay trong class A để sử dụng. Như vậy class A bị phụ thuộc vào class B.

```java
pulic class Student{
    private Task task;
    public Student(){
        task = new Task();
    }
}
```

- DI: tiêm sự phụ thuộc.

  - DI là một kĩ thuật trong đó một đối tượng (hoặc một phương thức tĩnh) cung cấp các phụ thuộc của đối tượng khác. Một phu thuộc là một đối tượng có thể được sử dung.

  - Cũng có thể hiểu DI là chuyển giao nhiệm vụ tạo đối tượng cho người khác và trực tiếp sử dụng phụ thuộc

### 2. Tại sao nên sử dụng DI (Why)

```java
pulic class Student{
    private Task task;
    public Student(){
        task = new doHomeworkTask();
    }
}
```

- Giả sử đang có một class như trên:

  Nếu bạn muốn đổi sang 1 task khác(cleanRoomTask) thì sao? Bạn sẽ phải tạo mới 1 đối tượng Student với một phụ thuộc mới? Và nếu còn nhiều task khác thì có thể sử dụng các này không?

  Khi sử dụng DI, bạn có thể thay đổi task khi tạo đối tượng thay vì phải tạo thêm những đối tượng mới vì task (dependency) có thể được truyền vào (inject). Điều này giúp cho Student không phải phụ thuộc vào Task.

- Nếu bạn tạo trực tiếp đối tượng của class Task bên trong class Student thì khi một object của Student được khởi tạo thì object của Task mới được khởi tạo. vậy bạn có thể suy ra rằng, nếu object của Student có vấn đề thì object đó của Task cũng **không thể sử dụng**.
Ngược lại, nếu sử dụng DI, thì object của Student độc lập với object của Task. Vậy thì khi object Student gặp lỗi, nó cũng không ảnh hưởng tới object Task. Ngoài ra, object Task còn **có thể tái sử dụng** ở các phần khác.

### 3. Khi nào nên dùng DI (When)

- **Khi đưa một một dependency vào nhiều thành phần**.
VD: Khi bạn cần đưa nhiệm vụ dọn phòng (cleanRoomTask) vào cả học sinh (Student) và lao công(Labor).

- **Khi đưa các triển khai khác nhau vào một thành phần**.
VD: Student có các nhiệm vụ như làm bài tập (doHomeworkTask), dọn phòng (cleanRoomTask), các nhiệm vụ này đều đc implement từ interface Task. Khi đó, nên dùng DI để tiêm các nhiệm vụ này.

### 4. Dùng DI như thế nào (How)

Có 2 cách chính để sử dụng DI:

#### a. Contructor

```java
pulic class Student{
    private Task task;
    public Student(Task task){
        this.task = task;
    }
}
```

>Sử dụng khi dependency đó là bắt buộc khi khởi tạo.
>
>Có thể inject nhiều dependency cùng lúc

#### b. Setter

```java
pulic class Student{
    private Task task;
    public void setStudent(Task task){
        this.task = task;
    }
    public Task getTask(){
        return task;
    }
}
```

>Sử dụng khi dependency đó là **không** bắt buộc khi khởi tạo.
>
>Mỗi setter chỉ inject một dependency.

### 5. Dùng DI ở đâu (Where)

Với tính độc lập của mình DI rất được khuyên dùng đối hầu hết các chương trình, tuy nhiên DI cũng gây rắc rối bởi sự phức tạp của nó. Do đó, với các chương trình nhỏ và thực hiện các chức năng đơn giản thì DI không quá cần thiết.

### 6. Ai nên sử dụng DI (Who)

Bất kì lập trình viên nào cũng nên biết tới và sử dụng DI, đặc biệ là khi làm việc về backend hoặc code OOP.
