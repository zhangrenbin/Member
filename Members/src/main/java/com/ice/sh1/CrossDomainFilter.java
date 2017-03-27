package com.ice.sh1;

import ice.tool.PropertiesProvider;
import ice.tool.validation.StringValidator;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CrossDomainFilter implements Filter {
	
	private String[] allowIps;

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain arg2) throws IOException, ServletException {
		String clientip = req.getRemoteAddr();
		HttpServletResponse hresp = (HttpServletResponse)resp;
		for (String ip : allowIps) {
			if(clientip.equals(ip)) {
				hresp.addHeader("Access-Control-Allow-Origin", "*");
				break;
			}
		}
		arg2.doFilter(req, resp);
	}

	public void init(FilterConfig c) throws ServletException {
		PropertiesProvider pp = PropertiesProvider.getInstance("/ice.properties");
		String ips = pp.getValue("cross_ip");
		if(StringValidator.isEmpty(ips)) {
			return;
		}
		allowIps = ips.split(",");
	}

}
