package com.sast.astbenchmark.cases.accuracy.objectSensitive;

import com.sast.astbenchmark.model.alias.PrimitiveData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Introduction 对象敏感-别名是否被污染-PrimitiveDataAlias
 * Level X
 * Date 2024-07-02
 */
// assession information start
// real vulnerability = true
// assession project = 准确度->对象敏感->别名是否被污染->PrimitiveDataAlias
// compose = PrimitiveDataAlias_001_T.java
// bind_url = accuracy/objectSensitive/PrimitiveDataAlias_001_T
// assession information end
@RestController
@RequestMapping("accuracy/objectSensitive")
public class PrimitiveDataAlias_001_T {
    @PostMapping(value = "PrimitiveDataAlias_001_T")
    public Map<String, Object> testcase(@RequestParam int id) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            PrimitiveData i = new PrimitiveData();
            PrimitiveData b = i;
            b.setIntData(id);
            Runtime.getRuntime().exec("cat /some/path/" + b.intData + ".png");
            modelMap.put("status", "success");
        } catch (Exception e) {
            modelMap.put("status", "error");
        }
        return modelMap;
    }
}