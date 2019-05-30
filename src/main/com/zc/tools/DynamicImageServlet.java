package main.com.zc.tools;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;





@ManagedBean
@ApplicationScoped
public class DynamicImageServlet extends HttpServlet {

	
	

	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void init(){
		
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

	{
	
	  try {
	   // Get image file.
	
	   String file = request.getParameter("file");
	
	   if(file==null) {
		   file="errorNotFound.png";
	   }
	   if(file.equals("")) {
		   file="errorNotFound.png";
		   
	   }
	   String mainDirectory=System.getProperty("catalina.base")+"/images/";
	   System.out.println(System.getProperty("catalina.base"));
	   FileInputStream fileInputStream=new FileInputStream( mainDirectory + file);
	   
	    BufferedInputStream in = new BufferedInputStream(fileInputStream);
	
	    // Get image contents.
	byte[] bytes = new byte[in.available()];
	
	   in.read(bytes);
	   in.close();
	
	   // Write image contents to response.
	   response.getOutputStream().write(bytes);
	   
	  
	} catch (IOException e) {
	
	e.printStackTrace();
	
	}
	
	}

}