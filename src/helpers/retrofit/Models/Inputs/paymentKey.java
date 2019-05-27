package helpers.retrofit.Models.Inputs;

import com.google.gson.annotations.SerializedName;

import main.com.zc.tools.Constants;

public class paymentKey {

	@SerializedName("auth_token")
 	public String auth_token;
	
	@SerializedName("amount_cents")
 	public Integer amount_cents;
	
	@SerializedName("expiration")
 	public Integer expiration;
	
	@SerializedName("order_id")
 	public Integer order_id;
	
	@SerializedName("currency")
 	public String currency;
	
	@SerializedName("integration_id")
 	public Integer integration_id;
	
	@SerializedName("billing_data")
 	public billing_data billing_dataV;

	
	@SerializedName("lock_order_when_paid")
 	public String lock_order_when_paid="false";
	
	
	 public class billing_data {

	        @SerializedName("apartment")
	        public String apartment="000";
	        
	        @SerializedName("email")
	        public String email="claudette09@exa.com";
	        
	        @SerializedName("floor")
	        public String floor="42";
	        
	        @SerializedName("first_name")
	        public String first_name="Clifford";
	        
	        @SerializedName("street")
	        public String street="Ethan Land";
	        
	        @SerializedName("building")
	        public String building="8028";
	        
	        @SerializedName("phone_number")
	        public String phone_number="+86(8)9135210487";
	        
	        @SerializedName("shipping_method")
	        public String shipping_method="PKG";
	        

	        @SerializedName("postal_code")
	        public String postal_code="01898";

	        @SerializedName("city")
	        public String city="Jaskolskiburgh";

	        @SerializedName("country")
	        public String country="CR";

	        @SerializedName("last_name")
	        public String last_name="Nicolas";
	        
	        @SerializedName("state")
	        public String state="Utah";

			public billing_data(String apartment, String email, String floor, String first_name, String street,
					String building, String phone_number, String shipping_method, String postal_code, String city,
					String country, String last_name, String state) {
				super();
				this.apartment = apartment;
				this.email = email;
				this.floor = floor;
				this.first_name = first_name;
				this.street = street;
				this.building = building;
				this.phone_number = phone_number;
				this.shipping_method = shipping_method;
				this.postal_code = postal_code;
				this.city = city;
				this.country = country;
				this.last_name = last_name;
				this.state = state;
			}
	        
	        
	    }
	 
	 
	public paymentKey(String auth_token, Integer amount_cents, Integer order_id, String currency,
			Integer integration_id, String apartment, String email, String floor, String first_name, String street,
			String building, String phone_number, String shipping_method, String postal_code, String city,
			String country, String last_name, String state) {
		super();
		this.auth_token = auth_token;
		this.amount_cents = amount_cents;
		this.order_id = order_id;
		this.expiration=Constants.EXPIRATION_TIME;
		this.currency = currency;
		this.integration_id = integration_id;
		this.billing_dataV=new billing_data(apartment, email, floor, first_name, street, building, phone_number, shipping_method, postal_code, city, country, last_name, state);
		System.out.println("Ticker: "+this.billing_dataV.first_name);
	}
	
	
	
}
