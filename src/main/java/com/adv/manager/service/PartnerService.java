package com.adv.manager.service;

import java.util.List;

import com.adv.manager.po.Partner;

public interface PartnerService {

	/**
	 * 
	 * @param type  1 渠道商   2 广告厂商
	 * @return
	 * @throws Exception
	 */
	public List<Partner> queryPartnersByType(int type) throws Exception;
	
	public int addPartner(Partner partner) throws Exception;
	
	public Partner queryOnePartner(String username)  throws Exception;
	
	public int updatePartner(String username,Partner partner)throws Exception;

	public void delPartnerByUsername(String partnerUsername);
}
