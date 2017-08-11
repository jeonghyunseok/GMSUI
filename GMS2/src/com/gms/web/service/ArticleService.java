package com.gms.web.service;

import java.util.List;

import com.gms.web.domain.ArticleBean;

public interface ArticleService {
	public String write(ArticleBean bean);

	public List<ArticleBean> list();

	public List<ArticleBean> findById(String id);

	public int countAriticle();

	public ArticleBean findByseq(String seq);

	public String modify(ArticleBean article);

	public String remove(String id);
}
