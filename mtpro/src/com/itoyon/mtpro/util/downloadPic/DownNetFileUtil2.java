package com.itoyon.mtpro.util.downloadPic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itoyon.mtpro.util.jdbc.JDBCUtil;

/**
 * This class is used to download files from the Internet to the native machine.
 * 
 */

public class DownNetFileUtil2 {
	private static final String FILE_DIR = "D:\\images\\";

	public static void main(String[] args) {
		downloadDrugPic();
	}

	/**
	 * 下载药品图片
	 */
	public static void downloadDrugPic() {
		long startTime = System.currentTimeMillis();
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		StringBuffer sb = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currDate = sdf.format(new Date());

		try {
			conn = new JDBCUtil().doConnet();
			statement = conn.createStatement();
			sb = new StringBuffer();
			sb.append("SELECT \n");
			sb.append("	d.drug_id, \n");
			sb.append("	CONCAT('http://file.cdfortis.com/', d.pic_path) AS pic_path, \n");
			sb.append("	substring_index(d.pic_path, '/', - 1) AS file_name \n");
			sb.append("FROM \n");
			sb.append("	b_drug d \n");
			sb.append("WHERE \n");
			sb.append("	1 = 1 \n");
			sb.append("AND d.pic_path IS NOT NULL \n");
			sb.append("AND d.`status` = 1");
			rs = statement.executeQuery(sb.toString());
			String picPath = null;
			String fileName = null;

			while (rs.next()) {
				picPath = rs.getString("pic_path");
				fileName = rs.getString("file_name");
				download(picPath, fileName, FILE_DIR + currDate + "\\");
			}

			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

			try {
				if (rs.next()) {
					rs.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		long endTime = System.currentTimeMillis();

		System.out.println("执行耗时：" + (endTime - startTime) / 1000 + " s");
	}

	/**
	 * 下载文件
	 * 
	 * @param urlString
	 * @param filename
	 * @param savePath
	 * @throws Exception
	 */
	public static void download(String urlString, String filename, String savePath) throws Exception {
		InputStream netFileInputStream = null;

		try {
			// 构造URL
			URL url = new URL(urlString);
			// 打开连接
			URLConnection con = url.openConnection();
			// 设置请求超时为5s
			con.setConnectTimeout(5 * 1000);
			// 输入流
			netFileInputStream = con.getInputStream();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			if (null == netFileInputStream) {
				System.out.println("[" + sdf.format(new Date()) + "] - [ERROR] 网络文件 “" + urlString + "” 不存在！");
			} else {
				// 文件绝对路径
				String fileFullName = null;

				// 1K的数据缓冲
				byte[] bs = new byte[1024];
				// 读取到的数据长度
				int len;
				// 输出的文件流
				File sf = new File(savePath);
				if (!sf.exists()) {
					sf.mkdirs();
				}
				fileFullName = sf.getPath() + "\\" + filename;
				File file = new File(fileFullName);
				if (!file.exists()) {
					OutputStream os = new FileOutputStream(fileFullName);
					// 开始读取
					while ((len = netFileInputStream.read(bs)) != -1) {
						os.write(bs, 0, len);
					}

					System.out.println("[" + sdf.format(new Date()) + "] - [INFO] 将网络文件 “" + urlString + "” 下载到本地  “"
							+ savePath + filename + "”.");
					os.close();
				}

				netFileInputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (netFileInputStream != null) {
					netFileInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
