
package com.apft.mvc.servlet;


import java.awt.Color;  
import java.awt.Font;  
import java.awt.Graphics;  
import java.awt.image.BufferedImage;  
import java.io.ByteArrayOutputStream;  
import java.io.IOException;  
import java.util.Random;
  
import javax.imageio.ImageIO;  
import javax.servlet.ServletException;  
import javax.servlet.ServletOutputStream;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  


  
public class RandCodeImageServlet extends HttpServlet {  
    public static final String SESSION_KEY_OF_RAND_CODE = "randCode"; // todo 要统一常量

	
//	private static int WIDTH = 90;  //6
	private static int WIDTH = 60;  //6
    private static int HEIGHT = 20;  
    private static int LENGTH = 4;  
  
    @Override  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
         HttpSession session = request.getSession();  
  
         response.setContentType("image/jpeg");  
  
         ServletOutputStream sos = response.getOutputStream();  
  
         //设置浏览器不要缓存此图片  
         response.setHeader("Pragma","No-cache");  
         response.setHeader("Cache-Control","no-cache");  
         response.setDateHeader("Expires", 0);  
  
         //创建内存图象并获得其图形上下文  
         BufferedImage image =   
                new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);   
  
         Graphics g = image.getGraphics();  
  
         //产生随机的认证码  
         char [] rands = generateCheckCode();  
  
         //产生图像  
         drawBackground(g);  
  
         drawRands(g,rands);  
  
         //结束图像的绘制过程，完成图像  
         g.dispose();  
  
         //将图像输出到客户端  
         ByteArrayOutputStream bos = new ByteArrayOutputStream();  
  
         ImageIO.write(image, "JPEG", bos);  
  
         byte [] buf = bos.toByteArray();  
  
         response.setContentLength(buf.length);  
  
         //下面的语句也可写成：bos.writeTo(sos);  
         sos.write(buf);  
         bos.close();  
         sos.close();  
  
         //将当前验证码存入到Session或者数据库中,下一个表单处理中验证客户端提交的验证码是否正确  
         session.setAttribute(SESSION_KEY_OF_RAND_CODE,new String(rands));  
    }  
  
    private static char [] generateCheckCode()  
    {  
       //定义验证码的字符表  
//        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";  
        String chars = "0123456789";  
  
       char [] rands = new char[LENGTH];  
       for(int i=0; i<LENGTH; i++)  
  
       {  
//           int rand = (int)(Math.random() * 36);  
           int rand = (int)(Math.random() * 10);  
          rands[i] = chars.charAt(rand);  
       }  
  
       return rands;  
    }  
      
       private void drawRands(Graphics g , char [] rands)   
       {  
    	   Color c;
    	   int ii;
    	   Random rand =new Random((int)System.currentTimeMillis());
    	   ii = (int)rand.nextInt();
    	   
    	   c = new Color(ii&0x7f, 0x7f&(ii>>8), 0x7f&(ii>>16));
    	   
//    	   g.setFont(new Font(null,Font.ITALIC|Font.BOLD,18));  
    	   g.setFont(new Font("Times New Roman", Font.BOLD, 24));
    	   
    	   g.setColor(c);
  
          //在不同的高度上输出验证码的每个字符           

			g.drawString("" + rands[0], 1, 17);
			ii = (int) rand.nextInt();
			c = new Color(ii & 0x7f, 0x7f & (ii >> 8), 0x7f & (ii >> 16));
			g.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));
			g.setColor(c);
			g.drawString("" + rands[1], 16, 15);
			ii = (int) rand.nextInt();
			c = new Color(ii & 0x7f, 0x7f & (ii >> 8), 0x7f & (ii >> 16));
			g.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));
			g.setColor(c);
			g.drawString("" + rands[2], 31, 18);
			ii = (int) rand.nextInt();
			c = new Color(ii & 0x7f, 0x7f & (ii >> 8), 0x7f & (ii >> 16));
			g.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));
			g.setColor(c);
			g.drawString("" + rands[3], 46, 16);

//          g.drawString("" + rands[4],61,14);  
//          g.drawString("" + rands[5],76,19);  
  
       }  
  
       private void drawBackground(Graphics g)  
  
       {  
           //画背景  
          g.setColor(new Color(0xDCDCDC));  
          g.fillRect(0, 0, WIDTH, HEIGHT);  
  
          //随机产生120个干扰点  
          for(int i=0; i<120; i++)  
  
          {  
             int x = (int)(Math.random() * WIDTH);  
  
             int y = (int)(Math.random() * HEIGHT);  
  
             int red = (int)(Math.random() * 255);  
  
             int green = (int)(Math.random() * 255);  
  
             int blue = (int)(Math.random() * 255);  
  
             g.setColor(new Color(red,green,blue));          
  
             g.drawOval(x,y,1,0);  
  
          }  
            
          Random rand =new Random((int)System.currentTimeMillis());
          int ii = (int)rand.nextInt()&0xfffffff;
          //加两条干扰线  
          g.drawLine(0, 5+(ii%10), 90, 5-(ii%11));  
          g.drawLine(0, 15-(ii%9), 90, 15+(ii%8));  
  
       }  
  
       public static void main(String args[]) {  
           char[] chars = generateCheckCode();  
  
       }  
}  