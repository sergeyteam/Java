package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FilenameUtils;

import crudImplementOperations.CrudImplementWaterPump;

/**
 * Servlet implementation class UploadImage
 */
// @WebServlet("/API/UploadImage")
public class UploadImageController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private CrudImplementWaterPump crud = new CrudImplementWaterPump();
	private List<String> allURLs = crud.getAllImagesURL();
	public static final String RELATIVE_WEB_PATH = "/static/images/staticImages/";
	
	
	public UploadImageController() {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		upload(request, response);
		collectTrashInStaticImages(request, response);
	}

	private void collectTrashInStaticImages(HttpServletRequest request, HttpServletResponse response) {
		/*
//		System.out.println(allURLs.toString()); // база работает!
 * */

		String absoluteFilePath = getServletContext().getRealPath(RELATIVE_WEB_PATH);
		File fileDirection = new File(absoluteFilePath); // если этот путь где-то
														// не будет срабатывать,
														// его можно укоротить
														// по /LP.. методом
														// substring();
														
		
		if (fileDirection.isDirectory()) {
			File[] garbagefiles = fileDirection.listFiles();
			System.out.println("ФАЙЛЫ на мусор:    " + Arrays.toString(garbagefiles));
			for (int j = 0; j < garbagefiles.length; j++) {
				for (int i = 0; i < allURLs.size(); i++) {
					Pattern pat = Pattern.compile(allURLs.get(i));
					
					Matcher m = pat.matcher(garbagefiles[j].getName().toString());
					if (m.find()) {
						System.out.println(garbagefiles[j].getName());
					}
//					if ((RELATIVE_WEB_PATH + garbagefiles[j].getName().toString()) != allURLs.get(i).toString()) {
//						System.out.println("заходит");
//						System.out.println(RELATIVE_WEB_PATH + garbagefiles[j].getName());
//					}
				}
			}
		}
	}

	private void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String contextPath = request.getContextPath();               // это для проверки
		System.out.println("getContextPath:    " + contextPath);     // и это для проверки

		String absoluteFilePath = getServletContext().getRealPath(RELATIVE_WEB_PATH); 
		File fDirection = new File(absoluteFilePath); // если этот путь где-то не будет срабатывать, его можно укоротить по /LP.. методом substring();
		
		/*
//		System.out.println("ABSOLUTEfilePath :  " + fDirection.toString());
		*/
		if (!ServletFileUpload.isMultipartContent(request)) {
			System.out.println("nothing to upload");
			return;
		}

		FileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(itemFactory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {

				String contentType = item.getContentType();
//				String contType = getServletContext().getMimeType(file);

				if (contentType.equals("image/png")) {
					File file = File.createTempFile("img", ".png", fDirection);
					item.write(file);
					out.println("File saved successfully");
				}

				if (contentType.equals("image/jpeg")) {
					File file = File.createTempFile("img", ".jpg", fDirection);
					item.write(file);
					out.println("File saved successfully");
				}
			}
		} catch (FileUploadException f) {
			out.println("upload fail");
		} catch (Exception e) {
			out.println("can't save");
		}
	}
	
	
	
	
	
//	System.out.println("~~~~~~~~~~~~~~~~~~~~ Что такое getRealPath() и getContextPath()~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//	ServletContext context = request.getServletContext();
//	System.out.println("сравнение способов получения путей в веб приолжении");
	/*  passing the "/" to getRealPath() would return you the 
	 	absolute disk file system path of the /web folder of the expanded WAR file of the project. 
	 */
//	String path = context.getRealPath("/");
//	System.out.println("context.getRealPath('/'):                    " + path);
//	System.out.println();
	/*
	 * Note that most starters don't seem to see/realize that you can actually pass the whole web content path to it 
	 * and that they often use 
	   String absolutePathToIndexJSP = servletContext.getRealPath("/") + "index.jsp";
	 * instead of
	   String absolutePathToIndexJSP = servletContext.getRealPath("/index.jsp");
	 */
//	System.out.println("context.getRealPath('/') + 'index.jsp' :     " + path + "index.jsp");
//	System.out.println();
//
//	System.out.println("context.getRealPath('index.jsp')  :          " + context.getRealPath("/index.jsp"));
//	System.out.println();

	/*
	 * all changes (e.g. new files or edited files) will get lost whenever the WAR is redeployed; 
	 * with the simple reason that all those changes are not contained in the original WAR file. 
	 * So all starters who are attempting to save uploaded files in there are doing it wrong.
	 */
	
	/*
	 * better use ServletContext#getResourceAsStream() instead, this will work regardless of the way how the WAR is expanded. 
	 * So, if you for example want an InputStream of index.jsp do: InputStream input = servletContext.getResourceAsStream("/index.jsp");
	 
	 * Or if you intend to obtain a list of all available web resource paths, use ServletContext#getResourcePaths() instead.
	   Set<String> resourcePaths = servletContext.getResourcePaths("/");
	 * You can obtain an individual resource as URL via ServletContext#getResource().
	   URL resource = servletContext.getResource(path);
	 */
//	System.out.println("getResourceAsStream:   " + context.getResourceAsStream("/index.jsp"));
//	System.out.println();
//
//	System.out.println("context path :   " + context.getContextPath());
	
	
	/*ЁЩЁ
	 * String requestURI = request.getRequestURI();
		System.out.println("getRequestURI() " + requestURI);
		
		String path2 = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("substring URI: " + path2);*/

}
