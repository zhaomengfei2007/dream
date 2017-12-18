package com.chuangjian.web.action;

import java.util.List;

import com.chuangjian.common.RetCode;
import com.chuangjian.entity.City;
import com.chuangjian.entity.District;
import com.chuangjian.entity.Province;

public class RegionAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Province province;
	private City city;
	private District district;
	private List<Province> provinceList;
	private List<City> cityList;
	private List<District> districtList;
	
	public String toSelect(){
		try {
			provinceList=provinceService.SelectProvince();
			cityList=cityService.getCityList();
			districtList=districtService.getDistrictList();
		} catch (Exception e) {
			log.error("toSelect is bug : {}",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getCityListByProvince(){
		try {
			cityList=cityService.getCityListByProvince(province);
			resultMap.put("retcode", RetCode.SUCCESS);
			resultMap.put("cityList", cityList);
		} catch (Exception e) {
			log.error("getCityListByProvince is bug : {}",e);
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", "获取省份信息失败，请刷新重试。");
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getDistrictListByCity(){
		try {
			districtList=districtService.getDistrictListByCity(city);
			resultMap.put("retcode", RetCode.SUCCESS);
			resultMap.put("districtList", districtList);
		} catch (Exception e) {
			log.error("getDistrictListByCity is bug : {}",e);
			resultMap.put("retcode", RetCode.UNKOWN_WRONG);
			resultMap.put("retmsg", "获取省份信息失败，请刷新重试。");
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public List<Province> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<Province> provinceList) {
		this.provinceList = provinceList;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public List<District> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<District> districtList) {
		this.districtList = districtList;
	}
}
