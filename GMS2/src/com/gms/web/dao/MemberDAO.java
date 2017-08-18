package com.gms.web.dao;

import java.util.List;
import java.util.Map;

import com.gms.web.domain.MemberBean;

public interface MemberDAO {
	public String insert(Map<?,?>map);

	public List<?> selectAll();

	public String count();

	public MemberBean selectById(String id);

	public List<?> selectByName(String name);

	public String update(MemberBean memeber);

	public String delete(String id);
}
