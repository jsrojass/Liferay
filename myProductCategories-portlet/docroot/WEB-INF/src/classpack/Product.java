package classpack;

import java.util.ArrayList;

public class Product {
	
	
				/*1.*/private ArrayList<Product> myProduct;
				/*2.*/private long row_id;
				/*3.*/private String product_id;
				/*4.*/private String product_type_id;
				/*5.*/private String product_code;
				/*6.*/private String external_id;
				/*7.*/private String product_name;
				/*8.*/private String product_web_name;
				/*9.*/private String name_as_webname;
				/*10.*/private String product_group_id;
				/*11.*/private String product_group_type_name;
				/*12.*/private String delivery_type_name;
				/*13.*/private String duration;
				/*14.*/private String stream_name;
				/*15.*/private String short_description;
				/*16.*/private String domain_id;
				/*17.*/private String location_id;
				/*18.*/private String default_price;
				/*19.*/private String business_id;
				/*20.*/private boolean is_active;
				/*21.*/private boolean is_published;
				/*22.*/private String date_created;
				/*23.*/private String date_modified;
				/*24.*/private boolean has_attribute;
				/*25.*/private boolean has_inventory;
				/*26.*/private String p_image_url;
		
	public Product(long row_id, String product_id, String product_type_id, String product_code, 
					String external_id, String product_name, String product_web_name, String name_as_webname, 
					String product_group_id, String product_group_type_name, String delivery_type_name, String duration, 
					String stream_name, String short_description, String domain_id, String location_id, String default_price, 
					String business_id, boolean is_active, boolean is_published, String date_created, String date_modified, 
					boolean has_attribute, boolean has_inventory, String p_image_url)
	{
					/*1.*/this.row_id = row_id;
					/*2.*/this.product_id = product_id;
					/*3.*/this.product_type_id = product_type_id;
					/*4.*/this.product_code = product_code;
					/*5.*/this.external_id = external_id;
					/*6.*/this.product_name = product_name;
					/*7.*/this.product_web_name = product_web_name;
					/*8.*/this.name_as_webname = name_as_webname;
					/*9.*/this.product_group_id = product_group_id;
					/*10*/this.product_group_type_name = product_group_type_name;
					/*11.*/this.delivery_type_name = delivery_type_name;
					/*12.*/this.duration = duration;
					/*13.*/this.stream_name = stream_name;
					/*14.*/this.short_description = short_description;
					/*15.*/this.domain_id = domain_id;
					/*16.*/this.location_id = location_id;
					/*17.*/this.default_price = default_price;
					/*18.*/this.business_id = business_id;
					/*19.*/this.is_active = is_active;
					/*20.*/this.is_published = is_published;
					/*21.*/this.date_created = date_created;
					/*22.*/this.date_modified = date_modified;
					/*23.*/this.has_attribute = has_attribute;
					/*24.*/this.has_inventory = has_inventory;
					/*25.*/this.p_image_url = p_image_url;
		
	}
	
/************************ 1. row_id: method to set and get the row id ************************/
	public void setrow_id( long rowid )
	{
		row_id = rowid; // store the row id
	} // end method setrow_id

	// method to retrieve the row id
	public long getrow_id()
	{
		return row_id;
	} // end method getrow_id
	
/************************ 2. product_id: method to set and get the product id ************************/
	public void setproduct_id( String productid )
	{
		product_id = productid; // store the product id
	} // end method setproduct_id

	// method to retrieve the product id
	public String getproduct_id()
	{
		return product_id;
	} // end method getproduct_id
	
/************************ 3. product_type_id: method to set and get the product type id ************************/
	public void setproduct_type_id( String producttypeid )
	{
		product_type_id = producttypeid; // store the product type id
	} // end method setproduct_type_id

	// method to retrieve the product type id
	public String getproduct_type_id()
	{
		return product_type_id;
	} // end method getproduct_type_id

/************************ 4. product_code: method to set and get the product code ************************/
	public void setproduct_code( String productcode )
	{
		product_code = productcode; // store the product code
	} // end method setproduct_code

	// method to retrieve the product code
	public String getproduct_code()
	{
		return product_code;
	} // end method getproduct_code
	
/************************ 5. external_id: method to set and get the external id ************************/
	public void setexternal_id( String externalid )
	{
		external_id = externalid; // store the external id
	} // end method setexternal_id

	// method to retrieve the external id
	public String getexternal_id()
	{
		return external_id;
	} // end method getexternal_id
	
/************************ 6. product_name: method to set and get the product name ************************/
	public void setproduct_name( String productname )
	{
		product_name = productname; // store the product name
	} // end method setproduct_name

	// method to retrieve the product name
	public String getproduct_name()
	{
		return product_name;
	} // end method getproduct_name
	
/************************ 7. product_web_name: method to set and get the product web name ************************/
	public void setproduct_web_name( String productwebname )
	{
		product_web_name = productwebname; // store the product web name
	} // end method setproduct_web_name

	// method to retrieve the product web name
	public String getproduct_web_name()
	{
		return product_web_name;
	} // end method getproduct_web_name
	
/************************ 8. name_as_webname: method to set and get the name as web name ************************/
	public void setname_as_webname( String nameaswebname )
	{
		name_as_webname = nameaswebname; // store the name as web name
	} // end method setname_as_webname

