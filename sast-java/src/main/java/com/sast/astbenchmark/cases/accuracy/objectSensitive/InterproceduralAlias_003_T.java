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
// compose = InterproceduralAlias_003_T.java
// bind_url = accuracy/objectSensitive/InterproceduralAlias_003_T
// assession information end
@RestController
@RequestMapping("accuracy/objectSensitive")
public class InterproceduralAlias_003_T {
    @PostMapping(value = "InterproceduralAlias_003_T")
    public Map<String, Object> aliasCase0005(@RequestParam String cmd) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            DataClass dc1 = new DataClass();
            DataClass dc2 = new DataClass();
            Invoke.taintMe(dc1, cmd);
            Invoke.copy(dc1, dc2);

            Runtime.getRuntime().exec(dc2.data);
            modelMap.put("status", "success");
        } catch (Exception e) {
            modelMap.put("status", "error");
        }
        return modelMap;
    }
}
