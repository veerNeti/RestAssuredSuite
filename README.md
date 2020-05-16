# WebServiceAutomationBuild

Sample Framework
## First We shall start automating using RestAssured
- RestAssured uses DSL (Domain Specific Language) for developing a test code.
* Key-words:
    1. *Given*: 
        Scenario Setup/Context builder : 
        - Example:
            - Configuration
            - Headers 
            - Parameters ,etc.,
            
    2. *When*:
        Do Some action:
        - Example:
            - GET an endpoint
            - Post To an Endpoint
            - ,etc.,
    3. *Then*:
            Validate the Response/ Assertions:
            - Example:
                - Check Response code
                - Check Response body
                - Extract data from Response and validate the fields,etc.,
                
                
BaseClass contains: -->Extends --> tests
- Base URI/PORT
- Default Headers
- Other Config


Request & Response Specifications:
- Request Specification 
    - Actions to include in every HTTP Request
    - Header, Cookies, Form Parameters, Base URL, BAse Port
    

- Response Specifications 
    - Actions to be taken After every HTTP request
    - Check Status code, Check Content-type, Response Time, Check Headers.
    
-You can use the builder to construct a request specification. The specification can be used as e.g.
    `ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();`
    `RequestSpecification requestSpec = new RequestSpecBuilder().addParam("parameter1", "value1").build();`
    
   ``  RequestSpecification requestSpec = new RequestSpecBuilder().addParameter("parameter1", "value1").build();
     given().
         spec(requestSpec).
        expect().
                body("x.y.z", equalTo("something")).
        when().
                get("/something");``
                
Automating the application:
https://github.com/james-willett/VideoGameDB


HTTP Verbs:
1. GET  --> Retrevie Data from an End point
2. POST --> Send data to an end point
3. PUT  --> update a resource
4. DELETE-> Delete a resource

#Serialization:
Get a Json Object -->Convert into Pojo -->Use pojo in restAssured code to create new game.


#Allure Reports:
- Report will be generated to target/site/allure-maven-plugin folder. 
  To open the report you can use the following command:
    * `mvn io.qameta.allure:allure-maven:serve`
- There is another way of generating the report. The generated report can be opened here "target/site/allure-maven-plugin/index.html".
  The command to generate the report is the following:
    * `mvn io.qameta.allure:allure-maven:report`
        
                
 #XML Schema
 - Get an XML Object --> Generate an XSD SChema -->Place the schema in our project-->Run a test that validates against the schema             
                      
 #Json Schema
 - Get a JSON Object -->Generate a JSON SChema--> place the schema in project--> Run Tests against it. 
 
 #JSON response to Pojo
 - Genereated a POJO class for payload using for serialization using http://pojo.sodhanalibrary.com/
 - Add a default constructor -->required by com.fasterxml.jackson.core
 - response.getBody( ).as(VideoGame.class); should parse the response to Pojo. 
 
 #Meassure Response Time
 - Capture Response Time
 - Asser on Response Time
 - Add response time assertion to response specification.
 
 ##Payload management
 -JSON to Pojo  ==>http://pojo.sodhanalibrary.com/
 -XML to POJO ==?http://pojo.sodhanalibrary.com/  
       
                
##Generate XSD from XML response
 - https://www.freeformatter.com/xsd-generator.html#ad-output
 
## Generate JSON Schema from Json response
 - https://jsonschema.net/home
 
 


##AllureReport:
mvn io.qameta.allure:allure-maven:report
mvn io.qameta.allure:allure-maven:serve