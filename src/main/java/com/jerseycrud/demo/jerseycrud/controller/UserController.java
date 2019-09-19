package com.jerseycrud.demo.jerseycrud.controller;

import com.jerseycrud.demo.jerseycrud.domain.User;
import com.jerseycrud.demo.jerseycrud.dto.UserDTO;
import com.jerseycrud.demo.jerseycrud.repository.UserPaginationRepository;
import com.jerseycrud.demo.jerseycrud.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/user")
public class UserController {

    private UserService userService;
    private UserPaginationRepository userRepository;

    public UserController(UserService userService, UserPaginationRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUser(){
        List<User> users = userService.getAll();
        return Response.ok(users).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAUser(@PathParam("id")Long id){
        User user = userService.getOne(id);
        return Response.ok(user).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertUser(UserDTO userDTO){
        User user = userService.insert(userDTO);
        return Response.ok(user).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id")Long id){
        userService.delete(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUSer(@PathParam("id")Long id , UserDTO userDTO){
        User user = userService.update(userDTO,id);
        return Response.ok(user).build();
    }

    @GET
    @Path("/pages")
    @Produces(MediaType.APPLICATION_JSON)
    public Response usersPages(@QueryParam("page") int page, @QueryParam("size") int size) {
        Pageable pageable = new PageRequest(
                page,size,new Sort("id")
        );
        Page<User> pageResult = userRepository.findAll(pageable);

        return Response.ok(pageResult).build();
    }
}
