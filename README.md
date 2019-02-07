# Validator
For this task, a program must be developed that allows the
input of all of the following types of data, displaying whether
the input is valid or not:
• Student ID
• Computing module code
• Plas Coch campus room number
• WGU email address
• UK postcode


## Application
This is a Spring Boot application wit JavaFX frontend.

### Prerequisites
It is built with: 
- OpenJDK 11  (https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=hotspot)
- OpenJFX 11  (https://gluonhq.com/products/javafx/)
- Maven 3.6.0 (https://maven.apache.org/download.cgi)
- NetBeans 10 (https://netbeans.apache.org/download/nb100/nb100.html)
- Scene Builder 9 (https://gluonhq.com/products/scene-builder/) (optional)

#### Netbeans IDE Setup
- set path to jdk in in netbeans.conf netbeans_jdkhome="<path_to_jdk>"
- set Scene Builder Home Tools -> Options -> JavaFX -> Scene Builder Home
- set up JavaFX 11 see https://openjfx.io/openjfx-docs/#IDE-NetBeans
- Project -> Properties -> Run add VM options:

	--module-path <path to javafx-sdk\lib>
	--add-modules=javafx.controls,javafx.fxml,javafx.graphics,javafx.base,javafx.media

#### Build
	mvn update
	mvn clean install 

#### Start application
	java -jar validator-0.0.1-SNAPSHOT.jar

