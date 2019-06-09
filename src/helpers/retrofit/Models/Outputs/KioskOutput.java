package helpers.retrofit.Models.Outputs;


import com.google.gson.annotations.SerializedName;


public class KioskOutput {

    @SerializedName("data")
    public data data;
    
    @SerializedName("amount_cents")
    public String amount_cents;

    public class data {

        @SerializedName("klass")
        public String klass;
        
        @SerializedName("bill_reference")
        public String bill_reference;
    }
}