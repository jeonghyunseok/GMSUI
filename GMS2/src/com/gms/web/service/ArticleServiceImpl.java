package com.gms.web.service;

import java.util.List;

import com.gms.web.dao.ArticleDAOImpl;
import com.gms.web.domain.ArticleBean;

public class ArticleServiceImpl implements ArticleService {
	public static ArticleServiceImpl getInstance() {
		return new ArticleServiceImpl();
	}

	private ArticleServiceImpl() {
	}

	@Override
	public String write(ArticleBean bean) {
		return (ArticleDAOImpl.getInstance().insert(bean).equals("1")) ? "성공" : "다시";
	}

	@Override
	public List<ArticleBean> list() {
		return ArticleDAOImpl.getInstance().selectAll();
	}

	@Override
	public List<ArticleBean> findById(String id) {

		return ArticleDAOImpl.getInstance().selectById(id);
	}

	@Override
	public ArticleBean findByseq(String seq) {

		return ArticleDAOImpl.getInstance().selectBySeq(seq);
	}

	@Override
	public String modify(ArticleBean bean) {

		return ArticleDAOImpl.getInstance().update(bean).equals("1") ? "성공" : "실패";
	}

	@Override
	public String remove(String seq) {

		return (ArticleDAOImpl.getInstance().delete(seq).equals("1")) ? "성공" : "다시";
	}

	@Override
	public int countAriticle() {

		return ArticleDAOImpl.getInstance().count();
	}

}
