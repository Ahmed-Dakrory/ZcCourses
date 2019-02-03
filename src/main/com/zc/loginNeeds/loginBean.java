package main.com.zc.loginNeeds;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FileUploadEvent;


@ManagedBean(name = "loginBean")
@SessionScoped
public class loginBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6715784400190397743L;
	private boolean isLoggedIn;
	private String emailOfUserLoggedIn;
	private String passwordOfUserLoggedIn;
	private List<UserData> listOfUsers;
	private UserData theUserOfThisAccount;
	private int type;
	private String imageOfAccountUser;
	private byte[] imageOfReg;
	private boolean imageUploaded;
	

	@ManagedProperty(value = "#{UserDataFacadeImpl}")
	private UserDataAppServiceImpl userDataFacede; 
	 

	private String passwordConfirm;
	@PostConstruct
	public void init() {
		isLoggedIn=false;
		imageUploaded=false;
		theUserOfThisAccount=new UserData();
		setImageDependOnLoginState();
		//theUserOfThisAccount=userDataFacede.getByEmailAndPassword(emailOfUserLoggedIn, passwordOfUserLoggedIn);
		listOfUsers=userDataFacede.getAll();
		
		
	}
	
	public void refresh(){
		HttpServletRequest origRequest = (HttpServletRequest)FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequest();
		
		try{
			Integer id=Integer.parseInt(origRequest.getParameterValues("id")[0]);
				if(id!=null){
					UserData user=getUserDataFacede().getById(id);
					user.setActive(1);
					getUserDataFacede().addUserData(user);
					
				}
			}
		catch(Exception ex){
			 
		}
	}
	
	public String logOut(){
		theUserOfThisAccount=new UserData();
		isLoggedIn=false;
		setImageDependOnLoginState();
		imageUploaded=false;
		System.out.println("");
		return "/pages/public/index.xhtml?faces-redirect=true";
	}
	public void login(){
		theUserOfThisAccount = userDataFacede.getByEmailAndPassword(emailOfUserLoggedIn, passwordOfUserLoggedIn);

		if(theUserOfThisAccount!=null){
			isLoggedIn=true;
			
		}else{
			isLoggedIn=false;
			theUserOfThisAccount=new UserData();
			wrongPassword();
		}
		if(isLoggedIn){
			setImageDependOnLoginState();
			try {
				if(theUserOfThisAccount.getEmail().equals("lts-admin@zewailcity.edu.eg")) {
				FacesContext.getCurrentInstance()
				   .getExternalContext().redirect("/ZcCourses/pages/secured/addListUser.xhtml");
				}else {
				FacesContext.getCurrentInstance()
					   .getExternalContext().redirect("index.xhtml");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			

			FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("FormMain");
		}
		
	}
	

	
   
	public void wrongPassword(){
		FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "wrong Credentials!", "Please try Again") );
   
	}
	
	void setImageDependOnLoginState(){
		if(isLoggedIn&&theUserOfThisAccount.getImage()!=null&&theUserOfThisAccount.getImage().length!=0){
			imageOfAccountUser=theUserOfThisAccount.getphoto();
		}else{
			
			imageOfAccountUser="images/comment-img3.jpg";
		}
	}
	
	void setImageDependOnRegisterationImageState(){
		if(imageUploaded){
			imageOfAccountUser=theUserOfThisAccount.getphoto();
		}else{
			
			imageOfAccountUser="images/comment-img3.jpg";
		}
	}
	
	
	public void RegisterNewUser(){
		validateUser(theUserOfThisAccount);
		
	}
	
	private void validateUser(UserData theUserOfThisAccount2) {
		// TODO Auto-generated method stub
		boolean ok=false;
		
		if(!theUserOfThisAccount2.getFullName().equals("") &&!theUserOfThisAccount2.getPassword().equals("") &&!theUserOfThisAccount2.getEmail().equals("") && theUserOfThisAccount2.getPassword().equals(passwordConfirm)){
			ok=true;
		}
		if(ok){
			completeRegisteration();
		}else{
			pleaseCheck();
		}
	}

	private void pleaseCheck() {
		// TODO Auto-generated method stub
		System.out.println("Please Check Data");
	}

	private void completeRegisteration() {
		// TODO Auto-generated method stub
		theUserOfThisAccount.setImage(imageOfReg);
		theUserOfThisAccount.setActive(0);
		userDataFacede.addUserData(theUserOfThisAccount);
		
		
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("registerEmailConfirm.xhtml");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		activateAccount(theUserOfThisAccount);
	}

	public void activateAccount(UserData userdata){
		sendEmailWithActivationCode(userdata);
	}
	
	public void sendEmailWithActivationCode(UserData userdata1){
		UserData userdata=userDataFacede.getByEmailAndPasswordNotActivated(userdata1.getEmail(), userdata1.getPassword());
		try{
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"LearningTechnologies@zewailcity.edu.eg",
								"zcltinfo");
					}
				});

		javax.mail.internet.InternetAddress[] addressTo = new javax.mail.internet.InternetAddress[1];
		
				addressTo[0] = new javax.mail.internet.InternetAddress(
						theUserOfThisAccount.getEmail());


		/* Message message = new MimeMessage(session); */
		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress(
				"LearningTechnologies@zewailcity.edu.eg"));
		message.setRecipients(Message.RecipientType.TO, addressTo);

		message.setSubject("Comfirmation Account in Zc Sessions");

		String htmlText = "<div style=width:700px;margin:0 auto;font:normal 13px/30px Segoe, Segoe UI, DejaVu Sans, Trebuchet MS, Verdana, sans-serif !important;>"
				+ "<ul style=margin:0;padding:0;>"
				+ "<li style=list-style:none;float:left;width:700px;margin:0;>"
				+ "	<ul style=margin:0;padding:0;width:700px;margin-top:18px;>"
				+ "<li style=list-style:none;float:left;width:260px;padding:0;><img src=\"http://zclt.info/ZCTestMail/university_logo.png\" alt=Zewail City of Science and Technology /></li>"
				+ "<li style=list-style:none;float:right;width:121px;padding:0;><img src=\"http://zclt.info/ZCTestMail/LT_logo_l.png\" alt=Center for Learning Technologies style=margin-top:4px; /></li>"
				+ "</ul>"
				+ "</li>"
				+ "<li style=list-style:none;float:left;width:700px;background:#f1f2f2;margin:15px 0 24px 0;padding:1px 0;>&nbsp;</li>"
				+ "<li style=list-style:none;float:left;width:700px;margin-bottom:24px;padding-left:24px;>"
				+ "<h2 style=margin:0;padding:0;color:#404040 !important;>Learning Technologies Services</h2>"
				+ "</li>"
				+ "<li style=list-style:none;float:left;width:700px;marin:0;background:#f2f0f0;>"
				+ "<div style=padding:24px 36px;color:#676767 !important;>"
				+ "<span style=color:#676767>Dear "
				+ userdata.getFullName()
				+ ",</span><br/><br/><br/>"
				+ "<span style=color:#676767>please click this link to activate account "+"http://localhost:8082/ZewailCourses/pages/public/login.xhtml?id="+userdata.getId()+"</span><br/><br/><br/>"
				+ "</span><br/><br/>"
				+ "<span style=color:#676767>Thank you, </span><br/><br/>"
				+ "<span style=color:#676767>Center for Learning Technologies</span>"
				+ "</div>"
				+ "</li>"
				+ "<li style=list-style:none;float:left;width:700px;margin-bottom:4px;background:#ececec;>"
				+ "<ul style=margin:0;padding:0;>"
				+ "<li style=list-style:none;float:left;width:134px;margin:0;padding:18px 36px !important;color:#717070;>"
				+ "<a href=http://www.zclt.info/ title=Center for Learning Technologies><img src=\"http://zclt.info/ZCTestMail/LT_logo_s.png\"  alt=Center for Learning Technologies /></a><br/>"
				+ "<span style=color:#404040;font-size:11px;>Giving Fuel to Innovation</span>"
				+ "</li>"
				+ "<li style=list-style:none;float:right;width:59px;margin:0;padding:18px 36px !important;color:#717070;>"
				+ "<a href=http://www.zewailcity.edu.eg/ title=Zewail City of Science and Technology><img src=\"http://zclt.info/ZCTestMail/ZC_logo.png\"  alt=Zewail City of Science and Technology /></a>"
				+ "</li>"
				+ "</ul>"
				+ "</li>"
				+ "<li style=list-style:none;float:left;width:700px;margin-bottom:12px;background:#ececec;>"
				+ "<div style=padding:8px 16px;color:#a1a0a0;font-size:11px;line-height:20px;>"
				+ " <br/><b><span style=color:#a1a0a0;font-size:11px;>Follow us:</sapn></b><a href=https://www.facebook.com/learning.technologies.zewailcity title=ZC LT Facebook><img src=\"http://zclt.info/ZCTestMail/facebook_square.png\"  alt=ZC LT Facebook style=vertical-align:middle;/></a>"
				+ "  <a href=https://www.youtube.com/channel/UCiajXXIv0rCpxVIgCDekm2A title=ZC LT Youtube><img src=\"http://zclt.info/ZCTestMail/youtube_square.png\"   alt=ZC LT Youtube style=vertical-align:middle;/></a>"
				+ "</div>" + "</li>" + "</ul>" + "</div>";
		/*
		 * message.setText("Dear " + dao.getName() + " ," +
		 * "\n Your Password is : " + dao.getPassword() + "\n\n Regards"
		 * + "\n Learning Technologies Department" +
		 * "\n\n Please do not reply to this email ");
		 * 
		 * Transport.send(message);
		 */

		message.setContent(htmlText, "text/html; charset=ISO-8859-1");

		Transport.send(message);
		}catch(MessagingException e){
			
		}
	}
	public String getTheStatueOfLoginMenu(){
		if(isLoggedIn){
			return "block";
		}
		return "none";
	}
	
	public String getTheStatueOfImageMenu(){
		if(isLoggedIn&&theUserOfThisAccount.getImage()==null){
			return "block";
		}else if(isLoggedIn){
			return "none";
		}
		return "block";
	}
	
	public String getTheStatueOfImageLoginMenu(){
		if(isLoggedIn&&theUserOfThisAccount.getImage()==null){
			return "none";
		}else if(isLoggedIn){
			return "block";
		}
		return "none";
	}
	public String imageUploadedVisib(){
		if(imageUploaded){
			return "block";
		}
		return "none";
	}
	
	public String imageUploadedVisibNot(){
		if(!imageUploaded){
			return "block";
		}
		return "none";
	}
	public String getTheStatueMenuMain(){
		if(isLoggedIn){
			return "none";
		}
		return "block";
	}
	
	
	
	public void previewImage(FileUploadEvent event) {
		/* FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		*/
		this.imageOfReg = event.getFile().getContents();
		theUserOfThisAccount.setImage(imageOfReg);
		imageUploaded=true;
		setImageDependOnRegisterationImageState();
		System.out.println("File Uploaded");
		
	}

	

	/*
	 * the start of getting and setting method
	 */
	
	
	public String getEmailOfUserLoggedIn() {
		return emailOfUserLoggedIn;
	}

	

	public byte[] getImageOfReg() {
		return imageOfReg;
	}

	public void setImageOfReg(byte[] imageOfReg) {
		this.imageOfReg = imageOfReg;
	}

	public boolean isImageUploaded() {
		return imageUploaded;
	}

	public void setImageUploaded(boolean imageUploaded) {
		this.imageUploaded = imageUploaded;
	}


	public void setEmailOfUserLoggedIn(String emailOfUserLoggedIn) {
		this.emailOfUserLoggedIn = emailOfUserLoggedIn;
	}

	public String getPasswordOfUserLoggedIn() {
		return passwordOfUserLoggedIn;
	}

	public void setPasswordOfUserLoggedIn(String passwordOfUserLoggedIn) {
		this.passwordOfUserLoggedIn = passwordOfUserLoggedIn;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}


	public List<UserData> getListOfUsers() {
		return listOfUsers;
	}


	public void setListOfUsers(List<UserData> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}


	public UserData getTheUserOfThisAccount() {
		return theUserOfThisAccount;
	}


	public void setTheUserOfThisAccount(UserData theUserOfThisAccount) {
		this.theUserOfThisAccount = theUserOfThisAccount;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public UserDataAppServiceImpl getUserDataFacede() {
		return userDataFacede;
	}


	public void setUserDataFacede(UserDataAppServiceImpl userDataFacede) {
		this.userDataFacede = userDataFacede;
	}

	public String getImageOfAccountUser() {
		return imageOfAccountUser;
	}

	public void setImageOfAccountUser(String imageOfAccountUser) {
		this.imageOfAccountUser = imageOfAccountUser;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	
	
	
	
	
	
	
	

	
}
