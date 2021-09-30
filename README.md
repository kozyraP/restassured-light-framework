# restassured-light-framework


## Main technologies
- [Java 11](https://github.com/openjdk/)
- [RestAssured](https://github.com/rest-assured/rest-assured)
- [Junit5](https://junit.org/junit5/docs/current/user-guide/)
- [Maven](https://maven.apache.org/)


## Requirements
- To run tests [Maven](https://maven.apache.org/) must be instaled.
- Add your credentials in `src/main/resources/CredentialConfiguration.properties` file. 
```
clientId=Client ID

clientSecret=Client Secret
```

- To do that you should register your application [here](https://apps.developer.allegro.pl.allegrosandbox.pl/new): 
`https://apps.developer.allegro.pl.allegrosandbox.pl/new`
   

## Usage

To run tests execute command:

```shell
mvn test 
```
![Gif example of performing tests from cmd](https://i.imgur.com/p65cL23.gif)
