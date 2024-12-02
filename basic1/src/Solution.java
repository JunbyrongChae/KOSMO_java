public class Solution {
    public int solution(String s) {
        public int solution ( int n){
            int answer = 0;
            for (int x = 2; x < n; x++) {
                if (n % x == 1) {
                    return x; // 조건을 만족하는 가장 작은 x를 반환
                }
                answer = x;
            }
            return answer; // 정상적으로는 도달하지 않음 (답이 항상 존재한다고 가정)
        }
    }
}
