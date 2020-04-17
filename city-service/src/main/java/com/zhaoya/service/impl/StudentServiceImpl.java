package com.zhaoya.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaoya.dao.StudentDao;
import com.zhaoya.pojo.Area;
import com.zhaoya.pojo.Student;
import com.zhaoya.service.StudentService;

@Service(interfaceClass=StudentService.class)
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao stuDao;

	@Override
	public List<Area> listByPid(int pid) {
		// TODO Auto-generated method stub
		
		return stuDao.listByPid(pid);
	}

	@Override
	public PageInfo<Student> list(int pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,5);
		List<Student> stu =stuDao.list();
		PageInfo<Student> info=new PageInfo<Student>(stu);
		return info;
	}

	@Override
	public int add(Student stu) {
		// TODO Auto-generated method stub
		return stuDao.add(stu);
	}

	@Override
	public int update(Student stu) {
		// TODO Auto-generated method stub
		return stuDao.update(stu);
		
	}

	@Override
	public Student get(int id) {
		// TODO Auto-generated method stub
		return stuDao.getById(id);
	}
	

}
