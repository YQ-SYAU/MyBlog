package com.syau.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendMailUtil1 {
		public static void Send(String randNum,String u_qq) throws MessagingException
		{
			  Properties properties = new Properties();

			  properties.put("mail.transport.protocol", "smtp");// 连接协议        

			  properties.put("mail.smtp.host", "smtp.qq.com");// 主机名        

			  properties.put("mail.smtp.port", "465");// 端口号        

			  properties.put("mail.smtp.auth", "true");        

			  properties.put("mail.smtp.ssl.enable", "true");//设置是否使用ssl安全连接  ---一般都使用        

			  properties.put("mail.debug", "true");//设置是否显示debug信息  true 会在控制台显示相关信息        

			//得到回话对象        

			Session session = Session.getInstance(properties);        

			// 获取邮件对象        

			Message message = new MimeMessage(session);        

			//设置发件人邮箱地址       

			 message.setFrom(new InternetAddress("285038165@qq.com"));

			 //设置收件人地址      
			 String a=u_qq+"@qq.com";
			 message.setRecipients(RecipientType.TO,new InternetAddress[] { new InternetAddress(a) });       

			 //设置邮件标题        

			message.setSubject("注册码");

			//设置邮件内容        
			String b="您好，您正在注册精英博客账户，您的验证码为："+randNum+" 请不要告诉别人哦";
			message.setText(b);       

			 //得到邮差对象        

			Transport transport = session.getTransport();        

			//连接自己的邮箱账户        

			transport.connect("285038165@qq.com", "gsehjiymtzjmcacc");//密码为刚才得到的授权码

			//发送邮件       
			transport.sendMessage(message, message.getAllRecipients());
		}

	}

