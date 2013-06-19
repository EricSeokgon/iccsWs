/**
 * 2009.12.1
 * 오두식
 * 새올 및 전자결재 관련내용 추가
 * 
 */
package sp.webservice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import kjf.cfg.Config;
import kjf.db.TX_MGR;
import kjf.ops.ReportDAO;
import kjf.ops.ReportEntity;
import kjf.util.KJFFile;
import kjf.util.KJFLog;
import kjf.util.KJFSec;
import kjf.util.KJFUtil;
import sp.sac.SOWNN00245Client;
import sp.sac.SOWNN00245ClientGpki;
import _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.ResponseTypeDATAMessageBodyList;

public class UBAgent {
	
	 ReportDAO    rDAO      = new ReportDAO();
	 ReportEntity rEntity   = null;
    
	public String excute(String Key, String s) {
		String result = "1";
		if(!checkKey(Key)) return result;
        try {
        	TX_MGR.begin("KJF"); 
        	
        	if(KJFUtil.print(s)=="") return result;
        	String sqls[] =KJFUtil.str2strs(s,"\t");
        	if(sqls != null && sqls.length >0){
        		for(int i=0;i<sqls.length;i++){
        			rDAO.execute(sqls[i]);
        		}
        	}	
            TX_MGR.commit(); //db commit
                        
        }
        catch (Exception ex) {
        	result=ex.toString();
            TX_MGR.rollback(); //db rollbacd
            KJFLog.log(ex.toString()); // Exception log
	        ex.printStackTrace();
        }        
        return result;        
	}

	

	public String[] select(String Key, String s) {
		String result[] = new String[2];
		result[0]="1";
		result[1]="";
		
		//String result = "";
		if(!checkKey(Key)) return result;
		
        try {
        	TX_MGR.begin("KJF");
        	
        	if(KJFUtil.print(s)=="") return result;
        	
        	rEntity = rDAO.select(s);
        	for(int i=0; i< rEntity.getRowCnt();i++){		
        		for(int j=0; j< rEntity.getFieldCnt()-1;j++ ){			
        			if((j+1)== rEntity.getFieldCnt()-1) {      							
        				result[1] += rEntity.getValue(i,j)+"!#$";				
        			} else {
        				result[1] += rEntity.getValue(i,j)+"\t";
        			}		
        		}
        	}

            TX_MGR.commit(); //db commit
                        
        }
        catch (Exception ex) {
            TX_MGR.rollback(); //db rollbacd
            result[0]="0";
            result[1]=ex.toString();
            KJFLog.log(ex.toString()); // Exception log
	        ex.printStackTrace();
        }        
        return result;        
	}	
	
	 public DataHandler getFile(String Key, String folder, String fileName){
		 
	  if(!checkKey(Key)) return null;			 

	  String file_fath=Config.props.get("ATT_FILE_DIR")+folder+KJFFile.FILE_S+fileName;
	  File file = new File(file_fath);
	  
	  if(!file.exists()){
		  KJFLog.log("file not found");
		  return null;
	  }	  
	  FileDataSource fileDataSource = new FileDataSource(file);
	  DataHandler dh = new DataHandler(fileDataSource);
	  return dh;
	 }
	 

	 public int setFile(String Key, DataHandler dh, String folder, String fileName)  {
		 int result = 0;	
		 FileOutputStream fos;
		 
		 KJFLog.log("setFile!!");
		 
		 if(!checkKey(Key)){
			 KJFLog.log("invalid Key!!");
			 return result;
		 }
		 
		 if(dh==null){
			 KJFLog.log("attachment is null");
			 return -1;
		 }
		 
		 String strpath= Config.props.get("ATT_FILE_DIR")+folder;
		 try {
			 KJFFile.fullDirMake(strpath);
		} catch (Exception e) {
			 KJFLog.log(e.toString()); // Exception log
			 e.printStackTrace();
			 return result;
		}
		 
		 String file_fath=strpath+KJFFile.FILE_S+fileName;
		 
		 try{
			 fos = new FileOutputStream(file_fath);
			 dh.writeTo(fos);
			 fos.flush();
			 fos.close();			 
		 }catch(Exception ex){
			 KJFLog.log(ex.toString()); // Exception log
			 ex.printStackTrace();
			 return result;
		 }

	  return 1;
	 }
	 
