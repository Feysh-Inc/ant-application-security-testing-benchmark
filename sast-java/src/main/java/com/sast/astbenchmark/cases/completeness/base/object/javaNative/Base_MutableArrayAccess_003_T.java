package com.sast.astbenchmark.cases.completeness.base.object.javaNative;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Introduction 对象中的简单类型对象，可变数组中的元素被污染
 * Level X
 * Date 2024-06-28
 */
// assession information start
// real vulnerability = true
// assession project = 完整度->基础跟踪能力->污点对象完整度->java原生对象->Array
// compose = Base_MutableArrayAccess_001_T.java && !Base_MutableArrayAccess_002_F.java && Base_MutableArrayAccess_003_T.java && !Base_MutableArrayAccess_004_F.java
// bind_url = completeness/base/object/javaNative/Base_MutableArrayAccess_003_T
// assession information end

@RestController()
@RequestMapping("completeness/base/object/javaNative")
public class Base_MutableArrayAccess_003_T {
    @PostMapping("Base_MutableArrayAccess_003_T")
    public Map<String, Object> testcase(@RequestParam String cmd) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            String a = Invoke.choose2("a", "b", cmd, "e");
            String b = Invoke.choose2("a", "b", "c", cmd);
            Runtime.getRuntime().exec(a);
            modelMap.put("status", "success");
        } catch (Exception e) {
            modelMap.put("status", "error");
        }
        return modelMap;
    }

    private static class Invoke {
        private static String choose2(String... params) {
            return params[2];
        }
    }
}