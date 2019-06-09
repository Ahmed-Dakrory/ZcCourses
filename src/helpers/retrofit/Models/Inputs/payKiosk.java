package helpers.retrofit.Models.Inputs;

import com.google.gson.annotations.SerializedName;

import main.com.zc.tools.Constants;

public class payKiosk {

	@SerializedName("source")
 	public source source;

	
	@SerializedName("payment_token")
 	public String payment_token;
	
	
	 public class source {

		 @SerializedName("identifier")
	        public String identifier=Constants.Identifier;

		
		 @SerializedName("subtype")
	        public String subtype=Constants.Identifier;
	     
		 public source(String identifier,String subtype) {
			// TODO Auto-generated constructor stub
			 this.subtype=subtype;
			 this.identifier=identifier;
		}
		 
	    }


	public payKiosk(String identifier,String subtype, String payment_token) {
		super();
		this.source=new source(identifier, subtype);
		this.payment_token = payment_token;
	}
	 
	
	
	
}
