package wzn.text.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
/**
 * 简单上传
 * 访问静态文件  http://localhost:8088/file.html 测试
 * 默认图片支持最大 1M
 * @author wzn
 * @date 2017年1月23日下午3:17:03
 * 
 */
@RestController
public class UploadController {
    /**
     * 文件上传具体实现方法;
     * @param file
     * @return
     */
	//控制上传文件大小
	@Value("${load.max}")
	private String maxNum;
    @RequestMapping("/upload")
    public String 	fileUpload(HttpServletRequest resquest,@RequestParam("file")MultipartFile file){
       if(!file.isEmpty()){
           try {
        	   //模拟控制上传最大值  暂时方案 应该有配置文件设置 后续研究
        	  /* if(new Long(file.getSize()).intValue()>Integer.valueOf(maxNum)){
        		   return"上传失败,超过上传最大值";
        	   }*/
        	
              BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File("imgs", "wzn.jpg")));//指定项目中某个文件夹保存 指定文件名称 随便写的可自行扩展
              out.write(file.getBytes());
              out.flush();
              out.close();
           } catch (FileNotFoundException e) {
              e.printStackTrace();
              return"上传失败,"+e.getMessage();
           } catch (IOException e) {
              e.printStackTrace();
              return"上传失败,"+e.getMessage();
           }
           return"上传成功";
       }else{
           return"上传失败，因为文件是空的.";
       }
    }
    //扩展多文加上传思路
	//MultipartHttpServletRequest 他的父类里有 MultipartRequest List<MultipartFile> getFiles(String name);方法 可以得到所有上传文件 
	   /* 	   MultipartHttpServletRequest mreq;
	   try{
		   mreq=(MultipartHttpServletRequest) resquest;
	   }catch (Exception e) {
		   return "resquest is not to MultipartHttpServletRequest";
	   } 
	   MultipartFile multipartFile = mreq.getFiles("file");
	   for(int i=0; i<multipartFile.size();i++){
	   //TODO循环遍历 流输出指定位置 指定文件名
	   
	   }
	   *
	   */
}
