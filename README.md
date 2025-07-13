# demo-open-api-swager

A demo project for designing and generating REST APIs using **OpenAPI 3**, **Spring Boot 3.3.3**, **Java 21**, and **Jakarta EE**, based on a contract-first approach.

📘 Blog post: [Creating REST APIs with OpenAPI, Spring Boot 3.3.3, Java 21, and Jakarta](https://jarmx.blogspot.com/2024/09/creating-rest-apis-with-openapi-spring.html)

---

## 📁 Project Structure

```
demo-open-api-swager
├── src
│   ├── main
│   │   └── java
│   │       └── com.henry.openapi.service
│   ├── test
│   │   └── java
│   │       └── com.henry...
├── pom.xml
```

---

## ✍️ Defining the API Contract

Create `src/main/resources/api.yaml`:

```yaml
openapi: 3.0.0
info:
  title: Sample API
  version: 1.0.0
paths:
  /items:
    get:
      summary: Get all items
      ...
components:
  schemas:
    Item:
      type: object
      properties:
        id:
          type: integer
        name:
          type: string
      required:
        - name
```

---

## ⚙️ OpenAPI Generator Configuration

In `pom.xml`, configure:

```xml
<plugin>
  <groupId>org.openapitools</groupId>
  <artifactId>openapi-generator-maven-plugin</artifactId>
  <version>7.8.0</version>
  <executions>
    <execution>
      <id>generate-sources</id>
      <goals><goal>generate</goal></goals>
      <configuration>
        <inputSpec>${project.basedir}/src/main/resources/api.yaml</inputSpec>
        <output>${project.basedir}/src/main/generated-sources</output>
        <generatorName>spring</generatorName>
        ...
      </configuration>
    </execution>
  </executions>
</plugin>
```

Then run:

```bash
mvn clean install
```

---

## 🧪 Sample Implementation

```java
@Service
public class ItemsServiceImpl implements ItemsApiDelegate {
    private final List<Item> items = new ArrayList<>();
    private Long currentId = 1L;

    public ItemsServiceImpl() {
        items.add(new Item().id(1L).name("Item 1"));
        items.add(new Item().id(2L).name("Item 2"));
    }

    @Override
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(items);
    }

    ...
}
```

---

## 🔍 API Access

- Swagger UI: `http://localhost:8080/swagger-ui.html`
- JSON Spec: `http://localhost:8080/v3/api-docs`
- YAML Spec: `http://localhost:8080/v3/api-docs.yaml`

---

## 🧪 cURL Examples

```bash
# Get all items
curl -X GET http://localhost:8080/items

# Get item by ID
curl -X GET http://localhost:8080/items/1

# Create item
curl -X POST http://localhost:8080/items -H "Content-Type: application/json" -d '{"name": "New Item"}'

# Update item
curl -X PUT http://localhost:8080/items/1 -H "Content-Type: application/json" -d '{"name": "Updated Item"}'

# Delete item
curl -X DELETE http://localhost:8080/items/1
```

---

## ✅ Conclusion

This project demonstrates how to:
- Define an OpenAPI contract
- Generate controllers using OpenAPI Generator
- Implement REST logic with Jakarta EE annotations
- Use Springdoc to visualize and interact with APIs

---

## 🔗 References

- https://swagger.io/specification/
- https://springdoc.org/
- https://github.com/swagger-api/swagger-codegen

---

## 👤 Author

**Henry Xiloj Herrera**  
- Blog: [jarmx.blogspot.com](https://jarmx.blogspot.com)  
- GitHub: [@HenryXiloj](https://github.com/HenryXiloj)
