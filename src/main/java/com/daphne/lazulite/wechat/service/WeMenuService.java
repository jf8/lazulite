/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.service;

import com.alibaba.fastjson.JSON;
import com.daphne.lazulite.wechat.ButtonKey;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.sword.wechat4j.event.EventType;
import org.sword.wechat4j.exception.WeChatException;
import org.sword.wechat4j.menu.Menu;
import org.sword.wechat4j.menu.MenuButton;
import org.sword.wechat4j.menu.MenuManager;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Service
public class WeMenuService {
	private static Logger logger = Logger.getLogger(WeMenuService.class);



	@Value("${web.nearShopUrl}")
	String nearShopUrl;;

	@Value("${web.personnalCenterUrl}")
	String personnalCenterUrl;;


	@Value("${web.myFavorableUrl}")
	String myFavorableUrl;;

	@Value("${web.toTheMallUrl}")
	String toTheMallUrl;

	private MenuManager manager = new MenuManager();
	 @PostConstruct
	 public void createMunu(){
		  buildMenu();
	 }
	/**
	 * 获取公众号菜单
	 * @return
	 */
	public String getMenu(){

		Menu menu = manager.getMenu();
		System.out.println(menu.getButton().size());
		 return JSON.toJSONString(menu);
	}


	/**
	 * 删除公众号菜单
	 * @return
	 */
	public void delMenu(){
		try {
			manager.delete();
			System.out.println("菜单删除成功");
		} catch (WeChatException e) {
			System.out.println("菜单删除失败");
			e.printStackTrace();
		}
	}



	private void buildMenu(){
		//前往商城
		MenuButton toTheMall= new MenuButton();
		toTheMall.setName("前往商城");
		toTheMall.setType(EventType.view);
		toTheMall.setUrl(toTheMallUrl);
		//附近门店
		MenuButton nearbyShop= new MenuButton();
		nearbyShop.setName("附近门店");
		nearbyShop.setType(EventType.view);
		nearbyShop.setUrl(nearShopUrl);


		List<MenuButton> subBut2 = new ArrayList<MenuButton>();
		subBut2.add(toTheMall);
		subBut2.add(nearbyShop);

		//购物指南
		MenuButton mainBtn1 = new MenuButton();
		mainBtn1.setName("购物指南");
		mainBtn1.setSubButton(subBut2);

		//微信活动
		MenuButton wechatActivity= new MenuButton();
		wechatActivity.setName("微信活动");
		wechatActivity.setType(EventType.click);
		wechatActivity.setKey(ButtonKey.wechatActivity.name());
		//会员活动
		MenuButton memberActivity= new MenuButton();
		memberActivity.setName("会员活动");
		memberActivity.setType(EventType.click);
		memberActivity.setKey(ButtonKey.memberActivity.name());



		List<MenuButton> subBut1 = new ArrayList<MenuButton>();
		subBut1.add(wechatActivity);
		subBut1.add(memberActivity);

		//最新活动
		MenuButton mainBtn2 = new MenuButton();
		mainBtn2.setName("最新活动");
		mainBtn2.setSubButton(subBut1);

		/********************第三个大菜单************************/
		MenuButton personalCenter = new MenuButton();
		personalCenter.setName("会员中心");
		personalCenter.setType(EventType.view);
		personalCenter.setUrl(personnalCenterUrl);

		MenuButton myFavorable = new MenuButton();
		myFavorable.setName("我的优惠");
		myFavorable.setType(EventType.view);
		myFavorable.setUrl(myFavorableUrl);

		/*ViewButton pointExchange = new ViewButton();
		pointExchange.setName("积分兑换");
		pointExchange.setType(VIEW);
		pointExchange.setUrl(pointsExchangeUrl);*/

		MenuButton  contactCustomer = new MenuButton();
		contactCustomer.setName("联系客服");
		contactCustomer.setType(EventType.click);
		contactCustomer.setKey(ButtonKey.contactCustomer.name());


		List<MenuButton> subBut3 = new ArrayList<MenuButton>();
		subBut3.add(personalCenter);
		subBut3.add(myFavorable);
		subBut3.add(contactCustomer);

		//最新活动
		MenuButton mainBtn3 = new MenuButton();
		mainBtn3.setName("个人中心");
		mainBtn3.setSubButton(subBut3);








		List<MenuButton> button = new ArrayList<MenuButton>();
		button.add(mainBtn1);
		button.add(mainBtn2);
		button.add(mainBtn3);
		Menu menu = new Menu();
		menu.setButton(button);

		try {
			manager.create(menu);
			System.out.println("菜单创建成功");
		} catch (WeChatException e) {
			System.out.println("菜单创建失败");
			e.printStackTrace();
		}
	}
}
