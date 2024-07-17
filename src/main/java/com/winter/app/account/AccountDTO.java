package com.winter.app.account;

import java.sql.Date;

import com.winter.app.member.MemberDTO;
import com.winter.app.product.ProductDTO;

public class AccountDTO {
	private int product_id;
	private Date join_date;
	private String account_number;
	private String member_id;
	private int balance;
	private MemberDTO memberDTO;
	private ProductDTO productDTO;
	private int mode;

	public MemberDTO getMemberDTO() {
		return memberDTO;
	}

	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountDTO [product_id=" + product_id + ", "
				+ (join_date != null ? "join_date=" + join_date + ", " : "")
				+ (account_number != null ? "account_number=" + account_number + ", " : "")
				+ (member_id != null ? "member_id=" + member_id + ", " : "") + "balance=" + balance + ", "
//				+ (memberDTO != null ? "memberDTO=" + memberDTO + ", " : "")
//				+ (productDTO != null ? "productDTO=" + productDTO : "") + "]"
		;
	}
}
