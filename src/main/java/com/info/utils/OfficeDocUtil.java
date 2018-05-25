package com.info.utils;

public class OfficeDocUtil {
	
	//密级
	private final static int SECURITY_LOW=00;//秘密
	private final static int SECURITY_MID=01;//机密
	private final static int SECURITY_HIG=02; //绝密
	
	//紧急程度
	private final static int EMERGENCY_LOW=10;//平件	
	private final static int EMERGENCY_LTM=11;//平急
	private final static int EMERGENCY_MID=12;//加急
	private final static int EMERGENCY_MTH=12;//特急
	private final static int EMERGENCY_HIG=13;//特提
	
	//公文文种
	private final static int DOC_KIND_RESOLUTION=101;//决议	
	private final static int DOC_KIND_DECISION=102;//决定	
	private final static int DOC_KIND_ORDER=103;//命令（令）	
	private final static int DOC_KIND_COMMUNIQUEWC=104;//公报	
	private final static int DOC_KIND_BULLETIN=105;//公告	
	private final static int DOC_KIND_ANNOUNCE=106;//通告	
	private final static int DOC_KIND_SUGGESTION=107;//意见	
	private final static int DOC_KIND_NOTICE=108;//通知	
	private final static int DOC_KIND_NOTIFICATION=109;//通报	
	private final static int DOC_KIND_REPORT=110;//报告
	private final static int DOC_KIND_REQUEST=111;//请示	
	private final static int DOC_KIND_INSTRUCTION=112;//批复	
	private final static int DOC_KIND_DISCUSSION_CASE=113;//议案	
	private final static int DOC_KIND_LETTER=114;//函	
	private final static int DOC_KIND_SUMMARY=115;//纪要
	
	public static String strArrayConnect(String[] strings) {
		String strRlt=new String();
		for(int i=0;i<strings.length;i++) {
			if(strRlt.isEmpty())
				strRlt=strings[i];
			else
				strRlt+=strings[i];
		}
		return strRlt;
	}
	
	public static String[] strArraySplit(String string) {
		return string.split(",");
	}
}
