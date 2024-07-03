package com.sast.astbenchmark.cases.accuracy.objectSensitive;

import com.sast.astbenchmark.model.alias.A;
import com.sast.astbenchmark.model.alias.B;
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
// compose = BackwardsIntraproceduralAlias_002_T.java
// bind_url = accuracy/objectSensitive/BackwardsIntraproceduralAlias_002_T
// assession information end
public class BackwardsIntraproceduralAlias_002_T {
    @PostMapping(value = "BackwardsIntraproceduralAlias_002_T")
    public Map<String, Object> testcase(@RequestParam String cmd) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            B b = new B();
            b.attr = new A();
            A a = b.attr;
            b.attr.b = cmd;

            Runtime.getRuntime().exec(a.b);
            modelMap.put("status", "success");
        } catch (Exception e) {
            modelMap.put("status", "error");
        }
        return modelMap;
    }
}
