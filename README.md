### File Uploading using <u>Standard</u>ServletMultipartResolver, configured with <u>web.xml</u>

#### Notable configuration files:

- ~~spittr.config.SpittrWebAppInitializer~~
- /main/webapp/WEB-INF/web.xml
  - sets the location of temp upload folder to *D:/d/data/temp/upload*
- spittr.config.WebConfig
  - ~~registers multipartResolver bean~~
  - **javax.servlet.http.Part** is used in place of MultipartResolver, so no need to register the bean

#### Other significant files

- /main/webapp/WEB-INF/views/registerForm.jsp
  - form enctype attribute
  - file input
- spittr.web.FileUploadController

This project only works on Servlet 3.0 supported servers because only Servlet 3.0 webapp xsd's <servlet> tags contain <multipart-config> tags. Or just that StandardServletMultipartResolver is supported after Servlet 3.0

<u>profilePicture.getSubmittedFileName() doesn't seem to work</u>, it seems to be for the reason that it is Servlet 3.1 only and I used it on a Servlet 3.0 container. 

### Steps

1. project

   1. ensure that you have 3.1 servlet and dependency 

2. web.xml

   add configuration for multipart in <servlet>

   ```xml
   	<servlet>
   		<servlet-name>kkz-manager</servlet-name>
   		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
   		<init-param>
   			<param-name>contextConfigLocation</param-name>
   			<param-value>classpath:spring/springmvc.xml</param-value>
   		</init-param>
   		<load-on-startup>1</load-on-startup>
   		<multipart-config>
                <!-- or C:/temp/upload -->
   			<location>/temp/upload</location>
             	 <!-- max file size in bytes -->
   			<max-file-size>2097152</max-file-size>
                <!-- max request size in bytes -->
   			<max-request-size>4194304</max-request-size>
   			<file-size-threshold>0</file-size-threshold>
   		</multipart-config>
   	</servlet>
   ```

   ​

3. form

   1. submit as post
   2. enctype is `multipart/form-data`
   3. has one or more `<input type="file">` tags

4. Controller

   1. accept the file with method parameter `@RequestPart("form_filed_name") Part local_method_variable_name`

5. use `local_method_variable_name.write(file_path)`, to move it

   1. if file_path is relative, the file will be written relative to the temporary upload location