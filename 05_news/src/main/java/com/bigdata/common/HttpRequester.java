package com.bigdata.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Vector;

/**
 * HTTP请求对象
 */
public class HttpRequester {
	/**
	 ** 默认字符编码
	 */
	private String defaultContentEncoding;
	
	/**
	 * 字符流编码
	 */
	private String charStreamEncoding;

	public String getCharStreamEncoding() {
		return charStreamEncoding;
	}

	public void setCharStreamEncoding(String charStreamEncoding) {
		this.charStreamEncoding = charStreamEncoding;
	}

	public HttpRequester() {
		// 得到系统默认的字符编码
		this.defaultContentEncoding = Charset.defaultCharset().name();
	}

	/**
	 * 发送GET请求
	 * 
	 * @param urlString URL地址
	 * @return 响应对象
	 * @throws java.io.IOException
	 */
	public HttpResponser sendGet(String urlString, boolean isContent) throws IOException {
		return this.send(urlString, "GET", null, null, isContent);
	}

	/**
	 * 发送GET请求
	 * @param urlString URL地址
	 * @param params 参数集合
	 * @return 响应对象
	 * @throws java.io.IOException
	 */
	public HttpResponser sendGet(String urlString, Map<String, String> params, boolean isContent) throws IOException {
		return this.send(urlString, "GET", params, null, isContent);
	}

	/**
	 * 发送GET请求
	 * @param urlString URL地址
	 * @param params 参数集合
	 * @param propertys 请求属性
	 * @return 响应对象
	 * @throws java.io.IOException
	 */
	public HttpResponser sendGet(String urlString, Map<String, String> params, Map<String, String> propertys, boolean isContent) throws IOException {
		return this.send(urlString, "GET", params, propertys, isContent);
	}

	/**
	 * 发送POST请求
	 * @param urlString URL地址
	 * @return 响应对象
	 * @throws java.io.IOException
	 */
	public HttpResponser sendPost(String urlString, boolean isContent) throws IOException {
		return this.send(urlString, "POST", null, null, isContent);
	}

	/**
	 * 发送POST请求
	 * @param urlString URL地址
	 * @param params 参数集合
	 * @return 响应对象
	 * @throws java.io.IOException
	 */
	public HttpResponser sendPost(String urlString, Map<String, String> params, boolean isContent) throws IOException {
		return this.send(urlString, "POST", params, null, isContent);
	}

	/**
	 * 发送POST请求
	 * @param urlString URL地址
	 * @param params 参数集合
	 * @param propertys 请求属性
	 * @return 响应对象
	 * @throws java.io.IOException
	 */
	public HttpResponser sendPost(String urlString, Map<String, String> params, Map<String, String> propertys, boolean isContent) throws IOException {
		return this.send(urlString, "POST", params, propertys, isContent);
	}

	/**
	 * 发送HTTP请求
	 * @param urlString
	 * @return 响映对象
	 * @throws java.io.IOException
	 */
	private HttpResponser send(String urlString, String method, Map<String, String> parameters, Map<String, String> propertys, boolean isContent)
		throws IOException {
		// HttpURLConnection为局部变量
		HttpURLConnection urlConnection = null;
		// URL对象
		URL url = null;
		// 如果请求为GET方法，并且参数不为空
		if (method.equalsIgnoreCase("GET") && parameters != null) {
			// 构建并拼接参数字符串
			StringBuffer param = new StringBuffer();
			int i = 0;
			for (String key : parameters.keySet()) {
				if (i == 0) {
					param.append("?");
				} else {
					param.append("&");
				}
				param.append(key).append("=").append(parameters.get(key));
				i++;
			}
			// 拼接URL串 + 参数
			urlString += param;
		}
		// NEW一个URL对象，由该对象的openConnection()方法将生成一个URLConnection对象
		url = new URL(urlString);
		urlConnection = (HttpURLConnection) url.openConnection();

		// 设置相关属性，具体含义请查阅JDK文档
		urlConnection.setRequestMethod(method);
		urlConnection.setDoOutput(true);
		urlConnection.setDoInput(true);
		urlConnection.setUseCaches(false);

		// 赋予请求属性
		if (propertys != null) {
			for (String key : propertys.keySet()) {
				urlConnection.addRequestProperty(key, propertys.get(key));
			}
		}

		// 如果请求为POST方法，并且参数不为空
		if (method.equalsIgnoreCase("POST") && parameters != null) {
			StringBuffer param = new StringBuffer();
			for (String key : parameters.keySet()) {
				param.append("&");
				param.append(key).append("=").append(parameters.get(key));
			}
			// 将参数信息发送到HTTP服务器
			// 要注意：一旦使用了urlConnection.getOutputStream().write()方法，urlConnection.setRequestMethod("GET");将失效，其请求方法会自动转为POST
			urlConnection.getOutputStream().write(param.toString().getBytes());
			urlConnection.getOutputStream().flush();
			urlConnection.getOutputStream().close();
		}
		return this.makeContent(urlString, urlConnection, isContent);
	}

