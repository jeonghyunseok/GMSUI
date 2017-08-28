package com.gms.web.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gms.web.command.Command;
import com.gms.web.constants.Action;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;

import com.gms.web.proxy.BlockHandler;
import com.gms.web.proxy.PageHandler;
import com.gms.web.proxy.PageProxy;
import com.gms.web.service.MemberService;
import com.gms.web.service.MemberServiceImpl;
import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.ParamsIterator;
import com.gms.web.util.Separator;


@WebServlet({"/member.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	
@SuppressWarnings("unused")
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 Separator.init(request);
	 MemberBean member=new MemberBean();
	 MemberService service=MemberServiceImpl.getInstance();
	 Map<?, ?> map=null;
	 PageProxy pxy=new PageProxy(request);
	 Command cmd=new Command();
	 pxy.setPageSize(5);
     pxy.setBlockSize(5);
	switch (request.getParameter(Action.CMD)) {
	case Action.MOVE:
		DispatcherServlet.send(request, response);
		break;
	case Action.JOIN:
		 System.out.println("join 진입");
		map=ParamsIterator.execute(request);
		member.setId((String)map.get("id"));
		member.setPassword((String)map.get("password"));
		member.setName((String)map.get("name"));
		member.setSsn((String)map.get("ssn"));
		member.setRegdate((String)map.get("regdate"));
		member.setPhone((String)map.get("phone"));
		member.setEmail((String)map.get("email"));
		member.setProfile((String)map.get("profile"));
		
		String[] subjects=((String)map.get("subject")).split(",");
		
		List<MajorBean> list=new ArrayList<>();
		
		MajorBean major=null;
		for(int i=0;i<subjects.length;i++){
			major= new MajorBean();
			major.setMajor_id(String.valueOf((int)((Math.random() * 9999)+1000)));
			major.setTitle((String)map.get("name"));
			major.setSubjId(subjects[i]);
			major.setId((String)map.get("id"));
			list.add(major);
		}
		Map<String,Object>tempMap=new HashMap<>();
		tempMap.put("member", member);
		tempMap.put("major", list);
		String rs=service.addMember(tempMap);
		Separator.cmd.setDir("common");
		Separator.cmd.process();
		System.out.println("id"+map.get("id"));
		DispatcherServlet.send(request, response);
		break;
	  case Action.LIST:
	         System.out.println("Member List Enter");
      	     pxy.setTheNumberOfRows(Integer.parseInt(service.countMembers(cmd)));
	         pxy.setPageNumber(Integer.parseInt(request.getParameter("pageNumber")));
	         pxy.execute(BlockHandler.attr(pxy), service.list(PageHandler.attr(pxy)));
	         DispatcherServlet.send(request, response);
	         break;
	  case Action.UPDATE:
		  cmd.setSearch(request.getParameter("id"));
		  service.modify(service.findById(cmd));
		  System.out.println("member update Enter");
		  	 DispatcherServlet.send(request, response);
		  	break;
	  case Action.SEARCH: 
		  System.out.println("member search");
		  map=ParamsIterator.execute(request);
		   pxy.setTheNumberOfRows(Integer.parseInt(service.countMembers(cmd)));
	           cmd=PageHandler.attr(pxy);
	           cmd.setColumn("name");
	           cmd.setSearch(String.valueOf(map.get("search")));
	           request.setAttribute("list", service.findByName(cmd));
	     	   DispatcherServlet.send(request, response);
		  break;
	  case Action.DELETE:
		  cmd.setSearch(request.getParameter("id"));
		   	System.out.println("member delete Enter");
		   	response.sendRedirect(request.getContextPath()+"/member.do?action=list&page=member_list&pageNumber=1");
		  	break;
	  case Action.DETAIL:
		  cmd.setSearch(request.getParameter("id"));
		  request.setAttribute("student",  service.findById(cmd));
		  System.out.println("member detail Enter");
		  DispatcherServlet.send(request, response);
		  break;
		}
  	}
 }