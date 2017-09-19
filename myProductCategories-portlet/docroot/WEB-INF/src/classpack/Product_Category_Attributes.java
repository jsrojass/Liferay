package classpack;

import java.util.ArrayList;

public class Product_Category_Attributes {
	
	/*0.*/ private ArrayList<Product_Category_Attributes> myProductCategoryAttributes;
	/*1.*/ private long row_id;
	/*2.*/ private String product_code;
	/*3.*/ private String business_id;
	/*4.*/ private String suitable_for;
	///////private boolean is_active1;
	/*6.*/ private String units_of_competency;
	///////private boolean is_active2;
	/*8.*/ private String qualification_outcomes;
	///////private boolean is_active3;
	/*10.*/private String pre_requisite_information;
	///////private boolean is_active4;
	/*12.*/private String rpl;
	///////private boolean is_active5;
	/*14.*/private String payment_options;
	///////private boolean is_active6;
	/*16.*/private String refund_policy;
	///////private boolean is_active7;
	/*18.*/private String related_courses;
	///////private boolean is_active8;
	/*20.*/private String max_students;
	///////private boolean is_active9;
	/*22.*/private String further_opportunities;
	///////private boolean is_active10;
	/*24.*/private String faq;
	///////private boolean is_active11;
	/*26.*/private String further_information;
	///////private boolean is_active12;
	/*28.*/private String date_created;
	/*29.*/private String date_modified;
	/*30.*/private boolean is_deleted;
	/*31.*/private boolean is_published;
	/*32.*/private Boolean[] is_active = new Boolean[12];
	
