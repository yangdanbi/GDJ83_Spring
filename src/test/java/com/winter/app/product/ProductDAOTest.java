package com.winter.app.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.DefaultTest;
import com.winter.app.boards.notice.NoticeDAO;
import com.winter.app.boards.notice.NoticeDTO;

public class ProductDAOTest extends DefaultTest {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private NoticeDAO noticeDAO;

	// @Test
	public void pageTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		long perPage = 10L;
		long totalCount = productDAO.getTotalCount();
		long totalPage = totalCount / perPage;

		if (totalCount % perPage != 0) {
			// totalPage = totalCount / perPage + 1;
			totalPage++;
		}

		System.out.println("totalPage " + totalPage);
		// System.out.println("totalCount % perPage : " + 122 % 10);
		// System.out.println(122 / 10 + 1);
	}

	// @Test
	public void addTestADO() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		for (int i = 0; i < 100; i++) {
			productDTO.setProduct_type("자유입출금" + i);
			double r = ((int) (Math.random() * 1000)) / 100.0;
			productDTO.setProduct_rate(Math.random());
			productDTO.setProduct_rate(r);
			productDTO.setProduct_detail("상세설명" + i);
			productDAO.add(productDTO);
			Thread.sleep(500);
		}
		System.out.println("Finish");
	}

	@Test
	public void addTestADO1() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		for (int i = 0; i < 100; i++) {
			noticeDTO.setBoard_writer("ydb");
			noticeDTO.setBoard_title("게시물 " + i);
			noticeDTO.setBoard_contents("상세설명 " + i);
			noticeDTO.setBoard_category("a");
			noticeDAO.add(noticeDTO);

			if (i % 10 == 0) {
				Thread.sleep(500);

			}
		}
		System.out.println("Finish");
	}

	// @Test
	public void getDetailTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_id(60);
		productDTO = productDAO.getDetail(productDTO);

		// 단정문
		assertNotNull(productDTO);// productDTO가 null이 아니면 좋겠다 희망하는 문

	}

	// @Test
	public void insertTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_type("적금");
		productDTO.setProduct_rate(3.2);
		productDTO.setProduct_detail("적금....");

		int result = productDAO.add(productDTO);

		assertEquals(1, result);

	}
}
