## Task
Create a todo list that allows users to input the following fields:  
- Task (mandatory)
- Priority levels (1 - 5)
- Due date (present or future)
- Add and clear buttons  

Task, priority and due date should be displayed in a table below.

Client should be able to see and retrieve a list of added task with the same browser.

## Concepts
1. Creating, tracking and destroying sessions
2. Mapping form fields
    - @RequestBody MultiValueMap
    - @ModelAttribute
3. Validating form fields
    - Semantic
    - Syntatic
    - Global form validation
    - Form field validation
4. Displaying validation errors
5. POST request
    -  @PostMapping(consumes="XXX", produces="XXX")
6. CSS styling for errors
    

## Additional Dependencies
Maven pom.xml  
Springboot Starter Validation
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
			<version>3.2.3</version>
		</dependency>