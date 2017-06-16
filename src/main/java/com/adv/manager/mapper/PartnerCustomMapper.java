package com.adv.manager.mapper;

import java.util.List;

import com.adv.manager.po.Partner;


public interface PartnerCustomMapper {
	
	List<Partner> queryPartnersByType(int type);
	void delPartnerByUsername(String partnerUsername);
}