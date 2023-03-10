# LinkNet REST-API

## Description:
    This REST API provides endpoints for managing users, groups, and connections within the application.

## Main business requirements 1️⃣0️⃣:
    0️⃣ As a user, I want to be able to create an account and complete my profile with my personal and professional information, so that 
    other users can find me and connect with me on the platform.
    1️⃣ As a user, I want to be able to see all my connections and also create new ones, so that I can expand my professional network.
    2️⃣ As a user, I want to be able to create and join groups, so that I can collaborate and network with other users who have similar interests.
    3️⃣ As a user, I want to be able to view and manage my group memberships, so that I can stay updated on the activities of the groups I am in.
    4️⃣ As a user, I want to be able to create groups, so that other users with similar interests can join.

## Application features:

### *️⃣ The Users API includes endpoints for getting a list of all users, getting a specific user by ID, creating a new user, updating a user, and deleting a user.
    
    ✅ Get all users;
    ✅ Get user by userId;
    ✅ Create a user;
    ✅ Modify an existing user;
    ✅ Delete an existing user;
    
### *️⃣ The Groups API includes endpoints for getting a list of all groups, getting a specific group by ID, creating a new group, updating a group and removing a user from a group.

    ✅ Get all groups;
    ✅ Get all members for a specific group;
    ✅ Remove a user from a specific group;

### *️⃣ The Connections API includes endpoints for getting a list of all connections for a specific user, creating a new connection, and deleting a connection.
   
    ✅ Get all the connections;
    ✅ Create a connection between 2 users;
    ✅ Delete a connection between 2 users;
    ✅ Get all connections that a user has;

### All the endpoints are built following the REST principles and use the standard HTTP methods (GET, POST, PUT, DELETE) to perform the CRUD operations. The LinkNet platform is designed to handle the data in a consistent and predictable way, and it uses HTTP status codes to indicate success or failure of the API calls.