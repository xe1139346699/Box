/*
 * 提醒类serveice
 */
package com.TB.TBox.note.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TB.TBox.note.bean.Warn;
import com.TB.TBox.note.mapper.EvaluateMapper;
import com.TB.TBox.note.mapper.WarnMapper;
import com.TB.base.mybatisUtils.SessionFactory;

@Service
public class WarnService {
	private SessionFactory sessionFactory;
	private Logger log = Logger.getLogger(EvaluateMapper.class);
	private WarnMapper warnmapper;
	@Autowired
	private Warn warn;
	/*
	 * set上的注解注入
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 设置提醒字条
	 * @param warn
	 */
	public void setWarn(Warn warn){
		SqlSession sqlSession = sessionFactory.getSession();
		warnmapper = sqlSession.getMapper(WarnMapper.class);
		try {
			warnmapper.addWarn(warn);
			sqlSession.commit();
			log.debug("添加成功");
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
	
	/**
	 * 按时间查找提醒字条
	 * @param warn
	 */
	public List<Warn> sehWarn(String date){
		SqlSession sqlSession = sessionFactory.getSession();
		warnmapper = sqlSession.getMapper(WarnMapper.class);
		List<Warn> warnList = new ArrayList<Warn>();
		try {
			warnList = warnmapper.selWarn(date);
			log.debug("查找成功");
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
		return warnList;
	}
	/**
	 * 按id删除提醒字条
	 * @param warn
	 */
	public void delWarn(int wid){
		SqlSession sqlSession = sessionFactory.getSession();
		warnmapper = sqlSession.getMapper(WarnMapper.class);
		try {
			warnmapper.delWarn(wid);;
			sqlSession.commit();
			log.debug("删除成功");
		} finally {
			// TODO: handle finally clause
			sqlSession.close();
		}
	}
}
