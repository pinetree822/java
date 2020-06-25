package My.project;

public class Test {

	public static void main(String[] args) {
		DataClass []dc=new DataClass[200];
		dc[0].setData("바람의이야기","200","images/a.jpg","마음의 평화를 줍니다.","책","영등포구");
		dc[1].setData("애기옷","6000","images/b.jpg","작아요","유아용품","강남구");
		dc[2].setData("모자","5000","images/c.jpg","검은색이에요","잡화","강북구");
		dc[3].setData("스커트","300","images/d.jpg","짧아요","옷","강서구");
		dc[4].setData("핸드폰","200000","images/e.jpg","3년사용","전자제품","신사구");
		
		
		String str = dc[0].vPrice;
	}

}
