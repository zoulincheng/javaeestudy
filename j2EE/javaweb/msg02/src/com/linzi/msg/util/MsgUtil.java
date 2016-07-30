package com.linzi.msg.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MsgUtil {
	private static final String DATEFORMAT = "yyyy-MM-dd HH:mm";
	private static final SimpleDateFormat SDF = new SimpleDateFormat(DATEFORMAT);
	public static String formatDate(Date date){
		return SDF.format(date);
	}
}
