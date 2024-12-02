package athread.step1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinVO {
    private String mem_id;
    private String mem_pw;
    private String mem_nickname;
    private String mem_name;
    private String mem_birth;
    private String mem_hp;
}
