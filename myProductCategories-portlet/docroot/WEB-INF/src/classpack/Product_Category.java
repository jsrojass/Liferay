package classpack;

import java.util.ArrayList;

public class Product_Category {
	
	/*1.*/private ArrayList<Product_Category> myProductCategory;
	/*2.*/private long row_id;
	/*3.*/private String product_code;
	/*4.*/private String category_name;
	/*5.*/private boolean has_parent;
	/*6.*/private String business_id;
	/*7.*/private String date_created;
	/*8.*/private String date_modified;
	/*9.*/private String parent_category_id;
	/*10.*/private boolean is_published;
	
	public Product_Category(	long row_id, String product_code, String category_name, boolean has_parent, String business_id, String date_created, 
							String date_modified, String parent_category_id, boolean is_published	)
	{
			/*2.*/this.row_id = row_id;
			/*3.*/this.product_code = product_code;
			/*4.*/this.category_name = category_name;
			/*5.*/this.has_parent = has_parent;
			/*6.*/this.business_id = business_id;
			/*7.*/this.date_created = date_created;
			/*8.*/this.date_modified = date_modified;
			/*9.*/this.parent_category_id = parent_category_id;
			/*10.*/this.is_published = is_published;
	}
	
/************************ 2. row_id: method to set and get the row id ************************/
	public void setrow_id( long rowid )
	{
		row_id = rowid; // store the row id
	} // end method setrow_id

	// method to retrieve the row id
	public long getrow_id()
	{
		return row_id;
	} // end method getrow_id
	
/************************ 3. product_code: method to set and get the product code ************************/
	public void setproduct_code( String productcode )
	{
		product_code = productcode; // store the product code
	} // end method setproduct_code

	// method to retrieve the product code
	public String getproduct_code()
	{
		return product_code;
	} // end method getproduct_code

/************************ 4. category_name: method to set and get the category name ************************/
	public void setcategory_name( String categoryname )
	{
		category_name = categoryname; // store the category name
	} // end method setcategory_name

	// method to retrieve the category name
	public String getcategory_name()
	{
		return category_name;
	} // end method getcategory_name
	
/************************ 5. has_parent: method to set and get the has parent ************************/
	public void sethas_parent(  boolean hasparent )
	{
		has_parent = hasparent; // store the has parent
	} // end method sethas_parent

	// method to retrieve the has parent
	public boolean gethas_parent()
	{
		return has_parent;
	} // end method gethas_parent
	
/************************ 6. business_id: method to set and get the business id ************************/
	public void setbusiness_id( String businessid )
	{
		business_id = businessid; // store the business id
	} // end method setbusiness_id

	// method to retrieve the business id
	public String getbusiness_id()
	{
		return business_id;
	} // end method getbusiness_id
	
/************************ 7. date_created: method to set and get the date created ************************/
	public void setdate_created( String datecreated )
	{
		date_created = datecreated; // store the date created
	} // end method setdate_created

	// method to retrieve the date created
	public String getdate_created()
	{
		return date_created;
	} // end method getdate_created
	
/************************ 8. date_modified: method to set and get the date modified ************************/
	public void setdate_modified( String datemodified )
	{
		date_modified = datemodified; // store the date modified
	} // end method setdate_modified

	// method to retrieve the date modified
	public String getdate_modified()
	{
		return date_modified;
	} // end method getdate_modified
	
/************************ 9. parent_category_id: method to set and get the parent category id ************************/
	public void setparent_category_id( String parentcategoryid )
	{
		parent_category_id = parentcategoryid; // store the parent category id
	} // end method setparent_category_id

	// method to retrieve the parent category id
	public String getparent_category_id()
	{
		return parent_category_id;
	} // end method getparent_category_id
	
/************************ 10. is_published: method to set and get the is published ************************/
	public void setis_published( boolean ispublished )
	{
		is_published = ispublished; // store the is published
	} // end method setis_published

	// method to retrieve the is published
	public boolean getis_published()
	{
		return is_published;
	} // end method getis_published

}
