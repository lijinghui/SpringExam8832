package com.hand.SpringExam8832;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Dao.filmDao;
import com.Dao.filmDaoImp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	 ((AbstractApplicationContext) context).start();
		filmDao filmImp = (filmDao) context.getBean("filmDaoImp");
		
		System.out.println("请输入电影名称(title)：");
		Scanner sc = new Scanner(System.in);
		String t = sc.next();
		System.out.println("请输入电影描述（description）：");
		String d = sc.next();
		System.out.println("请输入电影语言ID（language_id）：1.英语 2.意大利语 3.日语");
		int a = sc.nextInt();
		filmImp.saveFilm(t, d, a);
		((AbstractApplicationContext) context).stop();
    }
}
