package com.jerseycrud.demo.jerseycrud.dto;

import com.jerseycrud.demo.jerseycrud.domain.User;

public class UserDTO {
    private Long id;
    private String name;
    private String age;

    public UserDTO(Long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UserDTO() {
    }

    public UserDTO(User user){
        this(user.getId(),user.getName(),user.getAge());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
