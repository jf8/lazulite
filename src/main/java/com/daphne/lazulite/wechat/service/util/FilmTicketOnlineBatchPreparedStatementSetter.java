/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service.util;

import com.madhouse.daphne.service.impl.JdbcBatchService;
import com.madhouse.daphne.utils.CommonUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * 线上电影票批量插入时的设置函数
 * @ClassName: FilmTicketOnlineBatchPreparedStatementSetter 
 * @author Walter.xu
 * @date 2015年7月15日 下午2:35:49
 */
public class FilmTicketOnlineBatchPreparedStatementSetter extends AbstractBatchPreparedStatementSetter{
	private JdbcBatchService jdbcBatchService;
	/**
	 * @param activityID
	 */
	public FilmTicketOnlineBatchPreparedStatementSetter(Integer activityID, JdbcBatchService jdbcBatchService) {
		super(activityID);
		this.jdbcBatchService = jdbcBatchService;
	}
	/**
	 * insert into we_film_ticket_offline(id,order_code,member_name,source,num_of_ticket,is_send,is_valid,create_time,activity_id) <br>
	 * values(?,?,?,?,?,?,?,?)
	 */
	@Override
	public void setValues(PreparedStatement ps, int arg1) throws SQLException {
		String line = super.getLine(arg1);
		String[] args = line.split(",");
		if (args.length<4) {
			return ;
		}
		ps.setString(1, args[0].trim()); // order_code
		ps.setString(2, args[1].trim()); // member_name
		ps.setString(3, args[2].trim()); // source
		ps.setInt(4, CommonUtils.parseInt(args[3])); // num_of_ticket
		// update by walter in 2015/8/6. all online default sented.
		ps.setInt(5, 1); // is_send
		boolean isValid = jdbcBatchService.checkOrderCodeValidCallBack(args[0].trim(), args[1].trim());
		ps.setInt(6, isValid?1:0); // is_valid
		ps.setTimestamp(7, new Timestamp(super.currentTimestamp)); //create_time
		ps.setInt(8, super.activityID); //acitity_id
	}

}
