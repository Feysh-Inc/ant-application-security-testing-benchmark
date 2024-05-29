package com.sast.astbenchmark.cases.completeness.base.chain.taintKind;

/**
 * Introduction 污点链路样本中的source点-source未被污染-没有sink
 * Level X
 * Date 2024-05-23
 */
// assession information start
// real vulnerability = false
// assession project = 完整度->基础跟踪能力->污点链路完整度->污点状态->safe source->没有sink
// compose = !SafeKind_010_F.java && !SafeKind_011_F.java && !SafeKind_012_F.java
// bind_url =
// assession information end
public class SafeKind_011_F {
    public void testcase() {
        String sql = "select * from user where username = zhangsan";
    }
}
