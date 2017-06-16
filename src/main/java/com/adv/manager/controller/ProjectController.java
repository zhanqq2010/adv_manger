package com.adv.manager.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adv.manager.exception.CustomException;
import com.adv.manager.po.ChannelProject;
import com.adv.manager.po.Partner;
import com.adv.manager.po.ProductProject;
import com.adv.manager.service.PartnerService;
import com.adv.manager.service.ProjectService;
import com.adv.manager.util.CommonUtil;
import com.adv.manager.util.GetApkInfo;
import com.adv.manager.util.Plupload;
import com.adv.manager.util.PluploadUtil;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService service;
	
	@Autowired
	private PartnerService partnerService;
	
	
	@Value("#{configProperties['uploadFile.saveApkUrl']}") 
	private String saveApkUrl;
	@Value("#{configProperties['uploadFile.saveIconUrl']}") 
	private String saveIconUrl;
	

	@RequestMapping("/goProject/{partnerName}/{type}")
	public String goProject(@PathVariable("partnerName") String partnerName,
			@PathVariable("type") Integer type, Model model) throws Exception {
		model.addAttribute("partnerName", partnerName);
		if (type == 1) {
			model.addAttribute("typeDescription","手机渠道商");
			List<ChannelProject> channelProjects = service.queryChannelProjects(partnerName);
			model.addAttribute("channelProjects", channelProjects);
			return "project/channelProject";
		} else if (type == 2) {
			model.addAttribute("typeDescription","广告厂商");
			List<ProductProject> productProjects = service.queryProductProjects(partnerName);
			model.addAttribute("productProjects", productProjects);
			return "project/productProject";
		}

		return "home";
	}

	@RequestMapping("/goAddProductProject/{partnerName}")
	public String goAddProductProject(@PathVariable("partnerName") String partnerName, Model model) throws Exception{
		String pid = CommonUtil.createPid();
		model.addAttribute("pid", pid);
		model.addAttribute("partnerName", partnerName);
		return "project/addProductProject";
	}

	@RequestMapping("/goAddChannelProject/{partnerName}")
	public String goAddChannelProject(@PathVariable("partnerName") String partnerName, Model model) throws Exception{
		String pid = CommonUtil.createPid();
		List<Partner> products = partnerService.queryPartnersByType(2);
		model.addAttribute("pid", pid);
		model.addAttribute("partnerName", partnerName);
		if(products != null){
			model.addAttribute("products", products);
		}
		return "project/addChannelProject";
	}	

	/**
	 * 添加渠道商项目
	 * @param project
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/createChannelProject/{partnerName}")
	public String createChannelProject(@PathVariable("partnerName")String partnerName, ChannelProject project) throws Exception{
		int i = service.addChannelProject(project);
		if(i < 0){
			throw new CustomException("项目已经存在");
		}
		return "redirect:/project/goProject/" + partnerName + "/1";
	}
	
	@RequestMapping("/createProductProject/{partnerName}")
	public String createProductProject(@PathVariable("partnerName")String partnerName, ProductProject project) throws Exception{
		int addProductProject = service.addProductProject(project);
		return "redirect:/project/goProject/" + partnerName + "/2";
	}
	
	@RequestMapping("/delProductProject/{partnerName}/{pid}")
	public String delProductProjectByPid(@PathVariable("partnerName")String partnerName, @PathVariable("pid")String pid) throws Exception{
		service.delProductProjectByPid(pid);
		return "redirect:/project/goProject/" + partnerName + "/2";
	}
	
	
	
	@RequestMapping("/updateChannelProject/{partnerName}/{pid}")
	public String updateChannelProject(@PathVariable("partnerName")String partnerName,@PathVariable("pid")String pid, ChannelProject project) throws Exception{
		service.updateChannelProject(pid, project);
		return "redirect:/project/goProject/" + partnerName + "/1";
	}
	


	@RequestMapping("/updateProductProject/{partnerName}/{pid}")
	public String updateProductProject(@PathVariable("username")String partnerName,@PathVariable("pid")String pid, ProductProject project) throws Exception{
		service.updateProductProject(pid, project);
		return "redirect:/project/goProject/" + partnerName + "/2";
	}
	

	

	/**
	 * 创建apk下载链接
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/createDownloadUrl")
	public String createDownloadUrl(Model model) throws Exception{
		List<Partner> products = partnerService.queryPartnersByType(2);
		List<Partner> channels = partnerService.queryPartnersByType(1);
		if(products != null && products.size() > 0){
			model.addAttribute("products", products);
		}
		if(channels != null && channels.size() > 0){
			model.addAttribute("channels", channels);
		}
		return "downloadurl";
	}
	
	/**
	 * 
	 * @param productPid
	 * @param channelPid
	 * @param request
	 * @param response
	 * @param attr
	 * @throws Exception
	 */
	/*@RequestMapping("/downloadUrl/{productPid}/{channelPid}" )
	public void downloadUrl(@PathVariable("productPid") String productPid,@PathVariable("channelPid") String channelPid, HttpServletRequest request, HttpServletResponse response,RedirectAttributes attr) throws Exception{
		//创建DownloadRecords记录对象
		String ipAddress = NetworkUtil.getIpAddress(request);
		String country = NetworkUtil.getAddresses("ip=" + ipAddress, "utf-8");
		DownloadRecord record = new DownloadRecord();
		Date date = new Date(System.currentTimeMillis());
		record.setAddtime(date);
		record.setIpaddress(ipAddress);
		record.setCountry(country);
		record.setChannelpid(channelPid);
		record.setProductpid(productPid);
		ProductProject project = service.queryApkDownloadUrlByProductPid(productPid);
		record.setApkname(project.getAppname());
		
		
		//根据productPid和channelPid查询到对应的厂商名称
		ChannelProject channelProject = service.queryChannelProject(channelPid);
		ProductProject productProject = service.queryProductProject(productPid);
		record.setProductname(channelProject.getPartnername());
		record.setChannelname(productProject.getPartnername());
		record.setProductprojectname(productProject.getPname());
		record.setChannelprojectname(channelProject.getPname());
		
		//添加记录到数据库
		service.addDownloadRecord(record);
		
		//根据channelPid
		Partner partner = partnerService.queryOnePartner(channelProject.getPartnername());
		//数据透传协议  www.xxx.com?program=pg1&IP=47.91.137.252&country=CN&dt=2017-01-10 14:03:49
		if(partner != null ){
			String datasyncaddress = partner.getDatasyncaddress();
			if(datasyncaddress != null && !datasyncaddress.equals("")){
				HttpTookit.sendGet(datasyncaddress, "program=" + channelProject.getPname() + "&IP=" + ipAddress + "&country="+ country + "&dt=" + date.toLocaleString());
			}
		}
		//返回apk下载的真实地址  redirect forward
//		return "redirect:"  + project.getUrl();
//		return "redirect: http://47.91.137.252"+ project.getUrl();
//		return "redirect: http://192.168.0.222:8080"+ project.getUrl();
//		response.sendRedirect("http://192.168.0.222:8080"+URLEncoder.encode(project.getUrl(), "utf-8") );
		response.sendRedirect("http://192.168.0.222:8080"+project.getUrl());
		response.sendRedirect("http://www.huiyiyoutech.com"+project.getUrl());
	}*/
	
	/**
	 * 编辑渠道项目
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/goEditChannelProject/{pid}/{username}")
	public String goEditChannelProject(@PathVariable("pid") String pid ,@PathVariable("username") String username ,Model model) throws Exception{
		ChannelProject project = service.queryChannelProject(pid);
		List<Partner> products = partnerService.queryPartnersByType(2);
		model.addAttribute("username", username);
		if(project != null){
			model.addAttribute("project", project);
		}
		
		if(products != null && products.size() > 0){
			model.addAttribute("products", products);
		}
		return "editChannelProject";
	}
	
	
	/**
	 * 编辑广告厂商项目
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/goEditProjectProject/{pid}")
	public String goEditProductProject(@PathVariable("pid") String pid ,Model model) throws Exception{
		ProductProject project = service.queryProductProject(pid);
		if(project != null){
			model.addAttribute("project", project);
		}
		return "editChannelProject";
	}
	/**
	 * 编辑广告厂商项目
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editProductProject/{pid}")
	public String editPartnerProject(@PathVariable("pid") String pid ,Model model) throws Exception{
		//根据广告厂商的项目id查询项目
		
		ProductProject project = service.queryProductProject(pid);
		if(project != null){
			model.addAttribute("project", project);
		}
		return "project/editProductProject";
	}
	
	
	
	@RequestMapping("/queryProductProjectsByUsername/{username}")
	public @ResponseBody List<ProductProject> queryProductProjectsByUsername(@PathVariable("username") String username) throws Exception{
		List<ProductProject> productProjects = service.queryProductProjects(username);
		return productProjects;
	}
	
	@RequestMapping("/queryChannelProjectsByUsername/{username}")
	public @ResponseBody List<ChannelProject> queryChannelProjectsByUsername(@PathVariable("username") String username) throws Exception{
		List<ChannelProject> channelProjects = service.queryChannelProjects(username);
		return channelProjects;
	}
	
	// 接收上传文件

//	@RequestMapping(value="/uploadFile",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@RequestMapping("/uploadFile")
	public @ResponseBody Map<String, String> uploadFile(Plupload plupload,HttpServletRequest request, HttpServletResponse response) throws Exception {
//		@RequestParam("pic") CommonsMultipartFile pic
//		StringBuffer sb = new StringBuffer();
		
		Map<String, String> apkInfoMap = null;
		 plupload.setRequest(request);  
		  //文件存储路径  
	        File dir = new File(saveApkUrl);  
	          
//	        System.out.println(dir.getPath());  
	        try {  
	            //上传文件  
	        	// 为了避免文件名重复，在文件名前加UUID
	    		String uuid = UUID.randomUUID().toString().replace("-", "") ;
	    		String name = plupload.getName();
	    		String suffix = ".apk";
	    		if(name != null && !"".equals(name) && name.lastIndexOf(".") > 0){
	    			suffix = name.substring(name.lastIndexOf("."), name.length());
	    		}
//	    		String uuidFileName = uuid + plupload.getName();
	    		String uuidFileName = uuid + suffix;
	            PluploadUtil.upload(plupload, dir,uuidFileName);  
	            //判断文件是否上传成功（被分成块的文件是否全部上传完成）  
	            if (PluploadUtil.isUploadFinish(plupload)) {  
	                System.out.println(plupload.getName() + "----"); 
	                apkInfoMap = GetApkInfo.getApkInfo(saveApkUrl, uuidFileName,saveIconUrl);
	        		apkInfoMap.put("apkDownloadUrl" , "/apk/" + uuidFileName);
	        		apkInfoMap.put("apkIconUrl" , "/icon/" + apkInfoMap.get("iconPath"));
	        		System.out.println("apk解析结果：" + apkInfoMap);
	            }  
	        } catch (IllegalStateException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
		// 设置文件保存的本地路径	
//		System.out.println(saveApkUrl + "--------------------------" + saveIconUrl);
//		String fileName = pic.getOriginalFilename();
//		String fileName = "aaaa.apk";

//		String fileType = fileName.split("[.]")[1];

		// 为了避免文件名重复，在文件名前加UUID
//		String uuid = UUID.randomUUID().toString().replace("-", "");
//		String uuidFileName = uuid + fileName;
//		File f = new File(saveApkUrl  + uuid + "." + fileType);
		// 将文件保存到服务器
//		FileUtil.upFile(pic.getInputStream(), uuidFileName, saveApkUrl);
		//解析apk文件
		
//		Map<String, String> apkInfoMap = GetApkInfo.getApkInfo(saveApkUrl, uuidFileName,saveIconUrl);
//		 
//		System.out.println("apkdownloadurl :" + "/uploadFiles/" + uuidFileName);
//		apkInfoMap.put("apkDownloadUrl" , "/uploadFiles/" + uuidFileName);
//		apkInfoMap.put("apkIconUrl" , "/uploadFiles/apkicon/" + uuidFileName);
//		for(Map.Entry<String, String> entry:apkInfoMap.entrySet()){    
//			  System.out.println(entry.getKey()+"--->"+entry.getValue());    
//			sb.append(entry.getKey()) .append(":").append(entry.getValue()).append("|");
//		}  
//		 t.setMap(apkInfoMap);
//		Test a = new Test();
//		a.setStr("aaa");
		
		return apkInfoMap;
	}
	
	
}
