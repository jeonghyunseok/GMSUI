package com.gms.web.command;

import com.gms.web.constants.Extention;
import com.gms.web.constants.PATH;

public class Command implements Commandable{
	protected String dir,action,page,view;

	public String getView() {
		return view;
	}

	public String getdir() {
		return dir;
	}

	public void setdir(String dir) {
		this.dir = dir;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Override
	public void process() {
		this.view=PATH.VIEW+dir+PATH.SEPARARTOR+page+Extention.JSP;
	}
	
	@Override
	public String toString() {
		return "Command [dest=" + dir + "/"+page+".jsp"+"action="+action+"]";
	}

	
}
