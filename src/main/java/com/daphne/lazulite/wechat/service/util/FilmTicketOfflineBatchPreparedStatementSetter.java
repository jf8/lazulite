/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service.util;

import com.madhouse.daphne.dao.model.Member;
import com.madhouse.daphne.service.impl.JdbcBatchService;
import com.madhouse.daphne.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * 线下电影票批量设置时设置参数函数
 * @ClassName: FilmTicketOfflineBatchPreparedStatementSetter 
 * @author Walter.xu
 * @date 2015年7月15日 下午2:36:17
 */
public class FilmTicketOfflineBatchPreparedStatementSetter extends AbstractBatchPreparedStatementSetter{
	protected transient Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcBatchService jdbcBatchService;
	
	public FilmTicketOfflineBatchPreparedStatementSetter(Integer activityID, JdbcBatchService jdbcBatchService) {
		super(activityID);
		this.jdbcBatchService = jdbcBatchService;
	}

	/**
	 * insert into we_film_ticket_offline(member_id,member_name,num_of_ticket,is_send,is_valid,create_time,acitity_id) <br>
	 * values(?,?,?,?,?,?,?)
	 */
	@Override
	public void setValues(PreparedStatement ps, int arg1) throws SQLException {
		String line = getLine(arg1);
		String[] args = line.split(",");
//		//TODO
//		Integer memberID = CommonUtils.parseInt(args[0]);
//		if (memberID==null) {
//			return ;
//		}
		// format: OpenID,MemberID,MemberNumber,Phone,Name,NumOfTicket,Brand
		String openID = args[0].trim();
		Member member = jdbcBatchService.queryMemberCallBack(openID);
		String memberID = args.length>1?args[1].trim():"";
		String memberName = args.length>4?args[4].trim():"";
		Integer ticketNum = args.length>5?CommonUtils.parseInt(args[5]):0;
		String brand = args.length>6?args[6]:"";
		ps.setString(1, memberID); // member_id
		ps.setString(2, memberName); // member_name
		ps.setInt(3, ticketNum); // num_of_ticket
		ps.setInt(4, 0); // is_send
		int valid = 0;
		boolean isNeedSendTicket = jdbcBatchService.checkMemberNeedSendTicketCallBack(member==null?null:member.getId(), activityID);
		if (isNeedSendTicket) {
			valid = 1;
		}
		ps.setInt(5, valid); // is_valid
		ps.setTimestamp(6, new Timestamp(super.currentTimestamp)); //create_time
		ps.setInt(7, super.activityID); //acitity_id
		ps.setString(8, brand);
		ps.setInt(9, member==null?-1:member.getId());
	}

}
