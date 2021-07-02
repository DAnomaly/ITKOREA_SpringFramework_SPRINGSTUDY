package com.koreait.mygallery.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Board {
	private long boardNo;
	private String id;
	private String content;
	private String postdate;
	private String ip;
	private int state;
	private int groupno;
	private int groupord;
	private int depth;
}
