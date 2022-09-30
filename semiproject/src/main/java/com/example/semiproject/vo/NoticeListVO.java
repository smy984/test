package com.example.semiproject.vo;

import lombok.Data;

@Data
public class NoticeListVO {
	//공지사항 검색용
	private String type, keyword;
	
	public boolean isSearch() {
		return type != null && keyword != null;
	}
	
	//공지사항 페이징용
	private int p = 1;//선택한 페이지 번호(없을 시 1로 설정)
	
	private int printCount = 10;//한 화면에 출력될 게시물 수(없을 시 10으로 설정)
	
	private int count;//총 게시물 수
	
	private int blockSize = 5;//한 화면에 출력될 페이징 수
	
	public int endPrint() {//한 화면에 출력된 게시물의 마지막 번호
		return p * printCount;
	}
	
	public int startPrint() {//한 화면에 출력된 게시물의 첫 번째 번호
		return endPrint() - (printCount - 1);
	}
	
	public int endBlock() {//맨 마지막 페이징 번호
		int value = startBlock() + blockSize - 1;
		return Math.min(value, lastBlock());
	}
	
	public int startBlock() {//한 화면에 출력된 페이징 첫 번째 번호
		return (p - 1) / blockSize * blockSize + 1;
	}
	
	public int blockCount() {//총 페이징 개수
		return (count + (printCount - 1)) / printCount;
	}
	
	public int preBlock() {//이전 눌렀을 때 나타날 번호
		return startBlock() - 1;
	}
	
	public int nextBlock() {//다음 눌렀을 때 나타날 번호
		return endBlock() + 1;
	}
	
	public int firstBlock() {//페이징의 가장 맨 첫 번호-해석을 위해 한 번 더 만들었음
		return 1;
	}
	
	public int lastBlock() {//페이징의 가장 맨 마지막 번호-해석을 위해 한 번 더 만들었음
		return blockCount();
	}
	
	public boolean isFirst() {
		return p == 1;
	}
	
	public boolean isLast() {
		return endBlock() == lastBlock();
	}
	
	public boolean hasPrev() {
		return startBlock() > 1;
	}
	
	public boolean hasNext() {
		return endBlock() < lastBlock();
	}
}
