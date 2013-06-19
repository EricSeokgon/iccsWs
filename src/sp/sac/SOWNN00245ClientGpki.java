package sp.sac;

import kjf.cfg.Config;
import kjf.util.KJFDate;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;
import localhost.stmr.websvc.std.ws.SOWNN00245.wsdl.RequestType;
import localhost.stmr.websvc.std.ws.SOWNN00245.wsdl.ResponseType;
import localhost.stmr.websvc.std.ws.SOWNN00245.wsdl.SOWNN00245PortTypeProxy;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.ResponseTypeDATAMessageBodyList;

public class SOWNN00245ClientGpki {
    
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
		
		//�⺻�� ����
		init(diffDay);
		RequestType rt = null;
		ResponseType resType = null;
		
		try {
			SOWNN00245PortTypeProxy ws = new SOWNN00245PortTypeProxy(END_POINT);			
         
			String reqData = "";
			reqData += "<message>";
			reqData += "<body>";
			reqData += "<list>";
			reqData += "<in_take_symd>"+KJFDate.getDateAdd(DATE_DIFF, "yyyyMMdd")+"</in_take_symd>";
			reqData += "<in_take_eymd>"+KJFDate.getCurTime("yyyyMMdd")+"</in_take_eymd>";
			reqData += "<in_take_cgg_code>"+CGG_CODE+"</in_take_cgg_code>";
			reqData += "<in_condition>"+"T1.CGG_MW_AFR_CL_NO = '1440000016002' AND T1.DEAL_SE = '00'"+"</in_condition>";
			reqData += "<page_yn>Y</page_yn>";
			reqData += "<from>1</from>";
			reqData += "<to>10</to>";
			reqData += "</list>";
			reqData += "</body>";
			reqData += "</message>";

			 //GPKI ���� ��ȣȭ		
			reqData = SacUtil.envData(reqData);
		
			rt = new RequestType();
			rt.setIFID(IFID);
			rt.setSRCORGCD(SOURCE_CODE);
			rt.setTGTORGCD(TARGET_CODE);
			rt.setRESULTCODE("000");
			rt.setMSGKEY(SacUtil.getMSGKey());
			rt.setDATA(reqData);
			
			resType = ws.SOWNN00214(rt);			
	
		
			KJFLog.log(END_POINT);
			KJFLog.log("SOAP Result:" + resType.getRESULTCODE());
			
			String resData = resType.getDATA();
			
			//GPKI ���� ��ȣȭ
			resData = SacUtil.parseData( resData );


			System.out.println("resData:"+resData);
			
			Document decodedMsgDoc = SacUtil.getDocument( resData );
			Element eleFinal = decodedMsgDoc.getDocumentElement();
			NodeList listNode = eleFinal.getElementsByTagName("list");
			
			int listNum = listNode.getLength();
			
			ResponseTypeDATAMessageBodyList[] resMSGLists = new ResponseTypeDATAMessageBodyList[listNum];

			System.out.println("listNum : "+listNum);
			for(int i=0;i<listNum;i++){
				NodeList childList = listNode.item(i).getChildNodes();

				
				/////////////////////////////////////////////
				for(int j =0; j< childList.getLength() ; j++){
					String tagName= childList.item(j).getNodeName();
					String tagValue ="";
					if(childList.item(j).hasChildNodes()) tagValue=childList.item(j).getFirstChild().getNodeValue();			
					KJFLog.log("["+j+"] "+tagName+": "+tagValue);
				}//for(int j =0; j< childList.getLength() ; j++)�� ���� ��� ������ ���� ������, ������ ���� Ȯ���ϱ� ���� ���
				///////////////////////////////////////////////
				
				ResponseTypeDATAMessageBodyList resMSGList= new ResponseTypeDATAMessageBodyList();

				resMSGList.setMw_take_no(SacUtil.getTagValue(childList, 0));
				resMSGList.setTake_ymd(SacUtil.getTagValue(childList, 1));
				resMSGList.setTake_tm(SacUtil.getTagValue(childList, 2));
				resMSGList.setUser_name(SacUtil.getTagValue(childList, 3));
				resMSGList.setMw_pps_getr_id(SacUtil.getTagValue(childList, 4));
				resMSGList.setOutvars(SacUtil.getTagValue(childList, 5));
				resMSGList.setMw_afr_shtnm(SacUtil.getTagValue(childList, 6));
				resMSGList.setMw_se(SacUtil.getTagValue(childList, 7));
				resMSGList.setMw_aplct_nm(SacUtil.getTagValue(childList, 8));
				resMSGList.setMw_aplct_addr(SacUtil.getTagValue(childList, 9));
				resMSGList.setMw_code_cn(SacUtil.getTagValue(childList, 10));
				resMSGList.setRecpt_fee(SacUtil.getTagValue(childList, 11));
				resMSGList.setTake_confrm_code(SacUtil.getTagValue(childList, 12));
				resMSGList.setDeal_se(SacUtil.getTagValue(childList, 13));
				resMSGList.setDeal_code_cn(SacUtil.getTagValue(childList, 14));
				resMSGList.setTake_se(SacUtil.getTagValue(childList, 15));
				resMSGList.setTake_code_cn(SacUtil.getTagValue(childList, 16));
				resMSGList.setReal_deal_ymd(SacUtil.getTagValue(childList, 17));
				resMSGList.setDeal_plan_ymd(SacUtil.getTagValue(childList, 18));
				resMSGList.setCgg_mw_afr_cl_no(SacUtil.getTagValue(childList, 19));
				resMSGList.setCnt(SacUtil.getTagValue(childList, 20));
				
				resMSGLists[i]= resMSGList;

			}			
			
			
			return resMSGLists;	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;	
	}
	

