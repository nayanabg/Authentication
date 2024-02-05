package com.auth.demo.jwt;

public class JwtConstants {

	public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5 * 60 * 60;
	public static final String SIGNING_KEY = "hOHmUlEiHo-yTUOtsggwAWHJChBntVYTMsauBmj4F2bFJqNDuHlY0saQBQeA8POT";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
}
