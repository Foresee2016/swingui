package org.foresee.swingui;

import java.util.HashMap;
import java.util.Map;

/**
 * 接收命令行启动时传入的参数，例如java org.foresee.swingui.InputArguments -name MyName -path E:/JavaSpace/test.txt
 * args是String[4]，其中逐个存放，解析成键值Map
 */
public class InputArguments {
	public static void main(String[] args) {
		for (String string : args) {
			System.out.println(string);
		}
		Map<String, String> arguments=new HashMap<>();
		for (int i = 0; i < args.length; i+=2) {
			String key=args[i];
			if(i+1 >= args.length){
				System.err.println("key = "+key+" 没有指定值，结束解析");
				break;
			}
			String value=args[i+1];
			arguments.put(key, value);
		}
		System.out.println("得到Key-Value");
		for (String key : arguments.keySet()) {
			System.out.println(key+", "+arguments.get(key));
		}
	}
}
