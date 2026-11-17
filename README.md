# spring-boot-demo

一个最小的 Spring Boot 3 + Java 17 示例服务，提供 **三个 REST 接口**，数据保存在内存中（重启即清空），无数据库依赖。

## 技术栈

| 项目 | 版本 |
| --- | --- |
| Java | 17 |
| Spring Boot | 3.2.5 |
| 构建工具 | Maven |
| 端口 | 8080 |

## 接口列表

| 方法 | 路径 | 说明 | 成功状态码 |
| --- | --- | --- | --- |
| GET | `/api/tasks` | 查询全部任务（按 id 升序） | 200 |
| GET | `/api/tasks/{id}` | 按 id 查询单个任务，不存在返回 404 | 200 / 404 |
| POST | `/api/tasks` | 新建任务，`title` 必填且不超过 120 字符 | 201 / 400 |

## 快速开始

```bash
# 构建
mvn clean package

# 运行
mvn spring-boot:run
# 或
java -jar target/spring-boot-demo-0.0.1-SNAPSHOT.jar
```

## 调用示例

新建任务：

```bash
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"写一份 README","done":false}'
```

响应：

```json
{
  "id": 1001,
  "title": "写一份 README",
  "done": false,
  "createdAt": "2026-11-17T08:30:00Z"
}
```

查询列表：

```bash
curl http://localhost:8080/api/tasks
```

查询单个任务：

```bash
curl http://localhost:8080/api/tasks/1001
```

参数校验失败时返回 400：

```json
{
  "status": 400,
  "message": "validation failed",
  "errors": {
    "title": "title must not be blank"
  }
}
```

## 项目结构

```
src/main/java/com/example/demo
├── DemoApplication.java          # 启动类
├── controller
│   ├── TaskController.java       # 三个接口
│   └── ApiExceptionHandler.java  # 参数校验异常处理
├── model
│   ├── Task.java                 # 实体
│   └── CreateTaskRequest.java    # 创建请求体
└── service
    └── TaskService.java          # 内存存储
```

## 测试

```bash
mvn test
```

覆盖了创建 → 列表 → 详情的主流程，以及 404 与参数校验 400 两个分支。
