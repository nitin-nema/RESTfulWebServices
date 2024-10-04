package com.example.RESTfulWebServices.Controller;

import com.example.RESTfulWebServices.Model.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private Map<Integer, User> users = new HashMap<>();

    // GET all users
    @GetMapping
    public Collection<User> getAllUsers() {
        return users.values();
    }

    // GET specific user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return users.getOrDefault(id, new User());
    }

    // POST - create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        if (users.containsKey(user.getId())) {
            throw new RuntimeException("User already exists!");
        }
        users.put(user.getId(), user);
        return user;
    }

    // PUT - update existing user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        if (!users.containsKey(id)) {
            throw new RuntimeException("User not found!");
        }
        users.put(id, updatedUser);
        return updatedUser;
    }

    // DELETE - delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        if (!users.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found!");
        }
        users.remove(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
