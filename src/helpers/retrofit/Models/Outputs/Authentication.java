package helpers.retrofit.Models.Outputs;


import com.google.gson.annotations.SerializedName;


public class Authentication {

    @SerializedName("profile")
    public Profile profile;
    
    @SerializedName("token")
    public String token;

    public class Profile {

        @SerializedName("id")
        public Integer merchant_id;
        @SerializedName("country")
        public String country;
        @SerializedName("active")
        public boolean active;

    }
}