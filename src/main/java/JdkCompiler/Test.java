package JdkCompiler;

import cn.hutool.crypto.digest.MD5;
import com.google.common.collect.Maps;
import org.apache.dubbo.common.compiler.support.JdkCompiler;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2021/6/19
 */
public class Test {

    public static void main(String[] args) throws ScriptException {
        
        //1. 页面配置环境变量,上下文变量，json数据解析，放入到环境变量中 todo
        String signUrl = "signUrlTest";
        String secret = "secretTest";
        String appKey = "appKeyTest";

        long timestamp = System.currentTimeMillis();
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        int pageNo = 1;
        int pageSize = 10;

        // 环境变量
        Map<String, String> env = Maps.newHashMap();
        env.put("signUrl", signUrl);
        env.put("appKey", appKey);
        env.put("secret", secret);
        // 上下文
        Map<String, String> context = Maps.newHashMap();
        context.put("timestamp", Long.toString(timestamp));
        context.put("start", Long.toString(start));
        context.put("end", Long.toString(end));
        context.put("pageNo", Integer.toString(pageNo));
        context.put("pageSize", Integer.toString(pageSize));

        // 2.解析订单列表地址
        String requestUrl = "https://ark.xiaohongshu.com/ark/open_api/v0/packages?app_key=$appKey$&start_time=$$start$$&app_key=$appKey$&end_time=$$end$$" +
                "&status=waiting&page_no=$$pageNo$$&page_size=$$pageSize$$&time_type=confirmed_at";
        // 字符串占位符替换
        requestUrl = resolvePlaceholdersEnv(requestUrl,env);
        System.out.println(requestUrl);
        requestUrl = resolvePlaceholdersContext(requestUrl,context);
        System.out.println(requestUrl);

        // 3. 动态编译获取签名
        String sign = getJdkCompilerSign(env, context);
        // 4. 执行拉取订单数据 todo


    }

    public static String getJdkCompilerSign(Map<String, String> env, Map<String, String> context){
        String methodStr = "package com.dahai.video.product.utils;\n" +
                "\n" +
                "import cn.hutool.crypto.digest.MD5;\n" +
                "import com.alibaba.fastjson.JSON;\n" +
                "\n" +
                "import java.util.HashMap;\n" +
                "import java.util.Map;\n" +
                "\n" +
                "/**\n" +
                " * @author hanqingsong\n" +
                " * @version 1.0\n" +
                " * @date 2021/6/19\n" +
                " */\n" +
                "public class XiaohongshuSign implements Sign {\n" +
                "    @Override\n" +
                "    public String getSign(Map<String, String> env, Map<String, String> context){\n" +
                "        System.out.println(env);\n" +
                "        System.out.println(context);\n" +
                "        Map<String, String> paramMap = new HashMap<String, String>();\n" +
                "        paramMap.put(\"app-key\", env.get(\"appKey\"));\n" +
                "        paramMap.put(\"timestamp\", context.get(\"timestamp\").subSequence(0, 10).toString());\n" +
                "        paramMap.put(\"start_time\", context.get(\"start\"));\n" +
                "        paramMap.put(\"end_time\", context.get(\"end\"));\n" +
                "        paramMap.put(\"page_no\", context.get(\"pageNo\"));\n" +
                "        paramMap.put(\"page_size\", context.get(\"pageSize\"));\n" +
                "        paramMap.put(\"status\", \"waiting\");\n" +
                "        paramMap.put(\"time_type\", \"confirmed_at\");\n" +
                "\n" +
                "        System.out.println(JSON.toJSONString(paramMap));\n" +
                "\n" +
                "        String formatUrl = SortUtil.formatUrlParam(paramMap, \"utf-8\", true);\n" +
                "        String combine = env.get(\"signUrl\") + formatUrl + env.get(\"signUrl\");\n" +
                "        String digestHex = MD5.create().digestHex(combine);\n" +
                "        System.out.println(digestHex);\n" +
                "        return digestHex;\n" +
                "    }\n" +
                "}";
        JdkCompiler jdkCompiler = new JdkCompiler();
        try {
            Class<?> aClass = jdkCompiler.doCompile("com.dahai.video.product.utils.XiaohongshuSign", methodStr);
            Object instance = aClass.newInstance();
            Method method = aClass.getMethod("getSign",Map.class,Map.class);
            Object invoke = method.invoke(instance,env,context);
            return (String) invoke;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "";
    }

    public static Object scriptEngineManager() throws ScriptException {
        String str = "x<=1?5:x<=2?10:x<=5?15:20";

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("js");
        engine.put("x",3);

        Object result = engine.eval(str);
        System.out.println("结果类型:" + result.getClass().getName() + ",计算结果:"
                + result);
        return result;
    }

    public static String getSign(Map<String, String> env, Map<String, String> context){
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("app-key", env.get("appKey"));
        paramMap.put("timestamp", context.get("timestamp").subSequence(0, 10).toString());
        paramMap.put("start_time", context.get("start"));
        paramMap.put("end_time", context.get("end"));
        paramMap.put("page_no", context.get("pageNo"));
        paramMap.put("page_size", context.get("pageSize"));
        paramMap.put("status", "waiting");
        paramMap.put("time_type", "confirmed_at");

        String formatUrl = SortUtil.formatUrlParam(paramMap, "utf-8", true);
        String combine = env.get("signUrl") + formatUrl + env.get("signUrl");
        String digestHex = MD5.create().digestHex(combine);
        System.out.println(digestHex);
        return digestHex;
    }

    public static String resolvePlaceholdersContext(String text, Map<String, String> parameter) {
        return resolvePlaceholders(text, parameter, "$$", "$$");
    }
    public static String resolvePlaceholdersEnv(String text, Map<String, String> parameter) {
        return resolvePlaceholders(text, parameter, "$", "$");
    }
    public static String resolvePlaceholders(String text, Map<String, String> parameter, String placeholderPrefix, String placeholderSuffix) {
        if (parameter == null || parameter.isEmpty()) {
            return text;
        }

        StringBuffer buf = new StringBuffer(text);
        int startIndex = buf.indexOf(placeholderPrefix);
        while (startIndex != -1) {
            int endIndex = buf.indexOf(placeholderSuffix, startIndex + placeholderPrefix.length());
            if (endIndex != -1) {
                String placeholder = buf.substring(startIndex + placeholderPrefix.length(), endIndex);
                int nextIndex = endIndex + placeholderSuffix.length();
                if (placeholder.length() > 0) {
                    try {
                        String propVal = parameter.get(placeholder);
                        if (propVal != null) {
                            buf.replace(startIndex, endIndex + placeholderSuffix.length(), propVal);
                            nextIndex = startIndex + propVal.length();
                        } else {
                            System.out.println("Could not resolve placeholder '" + placeholder + "' in [" + text + "] ");
                        }
                    } catch (Exception ex) {
                        System.out.println("ex Could not resolve placeholder '" + placeholder + "' in [" + text + "]: " + ex);
                    }
                }
                startIndex = buf.indexOf(placeholderPrefix, nextIndex);
            } else {
                startIndex = -1;
            }
        }
        return buf.toString();
    }
}
