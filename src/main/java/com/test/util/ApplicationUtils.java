package com.test.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by SonyVaio on 3/13/2017.
 */

public final class ApplicationUtils {

	public static String generateJSONFromObject(final Object object) {

		final ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = null;

		try {

			jsonString = objectMapper.writeValueAsString(object);

		} catch (final Exception e) {
			e.printStackTrace();
		}
		return jsonString;
	}

	public static <T> T generateObjectFromJSON(final String jSONString, final Class<T> clazz) {

		ObjectMapper objectMapper = null;
		T object = null;

		if (!isEmpty(jSONString)) {
			try {

				object = clazz.newInstance();
				objectMapper = new ObjectMapper();
				object = objectMapper.readValue(jSONString, clazz);

			} catch (final Exception e) {
				e.printStackTrace();

			}
		}
		return object;
	}

	public static <T> List<T> generateObjectFromJSONArray(final String jSONString, final Class<T> clazz) {

		ObjectMapper objectMapper = null;
		List<T> object = null;

		if (!isEmpty(jSONString)) {
			try {

				object = new ArrayList<>();
				objectMapper = new ObjectMapper();
				object = objectMapper.readValue(jSONString, new TypeReference<List<T>>() {
				});

			} catch (final Exception e1) {
				e1.printStackTrace();
			}
		}
		return object;
	}

	public static boolean isEmpty(final String param) {

		final boolean error = false;
		if (param == null || param.trim().length() <= 0) {
			return true;
		}
		return error;
	}

	/**
	 * This <code>isEmpty</code> method is responsible to check whether the Long value passed is empty or not.
	 *
	 * @param param
	 * @return
	 */
	public static boolean isEmpty(final Long param) {

		final boolean error = false;

		if (param == null || param <= 0L) {
			return true;
		}
		return error;
	}

	/**
	 * This <code>isEmpty</code> method is responsible to check whether the Integer value passed is empty or not.
	 *
	 * @param param
	 * @return
	 */
	public static boolean isEmpty(final Integer param) {

		final boolean error = false;

		if (param == null || param <= 0) {
			return true;
		}
		return error;
	}

	/**
	 * This <code>isEmpty</code> method is responsible to check whether the Double value passed is empty or not.
	 *
	 * @param param
	 * @return
	 */
	public static boolean isEmpty(final Double param) {

		final boolean error = false;

		if (param == null || param <= 0) {
			return true;
		}
		return error;
	}

	public static boolean isValid(final Collection<?> collection) {

		return collection != null && !collection.isEmpty();
	}

	public static Date getDate() {

		return new java.sql.Date(new java.util.Date().getTime());

	}

	public static java.util.Date getYesterday() {

		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();

	}

	public static java.util.Date getTomorrow() {

		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +1);
		return cal.getTime();

	}

	public static java.util.Date getPLEndDate() {

		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -10);
		return cal.getTime();

	}


	static SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

	public static String getTodayDateInString() {

		return DATEFORMAT.format(getDate());
	}




}
