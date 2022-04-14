package web.services.learn.lessons.originInterview;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.services.learn.LoveFlyWithDream;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 特斯拉面试题
 *
 * @author HeTing.Zhao
 * @since 2022/4/14
 */
public class Tesla {

    //第一题
    @GetMapping(value = "/healthcheck")
    public ResponseEntity<String> healthcheck(@RequestParam(value = "format", required = true) String format) throws JsonProcessingException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        if ("full".equals(format)) {
            String dataTime = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT);
            DetailEntity entity = new DetailEntity();
            entity.setCurrentTime(dataTime);
            entity.setStatus("OK");
            return ResponseEntity.ok().headers(httpHeaders).body(new ObjectMapper().writeValueAsString(entity));
        }
        if ("short".equals(format)) {
            SimpleEntity entity = new SimpleEntity();
            entity.setStatus("OK");
            return ResponseEntity.ok().headers(httpHeaders).body(new ObjectMapper().writeValueAsString(entity));
        }

        return ResponseEntity.badRequest().headers(httpHeaders).build();
    }

    static class SimpleEntity {
        String status;

        public SimpleEntity() {
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    static class DetailEntity {
        String currentTime;
        String status;

        public DetailEntity() {
        }

        public String getCurrentTime() {
            return currentTime;
        }

        public void setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }


    /**
     * 特斯拉面试题。
     *
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "{()}[]";
        List<String> result = new ArrayList<>();
        result.add(s1);
        LoveFlyWithDream loveFlyWithDream = new LoveFlyWithDream();
        int[] C = {3, 2, 1, 2, 1, 2};
        int res = loveFlyWithDream.solution("aabbcc", C);
        System.out.println(res);
    }

    //特斯拉面试题。
    public int solution(String S, int[] C) {
        // write your code in Java SE 8
        //aabbcc 121212.
        char[] sArray = S.toCharArray();
        int leftIndex = 0, rightIndex = 0;
        int result = 0;
        while (rightIndex < sArray.length) {
            int maxC = C[leftIndex], sumC = 0;
            while (rightIndex < sArray.length && sArray[leftIndex] == sArray[rightIndex]) {
                maxC = Math.max(maxC, C[rightIndex]);
                sumC += C[rightIndex];
                ++rightIndex;
            }
            if (leftIndex < rightIndex - 1) {
                result += sumC - maxC;
            }
            leftIndex = rightIndex;
        }
        return result;
    }
}