	// method to retrieve the name as web name
	public String getname_as_webname()
	{
		return name_as_webname;
	} // end method getname_as_webname
	
/************************ 9. product_group_id: method to set and get the product group id ************************/
	public void setproduct_group_id( String productgroupid )
	{
		product_group_id = productgroupid; // store the product group id
	} // end method setproduct_group_id

	// method to retrieve the product group id
	public String getproduct_group_id()
	{
		return product_group_id;
	} // end method getproduct_group_id
	
/************************ 10. product_group_type_name: method to set and get the product group type name ************************/
	public void setproduct_group_type_name( String productgrouptypename )
	{
		product_group_type_name = productgrouptypename; // store the product group type name
	} // end method setproduct_group_type_name

	// method to retrieve the product group type name
	public String getproduct_group_type_name()
	{
		return product_group_type_name;
	} // end method getproduct_group_type_name
	
/************************ 11. delivery_type_name: method to set and get the delivery type name ************************/
	public void setdelivery_type_name( String deliverytypename )
	{
		delivery_type_name = deliverytypename; // store the delivery type name
	} // end method setdelivery_type_name

	// method to retrieve the delivery type name
	public String getdelivery_type_name()
	{
		return delivery_type_name;
	} // end method getdelivery_type_name
	
/************************ 12. duration: method to set and get the duration ************************/
	public void setduration( String this_duration )
	{
		duration = this_duration; // store the duration
	} // end method setduration

	// method to retrieve the duration
	public String getduration()
	{
		return duration;
	} // end method getduration
	
/************************ 13. stream_name: method to set and get the stream name ************************/
	public void setstream_name( String streamname )
	{
		stream_name = streamname; // store the stream name
	} // end method setstream_name

	// method to retrieve the stream name
	public String getstream_name()
	{
		return stream_name;
	} // end method getstream_name
	
/************************ 14. short_description: method to set and get the short description ************************/
	public void setshort_description( String shortdescription )
	{
		short_description = shortdescription; // store the short description
	} // end method setshort_description

	// method to retrieve the short description
	public String getshort_description()
	{
		return short_description;
	} // end method getshort_description
	
/************************ 15. domain_id: method to set and get the domain id ************************/
	public void setdomain_id( String domainid )
	{
		domain_id = domainid; // store the domain id
	} // end method setdomain_id

	// method to retrieve the domain id
	public String getdomain_id()
	{
		return domain_id;
	} // end method getdomain_id
	
/************************ 16. location_id: method to set and get the location id ************************/
	public void setlocation_id( String locationid )
	{
		location_id = locationid; // store the location id
	} // end method setlocation_id

	// method to retrieve the location id
	public String getlocation_id()
	{
		return location_id;
	} // end method getlocation_id
	
/************************ 17. default_price: method to set and get the default price ************************/
	public void setdefault_price( String defaultprice )
	{
		default_price = defaultprice; // store the default price
	} // end method setdefault_price

	// method to retrieve the default price
	public String getdefault_price()
	{
		return default_price;
	} // end method getdefault_price
	
/************************ 18. business_id: method to set and get the business id ************************/
	public void setbusiness_id( String businessid )
	{
		business_id = businessid; // store the business id
	} // end method setbusiness_id

	// method to retrieve the business id
	public String getbusiness_id()
	{
		return business_id;
	} // end method getbusiness_id
	
/************************ 19. is_active: method to set and get the is active ************************/
	public void setis_active( boolean isactive )
	{
		is_active = isactive; // store the is active
	} // end method setis_active

	// method to retrieve the is active
	public boolean getis_active()
	{
		return is_active;
	} // end method getis_active
	
/************************ 20. is_published: method to set and get the is published ************************/
	public void setis_published( boolean ispublished )
	{
		is_published = ispublished; // store the is published
	} // end method setis_published

	// method to retrieve the is published
	public boolean getis_published()
	{
		return is_published;
	} // end method getis_published
	
/************************ 21. date_created: method to set and get the date created ************************/
	public void setdate_created( String datecreated )
	{
		date_created = datecreated; // store the date created
	} // end method setdate_created

	// method to retrieve the date created
	public String getdate_created()
	{
		return date_created;
	} // end method getdate_created
	
/************************ 22. date_modified: method to set and get the date modified ************************/
	public void setdate_modified( String datemodified )
	{
		date_modified = datemodified; // store the date modified
	} // end method setdate_modified

	// method to retrieve the date modified
	public String getdate_modified()
	{
		return date_modified;
	} // end method getdate_modified
	
/************************ 23. has_attribute: method to set and get the has attribute ************************/
	public void sethas_attribute( boolean hasattribute )
	{
		has_attribute = hasattribute; // store the has attribute
	} // end method sethas_attribute

	// method to retrieve the has attribute
	public boolean gethas_attribute()
	{
		return has_attribute;
	} // end method gethas_attribute
	
/************************ 24. has_inventory: method to set and get the has inventory ************************/
	public void sethas_inventory( boolean hasinventory )
	{
		has_inventory = hasinventory; // store the has inventory
	} // end method sethas_inventory

	// method to retrieve the has inventory
	public boolean gethas_inventory()
	{
		return has_inventory;
	} // end method gethas_inventory
	
/************************ 25. p_image_url: method to set and get the p image url ************************/
	public void setp_image_url( String pimageurl )
	{
		p_image_url = pimageurl; // store the p image url
	} // end method setp_image_url

	// method to retrieve the p image url
	public String getp_image_url()
	{
		return p_image_url;
	} // end method getp_image_url

	


}
