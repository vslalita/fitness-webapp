fitness-webapp
==============
In order to run the web applications, you need to have the following softwares installed on your system

Pre-requisites
-------------------------

1. Maven- Please follow installation instructions for the approporiate OS as described in this link. http://maven.apache.org/download.cgi
2. JDK 1.7 - Please install using this link as a reference - http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
3. Make note of the folder where you installed the JDK 1.7 to. Set  JAVA_HOME to point to the <JDK_1.7_FolderPath>/bin/

Running the Web-App
-------------------------
1. Navigate to the project location. From the terminal(Linux or Mac) or command Prompt in Windows, type the following command
   cd \<Project Location\>
   
2. Run the following command 

   mvn jetty:run
   
3. In a web browser, type the following url - http://localhost:8080.