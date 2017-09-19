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
<portlet:actionURL var="GetPagesList" windowState="normal" name="GetPagesList"></portlet:actionURL>
<portlet:actionURL var="CreatePagesList" windowState="normal" name="CreatePagesList"></portlet:actionURL>
<portlet:actionURL var="EditLayout" windowState="normal" name="EditLayout"></portlet:actionURL>
<portlet:actionURL var="DeleteLayout" windowState="normal" name="DeleteLayout"></portlet:actionURL>
<portlet:actionURL var="ChangeHidden" windowState="normal" name="ChangeHidden"></portlet:actionURL>
<portlet:actionURL var="LayoutApiCall" windowState="normal" name="LayoutApiCall"></portlet:actionURL>


This is the <b>New Layout</b> portlet in View mode.

		<form action = "<%=GetPagesList%>" method = "POST" >			
		<input type = "submit" value = "Get" />		
		</form>
		
		<br/>
		
			<%
				if (request.getAttribute("myLayoutList") != null && request.getAttribute("currentLayout") != null )
				{
					List<Layout> myLayoutList = (List<Layout>) request.getAttribute("myLayoutList");	
					Layout currentLayout = (Layout) request.getAttribute("currentLayout");
			%>
			
			<b>PUBLIC PAGES LIST</b>
			
			<table border = "1">
			<tr>
			<td><b>layout_ID</b></td>
			<td><b>layout_name</b></td>
			<td><b>friendly_URL</b></td>
			<td><b>has_parent</b></td>
			<td><b>parent_layout_ID</b></td>
			<td><b>is_hidden</b></td>
			<td><b>edit</b></td>
			<td><b>delete</b></td>
			</tr>
				
			
			<%
				for(int i=0; i<myLayoutList.size() ; i++)
				{		
					if(myLayoutList.get(i).isPrivateLayout() == false)
					{
			%>
			
			
			<tr>
			<td><b><%=myLayoutList.get(i).getLayoutId()%></b></td>
			<td><%=myLayoutList.get(i).getName()%></td>
			<td><%=myLayoutList.get(i).getFriendlyURL() %></td>
			<td><%=myLayoutList.get(i).hasAncestor(myLayoutList.get(i).getParentLayoutId()) %></td>
			<td><%=myLayoutList.get(i).getParentLayoutId() %></td>
			
			<td>
			<%
				if (currentLayout.getLayoutId() == myLayoutList.get(i).getLayoutId() && 
					currentLayout.isPrivateLayout() == myLayoutList.get(i).isPrivateLayout())
				{
					
				}
				else
				{
					if(myLayoutList.get(i).isHidden() == false)
					{
			%>
			
			<form action = "<%=ChangeHidden%>" method = "POST" >
			<input type="hidden" name="layout_id" value="<%=myLayoutList.get(i).getLayoutId()%>"/>
			<input type="hidden" name="is_private" value="<%=myLayoutList.get(i).isPrivateLayout()%>"/>
			<input type = "submit" value = "Visible" style=" color:white; background-color:green"/>
			</form>
			
			<%
					}
					else
					{
			%>
			
			<form action = "<%=ChangeHidden%>" method = "POST" >
			<input type="hidden" name="layout_id" value="<%=myLayoutList.get(i).getLayoutId()%>"/>
			<input type="hidden" name="is_private" value="<%=myLayoutList.get(i).isPrivateLayout()%>"/>
			<input type = "submit" value = "Hidden" style=" color:black; background-color:yellow" />
			</form>
			</td>
			
			<%
				}
			}
			%>
			<td>
			
			<%
				if (currentLayout.getLayoutId() == myLayoutList.get(i).getLayoutId() && 
					currentLayout.isPrivateLayout() == myLayoutList.get(i).isPrivateLayout())
				{
				
				}
				else
				{
			%>
			<form action = "<%=EditLayout%>" method = "POST" >
			<input type="hidden" name="layout_id" value="<%=myLayoutList.get(i).getLayoutId()%>"/>
			<input type="hidden" name="is_private" value="<%=myLayoutList.get(i).isPrivateLayout()%>"/>
			<input type = "submit" value = "Edit" style=" color:white; background-color:blue" />
			</form>
			<% } %>
			
			</td>
					
			<td>
			<%
				if (currentLayout.getLayoutId() == myLayoutList.get(i).getLayoutId() && 
					currentLayout.isPrivateLayout() == myLayoutList.get(i).isPrivateLayout())
				{
			
				}
		else
		{
			%>
			<form action = "<%=DeleteLayout%>" method = "POST" >
			<input type="hidden" name="layout_id" value="<%=myLayoutList.get(i).getLayoutId()%>"/>
			<input type="hidden" name="is_private" value="<%=myLayoutList.get(i).isPrivateLayout()%>"/>
			<input type = "submit" value="Delete" style=" color:white; background-color:red" onclick="return confirm('are you sure you want to delete Layout ID: <%=myLayoutList.get(i).getLayoutId()%> URL: <%=myLayoutList.get(i).getFriendlyURL()%> ?')" />
			</form>
			<% } %>
			</td>
			
			</tr>
			
			
			<%
					}
				}
			
			%>
			
			<%
				}
			
			%>
			
			</table>
			<br/>
			
			<!-- PRIVATE PAGES -->
			
			<%
				if (request.getAttribute("myLayoutList") != null && request.getAttribute("currentLayout") != null )
				{
					List<Layout> myLayoutList = (List<Layout>) request.getAttribute("myLayoutList");	
					Layout currentLayout = (Layout) request.getAttribute("currentLayout");
			%>
			
			<b>PRIVATE PAGES LIST</b>
			
			<table border = "1">
			<tr>
			<td><b>layout_ID</b></td>
			<td><b>layout_name</b></td>
			<td><b>friendly_URL</b></td>
			<td><b>has_parent</b></td>
			<td><b>parent_layout_ID</b></td>
			<td><b>is_hidden</b></td>
			<td><b>edit</b></td>
			<td><b>delete</b></td>
			</tr>
				
			
			<%
				for(int i=0; i<myLayoutList.size() ; i++)
				{	
					if(myLayoutList.get(i).isPrivateLayout() == true)
					{
			%>
			
			
			<tr>
			<td><b><%=myLayoutList.get(i).getLayoutId()%></b></td>
			<td><%=myLayoutList.get(i).getName()%></td>
			<td><%=myLayoutList.get(i).getFriendlyURL() %></td>
			<td><%=myLayoutList.get(i).hasAncestor(myLayoutList.get(i).getParentLayoutId()) %></td>
			<td><%=myLayoutList.get(i).getParentLayoutId() %></td>
			
			<td>
			<%
				if (currentLayout.getLayoutId() == myLayoutList.get(i).getLayoutId() && 
						currentLayout.isPrivateLayout() == myLayoutList.get(i).isPrivateLayout())
				{
				
				}
				else
				{
					if(myLayoutList.get(i).isHidden() == false)
					{
			%>
			
			<form action = "<%=ChangeHidden%>" method = "POST" >
			<input type="hidden" name="layout_id" value="<%=myLayoutList.get(i).getLayoutId()%>"/>
			<input type="hidden" name="is_private" value="<%=myLayoutList.get(i).isPrivateLayout()%>"/>
			<input type = "submit" value = "Visible" style=" color:white; background-color:green"/>
			</form>
			
			<%
				}
				else
				{
			%>
			
			<form action = "<%=ChangeHidden%>" method = "POST" >
			<input type="hidden" name="layout_id" value="<%=myLayoutList.get(i).getLayoutId()%>"/>
			<input type="hidden" name="is_private" value="<%=myLayoutList.get(i).isPrivateLayout()%>"/>
			<input type = "submit" value = "Hidden" style=" color:black; background-color:yellow" />
			</form>
			</td>
			
			<%
				}
			}
			%>
			<td>
			
			<%
				if (currentLayout.getLayoutId() == myLayoutList.get(i).getLayoutId() && 
						currentLayout.isPrivateLayout() == myLayoutList.get(i).isPrivateLayout())
				{
				
				}
				else
				{
			%>
			<form action = "<%=EditLayout%>" method = "POST" >
			<input type="hidden" name="layout_id" value="<%=myLayoutList.get(i).getLayoutId()%>"/>
			<input type="hidden" name="is_private" value="<%=myLayoutList.get(i).isPrivateLayout()%>"/>
			<input type = "submit" value = "Edit" style=" color:white; background-color:blue" />
			</form>
			<% } %>
			
			</td>
					
			<td>
			<%
				if (currentLayout.getLayoutId() == myLayoutList.get(i).getLayoutId() && 
						currentLayout.isPrivateLayout() == myLayoutList.get(i).isPrivateLayout())
				{
				
				}
				else
				{
			%>
			<form action = "<%=DeleteLayout%>" method = "POST" >
			<input type="hidden" name="layout_id" value="<%=myLayoutList.get(i).getLayoutId()%>"/>
			<input type="hidden" name="is_private" value="<%=myLayoutList.get(i).isPrivateLayout()%>"/>
			<input type = "submit" value="Delete" style=" color:white; background-color:red" onclick="return confirm('are you sure you want to delete Layout ID: <%=myLayoutList.get(i).getLayoutId()%> URL: <%=myLayoutList.get(i).getFriendlyURL()%> ?')" />
			</form>
			<% } %>
			</td>
			
			</tr>
			
			
			<%
					}
				}
			
			%>
			
			<%
				}
			
			%>
			
			</table>
			
			<br/>
			
			<table border = "0">
			<tr>
			<td>
			<form action = "<%=CreatePagesList%>" method = "POST" >			
			<input type = "submit" value = "Create" />	
			</form>
			</td>
			<td>
			<form action = "<%=LayoutApiCall%>" method = "POST" >			
			<input type = "submit" value = "Synchronise with API"/>	
			</form>
			</td>
			<tr>
			</table>
			