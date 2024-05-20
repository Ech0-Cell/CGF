# Overview

The CGFmth3902 project is a simple Java backend application that interacts with a RESTful service. It queries the REST API at http://universities.hipolabs.com/search?name=bahce to retrieve information about universities containing the keyword "bahce" in their names. The application prints the API response to the console, making it a basic tool for testing and demonstrating the interaction with external RESTful services.

# Prerequisites

Java 22 or higher.

Maven 3.6 or higher.

Internet connection to access the RESTful service and Maven repositories.

# Setup

To get started with the CGFmth3902 project, clone this repository and navigate into the project directory:

bash

git clone <https://github.com/Ech0-Cell/CGF>

cd CGFmth3902

# Building the Application

Compile and package the application using Maven:

bash

mvn clean package

This command will generate a jar file within the target directory.

# Running the Application

To run the application, use the following command:

bash

nohup ${JAVA_HOME}/bin/java -jar target/CGFmth3902-1.0-SNAPSHOT.jar &

This will start the application in the background, allowing it to continuously print responses from the RESTful service to the console.

# Application Structure

The application utilizes the following main components:

HttpClient from Apache HTTPComponents for sending HTTP requests.
Jackson Databind for processing JSON data.
Maven for managing dependencies and building the application.
The main class org.example.Main contains the logic to send the HTTP request and process the response.

# Dependencies

org.apache.httpcomponents:httpclient: For sending HTTP requests.
com.fasterxml.jackson.core:jackson-databind: For JSON parsing.
These dependencies are defined in the pom.xml file and will be automatically handled by Maven.
