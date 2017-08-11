package com.gms.web.dao;

import java.util.List;

import com.gms.web.domain.MemberBean;

public interface MemberDAO {
	public String insert(MemberBean member);

	public List<MemberBean> selectAll();

	public String count();

	public MemberBean selectById(String id);

	public List<MemberBean> selectByName(String name);

	public String update(MemberBean memeber);

	public String delete(String id);
}
