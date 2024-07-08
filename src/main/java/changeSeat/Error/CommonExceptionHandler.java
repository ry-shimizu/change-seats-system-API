package changeSeat.Error;

import changeSeat.Error.ErrorObject.ResourceError;
import changeSeat.Error.ErrorObject.ValidationError;
import changeSeat.Error.Exception.FileOperateException;
import changeSeat.Error.Exception.InvalidInputException;
import changeSeat.Error.Exception.NotFoundException;
import changeSeat.Error.Exception.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler({InvalidInputException.class})
    public ResponseEntity<ResourceError> badRequestExceptionHandler(RuntimeException e) {
        log.warn(String.format(" エラーメッセージ：%s", e.getMessage()), e);
        return ResponseEntity.badRequest().body(new ResourceError(e.getMessage()));
    }

    @ExceptionHandler({DuplicateKeyException.class, FileOperateException.class})
    public ResponseEntity<ResourceError> serverErrorExceptionHandler(RuntimeException e) {
        log.error(String.format(" エラーメッセージ：%s", e.getMessage()), e);
        return ResponseEntity.internalServerError().body(new ResourceError(e.getMessage()));
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Void> notFoundExceptionHandler(RuntimeException e) {
        log.warn(String.format(" エラーメッセージ：%s", e.getMessage()));
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({UnauthorizedException.class})
    public ResponseEntity<ResourceError> unauthorizedExceptionHandler(RuntimeException e) {
        log.warn(String.format(" エラーメッセージ：%s", e.getMessage()));
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResourceError(e.getMessage()));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<List<ValidationError>> validationExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        var validationList = errors.stream().map(f -> new ValidationError(f.getField(), f.getDefaultMessage())).toList();
        log.warn(validationList.stream()
                .map(g -> g.getField() + "：" + g.getMessage())
                .collect(Collectors.joining(",")), e);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(validationList);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Void> exceptionHandler(Exception e) {
        log.error("予期しないエラーが発生しました。", e);
        return ResponseEntity.internalServerError().build();
    }
}
