<!-- A taglib directive must be added to the top of the JSP page that uses the portlet.tld custom tags -->

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "com.liferay.portal.kernel.model.Layout"%>
<%@ page contentType="text/css" %>


<!-- Any Java Server Page that needs easy and implicit access to classes defined in the 
     Portlet API needs only to add a single, special custom tag, portlet:defineObjects, to their JSP page. 
     
     After those elements have been added, you have implicit access to the variables named renderRequest, 
     renderResponse and portletConfig.-->

<portlet:defineObjects/>
<portlet:actionURL var="AddNewPage" windowState="normal" name="AddNewPage"></portlet:actionURL>
<portlet:actionURL var="GetPagesList" windowState="normal" name="GetPagesList"></portlet:actionURL>


This is the <b>New Layout</b> portlet in View mode.

<HTML>
<HEAD>

<script type="text/javascript">

function yesnoCheck() 
{
    if (document.getElementById('yesCheck').checked) 
    {
    if (document.getElementById('is_private_true').checked)
    {
    document.getElementById('privateParent').style.display = 'block';
    document.getElementById('publicParent').style.display = 'none';
    }else
    {
    document.getElementById('privateParent').style.display = 'none';
    document.getElementById('publicParent').style.display = 'block';
    }
    }else
    {
    document.getElementById('privateParent').style.display = 'none';
    document.getElementById('publicParent').style.display = 'none';
    }

}

</script>

</HEAD>
<BODY>

<form action = "<%=AddNewPage%>" method = "POST" >
		
		<%
				if (request.getAttribute("myLayoutList") != null)
				{
					List<Layout> myLayoutList = (List<Layout>) request.getAttribute("myLayoutList");
					
		%>
		
		
		<table border ="1">
		<tr><td>Name:</td><td><input type = "text" name = "name"/></td></tr>
		<tr><td>Title:</td><td><input type = "text" name = "title"/></td></tr>
		<tr><td>Description:</td><td><input type = "text" name = "description"/></td></tr>
		<tr><td>Type:</td><td><input type = "text" name = "type" value = "portlet" readonly/></td></tr>
		<tr><td>FriendlyURL:</td><td><input type = "text" name = "friendlyURL"/></td></tr>
		
			
			<tr>	
					<td>Is Private:</td>
					
					<td>
					true <input type="radio" onclick="javascript:yesnoCheck();" name="is_private" value="true" id="is_private_true"> 
					false <input type="radio" onclick="javascript:yesnoCheck();" name="is_private" value="false" id="is_private_false" checked><br> 
	         		</td>
	        </tr>
			
			<tr>	
					<td>Has Parent:</td>
					
					<td>
					true <input type="radio" onclick="javascript:yesnoCheck();" name="has_parent" value="true" id="yesCheck"> 
					false <input type="radio" onclick="javascript:yesnoCheck();" name="has_parent" value="false" id="noCheck" checked><br> 
	         		</td>
	        </tr>
			
		<tr>
					
								
					<td>
					
					Parent Layout: 
					
					</td>	
					
					<td>
					<div id = "publicParent" style = "display:none">	   				
					        				<select name="PublicParentLayoutId">
					        				
					        				<%
												for(int i=0; i<myLayoutList.size() ; i++)
												{
													if(myLayoutList.get(i).isPublicLayout() == true)
													{
											%>
					        				
											<option value="<%=myLayoutList.get(i).getLayoutId()%>"><%=myLayoutList.get(i).getName()%></option>
																	
											<%
													}
												}
											%>
											
											
											</select>							
					</div>
					<div id = "privateParent" style = "display:none">	   				
					        				<select name="PrivateParentLayoutId">
					        				
					        				<%
												for(int i=0; i<myLayoutList.size() ; i++)
												{
													if(myLayoutList.get(i).isPrivateLayout() == true)
													{
											%>
					        				
											<option value="<%=myLayoutList.get(i).getLayoutId()%>"><%=myLayoutList.get(i).getName()%></option>
																	
											<%
													}
												}
											%>
											
											
											</select>							
					</div>
					</td>
					
		</tr>
		</div>
				
			<tr><td>Hidden:</td>
				<td>
						<select name="hidden">
											<option value="false">false</option>
											<option value="true">true</option>
						</select><br/>
				</td>
			</tr>
		
		</table>
		
		<%
				}
		%>
				
		<input type = "submit" value = "New Layout" />
		</form>
		
		<form action = "<%=GetPagesList%>" method = "POST" >
		<input type = "submit" value = "Cancel" style=" color:white; background-color:red" />
		</form>

</BODY></HTML>
