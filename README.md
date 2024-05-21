# Charging Gateway Function (CGF) Project

This project is a Java application that serves as a Charging Gateway Function (CGF). It integrates with Kafka to poll messages from a specified topic and inserts subscriber usage records into an Oracle database.

## Project Structure

src/
├── main/
│ ├── java/
│ │ ├── com/
│ │ │ ├── example/
│ │ │ │ ├── cgf/
│ │ │ │ │ ├── KafkaPoller.java
│ │ │ │ │ ├── OracleInserter.java
│ │ │ │ │ ├── ChargingGatewayFunction.java
│ └── resources/
│ └── application.properties
└── test/
└── java/
└── com/
└── example/
└── cgf/
└── ChargingGatewayFunctionTest.java

## Prerequisites

- Java JDK 17
- Apache Maven
- Kafka
- Oracle Database
- An IDE like IntelliJ IDEA or VS Code

## Setup

### 1. Clone the Repository

git clone https://github.com/Ech0-Cell/your-repository-name.git
cd your-repository-name

### 2. Set Up Environment Variables

Windows

Right-click on 'This PC' or 'Computer' and select 'Properties'.
Click on 'Advanced system settings'.
Click on 'Environment Variables'.
Under 'System variables', click 'New' and add:
Variable name: JAVA_HOME
Variable value: C:\Program Files\Java\jdk-17
Add %JAVA_HOME%\bin to the Path variable.

macOS/Linux

Open a terminal.
Edit your shell profile file (.bashrc, .bash_profile, .zshrc, etc.) and add:

export JAVA_HOME=/path/to/your/java/home
export PATH=$JAVA_HOME/bin:$PATH

Apply the changes:

source ~/.bash_profile

### 3. Configure the Project

Update the application.properties file in the src/main/resources directory with your Kafka and Oracle database configurations.

# Kafka properties

kafka.bootstrap.servers=localhost:9092
kafka.group.id=cgf-group
kafka.key.deserializer=org.apache.kafka.common.serialization.StringDeserializer
kafka.value.deserializer=org.apache.kafka.common.serialization.StringDeserializer

# Oracle properties

oracle.db.url=jdbc:oracle:thin:@localhost:1521:xe
oracle.db.user=username
oracle.db.password=password

### 4. Build the Project

Use Maven to build the project:

mvn clean install

## Running the Application

1. Start Kafka
Ensure that your Kafka server is running and the topic for CGF is created.

2. Run the Application
You can run the application from your IDE or from the command line:

mvn exec:java -Dexec.mainClass="com.example.cgf.ChargingGatewayFunction"

3. Monitor the Application
The application will continuously poll messages from the Kafka topic and insert records into the Oracle database.

## Testing

To run the tests, use the following command:

mvn test
