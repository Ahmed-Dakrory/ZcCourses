package helpers.retrofit.mainFiles;



import helpers.retrofit.Models.Inputs.Apikey;
import helpers.retrofit.Models.Inputs.OrderDetails;
import helpers.retrofit.Models.Inputs.payKiosk;
import helpers.retrofit.Models.Inputs.paymentKey;
import helpers.retrofit.Models.Outputs.Authentication;
import helpers.retrofit.Models.Outputs.KioskOutput;
import helpers.retrofit.Models.Outputs.OrderOutDetails;
import helpers.retrofit.Models.Outputs.TokenForgenerateFrame;
import helpers.retrofit.Models.Outputs.WalletOutput;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {

	 @POST("auth/tokens")
	    Call<Authentication> performAuthenticationToGetToken(@Body Apikey api_key);
	 
	 
	 @POST("ecommerce/orders")
	    Call<OrderOutDetails> performOrder(@Body OrderDetails orderDetails);
	 
	 @POST("acceptance/payment_keys")
	    Call<TokenForgenerateFrame> paymentKeyRequest(@Body paymentKey paymentKey);
	 
	 @POST("acceptance/payments/pay")
	    Call<KioskOutput> payKioskRequest(@Body payKiosk payKiosk);
	 
	 @POST("acceptance/payments/pay")
	    Call<WalletOutput> payWalletRequest(@Body payKiosk payKiosk);

   
}