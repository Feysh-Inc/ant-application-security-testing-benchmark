package com.sast.astbenchmark.cases.accuracy.contextSensitive;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Introduction 上下文敏感-相同函数调用不同参数-VarargArrayAccess
 * Level X
 * Date 2024-06-28
 */
// assession information start
// real vulnerability = true
// assession project = 准确度->上下文敏感->相同函数调用不同参数->VarargArrayAccess
// compose = DifferentParamsForFunction_005_T.java && !DifferentParamsForFunction_006_F.java
// bind_url = accuracy/contextSensitive/DifferentParamsForFunction_005_T
// assession information end

@RestController()
@RequestMapping("accuracy/contextSensitive")
public class DifferentParamsForFunction_005_T {
    @PostMapping("DifferentParamsForFunction_005_T")
    public Map<String, Object> testcase(@RequestParam String cmd) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            String a = Invoke.chooseOne(3, "a", "b", "c", cmd, "e");
            Runtime.getRuntime().exec(a);  // $CWE-78
            modelMap.put("status", "success");
        } catch (Exception e) {
            modelMap.put("status", "error");
        }
        return modelMap;
    }

    private static class Invoke {
        private static String chooseOne(int i, String... params) {
            return params[i];
        }
    }
}