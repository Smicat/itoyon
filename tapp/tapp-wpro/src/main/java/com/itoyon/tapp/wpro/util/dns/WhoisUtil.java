package com.itoyon.tapp.wpro.util.dns;

import org.apache.commons.net.whois.WhoisClient;

import java.io.IOException;

public class WhoisUtil {
	public static void main(String[] args) {
		WhoisClient whois = new WhoisClient();
		WhoisUtil whoisTest = new WhoisUtil();
		// //默认 whois.internic.net 端口43
		// whoisTest.queryWhois(WhoisClient.DEFAULT_HOST, "oschina.net");
		// //使用国家域名whois服务器
		// whoisTest.queryWhois("whois.cnnic.cn", "12306.cn");
		whoisTest.queryWhois(WhoisClient.DEFAULT_HOST, "cdfortis.com");
	}

	public void queryWhois(String hostName, String domianName) {
		WhoisClient whois = new WhoisClient();

		try {
			// 连接whois查询服务器
			whois.connect(hostName);
			// 查询
			System.out.println(whois.query(domianName));
			// 关闭连接
			whois.disconnect();
		} catch (IOException e) {
			System.err.println("Error I/O exception: " + e.getMessage());
			return;
		}
	}
}
