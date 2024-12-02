edit TALK_MEMBER; 

edit TALK_FRIEND;

commit; 

SELECT
        MEM.MEM_ID, FRI.F_ID,FRI.RERELATIONSHIP
  FROM TALK_MEMBER MEM, TALK_FRIEND FRI
 WHERE FRI.MEM_ID = MEM.MEM_ID;
 
 SELECT
        MEM.MEM_ID, FRI.F_ID,FRI.RERELATIONSHIP
      , MEM.MEM_NAME AS "내이름",MEM1.MEM_NAME AS "친구이름"
  FROM TALK_MEMBER MEM, TALK_FRIEND FRI, TALK_MEMBER MEM1
 WHERE MEM.MEM_ID = FRI.MEM_ID
   AND FRI.F_ID = MEM1.MEM_ID  
   AND MEM.MEM_ID = 'kiwi';
   
    SELECT
        mem.mem_id, fri.f_id,fri.rerelationship, mem.status_msg AS "내상메",MEM1.STATUS_MSG AS "친구상메"
      , MEM.MEM_NAME AS "내이름",MEM1.MEM_NAME AS "친구이름"
  FROM talk_member mem, talk_friend fri, talk_member mem1
 WHERE MEM.MEM_ID = FRI.MEM_ID
   AND FRI.F_ID = MEM1.MEM_ID  
   AND MEM.MEM_ID = 'kiwi';