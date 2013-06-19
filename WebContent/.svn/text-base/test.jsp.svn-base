<%@ page
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@page import="_212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.ResponseTypeDATAMessageBodyList"%>
<%@page import="sp.sac.SOWNN00245ClientGpki"%>


<%


System.out.println("-------------------------------------------------------------");
ResponseTypeDATAMessageBodyList[] resMSGLists = SOWNN00245ClientGpki.callWS(-14);

for (ResponseTypeDATAMessageBodyList resMSGList : resMSGLists) {
	out.println("------------------------------");
	out.println("민원접수번호    :" + resMSGList.getMw_take_no());
	out.println("<br>");
	out.println("접수일자         :" + resMSGList.getTake_ymd());
	out.println("<br>");
	out.println("접수시간        :" + resMSGList.getTake_tm());
	out.println("<br>");
	out.println("접수자성명      :" + resMSGList.getUser_name());
	out.println("<br>");
	out.println("민원서류수령사용자ID:" + resMSGList.getMw_pps_getr_id());
	out.println("<br>");
	out.println("민원서류수령사용자명:" + resMSGList.getOutvars());
	out.println("<br>");
	out.println("민원사무약명    :" + resMSGList.getMw_afr_shtnm());
	out.println("<br>");
	out.println("민원구분        :" + resMSGList.getMw_se());
	out.println("<br>");
	out.println("민원신청인명    :" + resMSGList.getMw_aplct_nm());
	out.println("<br>");
	out.println("민원신청인주소  :" + resMSGList.getMw_aplct_addr());
	out.println("<br>");
	out.println("민원구분명      :" + resMSGList.getMw_code_cn());
	out.println("<br>");
	out.println("수납수수료      :" + resMSGList.getRecpt_fee());
	out.println("<br>");
	out.println("접수확인코드    :" + resMSGList.getTake_confrm_code());
	out.println("<br>");
	out.println("처리구분        :" + resMSGList.getDeal_se());
	out.println("<br>");
	out.println("처리구분명      :" + resMSGList.getDeal_code_cn());
	out.println("<br>");
	out.println("접수구분        :" + resMSGList.getTake_se());
	out.println("<br>");
	out.println("접수구분코드명  :" + resMSGList.getTake_code_cn());
	out.println("<br>");
	out.println("실제처리일자    :" + resMSGList.getReal_deal_ymd());
	out.println("<br>");
	out.println("처리예정일      :" + resMSGList.getDeal_plan_ymd());
	out.println("<br>");
	out.println("민원사무분류번호:" + resMSGList.getCgg_mw_afr_cl_no());
	out.println("<br>");
	out.println("민원목록총갯수  :" + resMSGList.getCnt());
	out.println("<br>");
	
}
	
%>