package com.sast.astbenchmark.cases.accuracy.fieldSensitive.objectField;

import com.sast.astbenchmark.model.alias.A;
import com.sast.astbenchmark.model.alias.B;
import com.sast.astbenchmark.model.alias.SimpleAlias;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Introduction 域敏感-对象属性-对象指针-别名参数
 * Level X
 * Date 2024-07-02
 */
// assession information start
// real vulnerability = false
// assession project = 准确度->域敏感->对象属性->对象指针->别名参数
// compose = SameArgumentAlias_001_T.java && !SameArgumentAlias_002_F.java
// bind_url = accuracy/fieldSensitive/objectField/SameArgumentAlias_002_F
// assession information end
@RestController
@RequestMapping("accuracy/fieldSensitive/objectField")
public class SameArgumentAlias_002_F {
    @PostMapping(value = "SameArgumentAlias_002_F")
    public Map<String, Object> testcase(@RequestParam String cmd) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            SimpleAlias sa = new SimpleAlias();
            B b1 = new B();
            B b2 = new B();
            A a = new A();
            a.b = cmd;

            sa.foo(b1, b2);
            String s = sa.bar(a).b;

            Runtime.getRuntime().exec(s);  // !$CWE-78
            modelMap.put("status", "success");
        } catch (Exception e) {
            modelMap.put("status", "error");
        }
        return modelMap;
    }
}