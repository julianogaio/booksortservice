## Book Sorting API Service

### Download or clone project to your computer

This is a Java maven project, you should import it through pom.xml file in your favorite IDE.

## Import source code in [Eclipse](https://www.eclipse.org/)
* Menu File > Import ...
* Maven > Existing Maven Projects
* Browse to "booksortservice" folder looking for pom.xml file > Finish.

### Project packages and its contents
* Package stormtech.com.sortservice contains application class (entry point) exception class and controller class responsible by REST method exposure.
* Package stormtech.com.sortservice.model contains sort service input model (request JSON), sort service output model (response JSON), Book and ConfigSort model classes
* Resources contain application.properties file
* src.test.java package not implemented yet

## Run API service in a virtualization
Using [Docker](https://www.docker.com/)
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


## Testing API service 
Using [Postman](https://www.getpostman.com/)

* Need to pass as input parameter the JSON SSInputModel (java class) which consists in a list of books and a list of sort configurations (configs attribute)

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
```


* The response will be a JSON based on SSOutputModel java class and would be something like this:
```
{
  "sortedList": [
    {
      "id": "book1",
      "title": "Java",
      "author": "Deitel",
      "edition": "2007"
    },
    {
      "id": "book4",
      "title": "Internet",
      "author": "Deitel",
      "edition": "2007"
    },
    {
      "id": "book3",
      "title": "Head",
      "author": "Elis",
      "edition": "2004"
    },
    {
      "id": "book2",
      "title": "Pattern",
      "author": "Martin",
      "edition": "2002"
    }
  ]
}
