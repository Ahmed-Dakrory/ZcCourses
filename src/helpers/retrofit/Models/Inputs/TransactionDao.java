package helpers.retrofit.Models.Inputs;

import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TransactionDao {
	
	private String type;
	
	private obj obj;

	
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public obj getObj() {
		return obj;
	}
	public void setObj(obj obj) {
		this.obj = obj;
	}





	public class obj{

		private Integer accept_fees_cents;
		private Integer amount_cents;
		private String api_source;
		private Integer captured_amount;
		private Calendar created_at;
		private String currency;
		private data data;
		private boolean error_occured;
		private boolean has_parent_transaction;
		private Integer id;
		private Integer integration_id;
		private boolean is_3d_secure;
		private boolean is_auth;
		private boolean is_capture;
		private boolean is_captured;
		private boolean is_hidden;
		private boolean is_live;
		private boolean is_refund;
		private boolean is_refunded;
		private boolean is_standalone_payment;
		private boolean is_void;
		private boolean is_voided;
		private String merchant_staff_tag;
		private order order;
		private String other_endpoint_reference;
		private String owner;
		private String parent_transaction;
		private payment_key_claims payment_key_claims;
		private boolean pending;
		private Integer profile_id;
		private Integer refunded_amount_cents;
		private source_data source_data;
		private Integer source_id;
		private boolean success;
		private List<String> transaction_processed_callback_responses;
		private String trx_settlement_curr;
		private Integer vat_cents;
		
		
	
		

		public class data{

			private String acq_response_code;
			private Integer amount;
			private String authorize_id;
			private String avs_acq_response_code;
			private String avs_result_code;
			private String batch_no;
			private String card_num;
			private String card_type;
			private String command;
			private Calendar created_at;
			private String currency;
			private Integer gateway_integration_pk;
			private String klass;
			private String merchant;
			private String merchant_txn_ref;
			private String message;
			private String order_info;
			private String receipt_no;
			private String secure_hash;
			private String transaction_no;
			private String txn_response_code;
			public String getAcq_response_code() {
				return acq_response_code;
			}
			public void setAcq_response_code(String acq_response_code) {
				this.acq_response_code = acq_response_code;
			}
			public Integer getAmount() {
				return amount;
			}
			public void setAmount(Integer amount) {
				this.amount = amount;
			}
			public String getAuthorize_id() {
				return authorize_id;
			}
			public void setAuthorize_id(String authorize_id) {
				this.authorize_id = authorize_id;
			}
			public String getAvs_acq_response_code() {
				return avs_acq_response_code;
			}
			public void setAvs_acq_response_code(String avs_acq_response_code) {
				this.avs_acq_response_code = avs_acq_response_code;
			}
			public String getAvs_result_code() {
				return avs_result_code;
			}
			public void setAvs_result_code(String avs_result_code) {
				this.avs_result_code = avs_result_code;
			}
			public String getBatch_no() {
				return batch_no;
			}
			public void setBatch_no(String batch_no) {
				this.batch_no = batch_no;
			}
			public String getCard_num() {
				return card_num;
			}
			public void setCard_num(String card_num) {
				this.card_num = card_num;
			}
			public String getCard_type() {
				return card_type;
			}
			public void setCard_type(String card_type) {
				this.card_type = card_type;
			}
			public String getCommand() {
				return command;
			}
			public void setCommand(String command) {
				this.command = command;
			}
			public Calendar getCreated_at() {
				return created_at;
			}
			public void setCreated_at(Calendar created_at) {
				this.created_at = created_at;
			}
			public String getCurrency() {
				return currency;
			}
			public void setCurrency(String currency) {
				this.currency = currency;
			}
			public Integer getGateway_integration_pk() {
				return gateway_integration_pk;
			}
			public void setGateway_integration_pk(Integer gateway_integration_pk) {
				this.gateway_integration_pk = gateway_integration_pk;
			}
			public String getKlass() {
				return klass;
			}
			public void setKlass(String klass) {
				this.klass = klass;
			}
			public String getMerchant() {
				return merchant;
			}
			public void setMerchant(String merchant) {
				this.merchant = merchant;
			}
			public String getMerchant_txn_ref() {
				return merchant_txn_ref;
			}
			public void setMerchant_txn_ref(String merchant_txn_ref) {
				this.merchant_txn_ref = merchant_txn_ref;
			}
			public String getMessage() {
				return message;
			}
			public void setMessage(String message) {
				this.message = message;
			}
			public String getOrder_info() {
				return order_info;
			}
			public void setOrder_info(String order_info) {
				this.order_info = order_info;
			}
			public String getReceipt_no() {
				return receipt_no;
			}
			public void setReceipt_no(String receipt_no) {
				this.receipt_no = receipt_no;
			}
			public String getSecure_hash() {
				return secure_hash;
			}
			public void setSecure_hash(String secure_hash) {
				this.secure_hash = secure_hash;
			}
			public String getTransaction_no() {
				return transaction_no;
			}
			public void setTransaction_no(String transaction_no) {
				this.transaction_no = transaction_no;
			}
			public String getTxn_response_code() {
				return txn_response_code;
			}
			public void setTxn_response_code(String txn_response_code) {
				this.txn_response_code = txn_response_code;
			}
			
			
			
		}
		

		
		

		public order getOrder() {
			return order;
		}



		public void setOrder(order order) {
			this.order = order;
		}



		public data getData() {
			return data;
		}



		public void setData(data data) {
			this.data = data;
		}



		public payment_key_claims getPayment_key_claims() {
			return payment_key_claims;
		}



		public void setPayment_key_claims(payment_key_claims payment_key_claims) {
			this.payment_key_claims = payment_key_claims;
		}



		public source_data getSource_data() {
			return source_data;
		}



		public void setSource_data(source_data source_data) {
			this.source_data = source_data;
		}



		public boolean isPending() {
			return pending;
		}



		public void setPending(boolean pending) {
			this.pending = pending;
		}



		public Integer getProfile_id() {
			return profile_id;
		}



		public void setProfile_id(Integer profile_id) {
			this.profile_id = profile_id;
		}



		public Integer getRefunded_amount_cents() {
			return refunded_amount_cents;
		}



		public void setRefunded_amount_cents(Integer refunded_amount_cents) {
			this.refunded_amount_cents = refunded_amount_cents;
		}



		


		public Integer getSource_id() {
			return source_id;
		}



		public void setSource_id(Integer source_id) {
			this.source_id = source_id;
		}



		public boolean isSuccess() {
			return success;
		}



		public void setSuccess(boolean success) {
			this.success = success;
		}



		public List<String> getTransaction_processed_callback_responses() {
			return transaction_processed_callback_responses;
		}



		public void setTransaction_processed_callback_responses(List<String> transaction_processed_callback_responses) {
			this.transaction_processed_callback_responses = transaction_processed_callback_responses;
		}



		public String getTrx_settlement_curr() {
			return trx_settlement_curr;
		}



		public void setTrx_settlement_curr(String trx_settlement_curr) {
			this.trx_settlement_curr = trx_settlement_curr;
		}



		public Integer getVat_cents() {
			return vat_cents;
		}



		public void setVat_cents(Integer vat_cents) {
			this.vat_cents = vat_cents;
		}



		public Integer getAccept_fees_cents() {
			return accept_fees_cents;
		}



		public void setAccept_fees_cents(Integer accept_fees_cents) {
			this.accept_fees_cents = accept_fees_cents;
		}



		public Integer getAmount_cents() {
			return amount_cents;
		}



		public void setAmount_cents(Integer amount_cents) {
			this.amount_cents = amount_cents;
		}



		public String getApi_source() {
			return api_source;
		}



		public void setApi_source(String api_source) {
			this.api_source = api_source;
		}



		public Integer getCaptured_amount() {
			return captured_amount;
		}



		public void setCaptured_amount(Integer captured_amount) {
			this.captured_amount = captured_amount;
		}



		public Calendar getCreated_at() {
			return created_at;
		}



		public void setCreated_at(Calendar created_at) {
			this.created_at = created_at;
		}



		public String getCurrency() {
			return currency;
		}



		public void setCurrency(String currency) {
			this.currency = currency;
		}



		public boolean isError_occured() {
			return error_occured;
		}



		public void setError_occured(boolean error_occured) {
			this.error_occured = error_occured;
		}



		public boolean isHas_parent_transaction() {
			return has_parent_transaction;
		}



		public void setHas_parent_transaction(boolean has_parent_transaction) {
			this.has_parent_transaction = has_parent_transaction;
		}



		public Integer getId() {
			return id;
		}



		public void setId(Integer id) {
			this.id = id;
		}



		public Integer getIntegration_id() {
			return integration_id;
		}



		public void setIntegration_id(Integer integration_id) {
			this.integration_id = integration_id;
		}



		public boolean isIs_3d_secure() {
			return is_3d_secure;
		}



		public void setIs_3d_secure(boolean is_3d_secure) {
			this.is_3d_secure = is_3d_secure;
		}



		public boolean isIs_auth() {
			return is_auth;
		}



		public void setIs_auth(boolean is_auth) {
			this.is_auth = is_auth;
		}



		public boolean isIs_capture() {
			return is_capture;
		}



		public void setIs_capture(boolean is_capture) {
			this.is_capture = is_capture;
		}



		public boolean isIs_captured() {
			return is_captured;
		}



		public void setIs_captured(boolean is_captured) {
			this.is_captured = is_captured;
		}



		public boolean isIs_hidden() {
			return is_hidden;
		}



		public void setIs_hidden(boolean is_hidden) {
			this.is_hidden = is_hidden;
		}



		public boolean isIs_live() {
			return is_live;
		}



		public void setIs_live(boolean is_live) {
			this.is_live = is_live;
		}



		public boolean isIs_refund() {
			return is_refund;
		}



		public void setIs_refund(boolean is_refund) {
			this.is_refund = is_refund;
		}



		public boolean isIs_standalone_payment() {
			return is_standalone_payment;
		}



		public void setIs_standalone_payment(boolean is_standalone_payment) {
			this.is_standalone_payment = is_standalone_payment;
		}



		public boolean isIs_void() {
			return is_void;
		}



		public void setIs_void(boolean is_void) {
			this.is_void = is_void;
		}



		public boolean isIs_voided() {
			return is_voided;
		}



		public void setIs_voided(boolean is_voided) {
			this.is_voided = is_voided;
		}



		public String getMerchant_staff_tag() {
			return merchant_staff_tag;
		}



		public void setMerchant_staff_tag(String merchant_staff_tag) {
			this.merchant_staff_tag = merchant_staff_tag;
		}



		public String getOther_endpoint_reference() {
			return other_endpoint_reference;
		}



		public void setOther_endpoint_reference(String other_endpoint_reference) {
			this.other_endpoint_reference = other_endpoint_reference;
		}



		public String getOwner() {
			return owner;
		}



		public void setOwner(String owner) {
			this.owner = owner;
		}



		public String getParent_transaction() {
			return parent_transaction;
		}



		public void setParent_transaction(String parent_transaction) {
			this.parent_transaction = parent_transaction;
		}



		public boolean isIs_refunded() {
			return is_refunded;
		}



		public void setIs_refunded(boolean is_refunded) {
			this.is_refunded = is_refunded;
		}



		
		
		public class source_data{
			private String pan;
			private String sub_type;
			private String type;
			
			
			
			public String getPan() {
				return pan;
			}
			public void setPan(String pan) {
				this.pan = pan;
			}
			public String getSub_type() {
				return sub_type;
			}
			public void setSub_type(String sub_type) {
				this.sub_type = sub_type;
			}
			public String getType() {
				return type;
			}
			public void setType(String type) {
				this.type = type;
			}
			
			
			
			
		}

		public class order{
			private Integer amount_cents;
			private String api_source;
			private String collector;
			private Integer commission_fees;
			private Calendar created_at;
			private String currency;
			private Integer delivery_fees;
			private boolean delivery_needed;
			private String expiry;
			private Integer id;
			private boolean is_payment_locked;
			private List<String> items;
			private merchant merchant;
			private String merchant_order_id;
			private String merchant_staff_tag;
			private boolean notify_user_with_email;
			private String order_url;
			private boolean paid_amount_cents;
			private String payment_method;
			private shipping_data shipping_data;
			private String shipping_details;
			private String wallet_notification;
			
			
			public class merchant{
				private String city;
				private List<String> company_emails;
				private String company_name;
				private String country;
				private Calendar created_at;
				private Integer id;
				private List<String> phones;
				private String postal_code;
				private String state;
				private String street;
				public String getCity() {
					return city;
				}
				public void setCity(String city) {
					this.city = city;
				}
				public List<String> getCompany_emails() {
					return company_emails;
				}
				public void setCompany_emails(List<String> company_emails) {
					this.company_emails = company_emails;
				}
				public String getCompany_name() {
					return company_name;
				}
				public void setCompany_name(String company_name) {
					this.company_name = company_name;
				}
				public String getCountry() {
					return country;
				}
				public void setCountry(String country) {
					this.country = country;
				}
				public Calendar getCreated_at() {
					return created_at;
				}
				public void setCreated_at(Calendar created_at) {
					this.created_at = created_at;
				}
				public Integer getId() {
					return id;
				}
				public void setId(Integer id) {
					this.id = id;
				}
				public List<String> getPhones() {
					return phones;
				}
				public void setPhones(List<String> phones) {
					this.phones = phones;
				}
				public String getPostal_code() {
					return postal_code;
				}
				public void setPostal_code(String postal_code) {
					this.postal_code = postal_code;
				}
				public String getState() {
					return state;
				}
				public void setState(String state) {
					this.state = state;
				}
				public String getStreet() {
					return street;
				}
				public void setStreet(String street) {
					this.street = street;
				}
				
				
			}
			
			public class shipping_data{
				private String apartment;
				private String building;
				private String city;
				private String country;
				private String email;
				private String extra_description;
				private String first_name;
				private String floor;
				private Integer id;
				private String last_name;
				private String order;
				private String order_id;
				private String phone_number;
				private String postal_code;
				private String shipping_method;
				private String state;
				private String street;
				public String getApartment() {
					return apartment;
				}
				public void setApartment(String apartment) {
					this.apartment = apartment;
				}
				public String getBuilding() {
					return building;
				}
				public void setBuilding(String building) {
					this.building = building;
				}
				public String getCity() {
					return city;
				}
				public void setCity(String city) {
					this.city = city;
				}
				public String getCountry() {
					return country;
				}
				public void setCountry(String country) {
					this.country = country;
				}
				public String getEmail() {
					return email;
				}
				public void setEmail(String email) {
					this.email = email;
				}
				public String getExtra_description() {
					return extra_description;
				}
				public void setExtra_description(String extra_description) {
					this.extra_description = extra_description;
				}
				public String getFirst_name() {
					return first_name;
				}
				public void setFirst_name(String first_name) {
					this.first_name = first_name;
				}
				public String getFloor() {
					return floor;
				}
				public void setFloor(String floor) {
					this.floor = floor;
				}
				public Integer getId() {
					return id;
				}
				public void setId(Integer id) {
					this.id = id;
				}
				public String getLast_name() {
					return last_name;
				}
				public void setLast_name(String last_name) {
					this.last_name = last_name;
				}
				public String getOrder() {
					return order;
				}
				public void setOrder(String order) {
					this.order = order;
				}
				public String getOrder_id() {
					return order_id;
				}
				public void setOrder_id(String order_id) {
					this.order_id = order_id;
				}
				public String getPhone_number() {
					return phone_number;
				}
				public void setPhone_number(String phone_number) {
					this.phone_number = phone_number;
				}
				public String getPostal_code() {
					return postal_code;
				}
				public void setPostal_code(String postal_code) {
					this.postal_code = postal_code;
				}
				public String getShipping_method() {
					return shipping_method;
				}
				public void setShipping_method(String shipping_method) {
					this.shipping_method = shipping_method;
				}
				public String getState() {
					return state;
				}
				public void setState(String state) {
					this.state = state;
				}
				public String getStreet() {
					return street;
				}
				public void setStreet(String street) {
					this.street = street;
				}
				
				
				
			}

		
			
			public Integer getAmount_cents() {
				return amount_cents;
			}

			public void setAmount_cents(Integer amount_cents) {
				this.amount_cents = amount_cents;
			}

			public String getApi_source() {
				return api_source;
			}

			public void setApi_source(String api_source) {
				this.api_source = api_source;
			}

			public String getCollector() {
				return collector;
			}

			public void setCollector(String collector) {
				this.collector = collector;
			}

			public Integer getCommission_fees() {
				return commission_fees;
			}

			public void setCommission_fees(Integer commission_fees) {
				this.commission_fees = commission_fees;
			}

			public Calendar getCreated_at() {
				return created_at;
			}

			public void setCreated_at(Calendar created_at) {
				this.created_at = created_at;
			}

			public String getCurrency() {
				return currency;
			}

			public void setCurrency(String currency) {
				this.currency = currency;
			}

			public Integer getDelivery_fees() {
				return delivery_fees;
			}

			public void setDelivery_fees(Integer delivery_fees) {
				this.delivery_fees = delivery_fees;
			}

			public boolean isDelivery_needed() {
				return delivery_needed;
			}

			public void setDelivery_needed(boolean delivery_needed) {
				this.delivery_needed = delivery_needed;
			}

			public String getExpiry() {
				return expiry;
			}

			public void setExpiry(String expiry) {
				this.expiry = expiry;
			}

			public Integer getId() {
				return id;
			}

			public void setId(Integer id) {
				this.id = id;
			}

			public boolean isIs_payment_locked() {
				return is_payment_locked;
			}

			public void setIs_payment_locked(boolean is_payment_locked) {
				this.is_payment_locked = is_payment_locked;
			}

			public List<String> getItems() {
				return items;
			}

			public void setItems(List<String> items) {
				this.items = items;
			}

			public merchant getMerchant() {
				return merchant;
			}

			public void setMerchant(merchant merchant) {
				this.merchant = merchant;
			}

			public String getMerchant_order_id() {
				return merchant_order_id;
			}

			public void setMerchant_order_id(String merchant_order_id) {
				this.merchant_order_id = merchant_order_id;
			}

			public String getMerchant_staff_tag() {
				return merchant_staff_tag;
			}

			public void setMerchant_staff_tag(String merchant_staff_tag) {
				this.merchant_staff_tag = merchant_staff_tag;
			}

			public boolean isNotify_user_with_email() {
				return notify_user_with_email;
			}

			public void setNotify_user_with_email(boolean notify_user_with_email) {
				this.notify_user_with_email = notify_user_with_email;
			}

			public String getOrder_url() {
				return order_url;
			}

			public void setOrder_url(String order_url) {
				this.order_url = order_url;
			}

			public boolean isPaid_amount_cents() {
				return paid_amount_cents;
			}

			public void setPaid_amount_cents(boolean paid_amount_cents) {
				this.paid_amount_cents = paid_amount_cents;
			}

			public String getPayment_method() {
				return payment_method;
			}

			public void setPayment_method(String payment_method) {
				this.payment_method = payment_method;
			}

			public shipping_data getShipping_data() {
				return shipping_data;
			}

			public void setShipping_data(shipping_data shipping_data) {
				this.shipping_data = shipping_data;
			}

			public String getShipping_details() {
				return shipping_details;
			}

			public void setShipping_details(String shipping_details) {
				this.shipping_details = shipping_details;
			}

			public String getWallet_notification() {
				return wallet_notification;
			}

			public void setWallet_notification(String wallet_notification) {
				this.wallet_notification = wallet_notification;
			}

		
		}
	
		public class payment_key_claims{
			private Integer amount_cents;
			private billing_data billing_data;
			private String currency;
			private Integer integration_id;
			private order2 order;
			private Integer user_id;
			
			
			public class billing_data{

				private String apartment;
				private String building;
				private String city;
				private String country;
				private String email;
				private String extra_description;
				private String first_name;
				private String floor;
				private String last_name;
				private String phone_number;
				private String postal_code;
				private String state;
				private String street;
				public String getApartment() {
					return apartment;
				}
				public void setApartment(String apartment) {
					this.apartment = apartment;
				}
				public String getBuilding() {
					return building;
				}
				public void setBuilding(String building) {
					this.building = building;
				}
				public String getCity() {
					return city;
				}
				public void setCity(String city) {
					this.city = city;
				}
				public String getCountry() {
					return country;
				}
				public void setCountry(String country) {
					this.country = country;
				}
				public String getEmail() {
					return email;
				}
				public void setEmail(String email) {
					this.email = email;
				}
				public String getExtra_description() {
					return extra_description;
				}
				public void setExtra_description(String extra_description) {
					this.extra_description = extra_description;
				}
				public String getFirst_name() {
					return first_name;
				}
				public void setFirst_name(String first_name) {
					this.first_name = first_name;
				}
				public String getFloor() {
					return floor;
				}
				public void setFloor(String floor) {
					this.floor = floor;
				}
				public String getLast_name() {
					return last_name;
				}
				public void setLast_name(String last_name) {
					this.last_name = last_name;
				}
				public String getPhone_number() {
					return phone_number;
				}
				public void setPhone_number(String phone_number) {
					this.phone_number = phone_number;
				}
				public String getPostal_code() {
					return postal_code;
				}
				public void setPostal_code(String postal_code) {
					this.postal_code = postal_code;
				}
				public String getState() {
					return state;
				}
				public void setState(String state) {
					this.state = state;
				}
				public String getStreet() {
					return street;
				}
				public void setStreet(String street) {
					this.street = street;
				}
				
				
			}
			
			public class order2{
				private Integer amount_cents;
				private String currency;
				private boolean delivery_needed;
				private List<String> items;
				private String merchant_order_id;
				public Integer getAmount_cents() {
					return amount_cents;
				}
				public void setAmount_cents(Integer amount_cents) {
					this.amount_cents = amount_cents;
				}
				public String getCurrency() {
					return currency;
				}
				public void setCurrency(String currency) {
					this.currency = currency;
				}
				public boolean isDelivery_needed() {
					return delivery_needed;
				}
				public void setDelivery_needed(boolean delivery_needed) {
					this.delivery_needed = delivery_needed;
				}
				public List<String> getItems() {
					return items;
				}
				public void setItems(List<String> items) {
					this.items = items;
				}
				public String getMerchant_order_id() {
					return merchant_order_id;
				}
				public void setMerchant_order_id(String merchant_order_id) {
					this.merchant_order_id = merchant_order_id;
				}
			
				
				
				
			}

			public Integer getAmount_cents() {
				return amount_cents;
			}

			public void setAmount_cents(Integer amount_cents) {
				this.amount_cents = amount_cents;
			}

			public billing_data getBilling_data() {
				return billing_data;
			}

			public void setBilling_data(billing_data billing_data) {
				this.billing_data = billing_data;
			}

			public String getCurrency() {
				return currency;
			}

			public void setCurrency(String currency) {
				this.currency = currency;
			}

			public Integer getIntegration_id() {
				return integration_id;
			}

			public void setIntegration_id(Integer integration_id) {
				this.integration_id = integration_id;
			}

			public order2 getOrder() {
				return order;
			}

			public void setOrder(order2 order) {
				this.order = order;
			}

			public Integer getUser_id() {
				return user_id;
			}

			public void setUser_id(Integer user_id) {
				this.user_id = user_id;
			}
			
			
			
			
		}
	
	}



}
