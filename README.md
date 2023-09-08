#### ТЕСТОВОЕ Java REST-сервис для хранения данных о витринах товаров.
#### Для запуска нужно:

Java 8+, Maven 3+, PostgreSql 14, swagger-ui/Postman

<br>

#### Запуск через IDE:
- Создать базу данных **shop** (pgAdmin4)

- В IDE:

 Подтянуть зависимости из pom-файла и
````
Run class DeviceListApplication
````

#### Запуск из командной строки:
- Создать базу данных **shop** (pgAdmin4)

- Старт из папки проекта командой:

````
mvn spring-boot:run 
````

#### Для выполнения запросов - swagger-ui (или постман):

http://localhost:8080/swagger-ui.html

