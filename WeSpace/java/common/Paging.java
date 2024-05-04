package common;

public class Paging {

	private final int perPage = 5; // 페이지당 글 개수 (고정이니까 final)
	private int pageCount; // 총 페이지 개수 (if 글 개수가 51개이면 5개씩이니까 11개가 총 페이지갯수가 됨)
	private int boardCount; // 총 글의 개수
	private int first; // 현재 페이지의 첫 글의 번호
	private int last; //현재 페이지의 끝글의 번호
	private final int perSection = 10; //페이지 개수 (한 페이지의 밑에 페이지 번호 써있는것 말하는 거임.10까지만 보이고 11 부터는 다음화면으로 넘어가야 보이게)
	private int begin; // 시작페이지 (0번 섹션 -> 1페이지)(1번 섹션-> 11)...  
	private int end; //끝페이지 (0번 섹션 -> 10페이지)(1번 섹션 -> 20) {if(2번 섹션에 21만 있을 경우) -> begin,end 둘 다 21}
	private int section; // 페이지 묶음 번호 (1~10페이지는 0, 11~20페이지는 1, ...)
	private int page; //현재 페이지
	
	private boolean prev; // true라면 이전버튼 뜨게 함(이전 섹션이 존재하는지 판별) (10페이지까지 쓸때는 이전, 다음 둘 다 없음 -> 11페이지 만들어지면 11페이지 눌렀을때 왼쪽에 이전이 생기고, 11페이지 말고 다른페이지 누르면 오른쪽에 다음버튼이 생김)
	private boolean next; // true라면 다음버튼 뜨게 함(다음 섹션이 존재하는지 판별)
	
	public Paging(int page,int boardCount) { 
		this.page = page;
		this.boardCount = boardCount;
		
		//총 페이지 
		pageCount = boardCount / perPage; //총 글의 개수(51)를 페이지당 글 개수(5)로 나눈 몫이 pageCount(총 페이지 개수(10))이다.(밑에서 나머지 1 처리 해줄 것)
		pageCount += (boardCount % perPage) == 0 ? 0 : 1; //총 글의 개수를 페이지당 글 개수로 나눈 나머지가 0이라면 0(정확히 맞아 떨어지면 다음 페이지가 필요 X //더할 것 없음), 아니라면 1(맞아 떨어지지 않으면 추가 페이지가 필요하므로 pageCount에 1을 더하여(누적) 페이지 개수를 조정)
		
		//시작글의 번호
		first = (page - 1) * perPage + 1; //현재 페이지의 첫 글의 번호 = 현재 페이지에서 1을 뺀 것과 페이지당 글의 갯수(5로 고정)에 1을 더한 값을 곱하면 됨
                                          //1페이지일 때 -> ( 1 - 1 ) * 5 + 1 (첫 글의 번호 : 1)
                                          //2번페이지일 때  ( 2 - 1 ) * 5 + 1 (첫 글의 번호 : 6) 6번부터 10번글이 있어야하므로 그것들을 계산해줌

		last = first + perPage - 1;        //현재 페이지의 마지막 글의 번호  = 현재 페이지의 첫 글의 번호 + 5 - 1 
                                           //1페이지일 때 -> 1 + 5 - 1 ( 마지막 글의 번호 : 5)
                                           //2페이지일 때 -> 6 + 5 - 1 ( 마지막 글의 번호 : 10)
		
		section = (page - 1) / perSection; //섹션 = (현재 페이지 - 1 ) / 10(고정)
                                           //1 ~ 10 페이지일 때 -> ( 섹션 : 0 )
                                           //11 ~ 20 페이지일 때 -> ( 섹션 : 1 )
                                           // ...

		//시작페이지,끝페이지
		begin = perSection * section + 1; // 10(고정) * 섹션 + 1 (섹션이 0일 때 -> 시작페이지: 1) ( 섹션이 1일 때 -> 시작페이지11) //현재 섹션의 첫 페이지를 구하는 식
		end = begin + perSection - 1; // 시작페이지 + 10(고정) -1; (시작페이지가 1일 때 -> 끝페이지: 10)(시작페이지가 2일 때 -> 끝 페이지 11) //현재 섹션의 마지막 페이지를 구하는 식
		end = end > pageCount ? pageCount : end;//끝 페이지의 번호가 총 페이지 개수보다 크면 end는 총 페이지 개수가 되고,그렇지 않으면 end는 아까 구한 값이 그대로 유지된다.
                                                //총 페이지 개수보다 지금 띄우는 페이지가 많으면 총페이지 개수로 마지막을 셋팅하겠다
                                                //ex)글 20개를 쓰면 4페이지(총 페이지 개수)가 나옴. 그때는 end페이지가 10이되면 안됨. 그때는 4페이지가 end페이지여야함.
                                                //글 60개면 12페이지(총 페이지 개수)가 나옴. 그러면 end페이지가 20이면 안됨. 그때는 12페이지가 end페이지여야함.
		
       //이전 & 다음 처리		
        prev = section != 0; //1~10페이지는 섹션이 0이므로 false (섹션이 0이 아니라면 true-> 이전 버튼 생김)
		next = boardCount > perPage * end; // 총 글의 개수 > 페이지당 글 개수(5로 고정) * 끝페이지가 true이면 -> 다음 버튼 생김
                                           // 51 > 5(고정) * 10 //글의 개수가 넘치기 때문에 다음 버튼이 있어야함
                                           // 총 글의 개수 -> 51 ~ 99 까지 다음 버튼 있다가 100이 되는 순간 다음 버튼 없어지고, 101이 되면 다시 생김
	}

	
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getPerPage() {
		return perPage;
	}
	public int getPerSection() {
		return perSection;
	}
}
