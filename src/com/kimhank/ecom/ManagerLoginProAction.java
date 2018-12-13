package com.kimhank.ecom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimhank.bean.MngrDBBean;

public class ManagerLoginProAction implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String passwd =request.getParameter("passwd");
		
		MngrDBBean dbpro = MngrDBBean.getInstance();
		return "mLoginPro.jsp";
	}

}
