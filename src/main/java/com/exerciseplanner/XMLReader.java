package com.exerciseplanner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {

	public static Document parseXML(File file){
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			if(file.exists()){
				dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(file);
				System.out.println("Correct file");
				return doc;
			}
			else{
				System.out.println("Wrong file");
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<ArrayList<String>> returnXMLTags(Document doc,String headerTag,String[] tag){
		System.out.println("header: "+headerTag);

		NodeList nList = doc.getElementsByTagName(headerTag);
		if(nList==null){
			return null;
		}
		else{
			if(nList.getLength()>0){
				
				ArrayList<ArrayList<String>> dataElements=new ArrayList<ArrayList<String>>();
				for(int i=0;i<nList.getLength();i++){
					ArrayList<String> nElements=new ArrayList<String>();
					for(int j=0;j<tag.length;j++){
						nElements.add((((Element) nList.item(i)).getElementsByTagName(tag[j])).item(0).getTextContent());
					}
					dataElements.add(nElements);
				}
				return dataElements;
			}
			else{
				return null;
			}
		}
	}
}
