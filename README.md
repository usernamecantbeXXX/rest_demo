# Restful API Demo

## 1. Directly Run
I have prepared a [tar.gz](https://raw.githubusercontent.com/usernamecantbeXXX/rest_demo/master/rest.tar.gz) file included the jar compiled and scripts.

Extract the tar.gz file, run the `start.sh` to start the web application at 8080 port. The port can be changed in the `application.properties` file.

```
tar -zxvf rest.tar.gz
cd rest
sh ./start.sh 
```

Then we can see the information as below if the app have been started successfully.
```
ubuntu@nmt:/opt/webapps/rest_demo/target$ sudo sh ./start.sh 
Service  start ...
Service  start SUCCESS
```
## 3. Call the API Command Line

After start the app, call the API with Command Line mode As Below：

```
sh ./tasks.sh add "write some codes" "17/11/2021" "todo"
sh ./tasks.sh list
sh ./tasks.sh list --expiring-today
sh ./tasks.sh done 3

```

## 3. Build and Package From Source code

### 3.1 Compile
```
sudo mkdir /opt/webapps && cd /opt/webapps
sudo git clone http://gitlab.admin.bluemoon.com.cn/xuxianxue/rest_demo.git
cd ./rest_demo
sudo mvn clean package --settings ./settings.xml
```

### 3.2 Run with Script

```
 cd ./target
 sudo sh ./start.sh
 sudo sh ./stop.sh
 sudo sh ./restart.sh
```

## 4. API Overview

| Method | HTTP Requests         | Returns          | Command                                 |
| ------ | --------------------- | ---------------- | --------------------------------------- |
| create | `POST /tasks`         | `SUCCESS/FAILED` | tasks add "write some code" 21/08/2019  |
| update | `PUT /tasks`          | `SUCCESS/FAILED` | tasks done 3                            |
| delete | `DELETE /tasks/${id}` | `SUCCESS/FAILED` | tasks delete 3                          |
| list   | `GET /tasks`          | A Task List      | tasks list /tasks list --expiring-today |

![HTTP Requests](https://raw.githubusercontent.com/usernamecantbeXXX/rest_demo/master/http_request.png)

## 5. Architecture

### 5.1 Technical Stacks

- Java 8
- SpringBoot
- Mybatis-plus
- SQLite

![SQLite DB](https://raw.githubusercontent.com/usernamecantbeXXX/rest_demo/master/sqlite_db.png)

### 5.2 Files Description
```
ubuntu@nmt:/opt/webapps/rest_demo$ tree ./
./
├── README.md
├── log
│   └── spring.log                                      #logs files
├── pom.xml
├── settings.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── rest_demo
    │   │               ├── RestDemoApplication.java
    │   │               ├── Service
    │   │               │   ├── TaskService.java
    │   │               │   └── TaskServiceImpl.java
    │   │               ├── controller
    │   │               │   └── TaskController.java     # Restful API Definition
    │   │               ├── entity
    │   │               │   └── Task.java
    │   │               └── mapper
    │   │                   └── TaskMapper.java
    │   └── resources
    │       ├── application.properties
    │       ├── db
    │       │   └── rest.sqlite 		        # SQLite datebase 
    │       ├── generated-requests.http                 # API request example 
    │       └── script					# script for start the Restful web application
    │           ├── restart.sh
    │           ├── start.sh
    │           └── stop.sh
    └── test
        └── java
            └── com
                └── example
                    └── rest_demo
                        └── Service
                            └── TaskServiceTest.java    # Junit Test
```

