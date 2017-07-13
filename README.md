### File Uploading using <u>Standard</u>ServletMultipartResolver, configured with <u>web.xml</u>

#### Significant configuration files:

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