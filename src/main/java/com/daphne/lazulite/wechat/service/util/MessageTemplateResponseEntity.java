/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service.util;

import com.madhouse.daphne.dao.model.Member;
import org.sword.wechat4j.message.template.TemplateMsgBody;
import org.sword.wechat4j.message.template.TemplateMsgData;

import java.util.ArrayList;

/**
 * 模板消息类，用于发送模板消息，需实现如下方法<bR>
 * <BR>{@linkplain #setBody}: 设置模板内容，对象中包含所需发送的人，模板ID，以及内容，该ID为对应的微信模板ID
 * <BR>{@linkplain #setMember}: 设置用户信息，该ID为对应的微信模板ID
 * <BR>{@linkplain #setMessage}: 设置消息信息，该ID为对应的微信模板ID
 * @ClassName: MessageTemplateResponseEntity 
 * @author Walter.xu
 * @date 2015年7月28日 下午6:11:36
 */
public class MessageTemplateResponseEntity extends MessageResponseEntity{
	private static final long serialVersionUID = 1L;
	private TemplateMsgBody body ;

	public TemplateMsgBody getBody() {
		return body;
	}

	public void setBody(TemplateMsgBody body) {
		this.body = body;
	}
	public void setTemplateID(String id){
		if (body==null) {
			body = new TemplateMsgBody();
		}
		body.setTemplateId(id);
		body.setUrl("");
	}
	public void setContent(String first, String keyword1, String keyword2, String keyword3, String remark){
		if (body==null) {
			body = new TemplateMsgBody();
		}
		if (body.getData()==null) {
			body.setData(new ArrayList<TemplateMsgData>());
		}
		body.getData().add(new TemplateMsgData("first", first, ""));
		body.getData().add(new TemplateMsgData("keyword1", keyword1, ""));
		body.getData().add(new TemplateMsgData("keyword2", keyword2, ""));
		body.getData().add(new TemplateMsgData("keyword3", keyword3, ""));
		body.getData().add(new TemplateMsgData("remark", remark, ""));
	}
	@Override
	public void setMember(Member member){
		super.setMember(member);
		if (body==null) {
			body = new TemplateMsgBody();
		}
		body.setTouser(super.getOpenID());
		body.setTopcolor("");
	}
	@Override
	public void setOpenID(String openID){
		super.setOpenID(openID);
		if (body==null) {
			body = new TemplateMsgBody();
		}
		body.setTouser(super.getOpenID());
		body.setTopcolor("");
	}
}
