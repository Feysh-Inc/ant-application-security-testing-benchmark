package com.sast.astbenchmark.cases.accuracy.objectSensitive;

import com.sast.astbenchmark.model.alias.DataClass;
import com.sast.astbenchmark.model.alias.Invoke;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * Introduction 对象敏感-别名是否被污染-BackwardsInterproceduralAlias
 * Level X
 * Date 2024-07-02
 */
// assession information start
// real vulnerability = false
// assession project = 准确度->对象敏感->别名是否被污染->BackwardsInterproceduralAlias
// compose = !BackwardsInterproceduralAlias_002_F.java
// bind_url = accuracy/objectSensitive/BackwardsInterproceduralAlias_002_F
// assession information end
public class BackwardsInterproceduralAlias_002_F {
    @PostMapping(value = "BackwardsInterproceduralAlias_002_F")
    public Map<String, Object> testcase(@RequestParam String cmd) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            DataClass dc1 = new DataClass();
            DataClass dc2 = new DataClass();
            Invoke.copy(dc1, dc2);
            Invoke.taintMe(dc1, cmd);

            Runtime.getRuntime().exec(dc2.data);
            modelMap.put("status", "success");
        } catch (Exception e) {
            modelMap.put("status", "error");
        }
        return modelMap;
    }
}
