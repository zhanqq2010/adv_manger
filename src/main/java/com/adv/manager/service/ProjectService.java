package com.adv.manager.service;

import java.util.List;

import com.adv.manager.po.AdvProject;
import com.adv.manager.po.ChannelProject;
import com.adv.manager.po.ProductProject;

public interface ProjectService {

	/**
	 * 查询所有广告厂商项目
	 * @param username 登录名
	 * @return
	 * @throws Exception
	 */
	public List<ProductProject> queryProductProjects(String username) throws Exception;
	/**
	 * 查询所有渠道商项目
	 * @param username 登录名
	 * @return
	 * @throws Exception
	 */
	public List<ChannelProject> queryChannelProjects(String username) throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<AdvProject> queryAdvProjects() throws Exception;
	
	/**
	 *  根据广告厂商的登录名添加项目
	 * @param username  登录名
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public int addProductProject(ProductProject project)  throws Exception;
	public int addAdvProject(AdvProject project)  throws Exception;
	/**
	 * 
	 * @param project
	 * @throws Exception
	 */
	public void delProductProjectByPid(String pid)  throws Exception;
	/**
	 * 根据渠道商的登录名添加项目
	 * @param username 登录名
	 * @param project  
	 * @return
	 * @throws Exception
	 */
	public int addChannelProject(ChannelProject project)  throws Exception;
	
	/**
	 * 根据渠道项目id查询项目
	 * @param pid  渠道项目id
	 * @return
	 * @throws Exception
	 */
	public ChannelProject queryChannelProject(String pid) throws Exception;
	
	/**
	 * 根据广告厂商项目id查询项目
	 * @param pid 广告厂商项目id
	 * @return 
	 * @throws Exception
	 */
	public ProductProject queryProductProject(String pid) throws Exception;
	
	/**
	 * 根据渠道项目id更新项目
	 * @param pidChannelProjects
	 * @return
	 */
	public int updateChannelProject(String pid,ChannelProject project) throws Exception;
	
	
	/**
	 * 根据厂商项目id更新项目
	 * @param pid
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public int updateProductProject(String pid, ProductProject project) throws Exception;

	
	/**
	 * 根据广告厂商的pid查询apk下载链接地址
	 * @param pid 广告厂商的项目id
	 * @return
	 * @throws Exception
	 */
//	public ProductProject queryApkDownloadUrlByProductPid(String pid) throws Exception;
	
	/**
	 * 添加访问次数记录
	 * @param record
	 * @return
	 * @throws Exception
	 */
//	public int addDownloadRecord(DownloadRecord record) throws Exception;
}
