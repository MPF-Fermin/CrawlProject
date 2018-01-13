package com.mpf.util;

public interface Parser {

	/**
	 * ��ȡָ����Tag��text
	 * @description <br/> 
	 * @param selectTag
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public String getContentAsText(String selectTag, String content) throws Exception;

	/**
	 * ��ȡָ����Tag������
	 * @description <br/> 
	 * @param selectTag
	 * @param content
	 * @param attr
	 * @return
	 * @throws Exception
	 */
	public String getContentAsAttr(String selectTag, String content, String attr) throws Exception;
}