	public Product_Category_Attributes(	long row_id, 
										String product_code, 
										String business_id, 
										String suitable_for, 
										//boolean is_active1, 
										String units_of_competency, 
										//boolean is_active2, 
										String qualification_outcomes, 
										//boolean is_active3, 
										String pre_requisite_information, 
										//boolean is_active4, 
										String rpl, 
										//boolean is_active5, 
										String payment_options, 
										//boolean is_active6, 
										String refund_policy, 
										//boolean is_active7, 
										String related_courses, 
										//boolean is_active8, 
										String max_students,  
										//boolean is_active9, 
										String further_opportunities, 
										//boolean is_active10, 
										String faq, 
										//boolean is_active11, 
										String further_information, 
										//boolean is_active12, 
										String date_created, 
										String date_modified, 
										boolean is_deleted, 
										boolean is_published,
										Boolean[] is_active
										)
	{
		
		
		/*1.*/this.row_id = row_id;
		/*2.*/this.product_code = product_code;
		/*3.*/this.business_id = business_id;
		/*4.*/this.suitable_for = suitable_for;
		///////this.is_active1 = is_active1;
		/*6.*/this.units_of_competency = units_of_competency;
		///////this.is_active2 = is_active2;
		/*8.*/this.qualification_outcomes = qualification_outcomes;
		///////this.is_active3 = is_active3;
		/*10.*/this.pre_requisite_information = pre_requisite_information;
		///////this.is_active4 = is_active4;
		/*12.*/this.rpl = rpl;
		///////this.is_active5 = is_active5;
		/*14.*/this.payment_options = payment_options;
		///////this.is_active6 = is_active6;
		/*16.*/this.refund_policy = refund_policy;
		///////this.is_active7 = is_active7;
		/*18.*/this.related_courses = related_courses;
		///////this.is_active8 = is_active8;
		/*20.*/this.max_students = max_students;
		///////this.is_active9 = is_active9;
		/*22.*/this.further_opportunities = further_opportunities;
		///////this.is_active10 = is_active10;
		/*24.*/this.faq = faq;
		///////this.is_active11 = is_active11;
		/*26.*/this.further_information = further_information;
		///////this.is_active12 = is_active12;
		/*28.*/this.date_created = date_created;
		/*29.*/this.date_modified = date_modified;
		/*30.*/this.is_deleted = is_deleted;
		/*31.*/this.is_published = is_published;
		/*32.*/this.is_active = is_active;
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
	
/************************ 2. product_code: method to set and get the product code ************************/
	public void setproduct_code( String productcode )
	{
		product_code = productcode; // store the product code
	} // end method setproduct_code
    
	// method to retrieve the product code
	public String getproduct_code()
	{
		return product_code;
	} // end method getproduct_code
	
/************************ 3. business_id: method to set and get the business id ************************/
	public void setbusiness_id( String businessid )
	{
		business_id = businessid; // store the business id
	} // end method setbusiness_id

	// method to retrieve the business id
	public String getbusiness_id()
	{
		return business_id;
	} // end method getbusiness_id
	
/************************ 4. suitable_for: method to set and get the suitable for ************************/
	public void setsuitable_for( String suitablefor )
	{
		suitable_for = suitablefor; // store the suitable for
	} // end method setsuitable_for

	// method to retrieve the suitable for
	public String getsuitable_for()
	{
		return suitable_for;
	} // end method getsuitable_for
	
/************************ 5. is_active1: method to set and get the is active1 ************************/
	//public void setis_active1( boolean isactive1 )
	//{
	//	is_active1 = isactive1; // store the is active1
	//} // end method setis_active1
	//
	// method to retrieve the is active1
	//public boolean getis_active1()
	//{
	//	return is_active1;
	//} // end method getis_active1
	
/************************ 6. units_of_competency: method to set and get the units of competency ************************/
	public void setunits_of_competency( String unitsofcompetency )
	{
		units_of_competency = unitsofcompetency; // store the units of competency
	} // end method setunits_of_competency

	// method to retrieve the units of competency
	public String getunits_of_competency()
	{
		return units_of_competency;
	} // end method getunits_of_competency
	
/************************ 7. is_active2: method to set and get the is active2 ************************/
	//public void setis_active2( boolean isactive2 )
	//{
	//	is_active2 = isactive2; // store the is active2
	//} // end method setis_active2
	//
	// method to retrieve the is active2
	//public boolean getis_active2()
	//{
	//	return is_active2;
	//} // end method getis_active2
	
/************************ 8. qualification_outcomes: method to set and get the qualification outcomes ************************/
	public void setqualification_outcomes( String qualificationoutcomes )
	{
		qualification_outcomes = qualificationoutcomes; // store the qualification outcomes
	} // end method setqualification_outcomes

	// method to retrieve the qualification outcomes
	public String getqualification_outcomes()
	{
		return qualification_outcomes;
	} // end method getqualification_outcomes
	
/************************ 9. is_active3: method to set and get the is active3 ************************/
	//public void setis_active3( boolean isactive3 )
	//{
	//	is_active3 = isactive3; // store the is active3
	//} // end method setis_active3
	//
	// method to retrieve the is active3
	//public boolean getis_active3()
	//{
	//	return is_active3;
	//} // end method getis_active3
	
/************************ 10. pre_requisite_information: method to set and get the pre requisite information ************************/
	public void setpre_requisite_information( String prerequisiteinformation )
	{
		pre_requisite_information = prerequisiteinformation; // store the pre requisite information
	} // end method setpre_requisite_information

	// method to retrieve the pre requisite information
	public String getpre_requisite_information()
	{
		return pre_requisite_information;
	} // end method getpre_requisite_information
	
/************************ 11. is_active4: method to set and get the is active4 ************************/
	//public void setis_active4( boolean isactive4 )
	//{
	//	is_active4 = isactive4; // store the is active4
	//} // end method setis_active4
	//
	// method to retrieve the is active4
	//public boolean getis_active4()
	//{
	//	return is_active4;
	//} // end method getis_active4

/************************ 12. rpl: method to set and get the rpl ************************/
	public void setrpl( String RPL )
	{
		rpl = RPL; // store the rpl
	} // end method setrpl

	// method to retrieve the rpl
	public String getrpl()
	{
		return rpl;
	} // end method getrpl
	
/************************ 13. is_active5: method to set and get the is active5 ************************/
	//public void setis_active5( boolean isactive5 )
	//{
	//	is_active5 = isactive5; // store the is active5
	//} // end method setis_active5
	//
	// method to retrieve the is active5
	//public boolean getis_active5()
	//{
	//	return is_active5;
	//} // end method getis_active5
	
/************************ 14. payment_options: method to set and get the payment options ************************/
	public void setpayment_options( String paymentoptions )
	{
		payment_options = paymentoptions; // store the payment options
	} // end method setpayment_options

	// method to retrieve the payment options
	public String getpayment_options()
	{
		return payment_options;
	} // end method getpayment_options
	
/************************ 15. is_active6: method to set and get the is active6 ************************/
	//public void setis_active6( boolean isactive6 )
	//{
	//	is_active6 = isactive6; // store the is active6
	//} // end method setis_active6
	//
	// method to retrieve the is active6
	//public boolean getis_active6()
	//{
	//	return is_active6;
	//} // end method getis_active6
	
/************************ 16. refund_policy: method to set and get the refund policy ************************/
	public void setrefund_policy( String refundpolicy )
	{
		refund_policy = refundpolicy; // store the refund policy
	} // end method setrefund_policy

	// method to retrieve the refund policy
	public String getrefund_policy()
	{
		return refund_policy;
	} // end method getrefund_policy
	
/************************ 17. is_active7: method to set and get the is active7 ************************/
	//public void setis_active7( boolean isactive7 )
	//{
	//	is_active7 = isactive7; // store the is active7
	//} // end method setis_active7
	//
	// method to retrieve the is active7
	//public boolean getis_active7()
	//{
	//	return is_active7;
	//} // end method getis_active7
	
/************************ 18. related_courses: method to set and get the related courses ************************/
	public void setrelated_courses( String relatedcourses )
	{
		related_courses = relatedcourses; // store the related courses
	} // end method setrelated_courses

	// method to retrieve the related courses
	public String getrelated_courses()
	{
		return related_courses;
	} // end method getrelated_courses
	
/************************ 19. is_active8: method to set and get the is active8 ************************/
	//public void setis_active8( boolean isactive8 )
	//{
	//	is_active8 = isactive8; // store the is active8
	//} // end method setis_active8
	//
	// method to retrieve the is active8
	//public boolean getis_active8()
	//{
	//	return is_active8;
	//} // end method getis_active8
	
/************************ 20. max_students: method to set and get the max students ************************/
	public void setmax_students( String maxstudents )
	{
		max_students = maxstudents; // store the max students
	} // end method setmax_students

	// method to retrieve the max students
	public String getmax_students()
	{
		return max_students;
	} // end method getmax_students
	
/************************ 21. is_active9: method to set and get the is active9 ************************/
	//public void setis_active9( boolean isactive9 )
	//{
	//	is_active9 = isactive9; // store the is active9
	//} // end method setis_active9
	//
	// method to retrieve the is active9
	//public boolean getis_active9()
	//{
	//	return is_active9;
	//} // end method getis_active9
	
/************************ 22. further_opportunities: method to set and get the further opportunities ************************/
	public void setfurther_opportunities( String furtheropportunities )
	{
		further_opportunities = furtheropportunities; // store the further opportunities
	} // end method setfurther_opportunities

	// method to retrieve the further opportunities
	public String getfurther_opportunities()
	{
		return further_opportunities;
	} // end method getfurther_opportunities
	
/************************ 23. is_active10: method to set and get the is active10 ************************/
	//public void setis_active10( boolean isactive10 )
	//{
	//	is_active10 = isactive10; // store the is active10
	//} // end method setis_active10
	//
	// method to retrieve the is active10
	//public boolean getis_active10()
	//{
	//	return is_active10;
	//} // end method getis_active10
	
/************************ 24. faq: method to set and get the FAQ ************************/
	public void setfaq( String FAQ )
	{
		faq = FAQ; // store the FAQ
	} // end method setfaq

	// method to retrieve the FAQ
	public String getfaq()
	{
		return faq;
	} // end method getfaq
	
/************************ 25. is_active11: method to set and get the is active11 ************************/
	//public void setis_active11( boolean isactive11 )
	//{
	//	is_active11 = isactive11; // store the is active11
	//} // end method setis_active11
	//
	// method to retrieve the is active11
	//public boolean getis_active11()
	//{
	//	return is_active11;
	//} // end method getis_active11
	
/************************ 26. further_information: method to set and get the further information ************************/
	public void setfurther_information( String furtherinformation )
	{
		further_information = furtherinformation; // store the further information
	} // end method setfurther_information

	// method to retrieve the further information
	public String getfurther_information()
	{
		return further_information;
	} // end method getfurther_information
	
/************************ 27. is_active12: method to set and get the is active12 ************************/
	//public void setis_active12( boolean isactive12 )
	//{
	//	is_active12 = isactive12; // store the is active12
	//} // end method setis_active12
	//
	// method to retrieve the is active12
	//public boolean getis_active12()
	//{
	//	return is_active12;
	//} // end method getis_active12
	
/************************ 28. date_created: method to set and get the date created ************************/
	public void setdate_created( String datecreated )
	{
		date_created = datecreated; // store the date created
	} // end method setdate_created

	// method to retrieve the date created
	public String getdate_created()
	{
		return date_created;
	} // end method getdate_created
	
/************************ 29. date_modified: method to set and get the date modified ************************/
	public void setdate_modified( String datemodified )
	{
		date_modified = datemodified; // store the date modified
	} // end method setdate_modified

	// method to retrieve the date modified
	public String getdate_modified()
	{
		return date_modified;
	} // end method getdate_modified
	
/************************ 30. is_deleted: method to set and get the is deleted ************************/
	public void setis_deleted( boolean isdeleted )
	{
		is_deleted = isdeleted; // store the is deleted
	} // end method setis_deleted

	// method to retrieve the is deleted
	public boolean getis_deleted()
	{
		return is_deleted;
	} // end method getis_deleted
	
/************************ 31. is_published: method to set and get the is published ************************/
	public void setis_published( boolean ispublished )
	{
		is_published = ispublished; // store the is published
	} // end method setis_published

	// method to retrieve the is published
	public boolean getis_published()
	{
		return is_published;
	} // end method getis_published
	
/************************ 32. is_active: method to set and get the is active[] ************************/
	public void setis_active( int i, boolean isactive)
	{
		is_active[i] = isactive; // store the is published
	} // end method setis_published

	// method to retrieve the is published
	public boolean getis_active(int i)
	{
		return is_active[i];
	} // end method getis_published
	


}
