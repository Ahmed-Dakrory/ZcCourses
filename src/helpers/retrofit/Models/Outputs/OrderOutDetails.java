package helpers.retrofit.Models.Outputs;


import com.google.gson.annotations.SerializedName;


public class OrderOutDetails {

    @SerializedName("id")
    public Integer order_id;
    
    @SerializedName("created_at")
    public String created_at;
    
    @SerializedName("paid_amount_cents")
    public String paid_amount_cents;
   
}