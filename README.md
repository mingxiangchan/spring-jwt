### Testing Endpoints

This endpoint is not restricted, anyone can access this.

```
localhost:8080/public
```

This endpoint is restricted. You need to login and attach your JWT token in the `Authorization` header before you can access this endpoint.

```
localhost:8080/restricted
```

### In-Memory DB Auth

Make a POST request to the authentication endpoint to get your JWT. The resulting JWT will be in the response's `Authorization` header.

```
http://localhost:8080/api/login?username=user&password=password
```