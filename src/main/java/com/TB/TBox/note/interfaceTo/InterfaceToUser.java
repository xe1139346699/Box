/**
 * 对user模块的接口
 */
package com.TB.TBox.note.interfaceTo;

import java.util.List;

public interface InterfaceToUser {
	/*
	 * 根据id查询图片
	 */
	public List<byte[]> sehImage(int noteId);
}
