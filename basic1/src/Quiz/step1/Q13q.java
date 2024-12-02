package Quiz.step1;
//생성자와 this
public class Q13q {
    private String name;
  //public Q13q(){this("fern");}
    public Q13q(String name){this.name = name;}//this.name = "Unnamed"
    public String getName(){return name;}
}/*
public class Tree extends Q13 {
    //public Tree(){ super();}// 부모 클래스의 디폴트 생성자를 호출
    public void growFruit() {}
    public void dropLeaves() {}
}*/


/******************************************************************************
Which is true?
A. The code will compile without changes.
B. The code will compile if public Tree() { Plant(); } is added to the Tree class.
C. The code will compile if public Q13() { Tree(); } is added to the Plant class.
D. The code will compile if public Q13() { this(”fern”); } is added to the Plant class.
E. The code will compile if public Q13() { Plant(”fern”); } is added to the Plant class.
//상위클래스에서 인자만 있는 생성자만 있기 때문에 디폴트생성자를 만들어야 하지만 보기중에 없기 때문에 this()자기 생성자호출을 사용한 D가 정답이 된다.
 *********************************************************************************/