package com.zhaoya.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.zhaoya.pojo.Area;
import com.zhaoya.pojo.Student;
import com.zhaoya.service.StudentService;

@Controller
@RequestMapping("stu")
public class StudentController {
	
	@Reference
	StudentService stuService;
	
	/**
	 * 进入添加的页�?
	 * @param request
	 * @return
	 */
	@RequestMapping("toAdd")
	public String toAdd(HttpServletRequest request) {
		//得到所有的直辖市
		List<Area> shengList = stuService.listByPid(0);
		request.setAttribute("shengList", shengList);
		return "stu/add";
	}
	
	
	/**
	 * 进入添加的页�?
	 * @param request
	 * @return
	 */
	@RequestMapping("index")
	public String toAdd(Model m,HttpServletRequest request,@RequestParam(defaultValue="1")int pageNum) {
		PageInfo<Student> info = stuService.list(pageNum);
		m.addAttribute("info",info);
		System.out.println("info ="+info);
		return "stu/index";
	}
	
	/**
	 * 进入修改的页�?
	 * @param request
	 * @return
	 */
	@RequestMapping("toupdate")
	public String toUpdate(HttpServletRequest request,int id) {
		//得到所有的直辖市
		List<Area> shengList = stuService.listByPid(0);
		request.setAttribute("shengList", shengList);
	
		Student student = stuService.get(id);
		request.setAttribute("stu", student);
		System.out.println("stu is " + student);
		
		request.setAttribute("shengList", shengList);
	
		
		return "stu/index";
	}
	
	/**
	 * 获取下一级别
	 * @param pid
	 * @return
	 */
	@RequestMapping("getSubs")
	@ResponseBody
	public List<Area> getSubAreaList(int pid) {
		List<Area> listByPid = stuService.listByPid(pid);
		return listByPid;
	}
	
	@RequestMapping("add")
	public String add(HttpServletRequest request,Student stu,MultipartFile file) throws IllegalStateException, IOException {
		
		stuService.add(stu);
		return "/stu/index";
		
		
	}

	@RequestMapping("update")
	public String updatae(HttpServletRequest request,Student stu,MultipartFile file) throws IllegalStateException, IOException {
		stuService.update(stu);
		return "/stu/index";
		
	}
	
	/**
	 *  上传文件
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	private String processFile(MultipartFile file) throws IllegalStateException, IOException {

		// 原来的文件名�?
		System.out.println("file.isEmpty() :" + file.isEmpty()  );
		System.out.println("file.name :" + file.getOriginalFilename());
		
		if(file.isEmpty()||"".equals(file.getOriginalFilename()) || file.getOriginalFilename().lastIndexOf('.')<0 ) {
			return "";
		}
			
		String originName = file.getOriginalFilename();
		String suffixName = originName.substring(originName.lastIndexOf('.'));
		SimpleDateFormat sdf=  new SimpleDateFormat("yyyyMMdd");
		String path = "e:/pic/" + sdf.format(new Date());
		File pathFile = new File(path);
		if(!pathFile.exists()) {
			pathFile.mkdir();
		}
		String destFileName = 		path + "/" +  UUID.randomUUID().toString() + suffixName;
		File distFile = new File( destFileName);
		file.transferTo(distFile);//文件另存到这个目录下�?
		return destFileName.substring(7);
		
		
		
	}
	
	
	
	
	
}
