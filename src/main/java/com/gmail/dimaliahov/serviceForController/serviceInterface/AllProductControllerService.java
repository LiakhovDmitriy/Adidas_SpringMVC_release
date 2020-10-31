package com.gmail.dimaliahov.serviceForController.serviceInterface;


import javax.servlet.http.HttpServletRequest;

public interface AllProductControllerService {

	String getCatalog (String categoryId, HttpServletRequest httpServletRequest);

}
