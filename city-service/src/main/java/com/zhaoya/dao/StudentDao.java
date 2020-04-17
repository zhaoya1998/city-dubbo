package com.zhaoya.dao;

import java.util.List;

import com.zhaoya.pojo.Area;
import com.zhaoya.pojo.Student;

public interface StudentDao {
	

	
	List<Student> list();

	
	int add(Student stu);

	int update(Student stu);

	List<Area> listByPid(int pid);

	Student getById(int id);
}
