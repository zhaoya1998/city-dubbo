package com.zhaoya.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhaoya.pojo.Area;
import com.zhaoya.pojo.Student;

/**
 * 
 * @author zhuzg
 *
 */
public interface StudentService {
	/**
	 * 鏍规嵁涓婁竴绾d 鑾峰彇涓嬩竴绾ф墍鏈夌殑鏁版嵁
	 * @param pid
	 * @return
	 */
	List<Area> listByPid(int pid);
	
	PageInfo<Student> list(int pageNum);
	//娣诲姞
	int add(Student stu);
	// 淇敼
	int update(Student stu);
	// 淇敼鏃跺�欑殑鍥炴樉浣跨敤
	Student get(int id);
	
	
}
