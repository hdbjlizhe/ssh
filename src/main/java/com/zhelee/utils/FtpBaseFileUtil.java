package com.zhelee.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.zhelee.info.domain.FtpBaseFile;

/**
 * “产业招商、精准招商”资料库 指定目录下面的所有文件
 * 
 * @author
 */
@Component
public class FtpBaseFileUtil {

	private static Logger logger = LoggerFactory.getLogger(FtpBaseFileUtil.class);

	// 属性值自动注入
	@Value("${ftpServer.host}")
	private String host;
	@Value("${ftpServer.port}")
	private int port;
	@Value("${ftpServer.userName}")
	private String userName;
	@Value("${ftpServer.password}")
	private String password;

	public FTPClient ftp;
	public List<FtpBaseFile> ftpBaseFiles;//做返回值接收用

	/**
	 * 重载构造函数
	 * 
	 * @param isPrintCommmand
	 *            是否打印与FTPServer的交互命令
	 * @return
	 */
	public FtpBaseFileUtil(){
		this(false);
	}
	public FtpBaseFileUtil(boolean isPrintCommmand) {
		//初始化FTPClient
		ftp = new FTPClient();
		this.ftp.setControlEncoding("GBK");
		//初始化ftpBaseFiles
		this.ftpBaseFiles=new ArrayList<FtpBaseFile>();
		//打印命令监听
		if (isPrintCommmand) {
			ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		}
	}

	/**
	 * 登陆FTP服务器
	 * @param host:FTPServer IP地址
	 * @param port:FTPServer 端口
	 * @param username:FTPServer 登陆用户名
	 * @param password:FTPServer 登陆密码
	 * @return boolean: 是否登录成功
	 * @throws IOException
	 */
	private boolean login(String host, int port, String username, String password) throws IOException {

		this.ftp.connect(host, port);

		if (FTPReply.isPositiveCompletion(this.ftp.getReplyCode())) {
			if (this.ftp.login(username, password)) {
				System.out.println("ftp.login方法成功");
				return true;
			}
		}
		if (this.ftp.isConnected()) {
			this.ftp.disconnect();
		}
		return false;
	}

	/**
	 * 关闭数据链接
	 * @throws IOException
	 */
	private void disConnection() throws IOException {
		if (this.ftp.isConnected()) {
			this.ftp.disconnect();
		}
	}

	/**
	 * 递归遍历目录下面指定的文件名
	 * @param pathName：需要遍历的目录，必须以"/"开始和结束
	 * @param ext： 文件的扩展名
	 * @throws IOException
	 */
	private void list(String pathName, String ext) throws IOException {

		if (pathName.startsWith("/") && pathName.endsWith("/")) {
			String directory = pathName;
			// 更换目录到当前目录
			this.ftp.changeWorkingDirectory(directory);
			FTPFile[] files = this.ftp.listFiles();
			for (FTPFile file : files) {
				//去除无效文件
				if (".".equals(file.getName()) || "..".equals(file.getName()))
					continue;
				if (file.isFile()) {
					//当为*号时,全适配
					if ("*".equals(ext)||file.getName().endsWith(ext)){
						ftpBaseFiles.add(FTPFile2FtpBaseFile(file,directory));
					}
				} else if (file.isDirectory()) {
					list(directory + file.getName() + "/", ext);
				}
			}
		}
	}
	
	// org.apache.commons.net.ftp.FTPFile转成自定义的FtpBaseFile
	private FtpBaseFile FTPFile2FtpBaseFile(FTPFile ftpFile, String filePath) {
		FtpBaseFile ftpBaseFile = new FtpBaseFile();
		// 文件名
		ftpBaseFile.setName(ftpFile.getName().substring(0, ftpFile.getName().lastIndexOf(".")));
		// 文件路径
		ftpBaseFile.setPath(filePath);
		// 上传时间
		ftpBaseFile.setUploadTime(ftpFile.getTimestamp().getTime());
		// 扩展名
		ftpBaseFile.setExtension(ftpFile.getName().substring(ftpFile.getName().lastIndexOf(".")));
		return ftpBaseFile;
	}
	
	//列出指定扩展名指定目录的所有的文件（含子目录）
	public List<FtpBaseFile> listAll(String path,String ext) throws IOException{
		// 1.登录FTP服务器
		if (!login(this.host, this.port, this.userName, this.password)) {
			logger.info("FTPServer登录不成功");
			return null;
		}
		// 2.list()
		this.list(path,ext);
		// 3.关闭FTP服务器
		this.disConnection();
		return this.ftpBaseFiles;
	}
	
	//列出指定目录的所有的文件（含子目录）
	public List<FtpBaseFile> listAll() throws IOException{
		return listAll("/", "*");
	}

}
