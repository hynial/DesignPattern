package com.anxxp.bridge;

public class SaveToDB implements ISaveData {
	@Override
	public void save(Object data) {
		System.out.println(data + "存储到数据库");
	}
}
