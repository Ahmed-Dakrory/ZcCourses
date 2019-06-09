package helpers.retrofit.Models.Outputs;


import com.google.gson.annotations.SerializedName;


public class WalletOutput {

    @SerializedName("source_data")
    public source_data source_data;
    
    @SerializedName("amount_cents")
    public String amount_cents;

    public class source_data {

        @SerializedName("phone_number")
        public String phone_number;
        
        @SerializedName("type")
        public String type;
    }
}