package ehu.parse;

import static org.junit.Assert.*;
import ixa.kaflib.KAFDocument;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import ehu.heads.CollinsHeadFinder;
import ehu.heads.HeadFinder;

public class AnnotateTest {

	private static Map<String,String>fixturesMap;
	private String[]fixtureFilePaths={
			"test_kafs/en-kaf-with-terms.kaf",
			"test_kafs/es-kaf-with-terms.kaf",
			"test_kafs/fr-kaf-with-terms.kaf",
			"test_kafs/it-kaf-with-terms.kaf",			
	};
	
	//private static Map<String,String>expectResults;
	
	@Before
	public void setUp() throws Exception {
		fixturesMap=new HashMap<String,String>();
		for(String filePath:fixtureFilePaths){
			InputStream is=AnnotateTest.class.getClassLoader().getResourceAsStream(filePath);
			ByteArrayOutputStream bos=new ByteArrayOutputStream();
			IOUtils.copy(is, bos);
			String lang=getFixtureFileLanguage(filePath);
			fixturesMap.put(lang, bos.toString());
		}
		
		
	}
	
	/*
	 * TEST FIXTURES NOT FINISHED, THAT IS WHAY I COMMENT THEM OUT
	 */
	
//	@Test
//	public void testAnnotatePOSToKAF_EN() {
//		try {
//			String lang="en";
//			Annotate annotate=new Annotate(lang);
//			String kafWithTokenString=fixturesMap.get(lang);
//			KAFDocument kaf=KAFDocument.createFromStream(new StringReader(kafWithTokenString));
//			HeadFinder headFinder = new CollinsHeadFinder(lang);
//			annotate.parseWithHeads(kaf, headFinder);
//			
//			//System.out.println(kaf.toString());
//			
//			String expectedKaf=FileUtils.readFileToString(new File(AnnotateTest.class.getClassLoader().getResource("test_kafs/"+lang+"-kaf-with-constit.kaf").getPath()),"UTF-8");
//			assertEquals(expectedKaf.trim(), kaf.toString().trim());
//			
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//		
//	}
//	
//	@Test
//	public void testAnnotatePOSToKAF_ES() {
//		try {
//			String lang="es";
//			Annotate annotate=new Annotate(lang);
//			String kafWithTokenString=fixturesMap.get(lang);
//			KAFDocument kaf=KAFDocument.createFromStream(new StringReader(kafWithTokenString));
//			HeadFinder headFinder = new CollinsHeadFinder(lang);
//			annotate.parseWithHeads(kaf, headFinder);
//			
//			
//			System.out.println(kaf.toString());
//			
//			
//			String expectedKaf=FileUtils.readFileToString(new File(AnnotateTest.class.getClassLoader().getResource("test_kafs/"+lang+"-kaf-with-constit.kaf").getPath()),"UTF-8");
//			assertEquals(expectedKaf.trim(), kaf.toString().trim());
//		
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//	
//	@Test
//	public void testAnnotatePOSToKAF_FR() {
//		try {
//			String lang="fr";
//			Annotate annotate=new Annotate(lang);
//			String kafWithTokenString=fixturesMap.get(lang);
//			KAFDocument kaf=KAFDocument.createFromStream(new StringReader(kafWithTokenString));
//			HeadFinder headFinder = new CollinsHeadFinder(lang);
//			annotate.parseWithHeads(kaf, headFinder);
//			
//			//System.out.println(kaf.toString());
//			
//			String expectedKaf=FileUtils.readFileToString(new File(AnnotateTest.class.getClassLoader().getResource("test_kafs/"+lang+"-kaf-with-constit.kaf").getPath()),"UTF-8");
//			assertEquals(expectedKaf.trim(), kaf.toString().trim());
//			
//			
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//	
//	@Test
//	public void testAnnotatePOSToKAF_IT() {
//		try {
//			String lang="it";
//			Annotate annotate=new Annotate(lang);
//			String kafWithTokenString=fixturesMap.get(lang);
//			KAFDocument kaf=KAFDocument.createFromStream(new StringReader(kafWithTokenString));
//			HeadFinder headFinder = new CollinsHeadFinder(lang);
//			annotate.parseWithHeads(kaf, headFinder);
//			
//		//	System.out.println(kaf.toString());
//			
//			String expectedKaf=FileUtils.readFileToString(new File(AnnotateTest.class.getClassLoader().getResource("test_kafs/"+lang+"-kaf-with-constit.kaf").getPath()),"UTF-8");
//			assertEquals(expectedKaf.trim(), kaf.toString().trim());
//			
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}

	
	protected String getFixtureFileLanguage(String filePath){
		File file=new File(filePath);
		return file.getName().substring(0, 2);
	}

}
