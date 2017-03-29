package com.adv.manager.mapper;

import java.util.List;

import com.adv.manager.po.PartnerCustom;


public interface PartnerCustomMapper {
	
	List<PartnerCustom> queryPartnerCustom(int type);
	void delPartnerByUsername(String partnerUsername);
}