package com.winter.app.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test {
	public static void main(String[] args) throws Exception {
		String URL = "https://www.10000recipe.com/recipe/6978360";

		// URL로부터 HTML 문서 가져오기
		Document doc = Jsoup.connect(URL).get();

		// 본문 HTML 요소 가져오기
		Elements elements = doc.select("#contents_area_full .cont_ingre2 .ready_ingre3 .ingre_list_name");
		System.out.println(elements.toString());

		String[] str = elements.text().split(" ");
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
}
