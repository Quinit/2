import java.util.*;
import java.io.*;
import java.time.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * 这个类展示了Java的各种语法和特性
 */
public class JavaSyntaxDemo {
    // 静态常量
    public static final double PI = 3.1415926;
    
    // 实例变量
    private String name;
    private int age;
    private List<String> hobbies;
    
    // 静态变量
    private static int instanceCount = 0;
    
    // 枚举
    public enum Gender {
        MALE, FEMALE, OTHER
    }
    
    // 构造方法
    public JavaSyntaxDemo(String name, int age) {
        this.name = name;
        this.age = age;
        this.hobbies = new ArrayList<>();
        instanceCount++;
    }
    
    // 方法重载
    public JavaSyntaxDemo() {
        this("Anonymous", 0);
    }
    
    // Getter和Setter
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public List<String> getHobbies() {
        return Collections.unmodifiableList(hobbies);
    }
    
    // 实例方法
    public void addHobby(String hobby) {
        hobbies.add(hobby);
    }
    
    // 静态方法
    public static int getInstanceCount() {
        return instanceCount;
    }
    
    // 可变参数方法
    public void addMultipleHobbies(String... newHobbies) {
        Collections.addAll(hobbies, newHobbies);
    }
    
    // 接口
    public interface Greeting {
        void greet();
    }
    
    // 内部类
    public class HobbyPrinter {
        public void printHobbies() {
            System.out.println(name + "'s hobbies:");
            for (String hobby : hobbies) {
                System.out.println("- " + hobby);
            }
        }
    }
    
    // 静态内部类
    public static class Counter {
        public void printCount() {
            System.out.println("Instance count: " + instanceCount);
        }
    }
    
    // 匿名类示例
    public Greeting createAnonymousGreeting() {
        return new Greeting() {
            @Override
            public void greet() {
                System.out.println("Hello from anonymous class!");
            }
        };
    }
    
    // Lambda表达式
    public void processHobbies(Consumer<String> hobbyProcessor) {
        hobbies.forEach(hobbyProcessor);
    }
    
    // 方法引用
    public void printHobbiesToConsole() {
        hobbies.forEach(System.out::println);
    }
    
    // Stream API
    public List<String> getLongHobbies() {
        return hobbies.stream()
                     .filter(h -> h.length() > 5)
                     .sorted()
                     .collect(Collectors.toList());
    }
    
    // 泛型方法
    public <T> T getFirstElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    // 异常处理
    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Name: " + name);
            writer.newLine();
            writer.write("Age: " + age);
            writer.newLine();
            writer.write("Hobbies: " + String.join(", ", hobbies));
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            throw e;
        }
    }
    
    // switch表达式 (Java 14+)
    public String getAgeGroup() {
        return switch (age) {
            case 0 -> "Newborn";
            case 1, 2 -> "Toddler";
            case 3, 4, 5 -> "Preschooler";
            case 6, 7, 8, 9, 10, 11, 12 -> "Child";
            case 13, 14, 15, 16, 17, 18 -> "Teenager";
            default -> age < 0 ? "Invalid age" : "Adult";
        };
    }
    
    // record类型 (Java 16+)
    public record Point(int x, int y) {
        public double distanceFromOrigin() {
            return Math.sqrt(x * x + y * y);
        }
    }
    
    // 文本块 (Java 15+)
    public String getJsonRepresentation() {
        return """
               {
                   "name": "%s",
                   "age": %d,
                   "hobbies": %s
               }
               """.formatted(name, age, hobbies);
    }
    
    // 模式匹配instanceof (Java 16+)
    public void processObject(Object obj) {
        if (obj instanceof String s) {
            System.out.println("String length: " + s.length());
        } else if (obj instanceof Integer i) {
            System.out.println("Integer value: " + i);
        } else {
            System.out.println("Unknown object type");
        }
    }
    
    // sealed接口 (Java 17+)
    public sealed interface Shape permits Circle, Rectangle {
        double area();
    }
    
    public static final class Circle implements Shape {
        private final double radius;
        
        public Circle(double radius) {
            this.radius = radius;
        }
        
        @Override
        public double area() {
            return PI * radius * radius;
        }
    }
    
    public static final class Rectangle implements Shape {
        private final double width, height;
        
        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }
        
        @Override
        public double area() {
            return width * height;
        }
    }
    
    // 主方法
    public static void main(String[] args) {
        // 创建对象
        JavaSyntaxDemo demo = new JavaSyntaxDemo("Alice", 25);
        demo.addHobby("Reading");
        demo.addHobby("Swimming");
        demo.addMultipleHobbies("Hiking", "Photography");
        
        // 使用内部类
        HobbyPrinter hobbyPrinter = demo.new HobbyPrinter();
        hobbyPrinter.printHobbies();
        
        // 使用静态内部类
        Counter counter = new Counter();
        counter.printCount();
        
        // 使用匿名类
        Greeting greeting = demo.createAnonymousGreeting();
        greeting.greet();
        
        // 使用Lambda表达式
        demo.processHobbies(hobby -> System.out.println("Processing hobby: " + hobby));
        
        // 使用Stream API
        List<String> longHobbies = demo.getLongHobbies();
        System.out.println("Long hobbies: " + longHobbies);
        
        // 使用record
        Point point = new Point(3, 4);
        System.out.println("Point distance: " + point.distanceFromOrigin());
        
        // 使用文本块
        System.out.println(demo.getJsonRepresentation());
        
        // 使用模式匹配instanceof
        demo.processObject("Hello");
        demo.processObject(42);
        
        // 使用sealed接口
        Shape circle = new Circle(5.0);
        System.out.println("Circle area: " + circle.area());
        
        // 多线程
        Runnable runnable = () -> {
            System.out.println("Running in thread: " + Thread.currentThread().getName());
        };
        new Thread(runnable).start();
        
        // 日期时间API
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current time: " + now);
        
        // 异常处理
        try {
            demo.saveToFile("demo.txt");
        } catch (IOException e) {
            System.err.println("Failed to save: " + e.getMessage());
        }
        
        // 泛型集合
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println("First number: " + demo.getFirstElement(numbers));
        
        // 数组
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Array length: " + array.length);
        
        // 增强for循环
        for (int num : array) {
            System.out.println("Number: " + num);
        }
        
        // 传统for循环
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element at " + i + ": " + array[i]);
        }
        
        // while循环
        int i = 0;
        while (i < array.length) {
            System.out.println("While loop: " + array[i]);
            i++;
        }
        
        // do-while循环
        i = 0;
        do {
            System.out.println("Do-while loop: " + array[i]);
            i++;
        } while (i < array.length);
        
        // 三元运算符
        String status = demo.age >= 18 ? "Adult" : "Minor";
        System.out.println("Status: " + status);
        
        // switch语句
        System.out.println("Age group: " + demo.getAgeGroup());
    }
}