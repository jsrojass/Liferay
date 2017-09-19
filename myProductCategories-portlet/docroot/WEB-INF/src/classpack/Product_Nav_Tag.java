package classpack;

import java.util.ArrayList;

public class Product_Nav_Tag {
	
			/*1.*/private ArrayList<Product_Nav_Tag> myProductNavTag;
			/*2.*/private long row_id;
			/*3.*/private String nav_tag_id;
			/*4.*/private String business_id;
			/*5.*/private String description;
			/*6.*/private String date_created;
			/*7.*/private String date_modified;
			/*8.*/private boolean is_deleted;
			/*9.*/private boolean is_published;

		public Product_Nav_Tag(	long row_id, String nav_tag_id, String business_id, String description, 
								String date_created, String date_modified, boolean is_deleted, boolean is_published)
				{
						/*2.*/this.row_id = row_id;
						/*3.*/this.nav_tag_id = nav_tag_id;
						/*4.*/this.business_id = business_id;
						/*5.*/this.description = description;
						/*6.*/this.date_created = date_created;
						/*7.*/this.date_modified = date_modified;
						/*8.*/this.is_deleted = is_deleted;
						/*9.*/this.is_published = is_published;
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
	
/************************ 3. nav_tag_id: method to set and get the nav tag id ************************/
		public void setnav_tag_id( String navtagid )
		{
			nav_tag_id = navtagid; // store the nav tag id
		} // end method setnav_tag_id

		// method to retrieve the nav tag id
		public String getnav_tag_id()
		{
			return nav_tag_id;
		} // end method getnav_tag_id
		
/************************ 4. business_id: method to set and get the business id ************************/
		public void setbusiness_id( String businessid )
		{
			business_id = businessid; // store the business id
		} // end method setbusiness_id

		// method to retrieve the business id
		public String getbusiness_id()
		{
			return business_id;
		} // end method getbusiness_id
		
/************************ 5. description: method to set and get the description ************************/
		public void setdescription( String Description )
		{
			description = Description; // store the description
		} // end method setdescription

		// method to retrieve the description
		public String getdescription()
		{
			return description;
		} // end method getdescription
		
/************************ 6. date_created: method to set and get the date created ************************/
		public void setdate_created( String datecreated )
		{
			date_created = datecreated; // store the date created
		} // end method setdate_created

		// method to retrieve the date created
		public String getdate_created()
		{
			return date_created;
		} // end method getdate_created
		
/************************ 7. date_modified: method to set and get the date modified ************************/
		public void setdate_modified( String datemodified )
		{
			date_modified = datemodified; // store the date modified
		} // end method setdate_modified

		// method to retrieve the date modified
		public String getdate_modified()
		{
			return date_modified;
		} // end method getdate_modified
		
/************************ 8. is_deleted: method to set and get the is deleted ************************/
		public void setis_deleted( boolean isdeleted )
		{
			is_deleted = isdeleted; // store the is deleted
		} // end method setis_deleted

		// method to retrieve the is deleted
		public boolean getis_deleted()
		{
			return is_deleted;
		} // end method getis_deleted
		
/************************ 9. is_published: method to set and get the is published ************************/
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
