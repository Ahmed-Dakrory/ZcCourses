package main.com.zc.services.domain.courses;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.PrimeFaces;

import main.com.zc.allRegisterations.courseReg;
import main.com.zc.allRegisterations.courseRegAppServiceImpl;
import main.com.zc.loginNeeds.loginBean;
import main.com.zc.services.domain.courses.CourseAppServiceImpl;
import main.com.zc.services.domain.courses.course;
import main.com.zc.tools.Constants;
import retrofit2.Call;
import helpers.retrofit.Models.Inputs.Apikey;
import helpers.retrofit.Models.Inputs.OrderDetails;
import helpers.retrofit.Models.Inputs.paymentKey;
import helpers.retrofit.Models.Outputs.Authentication;
import helpers.retrofit.Models.Outputs.OrderOutDetails;
import helpers.retrofit.Models.Outputs.TokenForgenerateFrame;
import helpers.retrofit.mainFiles.APIClient;
import helpers.retrofit.mainFiles.APIInterface;


@ManagedBean(name = "courseBean")
@SessionScoped
public class courseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7292135686409219607L;


	@ManagedProperty(value = "#{loginBean}")
	private loginBean loginBean;
	
	



	@ManagedProperty(value = "#{CourseFacadeImpl}")
	private CourseAppServiceImpl courseFasade; 
	private List<course> courses;

	private course thecourseSelected;
	private int selectedCourseId;
	 

	@ManagedProperty(value = "#{courseRegFacadeImpl}")
	private courseRegAppServiceImpl registerCourseFasade;
	 
	APIInterface apiInterface;

	private String tokenString;
	
	
	FacesContext cs;
	ExternalContext xCx;
	
	
	@PostConstruct
	public void init() {
		refreshPage();
		 apiInterface = APIClient.getClient().create(APIInterface.class);
			cs = FacesContext.getCurrentInstance();
			xCx=cs.getExternalContext();
	}
	
	public void dismissDialog(){

		PrimeFaces.current().executeScript("dismiss();");
	}
	
	public void enrollInCourse(int id){
		selectedCourseId=id;
		if(loginBean.isLoggedIn()){
			PrimeFaces.current().executeScript("opencomfirmPopUpBox();");
			
		}else{
			PrimeFaces.current().executeScript("openLoginPopUpBox();");
		}
	}
	
	
	
	public void cancelTheEnroll(int courseId) {
		courseReg courseReg = registerCourseFasade.getByIdStudentandCourseId(loginBean.getTheUserOfThisAccount().getId(), courseId);
		courseReg.setState(4);
		registerCourseFasade.addcourseReg(courseReg);
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("enrollmentPanel");
	}
	
	
	public String getTheStateOfViewOfSelectedCourse(int courseId,int state){
		if(loginBean.isLoggedIn()){
			
			
			courseReg courseReg = registerCourseFasade.getByIdStudentandCourseId(loginBean.getTheUserOfThisAccount().getId(), courseId);
			if(state==0){
				if(courseReg!=null&&courseReg.getState()!=4){
					//He is registered
					return "none";
				}else{
					return "block";
				}
			}else if(state == 1){
				if(courseReg!=null&&courseReg.getState()!=4){
					//He is registered
					return "block";
				}else{
					return "none";
				}
			}else{
				return "block";
			}
			
			
		}else{
		
			if(state==0){
				
				return "block";
				
			}else if(state == 1){
				return "none";
				
			}else{
				return "block";
			}
		}
	}
	
	public void comfirmActionForEnrollment() {
		// TODO Auto-generated method stub
		courseReg courseReg=new courseReg();
		courseReg.setCourseId(courseFasade.getById(selectedCourseId));
		courseReg.setStudentId(loginBean.getTheUserOfThisAccount());
		courseReg.setDate(Calendar.getInstance());
		courseReg.setState(0);
		
		registerCourseFasade.addcourseReg(courseReg);
		dismissDialog();
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("enrollmentPanel");
		
	}
	
	public void getCoursesRelatedToprogram(int idProgram){
		try {
	  		courses=courseFasade.getByIdProgram(idProgram);
	  	for(int i=0;i<courses.size();i++) {
	  		if(courses.get(i).getId()==thecourseSelected.getId()) {
	  			courses.remove(i);
	  		}
	  	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void payForthisCourse() {
		courseReg theRegCourse=registerCourseFasade.getByIdStudentandCourseId(loginBean.getTheUserOfThisAccount().getId(), thecourseSelected.getId());
	
		try {
			
			String uniqueID = UUID.randomUUID().toString();
			sendGet(uniqueID,theRegCourse.getCourseId().getPrice());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	// HTTP GET request
	public void sendGet(String merchant_Order_ID,int price) throws Exception {
		courseReg theRegCourse=registerCourseFasade.getByIdStudentandCourseId(loginBean.getTheUserOfThisAccount().getId(), thecourseSelected.getId());
		
		theRegCourse.setMerchant_Order_ID(merchant_Order_ID);
		registerCourseFasade.addcourseReg(theRegCourse);
					MakePurchase(merchant_Order_ID,price);

			

		}
		

		public void MakePurchase(String courseRegID,int price){

			Apikey key=new Apikey(Constants.api_key);

		
		       
	        Call<Authentication> call = apiInterface.performAuthenticationToGetToken(key);
	        try {
				Authentication resource= call.execute().body();
				
				boolean active = resource.profile.active;
                String token = resource.token;
                Integer merchant_id = resource.profile.merchant_id;
                String courseReg_ID = String.valueOf(courseRegID);
               if(active) {
            	   callOrder(token, merchant_id, price, "EGP", courseReg_ID);
               }else {
            	   System.out.println("Account Deactive");   
               }
                
                
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	       
		}

		public void callOrder(String auth_token, Integer merchant_id, Integer amount_cents, String currency,
				String merchant_order_id) {
			OrderDetails order=new OrderDetails(auth_token, merchant_id, amount_cents, currency, merchant_order_id);

		       
	        Call<OrderOutDetails> call = apiInterface.performOrder(order);
	        try {
				OrderOutDetails resource =call.execute().body();
				if(resource!=null) {
            		String dateString = resource.created_at;
            		Integer orderId = resource.order_id;

	            	   System.out.println("dateString: "+dateString);
	            	   System.out.println("orderId: "+orderId);   
                
	            	   getTokenForFrame(auth_token, amount_cents, orderId, currency, Constants.INTEGRATION_ID1);  
            	}
                
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
		}

		public void getTokenForFrame(String auth_token, Integer amount_cents, Integer order_id, String currency,
				Integer integration_id) {
			
			String apartment="Empty";
			String email=loginBean.getTheUserOfThisAccount().getEmail();
			String floor="Empty";
			String first_name=loginBean.getTheUserOfThisAccount().getFullName();
			String street="Empty";
			String building="Empty";
			String phone_number=loginBean.getTheUserOfThisAccount().getMobile();
			String shipping_method="Empty";
			String postal_code="Empty";
			String city="Empty";
			String country="Empty";
			String last_name=".";
			String state="Empty";
			paymentKey paymentKey=new paymentKey(auth_token, amount_cents, order_id, currency, integration_id, apartment, email, floor, first_name, street, building, phone_number, shipping_method, postal_code, city, country, last_name, state);

		       
	        Call<TokenForgenerateFrame> call = apiInterface.paymentKeyRequest(paymentKey);
	        
	        
			try {
				TokenForgenerateFrame resource = call.execute().body();
				if(resource!=null) {
	        		 tokenString = resource.token;
	        		
	        		 try {
	     				xCx.redirect("/pages/public/pay.jsf");
	     				PrimeFaces.current().executeScript("stopDim();");
	     			} catch (IOException e) {
	     				// TODO Auto-generated catch block
	     				e.printStackTrace();
	     			}	
	        	}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
	        
	        
		}
	
		public void refreshPage(){
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("enrollmentPanel");
		HttpServletRequest origRequest = (HttpServletRequest)FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequest();
		
		try{
			Integer id=Integer.parseInt(origRequest.getParameterValues("id")[0]);
				if(id!=null){
					thecourseSelected=courseFasade.getById(id);
			  		selectedCourseId=thecourseSelected.getId();
			  		getCoursesRelatedToprogram(thecourseSelected.getIdProgram());
					
				}
			}
		catch(Exception ex){
			 
		}
	}

	
	
	public CourseAppServiceImpl getCourseFasade() {
		return courseFasade;
	}

	public void setCourseFasade(CourseAppServiceImpl courseFasade) {
		this.courseFasade = courseFasade;
	}

	public List<course> getCourses() {
		return courses;
	}

	public void setCourses(List<course> courses) {
		this.courses = courses;
	}

	

	public course getThecourseSelected() {
		return thecourseSelected;
	}

	public void setThecourseSelected(course thecourseSelected) {
		this.thecourseSelected = thecourseSelected;
	}

	public loginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(loginBean loginBean) {
		this.loginBean = loginBean;
	}

	public courseRegAppServiceImpl getRegisterCourseFasade() {
		return registerCourseFasade;
	}

	public void setRegisterCourseFasade(courseRegAppServiceImpl registerCourseFasade) {
		this.registerCourseFasade = registerCourseFasade;
	}

	public int getSelectedCourseId() {
		return selectedCourseId;
	}

	public void setSelectedCourseId(int selectedCourseId) {
		this.selectedCourseId = selectedCourseId;
	}

	public String getTokenString() {
		return tokenString;
	}

	public void setTokenString(String tokenString) {
		this.tokenString = tokenString;
	}

	
	

	
	
	
}
