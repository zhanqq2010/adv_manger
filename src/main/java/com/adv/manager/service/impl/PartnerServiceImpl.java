package com.adv.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adv.manager.mapper.PartnerCustomMapper;
import com.adv.manager.mapper.PartnerMapper;
import com.adv.manager.po.Partner;
import com.adv.manager.service.PartnerService;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired PartnerCustomMapper partnerCustomMapper;
	@Autowired PartnerMapper partnerMapper;
	
	@Override
	public List<Partner> queryPartnersByType(int type) throws Exception {
		return partnerCustomMapper.queryPartnersByType(type);
	}
	

	@Override
	public int addPartner(Partner partner) throws Exception {
		return partnerMapper.insert(partner);
	}


	@Override
	public Partner queryOnePartner(String username) throws Exception {
		
		return partnerMapper.selectByPrimaryKey(username);
	}

	@Override
	public int updatePartner(String username, Partner partner)
			throws Exception {
		partner.setUsername(username);
		return partnerMapper.updateByPrimaryKeyWithBLOBs(partner);
		
	}

	@Override
	public void delPartnerByUsername(String partnerUsername) {
		partnerCustomMapper.delPartnerByUsername(partnerUsername);
	}



	
	
	


	
}
