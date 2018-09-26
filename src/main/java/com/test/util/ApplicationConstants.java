/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.util;

import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The <code>ApplicationConstants</code> class is responsible for in <b>CCM</b>.
 *
 * @author Manish
 */
public final class ApplicationConstants {

	//public static final String S_URL = "ws://mlive.bcommo.in:8888/WebSocketsServer2.ashx?type=Watch&userid=1956&profileid=2400&rowsize=20&android_id=&currentpage=1";
	public static final String S_URL = "ws://mlive.bcommo.in:3030/MliveDeskSocket/watch/";
	public static final String S_URL2 = "ws://mlive.bcommo.in:3030/MliveDeskSocket/watch";
	public static final String S_PROFILE_SOCKET = "ws://mlive.bcommo.in:3030/MliveDeskSocket/profile/";
	// Http Headre
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String APPLICATION_X_FORM_URL = "application/x-www-form-urlencoded";
	public static final int BLINK_DURATION = 500;
	// Urls for api
	//public static final String A_URL = "http://mlive.bcommo.in:188";
	public static final String A_URL = "http://mlive.bcommo.in:3030/MliveDeskApi/rest";
	// middle part of api
	private static final String USER_PROFILE_API = "/UserLogin.asmx";
	private static final String MKW_LOADMKW_API = "/LoadMarketWatch.asmx";
	public static final String GET_ALL_SCRIPT = "/profile/getall";

	// full api link
	private static final String DO_LOGIN = "/doLogin";
	public static final String DO_LOGIN_URL = ApplicationConstants.USER_PROFILE_API + ApplicationConstants.DO_LOGIN;
	private static final String GET_DATA = "/GetData";
	public static final String MKW_GET_DATA = ApplicationConstants.MKW_LOADMKW_API + ApplicationConstants.GET_DATA;

	// Request method parameter constant
	public static final String USER_NAME_PARAM = "username";
	public static final String PASSWORD_PARAM = "password";

	public static final String USER_ID_PARAM = "userid";
	public static final String PROFILE_ID_PARAM = "profileid";
	public static final String ROW_SIZE_PARAM = "rowSize";
	public static final String CURRENT_PAGE = "currentPage";

	//Other constant
	public static final int CODE_ZERO = 0;
	public static final int CODE_ONE = 1;

	//ErrorMessage
	public static final String ERR_HTTP_NEGATIVE_RESPONSE = "Connection time out";

	//Objetc name for callresponse
	public static final String I1 = "Buy Qty", I2 = "Buy Price", I3 = "Sell Qty", I4 = "Sell Price",
			I5 = "Last Trade Quantity", I6 = "LTP", I7 = "Volume",I8 = "Val(Cr)",
			I9="High",I10="Low",I11="Open",I12= "Close",I13 = "Total Buy Quantity",
			I14 = "Total Sell Quantity",I15 = "Avarage Trade Price",I16 = "Open Interest",I17 = "?",
			I18 = "?",I19="Net Chg",I20="Net Per",
			I21 = "DPR",I_LI = "|",I_IN="Indicator";
	public static final String I_SYMBOL = "Symbol",I_EXCHANGE = "Exchange",I_EXPIRY = "Expiry Date";
	public static final List<String> allColumnsList = new ArrayList<>();
	static{
		allColumnsList.add(I1);allColumnsList.add(I2);allColumnsList.add(I3);allColumnsList.add(I4);allColumnsList.add(I5);
		allColumnsList.add(I6);allColumnsList.add(I7);allColumnsList.add(I8);allColumnsList.add(I9);allColumnsList.add(I10);
		allColumnsList.add(I11);allColumnsList.add(I12);allColumnsList.add(I13);allColumnsList.add(I14);allColumnsList.add(I15);
		allColumnsList.add(I16);allColumnsList.add(I17);allColumnsList.add(I18);allColumnsList.add(I19);allColumnsList.add(I20);
		allColumnsList.add(I21);allColumnsList.add(I_SYMBOL);allColumnsList.add(I_EXCHANGE);allColumnsList.add(I_EXPIRY);
		allColumnsList.add(I_IN);allColumnsList.add(I_LI);
	}

	public static final Map<String,String> COLUMN_FILELD_PAIR = new HashMap<>();

	static{
		COLUMN_FILELD_PAIR.put(I_SYMBOL, "s");COLUMN_FILELD_PAIR.put(I_EXCHANGE, "ie");COLUMN_FILELD_PAIR.put(I_EXPIRY, "ix");
		COLUMN_FILELD_PAIR.put(I1,"i1");COLUMN_FILELD_PAIR.put(I2,"i2");COLUMN_FILELD_PAIR.put(I3,"i3");COLUMN_FILELD_PAIR.put(I4,"i4");
		COLUMN_FILELD_PAIR.put(I5,"i5");COLUMN_FILELD_PAIR.put(I6,"i6");COLUMN_FILELD_PAIR.put(I7,"i7");COLUMN_FILELD_PAIR.put(I8,"i8");
		COLUMN_FILELD_PAIR.put(I9,"i9");COLUMN_FILELD_PAIR.put(I10,"i10");COLUMN_FILELD_PAIR.put(I11,"i11");COLUMN_FILELD_PAIR.put(I12,"i12");
		COLUMN_FILELD_PAIR.put(I13,"i13");COLUMN_FILELD_PAIR.put(I14,"i14");COLUMN_FILELD_PAIR.put(I15,"i15");COLUMN_FILELD_PAIR.put(I16,"i16");
		COLUMN_FILELD_PAIR.put(I17,"i17");COLUMN_FILELD_PAIR.put(I18,"i18");COLUMN_FILELD_PAIR.put(I19,"i19");COLUMN_FILELD_PAIR.put(I20,"i20");
		COLUMN_FILELD_PAIR.put(I21,"i21");COLUMN_FILELD_PAIR.put("First Name", "aa");
	}
	/** Formatter **///

	public static final SimpleDateFormat yyyyMMddFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.s");
	public static final SimpleDateFormat ddMMMyyyyFormat = new SimpleDateFormat("ddMMMyyyy");
	public static final DecimalFormat decimalFormatter = new DecimalFormat("0.00");

	/****************** fonts ***********************************/

	public static final Font MARKET_WATCH_HEADER_FONT = new java.awt.Font("Arial", Font.BOLD, 14);


	public static final int GET_ALL_PROFILE_CODE = 1;
	public static final int ADD_PROFILE_CODE = 2;

	//
	public static final String MARKET_WATCH_FONT = "MARKET_WATCH_FONT";
	public interface ALPHABET_CONSTANT {

		String A = "a", B = "b", C = "c", D = "d", E = "e", F = "f", G = "g", H = "h", I = "i", J = "j", K = "k", L = "l", M = "m", N = "n", O = "o", P = "p",
				Q = "q", R = "r", S = "s", T = "t", U = "u", V = "v", W = "w", X = "x", Y = "y", Z = "z";
	}

}
