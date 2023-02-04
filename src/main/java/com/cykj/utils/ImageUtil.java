package com.cykj.utils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


public class ImageUtil {

	private ImageUtil() {
	}

	/*
	 * 随机字符字典
	 */
	private static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	/*
	 * 随机数
	 */
	private static Random random = new Random();

	/*
	 * 获取4位随机数
	 */
	private static String getRandomString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
	}

	/*
	 * 获取随机数颜色
	 */
	private static Color getRandomColor() {
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}

	/*
	 * 返回某颜色的反色
	 */
	private static Color getReverseColor(Color c) {
		return new Color(255 - c.getRed(), 255 - c.getGreen(), 255-c.getBlue());
	}

	public static void writeCheckCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.setContentType("image/jpeg");
		//生成验证码
		String randomString = getRandomString();
		//保存到session中
		request.getSession(true).setAttribute("codeString", randomString);

		//生成验证码图片的方法
		//图片的宽高
		int width = 100;
		int height = 30;
		//图片的颜色
		Color color = getRandomColor();
		Color reverse = getReverseColor(color);
		//图片流
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//画笔
		Graphics2D g = bi.createGraphics();
		//设置字体
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		//设置颜色
		g.setColor(color);
		//画矩形
		g.fillRect(0, 0, width, height);
		//设置反向颜色
		g.setColor(reverse);
		//写字：随机字符
		g.drawString(randomString, 18, 20);
		//话100个随机点
		for (int i = 0, n = random.nextInt(100); i < n; i++) {
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}
		//通过应答输出到前端
		response.setContentType("image/jpeg");
		// 转成JPEG格式
		ServletOutputStream out = response.getOutputStream();
//		int len =0;
//		byte[] buffer=new byte[1024];

		ImageIO.write(bi,"JPEG", out);

		out.flush();
	}
}
