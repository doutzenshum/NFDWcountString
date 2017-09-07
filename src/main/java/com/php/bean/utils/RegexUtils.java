package com.php.bean.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
	
	private static final String REG_EM = "(\\<em\\>.{1,20}\\<\\/em\\>)";
	
	private final static String regxpForHtml = "([\u4e00-\u9fa5]+)"; // 获取中文的正则表达式
	
	private static List<Object> listAll = new ArrayList<>();
	
	public static List<Object> getEm(String str){
		Pattern p = Pattern.compile(REG_EM);
		Pattern pHtml = Pattern.compile(regxpForHtml);
		Matcher m = p.matcher(str);
		while(m.find()) {
			Matcher mHtml = pHtml.matcher(m.group());
			while(mHtml.find()){
				listAll.add(mHtml.group());
			}
		}
		return listAll;
	}
}
