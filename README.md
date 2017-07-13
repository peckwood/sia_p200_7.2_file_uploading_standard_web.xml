### File Uploading using <u>Standard</u>ServletMultipartResolver, configured with <u>web.xml</u>

#### Significant configuration files:

- ~~spittr.config.SpittrWebAppInitializer~~
- /main/webapp/WEB-INF/web.xml
  - sets the location of temp upload folder to *D:/d/data/temp/upload*
- spittr.config.WebConfig
  - registers multipartResolver bean

#### Other significant files

- /main/webapp/WEB-INF/views/registerForm.jsp
  - form enctype attribute
  - file input
- spittr.web.FileUploadController

This project only works on Servlet 3.0 supported servers because only Servlet 3.0 webapp xsd's <servlet> tags contain <multipart-config> tags. Or just that StandardServletMultipartResolver is supported after Servlet 3.0