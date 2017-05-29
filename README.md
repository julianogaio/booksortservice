## Book Sorting Service

This is a Java maven project, you should import it through pom.xml file in your favorite IDE.

## To check source code in Eclipse IDE
* In Eclipse: File > Import ...
* Maven > Existing Maven Projects
* Browse to "booksortservice" folder looking for pom.xml file > Finish.

* Package sortingservice contains application class (entry point) exception class and controller class responsible by REST method exposure.
* Package model contains sort service input model (request JSON), sort service output model (response JSON), Book and ConfigSort model classes

## To run API service
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
The application will start and listen at http://localhost:4040/sort


## To test service
Using Postman
* Need to pass as input parameter the SSInputModel which consists in a list of books and a list of sort configurations (configs attribute)

The JSON should be in this format

```
{ 
	"books": [
		{"id":"book1", "title": "Java", "author":"Deitel", "edition": "2007"},
		{"id":"book2", "title": "Pattern", "author":"Martin", "edition": "2002"},
		{"id":"book3", "title": "Head", "author":"Elis", "edition": "2004"},
		{"id":"book4", "title": "Internet", "author":"Deitel", "edition": "2007"}
		],
	"configs": [
		{"column":"edition", "sort": "desc"},
		{"column":"author", "sort": "desc"},
		{"column":"title", "sort": "desc"}]
}
...
