/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service.util;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Batch insertion tools, using for setting parameters in jdbcTemplate batch insert.
 * @ClassName: AbstractBatchPreparedStatementSetter 
 * @author Walter.xu
 * @date 2015年6月25日 上午9:51:13
 */
public abstract class AbstractBatchPreparedStatementSetter implements BatchPreparedStatementSetter {
	/**
	 * 数据行列表，一行为一列数据库记录，以,分开
	 */
	private List<String> lineList = new ArrayList<String>();
	protected long currentTimestamp;
	protected Integer activityID;
	
	/**
	 * 
	 * @param activityID 活动ID
	 */
	public AbstractBatchPreparedStatementSetter(Integer activityID){
		this.currentTimestamp = new Date().getTime();
		this.activityID = activityID;
	}
	
	/**
	 * 添加文件行，用于设置文件列表
	 * @param line
	 */
	public void addLine(String line){
		// 仅行非空时添加
		if (line!=null&&!"".equals(line.trim())) {
			lineList.add(line);
		}
	}
	
	@Override
	public int getBatchSize() {
		return lineList.size();
	}
	/**
	 * 获取所有待插入的数据列表
	 * @return
	 */
	public List<String> getLineList(){
		return lineList;
	}
	/**
	 * 获取待插入的行
	 * @param index
	 * @return
	 */
	public String getLine(int index){
		return lineList.get(index);
	}
}
