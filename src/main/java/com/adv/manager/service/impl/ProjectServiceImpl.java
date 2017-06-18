package com.adv.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adv.manager.exception.CustomException;
import com.adv.manager.mapper.AdvProjectMapper;
import com.adv.manager.mapper.AdvProjectsCustomMapper;
import com.adv.manager.mapper.ChannelProjectMapper;
import com.adv.manager.mapper.ChannelProjectsCustomMapper;
import com.adv.manager.mapper.ProductProjectMapper;
import com.adv.manager.mapper.ProductProjectsCustomMapper;
import com.adv.manager.po.AdvProject;
import com.adv.manager.po.ChannelProject;
import com.adv.manager.po.ProductProject;
import com.adv.manager.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ChannelProjectsCustomMapper cCustomMapper;
	
	@Autowired
	private ProductProjectsCustomMapper pCustomMapper;
	
	@Autowired
	private ProductProjectMapper pMapper;
	
	@Autowired
	private ChannelProjectMapper cMapper;
	
	@Autowired
	private AdvProjectMapper advMapper;
	@Autowired
	private AdvProjectsCustomMapper advCustomMapper;
	
//	@Autowired
//	private DownloadRecordMapper recordMapper;
	
	@Override
	public List<ProductProject> queryProductProjects(String username) throws Exception {
		return	pCustomMapper.queryProductProjectsByUsername(username);
	}
	@Override
	public List<ChannelProject> queryChannelProjects(String username) throws Exception {
		return	cCustomMapper.queryChannelProjectByUsername(username);
	}
	@Override
	public int addProductProject(ProductProject project)
			throws Exception {
		if(project  == null){
			return -1;
		}
		return pMapper.insert(project);
	}
	
	@Override
	public int addAdvProject(AdvProject project)
			throws Exception {
		if(project  == null){
			return -1;
		}
		return advMapper.insert(project);
	}
	@Override
	public int addChannelProject(ChannelProject project)
			throws Exception {
		if(project  == null){
			return -1;
		}
		return cMapper.insert(project);
	}
	
	@Override
	public ChannelProject queryChannelProject(String pid) throws Exception {
		return cCustomMapper.selectByPid(pid);
//		return cMapper.selectByPrimaryKey(pid);
	}
	
	@Override
	public ProductProject queryProductProject(String pid) throws Exception {
		return pCustomMapper.selectByPid(pid);
//		return pMapper.selectByPrimaryKey(pid);
	}
	@Override
	public int updateChannelProject(String pid, ChannelProject project)
			throws Exception {
		if(pid != null && !pid.equals("")){
			int i = cMapper.updateByPrimaryKeySelective(project);
			if(i < 0){
				throw new CustomException("更新项目失败,项目id不存在");
			}
			return i;
		}
	
		return -1;
	}
	@Override
	public int updateProductProject(String pid, ProductProject project)
			throws Exception {
		if(pid != null && !pid.equals("")){
			int i = pMapper.updateByPrimaryKeySelective(project);
			if(i < 0){
				throw new CustomException("更新项目失败,项目id不存在");
			}
			return i;
		}
	
		return -1;
	}
	@Override
	public void delProductProjectByPid(String pid) throws Exception {
		pCustomMapper.delProductProjectByPid(pid);
		
	}
	@Override
	public List<AdvProject> queryAdvProjects() throws Exception {
		return advCustomMapper.queryAdvProjects();
	}

	
	
//	@Override
//	public ProductProject queryApkDownloadUrlByProductPid(String pid) throws Exception {
//		return pMapper.selectByPrimaryKey(pid);
//	}
//	@Override
//	public int addDownloadRecord(DownloadRecord record) throws Exception {
//		 int i = recordMapper.insert(record);
//		 if(i < 0){
//			 throw new CustomException("添加记录失败");
//		 }
//		return i;
//	}
	
	
	

}
