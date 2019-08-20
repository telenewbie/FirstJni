package com.tele.jni;

public class TestJni{
	static {
		System.loadLibrary("testJni");
	}

	public native static long _get_UID();
}