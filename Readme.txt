Technologies used:
NetBeans 8.2
JEE 7
Glassfishserver 4.1.1
Wamp Server 3.1.9

V1:

	- All .jsp and .sql are in "WEB-INF"
	- No Java in .jsp
	- Unique Servlet "Controller" that is the unique entry point
	- 2 classes: db.java (for requests on data base), Employee.java to get informations
	- We use Java DB
	- For the Data Base: Name: JEEDB, User: jee, Password: jee
	- Comments are in the code to understand what we have done

V2 (Maven Project):

	- All .jsp are in "WEB-INF"
	- No Java in .jsp
	- Unique Servlet "Controller" that is the unique entry point and that controls barely all the website by redirecting the users to pages
	- Session Bean "EmployeeSB" that have all the functions "AddAnEmployee, ModifyAnEmployee, DeleteAnEmployee..."
	- Entity class from Data Base "Employees"
	- Use of Wamp Server to create (thanks to PhPMyAdmin) a Data Base
	- Fop the DataBase: Name: jeedb, User: root, Password: *none* (there is no password, please let it blank)



WHAT WAS ASKED FOR (works for V1 AND V2):

	- Login page, where only admin an employee can access OK
	- Login page handles error of login such as bad entry, and both field must be filled OK
	- Admin can see the list of employees and DELETE, MODIFY, ADD an employee OK
	- Employee can only see the list of employees OK
	- 2 categories of users: admin and employee OK
	- ADD button to add an employee OK
	- Modify button to modify an employee OK
	- Delete button to delete an employee OK
	- When there is no employee -> "The company has no employee!"
	- Session (in header) logout OK
	- GoodBye page OK






When you download the project, make sure that you have all the technologies installed, and for v2 wamp server started.
First of all you should connect to the data base before running the project here are the steps:

V1:
	1) Click on "Services"
	2) Right click on Databases
	3) Click on New Connection
	4) Select Java DB (Embedded) and click on Next
	5) You must only fill the JDBC ULR with: jdbc:derby://localhost:1527/JEEDB
	6) Click on Finish
	7) Then right click on the file (file name: URL that you just entered) that just appeared in your "Databases folder" and right click
	8) Click on Connect
	9) Run project :)

V2:
	1)
