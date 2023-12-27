Demo project to show how JPA/Hibernate map Java Time to MySQL TIMESTAMP/DATETIME column.

# Pre-requisite

- JDK 17
- Maven 3.9.5
- MySQL Server 8.0.33+ installed

# Usage

Make sure MySQL database `jpa_test` and username `root` with password `root` created, or changed the property in `application.properties` accordance with your setting.

```shell
mvn spring-boot:run
```

And then open [Swagger UI](http://localhost/swagger-ui/index.html) to call api to observe logs and results.

Or you could run test in `ApplicationTest` to observe logs.

# Note

`BeanPropertyRowMapper` will map MySQL `DATETIME` to `java.time.LocalDateTime` automatically and Spring Framework does not have default converter from `LocalDateTime` to `Instant`, so we choose not to include `jdbc_instant_datetime` column.
