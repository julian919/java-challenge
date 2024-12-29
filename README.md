## Steps to Run the Project

1. **Navigate to the Root Project Folder**  
   Open your terminal and navigate to the root directory of the project.

2. **Start the Services Using Docker Compose**  
   Run the following command to start the services:
   ```bash
   docker-compose up
   ```

3. **Wait for the Services to Load**  
   Allow the services some time to load and discover each other via the Eureka service.

4. **Check the Services on Eureka Dashboard**  
   Once the services are up and running, you can check their status by visiting the Eureka Dashboard at:  
   [http://localhost:8761](http://localhost:8761)

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
