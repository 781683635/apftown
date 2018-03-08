package com.apft.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;


public class JavaMail {
    /**
     * Message对象将存储我们实际发送的电子邮件信息，
     * Message对象被作为一个MimeMessage对象来创建并且需要知道应当选择哪一个JavaMail session。
     */
    private MimeMessage message;
    
    /**
     * Session类代表JavaMail中的一个邮件会话。
     * 每一个基于JavaMail的应用程序至少有一个Session（可以有任意多的Session）。
     * 
     * JavaMail需要Properties来创建一个session对象。
     * 寻找"mail.smtp.host"    属性值就是发送邮件的主机
     * 寻找"mail.smtp.auth"    身份验证，目前免费邮件服务器都需要这一项
     */
    private Session session;
    
    /***
     * 邮件是既可以被发送也可以被受到。JavaMail使用了两个不同的类来完成这两个功能：Transport 和 Store。 
     * Transport 是用来发送信息的，而Store用来收信。对于这的教程我们只需要用到Transport对象。
     */
    private Transport transport;
    
    private String mailHost="imap.exmail.qq.com";
    private String sender_username="service@apftown.com";
    private String sender_password="Apftown8382";

    
    private Properties properties = new Properties();
    /*
     * 初始化方法
     */
    public JavaMail(boolean debug) {

//    		Properties prop = new Properties();
    		// 读取配置文件目录对应的是src下面的路径 而且，/uploadpath.properties中的/符号不能少
    		InputStream in = this.getClass().getResourceAsStream("/MailServer.properties");
    			//UserCookieUtil.class.getResourceAsStream("/MailServer.properties");
    		try {
    			if (in == null){
    				System.out.println("读取用户session的配置文件错误！使用默认值");
		
    			}
    			else {
    				properties.load(in);
    				mailHost = properties.getProperty("mailHost");
    				sender_username = properties.getProperty("sender_username");
    				sender_password = properties.getProperty("sender_password");				
    			}
    		} catch (IOException e) {
    			e.printStackTrace();
    		}

    	
    	
//        InputStream in = JavaMail.class.getResourceAsStream("MailServer.properties");
//        try {
//            properties.load(in);
//            this.mailHost = properties.getProperty("mail.smtp.host");
//            this.sender_username = properties.getProperty("mail.sender.username");
//            this.sender_password = properties.getProperty("mail.sender.password");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        
        session = Session.getInstance(properties);
        session.setDebug(debug);//开启后有调试信息
        message = new MimeMessage(session);
    }

    /**
     * 发送邮件
     * 
     * @param subject
     *            邮件主题
     * @param sendHtml
     *            邮件内容
     * @param receiveUser
     *            收件人地址
     */
    public void doSendHtmlEmail(String sender,  String subject, String sendHtml,
            String receiveUser) {
        try {
            // 发件人
            //InternetAddress from = new InternetAddress(sender_username);
            // 下面这个是设置发送人的Nick name
            InternetAddress from = new InternetAddress(MimeUtility.encodeWord(sender)+" <"+sender_username+">");
            message.setFrom(from);
            
            // 收件人
            InternetAddress to = new InternetAddress(receiveUser);
            message.setRecipient(Message.RecipientType.TO, to);//还可以有CC、BCC
            
            // 邮件主题
            message.setSubject(subject);
            
            String content = sendHtml.toString();
            // 邮件内容,也可以使纯文本"text/plain"
            message.setContent(content, "text/html;charset=UTF-8");
            
            // 保存邮件
            message.saveChanges();
            
            transport = session.getTransport("smtp");
            // smtp验证，就是你用来发邮件的邮箱用户名密码
            transport.connect(mailHost, sender_username, sender_password);
            // 发送
            transport.sendMessage(message, message.getAllRecipients());
            
            transport.close();
            
            System.out.println("send success!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(transport!=null){
                try {
                    transport.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        JavaMail se = new JavaMail(false);
        
        
        String mailContent = "<div class=\"txt\"><div style=\"font-size:14px;font-family:Verdana,&quot;宋体&quot;,Helvetica,sans-serif;line-height:1.66;padding:8px 10px;margin:0;overflow:auto\">"
        		+ "<p style=\"margin-left:30px\">亲爱的矿业圈用户：</p>"
        		+ "<p style=\"margin-left:30px\">您的用户名是：<span style=\"font-size:16px; color:#ff0000; font-weight: bold; font-family:Arial, Helvetica, sans-serif\">MiningCircle</span></p>"
        		+ "<p style=\"margin-left:30px\">请点击下面链接，完成您的邮箱验证：<br></p>"
        		+ "<div style=\"font-size:16px; color:#0000CC; margin-left:30px; font-family:Arial, Helvetica, sans-serif\"><a target=\"_blank\" href=\"http://passport.miningcirlce.com/identity/emailSubmit.do?ue=test%40qlfg.com&amp;un=test&amp;ui=91507351&amp;token=2ad3343f126790ede3ae09ea1ca6f32f\" _act=\"check_domail\">http://passport.miningcirlce.com/identity/emailSubmit.do?ue=2winner%40sina.com&amp;un=2winner&amp;ui=91507351&amp;token=2ad3343f126790ede3ae09ea1ca6f32f</a></div><p>"
        		+ "</p><div style=\"font-size:12px; margin-left:30px; color:#555555\">此信是由矿业圈系统发出，系统不接受回信，请勿直接回复。<br>如有任何疑问，请联系我们<a target=\"_blank\" href=\"http://miningcirlce.com\" _act=\"check_domail\">miningcirlce.com</a>。</div>"
        		+ "<p></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;致<br>  礼！</p><p style=\"margin-left:250px\">矿业圈--财富的圈子<br>www.miningcirlce.com</p></div></div>"
;        
//        se.doSendHtmlEmail("邮件主题", mailContent, "491566069@qq.com");
        se.doSendHtmlEmail("矿业圈","矿业圈通知TEST", mailContent, "czl@qlfg.com");
    }
}

