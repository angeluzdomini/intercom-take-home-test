# Food & Drinks Invitation List Generator

## Problem Statement
We have some customer records in a text file (customers.txt) -- one customer per line, JSON
lines formatted. We want to invite any customer within 100km of our Dublin office for some food
and drinks on us. Write a program that will read the full list of customers and output the names
and user ids of matching customers (within 100km), sorted by User ID (ascending).
- You must use the first formula from [this Wikipedia Article](https://en.wikipedia.org/wiki/Great-circle_distance) to calculate distance. Don't
forget, you'll need to convert degrees to radians.
- The GPS coordinates for our Dublin office are 53.339428, -6.257664.
- You can find the Customer list in [this URL](https://s3.amazonaws.com/intercom-take-home-test/customers.txt) and also in this path: src/main/resources/customers.txt.

## Technical Details
- Language: Java
- External libraries
  - org.json:json:20201115 : For transforming json data from the files.
  - org.junit.jupiter:junit-jupiter-engine:5.5.2 and org.junit.platform:junit-platform-runner:1.5.2 : Support for junit5 test cases.

- Origin location (Dublin office), search radius and input file name/path are defined as constants as per the problem statement.
 
## How to run
### Pre-requisites
- Java 8
- Maven 3

### Installing Java
You can install Java 8 according to the instructions here:
https://java.com/en/download/help/download_options.html

You can confirm the version after installation using this command:
> **java -version**

Version would be given similar to this:
**java version "1.8.0_231"**

### Installing Maven
You can install maven according to the instructions here:
https://maven.apache.org/install.html

You can confirm the version after installation using this command:
> **mvn -version**

Version would be given similar to this:
**Apache Maven 3.6.1**

### Building the code
You can build the code using the following command from the root folder of the project:
> **mvn clean install**

### Running the code
After building the code successfully, go to the root folder of the project and run the command:
> **java -jar target\my-app-1.0-SNAPSHOT-jar-with-dependencies.jar**

### Sample output
A sample output is available in the following path: **src/main/resources/output.txt**

