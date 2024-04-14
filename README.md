# Todo Server Application

## Overview
This is a backend server application designed to handle CRUD operations for memos. It provides RESTFUL endpoints to create, read, update, and delete memos. This memo app is unique in that it only allows for Completed, Uncompleted and Urgent Tasks to be logged. All Requests that attempt to use non-allowed Tags will be rejected.

## Technologies/Main Libraries Used
- Java
- Spring Boot
- Lombok
- MapStruct
- SQLite

## Usage
1. **Creating a Memo**: Use a POST request to `/v1/post/single/memo` with a JSON body containing the details of the memo. The server will save the memo.


2. **Fetching a Memo**: Use a GET request to `/v1/get/single/memo` with a JSON body containing the search criteria for the memo. The server will return the memo that matches the criteria.


3. **Fetching Memos by Tag**: Use a GET request to `/v1/get/tag/memo` with a JSON body containing the search criteria for the memo tag. The server will return a list of memos that match the tag.


4. **Fetching All Memos**: Use a GET request to `/v1/get/all/memo` to retrieve all memos stored in the system.


5. **Updating a Memo**: Use a PATCH request to `/v1/patch/single/memo` with a JSON body containing the updated details of the memo. The server will update the memo.


6. **Deleting a Memo**: Use a DELETE request to `/v1/delete/single/memo` with a JSON body containing the details of the memo to delete. The server will delete the memo.


## How to Run
To run the application, you need to have Java 21 installed on your system. Then, you can execute the JAR file containing the application using the following command:

`java -jar core-0.0.1-SNAPSHOT.jar`


Alternatively, you can clone this repository, load as Maven project, build and run it locally from your IDE.


## Wish List
1. Add more validations.
2. Migrate database to cloud instead of embedded database.
3. Custom HTTP Error Responses.

## Project Structure
According to best practices of Spring Boot Applications, there are different layers to this application which I have chosen to modularise for better Separation of Concerns.
1. Core
- Driver Class of the Application, contains all the modules that is required to run this application.
- The generated jar from this module will be used to run this application as a jar.

2. Server
- Contains the REST Controllers for the application. Handles all incoming requests as a DTO where validations can be done to filter good API requests.
- Basic Validations are done on essential fields, such as NonNull inputs.

3. Common
- Contains the data representation classes. DTOs are used to represent HTTP requests that come into the application. Domain level classes are used to represent data objects used in the service layer. Entity classes are used to represent data objects for repository queries.

4. Service
- Contains the business logic of the application. Business validations can also be done here. I have chosen to contain the repository class in this as well to interact with the DB.
- The DB used is SQLite, the decision was made to showcase a non-JPA based mechanism to interact with a non-native DB.