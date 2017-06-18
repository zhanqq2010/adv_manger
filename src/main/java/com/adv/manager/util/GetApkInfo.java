package com.adv.manager.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.xmlpull.v1.XmlPullParser;

import android.content.res.AXmlResourceParser;
public class GetApkInfo {
	
	/**
	 * 将apk进行解压缩获取到AndroidManifest.xml文件
	 * @param path
	 * @param projectPath
	 * @return
	 */
	 public static File zip2file(String path,String projectPath) {
	        try {
	            ZipInputStream in = new ZipInputStream(new FileInputStream(path));
	            ZipEntry z = null;
	            File f = null;
	            while ((z = in.getNextEntry()) != null) {
	                if (!z.isDirectory()
	                        && z.getName().equals("AndroidManifest.xml")) {
	                    f = new File(projectPath+"/upload/apkXml/" + z.getName());
	                    OutputStream out = new FileOutputStream(f);
	                    int b;
	                    while ((b = in.read()) != -1) {
	                        out.write(b);
	                    }
	                    out.close();
	                    
	                }
	            }
	            in.close();
                return f;
	          

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return null;
	    }
	 
	 /**
	  * 获取apk包的版本号
	  * @param path
	  * @param projectPath
	  * @return
	  */
	 public static String getVersionCode(String path,String projectPath) {
		 System.out.println("path is "+path);
		 System.out.println("projectPath is "+projectPath);
	        try {
	            File androidManifest = GetApkInfo.zip2file(path,projectPath);
	            AXmlResourceParser parser = new AXmlResourceParser();
	            parser.open(new FileInputStream(androidManifest));
	            while (true) {
	                int type = parser.next();
	                if (type == XmlPullParser.END_DOCUMENT) {
	                    break;
	                }
	                switch (type) {
	                case XmlPullParser.START_TAG:
	                    for (int i = 0; i != parser.getAttributeCount(); ++i) {
	                        if (parser.getAttributeName(i).equals("versionCode")) {
	                            return parser.getAttributeValue(i);
	                        }
	                    }
	                    break;
	                }
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	 /**
	  * 获取apk包名
	  * @param path
	  * @param projectPath
	  * @return
	  */
	 public static String getPackage(String path,String projectPath) {
	        try {
	            File androidManifest = GetApkInfo.zip2file(path,projectPath);
	            AXmlResourceParser parser = new AXmlResourceParser();
	            parser.open(new FileInputStream(androidManifest));
	            while (true) {
	                int type = parser.next();
	                if (type == XmlPullParser.END_DOCUMENT) {
	                    break;
	                }
	                switch (type) {
	                case XmlPullParser.START_TAG:
	                    for (int i = 0; i != parser.getAttributeCount(); ++i) {
	                        if (parser.getAttributeName(i).equals("package")) {
	                            return parser.getAttributeValue(i);
	                        }
	                    }
	                    break;
	                }
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    } 
	 
	 /**
	  * apk文件重命名
	  * @param path
	  * @param oldname
	  * @param newname
	  * @return
	  */
	 public static int renameFile(String path,String oldname,String newname){
		 		//新的文件名和以前文件名不同时,才有必要进行重命名   
		 		
		 		try{
		 			
			 			File oldfile=new File(path+"/"+oldname); 
			 			 File newfile=new File(path+"/"+newname); 
			 			 
//			 			System.out.println("oldfile="+path+"/"+oldname);
//				        System.out.println("newfile="+path+"/"+newname);
				        
				        if(newfile.exists())//若在该目录下已经有一个文件和新文件名相同，则不允许重命名   
				        {
				        		return 5  ; 
				        
				        }
				        else{   
			               Boolean flag = oldfile.renameTo(newfile);  
			               System.out.println(flag);
			               if(flag){
			            	   return 6  ;
			               }else {
			            	   return 7  ; 
			               }
			              			                
			           }          
		 		}catch (Exception e) {
		 			 	return 7  ; 
				}
	           
	 	} 
	 	
	 /**
	  * 复制文件
	  * @param oldPath
	  * @param newPath
	  */
	 public  static void copyFile(String oldPath, String newPath) {
		
			try{
				int bytesum = 0;
				int byteread = 0;
				File oldFile = new File(oldPath);
				File uploadFilePath = new File("D:/upload/apk");
			    if(uploadFilePath.exists() == false){
			    	  uploadFilePath.mkdirs();
			    }
				
				if(oldFile.exists()){
					InputStream inputStream = new FileInputStream(oldPath);
					FileOutputStream outputStream = new FileOutputStream(newPath);
					byte[] buffer = new byte[1444];
					
					while((byteread = inputStream.read(buffer))!=-1){
						bytesum+=byteread;
						outputStream.write(buffer,0,byteread);
					}
					inputStream.close();
					outputStream.close();
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	 
	 /**
	  * 验证文件是否存在
	  * @param path
	  * @return
	  */
	 public static boolean isexists(String path){
		  File f  = new File(path);
		  if(f.exists())
		   return true;
		  else
		   return false;
		 }
	 
	 /**
	  * 删除apk
	  * @param oldPath
	  */
	 public static void delApk(String oldPath){
		 try{
				String filePath = oldPath;
				filePath = filePath.toString();
				java.io.File myDelFile = new java.io.File(filePath);
				myDelFile.delete();
				
			}catch (Exception e) {
				
			}
	 }
	 
	 /**
	  * 获取apk详细信息
	  * @param apkPath
	  * @return
	  */
	 public static Map<String, String> getApkInfo(String saveApkUrl, String apkPath, String saveIconUrl) {
		 Map<String, String> map = new HashMap<String, String>();
			Runtime rt = Runtime.getRuntime();
			StringBuffer buffer = new StringBuffer();
			//判断下操作系统类型
			String execName = "aapt";
			String osType = System.getProperty("os.name");
			if(osType.indexOf("win") >= 0 || osType.indexOf("Win") >= 0) {
				execName = "aapt.exe";
			}
			buffer.append(execName).append(" d badging ").append(saveApkUrl).append(apkPath).append("");
			String command = buffer.toString();
			System.out.println(command);
			try {
				Process pro = rt.exec(command);
				pro.getOutputStream().flush();
				InputStream is = pro.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String temp = null;
				while((temp = br.readLine()) != null) {
					if(temp.indexOf("package:") >= 0) {
						map.putAll(parsePackageInfo(temp));
						continue;
					}
					if(temp.indexOf("application-label") >= 0) {
						map.put("appCnName", temp.split(":")[1].replace("'", ""));
						continue;
					}
					if(temp.indexOf("application-label-zh_CN") >= 0) {
						map.put("appCnName", temp.split(":")[1].replace("'", ""));
						continue;
					}
					if(temp.indexOf("application:") >= 0 && temp.indexOf("icon") > 0) {
						map.putAll(getIconPath(temp));
						continue;
					}
				}
				br.close();
				isr.close();
				is.close();
				//获取icon文件
				String iconInnerPath = map.get("iconInnerPath");
				String iconPath = null;
				if(iconInnerPath != null && iconInnerPath.length() > 0) {
					iconPath = getPackageIcon(iconInnerPath, saveApkUrl + apkPath, saveIconUrl);
				}
				if(iconPath != null) {
					map.put("iconPath", iconPath);
				}
				pro.waitFor();
				pro.destroy();
//				System.out.println("apk解析结果：" + map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return map;
		 
	 }
			
	private static Map<String, String> parsePackageInfo(String src) {
		Map<String, String> result = new HashMap<String, String>();
		String[] temp = src.split(" ");
		for(String s : temp) {
			if(s.indexOf("=") > 0) {
				String[] inner = s.split("=");
				if("name".equals(inner[0])) {
					result.put("packageName", inner[1].replace("'", ""));
					continue;
				}
				if("versionCode".equals(inner[0])) {
					result.put("versionCode", inner[1].replace("'", ""));
					continue;
				}
				if("versionName".equals(inner[0])) {
					result.put("versionName", inner[1].replace("'", ""));
					continue;
				}
			}
		}
		return result;
	}
	
	private static Map<String, String> getIconPath(String src) {
		Map<String, String> result = new HashMap<String, String>();
		String[] temp = src.split(" ");
		for(String s : temp) {
			if(s.indexOf("=") > 0) {
				String[] inner = s.split("=");
				if("icon".equals(inner[0])) {
					result.put("iconInnerPath", inner[1].replace("'", ""));
					break;
				}
			}
		}
		return result;
	}
	
	private static String getPackageIcon(String iconInnerPath, String packagePath, String iconFolderPath) {
		String result = null;
		String suffix = iconInnerPath.substring(iconInnerPath.lastIndexOf("."));
		try {
			File apkFile = new File(packagePath);
			FileInputStream fis = new FileInputStream(apkFile);
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = null;
			while((ze = zis.getNextEntry()) != null) {
				String zeName = ze.getName();
				if(iconInnerPath.equals(zeName)) {
					byte[] buffer = new byte[1024];
					StringBuffer fileName = new StringBuffer(iconFolderPath);
					if(iconFolderPath.lastIndexOf(File.separator) != iconFolderPath.length() - 1) {
						fileName.append("/");
					}
					String lastFileName = null;
					if(packagePath != null && !packagePath.equals("")){
						lastFileName = packagePath.substring( packagePath.lastIndexOf(File.separator) + 1, packagePath.lastIndexOf(".")) + suffix;
					}else{
						lastFileName = System.currentTimeMillis() + suffix;
					}
					fileName.append(lastFileName);
					FileOutputStream fos = new FileOutputStream(new File(fileName.toString()));
					int n = 0;
					while((n = zis.read(buffer, 0, buffer.length)) != -1) {
						fos.write(buffer, 0, n);
					}
					fos.close();
					result = lastFileName;
//					result = "/upload/images/" + lastFileName;
					//result =  "http://127.0.0.1:8013/upload/images/" + lastFileName;
					break;
				}
			}
			zis.closeEntry();
			zis.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
