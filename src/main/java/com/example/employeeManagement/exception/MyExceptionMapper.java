package com.example.employeeManagement.exception;

import com.example.employeeManagement.helper.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyExceptionMapper implements ExceptionMapper<MyException> {
  @Override
  public Response toResponse(MyException exception) {
    ErrorMessage errorMessage = new ErrorMessage(exception.getCode(), exception.getDescription());
    return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
  }
}
