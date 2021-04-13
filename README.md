# CnM

영화관 사이트(영화 정보 제공, 예매)



# DTO
getSelect
getList
getFileSelect
getFileInsert
setReply
setReplyUpdate
setInsert
setUpdate
setDelete


MemberDTO
	private String nickName;<<nickName은 변형이 자주 일어날 수 잇으니까 id로 pk바꾸자고 하기,,,미안하네,,
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private String coupon;
	private long point;
	private String grade;
	private String profilePic;

	
BoardDTO
	private long num;
	private String nickName;
	private String title;
	private String contents;
	private Date regDate;
	private long hit; <<notice랑 FAQ에도 hit있으면 좋을 거 같다(귀찮은거 아니구,,하하)
		CommunityDTO
			private String genre;
		NoticeDTO
		FaqDTO
		QnaDTO
			private String genre;
			private long ref;
			private long step;
			private long depth;
			private String lock;
BoardFileDTO
	(coummunity?)
	private String fileNum;
	private long num;
	private String fileName;
	private String originName;

CommentDTO
	private long commentNum;
	private long num;
	private String nickName;
	private String contents;
	private Date regDate;
	private long ref;
	private long step;
	private long depth;
ReviewDTO
	private long reviewNum;
	private String nickName;
	private double star;
	private String contents;
	private Date regDate;
	private long goodNum;
	private long badNum;
	private long warning;
BookedDTO
	private String bookedCode;
	private String nickName;
	private String theater;
	private String room;
	private String seatName;
	private String movieType;
	private String movieTitle;
	private Date scheduleTime;
	private long price;
	private long bookedCount;<<<count가 더 나을거 같다고 말하기
	private String payment;
	private String state;
	
--
LocationDTO
	private long num;
	private String theater;
	private String room;
	private String seatName;
	private String movieType;<<이거 넣을거면 장르별 통계도 뽑아도 될듯
	private long totalProfit;
	private long totalAudience;
		SeoulTheaterDTO
		BusanTheaterDTO
		GwangjuTheaterDTO
		IncheonTheaterDTO
		DaeguTheaterDTO
		DaejeonTheaterDTO
		UlsanTheaterDTO
		SejongTheaterDTO
ScheduleDTO
	private long scheduleNum;
	private String theater;
	private String room;
	private String movieType;
	private Date scheduleTile;
	private String movieTitle;

--
util
