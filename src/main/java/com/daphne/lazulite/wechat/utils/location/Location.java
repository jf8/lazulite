/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.utils.location;
/**
 * 位置对象
 * @author TangMj
 *
 */
public class Location {
	private String lat;
	private String lng;
	private boolean isPrecise;
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public boolean isPrecise() {
		return isPrecise;
	}
	public void setPrecise(boolean isPrecise) {
		this.isPrecise = isPrecise;
	}
	@Override
	public String toString() {
		return "Location [lat=" + lat + ", lng=" + lng + ", isPrecise="
				+ isPrecise + "]";
	}
}
