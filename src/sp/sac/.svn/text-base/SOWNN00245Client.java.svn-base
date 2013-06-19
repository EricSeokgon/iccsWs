package sp.sac;

import kjf.cfg.Config;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;
import _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.RequestType;
import _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.RequestTypeDATA;
import _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.RequestTypeDATAMessage;
import _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.RequestTypeDATAMessageBody;
import _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.ResponseType;
import _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.ResponseTypeDATA;
import _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.ResponseTypeDATAMessage;
import _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.ResponseTypeDATAMessageBodyList;
import _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.SOWNN00245PortTypeProxy;


public class SOWNN00245Client {
    
    private static String IFID						= "SOWNN00245";
    private static String END_POINT					;
    private static String CGG_CODE					;
    private static String SOURCE_CODE				;
    private static String TARGET_CODE				;   
    private static int	DATE_DIFF					; 
    

    public static void init( int diffDay){
    	int dDay = diffDay<0?diffDay:KJFUtil.str2int(KJFUtil.print(Config.props.get("DATE_DIFF"),"-14"));
    	END_POINT 	= "http://"+KJFUtil.print(Config.props.get("SEALL_IP"))+":3002/stmr/websvc/std/ws?wsdl=SOWNN00245";
    	CGG_CODE 	= KJFUtil.print(Config.props.get("SIGUNGU_CGG_CODE"));
    	SOURCE_CODE = KJFUtil.print(Config.props.get("SIGUNGU_SOURCE_CODE"));
    	TARGET_CODE = KJFUtil.print(Config.props.get("SIGUNGU_TARGET_CODE"));
    	DATE_DIFF 	= dDay;
    }
    

	public static ResponseTypeDATAMessageBodyList[] callWS( int diffDay) {
		
		//기본값 세팅
		init(diffDay);
		RequestType rt = null;
		ResponseType resType = null;
		
		try {
			SOWNN00245PortTypeProxy ws = new SOWNN00245PortTypeProxy(END_POINT);			
         
			////////////////////////////////////////////////////////////////////////
			RequestTypeDATA rtData = null;
			RequestTypeDATAMessage rtMSG = null;			
			RequestTypeDATAMessageBody rtMSGBody = new RequestTypeDATAMessageBody();			
			
			rtMSGBody.setIn_take_symd(KJFDate.getDateAdd(DATE_DIFF, "yyyyMMdd"));
			rtMSGBody.setIn_take_eymd(KJFDate.getCurTime("yyyyMMdd"));
			rtMSGBody.setIn_take_cgg_code(CGG_CODE);
			rtMSGBody.setIn_take_dep_code("");
			rtMSGBody.setIn_mw_take_no("");
			rtMSGBody.setIn_mw_se("");
			rtMSGBody.setIn_mw_aplr_nm("");			
			rtMSGBody.setIn_condition("T1.CGG_MW_AFR_CL_NO = '1440000016002' AND T1.DEAL_SE = '00'");
			rtMSGBody.setIn_condition2("");			
			rtMSGBody.setPage_yn("Y");
			rtMSGBody.setFrom("1");
			rtMSGBody.setTo("10");
			
			rtMSG = new RequestTypeDATAMessage(rtMSGBody);
			rtData = new RequestTypeDATA(rtMSG);
			////////////////////////////////////////////////////////////////////////
			
			rt = new RequestType();
			rt.setIFID(IFID);
			rt.setSRCORGCD(SOURCE_CODE);
			rt.setTGTORGCD(TARGET_CODE);
			rt.setRESULTCODE("000");
			rt.setMSGKEY(SacUtil.getMSGKey());
			rt.setDATA(rtData);
									
			resType = ws.SOWNN00214(rt);
			
			
			KJFLog.log(END_POINT);
			KJFLog.log("SOAP Result:" + resType.getRESULTCODE());
			
			ResponseTypeDATA resData = resType.getDATA();
			ResponseTypeDATAMessage resMSG = resData.getMessage();
			ResponseTypeDATAMessageBodyList[] resMSGLists = resMSG.getBody();		
			
			return resMSGLists;	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;	
	}
	

	/**	 버그확인시 사용	 */
	public static void main(String[] args) 	{
		
		try {

			ResponseTypeDATAMessageBodyList[] resMSGLists = callWS( -14);		
			
			for (ResponseTypeDATAMessageBodyList resMSGList : resMSGLists) {
				System.out.println("------------------------------");
				System.out.println("민원접수번호    :" + resMSGList.getMw_take_no());
				System.out.println("접수일자         :" + resMSGList.getTake_ymd());
				System.out.println("접수시간        :" + resMSGList.getTake_tm());
				System.out.println("접수자성명      :" + resMSGList.getUser_name());
				System.out.println("민원서류수령사용자ID:" + resMSGList.getMw_pps_getr_id());
				System.out.println("민원서류수령사용자명:" + resMSGList.getOutvars());
				System.out.println("민원사무약명    :" + resMSGList.getMw_afr_shtnm());
				System.out.println("민원구분        :" + resMSGList.getMw_se());
				System.out.println("민원신청인명    :" + resMSGList.getMw_aplct_nm());
				System.out.println("민원신청인주소  :" + resMSGList.getMw_aplct_addr());
				System.out.println("민원구분명      :" + resMSGList.getMw_code_cn());
				System.out.println("수납수수료      :" + resMSGList.getRecpt_fee());
				System.out.println("접수확인코드    :" + resMSGList.getTake_confrm_code());
				System.out.println("처리구분        :" + resMSGList.getDeal_se());
				System.out.println("처리구분명      :" + resMSGList.getDeal_code_cn());
				System.out.println("접수구분        :" + resMSGList.getTake_se());
				System.out.println("접수구분코드명  :" + resMSGList.getTake_code_cn());
				System.out.println("실제처리일자    :" + resMSGList.getReal_deal_ymd());
				System.out.println("처리예정일      :" + resMSGList.getDeal_plan_ymd());
				System.out.println("민원사무분류번호:" + resMSGList.getCgg_mw_afr_cl_no());
				System.out.println("민원목록총갯수  :" + resMSGList.getCnt());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
