package com.riverbed.jsconapi.util;

public class SconUtil {
	
	public static String removeBrackets(String string){
		
		
		if(string.charAt(0)=='\"') string = string.substring(1);
		if(string.charAt(string.length()-1)=='\"') string = string.substring(0,string.length()-1); 
			
		return string;
		
	}
	
	public static String replaceSpaceByUnderscore(String string){
		
		char[] result = string.toCharArray();
		for(int i=0;i<result.length;i++){
			if(result[i]==' ') result[i]='_';
		}
		
		return new String(result);
		
	}
	
	public static String replaceUnderscoreBySpace(String string){
		
		char[] result = string.toCharArray();
		for(int i=0;i<result.length;i++){
			if(result[i]=='_') result[i]=' ';
		}	
		return new String(result);
		
	}
	
	public static String StringArrayToString(String[] array) {
		String str = null;
		if(array!=null) {
			for(int i=0;i<array.length;i++) {
				if(i!=0) str = str+" "+array[i];
				else str = array[i];
			}
		}
		return str;
	}

	
}