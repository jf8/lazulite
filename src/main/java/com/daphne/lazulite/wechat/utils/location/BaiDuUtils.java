/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.daphne.lazulite.wechat.utils.location;

import com.alibaba.fastjson.JSONObject;
import org.sword.lang.HttpUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * 根据地址得到地址的经纬度工具
 * @author TangMj
 *
 */
public class BaiDuUtils {
	private static String baseUrl = "http://api.map.baidu.com/geocoder/v2/?ak=gmRU63QwpkiS7WWHWnr7uIL0";
	/**
	 * 得到百度接口请求地址
	 * @param addressOrLocation
	 * @return
	 * @throws IntrospectionException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private static String getUrl(Object addressOrLocation) throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		/**
		 * 正向地址
		 * http://api.map.baidu.com/geocoder/v2/?address=百度
			&output=json&ak=E4805d16520de693a3fe707cdc962045&callback=showLocation
		 */
		/**
		 * 反向地址
		 * http://api.map.baidu.com/geocoder/v2/?ak=E4805d16520de693a3fe707cdc962045&callback=renderReverse
		 * &location=39.983424,116.322987&output=json&pois=1
		 */
		StringBuffer sb = new StringBuffer(baseUrl);
		Class clazz = addressOrLocation.getClass();
		BeanInfo beanInfo = Introspector.getBeanInfo(addressOrLocation.getClass());
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : pds) {
			String name = propertyDescriptor.getName();
			if(!"class".equals(name)){
				Method getter = propertyDescriptor.getReadMethod();
				getter.setAccessible(true);
				Object value = getter.invoke(addressOrLocation, null);
				if(value!=null){
					sb.append("&").append(name).append("=").append(value).append("&");
				}
			}
		}
		sb = sb.deleteCharAt(sb.lastIndexOf("&"));
		return sb.toString();
	}
	/**
	 * 地址得到经纬度
	 * @param address
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static Location getLocation(BaiDuAddress address) throws IllegalArgumentException, IntrospectionException, IllegalAccessException, InvocationTargetException{
		Location loc = new Location();
		//{"result":{"confidence":80,"level":"商务大厦","location":{"lat":40.056876296398,"lng":116.30783584945},"precise":1},"status":0}
		JSONObject jsonObject = JSONObject.parseObject(HttpUtils.get(getUrl(address)));
		System.out.println(jsonObject);
		JSONObject result = jsonObject.getJSONObject("result");
		if(result!=null){
			JSONObject location = result.getJSONObject("location");
			//String precise = result.getString("precise");
			boolean precise = result.getBoolean("precise");
			BigDecimal lat = (BigDecimal) location.get("lat");
			BigDecimal lng = (BigDecimal) location.get("lng");
			loc.setLat(lat+"");
			loc.setLng(lng+"");
			loc.setPrecise(precise);
		}
		return loc;
	}
	
	/**
	 * 经纬度得到地址
	 * @param baiDu
	 * renderReverse&&renderReverse({"status":0,"result":{"location":{"lng":116.32298703399,"lat":39.983424051248},"formatted_address":"北京市海淀区中关村大街27号1101-08室","business":"中关村,人民大学,苏州街","addressComponent":{"city":"北京市","country":"中国","direction":"附近","distance":"7","district":"海淀区","province":"北京市","street":"中关村大街","street_number":"27号1101-08室","country_code":0},"pois":[{"addr":"北京北京海淀海淀区中关村大街27号（地铁海淀黄庄站A1","cp":"NavInfo","direction":"内","distance":"0","name":"北京远景国际公寓(中关村店)","poiType":"房地产","point":{"x":116.3229458916,"y":39.983610361549},"tel":"","uid":"35a08504cb51b1138733049d","zip":""},{"addr":"海淀区中关村北大街27号","cp":"NavInfo","direction":"附近","distance":"25","name":"中关村大厦","poiType":"房地产","point":{"x":116.32285606105,"y":39.983568897877},"tel":"","uid":"06d2dffdaef1b7ef88f15d04","zip":""},{"addr":"中关村大街29","cp":"NavInfo","direction":"北","distance":"62","name":"海淀医院激光整形美容部","poiType":"医疗","point":{"x":116.32317046798,"y":39.983016046485},"tel":"","uid":"b1c556e81f27cb71b4265502","zip":""},{"addr":"中关村大街27号中关村大厦1层","cp":"NavInfo","direction":"附近","distance":"1","name":"中国人民财产保险中关村营业部","poiType":"金融","point":{"x":116.32298182382,"y":39.983416864194},"tel":"","uid":"060f5e53137d20d7081cc779","zip":""},{"addr":"北京市海淀区","cp":"NavInfo","direction":"东北","distance":"58","name":"北京市海淀医院-输血科","poiType":"医疗","point":{"x":116.322685383,"y":39.983092063819},"tel":"","uid":"cf405905b6d82eb9b55f1e89","zip":""},{"addr":"北京市海淀区中关村大街27号中关村大厦二层","cp":"NavInfo","direction":"附近","distance":"0","name":"眉州东坡酒楼(中关村店)","poiType":"美食","point":{"x":116.32298182382,"y":39.983423774823},"tel":"","uid":"2c0bd6c57dbdd3b342ab9a8c","zip":""},{"addr":"北京市海淀区中关村大街29号（海淀黄庄路口）","cp":"NavInfo","direction":"东北","distance":"223","name":"海淀医院","poiType":"医疗","point":{"x":116.32199368776,"y":39.982083099537},"tel":"","uid":"fa01e9371a040053774ff1ca","zip":""},{"addr":"北京市海淀区中关村大街28号","cp":"NavInfo","direction":"西北","distance":"229","name":"海淀剧院","poiType":"休闲娱乐","point":{"x":116.32476945179,"y":39.982622137118},"tel":"","uid":"edd64ce1a6d799913ee231b3","zip":""},{"addr":"海淀黄庄地铁站旁","cp":"NavInfo","direction":"西北","distance":"375","name":"中发电子市场(中关村大街)","poiType":"购物","point":{"x":116.32529945204,"y":39.981537146849},"tel":"","uid":"69130523db34c811725e8047","zip":""},{"addr":"北京市海淀区知春路128号","cp":"NavInfo","direction":"西北","distance":"434","name":"泛亚大厦","poiType":"房地产","point":{"x":116.32600013033,"y":39.981516414381},"tel":"","uid":"d24e48ebb9991cc9afee7ade","zip":""}],"poiRegions":[],"sematic_description":"北京远景国际公寓(中关村店)内0米","cityCode":131}})
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IntrospectionException 
	 * @throws IllegalArgumentException 
	 */
	public static Address getAddress(BaiDuLocation location) throws IllegalArgumentException, IntrospectionException, IllegalAccessException, InvocationTargetException{
		Address address = new Address();
		JSONObject jsonObject = JSONObject.parseObject(HttpUtils.get(getUrl(location)));
		//{"result":{"addressComponent":{"city":"江门市","country":"中国","country_code":0,"direction":"附近","distance":"23","district":"新会区","province":"广东省","street":"仁寿路","street_number":"40号"},"business":"","cityCode":302,"formatted_address":"广东省江门市新会区仁寿路40号","location":{"lat":22.526759102464,"lng":113.04557326474},"poiRegions":[],"sematic_description":"旺角东77米"},"status":0}
		JSONObject result = jsonObject.getJSONObject("result");
		if(result!=null){
			String formatted_address = result.getString("formatted_address");
			address.setAddress(formatted_address);
		}
		return address;
	}
	public static void main(String[] args) throws IllegalArgumentException, IntrospectionException, IllegalAccessException, InvocationTargetException {
		BaiDuAddress baiDu = new BaiDuAddress( "山东省枣庄市市中区君山中路52号购物中心");
		Location location = getLocation(baiDu);
		System.out.println(location);
		BaiDuLocation baiDuLocation = new BaiDuLocation("22.526759095496,113.04557330179");
		Address address = getAddress(baiDuLocation);
		System.out.println(address);
	}
}
