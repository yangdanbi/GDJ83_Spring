<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="layoutSidenav_nav">
	<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
		<div class="sb-sidenav-menu">
			<div class="nav">
				<div class="sb-sidenav-menu-heading">YDB</div>
				<a class="nav-link" href="/">
					<div class="sb-nav-link-icon">
						<i class="fas fa-tachometer-alt"></i>
					</div> Home
				</a> <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
					data-bs-target="#collapsePages" aria-expanded="false"
					aria-controls="collapsePages">
					<div class="sb-nav-link-icon">
						<i class="fas fa-book-open"></i>
					</div> 게시판
					<div class="sb-sidenav-collapse-arrow">
						<i class="fas fa-angle-down"></i>
						<a class="nav-link" href="/qna/list"> qna </a>
						<a class="nav-link" href="/notice/list"> notice </a>
		
					</div>
				</a>
				<div class="collapse" id="collapsePages"
					aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
					<nav class="sb-sidenav-menu-nested nav accordion"
						id="sidenavAccordionPages">
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#pagesCollapseAuth" aria-expanded="false"
							aria-controls="pagesCollapseAuth"> 고객센터
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="pagesCollapseAuth"
							aria-labelledby="headingOne"
							data-bs-parent="#sidenavAccordionPages">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="/">공지사항</a> <a class="nav-link"
									href="/">QnA</a>
							</nav>
						</div>
					</nav>
				</div>

				<div class="sb-sidenav-menu-heading">YDB Bank</div>
				<a class="nav-link" href="/product/list"> YDB금융 상품 </a>
			</div>
			
			<div class="sb-sidenav-menu-heading">게시판</div>
				<a class="nav-link" href="/qna/list"> qna </a>
				</div>
			<div class="sb-sidenav-menu-heading">게시판</div>
						<a class="nav-link" href="/notice/list"> notice </a>
				</div>	
		
		<div class="sb-sidenav-footer">
			<div class="small">Logged in as:</div>
			Start Bootstrap
		</div>
	</nav>
</div>