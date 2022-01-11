package com.pedidohamburguer.controller.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<Errors> handle(MethodArgumentNotValidException expection) {

		List<Errors> dto = new ArrayList<>();

		List<FieldError> fieldErrors = expection.getBindingResult().getFieldErrors();

		for (FieldError fieldError : fieldErrors) {

			String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			Errors erro = new Errors(fieldError.getField(), mensagem);
			dto.add(erro);
		}
		return dto;

	}

}