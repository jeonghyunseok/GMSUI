package com.gms.web.dao;

import java.util.List;

import com.gms.web.domain.ArticleBean;

public interface ArticleDAO {
	public String insert(ArticleBean bean);

	public List<ArticleBean> selectAll();

	public List<ArticleBean> selectById(String id);

	public int count();

	public ArticleBean selectBySeq(String seq);

	public String update(ArticleBean bean);

	public String delete(String seq);
}