	/**	 ����Ȯ�ν� ���	 */
	public static void main(String[] args) 	{
		
		try {

			ResponseTypeDATAMessageBodyList[] resMSGLists = callWS( -14);		
			
			for (ResponseTypeDATAMessageBodyList resMSGList : resMSGLists) {
				System.out.println("------------------------------");
				System.out.println("�ο�������ȣ    :" + resMSGList.getMw_take_no());
				System.out.println("��������         :" + resMSGList.getTake_ymd());
				System.out.println("�����ð�        :" + resMSGList.getTake_tm());
				System.out.println("�����ڼ���      :" + resMSGList.getUser_name());
				System.out.println("�ο��������ɻ����ID:" + resMSGList.getMw_pps_getr_id());
				System.out.println("�ο��������ɻ���ڸ�:" + resMSGList.getOutvars());
				System.out.println("�ο��繫���    :" + resMSGList.getMw_afr_shtnm());
				System.out.println("�ο�����        :" + resMSGList.getMw_se());
				System.out.println("�ο���û�θ�    :" + resMSGList.getMw_aplct_nm());
				System.out.println("�ο���û���ּ�  :" + resMSGList.getMw_aplct_addr());
				System.out.println("�ο����и�      :" + resMSGList.getMw_code_cn());
				System.out.println("����������      :" + resMSGList.getRecpt_fee());
				System.out.println("����Ȯ���ڵ�    :" + resMSGList.getTake_confrm_code());
				System.out.println("ó������        :" + resMSGList.getDeal_se());
				System.out.println("ó�����и�      :" + resMSGList.getDeal_code_cn());
				System.out.println("��������        :" + resMSGList.getTake_se());
				System.out.println("���������ڵ��  :" + resMSGList.getTake_code_cn());
				System.out.println("����ó������    :" + resMSGList.getReal_deal_ymd());
				System.out.println("ó��������      :" + resMSGList.getDeal_plan_ymd());
				System.out.println("�ο��繫�з���ȣ:" + resMSGList.getCgg_mw_afr_cl_no());
				System.out.println("�ο�����Ѱ���  :" + resMSGList.getCnt());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
