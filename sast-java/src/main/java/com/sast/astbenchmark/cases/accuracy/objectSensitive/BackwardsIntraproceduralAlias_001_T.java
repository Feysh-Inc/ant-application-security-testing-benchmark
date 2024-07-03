package com.sast.astbenchmark.cases.accuracy.objectSensitive;

import com.sast.astbenchmark.model.alias.A;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * Introduction 对象敏感-别名是否被污染-BackwardsIntraproceduralAlias
 * Level X
 * Date 2024-07-02
 */
// assession information start
// real vulnerability = true
// assession project = 准确度->对象敏感->别名是否被污染->BackwardsIntraproceduralAlias
// compose = BackwardsIntraproceduralAlias_001_T.java
// bind_url = accuracy/objectSensitive/BackwardsIntraproceduralAlias_001_T
// assession information end
public class BackwardsIntraproceduralAlias_001_T {
    @PostMapping(value = "BackwardsIntraproceduralAlias_001_T")
    public Map<String, Object> testcase(@RequestParam String cmd) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            A a = new A();
            a.b = cmd;
            A a2 = a;

            Runtime.getRuntime().exec(a2.b);
            modelMap.put("status", "success");
        } catch (Exception e) {
            modelMap.put("status", "error");
        }
        return modelMap;
    }
}
