<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4" style="font-size: 14px;">


	<!-- start of content -->
	<div class="row my-3">
		<div class="col-lg-6 col-md-12 text-truncate">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col"><a class="text-decoration-none text-light"
							href="/communityexample/best">BEST게시판</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach begin="1" end="9" varStatus="var">
						<tr>
							<td><a class="text-decoration-none text-info"
								href="/communityexample/best/${bIndex}">환경권의 내용과 행사에 관하여는
									법률로 정한다. 행정각부의 장은 국무위원 중에서 국무총리의 제청으로 대통령이 임명한다. 외국인은 국제법과 조약이
									정하는 바에 의하여 그 지위가 보장된다. 사회적 특수계급의 제도는 인정되지 아니하며, 어떠한 형태로도 이를 창설할
									수 없다. 법률이 정하는 주요방위산업체에 종사하는 근로자의 단체행동권은 법률이 정하는 바에 의하여 이를 제한하거나
									인정하지 아니할 수 있다.<span class="badge badge-info mx-1">{bCommentnum}</span>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-lg-6 col-md-12 text-truncate">
			<table class="table mb-lg-0">
				<thead class="thead-light">
					<tr>
						<th scope="col"><a class="text-decoration-none text-dark"
							href="/communityexample/humor">유머</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach begin="1" end="4" varStatus="var">
						<tr>
							<td><a class="text-decoration-none text-info"
								href="/communityexample/humor/${bIndex}">이 헌법에 의한 최초의 대통령의
									임기는 이 헌법시행일로부터 개시한다. 예비비는 총액으로 국회의 의결을 얻어야 한다. 예비비의 지출은 차기국회의
									승인을 얻어야 한다. 법률이 정하는 주요방위산업체에 종사하는 근로자의 단체행동권은 법률이 정하는 바에 의하여 이를
									제한하거나 인정하지 아니할 수 있다. 공공필요에 의한 재산권의 수용·사용 또는 제한 및 그에 대한 보상은 법률로써
									하되, 정당한 보상을 지급하여야 한다.<span class="badge badge-info mx-1">{bCommentnum}</span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<table class="table mb-lg-0">
				<thead class="thead-light">
					<tr>
						<th scope="col"><a class="text-decoration-none text-dark"
							href="/communityexample/issue">이슈</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach begin="1" end="4" varStatus="var">
						<tr>
							<td><a class="text-decoration-none text-info"
								href="/communityexample/issue/${bIndex}">신체장애자 및 질병·노령 기타의
									사유로 생활능력이 없는 국민은 법률이 정하는 바에 의하여 국가의 보호를 받는다. 국군의 조직과 편성은 법률로
									정한다. 대통령은 내란 또는 외환의 죄를 범한 경우를 제외하고는 재직중 형사상의 소추를 받지 아니한다. 국회는
									상호원조 또는 안전보장에 관한 조약, 중요한 국제조직에 관한 조약, 우호통상항해조약, 주권의 제약에 관한 조약,
									강화조약, 국가나 국민에게 중대한 재정적 부담을 지우는 조약 또는 입법사항에 관한 조약의 체결·비준에 대한
									동의권을 가진다.<span class="badge badge-info mx-1">{bCommentnum}</span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


	<div class="row my-3">
		<div class="col-lg-6 col-md-12 text-truncate">
			<table class="table mb-lg-0">
				<thead class="thead-light">
					<tr>
						<th scope="col"><a class="text-decoration-none text-dark"
							href="">게시판3</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach begin="1" end="5" varStatus="var">
						<tr>
							<td><a class="text-decoration-none text-info" href="">신체장애자
									및 질병·노령 기타의 사유로 생활능력이 없는 국민은 법률이 정하는 바에 의하여 국가의 보호를 받는다. 국군의
									조직과 편성은 법률로 정한다. 대통령은 내란 또는 외환의 죄를 범한 경우를 제외하고는 재직중 형사상의 소추를 받지
									아니한다. 국회는 상호원조 또는 안전보장에 관한 조약, 중요한 국제조직에 관한 조약, 우호통상항해조약, 주권의
									제약에 관한 조약, 강화조약, 국가나 국민에게 중대한 재정적 부담을 지우는 조약 또는 입법사항에 관한 조약의
									체결·비준에 대한 동의권을 가진다.<span class="badge badge-info mx-1">{bCommentnum}</span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-lg-6 col-md-12 text-truncate">
			<table class="table mb-lg-0">
				<thead class="thead-light">
					<tr>
						<th scope="col"><a class="text-decoration-none text-dark"
							href="">게시판4</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach begin="1" end="5" varStatus="var">
						<tr>
							<td><a class="text-decoration-none text-info" href="">신체장애자
									및 질병·노령 기타의 사유로 생활능력이 없는 국민은 법률이 정하는 바에 의하여 국가의 보호를 받는다. 국군의
									조직과 편성은 법률로 정한다. 대통령은 내란 또는 외환의 죄를 범한 경우를 제외하고는 재직중 형사상의 소추를 받지
									아니한다. 국회는 상호원조 또는 안전보장에 관한 조약, 중요한 국제조직에 관한 조약, 우호통상항해조약, 주권의
									제약에 관한 조약, 강화조약, 국가나 국민에게 중대한 재정적 부담을 지우는 조약 또는 입법사항에 관한 조약의
									체결·비준에 대한 동의권을 가진다.<span class="badge badge-info mx-1">{bCommentnum}</span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- end of content -->


</div>
<%@ include file="../include/footer.jsp"%>