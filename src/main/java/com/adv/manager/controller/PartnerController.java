package com.adv.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adv.manager.po.Partner;
import com.adv.manager.service.PartnerService;

@Controller
@RequestMapping("partner")
public class PartnerController {

	@Autowired PartnerService service;
	
	@RequestMapping("/queryPartnerByType/{type}")
	public String queryAllProducts(@PathVariable("type") int type ,Model model) throws Exception{
		List<Partner> partners = service.queryPartnersByType(type);
		if(partners != null){
			model.addAttribute("partners", partners);
			model.addAttribute("type",type);
			
			if(type == 1){
				model.addAttribute("typeDescription","手机渠道商");
			}else if(type == 2){
				model.addAttribute("typeDescription","广告厂商");
			}else{
				model.addAttribute("typeDescription","合作伙伴");
			}
		}
		return "partner/partner";
	}
	
	
	@RequestMapping("/goAddPartner/{type}")
	public String goAddPartner(@PathVariable("type") int type,Model model) throws Exception{
		model.addAttribute("option","add");
		model.addAttribute("type",type);
		if(type == 1){
			model.addAttribute("typeDescription","手机渠道商");
		}else if(type == 2){
			model.addAttribute("typeDescription","广告厂商");
		}else{
			model.addAttribute("typeDescription","合作伙伴");
		}
		return "partner/addPartner";
	}
	
	/**
	 * 创建合作伙伴
	 * @param partner
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/createPartner")
	public String createPartner(Partner partner)throws Exception{
		int id = service.addPartner(partner);
		return "redirect:/partner/queryPartnerByType/" + partner.getType();
	}
	
/*	@RequestMapping("/dealPartnerOpt/{type}")
	public String dealPartnerOptioin(@PathVariable("type") int type, String option,Partner partner) throws Exception{
		String url = "";
		partner.setCreatetime(new Date(System.currentTimeMillis()));
		if("edit".equals(option)){
			url = updatePartner(partner);
		}else if("add".equals(option)){
			url = createPartner(partner,type);
		}
		return url ;
	}
*/	
	/**
	 * 批量删除合作伙伴  
	 * @return
	 */
	@RequestMapping("/delPartners/{type}")
	public String delPartners(@PathVariable("type") String type, String[] partnerNames){
		
		if(partnerNames != null && partnerNames.length > 0){
			for(String partnerName : partnerNames){
				service.delPartnerByUsername(partnerName);
			}
		}
		return "redirect:/partner/queryPartnerByType/" + type;
	}
	/**
	 * 批量删除合作伙伴  
	 * @return
	 */
	@RequestMapping("/delPartner/{username}/{type}")
	public String delPartner(@PathVariable("username") String username, @PathVariable("type") String type){
		service.delPartnerByUsername(username);
		return "redirect:/partner/queryPartnerByType/" + type;
	}
	
	
	
	
	@RequestMapping("/goEditPartner/{username}")
	public String goEditPartner(@PathVariable("username") String username,Model model) throws Exception{
		Partner partner = service.queryOnePartner(username);
		if(partner != null){
			model.addAttribute("partner", partner);
			Integer type = partner.getType();
			model.addAttribute("option","edit");
			if(type == 1){
				model.addAttribute("typeDescription","手机渠道商");
			}else if(type == 2){
				model.addAttribute("typeDescription","广告厂商");
			}else{
				model.addAttribute("typeDescription","合作伙伴");
			}
		}
		return "partner/editPartner";
	}
	
	@RequestMapping("/updatePartner")
	public String updatePartner(Partner partner)throws Exception{
		service.updatePartner(partner.getUsername(), partner);
		return "redirect:/partner/queryPartnerByType/" + partner.getType();
	}
	

	
}
