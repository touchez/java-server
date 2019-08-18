package com.iotexample.demo.controller;

import com.iotexample.demo.config.test;
import com.iotexample.demo.result.CodeMsg;
import com.iotexample.demo.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * @program: iotdemo
 * @description: 远程调用服务器的python代码
 * @author: WenYuan
 * @create: 2019-07-03 16:12
 */

@RestController
@RequestMapping("/pyapi")
@Slf4j
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

  @RequestMapping("/openlock")
  @CrossOrigin
  public Result<String> openLock() {
    try {
//      execShell("/root/NFCproject/test_tcp_client.py", "1");
//      Process process = Runtime.getRuntime().exec("/root/NFCproject/start1.sh");
      callScript("start1.sh", "", "/root/NFCproject/");
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

      log.info("result is {}", result);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  private void callScript(String script, String args, String... workspace){
    try {
      String cmd = "sh " + script + " " + args;
//        	String[] cmd = {"sh", script, "4"};
      File dir = null;
      if(workspace[0] != null){
        dir = new File(workspace[0]);
        System.out.println(workspace[0]);
      }
      String[] evnp = {"val=2", "call=Bash Shell"};
      Process process = Runtime.getRuntime().exec(cmd, evnp, dir);
//            process = Runtime.getRuntime().exec(cmd);
      BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line = "";
      while ((line = input.readLine()) != null) {
        System.out.println(line);
      }
      input.close();
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }


}
