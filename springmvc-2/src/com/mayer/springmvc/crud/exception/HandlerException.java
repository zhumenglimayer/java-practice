package com.mayer.springmvc.crud.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {
	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView getArithmeticException(Exception ex){
		System.out.println("======出异常了...." + ex);
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ex);
		return mv;
	}
}
