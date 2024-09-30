# franchise-challenge
## Tools
- ### docker
- ### docker compose
- ### mysql
- ### h2 for test
- ### maven

## Installation
```bash
docker compose up --build
```
#### This command will create two containers: a database container and an API container, and it will expose them on port 3001 of your local machine using the .env.docker file
#### If you don't use Docker Compose, you can run this project by installing all the dependencies. MySQL is required on your local machine to build the project. The application.properties file contains all the default configurations 
## Endpoints
### [POST] /franchise
```json 
{
    "name": "franchise name"
} 
```
### [POST] /branch
```json
{
  "name": "branch name",
  "franchiseId": 52
}
```

### [POST] /products
```json
{
	"name": "product1",
	"quantity": 200,
	"branchId": 2
}
```

### [PUT] /products/stock
```json
{
	"id": 1,
	"quantity": 100
}
```
### [GET]  /products/top/{franchiseId}
```json

```

### [PUT] /branch
```json
{
	"id": 1,
	"name": "branchNameModified223232"
}
```
### [PUT] /franchise 
```json
{
	"id": 1,
	"name": "franchiseNameModified"
}
```

### [PUT] /products
```json
{
	"id": "1",
	"name": "procuctNameModified"
}
```




