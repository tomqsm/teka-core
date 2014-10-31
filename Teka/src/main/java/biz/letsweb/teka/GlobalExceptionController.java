package biz.letsweb.teka;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author toks
 */
@ControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler{

    /* Handling framework exceptions */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("Internal framework error occurred.");
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }
    
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    @ExceptionHandler
//    public String handleResourceNotFound(Exception ex){
//        System.out.println("resource not found");
//        return "/404";
//    }
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleAllExceptions(Exception ex) {
//        ModelAndView mav = new ModelAndView("500");
//        return mav;
//    }
}
