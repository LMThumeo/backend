# IoC & DI

## I. IoC (Inversion of Control)

Inversion of Control: là một design pattern tuân thủ theo nguyên lí Dependency Inversion, trong đó các thành phần nó dựa vào để làm việc bị đảo ngược quyền điều khiển khi so sánh với lập trình truyền thống.

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
