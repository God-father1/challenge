package com.globalcodingc.gcc.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globalcodingc.gcc.Service.ProfitMaximization;
import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/*
* @RequestMapping(value = {"json/test"},method = RequestMethod.GET)
    @ResponseBody
    public String jsonTest(String json){
       JSONObject jsonObject = JSONObject.fromObject(json);
        String m = jsonObject.get("message").toString();
        String t = jsonObject.get("time").toString();
        String n = jsonObject.get("name").toString();
    }
    * */
@RestController
public class GccController {
    @Autowired
    ProfitMaximization profitMaximization;


    @PostMapping(value = "/profit-maximization", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> profitMaximization(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map
                = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });

        String input = map.values().toString();
        String[] clear = new String[]{Arrays.toString(input.replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .split(" ,"))};
        List<Integer> answer = profitMaximization.findMaxProfit(clear);

        Map<String, Object> ans = new HashMap<>();
        ans.put("answer", answer);
        return ResponseEntity.ok(objectMapper.writeValueAsString(ans));
    }

}
