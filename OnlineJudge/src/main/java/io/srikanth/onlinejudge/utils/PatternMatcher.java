package io.srikanth.onlinejudge.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PatternMatcher {

	final Logger logger = LogManager.getLogger(PatternMatcher.class);

	public String matchPattern(String code, String token) {
		Pattern JAVA_CLASS_NAME = Pattern.compile("(public class [a-z|A-Z|0-9]*)");
		Matcher m = JAVA_CLASS_NAME.matcher(code);
		StringBuilder sb = new StringBuilder();
		String repString = "public class Main" + token;
		if (m.find())
			m.appendReplacement(sb, repString);
		m.appendTail(sb);
		logger.info(sb);
		logger.info(repString);
		return "";
	}
}
