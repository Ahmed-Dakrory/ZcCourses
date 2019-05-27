package helpers.retrofit.Models.Inputs;

import com.google.gson.annotations.SerializedName;

public class Apikey {

		@SerializedName("api_key")
	 	public String api_key;

		public Apikey(String api_key) {
			this.api_key = api_key;
		}
	 	
	 	
}
