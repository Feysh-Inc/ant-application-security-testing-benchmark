package com.sast.astbenchmark.cases.completeness.base.chain.taintKind;

/**
 * Introduction 污点链路样本中的污点分类，source没有被污染，且没有sink
 * Level X
 * Date 2024-05-23
 */
// assession information start
// real vulnerability = false
// assession project = 完整度->基础跟踪能力->污点链路完整度->污点状态->source没有被污染
// compose = !SafeKind_001_F.java && !SafeKind_002_F.java && !SafeKind_003_F.java
// bind_url =
// assession information end
public class SafeKind_002_F {
    public void testcase() {
        String sql = "select * from user where username = zhangsan";
    }
}
