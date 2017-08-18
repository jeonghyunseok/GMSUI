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

import com.gms.web.constants.Action;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudentBean;
import com.gms.web.service.MemberService;
import com.gms.web.service.MemberServiceImpl;
import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.ParamsIterator;
import com.gms.web.util.Separator;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;



@WebServlet({"/member.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	
    
  @SuppressWarnings("unused")
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 Separator.init(request);
	 MemberBean member=new MemberBean();
	 MemberService service=MemberServiceImpl.getInstance();
	 
	switch (request.getParameter(Action.CMD)) {
	case Action.MOVE:
		DispatcherServlet.send(request, response);
		break;
	case Action.JOIN:
		 System.out.println("join 진입");
		Map<?, ?> map=ParamsIterator.execute(request);
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
		Separator.cmd.setdir("common");
		Separator.cmd.process();
		System.out.println("id"+map.get("id"));
		DispatcherServlet.send(request, response);
		break;
	case Action.LIST:
		System.out.println("Member List Enter");
		
		@SuppressWarnings("unchecked")
		List<StudentBean> memberlist=(List<StudentBean>)service.getMembers();
		
		System.out.println("DB에서 가져온 Member List"+memberlist);

		request.setAttribute("prevBlock", "0");
		request.setAttribute("pageNumber", request.getParameter("pageNumber"));
		request.setAttribute("list",memberlist);
		
		request.setAttribute("theNumberOfPages", memberlist.size()/5);
		request.setAttribute("startPage","1");
		
		int theNumberOfPages=
				(memberlist.size()/5!=0)?
						memberlist.size()/5+1
						:memberlist.size()/5;
		System.out.println("페이지 수"+theNumberOfPages);
		
		request.setAttribute("theNumberOfPages", theNumberOfPages);
		request.setAttribute("endPage", String.valueOf(theNumberOfPages));
		DispatcherServlet.send(request, response);

		break;
	default:
		break;
	}
}
 }


