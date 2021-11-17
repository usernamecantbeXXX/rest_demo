# Restful API Demo

## Build and Run

### Compile
```
sudo mkdir /opt/webapps && cd /opt/webapps
sudo git clone http://gitlab.admin.bluemoon.com.cn/xuxianxue/rest_demo.git
cd ./rest_demo
sudo mvn clean package --settings ./settings.xml
```

### Run with Jar

```
 cd ./target
 java -jar rest_demo-0.0.1-SNAPSHOT.jar
```

### Run with Script

```
 ./start.sh
 ./stop.sh
```

## API Overview

| Method | HTTP Requests         | Returns          | Command                                 |
| ------ | --------------------- | ---------------- | --------------------------------------- |
| create | `POST /tasks`         | `SUCCESS/FAILED` | tasks add "write some code" 21/08/2019  |
| update | `PUT /tasks`          | `SUCCESS/FAILED` | tasks done 3                            |
| delete | `DELETE /tasks/${id}` | `SUCCESS/FAILED` | tasks delete 3                          |
| list   | `GET /tasks`          | A Task List      | tasks list /tasks list --expiring-today |

## Architecture

- Java 8
- SpringBoot
- Mybatis-plus
- SQLite