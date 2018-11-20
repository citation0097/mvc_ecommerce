package com.kimhank.ecom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandAction {
	public String requestPro(HttpServletRequest requet, HttpServletResponse response)
	throws Throwable;
}
