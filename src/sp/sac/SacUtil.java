package sp.sac;


import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import kjf.cfg.Config;
import kjf.util.KJFFile;
import kjf.util.KJFLog;
import kjf.util.KJFUtil;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.gpki.gpkiapi.cert.X509Certificate;
import com.gpki.gpkiapi.cms.EnvelopedData;
import com.gpki.gpkiapi.crypto.PrivateKey;
import com.gpki.gpkiapi.storage.Disk;
import com.gpki.gpkiapi.util.Base64;
import com.gpki.gpkiapi.util.Ldap;




public class SacUtil {
	
	private static String certsRootPath =KJFUtil.print(Config.props.get("CERTS_ROOT_PATH"));
	
	public static String envData( String inputMsg) {


		X509Certificate TargetCert; //새올서버의 인증서
		Base64 base64 = new Base64();

		String outData = null;
		byte[] byteData = null;
		
		
		try {
			String certsRootPath =KJFUtil.print(Config.props.get("CERTS_ROOT_PATH"));
			String targetPubKeyName = KJFUtil.print(Config.props.get("TARGET_PUBKEY"));
			
			//새올서버의 공개키가 있는지 확인하고 없다면 LDAP 서버에 접근하여 GPKI 공개키를 다운받아 파일로 만든다.
			if(!KJFFile.existFile(certsRootPath, targetPubKeyName)){
				String targetGpkiId = KJFUtil.print(Config.props.get("TARGET_GPKI_ID"));
				byte[] dataBuff = null;
				Ldap ldap = new Ldap();
				ldap.setLdap("ldap.gcc.go.kr", 389);
				ldap.searchCN(Ldap.DATA_TYPE_KM_CERT , targetGpkiId);
				
				dataBuff = ldap.getData();
	
				ByteArrayInputStream in = new ByteArrayInputStream(dataBuff);
				KJFFile.saveFile(certsRootPath , targetPubKeyName, in);
			}
	

			
			//새올서버 공개키를 이용해서 인증서 생성
			TargetCert	= Disk.readCert(certsRootPath+targetPubKeyName);

			//SEED 3DES DES NEAT ARIA NES NEAT/CBC
			EnvelopedData envData = new EnvelopedData("NEAT");
			envData.addRecipient( TargetCert );
			
			byteData = envData.generate( inputMsg.getBytes() );	
			
			outData = base64.encode ( byteData );
			
		} catch (Exception e) {
			e.printStackTrace();
			KJFLog.log(e.toString());
		}
		
		return outData;
	}
	
	
	public static String parseData( String inputMsg) {

		X509Certificate sourceCert; //연계서버의 인증서
		PrivateKey sourcePrivateKey;// 연계서버의 개인키
		
		Base64 base64 = new Base64();
		
		

		byte[] outMsg = null;

		try {
			String srcPubKey =KJFUtil.print(Config.props.get("SOURCE_PUBKEY"));
			String srcPriKey =KJFUtil.print(Config.props.get("SOURCE_PRIKEY"));
			String srcPriKeyPw =KJFUtil.print(Config.props.get("SOURCE_PRIKEY_PW"));
			
			sourceCert			= Disk.readCert(certsRootPath+srcPubKey);
			sourcePrivateKey	= Disk.readPriKey(certsRootPath+srcPriKey, srcPriKeyPw );

			EnvelopedData envData = new EnvelopedData("NEAT");
			
			byte[] byteContent = base64.decode( inputMsg );
			outMsg = envData.process(byteContent, sourceCert, sourcePrivateKey);

		} catch (Exception e) {
			e.printStackTrace();
			KJFLog.log(e.toString());
		}
		
		return new String(outMsg);
	}
	
	public static String getMSGKey(){
		String DATE_FORMAT = "yyyyMMddHHmmssSSS";
		SimpleDateFormat sdf = new SimpleDateFormat( DATE_FORMAT );
		Calendar cal = Calendar.getInstance();

		Random oRandom = new Random();

		long rndValue = 0;

		while(true){
			rndValue = Math.abs( oRandom.nextInt()*1000000 );
			if(String.valueOf(rndValue).length()==8)
				break;
		}

		return sdf.format( cal.getTime() )+rndValue;
	}
	
	public static Document getDocument( String inputMsg ) throws Exception{
		Document doc = null ;
	
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		
		InputSource inputSource = new InputSource(new StringReader( inputMsg ));
	    doc =docBuilder.parse( inputSource );
    
		return doc;
	}
	
	public static String getTagValue( NodeList nodeList, int j ) throws Exception{

		String tagValue ="";
		if(nodeList.item(j).hasChildNodes()) tagValue=nodeList.item(j).getFirstChild().getNodeValue();
    
		return tagValue;
	}	

}