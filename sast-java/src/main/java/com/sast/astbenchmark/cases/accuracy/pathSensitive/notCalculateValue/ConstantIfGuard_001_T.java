package com.sast.astbenchmark.cases.accuracy.pathSensitive.notCalculateValue;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Introduction 路径敏感-不涉及求解问题-常量分支条件
 * Level X
 * Date 2024-05-23
 */
// assession information start
// real vulnerability = true
// assession project = 准确度->路径敏感->不涉及求解问题->常量分支条件
// compose = !ConstantIfGuard_002_F.java && ConstantIfGuard_001_T.java
// bind_url = accuracy/pathSensitive/notCalculateValue/ConstantIfGuard_001_T
// assession information end
@RestController
@RequestMapping("accuracy/pathSensitive/notCalculateValue")
public class ConstantIfGuard_001_T {
    @PostMapping(value = "ConstantIfGuard_001_T")
    public Map<String, Object> testcase(@RequestParam String cmd) {
        Map<String, Object> modelMap = new HashMap<>();
        String exec = getCmdWithPathSensitive(cmd);
        try {
            Runtime.getRuntime().exec(exec);  // $CWE-78
            modelMap.put("status", "success");
        } catch (IOException e) {
            modelMap.put("status", "error");
        }
        return modelMap;
    }

    private String getCmdWithPathSensitive(String cmd) {
        int x = 1;
        if (x > 0) {
            return cmd;
        }
        else {
            return "ls";
        }
    }
}
