# book sorting service

This is a Java maven project, you should import it through pom.xml file in your favorite IDE.

# To check source code in Eclipse IDE
* In Eclipse: File > Import ...
* Maven > Existing Maven Projects
* Browse to "booksortservice" folder looking for pom.xml file > Finish.

* Package sortingservice contains application class (entry point) exception class and controller class responsible by REST method exposure.
* Package model contains sort service input model (request JSON), sort service output model (response JSON), Book and ConfigSort model classes

# To run API service
Using Docker 
* Go to jar folder
```sh
  $ cd booksortservice/jar
```
* Build image 
```sh
  $ sudo docker build -t sortingservice .
```
* Run application 
```sh
  $ sudo docker run -p 4040:8080 sortingservice
```
The application starts and listen in localhost:4040/sort

# To test service
Using Postman
