/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.domain;


public class BarCodeInfo {
	/** Parameter name for the message */
    private  String msg;
    /** Parameter name for the barcode type */
    private  String type;
    /** Parameter name for the barcode height */
    private  String height;
    /** Parameter name for the module width */
    private  String mw;
    /** Parameter name for the wide factor */
    private  String wf;
    /** Parameter name for the quiet zone */
    private  String qz;
    /** Parameter name for the human-readable placement */
    private  String hrp;
    /** Parameter name for the output format */
    private  String fmt;
    /** Parameter name for the image resolution (for bitmaps) */
    private  String res;
    /** Parameter name for the grayscale or b/w image (for bitmaps) */
    private  String gray;
    /** Parameter name for the font size of the human readable display */
    private  String hrsize;
    /** Parameter name for the font name of the human readable display */
    private  String hrfont;
    /** Parameter name for the pattern to format the human readable message */
    private  String hrpattern;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getMw() {
		return mw;
	}
	public void setMw(String mw) {
		this.mw = mw;
	}
	public String getWf() {
		return wf;
	}
	public void setWf(String wf) {
		this.wf = wf;
	}
	public String getQz() {
		return qz;
	}
	public void setQz(String qz) {
		this.qz = qz;
	}
	public String getHrp() {
		return hrp;
	}
	public void setHrp(String hrp) {
		this.hrp = hrp;
	}
	public String getFmt() {
		return fmt;
	}
	public void setFmt(String fmt) {
		this.fmt = fmt;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public String getGray() {
		return gray;
	}
	public void setGray(String gray) {
		this.gray = gray;
	}
	public String getHrsize() {
		return hrsize;
	}
	public void setHrsize(String hrsize) {
		this.hrsize = hrsize;
	}
	public String getHrfont() {
		return hrfont;
	}
	public void setHrfont(String hrfont) {
		this.hrfont = hrfont;
	}
	public String getHrpattern() {
		return hrpattern;
	}
	public void setHrpattern(String hrpattern) {
		this.hrpattern = hrpattern;
	}
}
