package com.ssw.shoppingmall.web;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import com.google.common.collect.ImmutableMap;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by wisebirds on 2017-08-16.
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlerControllerAdvice {
	public static String getStackFrame(Throwable t) {
		String stack = null;
		try {
			stack = ExceptionUtils.getStackFrames(t)[0];
		} catch (Exception e) {
			// 실패해도 문제없다.
		}
		return stack;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView handleException(Exception e) {
		if (e instanceof NoHandlerFoundException) {
			return new ModelAndView("common/error", "e", //
					ImmutableMap.builder(). //
							put("message", e.getMessage() == null ? "Unknown" : e.getMessage()).//
							put("stack", getStackFrame(e)).//
							put("code", "dev.e").//
							build());
		} else {
			log.error("무언가 오류가 발생했습니다.", e);
			return new ModelAndView("common/error", "e", //
					ImmutableMap.builder(). //
							put("message", e.getMessage() == null ? "Unknown" : e.getMessage()).//
							put("stack", getStackFrame(e)).//
							put("code", "dev.e").//
							build());
		}
	}

	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ModelAndView handleBindException(BindException be) {
		log.warn("잘못된 호출입니다.", be);
		return new ModelAndView("common/error", "e", //
				ImmutableMap.builder(). //
						put("message", be.getMessage() == null ? "Unknown" : be.getMessage()).//
						put("stack", getStackFrame(be)).//
						put("code", "dev.request_param_bind_exception").//
						build());
	}

	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView handleNullPointerException(NullPointerException npe) {
		log.error("이런! 개발자가 실수를 했군요", npe);
		return new ModelAndView("common/error", "e", //
				ImmutableMap.builder(). //
						put("message", npe.getMessage() == null ? "Unknown" : npe.getMessage()).//
						put("stack", getStackFrame(npe)).//
						put("code", "dev.npe").//
						build());
	}

}
