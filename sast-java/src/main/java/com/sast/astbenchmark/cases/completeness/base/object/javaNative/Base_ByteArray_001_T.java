package com.sast.astbenchmark.cases.completeness.base.object.javaNative;

import com.sast.astbenchmark.common.utils.SinkUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Introduction 对象中的简单类型对象，Byte[]对象为污点
 * Level X
 * Date 2024-05-09
 * 注意，case中的 SinkUtil.sink 为自定义Sink，由于评测对基础类型无法直接找到sink点，因此设计出了一个自定义Sink。
 * 此评价项（assession project）的达成为"或"条件（参考compose），一个case是自定义case的形式，另一种case是通过String.valueof函数转化为sink点可以接受的入参类型，两个case达成一个即认为本评价项达成。具体要支持哪个可依据不同引擎的情况而定。
 */
// assession information start
// real vulnerability = true
// assession project = 完整度->基础跟踪能力->污点对象完整度->java原生对象->Byte[]
// compose = Base_ByteArray_001_T.java || Base_ByteArray_002_T.java
// bind_url = completeness/base/object/javaNative/Base_ByteArray_001_T
// assession information end

@RestController()
@RequestMapping("completeness/base/object/javaNative")
public class Base_ByteArray_001_T {
    @PostMapping("Base_ByteArray_001_T")
    public Map<String, Object> aTaintCase0151(@RequestBody byte[] cmd) {  // $CWE-78
        Map<String, Object> modelMap = new HashMap<>();
        if (cmd == null || cmd.length < 1) {
            modelMap.put("status", "error");
            return modelMap;
        }
        SinkUtil.sink(cmd);
        modelMap.put("status", "success");
        return modelMap;
    }
}
