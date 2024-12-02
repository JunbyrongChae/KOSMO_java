package athread.step1;

public class Protocol {
    public static final int WAIT = 100;//대기자방
    public static final int ROOM_CREATE = 110;//방만들기
    public static final int ROOM_LIST = 120;//단톡방 목록
    public static final int ROOM_IN = 130;//방입장
    public static final int ROOM_INLIST = 140;//사람목록
    public static final int ROOM_OUT = 190;//방나가기
    public static final int MESSAGE = 200;//단톡
    public static final int WHISPER = 201;//1:1
    public static final int NICK_CHANGE = 300;//닉변
    public static final int COLOR_CHANGE = 400;//글자색변경
    public static final String seperator = "#";//토큰값
}