	/**
	 * 得到响应对象
	 * @param urlConnection
	 * @return 响应对象
	 * @throws java.io.IOException
	 */
	private HttpResponser makeContent(String urlString, HttpURLConnection urlConnection, boolean isContent) throws IOException {
		HttpResponser httpResponser = new HttpResponser();
		try {
			StringBuffer temp = new StringBuffer();
			if (isContent) {
				// 得到响应流
				InputStream in = urlConnection.getInputStream();
				// 封装成高级对象
				BufferedReader bufferedReader = null;
				if (this.getCharStreamEncoding() == null) {
					bufferedReader = new BufferedReader(new InputStreamReader(in));
				} else {
					bufferedReader = new BufferedReader(new InputStreamReader(in, this.getCharStreamEncoding()));
				}
				// 内容集合(集合项为行内容)
				httpResponser.setContentCollection(new Vector<String>());
				String line = bufferedReader.readLine();
				while (line != null) {
					httpResponser.getContentCollection().add(line);
					temp.append(line).append("\r\n");
					line = bufferedReader.readLine();
				}
				bufferedReader.close();
			}

			// 得到请求连接的字符集
			String ecod = urlConnection.getContentEncoding();
			if (ecod == null) {
				ecod = this.defaultContentEncoding;
			}

			// 将各属性赋值给响应对象
			httpResponser.setUrlString(urlString);
			httpResponser.setDefaultPort(urlConnection.getURL().getDefaultPort());
			httpResponser.setFile(urlConnection.getURL().getFile());
			httpResponser.setHost(urlConnection.getURL().getHost());
			httpResponser.setPath(urlConnection.getURL().getPath());
			httpResponser.setPort(urlConnection.getURL().getPort());
			httpResponser.setProtocol(urlConnection.getURL().getProtocol());
			httpResponser.setQuery(urlConnection.getURL().getQuery());
			httpResponser.setRef(urlConnection.getURL().getRef());
			httpResponser.setUserInfo(urlConnection.getURL().getUserInfo());
			httpResponser.setContent(new String(temp.toString().getBytes(), ecod));
			httpResponser.setContentEncoding(ecod);
			httpResponser.setCode(urlConnection.getResponseCode());
			httpResponser.setMessage(urlConnection.getResponseMessage());
			httpResponser.setContentType(urlConnection.getContentType());
			httpResponser.setMethod(urlConnection.getRequestMethod());
			httpResponser.setConnectTimeout(urlConnection.getConnectTimeout());
			httpResponser.setReadTimeout(urlConnection.getReadTimeout());

			return httpResponser;
		} catch (IOException e) {
			throw e;
		} finally {
			// 最终关闭流
			if (urlConnection != null) {
				urlConnection.disconnect();
			}
		}
	}

	/**
	 * 默认的响应字符集
	 */
	public String getDefaultContentEncoding() {
		return this.defaultContentEncoding;
	}

	/**
	 * 设置默认的响应字符集
	 */
	public void setDefaultContentEncoding(String defaultContentEncoding) {
		this.defaultContentEncoding = defaultContentEncoding;
	}
}