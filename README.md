# A Spring ActiveMQ App

## 1. Create a repo manually

### 1.1 Create a repo on GitHub
Click "Repositories",then click "New" button,input "spring-activemq-app", leave all other input as default, click "Create repository".

### 1.2 Create a Java ActiveMQ app by Maven
```console
$ cd code
$ mvn archetype:generate -DgroupId=xyz.javaneverdie.activemq -DartifactId=springactivemqapp -DarchetypeArtifactId=maven-archetype-quickstart -Dversion=1.0-SNAPSHOT -DinteractiveMode=false
```

### 1.3 Init repo 
```console
$ cd springactivemqapp
$ mvn clean
$ echo "# spring-activemq-app" >> README.md
$ git init
$ git add -A
$ git commit -m "add java maven archetype quickstart app"
$ git branch -M main
$ git remote add origin https://github.com/maping/spring-activemq-app.git
$ git push -u origin main
```

## 2. Modify pom.xml

### 2.1 增加源代码编码和 java compile 版本属性设定
```code
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <!--<org.springframework.version>6.0.3</org.springframework.version>-->
        <org.springframework.version>5.2.9.RELEASE</org.springframework.version>      
    </properties>
```
>重要：java compiler 版本要与实际使用的 JDK 保持一致。

### 2.2 增加 activemq-all 依赖 
```code
        <dependency>
            <groupId>org.apache.activemq</groupId>
            <artifactId>activemq-all</artifactId>
            <version>5.17.3</version>
        </dependency>
        <dependency>
            <groupId>org.apache.activemq</groupId>
            <artifactId>activemq-pool</artifactId>
            <version>5.17.3</version>
        </dependency>
```

### 2.3 增加 log4j 依赖 
```code
        <!-- log4j-core 和 logj-api 两个依赖用于修复 Apache Log4j2 远程代码执行漏洞 -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.19.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.19.0</version>
        </dependency>
```

### 2.3 增加 spring-jms 依赖 
```code
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${org.springframework.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>  
            <version>${org.springframework.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>${org.springframework.version}</version>   
        </dependency> 
        <!-- Spring JMS  -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jms</artifactId>
            <version>${org.springframework.version}</version>
        </dependency>        
```

## 3. Compile application
```console
$ cd springactivemqapp
$ mvn clean package
```
恭喜，你已经成功构建了一个 Java 应用！

## 4. Run application
使用 Netbeans 打开应用目录，然后右键 .java，选择 Run File

