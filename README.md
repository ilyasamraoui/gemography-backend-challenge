# gemography-backend-challenge

This application is a Spring Boot REST microservice that list the languages used by the most starred GitHub public repos created in the last 30 days.

## Run the app

To launch the application run:
```
mvn spring-boot:run
```

## Run the tests
code coverage:

class 100%, method 78%, line 78%.

To launch the application's tests, run:
```
mvn clean test
```

# Rest API

The REST API of this microservice is described below.

## Get list of Trending languages

### Request

`GET /trendingLanguages`

    curl -i -H 'Accept: application/json' http://localhost:8080/trendingLanguages

### Response

    [   
        {
             "languageName": "Rust",
             "reposCount": 2,
             "reposUrls": [
                 "https://github.com/Qovery/engine",
                 "https://github.com/willdoescode/nat"
             ]
        },
        {
             "languageName": "C#",
             "reposCount": 1,
             "reposUrls": [
                 "https://github.com/RayWangQvQ/BiliBiliTool"
             ]
        }  
    ]