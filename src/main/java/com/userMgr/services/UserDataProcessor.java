package com.userMgr.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import com.userMgr.model.Users;

public class UserDataProcessor {
    private static final String FILE_PATH = "C:\\Users\\USER\\Desktop\\project\\cakeShop\\src\\main\\webapp\\WEB-INF\\users.txt";
    
    /**
     * Authenticates a user using bubble search algorithm on a queue of users
     * @param userIdentifier username or email
     * @param password user's password
     * @return User object if authenticated, null otherwise
     */
    public Users authenticateUser(String userIdentifier, String password) {
        Queue<Users> userQueue = loadUsersIntoQueue();
        Users user = bubbleSearchUser(userQueue, userIdentifier, password);
        System.out.println("User: " + userQueue);
        return user;
    }
    
    /**
     * Loads all users from users.txt into a queue
     * @return Queue of User objects
     */
    private Queue<Users> loadUsersIntoQueue() {
        Queue<Users> queue = new LinkedList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                
                System.out.println("Line: " + line);
                if (parts.length >= 3) {
                	
                    String username = parts[0];
                    String email = parts[1];
                    String pwd = parts[2];
                   
                    
                    Users user = new Users(username, email, pwd);
                    queue.add(user);
                }
            }
            System.out.println("Queue: " + queue);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return queue;
    }
    
    /**
     * Implements bubble search algorithm on a queue of users
     * Bubble search: We compare adjacent elements (in this case, we're using it to search through the queue)
     * @param userQueue queue of users
     * @param userIdentifier username or email
     * @param password user's password
     * @return User object if found and authenticated, null otherwise
     */

private Users bubbleSearchUser(Queue<Users> userQueue, String userIdentifier, String password) {
    int size = userQueue.size();
    
    System.out.println("Size: " + size);
    Users[] users = new Users[size];

    // Convert queue to array and preserve queue contents
    for (int i = 0; i < size; i++) {
        Users user = userQueue.remove();
        users[i] = user;
        userQueue.add(user); // Add back to queue
    }

    // Simple linear search is more appropriate for finding a user
    for (Users user : users) {
        if (isMatchingUser(user, userIdentifier, password)) {
            return user;
        }
    }

    return null; // User not found or credentials don't match
}

    
    
    
    /**
     * Checks if a user matches the provided credentials
     * @param user User object
     * @param userIdentifier username or email
     * @param password user's password
     * @return true if matching, false otherwise
     */
    private boolean isMatchingUser(Users user, String userIdentifier, String password) {
    	
        return (user.getUserName().equals(userIdentifier) || 
                user.getEmail().equals(userIdentifier)) && 
               user.getPassword().equals(password);
    }
}