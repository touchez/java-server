package com.iotexample.demo.controller;

import com.iotexample.demo.result.CodeMsg;
import com.iotexample.demo.result.Result;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @program: iotdemo
 * @description: 远程调用服务器的python代码
 * @author: WenYuan
 * @create: 2019-07-03 16:12
 */

@RestController
@RequestMapping("/pyapi")
public class UsePythonController {

  @RequestMapping("/callow")
  @CrossOrigin
  public Result<String> callOpenWebPy() {
    try {
      //execShell("python3");
      Process process = Runtime.getRuntime().exec("/root/OpenWeb/OpenWeb/testClient.py");
    } catch (Exception e) {
      return Result.error(CodeMsg.SERVER_ERROR);
    }

    return Result.success("success");
  }

  /**
   * 解决了 参数中包含 空格和脚本没有执行权限的问题
   *
   * @param scriptPath 脚本路径
   * @param para       参数数组
   */
  private void execShell(String scriptPath, String... para) {
    try {
      String[] cmd = new String[]{scriptPath};
      //为了解决参数中包含空格
      cmd = ArrayUtils.addAll(cmd, para);

      //解决脚本没有执行权限
      ProcessBuilder builder = new ProcessBuilder("/bin/chmod", "755", scriptPath);
      Process process = builder.start();
      process.waitFor();

      Process ps = Runtime.getRuntime().exec(cmd);
      ps.waitFor();

      BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
      StringBuffer sb = new StringBuffer();
      String line;
      while ((line = br.readLine()) != null) {
        sb.append(line).append("\n");
      }
      //执行结果
      String result = sb.toString();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
