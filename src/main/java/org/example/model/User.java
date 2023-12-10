package org.example.model;

public class User {

    private static User configManagerInstance;
    private static int nextUserId = 1;

    private String name;
    private int id;
    private  UserRole role;
    private String address;

    public User(String name, UserRole role, String address) {
        this.id = nextUserId++;
        this.name = name;
        this.role = role;
        this.address = address;
    }

    public static User createConfigurationManager(){
        if(configManagerInstance == null){
            configManagerInstance = new User("ConfigurationManager", UserRole.CONFIG_MANAGER, "Cluj");
            configManagerInstance.setId(1);

        }
        return configManagerInstance;
    }

    public static User createUser(String name, UserRole role, String address){
        return new User(name, role, address);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
