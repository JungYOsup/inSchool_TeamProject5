package com.min.inschool.dbinfo;

public class Util {

	private String arrowNbsp;
	
	//파마리터 depth는 화면에서의 depth을받음
	public String getArrowNbsp() {
		
		
		return arrowNbsp;
		
	}
	
	
	public void setArrowNbsp(String depth) {
		String nbsp="";
		
		int depthint = Integer.parseInt(depth);
		for (int i = 0; i < depthint; i++) {
			nbsp+="&nbsp;&nbsp;&nbsp;&nbsp;";
			
		}
		//이미지는 새롭게 추가
		this.arrowNbsp = (depthint>0?nbsp+"<img src='img/arrow.png' alt=''/>":"");
	}

	public Util() {
		
	}

	public static String jsForward(String msg,String url){
		String str="<script type='text/javascript'>"
				+ "alert('"+msg+"');"
				+ "location.href='"+url+"';"
				+ "</script>";
		return str;
	}


}
