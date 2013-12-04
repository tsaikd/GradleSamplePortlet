package org.tsaikd.java;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class SamplePortlet extends GenericPortlet {

	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		String sYourName = (String) request.getParameter("yourname");
		if (sYourName != null) {
			PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/jsp/hello.jsp");
			prd.include(request, response);
		} else {
			PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/jsp/welcome.jsp");
			prd.include(request, response);
		}
	}

	protected void doHelp(RenderRequest rRequest, RenderResponse rResponse) throws PortletException, IOException {
		rResponse.setContentType("text/html");
		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/jsp/help.jsp");
		prd.include(rRequest, rResponse);
	}

	protected void doEdit(RenderRequest rRequest, RenderResponse rResponse) throws PortletException, IOException {
		rResponse.setContentType("text/html");
		PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/jsp/edit.jsp");
		prd.include(rRequest, rResponse);
	}

	public void processAction(ActionRequest aRequest, ActionResponse aResponse) throws PortletException, IOException {
		String sYourname = (String) aRequest.getParameter("yourname");
		aResponse.setRenderParameter("yourname", sYourname);
	}

}
