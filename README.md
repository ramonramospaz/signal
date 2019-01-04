# signal
Signal Monitor System

For this proyect i wanted to simulate a remote distributed system. CORBA was used as the remote object interface framework. Then i used PHP as a server side script that would send the signals to an AJAX enabled web site. To test this project you would need to a web server (i recommend Apache) and a CORBA server as well. The frontend is web site that resides within the folder Modulo_Html_Ajax.

Steps to execute the task:
1) Verify that you have a WEB server (apache2) with the active PHP module and java sdk installed.
2) Unzip what is in the projectDredes ZIP file.
3) Place the html and php files that are in the folders MODULO_PHP and MODULO_HTML_AJAX in the root folder of the web server. In my case the route is / var / www. Both files must be in the same folder.
4) Open 3 consoles and execute the commands in the following order:
   1. Execute the command found in the file "preparar_servidor"
   2. Execute the command found in the file "activar_servidor"
   3. Execute the command found in the file "activar_cliente"
5) Open a WEB browser and place the address where the web files are placed. In my case as it was the root address I just had to place LOCALHOST.
