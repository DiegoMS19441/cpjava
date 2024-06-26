package br.com.fiap.cpjava.handler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class ErroHandler {
        @ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity<Void> error404(){
            return ResponseEntity.notFound().build();
        }
}
