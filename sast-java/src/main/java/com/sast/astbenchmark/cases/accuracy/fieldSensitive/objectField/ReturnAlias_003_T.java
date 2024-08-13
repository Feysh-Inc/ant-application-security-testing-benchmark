package com.sast.astbenchmark.cases.accuracy.fieldSensitive.objectField;

import com.sast.astbenchmark.model.alias.A;
import com.sast.astbenchmark.model.alias.Invoke;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Introduction 域敏感-对象属性-对象指针-ReturnAlias FlowSensitive-scene2
 * Level X
 * Date 2024-07-02
 */
// assession information start
// real vulnerability = true
// assession project = 准确度->域敏感->对象属性->对象指针->ReturnAlias FlowSensitive-scene2
// compose = ReturnAlias_003_T.java && !ReturnAlias_004_F.java
// bind_url = accuracy/fieldSensitive/objectField/ReturnAlias_003_T
// assession information end
@RestController
@RequestMapping("accuracy/fieldSensitive/objectField")
public class ReturnAlias_003_T {
    @PostMapping(value = "ReturnAlias_003_T")
    public Map<String, Object> testcase(@RequestParam String cmd) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            A a = new A();
            A b = Invoke.alias(a);
            A c = Invoke.alias(b);
            A d = Invoke.alias(c);
            A e = Invoke.alias(d);
            a.b = cmd;

            Runtime.getRuntime().exec(e.b);  // $CWE-78
            modelMap.put("status", "success");
        } catch (Exception e) {
            modelMap.put("status", "error");
        }
        return modelMap;
    }
}
