package classpack;

public class Report_Date 
{
	
	private int report_id;
    private String report_date;

    public Report_Date(int report_id, String report_date)
    {
        this.report_id = report_id;   
    	this.report_date = report_date;
    }

    public int getReport_id() 
    {
           return report_id;
    }
   
    public String getReport_date() 
    {
           return report_date;
    }

    public void setReport_id(int report_id) 
    {
           this.report_id = report_id;
    }
   
    public void setReport_date( String report_date) 
    {
           this.report_date = report_date;
    }

}
