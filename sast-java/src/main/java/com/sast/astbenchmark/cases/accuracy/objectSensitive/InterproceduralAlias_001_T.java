package com.sast.astbenchmark.cases.accuracy.objectSensitive;

import com.sast.astbenchmark.model.alias.DataClass;
import com.sast.astbenchmark.model.alias.Invoke;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Introduction 对象敏感-别名是否被污染-InterproceduralAlias
 * Level X
 * Date 2024-07-02
 */
// assession information start
// real vulnerability = true
// assession project = 准确度->对象敏感->别名是否被污染->InterproceduralAlias
// compose = InterproceduralAlias_001_T.java
// bind_url = accuracy/objectSensitive/InterproceduralAlias_001_T
// assession information end
@RestController
@RequestMapping("accuracy/objectSensitive")
public class InterproceduralAlias_001_T {
    @PostMapping(value = "InterproceduralAlias_001_T")
    public Map<String, Object> aliasCase0005(@RequestParam String cmd) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            String tainted = cmd;
            DataClass dc1 = new DataClass();
            DataClass dc2 = new DataClass();
            dc1.data = tainted;
            Invoke.copy(dc1, dc2);

            Runtime.getRuntime().exec(dc2.data);
            modelMap.put("status", "success");
        } catch (Exception e) {
            modelMap.put("status", "error");
        }
        return modelMap;
    }
}
