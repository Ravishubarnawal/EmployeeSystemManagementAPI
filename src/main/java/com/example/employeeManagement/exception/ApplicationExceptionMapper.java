package com.example.employeeManagement.exception;

import com.example.employeeManagement.helper.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<ApplicationException> {
  @Override
  public Response toResponse(ApplicationException ex) {
    ErrorMessage errorMessage = new ErrorMessage();
    errorMessage.setErrorMessage("Data is not available in DB");
    errorMessage.setErrorCode(400);
    errorMessage.setDocumentation(
        "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404?retiredLocale=de");
    return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
  }
}
