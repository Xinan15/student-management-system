# Java Web SSM

## Java Web `SSM`: `Spring` + `SpringMVC` + `MyBatis`

## Layers - 分层结构概念

1. **Controller 层**（或 Web 层）
   - **职责**：负责处理客户端的 HTTP 请求，将请求转发给合适的 `Service` 层进行处理，并将响应返回给客户端。
   - **框架**：Spring MVC、Spring WebFlux 等
   - **注解**：通常使用 `@Controller` 或 `@RestController` 注解
   - **示例代码**：
   ```java
   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.RequestMapping;
   import org.springframework.web.bind.annotation.RestController;

   @RestController
   @RequestMapping("/api")
   public class UserController {
       @GetMapping("/hello")
       public String sayHello() {
           return "Hello, Spring!";
       }
   }
   ```

2. **Service 层**
   - **职责**：封装业务逻辑。接收来自 `Controller` 层的请求，进行相应的业务处理，并调用 DAO 层进行数据持久化操作。
   - **框架**：Spring
   - **注解**：通常使用 `@Service` 注解
   - **示例代码**：
   ```java
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.stereotype.Service;

   @Service
   public class UserService {
       @Autowired
       private UserDao userDao;

       public User findUserById(Long id) {
           return userDao.findById(id).orElse(null);
       }
   }
   ```

3. **DAO 层**（或 `Repository` 层）
   - **职责**：负责与数据库进行交互，执行数据持久化操作。通常通过 `JPA`、`MyBatis` 或其他持久层框架实现。
   - **框架**：Spring Data JPA、MyBatis、Hibernate 等
   - **注解**：通常使用 `@Repository` 注解
   - **示例代码**：
   ```java
   import org.springframework.data.jpa.repository.JpaRepository;
   import org.springframework.stereotype.Repository;

   @Repository
   public interface UserDao extends JpaRepository<User, Long> {
   }
   ```

4. **POJO（Plain Old Java Object）**
   - **职责**：简单的 Java 对象，通常用于表示数据模型或传输对象（DTO）。它们通常没有业务逻辑。
   - **框架**：Java 基本对象
   - **示例代码**：
   ```java
   public class User {
       private Long id;
       private String name;
       private String email;

       // 构造方法、getter 和 setter
       public User() {}

       public User(Long id, String name, String email) {
           this.id = id;
           this.name = name;
           this.email = email;
       }

       public Long getId() {
           return id;
       }

       public void setId(Long id) {
           this.id = id;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       public String getEmail() {
           return email;
       }

       public void setEmail(String email) {
           this.email = email;
       }
   }
   ```

### 分层架构中的位置

这些组件一般在分层架构中有明确的职责划分：

1. **表现层（Presentation Layer）**：包括 `Controller` 层
2. **业务逻辑层（Business Logic Layer）**：包括 `Service` 层
3. **数据访问层（Data Access Layer）**：包括 `DAO` 层
4. **模型层（Model Layer）**：包括 `POJO`

### 统称

这种结构通常被统称为**分层架构**（Layered Architecture）或**多层架构**（N-Tier Architecture）。

### 典型的 SSM 框架结构图

```
+------------------------------------------------+
|                   Controller                    |
|  (Spring MVC Controllers, REST Controllers)     |
+------------------------------------------------+
|                   Service                       |
|    (Business Logic, Spring Services)            |
+------------------------------------------------+
|                    DAO                          |
|     (Data Access, MyBatis, JPA Repositories)    |
+------------------------------------------------+
|                   POJO                          |
|       (Data Models, Entities, DTOs)             |
+------------------------------------------------+
```

### 小结

- `Controller`：负责处理请求，调用服务层，返回响应。
- `Service`：封装业务逻辑。
- `DAO`：与数据库交互，执行数据持久化操作。
- `POJO`：简单的 Java 对象，表示数据模型或传输对象。

这些概念和框架组成了 SSM（Spring、Spring MVC、MyBatis）或 Spring Boot 开发中常用的多层架构。