	 /**
	  * 전자결재 문서를 수신하여 EBMS_FILE_DIR에 저장한다. eof.inf파일이 요청이 들어오면 파일을 전자결재 시스템으로 전송한다.
	  * @param Key
	  * @param dh
	  * @param folder
	  * @param fileName
	  * @return
	  */
	 public int setEbmsFile(String Key, DataHandler dh, String folder, String fileName)  {
		 int result = 0;	
		 FileOutputStream fos;
		 
		 KJFLog.log("ebms file create!");
		 
		 if(!checkKey(Key)){
			 KJFLog.log("invalid Key!!");
			 return result;
		 }
		 
		 if(dh==null && !"eof.inf".equals(fileName)){
			 KJFLog.log("attachment is null");
			 return -1;
		 }
		 
		 String strpath= Config.props.get("EBMS_FILE_DIR")+folder;
		 
		 File dir = new File(strpath);
        
		 if(!dir.isDirectory()){
			 try {
				 KJFLog.debug("make Directory",strpath);
				 KJFFile.dirMake(strpath);
			 } catch (Exception e) {
				 KJFLog.log(e.toString()); // Exception log
				 e.printStackTrace();
				 return result;
			 }
		 }
		 
		 String file_fath=strpath+KJFFile.FILE_S+fileName;
		 
		 if("eof.inf".equals(fileName)){
			 File file = new File(file_fath);
			 boolean fileCreated = false;
			 
			 try{
				 fileCreated = file.createNewFile();
				 
			 }catch (IOException iex) {
				 KJFLog.log(iex.toString()); // Exception log
				 iex.printStackTrace();
				 return result;
			 }
			 
			 try{
				String [] command = { "chown", "-R","exchange:exchange", strpath };
	
				Process proc = Runtime.getRuntime ().exec ( command );
				proc.waitFor( );
	
				if ( proc.exitValue ( ) != 0 ){					
					KJFLog.log("directory owner change error!" );
				}
	
				proc.destroy ( );
			 }
			 catch ( Exception e ) { System.out.println ( e ); }
				

		 }else{
			 try{
				 fos = new FileOutputStream(file_fath);
				 dh.writeTo(fos);
				 fos.flush();
				 fos.close();			 
			 }catch(Exception ex){
				 KJFLog.log(ex.toString()); // Exception log
				 ex.printStackTrace();
				 return result;
			 }
		 }
		 

	  return 1;
	 }
	 
	 /**
	  * 새올 데이터 반환
	  * @param key
	  * @param addDate
	  * @return
	  */
	 public ResponseTypeDATAMessageBodyList[] getSeAllData(String key, int addDate){
		 
		  if(!checkKey(key)) return null;
		  
		  boolean GPKI_USE_YN = KJFUtil.yn2Boolean(Config.props.get("GPKI_USE_YN"));
		  
		  ResponseTypeDATAMessageBodyList[] resMSGLists = null;
		  
		  if(GPKI_USE_YN){
			  resMSGLists = SOWNN00245ClientGpki.callWS(addDate);
		  } else {
			  resMSGLists = SOWNN00245Client.callWS(addDate);
		  }
			  
		  
		  return resMSGLists;
	}


	public boolean checkKey(String encodeKey) {
		 String area_code = Config.props.get("AREA_CODE");	 
		 try {
			 String key = KJFSec.decode(KJFUtil.print(encodeKey));
			 if(area_code.equalsIgnoreCase(key)) return true;			
		} catch (Exception e) {
			 KJFLog.log(e.toString()); // Exception log
			 e.printStackTrace();	
		}
	  return false;
	}		
}
