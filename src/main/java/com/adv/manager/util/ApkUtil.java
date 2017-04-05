package com.adv.manager.util;
/*package com.hatchbeen.adv.ddl.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.omg.CORBA.portable.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xmlpull.v1.XmlPullParser;

import android.content.res.AXmlResourceParser;
import android.util.TypedValue;


public class ApkUtil
{
	*//**
	 * 日志对象
	 *//*
	private static Logger	    log	              = LoggerFactory.getLogger(ApkUtil.class);
	
	private static final float	RADIX_MULTS[]	  = { 0.00390625F, 3.051758E-005F, 1.192093E-007F, 4.656613E-010F };
	
	private static final String	DIMENSION_UNITS[]	= { "px", "dip", "sp", "pt", "in", "mm", "", "" };
	
	private static final String	FRACTION_UNITS[]	= { "%", "%p", "", "", "", "", "", "" };
	
	*//**
	 * 获取apk信息
	 * 
	 * @param apkPath
	 * @return
	 *//*
	public static String[] getApkInfo(String uZipPath,String apkName)
	{
		// apk信息的返回结果
		final String[] apkResult = new String[3];
		ZipFile zipFile = null;
		try
		{
			final String apkPath = uZipPath +File.separator+ apkName;
			// 获得一个解压文件对象
			zipFile = new ZipFile(apkPath);
			// 将解压文件对象转列举对象
			final Enumeration enumeration = zipFile.entries();
			ZipEntry zipEntry = null;
			// 遍历列举对象元素
			while (enumeration.hasMoreElements())
			{
				// 获得一个解压条目对象
				zipEntry = (ZipEntry) enumeration.nextElement();
				if (zipEntry.isDirectory())
				{
					
				}
				else
				{
					// 获得名为AndroidManifest.xml的文件
					if ("AndroidManifest.xml".equals(zipEntry.getName()))
					{
						try
						{
							final AXmlResourceParser parser = new AXmlResourceParser();
							parser.open(zipFile.getInputStream(zipEntry));
							// 遍历文件里的内容
							while (true)
							{
								final int type = parser.next();
								if (type == XmlPullParser.END_DOCUMENT)
								{
									break;
								}
								switch (type)
								{
								// 满足条件开始遍历内容提取需要的信息
									case XmlPullParser.START_TAG: {
										for (int i = 0; i != parser.getAttributeCount(); ++i)
										{
											if ("package".equals(parser.getAttributeName(i)))
											{
												apkResult[0] = ApkUtil.getAttributeValue(parser, i);
											}
											else if ("versionCode".equals(parser.getAttributeName(i)))
											{
												apkResult[1] = ApkUtil.getAttributeValue(parser, i);
											}
											else if ("versionName".equals(parser.getAttributeName(i)))
											{
												apkResult[2] = ApkUtil.getAttributeValue(parser, i);
											}
											
										}
									}
								}
							}
						}
						catch (final Exception e)
						{
							ApkUtil.log.error("get file fail...！", e);
						}
					}
					
				}
			}
		}
		catch (final IOException e)
		{
			ApkUtil.log.error("analyzing fail...", e);
		}
		finally
		{
			if (zipFile != null)
			{
				try
				{
					zipFile.close();
				}
				catch (final IOException e)
				{
					ApkUtil.log.error("Zipfile close fail.", e);
				}
			}
		}
		
		return apkResult;
	}
	
	private static String getAttributeValue(AXmlResourceParser parser, int index)
	{
		final int type = parser.getAttributeValueType(index);
		final int data = parser.getAttributeValueData(index);
		if (type == TypedValue.TYPE_STRING)
		{
			return parser.getAttributeValue(index);
		}
		if (type == TypedValue.TYPE_ATTRIBUTE)
		{
			return String.format("?%s%08X", ApkUtil.getPackage(data), data);
		}
		if (type == TypedValue.TYPE_REFERENCE)
		{
			return String.format("@%s%08X", ApkUtil.getPackage(data), data);
		}
		if (type == TypedValue.TYPE_FLOAT)
		{
			return String.valueOf(Float.intBitsToFloat(data));
		}
		if (type == TypedValue.TYPE_INT_HEX)
		{
			return String.format("0x%08X", data);
		}
		if (type == TypedValue.TYPE_INT_BOOLEAN)
		{
			return data != 0 ? "true" : "false";
		}
		if (type == TypedValue.TYPE_DIMENSION)
		{
			return Float.toString(ApkUtil.complexToFloat(data))
			        + ApkUtil.DIMENSION_UNITS[data & TypedValue.COMPLEX_UNIT_MASK];
		}
		if (type == TypedValue.TYPE_FRACTION)
		{
			return Float.toString(ApkUtil.complexToFloat(data))
			        + ApkUtil.FRACTION_UNITS[data & TypedValue.COMPLEX_UNIT_MASK];
		}
		if (type >= TypedValue.TYPE_FIRST_COLOR_INT && type <= TypedValue.TYPE_LAST_COLOR_INT)
		{
			return String.format("#%08X", data);
		}
		if (type >= TypedValue.TYPE_FIRST_INT && type <= TypedValue.TYPE_LAST_INT)
		{
			return String.valueOf(data);
		}
		return String.format("<0x%X, type 0x%02X>", data, type);
	}
	
	private static String getPackage(int id)
	{
		if (id >>> 24 == 1)
		{
			return "android:";
		}
		return "";
	}
	
	public static float complexToFloat(int complex)
	{
		return (complex & 0xFFFFFF00) * ApkUtil.RADIX_MULTS[complex >> 4 & 3];
	}
	
	
	
	*//**
	 * 抽取apk程序的应用图标
	 * @param apkPath apk的路径名
	 * @param aaptPath aapt工具的全路径名
	 * @param outDir 图标的输出路径
	 *//*
	public static void getApkIcon(String apkPath, String aaptPath, String outDir){
		String iconName = getIconName(apkPath, aaptPath);
		File iconOutDir = new File(outDir);
		if(!iconOutDir.exists()){
			iconOutDir.mkdirs();
		}
		getIcon(apkPath, iconName, outDir + iconName);
	}
	
	*//**
	 * 获取图标的名字
	 *//*
	private static String getIconName(String apkPath, String aaptPath) {
		String iconName = "";
		try {
			*//**
			 * Runtime类封装了运行时的环境。每个Java应用程序都有一个Runtime 类实例，使应用程序能够与其运行的环境相连接。
             * 一般不能实例化一个Runtime对象，应用程序也不能创建自己的Runtime类实例，但可以通过getRuntime方法获取当前Runtime运行时对象的引用。
			 *//*
			Runtime rt = Runtime.getRuntime();
			String order = aaptPath + "aapt.exe" + " d badging \"" + apkPath + "\"";
			Process proc = rt.exec(order);
			InputStream inputStream = proc.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
			String line = null;
			while((line = bufferedReader.readLine()) != null){
				if(line.contains("application:")){//application: label='UC浏览器' icon='res/drawable-hdpi/icon.png'
					iconName = line.substring(line.lastIndexOf("/") + 1, line.lastIndexOf("'")).trim().toLowerCase();
					break;
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return iconName;
	}

	*//**
	 * 抽取图标
	 *//*
	private static void getIcon(String apkPath, String iconName, String outPath) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		ZipInputStream zis = null;
		File apkFile = new File(apkPath);
		try {
			fis = new FileInputStream(apkFile);
			zis = new ZipInputStream(fis);
			ZipEntry zipEntry = null;
			while((zipEntry = zis.getNextEntry()) != null){
				String name = zipEntry.getName().toLowerCase();
				if((name.endsWith("/" + iconName) && name.contains("drawable") && name.contains("res")) || 
						(name.endsWith("/" + iconName) && name.contains("raw") && name.contains("res"))){
					fos = new FileOutputStream(new File(outPath));
					byte[] buffer = new byte[1024];
					int n = 0;
					while((n = zis.read(buffer, 0, buffer.length)) != -1){
						fos.write(buffer, 0, n);
					}
					break;
				}
			}
			fos = null;
			zis.closeEntry();
			zipEntry = null;
			System.out.println("图标抽取成功"+outPath);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (zis != null) {
					zis.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
*/