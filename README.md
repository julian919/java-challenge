Steps to run the project:
1.Navigate to root project folder
2.Enter docker-compose up
3.Wait for services to load & discover each other on the eureka service 
4.Can check for services up on (http://localhost:8761)

# API Documentation

## Base URL
`http://localhost:8765`

---

## Endpoints

### 1. **Register User**
- **Method:** `POST`
- **Endpoint:** `/auth/register`
- **Description:** Register a new user with the provided username and password.
- **Request Body:**
    ```json
    {
      "username": "julian-test",
      "password": "password-test"
    }
    ```
- **Authorization:** None

---

### 2. **Login User**
- **Method:** `POST`
- **Endpoint:** `/auth/login`
- **Description:** Log in with the provided username and password and receive a JWT token for authorization.
- **Request Body:**
    ```json
    {
      "username": "julian-test",
      "password": "password-test"
    }
    ```
- **Authorization:** None

---

### 3. **Update Postcode**
- **Method:** `PUT`
- **Endpoint:** `/postcodes/update/{postcode_id}`
- **Description:** Update the postcode with the provided `postcode_id`. 
- **Request Body:**
    ```json
    {
      "longitude": "11"
    }
    ```
- **Authorization:** **Required** (Bearer token in the `Authorization` header)

---

### 4. **Get Distance Between Postcodes**
- **Method:** `POST`
- **Endpoint:** `/postcodes/distance`
- **Description:** Calculate the distance between two postcodes.
- **Request Body:**
    ```json
    {
      "postcode1": "B34",
      "postcode2": "IP10"
    }
    ```
- **Authorization:** None

---

### 5. **List Postcodes**
- **Method:** `POST`
- **Endpoint:** `/postcodes`
- **Description:** Get a paginated list of postcodes.
- **Request Body:**
    ```json
    {
      "page": "1",
      "limit": "10"
    }
    ```
- **Authorization:** **Required** (Bearer token in the `Authorization` header)

---

## Authorization

For endpoints that require authorization, use the following header:

```http
Authorization: Bearer <JWT_TOKEN>
