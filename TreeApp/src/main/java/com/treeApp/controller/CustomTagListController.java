package com.treeApp.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.treeApp.dto.EmployeeDTO;

@Controller
public class CustomTagListController {

	@RequestMapping(value = "/customtag", method = RequestMethod.GET)
	public ModelAndView  customListMethod(){
		
		List<EmployeeDTO> e1 = new ArrayList<EmployeeDTO>();
		
		for(int i = 0; i < 5; i++){
			EmployeeDTO emp = new EmployeeDTO();
			
			emp.setId(i);
			emp.setName("Test" + i);
			emp.setDesignation("SE" + i);
			emp.setManagerName("Mgr" + i);
			emp.setSalary("24000" +i);
			e1.add(emp);
			
		}
		
		ModelAndView mv = new ModelAndView("CutomTag");
		mv.addObject("employeeList", e1);
		
		return mv;
	}

	@RequestMapping(value = "/fileupload", method = RequestMethod.GET)
	public ModelAndView  uploadFileMethod(){
		ModelAndView mv = new ModelAndView("FileUpload");
		
		return mv;
	}
	
	@RequestMapping(value = "/fileUploadAction", method = RequestMethod.POST)
	@ResponseBody
	public String  uploadFileAction(@RequestParam("file") MultipartFile file){
		
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = "D:\\";
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("Server File Location="
						+ serverFile.getAbsolutePath());

				return "You successfully uploaded file=" + file.getOriginalFilename();
			} catch (Exception e) {
				return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + file.getOriginalFilename()
					+ " because the file was empty.";
		}
		
	}
}
