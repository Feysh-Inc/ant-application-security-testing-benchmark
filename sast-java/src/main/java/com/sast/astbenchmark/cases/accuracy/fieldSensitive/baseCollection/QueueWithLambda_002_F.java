package com.sast.astbenchmark.cases.accuracy.fieldSensitive.baseCollection;

import com.google.common.collect.Queues;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Introduction 域敏感-Queue+Lambda
 * Level X
 * Date 2024-05-09
 */
// assession information start
// real vulnerability = false
// assession project = 准确度->域敏感->容器->Queue+Lambda
// compose = !QueueWithLambda_002_F.java && QueueWithLambda_001_T.java
// bind_url = accuracy/fieldSensitive/baseCollection/QueueWithLambda_002_F
// assession information end

@RestController()
@RequestMapping("accuracy/fieldSensitive/baseCollection")
public class QueueWithLambda_002_F {
    @PostMapping(value = "QueueWithLambda_002_F")
    public Map<String, Object> testcase(@RequestParam String cmd) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            Queue<String> queue = Queues.newArrayDeque();
            queue.add(cmd);
            queue.add("cd /");
            queue.add("cd ~");
            queue.stream().forEach(e -> {
                if ("cd /".equals(e)) {
                    try {
                        Runtime.getRuntime().exec(e);  // !$CWE-78
                    } catch (IOException ex) {
                    }
                }
            });

            modelMap.put("status", "success");
        } catch (Exception e) {
            modelMap.put("status", "error");
        }
        return modelMap;
    }
}
