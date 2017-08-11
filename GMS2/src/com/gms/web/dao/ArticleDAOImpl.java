package com.gms.web.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gms.web.constants.DB;
import com.gms.web.constants.SQL;
import com.gms.web.constants.Vendor;
import com.gms.web.domain.ArticleBean;
import com.gms.web.factory.DatabaseFactory;

public class ArticleDAOImpl implements ArticleDAO {
	public static ArticleDAOImpl getInstance() {
		return new ArticleDAOImpl();
	}

	private ArticleDAOImpl() {
	};

	@Override
	public String insert(ArticleBean bean) {
		int rs = 0;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD)
					.getConnection().prepareStatement(SQL.BOARD_INSERT);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContent());
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(rs);
	}

	@Override
	public List<ArticleBean> selectAll() {
		List<ArticleBean> list = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection()
					.prepareStatement(SQL.BOARD_LIST).executeQuery();

			ArticleBean bean = null;
			while (rs.next()) {
				bean = new ArticleBean();
				bean.setArticleSeq(rs.getInt(DB.BOARD_ARTICLE_SEQ));
				bean.setId(rs.getString(DB.BOARD_ID));
				bean.setTitle(rs.getString(DB.BOARD_TITLE));
				bean.setContent(rs.getString(DB.BOARD_CONTENT));
				bean.setRegdate(rs.getString(DB.BOARD_REGDATE));
				bean.setHitcount(Integer.parseInt(rs.getString(DB.BOARD_HITCOUNT)));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ArticleBean> selectById(String id) {
		List<ArticleBean> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD)
					.getConnection().prepareStatement(SQL.BOARD_SELECTBYID);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			ArticleBean bean = null;
			while (rs.next()) {
				bean = new ArticleBean();
				bean.setArticleSeq(Integer.parseInt((rs.getString(DB.BOARD_ARTICLE_SEQ))));
				bean.setId(rs.getString(DB.MEMBER_ID));
				bean.setTitle(rs.getString(DB.BOARD_TITLE));
				bean.setContent(rs.getString(DB.BOARD_CONTENT));
				bean.setRegdate(rs.getString(DB.BOARD_REGDATE));
				bean.setHitcount(Integer.parseInt(rs.getString(DB.BOARD_HITCOUNT)));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int count() {
		int count = 0;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection()
					.prepareStatement(SQL.MEMBER_COUNT).executeQuery();

			if (rs.next()) {
				count = Integer.parseInt(rs.getString("count"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public ArticleBean selectBySeq(String seq) {
		ArticleBean bean = new ArticleBean();
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD)
					.getConnection().prepareStatement(SQL.BOARD_SELECTBYSEQ);
			pstmt.setString(1, seq);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new ArticleBean();
				bean.setArticleSeq(Integer.parseInt((rs.getString(DB.BOARD_ARTICLE_SEQ))));
				bean.setId(rs.getString(DB.MEMBER_ID));
				bean.setTitle(rs.getString(DB.BOARD_TITLE));
				bean.setContent(rs.getString(DB.BOARD_CONTENT));
				bean.setRegdate(rs.getString(DB.BOARD_REGDATE));
				bean.setHitcount(Integer.parseInt(rs.getString(DB.BOARD_HITCOUNT)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public String update(ArticleBean bean) {
		ArticleBean temp = selectBySeq(String.valueOf(bean.getArticleSeq()));
		String title = (bean.getTitle().equals("")) ? temp.getTitle() : bean.getTitle();
		String content = (bean.getTitle().equals("")) ? temp.getContent() : bean.getContent();
		String rs = "";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD)
					.getConnection().prepareStatement(SQL.BOARD_UPDATE);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, String.valueOf(bean.getArticleSeq()));
			rs = String.valueOf(pstmt.executeUpdate());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String delete(String seq) {
		String rs = "";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD)
					.getConnection().prepareStatement(SQL.BOARD_DELETE);
			pstmt.setString(1, seq);
			rs = String.valueOf(pstmt.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
