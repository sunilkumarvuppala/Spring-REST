
package com.sunil.api.controller;

import com.sunil.api.constants.URI;
import com.sunil.api.entity.User;
import com.sunil.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = URI.USERS)
@Api(tags = "users")
public class UserController {
    
    private UserService service;
    
    public UserController(UserService service){
        this.service=service;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Find All Users", notes = "Returns all users in the app")
    @ApiResponses(value = {
        @ApiResponse(code=200, message = "Success!!!"),
        @ApiResponse(code=500, message = "Internal Server Error!!!")
    })
    public List<User> finalAll(){
        return service.findAll();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = URI.ID)
    @ApiOperation(value = "Find All User by Id", notes = "Returns user by Id if exists in the app")
        @ApiResponses(value = {
        @ApiResponse(code=200, message = "Success!!!"),
        @ApiResponse(code=404, message = "Not Found!!!"),
        @ApiResponse(code=500, message = "Internal Server Error!!!")
    })
    public User findOne(@PathVariable("id") String id){
        return service.findOne(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Create an User", notes = "Creates an user with unique email")
        @ApiResponses(value = {
        @ApiResponse(code=200, message = "Success!!!"),
        @ApiResponse(code=400, message = "Bad Request!!!"),
        @ApiResponse(code=500, message = "Internal Server Error!!!")
    })
    public User create(@RequestBody User user){
        return service.create(user);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = URI.ID)
    @ApiOperation(value = "Update User", notes = "Updates an user if exists")
        @ApiResponses(value = {
        @ApiResponse(code=200, message = "Success!!!"),
        @ApiResponse(code=404, message = "Not Found!!!"),
        @ApiResponse(code=500, message = "Internal Server Error!!!")
    })
    public User update(@PathVariable("id") String id,@RequestBody User user){
        return service.update(id, user);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = URI.ID)
    @ApiOperation(value = "Delete User", notes = "Deletes an user if exists")
        @ApiResponses(value = {
        @ApiResponse(code=200, message = "Success!!!"),
        @ApiResponse(code=404, message = "Not Found!!!"),
        @ApiResponse(code=500, message = "Internal Server Error!!!")
    })
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
