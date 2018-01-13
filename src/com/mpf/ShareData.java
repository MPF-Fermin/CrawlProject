package com.mpf;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mpf.common.Constant;
import com.mpf.entity.Book;
import com.mpf.util.HttpClientUtil;

public class ShareData {
	private String category = "";
	private int pageNum = 0;
	private HttpClient client=HttpClientUtil.getHttpClient();
	public ShareData(String category){
		this.category = category;
	}
	public synchronized void searchHref(ArrayList<Book> finalAllBooks){
		ArrayList<String> allBooksTitle = new ArrayList<String>();
		ArrayList<String> allBooksRanking = new ArrayList<String>();
		ArrayList<String> allBooksCommentNum = new ArrayList<String>();
		String url = Constant.mainHref + category + "?start=" + pageNum + "&type=T";
		System.out.println(url);
		GetMethod method = HttpClientUtil.getMethod(HttpClientUtil.encodeUrlCh(url));
		try {
            int status = client.executeMethod(method);
			if(status==200){
				InputStream inputStream = method.getResponseBodyAsStream();
				ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
				byte[] b = new byte[1024];
				
				while(inputStream.read(b)!=-1){
					outputStream.write(b);
				}
				inputStream.close();
				
				String content=new String(outputStream.toByteArray(),method.getResponseCharSet());
				content = content.substring(content.indexOf(Constant.beginStr), content.indexOf(Constant.endStr));
				Document doc = Jsoup.parse(content);

			    //Document doc = Jsoup.connect(this.url).header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").get();  
				Elements elements = doc.select("a");
				Elements spanElements = doc.select("span");
				String temElement = "";
				for(Element element:elements){
					//String href=element.attr("href");
					String title=element.attr("title");
					if(temElement.equals(title)){
						continue;
					}
					temElement = title;
					if(null!=title&&!"".equals(title)){
						allBooksTitle.add(title);
					}
				}
				for(Element element:spanElements){
					String rankingClass = element.attr("class");
					String commentNumClass = element.attr("class");
					if("rating_nums".equals(rankingClass)){
						allBooksRanking.add(element.text().trim());
					}
					if("pl".equals(commentNumClass)){
						String str = element.text();
						str = str.replaceAll("[^0-9]", "");
						allBooksCommentNum.add(str);
					}
				}
				for(int i =  0; i < 20; i++){
					//String titleStr = allBooksTitle.get(i);
					Book book = new Book();
					book.setTitle(allBooksTitle.get(i));
					book.setRanking(Double.parseDouble(allBooksRanking.get(i)));
					book.setCommentNum(Integer.parseInt(allBooksCommentNum.get(i)));
					finalAllBooks.add(book);
				}
				//ШЅжи
				//allBooksHref = CommonMethod.removeDuplication(allBooksHref);
			}else if(status == 502 || status == 504 || status == 500 || status == 403){
				System.out.println("error code:"+status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			method.releaseConnection();
			pageNum += 20;
		}
	}
	
	public int getPageNum(){
		return this.pageNum;
	}
}
