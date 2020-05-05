package com;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HospitalAPI")
public class HospitalAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HospitalService hospitalService = new HospitalService();

	
	public HospitalAPI() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String output = hospitalService.insertHospital(request.getParameter("hospitalName"),
				request.getParameter("city"), request.getParameter("address"), request.getParameter("email"),request.getParameter("contactNumber"));

		response.getWriter().write(output);

	}
	
	// Convert request parameters to a Map
		private static Map getParasMap(HttpServletRequest request) {
			Map<String, String> map = new HashMap<String, String>();
			try {
				Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
				String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
				scanner.close();
				String[] params = queryString.split("&");
				for (String param : params) {
					String[] p = param.split("=");
					map.put(p[0], p[1]);
				}
			} catch (Exception e) {
			}
			return map;
		}
		
		protected void doPut(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			 Map paras = getParasMap(request);
			 String output = hospitalService.updateHospital(paras.get("hidHospitalIDSave").toString(),
			 paras.get("hospitalName").toString(),
			 paras.get("city").toString(),
			 paras.get("address").toString(),
			 paras.get("email").toString(),
			 paras.get("contactNumber").toString());
		}
		
		protected void doDelete(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			 Map paras = getParasMap(request);
			 String output = hospitalService.deleteHospital(paras.get("id").toString());
			response.getWriter().write(output);
		}

}
