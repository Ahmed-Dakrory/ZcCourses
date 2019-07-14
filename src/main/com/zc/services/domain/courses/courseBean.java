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

import helpers.retrofit.Models.Inputs.Apikey;
import helpers.retrofit.Models.Inputs.OrderDetails;
import helpers.retrofit.Models.Inputs.payKiosk;
import helpers.retrofit.Models.Inputs.paymentKey;
import helpers.retrofit.Models.Outputs.Authentication;
import helpers.retrofit.Models.Outputs.KioskOutput;
import helpers.retrofit.Models.Outputs.OrderOutDetails;
import helpers.retrofit.Models.Outputs.TokenForgenerateFrame;
import helpers.retrofit.Models.Outputs.WalletOutput;
import helpers.retrofit.mainFiles.APIClient;
import helpers.retrofit.mainFiles.APIInterface;
import main.com.zc.allRegisterations.courseReg;
import main.com.zc.allRegisterations.courseRegAppServiceImpl;
import main.com.zc.loginNeeds.loginBean;
import main.com.zc.tools.Constants;
import retrofit2.Call;


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
	private courseReg courseRegSelected;
	
	private String phoneNumberPayment;
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
			
			
			courseRegSelected = registerCourseFasade.getByIdStudentandCourseId(loginBean.getTheUserOfThisAccount().getId(), courseId);
			if(state==0){
				if(courseRegSelected!=null&&courseRegSelected.getState()!=4){
					//He is registered
					return "none";
				}else{
					return "block";
				}
			}else if(state == 1){
				if(courseRegSelected!=null&&courseRegSelected.getState()!=4){
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
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("paymentForm:paymentPanel");
		
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
	
	
	public void payForthisCourseTypeOnline(int type) {
		if(!phoneNumberPayment.equals("")||type==Constants.MethodOnline||type==Constants.MethodKiosk) {
		try {
			
			String uniqueID = UUID.randomUUID().toString();
			sendGet(type,uniqueID,courseRegSelected.getCourseId().getPrice()*100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {

				PrimeFaces.current().executeScript("stopDim();");
			//Please enter a valid phone number for the payment
			PrimeFaces.current().executeScript("swal({\r\n" + 
					"  title: \"Data Missing!\",\r\n" + 
					"  text: \"Please enter a valid Mobile number!\",\r\n" + 
					"  icon: \"warning\",\r\n" + 
					"})\r\n" + 
					";");
		}
	}


	
	
	
	// HTTP GET request
	public void sendGet(int type, String merchant_Order_ID,int price) throws Exception {
		
		courseRegSelected.setMerchant_Order_ID(merchant_Order_ID);
		registerCourseFasade.addcourseReg(courseRegSelected);
					MakePurchase(type,merchant_Order_ID,price);

			

		}
		

		public void MakePurchase(int type, String courseRegID,int price){

			Apikey key=new Apikey(Constants.api_key);

		
		       
	        Call<Authentication> call = apiInterface.performAuthenticationToGetToken(key);
	        try {
				Authentication resource= call.execute().body();
				
				boolean active = resource.profile.active;
                String token = resource.token;
                Integer merchant_id = resource.profile.merchant_id;
                String courseReg_ID = String.valueOf(courseRegID);
               if(active) {
            	   callOrder(type, token, merchant_id, price, "EGP", courseReg_ID);
               }else {
            	   System.out.println("Account Deactive");   
               }
                
                
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	       
		}

		public void callOrder(int type,String auth_token, Integer merchant_id, Integer amount_cents, String currency,
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
                if(type==Constants.MethodOnline) {

	            	   getTokenForFrame(type,auth_token, amount_cents, orderId, currency, Constants.INTEGRATION_ID_OnlineMethod);  
                }else if(type==Constants.MethodKiosk) {

	            	   getTokenForFrame(type,auth_token, amount_cents, orderId, currency, Constants.INTEGRATION_ID_Kiosk_Method);  
                }else if(type==Constants.MethodWallet) {

	            	   getTokenForFrame(type,auth_token, amount_cents, orderId, currency, Constants.INTEGRATION_ID_Wallet_Method);  
                }
                
                
            	}
                
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
		}

		public void getTokenForFrame(int type, String auth_token, Integer amount_cents, Integer order_id, String currency,
				Integer integration_id) {
			int firstSpace = loginBean.getTheUserOfThisAccount().getFullName().indexOf(" "); // detect the first space character
			String firstName = loginBean.getTheUserOfThisAccount().getFullName().substring(0, firstSpace);  // get everything up to the first space character
			String lastName = loginBean.getTheUserOfThisAccount().getFullName().substring(firstSpace).trim(); // get everything after the first space, trimming the spaces off
			
			
			String apartment="NA";
			String email=loginBean.getTheUserOfThisAccount().getEmail();
			String floor="NA";
			String first_name=firstName;
			String street="NA";
			String building="NA";
			String phone_number=loginBean.getTheUserOfThisAccount().getMobile();
			String shipping_method="NA";
			String postal_code="NA";
			String city="NA";
			String country="NA";
			String last_name=lastName;
			String state="NA";
			
			paymentKey paymentKey=new paymentKey(auth_token, amount_cents, order_id, currency, integration_id, apartment, email, floor, first_name, street, building, phone_number, shipping_method, postal_code, city, country, last_name, state);

		       
	        Call<TokenForgenerateFrame> call = apiInterface.paymentKeyRequest(paymentKey);
	        
	        
			try {
				TokenForgenerateFrame resource = call.execute().body();
				if(resource!=null) {
	        		 tokenString = resource.token;
	        		
	        		 if(type==Constants.MethodOnline) {
	        			 try {
	 	     				xCx.redirect("/pages/public/pay.jsf");
	 	     				PrimeFaces.current().executeScript("stopDim();");
	 	     			} catch (IOException e) {
	 	     				// TODO Auto-generated catch block
	 	     				e.printStackTrace();
	 	     			}
	        		 }else if(type==Constants.MethodKiosk) {
	        			 payKiosk kiosk=new payKiosk(Constants.Identifier,Constants.Identifier,tokenString);
	        			 Call<KioskOutput> callKiosk = apiInterface.payKioskRequest(kiosk);
	        			 KioskOutput outputKiosk=callKiosk.execute().body();
	        			 System.out.println("callkiosk : "+outputKiosk.data.bill_reference);
	 	     				PrimeFaces.current().executeScript("stopDim();");
	 	     				
	 	     				PrimeFaces.current().executeScript("swal(\"Check your email and Payment Details!\", \"your reference number: "+outputKiosk.data.bill_reference+"\", \"success\")");
	        		 }else if(type==Constants.MethodWallet) {
	        			 payKiosk wallet=new payKiosk(phoneNumberPayment,"WALLET",tokenString);
	        			 Call<WalletOutput> callKiosk = apiInterface.payWalletRequest(wallet);
	        			 WalletOutput outPutWallet=callKiosk.execute().body();
	        			 System.out.println("call Wallet: "+outPutWallet.source_data.phone_number);
	 	     				PrimeFaces.current().executeScript("stopDim();");
	 	     				PrimeFaces.current().executeScript("swal(\"Payment Details!\", \"your phone number: "+outPutWallet.source_data.phone_number+"\", \"success\")");
	 		        		 
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
					if(loginBean.isLoggedIn()) {
						courseRegSelected = registerCourseFasade.getByIdStudentandCourseId(loginBean.getTheUserOfThisAccount().getId(), selectedCourseId);
						
					}
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

	public courseReg getCourseRegSelected() {
		return courseRegSelected;
	}

	public void setCourseRegSelected(courseReg courseRegSelected) {
		this.courseRegSelected = courseRegSelected;
	}

	
	public String getPhoneNumberPayment() {
		return phoneNumberPayment;
	}

	public void setPhoneNumberPayment(String phoneNumberPayment) {
		this.phoneNumberPayment = phoneNumberPayment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

	
	
	
}
