package helpers.retrofit.Models.Inputs;

import com.google.gson.annotations.SerializedName;

public class OrderDetails {
	@SerializedName("auth_token")
 	public String auth_token;
	
	@SerializedName("delivery_needed")
 	public String delivery_needed;
	
	@SerializedName("merchant_id")
 	public Integer merchant_id;
	
	@SerializedName("amount_cents")
 	public Integer amount_cents;
	
	@SerializedName("currency")
 	public String currency;
	
	@SerializedName("merchant_order_id")
 	public String merchant_order_id;

	public OrderDetails(String auth_token, Integer merchant_id, Integer amount_cents, String currency,
			String merchant_order_id) {
		super();
		this.auth_token = auth_token;
		this.merchant_id = merchant_id;
		this.delivery_needed="false";
		this.amount_cents = amount_cents;
		this.currency = currency;
		this.merchant_order_id = merchant_order_id;
	}

	
 	
}
